package com.example.warehouse.service;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.repository.CurrencyRepository;
import com.example.warehouse.responce.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addCurrency(Currency currency) {
        boolean exists = currencyRepository.existsByName(currency.getName());
        if (exists) return new Result("Bunday o'lchov birligi mavjud", false);
        Currency save = currencyRepository.save(currency);
        return new Result("currency saqlandi", true, save);
    }

    public Result getOneCurrency(Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent())
            return new Result("Bunday currency mavjud emas", false);

        Currency currency = optionalCurrency.get();
        return new Result("Currency topildi", true, currency);
    }

    public Result getAllCurrency() {
        List<Currency> currencyList = currencyRepository.findAll();
        return new Result("Currency list topildi", true, currencyList);
    }

    public Result updateCurrency(Integer id, Currency currency) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent())
            return new Result("Bunday currency mavjud emas", false);
        Currency currency1 = optionalCurrency.get();
        currency1.setName(currency.getName());
        currency1.setActive(currency.getActive());
        Currency save = currencyRepository.save(currency1);
        return new Result("Currency list topildi", true, save);
    }

    public Result deleteCurrency(Integer id) {
        currencyRepository.deleteById(id);
        return new Result("Deleted currency", true);
    }
}
