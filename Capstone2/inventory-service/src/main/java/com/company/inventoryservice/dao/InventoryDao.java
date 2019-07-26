package com.company.inventoryservice.dao;

import com.company.inventoryservice.model.Inventory;

import java.util.List;

public interface InventoryDao {

    Inventory addInventory(Inventory inventory);

    Inventory getInventory(int inventoryId);

    void deleteInventory(int inventoryId);

    void updateInventory(Inventory inventory);

    List<Inventory> getAllInventory();

    List<Inventory> getInventoryByProductId(int productId);


}
