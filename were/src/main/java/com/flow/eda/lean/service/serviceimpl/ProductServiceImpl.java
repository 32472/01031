package com.flow.eda.lean.service.serviceimpl;

import com.flow.eda.lean.mapper.ProductMapper;
import com.flow.eda.lean.pojo.Product;
import com.flow.eda.lean.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductsByWarehouseId(Integer warehouseId) {
        return productMapper.selectByWarehouseId(warehouseId);
    }

    @Override
    public int addProduct(Product product) {
        // 检查 supplier 是否为 null 或空，若是则设置默认值
        if (product.getSupplier() == null || product.getSupplier().isEmpty()) {
            product.setSupplier("Default Supplier"); // 设置默认供应商
        }

        // 调用 Mapper 层的方法插入产品
        return productMapper.insertProduct(product);
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return productMapper.deleteProduct(productId) > 0;
    }

    @Override
    public boolean transferProductToWarehouse(Integer productId, Integer newWarehouseId) {
        return productMapper.transferProductToWarehouse(productId, newWarehouseId) > 0;
    }

    // 实现查询所有商品的方法
    @Override
    public List<Product> getAllProducts() {
        return productMapper.selectAllProducts(); // 调用 Mapper 层获取所有商品
    }
}