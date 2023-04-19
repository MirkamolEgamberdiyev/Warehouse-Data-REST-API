package com.example.warehouse.service;

import com.example.warehouse.entity.Input;
import com.example.warehouse.entity.InputProduct;
import com.example.warehouse.entity.Product;
import com.example.warehouse.payload.InputProductDto;
import com.example.warehouse.repository.InputProductRepository;
import com.example.warehouse.repository.InputRepository;
import com.example.warehouse.repository.ProductRepository;
import com.example.warehouse.responce.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputProductService {
    @Autowired
    InputProductRepository inputProductRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InputRepository inputRepository;


    public Result addInputProduct(InputProductDto inputProductDto) {
        InputProduct inputProduct = new InputProduct();
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setExpireDate(inputProductDto.getExpireDate());

        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProduct_id());
        if (!optionalProduct.isPresent())
            return new Result("Bunday product mavjud emas", false);

        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInput_id());
        if (!optionalInput.isPresent())
            return new Result("Bunday input mavjud emas", false);

        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setInput(optionalInput.get());

        InputProduct save = inputProductRepository.save(inputProduct);

        return new Result("Input product saqlandi", true, save);

    }

    public Result getOneInputProduct(Integer id) {
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (!optionalInputProduct.isPresent())
            return new Result("Bunday inputProduct mavjud emas", false);

        InputProduct inputProduct = optionalInputProduct.get();
        return new Result("Input product", true, inputProduct);

    }

    public Result getAllInputProduct() {
        List<InputProduct> inputProducts = inputProductRepository.findAll();
        return new Result("Input Product list", true, inputProducts);
    }

    public Result updateInputProduct(Integer id, InputProductDto inputProductDto){
        Optional<InputProduct> optionalInputProduct = inputProductRepository.findById(id);
        if (!optionalInputProduct.isPresent())
            return new Result("Bunday InputProduct mavjud emas", false);

        InputProduct inputProduct = optionalInputProduct.get();
        inputProduct.setAmount(inputProductDto.getAmount());
        inputProduct.setPrice(inputProductDto.getPrice());
        inputProduct.setExpireDate(inputProductDto.getExpireDate());

        Optional<Product> optionalProduct = productRepository.findById(inputProductDto.getProduct_id());
        if (!optionalProduct.isPresent())
            return new Result("Bunday product mavjud emas", false);

        Optional<Input> optionalInput = inputRepository.findById(inputProductDto.getInput_id());
        if (!optionalInput.isPresent())
            return new Result("Bunday input mavjud emas", false);

        inputProduct.setProduct(optionalProduct.get());
        inputProduct.setInput(optionalInput.get());

        InputProduct save = inputProductRepository.save(inputProduct);

        return new Result("Input product saqlandi", true, save);

    }

    public Result deleteInputProduct(Integer id){
        inputProductRepository.deleteById(id);
        return new Result("deleted inputProduct", true);
    }

}
