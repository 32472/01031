package com.flow.eda.lean.pojo;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String name;
    private String supplier;
    private Integer warehouseId;
    private Boolean isDeleted = false;
}