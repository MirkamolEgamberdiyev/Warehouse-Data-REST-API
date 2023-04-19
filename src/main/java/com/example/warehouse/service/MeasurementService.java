package com.example.warehouse.service;

import com.example.warehouse.entity.Measurement;
import com.example.warehouse.repository.MeasurementRepository;
import com.example.warehouse.responce.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    public Result addMeasurementService(Measurement measurement) {
        boolean exists = measurementRepository.existsByName(measurement.getName());
        if (exists) return new Result("Bunday o'lchov birligi mavjud", false);
        measurementRepository.save(measurement);
        return new Result("saqlandi", true);
    }

    public Result getOneMeasurement(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent())
            return new Result("Bunday measurement mavjud emas", false);
        Measurement measurement = optionalMeasurement.get();
        return new Result("Measurement", true, measurement);
    }

    public Result getAllMeasurements() {
        List<Measurement> measurements = measurementRepository.findAll();
        return new Result("measurement list", true, measurements);
    }

    public Result updateMeasurement(Integer id, Measurement measurement) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent())
            return new Result("Bunday measurement mavjud emas", false);

        Measurement measurement1 = optionalMeasurement.get();
        measurement1.setActive(measurement.getActive());
        measurement1.setName(measurement.getName());
        measurementRepository.save(measurement1);
        return new Result("saqlandi", true);
    }

    public Result deleteMeasurement(Integer id) {
        measurementRepository.deleteById(id);
        return new Result("deleted measurement", true);
    }
}
