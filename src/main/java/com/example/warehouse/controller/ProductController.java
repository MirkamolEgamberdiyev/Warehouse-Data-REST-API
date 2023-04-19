package com.example.warehouse.controller;

import com.example.warehouse.payload.ProductDto;
import com.example.warehouse.responce.Result;
import com.example.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public Result addProduct(@RequestBody ProductDto productDto) {
        Result result = productService.addProduct(productDto);
        return result;
    }

    @GetMapping("/getOneProduct/{id}")
    public Result getOneProduct(@PathVariable Integer id){
        return productService.getOneProduct(id);
    }

    @GetMapping("/getAllProduct")
    public Result getAllProduct(){
        return productService.getAllProduct();
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }
    @PutMapping("/updateProduct/{id}")
    public Result updateProduct(@PathVariable Integer id, ProductDto productDto){
        return productService.updateProduct(id, productDto);
    }

}
