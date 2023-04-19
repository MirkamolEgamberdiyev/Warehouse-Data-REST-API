package com.example.warehouse.payload;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class InputDto {

    private Timestamp date;
    private String factureNumber;
    private String code;
    private Integer warehouse_id;
    private Integer currency_id;
    private Integer supplier_id;
}
