package com.example.warehouse.controller;

import com.example.warehouse.entity.Client;
import com.example.warehouse.responce.Result;
import com.example.warehouse.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/addClient")
    public Result addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }
    @GetMapping("/getOneClient/{id}")
    public Result getOneClient(@PathVariable Integer id){
        return clientService.getOneClient(id);
    }

    @GetMapping("/getAllClient")
    public Result getAllClient(){
        return clientService.getAllClient();
    }

    @PutMapping("/updateClient/{id}")
    public Result updateClient(@PathVariable Integer id, @RequestBody Client client){
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public Result deleteClient(@PathVariable Integer id){
        return clientService.deleteClient(id);
    }



}
