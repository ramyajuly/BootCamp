package com.company.videogamestore.service;

import com.company.videogamestore.dao.ConsoleDao;
import com.company.videogamestore.model.Console;
import com.company.videogamestore.viewmodel.ConsoleViewModel;
import org.junit.*;

import static junit.framework.TestCase.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Unit test for Console Service using mock
 */
public class ConsoleInventoryServiceTest {
    ConsoleInventoryService consoleService;
    ConsoleDao consoleDao;


    /**
     * TO set up before running tests
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        consoleService = new ConsoleInventoryService(consoleDao);
    }

    /**
     * To test adding a new Console
     */
    @Test
    public void addConsole() {
        ConsoleViewModel actualConsole = new ConsoleViewModel();
        actualConsole.setModel("PlayStation");
        actualConsole.setManufacturer("Sony");
        actualConsole.setMemoryAmount("2MB");
        actualConsole.setProcessor("SPC-700");
        actualConsole.setPrice(new BigDecimal("399.00"));
        actualConsole.setQuantity(1);
        actualConsole = consoleService.addConsole(actualConsole);
        ConsoleViewModel expectedConsole =  consoleService.getConsole(actualConsole.getConsoleId());
        assertEquals(expectedConsole, actualConsole);
    }

    /**
     * Test to get all consoles
     */
    @Test
    public void getAllConsole() {
        List<ConsoleViewModel> expectedConsoleLst = new ArrayList<>();
        ConsoleViewModel actualConsole = new ConsoleViewModel();
        actualConsole.setConsoleId(6);
        actualConsole.setModel("PlayStation");
        actualConsole.setManufacturer("Sony");
        actualConsole.setMemoryAmount("2MB");
        actualConsole.setProcessor("SPC-700");
        actualConsole.setPrice(new BigDecimal("399.00"));
        actualConsole.setQuantity(1);
        expectedConsoleLst.add(actualConsole);

        actualConsole = new ConsoleViewModel();
        actualConsole.setConsoleId(9);
        actualConsole.setModel("Xbox");
        actualConsole.setManufacturer("Microsoft");
        actualConsole.setMemoryAmount("64MB");
        actualConsole.setProcessor("Intel Pentium");
        actualConsole.setPrice(new BigDecimal("300.00"));
        actualConsole.setQuantity(1);
        expectedConsoleLst.add(actualConsole);

        List<ConsoleViewModel> actualConsoleLst = consoleService.getAllConsole();
        assertEquals(expectedConsoleLst.size(),actualConsoleLst.size());
    }

    /**
     * Test to get a Console
     */
    @Test
    public void getConsole() {
        ConsoleViewModel expectedConsole = new ConsoleViewModel();
        expectedConsole.setConsoleId(6);
        expectedConsole.setModel("PlayStation");
        expectedConsole.setManufacturer("Sony");
        expectedConsole.setMemoryAmount("2MB");
        expectedConsole.setProcessor("SPC-700");
        expectedConsole.setPrice(new BigDecimal("399.00"));
        expectedConsole.setQuantity(1);
        ConsoleViewModel actualConsole = consoleService.getConsole(6);
        assertEquals(expectedConsole, actualConsole);
    }

    /**
     * To update a Console
     *
     * */
    @Test
    public void updateConsole() {
        ConsoleViewModel actualConsole = new ConsoleViewModel();
        actualConsole.setConsoleId(9);
        actualConsole.setModel("Xbox One");
        actualConsole.setManufacturer("Microsoft");
        actualConsole.setMemoryAmount("500GB");
        actualConsole.setProcessor("Intel Pentium");
        actualConsole.setPrice(new BigDecimal("499.00"));
        actualConsole.setQuantity(1);

        actualConsole = consoleService.updateConsole(actualConsole);

        ConsoleViewModel expectedConsole = new ConsoleViewModel();
        expectedConsole.setConsoleId(9);
        expectedConsole.setModel("Xbox One");
        expectedConsole.setManufacturer("Microsoft");
        expectedConsole.setMemoryAmount("500GB");
        expectedConsole.setProcessor("Intel Pentium");
        expectedConsole.setPrice(new BigDecimal("499.00"));
        expectedConsole.setQuantity(1);
        assertEquals(expectedConsole, actualConsole);
    }

