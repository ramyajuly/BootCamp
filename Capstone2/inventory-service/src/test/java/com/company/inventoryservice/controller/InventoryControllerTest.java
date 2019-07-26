package com.company.inventoryservice.controller;

import com.company.inventoryservice.dao.InventoryDao;
import com.company.inventoryservice.model.Inventory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = InventoryController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    InventoryDao inventoryDao;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void inventoryGetRoute() throws Exception {
        Inventory inventory = new Inventory(1,1,6);
        when(inventoryDao.getInventory(1)).thenReturn(inventory);

        this.mockMvc.perform(get("/inventory/{inventoryId}",1).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.quantity",is(6)));
    }

    @Test
    public void inventoryPostRoute() throws Exception {
        Inventory actualInventory = new Inventory(1,6);
        Inventory expectedInventory= new Inventory(1,1,6);

        doReturn(expectedInventory).when(inventoryDao).addInventory(actualInventory);

        String actualContent = objectMapper.writeValueAsString(actualInventory);

        this.mockMvc.perform(post("/inventory").content(actualContent)
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isCreated()).andExpect(content().json(objectMapper.writeValueAsString(expectedInventory)));
    }

    @Test
    public void inventoryPutRoute() throws Exception {
        Inventory inventory = new Inventory(1,1,6);
        when(inventoryDao.getInventory(inventory.getInventoryId())).thenReturn(inventory);
        doNothing().when(inventoryDao).updateInventory(inventory);

        this.mockMvc.perform(put("/inventory/{inventoryId}",inventory.getInventoryId()).content(asJsonString(inventory))
                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void inventoryDeleteRoute() throws Exception {
        Inventory inventory = new Inventory(1,1,6);
            when(inventoryDao.getInventory(inventory.getInventoryId())).thenReturn(inventory);
        doNothing().when(inventoryDao).deleteInventory(inventory.getInventoryId());
        this.mockMvc.perform(delete("/inventory/{inventoryId}",inventory.getInventoryId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inventory))).andExpect(status().isNoContent());
    }

    @Test
    public void inventoryGetAllRoute() throws Exception {
        List<Inventory> inventoryList = Arrays.asList(new Inventory(1,1,6),
                new Inventory(2,2,10));
        when(inventoryDao.getAllInventory()).thenReturn(inventoryList);


        this.mockMvc.perform(get("/inventory"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].inventoryId", is(1)));


    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
