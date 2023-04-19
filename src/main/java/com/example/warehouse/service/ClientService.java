package com.example.warehouse.service;

import com.example.warehouse.entity.Client;
import com.example.warehouse.repository.ClientRepository;
import com.example.warehouse.responce.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;


    public Result addClient(Client client) {
        boolean exists = clientRepository.existsByName(client.getName());
        if (exists) return new Result("Bunday o'lchov birligi mavjud", false);
        Client save = clientRepository.save(client);
        return new Result("client qo'shildi", true, save);
    }

    public Result getOneClient(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent())
            return new Result("Bunday client mavjud emas", false);
        Client client = optionalClient.get();
        return new Result("Client topildi", true, client);
    }

    public Result getAllClient() {
        List<Client> clientList = clientRepository.findAll();
        return new Result("Clientlar listi topildi", true, clientList);
    }

    public Result updateClient(Integer id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent())
            return new Result("Bunday client mavjud emas", false);

        Client client1 = optionalClient.get();
        client1.setName(client.getName());
        client1.setActive(client.getActive());
        client1.setPhoneNumber(client.getPhoneNumber());
        Client save = clientRepository.save(client1);
        return new Result("client o'zgartirildi", true, save);
    }

    public Result deleteClient(Integer id){
        clientRepository.deleteById(id);
        return new Result("deleted client", true);
    }

}