    /**
     * To delete a Console
     */
    @Test
    public void deleteConsole() {
        int deleted = consoleService.deleteConsole(9);
        assertEquals(1, deleted);
    }

    /**
     * To get all tests by manufacturer
     */
    @Test
    public void getConsolesByManufacturer() {
        List<ConsoleViewModel> actualConsoleManufacturerLst = new ArrayList<>();
        List<ConsoleViewModel> expectedConsoleManufacturerLst = new ArrayList<>();

        ConsoleViewModel console = new ConsoleViewModel();
        console.setConsoleId(6);
        console.setModel("PlayStation");
        console.setManufacturer("Sony");
        console.setMemoryAmount("2MB");
        console.setProcessor("SPC-700");
        console.setPrice(new BigDecimal("399.00"));
        console.setQuantity(1);
        expectedConsoleManufacturerLst.add(console);

        actualConsoleManufacturerLst = consoleService.getConsolesByManufacturer("Sony");
        assertEquals(expectedConsoleManufacturerLst.size(),actualConsoleManufacturerLst.size());
    }

    /**
     * Helper Method
     */
    public void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDao.class);
        List<Console> lstConsole = new ArrayList<>();
        List<Console> lstConsoleByManufacturer = new ArrayList<>();

        //---- CONSOLE To BE SAVED
        Console consoleToBeSaved = new Console();
        consoleToBeSaved.setModel("PlayStation");
        consoleToBeSaved.setManufacturer("Sony");
        consoleToBeSaved.setMemoryAmount("2MB");
        consoleToBeSaved.setProcessor("SPC-700");
        consoleToBeSaved.setPrice(new BigDecimal("399.00"));
        consoleToBeSaved.setQuantity(1);

        //---- CONSOLE AFTER SAVE
        Console consoleAfterSave = new Console();
        consoleAfterSave.setConsoleId(6);
        consoleAfterSave.setModel("PlayStation");
        consoleAfterSave.setManufacturer("Sony");
        consoleAfterSave.setMemoryAmount("2MB");
        consoleAfterSave.setProcessor("SPC-700");
        consoleAfterSave.setPrice(new BigDecimal("399.00"));
        consoleAfterSave.setQuantity(1);

        //--CONSOLES TO BE ADDED TO LIST
        Console consoleAfterSave1 = new Console();
        consoleAfterSave1.setConsoleId(9);
        consoleAfterSave1.setModel("Xbox");
        consoleAfterSave1.setManufacturer("Microsoft");
        consoleAfterSave1.setMemoryAmount("64MB");
        consoleAfterSave1.setProcessor("Intel Pentium");
        consoleAfterSave1.setPrice(new BigDecimal("300.00"));
        consoleAfterSave1.setQuantity(1);

        //---CONSOLE AFTER UPDATE
        Console consoleUpdated = new Console();
        consoleUpdated.setConsoleId(9);
        consoleUpdated.setModel("Xbox One");
        consoleUpdated.setManufacturer("Microsoft");
        consoleUpdated.setMemoryAmount("500GB");
        consoleUpdated.setProcessor("Intel Pentium");
        consoleUpdated.setPrice(new BigDecimal("499.00"));
        consoleUpdated.setQuantity(1);

        //---CONSOLES ADDED TO LIST
        lstConsole.add(consoleAfterSave);
        lstConsole.add(consoleAfterSave1);

        //CONSOLES ADDED TO LIST AFTER FILTER ON MANUFACTURE
        lstConsoleByManufacturer.add(consoleAfterSave);

        doReturn(consoleAfterSave).when(consoleDao).addConsole(consoleToBeSaved);
        doReturn(consoleAfterSave).when(consoleDao).getConsole(6);
        doReturn(lstConsole).when(consoleDao).getAllConsole();
        doReturn(consoleUpdated).when(consoleDao).updateConsole(consoleUpdated);
        doReturn(1).when(consoleDao).deleteConsole(9);
        doReturn(lstConsoleByManufacturer).when(consoleDao).getConsolesByManufacturer("Sony");
    }
}
