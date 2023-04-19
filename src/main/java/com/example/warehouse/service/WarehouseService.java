package com.example.warehouse.service;

import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.repository.WarehouseRepository;
import com.example.warehouse.responce.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addWarehouse(Warehouse warehouse) {
        boolean exists = warehouseRepository.existsByName(warehouse.getName());
        if (exists) return new Result("Bunday o'lchov birligi mavjud", false);
        Warehouse save = warehouseRepository.save(warehouse);
        return new Result("saved warehouse", true, save);
    }

    public Result updateWarehouse(Integer id, Warehouse warehouse) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday warehouse mavjud emas", false);
        Warehouse warehouse1 = optionalWarehouse.get();
        warehouse1.setActive(warehouse.getActive());
        warehouse1.setName(warehouse.getName());
        Warehouse save = warehouseRepository.save(warehouse1);
        return new Result("updated warehouse", true, save);
    }

    public Result getOneWarehouse(Integer id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday warehouse mavjud emas", false);

        Warehouse warehouse = optionalWarehouse.get();
        return new Result("Warehouse topildi", true, warehouse);
    }

    public Result getAllWarehouse() {
        List<Warehouse> warehouseList = warehouseRepository.findAll();
        return new Result("Warehosue list topildi", true, warehouseList);
    }

    public Result deleteWarehouse(Integer id) {
        warehouseRepository.deleteById(id);
        return new Result("deleted warehouse", true);
    }

}
