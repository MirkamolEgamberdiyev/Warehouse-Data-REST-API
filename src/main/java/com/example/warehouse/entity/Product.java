package com.example.warehouse.entity;

import com.example.warehouse.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product extends AbsEntity {

    private String code;

    @ManyToOne(optional = false)
    private Category category;

    @OneToOne
    Attachment photo;

    @ManyToOne(optional = false)
    private Measurement measurement;
}
