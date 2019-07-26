package com.company.inventoryservice.controller;

import com.company.inventoryservice.dao.InventoryDao;
import com.company.inventoryservice.exception.NotFoundException;
import com.company.inventoryservice.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/inventory")
@CacheConfig(cacheNames = {"inventorycache"})
public class InventoryController {
    @Autowired
    InventoryDao inventoryDao;

    public InventoryController(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @CachePut(key = "#result.getInventoryId()")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryDao.addInventory(inventory);
    }

    @Cacheable
    @GetMapping("/{inventoryId}")
    @ResponseStatus(HttpStatus.OK)
    public Inventory getInventory(@PathVariable("inventoryId") int inventoryId) {
       Inventory inventory =  inventoryDao.getInventory(inventoryId);
        if(inventory == null){
            throw new NotFoundException("Inventory could not be retrieved for id " + inventoryId);
        }
        return inventory;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Inventory> getAllInventory() {
        return inventoryDao.getAllInventory();
    }


    @CacheEvict(key = "#inventory.getInventoryId()")
    @PutMapping("/{inventoryId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateInventory(@PathVariable("inventoryId") int inventoryId, @RequestBody Inventory inventory) {
        inventory.setInventoryId(inventoryId);
        if(inventory.getInventoryId() ==0){
            inventory.setInventoryId(inventoryId);
        }
        if(inventoryId != inventory.getInventoryId()){
            throw new IllegalArgumentException("Inventory ID on path must match the ID on the inventory object");
        }
        inventoryDao.updateInventory(inventory);
    }

    @CacheEvict
    @DeleteMapping("/{inventoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInventory(@PathVariable("inventoryId") int inventoryId) {
        inventoryDao.deleteInventory(inventoryId);
    }

}
