package com.example.warehouse.controller;

import com.example.warehouse.payload.InputProductDto;
import com.example.warehouse.responce.Result;
import com.example.warehouse.service.InputProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inputProduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;

    @PostMapping("/addInputProduct")
    public Result addInputProduct(@RequestBody InputProductDto inputProductDto){
        return inputProductService.addInputProduct(inputProductDto);
    }

    @GetMapping("/getOneInputProduct/{id}")
    public Result getOneInputProduct(@PathVariable Integer id){
        return inputProductService.getOneInputProduct(id);
    }
    @GetMapping("/getAllInputProduct")
    public Result getAllInputProduct(){
        return inputProductService.getAllInputProduct();
    }

    @PutMapping("/updateInputProduct/{id}")
    public Result updateInputProduct(@PathVariable Integer id, @RequestBody InputProductDto inputProductDto){
        return inputProductService.updateInputProduct(id, inputProductDto);
    }

    @DeleteMapping("/deleteInputProduct/{id}")
    public Result deleteInputProduct(@PathVariable Integer id){
        return inputProductService.deleteInputProduct(id);
    }

}
