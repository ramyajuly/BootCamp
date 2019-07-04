package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {
    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp() {
        List<Task> lstTask = taskerDao.getAllTasks();
        for (Task task : lstTask) {
            taskerDao.deleteTask(task.getId());
        }
    }

    @Test
    public void addGetDeleteTask() {
        //assemble
        Task actualTask;
        actualTask = new Task();
        actualTask.setDescription("Task Description");
        actualTask.setCreateDate(LocalDate.of(2018, 06, 06));
        actualTask.setDueDate(LocalDate.of(2019, 06, 06));
        actualTask.setCategory("Task Category");
        //act
        actualTask = taskerDao.createTask(actualTask);
        Task expectedTask = taskerDao.getTask(actualTask.getId());
        taskerDao.deleteTask(actualTask.getId());
        Task actualDeletedTask = taskerDao.getTask(actualTask.getId());
        //assert
        assertEquals(expectedTask, actualTask);
        assertEquals(null, actualDeletedTask);
    }

    @Test
    public void getAllTask() {
        //assemble
        Task actualTask;

        actualTask = new Task();
        actualTask.setDescription("Task Description");
        actualTask.setCreateDate(LocalDate.of(2018, 06, 06));
        actualTask.setDueDate(LocalDate.of(2019, 06, 06));
        actualTask.setCategory("Task Category");
        actualTask = taskerDao.createTask(actualTask);

        actualTask = new Task();
        actualTask.setDescription("Task Description");
        actualTask.setCreateDate(LocalDate.of(2018, 06, 06));
        actualTask.setDueDate(LocalDate.of(2019, 06, 06));
        actualTask.setCategory("Task Category");
        actualTask = taskerDao.createTask(actualTask);

        actualTask = new Task();
        actualTask.setDescription("Task Description");
        actualTask.setCreateDate(LocalDate.of(2018, 06, 06));
        actualTask.setDueDate(LocalDate.of(2019, 06, 06));
        actualTask.setCategory("Task Category");
        actualTask = taskerDao.createTask(actualTask);

        //act
        List<Task> actualLstTask = taskerDao.getAllTasks();

        //assert
        assertEquals(3, actualLstTask.size());
    }

    @Test
    public void getTaskByCategory() {
        //assemble
        Task actualTask;

        actualTask = new Task();
        actualTask.setDescription("Task Description");
        actualTask.setCreateDate(LocalDate.of(2018, 06, 06));
        actualTask.setDueDate(LocalDate.of(2019, 06, 06));
        actualTask.setCategory("Task Category");
        actualTask = taskerDao.createTask(actualTask);

        actualTask = new Task();
        actualTask.setDescription("Task Description");
        actualTask.setCreateDate(LocalDate.of(2018, 06, 06));
        actualTask.setDueDate(LocalDate.of(2019, 06, 06));
        actualTask.setCategory("Task Category");
        actualTask = taskerDao.createTask(actualTask);

        actualTask = new Task();
        actualTask.setDescription("Task Description");
        actualTask.setCreateDate(LocalDate.of(2018, 06, 06));
        actualTask.setDueDate(LocalDate.of(2019, 06, 06));
        actualTask.setCategory("Task Category1");
        actualTask = taskerDao.createTask(actualTask);

        //act
        List<Task> actualLstTask = taskerDao.getTasksByCategory("Task Category");

        //assert
        assertEquals(2, actualLstTask.size());
    }

    @Test
    public void updateTask() {
        //assemble
        Task actualTask;
        Task expextedTask;
        expextedTask = new Task();
        expextedTask.setDescription("Task Updated");
        expextedTask.setCreateDate(LocalDate.of(2019, 06, 06));
        expextedTask.setDueDate(LocalDate.of(2020, 06, 06));
        expextedTask.setCategory("Category updated");

        actualTask = new Task();
        actualTask.setDescription("Task Description");
        actualTask.setCreateDate(LocalDate.of(2018, 06, 06));
        actualTask.setDueDate(LocalDate.of(2019, 06, 06));
        actualTask.setCategory("Task Category");
        actualTask = taskerDao.createTask(actualTask);
        expextedTask.setId(actualTask.getId());

        actualTask.setDescription("Task Updated");
        actualTask.setCreateDate(LocalDate.of(2019, 06, 06));
        actualTask.setDueDate(LocalDate.of(2020, 06, 06));
        actualTask.setCategory("Category updated");

        //act
        taskerDao.updateTask(actualTask);
        actualTask = taskerDao.getTask(actualTask.getId());
        //assert
        assertEquals(expextedTask, actualTask);
    }
}
