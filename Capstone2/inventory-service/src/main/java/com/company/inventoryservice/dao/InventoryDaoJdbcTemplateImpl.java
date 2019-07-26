package com.company.inventoryservice.dao;

import com.company.inventoryservice.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InventoryDaoJdbcTemplateImpl implements InventoryDao {

    //prepared statements
    private static final String INSERT_INVENTORY_SQL = "INSERT INTO inventory ( product_id, quantity) VALUES (?,?)";
    private static final String SELECT_INVENTORY_SQL = "SELECT * FROM inventory WHERE inventory_id=?";
    private static final String UPDATE_INVENTORY_SQL = "UPDATE inventory SET product_id=?, quantity=? WHERE inventory_id=?";
    private static final String DELETE_INVENTORY_SQL = "DELETE FROM inventory WHERE inventory_id=?";
    private static final String SELECT_INVENTORY_BY_PRODUCT_ID_SQL = "SELECT * FROM inventory WHERE product_id=?";
    private static final String SELECT_ALL_INVENTORY_SQL = "SELECT * FROM inventory";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public InventoryDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    @Override
    public Inventory addInventory(Inventory inventory) {
        jdbcTemplate.update(INSERT_INVENTORY_SQL,inventory.getProductId(),inventory.getQuantity());
        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        inventory.setInventoryId(id);
        return inventory;
    }

    @Override
    public Inventory getInventory(int inventoryId) {
        try{
        return jdbcTemplate.queryForObject(SELECT_INVENTORY_SQL,this::mapRowToInventory, inventoryId);}
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void deleteInventory(int inventoryId) {
        jdbcTemplate.update(DELETE_INVENTORY_SQL,inventoryId);

    }

    @Override
    public void updateInventory(Inventory inventory) {
        jdbcTemplate.update(UPDATE_INVENTORY_SQL,inventory.getProductId(),inventory.getQuantity(),inventory.getInventoryId());
    }

    @Override
    public List<Inventory> getAllInventory() {
        return jdbcTemplate.query(SELECT_ALL_INVENTORY_SQL,this::mapRowToInventory);
    }

    @Override
    public List<Inventory> getInventoryByProductId(int productId) {
        return jdbcTemplate.query(SELECT_INVENTORY_BY_PRODUCT_ID_SQL,this::mapRowToInventory,productId);
    }

    private Inventory mapRowToInventory(ResultSet rs, int row) throws SQLException {
        Inventory inventory = new Inventory();
        inventory.setInventoryId(rs.getInt("inventory_id"));
        inventory.setProductId(rs.getInt("product_id"));
        inventory.setQuantity(rs.getInt("quantity"));
        return  inventory;
    }
}
