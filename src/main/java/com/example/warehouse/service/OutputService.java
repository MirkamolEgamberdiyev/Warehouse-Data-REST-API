package com.example.warehouse.service;
import com.example.warehouse.entity.Client;
import com.example.warehouse.entity.Currency;
import com.example.warehouse.entity.Output;
import com.example.warehouse.entity.Warehouse;
import com.example.warehouse.payload.OutputDto;
import com.example.warehouse.repository.ClientRepository;
import com.example.warehouse.repository.CurrencyRepository;
import com.example.warehouse.repository.OutputRepository;
import com.example.warehouse.repository.WarehouseRepository;
import com.example.warehouse.responce.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    ClientRepository clientRepository;

    public Result addOutput(OutputDto outputDto) {
        Output output = new Output();
        output.setCode(outputDto.getCode());
        output.setDate(outputDto.getDate());
        output.setFactureNumber(outputDto.getFactureNumber());

        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrency_id());
        if (!optionalCurrency.isPresent())
            return new Result("Bunday currency mavjud emas", false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouse_id());
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday warehouse mavjud emas", false);

        Optional<Client> clientOptional = clientRepository.findById(outputDto.getClient_id());
        if (!clientOptional.isPresent())
            return new Result("Bunday client mavjud emas", false);

        output.setClient(clientOptional.get());
        output.setCurrency(optionalCurrency.get());
        output.setWarehouse(optionalWarehouse.get());

        Output save = outputRepository.save(output);
        return new Result("Output saqlandi", true, save);
    }

    public Result updateOutput(Integer id, OutputDto outputDto) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (!optionalOutput.isPresent())
            return new Result("Bunday output mavjud emas", false);

        Output output = optionalOutput.get();
        output.setCode(outputDto.getCode());
        output.setDate(outputDto.getDate());
        output.setFactureNumber(outputDto.getFactureNumber());

        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrency_id());
        if (!optionalCurrency.isPresent())
            return new Result("Bunday currency mavjud emas", false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarehouse_id());
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday warehouse mavjud emas", false);

        Optional<Client> clientOptional = clientRepository.findById(outputDto.getClient_id());
        if (!clientOptional.isPresent())
            return new Result("Bunday client mavjud emas", false);

        output.setClient(clientOptional.get());
        output.setCurrency(optionalCurrency.get());
        output.setWarehouse(optionalWarehouse.get());

        Output save = outputRepository.save(output);
        return new Result("Output saqlandi", true, save);
    }

    public Result getOneOutPut(Integer id) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (!optionalOutput.isPresent())
            return new Result("Bunday output mavjud emas", false);
        Output output = optionalOutput.get();
        return new Result("output topildi", true, output);
    }

    public Result getAllOutput() {
        List<Output> outputList = outputRepository.findAll();
        return new Result("Output list topildi", true, outputList);
    }

    public Result deleteOutput(Integer id) {
        outputRepository.deleteById(id);
        return new Result("deleted output", true);
    }

}
