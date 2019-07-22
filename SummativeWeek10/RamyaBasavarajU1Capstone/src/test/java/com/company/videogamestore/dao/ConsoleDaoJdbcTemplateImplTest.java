package com.company.videogamestore.dao;

import com.company.videogamestore.model.Console;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import static junit.framework.TestCase.*;

/**
 * Integration testing with Database
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoJdbcTemplateImplTest {
    @Autowired
    ConsoleDao consoleDao;

    /**
     * To delete all the records of console in database
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        List<Console> consoleList = consoleDao.getAllConsole();
        for (Console console : consoleList) {
            consoleDao.deleteConsole(console.getConsoleId());
        }
    }

    /**
     * To test for adding a new Console, to get a console and to delete a console
     */
    @Test
    public void addGetDeleteConsole() {
        Console actualConsole = new Console();
        actualConsole.setModel("PlayStation");
        actualConsole.setManufacturer("Sony");
        actualConsole.setMemoryAmount("2MB");
        actualConsole.setProcessor("SPC-700");
        actualConsole.setPrice(new BigDecimal("399.00"));
        actualConsole.setQuantity(1);
        actualConsole = consoleDao.addConsole(actualConsole);
        Console expectedConsole = consoleDao.getConsole(actualConsole.getConsoleId());
        assertEquals(expectedConsole, actualConsole);
        int deleted = consoleDao.deleteConsole(actualConsole.getConsoleId());
        assertEquals(1, deleted);
    }

    /**
     * To get all Consoles
     */
    @Test
    public void getAllConsoles() {
        List<Console> actualConsoleLst = new ArrayList<>();
        Console actualConsole = new Console();
        actualConsole.setModel("PlayStation");
        actualConsole.setManufacturer("Sony");
        actualConsole.setMemoryAmount("2MB");
        actualConsole.setProcessor("SPC-700");
        actualConsole.setPrice(new BigDecimal("399.00"));
        actualConsole.setQuantity(1);
        consoleDao.addConsole(actualConsole);

        actualConsole = new Console();
        actualConsole.setModel("Xbox");
        actualConsole.setManufacturer("Microsoft");
        actualConsole.setMemoryAmount("64MB");
        actualConsole.setProcessor("Intel Pentium");
        actualConsole.setPrice(new BigDecimal("300.00"));
        actualConsole.setQuantity(1);
        consoleDao.addConsole(actualConsole);
        actualConsoleLst = consoleDao.getAllConsole();
        assertEquals(2, actualConsoleLst.size());

    }

    /**
     * To update a console
     */
    @Test
    public void updateConsole(){
        Console actualConsole = new Console();
        actualConsole.setModel("PlayStation");
        actualConsole.setManufacturer("Sony");
        actualConsole.setMemoryAmount("2MB");
        actualConsole.setProcessor("SPC-700");
        actualConsole.setPrice(new BigDecimal("399.00"));
        actualConsole.setQuantity(1);
        actualConsole = consoleDao.addConsole(actualConsole);

        actualConsole.setModel("Xbox");
        actualConsole.setManufacturer("Microsoft");
        actualConsole.setMemoryAmount("64MB");
        actualConsole.setProcessor("Intel Pentium");
        actualConsole.setPrice(new BigDecimal("300.00"));
        actualConsole.setQuantity(1);

        Console expectedConsole = consoleDao.updateConsole(actualConsole);
        assertEquals(expectedConsole, actualConsole);

    }

    /**
     * To filter consoles based on manufacture
     *
     */
    @Test
    public void getConsolesByManufacturer(){
        List<Console> actualConsoleLst = new ArrayList<>();

        Console actualConsole = new Console();
        actualConsole.setModel("PlayStation");
        actualConsole.setManufacturer("Sony");
        actualConsole.setMemoryAmount("2MB");
        actualConsole.setProcessor("SPC-700");
        actualConsole.setPrice(new BigDecimal("399.00"));
        actualConsole.setQuantity(1);
        actualConsole = consoleDao.addConsole(actualConsole);
        actualConsoleLst.add(actualConsole);

        actualConsole = new Console();
        actualConsole.setModel("Xbox");
        actualConsole.setManufacturer("Sony");
        actualConsole.setMemoryAmount("64MB");
        actualConsole.setProcessor("Intel Pentium");
        actualConsole.setPrice(new BigDecimal("300.00"));
        actualConsole.setQuantity(1);
        actualConsole = consoleDao.addConsole(actualConsole);
        actualConsoleLst.add(actualConsole);

        actualConsoleLst = consoleDao.getConsolesByManufacturer("Sony");
        assertEquals(2,actualConsoleLst.size());

    }

}
