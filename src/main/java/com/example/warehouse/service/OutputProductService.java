package com.example.warehouse.service;

import com.example.warehouse.entity.*;
import com.example.warehouse.payload.OutputProductDto;
import com.example.warehouse.repository.OutputProductRepository;
import com.example.warehouse.repository.OutputRepository;
import com.example.warehouse.repository.ProductRepository;
import com.example.warehouse.responce.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutputProductService {
    @Autowired
    OutputProductRepository outputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OutputRepository outputRepository;


    public Result addOutputProduct(OutputProductDto outputProductDto) {
        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProduct.getPrice());


        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProduct_id());
        if (!optionalProduct.isPresent())
            return new Result("Bunday product mavjud emas", false);

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutput_id());
        if (!optionalOutput.isPresent())
            return new Result("Bunday output mavjud emas", false);

        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setOutput(optionalOutput.get());

        OutputProduct save = outputProductRepository.save(outputProduct);
        return new Result("Input product saqlandi", true, save);

    }

    public Result getOneOutputProduct(Integer id) {
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (!optionalOutputProduct.isPresent())
            return new Result("Bunday outputProduct mavjud emas", false);

        OutputProduct outputProduct = optionalOutputProduct.get();
        return new Result("Input product", true, outputProduct);

    }

    public Result getAllOutputProduct() {
        List<OutputProduct> outputProducts = outputProductRepository.findAll();
        return new Result("Output Product list", true, outputProducts);
    }

    public Result updateOutputProduct(Integer id, OutputProductDto outputProductDto) {
        Optional<OutputProduct> optionalOutputProduct = outputProductRepository.findById(id);
        if (!optionalOutputProduct.isPresent())
            return new Result("Bunday InputProduct mavjud emas", false);

        OutputProduct outputProduct = optionalOutputProduct.get();

        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());

        Optional<Product> optionalProduct = productRepository.findById(outputProductDto.getProduct_id());
        if (!optionalProduct.isPresent())
            return new Result("Bunday product mavjud emas", false);

        Optional<Output> optionalOutput = outputRepository.findById(outputProductDto.getOutput_id());
        if (!optionalOutput.isPresent())
            return new Result("Bunday input mavjud emas", false);

        outputProduct.setProduct(optionalProduct.get());
        outputProduct.setOutput(optionalOutput.get());

        OutputProduct save = outputProductRepository.save(outputProduct);

        return new Result("output product saqlandi", true, save);

    }

    public Result deleteOutputProduct(Integer id) {
        outputProductRepository.deleteById(id);
        return new Result("deleted OutputProduct", true);
    }

}
