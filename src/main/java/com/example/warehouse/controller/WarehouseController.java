package com.example.warehouse.controller;

import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.responce.Result;
import com.example.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/addWarehouse")
    public Result addWarehouse(@RequestBody Warehouse warehouse){
        return warehouseService.addWarehouse(warehouse);
    }
    @PutMapping("/updateWarehouse/{id}")
    public Result updateWarehouse(@PathVariable Integer id, @RequestBody Warehouse warehouse){
        return warehouseService.updateWarehouse(id, warehouse);
    }

    @GetMapping("/getOneWarehouse/{id}")
    public Result getOneWarehouse(@PathVariable Integer id){
        return warehouseService.getOneWarehouse(id);
    }
    @GetMapping("/getAllWarehouse")
    public Result getAllWarehouse(){
        return warehouseService.getAllWarehouse();
    }

    @DeleteMapping("/deleteWarehouse/{id}")
    public Result deleteWarehouse(@PathVariable Integer id){
        return warehouseService.deleteWarehouse(id);
    }
}
