package com.example.warehouse.service;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.entity.Input;
import com.example.warehouse.entity.Supplier;
import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.payload.InputDto;
import com.example.warehouse.repository.CurrencyRepository;
import com.example.warehouse.repository.InputRepository;
import com.example.warehouse.repository.SupplierRepository;
import com.example.warehouse.repository.WarehouseRepository;
import com.example.warehouse.responce.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;

    public Result addInput(InputDto inputDto) {
        Input input = new Input();
        input.setCode(inputDto.getCode());
        input.setDate(inputDto.getDate());
        input.setFactureNumber(inputDto.getFactureNumber());

        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrency_id());
        if (!optionalCurrency.isPresent())
            return new Result("Bunday currency mavjud emas", false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouse_id());
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday warehouse mavjud emas", false);


        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplier_id());
        if (!optionalSupplier.isPresent())
            return new Result("Bunday supplier mavjud emas", false);

        input.setSupplier(optionalSupplier.get());
        input.setCurrency(optionalCurrency.get());
        input.setWarehouse(optionalWarehouse.get());

        Input save = inputRepository.save(input);

        return new Result("added input ", true, save);

    }

    public Result getOneInput(Integer id) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (!optionalInput.isPresent())
            return new Result("Bunday input mavjud emas", false);

        Input input = optionalInput.get();
        return new Result("Input topildi", true, input);
    }

    public Result getAllInput() {
        List<Input> inputs = inputRepository.findAll();
        return new Result("Inputs list", true, inputs);
    }

    public Result updateInput(Integer id, InputDto inputDto) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (!optionalInput.isPresent())
            return new Result("Bunday input mavjud emas", false);

        Input input = optionalInput.get();
        input.setCode(inputDto.getCode());
        input.setDate(inputDto.getDate());
        input.setFactureNumber(inputDto.getFactureNumber());

        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrency_id());
        if (!optionalCurrency.isPresent())
            return new Result("Bunday currency mavjud emas", false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarehouse_id());
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday warehouse mavjud emas", false);


        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplier_id());
        if (!optionalSupplier.isPresent())
            return new Result("Bunday supplier mavjud emas", false);

        input.setSupplier(optionalSupplier.get());
        input.setCurrency(optionalCurrency.get());
        input.setWarehouse(optionalWarehouse.get());

        Input save = inputRepository.save(input);

        return new Result("added input ", true, save);
    }

    public Result deleteInput(Integer id) {
        inputRepository.deleteById(id);
        return new Result("deleted input", true);
    }
}
