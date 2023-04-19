package com.example.warehouse.payload;

import lombok.Data;

import java.util.Date;

@Data
public class InputProductDto {

    private Double amount;

    private Double price;

    private Date expireDate;

    private Integer product_id;

    private Integer input_id;
}
