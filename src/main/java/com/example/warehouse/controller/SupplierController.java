package com.example.warehouse.controller;

import com.example.warehouse.entity.Supplier;
import com.example.warehouse.responce.Result;
import com.example.warehouse.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping("/addSupplier")
    public Result addSupplier(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }
    @PutMapping("/updateSupplier/{id}")
    public Result updateSupplier(@PathVariable Integer id, @RequestBody Supplier supplier){
        return supplierService.updateSupplier(id, supplier);
    }
    @GetMapping("/getOneSupplier/{id}")
    public Result getOneSupplier(@PathVariable Integer id){
        return supplierService.getOneSupplier(id);
    }

    @GetMapping("/getAllSupplier")
    public Result getAllSupplier(){
        return supplierService.getAllSupplier();
    }

    @DeleteMapping("/deleteSupplier/{id}")
    public Result deleteSupplier(@PathVariable Integer id){
        return supplierService.deleteSupplier(id);
    }


}
