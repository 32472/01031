package com.flow.eda.lean.service;


import com.flow.eda.lean.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    List<Product> getProductsByWarehouseId(Integer warehouseId);
    int addProduct(Product product);
    boolean deleteProduct(Long productId);
    boolean transferProductToWarehouse(Integer productId, Integer newWarehouseId);

    // 新增方法：查询所有商品
    List<Product> getAllProducts();
}