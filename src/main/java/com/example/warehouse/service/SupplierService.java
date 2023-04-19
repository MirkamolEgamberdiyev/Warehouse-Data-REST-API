package com.example.warehouse.service;

import com.example.warehouse.entity.Supplier;
import com.example.warehouse.repository.SupplierRepository;
import com.example.warehouse.responce.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public Result addSupplier(Supplier supplier) {
        boolean exists = supplierRepository.existsByName(supplier.getName());
        if (exists) return new Result("Bunday o'lchov birligi mavjud", false);
        Supplier save = supplierRepository.save(supplier);
        return new Result("supplier saqlandi", true, save);
    }

    public Result updateSupplier(Integer id, Supplier supplier) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent())
            return new Result("Bunday supplier topilmadi", false);

        Supplier supplier1 = optionalSupplier.get();
        supplier1.setName(supplier.getName());
        supplier1.setActive(supplier.getActive());
        supplier1.setPhoneNumber(supplier.getPhoneNumber());

        Supplier save = supplierRepository.save(supplier1);
        return new Result("supplier saqlandi", true, save);
    }

    public Result getOneSupplier(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent())
            return new Result("Bunday supplier topilmadi", false);
        Supplier supplier = optionalSupplier.get();
        return new Result("supplier topildi", true, supplier);
    }
    public Result getAllSupplier(){
        List<Supplier> suppliers = supplierRepository.findAll();
        return new Result("supplier listi topildi", true, suppliers);
    }
    public Result deleteSupplier(Integer id){
        supplierRepository.deleteById(id);
        return new Result("deleted supplier", true);
    }

}
