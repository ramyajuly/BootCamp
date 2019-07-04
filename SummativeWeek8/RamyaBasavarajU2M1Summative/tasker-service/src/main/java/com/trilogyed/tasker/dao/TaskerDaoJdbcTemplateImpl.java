package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Repository class to do Create, Read, update and delete operation.
 */
@Repository
public class TaskerDaoJdbcTemplateImpl implements TaskerDao {
    /**
     * Prepared statements
     */
    public static final String INSERT_TASK =
            "insert into task (task_description, create_date, due_date, category) values (?, ?, ?, ?)";
    public static final String SELECT_TASK_BY_ID =
            "select * from task where task_id = ?";
    public static final String SELECT_ALL_TASKS =
            "select * from task";
    public static final String SELECT_TASKS_BY_CATEGORY =
            "select * from task where category = ?";
    public static final String UPDATE_TASK =
            "update task set task_description = ?, create_date = ?, due_date = ?, category = ? where task_id = ?";
    public static final String DELETE_TASK =
            "delete from task where task_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor
     *
     * @param jdbcTemplate
     */
    public TaskerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * To add a new task
     *
     * @param task
     */
    @Override
    @Transactional
    public Task createTask(Task task) {

        jdbcTemplate.update(
                INSERT_TASK, task.getDescription(), task.getCreateDate(), task.getDueDate(), task.getCategory());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        task.setId(id);
        return task;
    }

    /**
     * To get a task
     *
     * @param id
     */
    @Override
    public Task getTask(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TASK_BY_ID, this::mapRowToTask, id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    /**
     * To get all task
     */
    @Override
    public List<Task> getAllTasks() {
        return
                jdbcTemplate.query(
                        SELECT_ALL_TASKS,
                        this::mapRowToTask
                );
    }

    /**
     * To get all task by category
     *
     * @param category
     */
    @Override
    public List<Task> getTasksByCategory(String category) {
        return jdbcTemplate.query(
                SELECT_TASKS_BY_CATEGORY,
                this::mapRowToTask, category
        );
    }

    /**
     * To update a task
     *
     * @param task
     */
    @Override
    public void updateTask(Task task) {
        ////task_description, create_date, due_date, category
        jdbcTemplate.update(UPDATE_TASK,
                task.getDescription(), task.getCreateDate(), task.getDueDate(), task.getCategory(), task.getId());
    }

    /**
     * To delete a task
     *
     * @param id
     */
    @Override
    public void deleteTask(int id) {
        jdbcTemplate.update(DELETE_TASK, id);
    }

    /**
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    private Task mapRowToTask(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setId(rs.getInt("task_id"));
        task.setDueDate(rs.getDate("due_date").toLocalDate());
        task.setCreateDate(rs.getDate("create_date").toLocalDate());
        task.setCategory(rs.getString("category"));
        task.setDescription(rs.getString("task_description"));
        return task;
    }
}
