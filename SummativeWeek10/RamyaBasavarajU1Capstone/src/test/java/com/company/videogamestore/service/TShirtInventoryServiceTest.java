package com.company.videogamestore.service;

import com.company.videogamestore.dao.TShirtDao;

import com.company.videogamestore.model.TShirt;
import com.company.videogamestore.viewmodel.TShirtViewModel;
import org.junit.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;
/**
 * Unit test for TShirt Service using mock
 */
public class TShirtInventoryServiceTest {

    TShirtInventoryService tShirtInventoryService;
    TShirtDao tShirtDao;

    /**
     * TO set up before running tests
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        setUpTShirtDaoMock();
        tShirtInventoryService = new TShirtInventoryService(tShirtDao);
    }

    /**
     * Test to add a new TShirt
     */
    @Test
    public void addTshirt() {
        TShirtViewModel actualTShirt = new TShirtViewModel();
        actualTShirt.setSize("small");
        actualTShirt.setColor("yellow");
        actualTShirt.setDescription("Small yellow T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);
        actualTShirt = tShirtInventoryService.addTShirt(actualTShirt);
        TShirtViewModel expectedTShirt = tShirtInventoryService.getTShirt(actualTShirt.gettShirtId());
        assertEquals(expectedTShirt, actualTShirt);
    }

    /**
     * Test to get all TShirts
     */
    @Test
    public void getAllTshirt() {
        List<TShirtViewModel> actualTShirtLst = tShirtInventoryService.getAllTShirt();
        assertEquals(2, actualTShirtLst.size());
    }

    /**
     * Test to get a TShirt
     */
    @Test
    public void getTshirt() {
        TShirtViewModel expectedTShirt = new TShirtViewModel();
        expectedTShirt.settShirtId(6);
        expectedTShirt.setSize("small");
        expectedTShirt.setColor("yellow");
        expectedTShirt.setDescription("Small yellow T-shirt");
        expectedTShirt.setPrice(new BigDecimal("15.00"));
        expectedTShirt.setQuantity(1);
        TShirtViewModel actualTShirt = tShirtInventoryService.getTShirt(6);
        assertEquals(expectedTShirt, actualTShirt);
    }

    /**
     * Test to update a TShirt
     */
    @Test
    public void updateTshirt() {
        TShirtViewModel actualTShirt = new TShirtViewModel();
        actualTShirt.settShirtId(6);
        actualTShirt.setSize("small");
        actualTShirt.setColor("yellow");
        actualTShirt.setDescription("Small yellow T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);
        actualTShirt = tShirtInventoryService.updateTShirt(actualTShirt);

        TShirtViewModel expectedTShirt = new TShirtViewModel();
        expectedTShirt.settShirtId(6);
        expectedTShirt.setSize("small");
        expectedTShirt.setColor("yellow");
        expectedTShirt.setDescription("Small yellow T-shirt");
        expectedTShirt.setPrice(new BigDecimal("15.00"));
        expectedTShirt.setQuantity(1);

        assertEquals(expectedTShirt, actualTShirt);
    }

    /**
     * Test to delete a TShirt
     */
    @Test
    public void deleteTshirt() {
        int deleted = tShirtInventoryService.deleteTShirt(6);
        assertEquals(1, deleted);
    }

    /**
     * Test to get TShirt by color
     */
    @Test
    public void getTshirtByColor() {
        List<TShirtViewModel> actualTShirtLst = new ArrayList<>();
        TShirtViewModel actualTShirt = new TShirtViewModel();
        actualTShirt.setSize("small");
        actualTShirt.setColor("yellow");
        actualTShirt.setDescription("Small yellow T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);
        actualTShirt = tShirtInventoryService.addTShirt(actualTShirt);

        actualTShirt = new TShirtViewModel();
        actualTShirt.setSize("small");
        actualTShirt.setColor("yellow");
        actualTShirt.setDescription("Small yellow T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);
        actualTShirt = tShirtInventoryService.addTShirt(actualTShirt);


        actualTShirtLst = tShirtInventoryService.getTShirtsByColor("yellow");
        assertEquals(2, actualTShirtLst.size());
    }

    /**
     * Test to get TShirt by size
     */
    @Test
    public void getTshirtBySize() {
        List<TShirtViewModel> actualTShirtLst = new ArrayList<>();
        TShirtViewModel actualTShirt = new TShirtViewModel();
        actualTShirt.setSize("small");
        actualTShirt.setColor("yellow");
        actualTShirt.setDescription("Small yellow T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);
        actualTShirt = tShirtInventoryService.addTShirt(actualTShirt);

        actualTShirt = new TShirtViewModel();
        actualTShirt.setSize("small");
        actualTShirt.setColor("yellow");
        actualTShirt.setDescription("Small yellow T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);
        actualTShirt = tShirtInventoryService.addTShirt(actualTShirt);


        actualTShirtLst = tShirtInventoryService.getTShirtsBySize("small");
        assertEquals(2, actualTShirtLst.size());
    }


    /**
     * Helper Method
     */
    public void setUpTShirtDaoMock() {
        tShirtDao = mock(TShirtDao.class);
        TShirt tShirt = new TShirt();
        tShirt.setSize("small");
        tShirt.setColor("yellow");
        tShirt.setDescription("Small yellow T-shirt");
        tShirt.setPrice(new BigDecimal("15.00"));
        tShirt.setQuantity(1);

        TShirt tShirtSaved = new TShirt();
        tShirtSaved.settShirtId(6);
        tShirtSaved.setSize("small");
        tShirtSaved.setColor("yellow");
        tShirtSaved.setDescription("Small yellow T-shirt");
        tShirtSaved.setPrice(new BigDecimal("15.00"));
        tShirtSaved.setQuantity(1);

        TShirt tShirtSaved1 = new TShirt();
        tShirtSaved1.settShirtId(9);
        tShirtSaved1.setSize("small");
        tShirtSaved1.setColor("yellow");
        tShirtSaved1.setDescription("Small yellow T-shirt");
        tShirtSaved1.setPrice(new BigDecimal("15.00"));
        tShirtSaved1.setQuantity(1);

        //To get All TShirts
        List<TShirt> lstTShirt = new ArrayList<>();
        lstTShirt.add(tShirtSaved);
        lstTShirt.add(tShirtSaved1);

        //To get TShirt List by color
        List<TShirt> lstTShirtByColor = new ArrayList<>();
        lstTShirtByColor.add(tShirtSaved);
        lstTShirtByColor.add(tShirtSaved);

        //To get TShirt List by size
        List<TShirt> lstTShirtBySize = new ArrayList<>();
        lstTShirtBySize.add(tShirtSaved);
        lstTShirtBySize.add(tShirtSaved);

        doReturn(tShirtSaved).when(tShirtDao).addTShirt(tShirt);
        doReturn(tShirtSaved).when(tShirtDao).getTShirt(6);
        doReturn(lstTShirt).when(tShirtDao).getAllTShirt();
        doReturn(tShirtSaved).when(tShirtDao).updateTShirt(tShirtSaved);
        doReturn(1).when(tShirtDao).deleteTShirt(6);
        doReturn(lstTShirtByColor).when(tShirtDao).getTShirtsByColor("yellow");
        doReturn(lstTShirtBySize).when(tShirtDao).getTShirtsBySize("small");


    }
}
