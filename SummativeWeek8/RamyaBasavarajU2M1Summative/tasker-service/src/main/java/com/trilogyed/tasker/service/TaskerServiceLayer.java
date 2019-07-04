package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.exception.FeignClientException;
import com.trilogyed.tasker.feignClient.Adserver;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {
    @Autowired
    TaskerDao dao;

    @Autowired
    Adserver adserver;

    /**
     * Constructor
     *
     * @param dao
     */
    public TaskerServiceLayer(TaskerDao dao, Adserver adserver) {
        this.dao = dao;
        this.adserver = adserver;
    }


    public TaskViewModel fetchTask(int id) {
        try {
            Task task = dao.getTask(id);
            TaskViewModel tvm = new TaskViewModel();
            tvm.setId(task.getId());
            tvm.setDescription(task.getDescription());
            tvm.setCreateDate(task.getCreateDate());
            tvm.setDueDate(task.getDueDate());
            tvm.setCategory(task.getCategory());
            try {
                String advertisement = adserver.getAd();
                tvm.setAdvertisement(advertisement);
            } catch (RuntimeException ex) {
                throw new FeignClientException(ex.getMessage());
            }
            return tvm;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * To fetch all the Tasks and add to Type List of TaskViewModel
     *
     * @return List<TaskViewModel>
     */
    public List<TaskViewModel> fetchAllTasks() {
        List<TaskViewModel> taskViewModelList = new ArrayList<>();
        TaskViewModel taskViewModel;
        List<Task> taskList = dao.getAllTasks();
        for (Task task : taskList) {
            taskViewModel = new TaskViewModel();
            taskViewModel.setId(task.getId());
            taskViewModel.setDescription(task.getDescription());
            taskViewModel.setCreateDate(task.getCreateDate());
            taskViewModel.setDueDate(task.getDueDate());
            taskViewModel.setCategory(task.getCategory());
            try {
                taskViewModel.setAdvertisement(adserver.getAd());
            } catch (RuntimeException ex) {
                throw new FeignClientException(ex.getMessage());
            }
            taskViewModelList.add(taskViewModel);
        }
        return taskViewModelList;
    }

    /**
     * To fetch Tasks by Categoty
     *
     * @param category
     * @return List<TaskViewModel>
     */
    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<TaskViewModel> taskViewModelList = new ArrayList<>();
        TaskViewModel taskViewModel;
        List<Task> taskList = dao.getTasksByCategory(category);
        for (Task task : taskList) {
            taskViewModel = new TaskViewModel();
            taskViewModel.setId(task.getId());
            taskViewModel.setDescription(task.getDescription());
            taskViewModel.setCreateDate(task.getCreateDate());
            taskViewModel.setDueDate(task.getDueDate());
            taskViewModel.setCategory(task.getCategory());
            try {
                taskViewModel.setAdvertisement(adserver.getAd());
            } catch (RuntimeException ex) {
                throw new FeignClientException(ex.getMessage());
            }
            taskViewModelList.add(taskViewModel);
        }
        return taskViewModelList;
    }


    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        task = dao.createTask(task);
        taskViewModel.setId(task.getId());
        try {
            String advertisement = adserver.getAd();
            taskViewModel.setAdvertisement(advertisement);
        } catch (RuntimeException ex) {
            throw new FeignClientException(ex.getMessage());
        }
        return taskViewModel;

    }

    /**
     * To delete a Task
     *
     * @param id
     */
    public void deleteTask(int id) {

        dao.deleteTask(id);
    }

    /**
     * To update a Task
     *
     * @param taskViewModel
     */
    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        task.setId(taskViewModel.getId());
        dao.updateTask(task);
    }
}
