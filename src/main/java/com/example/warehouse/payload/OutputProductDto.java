package com.example.warehouse.payload;

import lombok.Data;

@Data
public class OutputProductDto {

    private Double amount;

    private Double price;

    private Integer product_id;

    private Integer output_id;
}
