package com.company.inventoryservice.dao;

import com.company.inventoryservice.model.Inventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class InventoryDaoJdbcTemplateImplTest {
    @Autowired
    InventoryDao inventoryDao;

    @Before
    public void setUp() {
        List<Inventory> inventoryList = inventoryDao.getAllInventory();
        for (Inventory inventory : inventoryList) {
            inventoryDao.deleteInventory(inventory.getInventoryId());
        }
    }

    @Test
    public void getAddDeleteInventory() {
        Inventory actualInventory = new Inventory(1, 6);
        inventoryDao.addInventory(actualInventory);
        Inventory expectInventory = new Inventory(actualInventory.getInventoryId(), 1, 6);
        Assert.assertEquals(expectInventory, actualInventory);
        inventoryDao.deleteInventory(actualInventory.getInventoryId());
        Assert.assertNull(inventoryDao.getInventory(actualInventory.getInventoryId()));
    }

    @Test
    public void updateInventory() {
        Inventory actualInventory = new Inventory(1, 6);
        inventoryDao.addInventory(actualInventory);

        actualInventory.setQuantity(10);
        actualInventory.setProductId(2);
        inventoryDao.updateInventory(actualInventory);

        Inventory expectInventory = inventoryDao.getInventory(actualInventory.getInventoryId());
        Assert.assertEquals(expectInventory, actualInventory);
    }


    @Test
    public void getInventoryByProductId() {
        List<Inventory> actualInventoryList = new ArrayList<>();
        inventoryDao.addInventory(new Inventory(1, 6));
        inventoryDao.addInventory(new Inventory(1, 10));
        inventoryDao.addInventory(new Inventory(2, 10));

        actualInventoryList=inventoryDao.getInventoryByProductId(1);
        Assert.assertEquals(2, actualInventoryList.size());
    }

     @Test
    public void getAllInventory(){
        List<Inventory> actualInventoryList = new ArrayList<>();
        actualInventoryList.add(inventoryDao.addInventory(new Inventory(1, 6)));
        actualInventoryList.add(inventoryDao.addInventory(new Inventory(1, 10)));
        Assert.assertEquals(2, actualInventoryList.size());
    }
}
