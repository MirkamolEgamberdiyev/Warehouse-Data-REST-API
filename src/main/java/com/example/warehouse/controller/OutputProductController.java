package com.example.warehouse.controller;
import com.example.warehouse.payload.OutputProductDto;
import com.example.warehouse.responce.Result;
import com.example.warehouse.service.OutputProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;

    @PostMapping("/addOutputProduct")
    public Result addOutputProduct(@RequestBody OutputProductDto outputProductDto) {
        return outputProductService.addOutputProduct(outputProductDto);
    }

    @GetMapping("/getOneOutputProduct/{id}")
    public Result getOneOutputProduct(@PathVariable Integer id) {
        return outputProductService.getOneOutputProduct(id);
    }

    @GetMapping("/getAllOutputProduct")
    public Result getAllOutputProduct() {
        return outputProductService.getAllOutputProduct();
    }

    @PutMapping("/updateOutputProduct/{id}")
    public Result updateOutputProduct(@PathVariable Integer id, @RequestBody OutputProductDto outputProductDto) {
        return outputProductService.updateOutputProduct(id, outputProductDto);
    }

    @DeleteMapping("/deleteOutputProduct/{id}")
    public Result deleteOutputProduct(@PathVariable Integer id) {
        return outputProductService.deleteOutputProduct(id);
    }

}
