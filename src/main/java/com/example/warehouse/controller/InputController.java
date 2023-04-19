package com.example.warehouse.controller;

import com.example.warehouse.payload.InputDto;
import com.example.warehouse.responce.Result;
import com.example.warehouse.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputService inputService;

    @PostMapping("/addInput")
    public Result addInput(@RequestBody InputDto inputDto){
        return inputService.addInput(inputDto);
    }
    @GetMapping("/getOneInput/{id}")
    public Result getOneInput(@PathVariable Integer id){
        return inputService.getOneInput(id);
    }
    @GetMapping("/getAllInput")
    public Result getAllInput(){
        return inputService.getAllInput();
    }

    @PutMapping("/updateInput/{id}")
    public Result updateInput(@PathVariable Integer id, @RequestBody InputDto inputDto){
        return inputService.updateInput(id, inputDto);
    }
    @DeleteMapping("/deleteInput/{id}")
    public Result deleteInput(@PathVariable Integer id){
        return inputService.deleteInput(id);
    }


}
