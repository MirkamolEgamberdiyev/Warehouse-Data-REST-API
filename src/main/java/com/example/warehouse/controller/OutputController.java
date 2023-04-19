package com.example.warehouse.controller;

import com.example.warehouse.payload.OutputDto;
import com.example.warehouse.responce.Result;
import com.example.warehouse.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;

    @PostMapping("/addOutput")
    public Result addOutput(@RequestBody OutputDto outputDto){
        return outputService.addOutput(outputDto);
    }

    @PutMapping("/updateOutput/{id}")
    public Result updateOutput(@PathVariable Integer id, @RequestBody OutputDto outputDto){
        return outputService.updateOutput(id, outputDto);
    }

    @GetMapping("/getOneOutput/{id}")
    public Result getOneOutput(@PathVariable Integer id){
        return outputService.getOneOutPut(id);
    }
    @GetMapping("/getAllOutput")
    public Result getAllOutput(){
        return outputService.getAllOutput();
    }
    @DeleteMapping("/deleteOutput/{id}")
    public Result deleteOutput(@PathVariable Integer id){
        return outputService.deleteOutput(id);
    }


}
