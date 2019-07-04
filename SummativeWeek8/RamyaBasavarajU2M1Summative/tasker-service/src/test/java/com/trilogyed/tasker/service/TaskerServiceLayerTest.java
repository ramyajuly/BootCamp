package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.feignClient.Adserver;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.junit.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;
import static junit.framework.TestCase.*;

public class TaskerServiceLayerTest {
    TaskerServiceLayer taskerServiceLayer;
    TaskerDao taskerDao;
    Adserver adserver;

    @Before
    public void setUp() {
        setTaskerDao();
        taskerServiceLayer = new TaskerServiceLayer(taskerDao, adserver);
    }

    @Test
    public void fetchTask() {
        //Assemble
        TaskViewModel taskViewModelExpected = new TaskViewModel();
        taskViewModelExpected.setId(1);
        taskViewModelExpected.setAdvertisement("Super Sale on summer clothes!");
        taskViewModelExpected.setCategory("Task Category");
        taskViewModelExpected.setCreateDate(LocalDate.of(2018, 06, 06));
        taskViewModelExpected.setDescription("Task Description");
        taskViewModelExpected.setDueDate(LocalDate.of(2019, 06, 06));
        //Act
        TaskViewModel taskViewmodelActual = taskerServiceLayer.fetchTask(1);
        //Assert
        assertEquals(taskViewModelExpected, taskViewmodelActual);
    }

    @Test
    public void fetchAllTasks() {
        //Act
        List<TaskViewModel> lstTaskVewModel = taskerServiceLayer.fetchAllTasks();
        //Assert
        assertEquals(3, lstTaskVewModel.size());

    }

    @Test
    public void fetchTasksByCategory() {
        //Act
        List<TaskViewModel> lstTaskVewModel = taskerServiceLayer.fetchTasksByCategory("Task Category");
        //Assert
        assertEquals(2, lstTaskVewModel.size());
    }

    @Test
    public void newTask() {
        //Assemble
        TaskViewModel taskViewModelToSave = new TaskViewModel();
        taskViewModelToSave.setCategory("Task Category");
        taskViewModelToSave.setCreateDate(LocalDate.of(2018, 06, 06));
        taskViewModelToSave.setDescription("Task Description");
        taskViewModelToSave.setDueDate(LocalDate.of(2019, 06, 06));
        //Act
        TaskViewModel taskViewmodelActual = taskerServiceLayer.newTask(taskViewModelToSave);
        TaskViewModel taskViewmodelExpected = taskerServiceLayer.fetchTask(taskViewmodelActual.getId());
        //Assert
        assertEquals(taskViewmodelExpected, taskViewmodelActual);
    }

    @Test
    public void deleteTask() {
        //Act
        taskerServiceLayer.deleteTask(2);
        //Assert
        assertEquals(null, taskerServiceLayer.fetchTask(2));
    }

    @Test
    public void updateTask() {
        //Assemble
        TaskViewModel taskViewModelToUpdate = new TaskViewModel();
        taskViewModelToUpdate.setId(1);
        taskViewModelToUpdate.setAdvertisement("Super Sale on summer clothes!");
        taskViewModelToUpdate.setCategory("Task Category");
        taskViewModelToUpdate.setCreateDate(LocalDate.of(2018, 06, 06));
        taskViewModelToUpdate.setDescription("Task Description");
        taskViewModelToUpdate.setDueDate(LocalDate.of(2019, 06, 06));
        //Act
        taskerServiceLayer.updateTask(taskViewModelToUpdate);
        TaskViewModel taskViewmodelExpected = taskerServiceLayer.fetchTask(taskViewModelToUpdate.getId());
        //Assert
        assertEquals(taskViewmodelExpected, taskViewModelToUpdate);

    }


    //Helper Methods
    public void setTaskerDao() {
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);
        adserver = mock(Adserver.class);
        List<Task> lstTask = new ArrayList<>();
        Task taskToSave;
        Task taskAfterSave1;
        Task taskAfterSave2;
        Task taskAfterSave3;

        taskToSave = new Task();
        taskToSave.setDescription("Task Description");
        taskToSave.setCreateDate(LocalDate.of(2018, 06, 06));
        taskToSave.setDueDate(LocalDate.of(2019, 06, 06));
        taskToSave.setCategory("Task Category");

        taskAfterSave1 = new Task();
        taskAfterSave1.setId(1);
        taskAfterSave1.setDescription("Task Description");
        taskAfterSave1.setCreateDate(LocalDate.of(2018, 06, 06));
        taskAfterSave1.setDueDate(LocalDate.of(2019, 06, 06));
        taskAfterSave1.setCategory("Task Category");
        lstTask.add(taskAfterSave1);

        taskAfterSave2 = new Task();
        taskAfterSave2.setId(2);
        taskAfterSave2.setDescription("Task Description");
        taskAfterSave2.setCreateDate(LocalDate.of(2018, 06, 06));
        taskAfterSave2.setDueDate(LocalDate.of(2019, 06, 06));
        taskAfterSave2.setCategory("Task Category");
        lstTask.add(taskAfterSave2);

        taskAfterSave3 = new Task();
        taskAfterSave3.setId(3);
        taskAfterSave3.setDescription("Task Description");
        taskAfterSave3.setCreateDate(LocalDate.of(2018, 06, 06));
        taskAfterSave3.setDueDate(LocalDate.of(2019, 06, 06));
        taskAfterSave3.setCategory("Task Category-New");
        lstTask.add(taskAfterSave3);

        List<Task> lstTaskCategory = lstTask.stream().filter(task -> task.getCategory().equals("Task Category")).collect(Collectors.toList());

        doReturn(taskAfterSave1).when(taskerDao).createTask(taskToSave);
        doReturn(taskAfterSave1).when(taskerDao).getTask(1);
        doReturn(null).when(taskerDao).getTask(2);
        doReturn(lstTask).when(taskerDao).getAllTasks();
        doReturn(lstTaskCategory).when(taskerDao).getTasksByCategory("Task Category");
        doReturn("Super Sale on summer clothes!").when(adserver).getAd();
        doNothing().when(taskerDao).deleteTask(2);

    }
}
