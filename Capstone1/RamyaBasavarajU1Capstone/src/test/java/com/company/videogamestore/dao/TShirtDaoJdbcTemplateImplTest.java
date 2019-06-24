package com.company.videogamestore.dao;


import com.company.videogamestore.model.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 *
 *  TShirt Integration testing with Database
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoJdbcTemplateImplTest {
    @Autowired
    TShirtDao tShirtDao;

    /**
     * To delete all the records of TShirts in database
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        List<TShirt> tShirtsList = tShirtDao.getAllTShirt();
        for (TShirt tShirt : tShirtsList) {
            tShirtDao.deleteTShirt(tShirt.gettShirtId());
        }
    }

    /**
     * To test for adding a new TShirt, to get a TShirt and to delete a TShirt
     */
    @Test
    public void addGetDeleteTshirt() {
        TShirt actualTShirt = new TShirt();
        actualTShirt.setSize("small");
        actualTShirt.setColor("yellow");
        actualTShirt.setDescription("Small yellow T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);

        actualTShirt = tShirtDao.addTShirt(actualTShirt);

        TShirt expectedTShirt = tShirtDao.getTShirt(actualTShirt.gettShirtId());
        assertEquals(expectedTShirt, actualTShirt);

        int deleted = tShirtDao.deleteTShirt(actualTShirt.gettShirtId());
        assertEquals(1, deleted);
    }

    /**
     * Test to get all TShirts
     */
    @Test
    public void getAllTShirts() {
        List<TShirt> actualTShirtLst = new ArrayList<>();
        TShirt tShirt1 = new TShirt();

        tShirt1.setSize("small");
        tShirt1.setColor("yellow");
        tShirt1.setDescription("Small yellow T-shirt");
        tShirt1.setPrice(new BigDecimal("15.00"));
        tShirt1.setQuantity(1);

        TShirt tShirt2 = new TShirt();

        tShirt2.setSize("small");
        tShirt2.setColor("yellow");
        tShirt2.setDescription("Small yellow T-shirt");
        tShirt2.setPrice(new BigDecimal("15.00"));
        tShirt2.setQuantity(1);
        tShirt1=  tShirtDao.addTShirt(tShirt1);
        tShirt2= tShirtDao.addTShirt(tShirt2);


        actualTShirtLst = tShirtDao.getAllTShirt();
        assertEquals(2, actualTShirtLst.size());

    }

    /**
     * Test to update a TShirt
     */
    @Test
    public void updateTShirt() {
        TShirt actualTShirt = new TShirt();
        actualTShirt.setSize("small");
        actualTShirt.setColor("yellow");
        actualTShirt.setDescription("Small yellow T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);

        actualTShirt = tShirtDao.addTShirt(actualTShirt);

        actualTShirt.setSize("Big");
        actualTShirt.setColor("red");
        actualTShirt.setDescription("big red T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);

        TShirt expectedTShirt = new TShirt();
        expectedTShirt.settShirtId(actualTShirt.gettShirtId());
        expectedTShirt.setSize("Big");
        expectedTShirt.setColor("red");
        expectedTShirt.setDescription("big red T-shirt");
        expectedTShirt.setPrice(new BigDecimal("15.00"));
        expectedTShirt.setQuantity(1);

        actualTShirt = tShirtDao.updateTShirt(actualTShirt);
        assertEquals(expectedTShirt, actualTShirt);

    }

    /**
     * Test to filter TShirt by Color
     */
    @Test
    public void getTShirtsByColor() {
        TShirt actualTShirt = new TShirt();
        actualTShirt.setSize("small");
        actualTShirt.setColor("yellow");
        actualTShirt.setDescription("Small yellow T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);
        actualTShirt = tShirtDao.addTShirt(actualTShirt);

        actualTShirt = new TShirt();
        actualTShirt.setSize("small");
        actualTShirt.setColor("yellow");
        actualTShirt.setDescription("Small yellow T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);
        actualTShirt = tShirtDao.addTShirt(actualTShirt);

        List<TShirt> actualTShirtLst = tShirtDao.getTShirtsByColor("yellow");
        assertEquals(2, actualTShirtLst.size());
    }

    /**
     * Test to filter TShirt by size
     */
    @Test
    public void getTShirtsBySize() {
        TShirt actualTShirt = new TShirt();
        actualTShirt.setSize("small");
        actualTShirt.setColor("yellow");
        actualTShirt.setDescription("Small yellow T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);
        actualTShirt = tShirtDao.addTShirt(actualTShirt);

        actualTShirt = new TShirt();
        actualTShirt.setSize("small");
        actualTShirt.setColor("yellow");
        actualTShirt.setDescription("Small yellow T-shirt");
        actualTShirt.setPrice(new BigDecimal("15.00"));
        actualTShirt.setQuantity(1);
        actualTShirt = tShirtDao.addTShirt(actualTShirt);

        List<TShirt> actualTShirtLst = tShirtDao.getTShirtsBySize("small");
        assertEquals(2, actualTShirtLst.size());
    }

}
