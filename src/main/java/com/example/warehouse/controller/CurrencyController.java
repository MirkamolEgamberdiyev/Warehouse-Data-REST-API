package com.example.warehouse.controller;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.responce.Result;
import com.example.warehouse.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;
    @PostMapping("/addCurrency")
    public Result addCurrency(@RequestBody Currency currency){
        return currencyService.addCurrency(currency);
    }

    @GetMapping("/getOneCurrency/{id}")
    public Result getOneCurrency(@PathVariable Integer id){
        return currencyService.getOneCurrency(id);
    }

    @GetMapping("/getAllCurrency")
    public Result getAllCurrency(){
        return currencyService.getAllCurrency();
    }

    @PutMapping("/updateCurrency/{id}")
    public Result updateCurrency(@PathVariable Integer id, @RequestBody Currency currency){
        return currencyService.updateCurrency(id, currency);
    }

    @DeleteMapping("/deleteCurrency/{id}")
    public Result deleteCurrency(@PathVariable Integer id){
        return currencyService.deleteCurrency(id);
    }

}
