package com.example.warehouse.controller;

import com.example.warehouse.entity.Measurement;
import com.example.warehouse.responce.Result;
import com.example.warehouse.service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;

    @PostMapping("/addMeasurement")
    public Result addMeasurementController(@RequestBody Measurement measurement) {
        Result result = measurementService.addMeasurementService(measurement);
        return result;
    }


    @GetMapping("/getOneMeasurement/{id}")
    public Result getOneMeasurement(@PathVariable Integer id) {
        return measurementService.getOneMeasurement(id);
    }

    @GetMapping("/getAllMeasurements")
    public Result getAllMeasurements() {
        return measurementService.getAllMeasurements();
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteMeasurement(@PathVariable Integer id) {
        return measurementService.deleteMeasurement(id);
    }

    @PutMapping("/updateMeasurement/{id}")
    public Result updateMeasurement(@PathVariable Integer id, Measurement measurement) {
        return measurementService.updateMeasurement(id, measurement);
    }
}
