package com.example.warehouse.payload;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class OutputDto {

    private Date date;
    private String factureNumber;
    private String code;
    private Integer warehouse_id;
    private Integer currency_id;
    private Integer client_id;
}
