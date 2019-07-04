package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    /**
     * Constructor
     * @param service
     */
    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    /**
     *
     * @param task
     * @return
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public TaskViewModel addTask(@RequestBody @Valid TaskViewModel task) {
        return service.newTask(task);
    }

    /***
     * To delete a task using task id
     * @param id
     */

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

    /**
     * To get a task
     * @param taskId
     */
    @GetMapping("/{taskId}")
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel getTask(@PathVariable("taskId")  int taskId){
        TaskViewModel taskViewModel = service.fetchTask(taskId);
        if(taskViewModel == null){
            throw new NotFoundException("Task could not be retrieved for id " + taskId);
        }
        return taskViewModel;
    }

    /**
     * To get a task
     * @param category
     */
    @GetMapping("/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getTaskBtCategory(@PathVariable("category")  String category){
        List<TaskViewModel> taskViewModel = service.fetchTasksByCategory(category);
        return taskViewModel;
    }


    /**
     * To get all Tasks
     * @return
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasks() {
        return service.fetchAllTasks();

    }

    /**
     * To update a Task
     * @param taskId
     * @param taskViewModel
     */
    @PutMapping("/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@PathVariable("taskId") int taskId, @RequestBody @Valid TaskViewModel taskViewModel) {
        if (taskViewModel.getId() == 0)
            taskViewModel.setId(taskId);
        if (taskId != taskViewModel.getId()) {
            throw new IllegalArgumentException("Task ID on path must match the ID in the Console object");
        }
        service.updateTask(taskViewModel);
    }
}
