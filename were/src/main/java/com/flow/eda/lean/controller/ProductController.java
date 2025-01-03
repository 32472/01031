package com.flow.eda.lean.controller;

import com.flow.eda.lean.pojo.Product;
import com.flow.eda.lean.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // 获取指定仓库的商品
    @GetMapping("/{warehouseId}/products")
    public ResponseEntity<List<Product>> getProductsByWarehouseId(@PathVariable Integer warehouseId) {
        try {
            List<Product> products = productService.getProductsByWarehouseId(warehouseId);
            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 查询所有商品
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts(); // 调用 Service 层获取所有商品
            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 没有商品时返回 404
            }
            return ResponseEntity.ok(products); // 返回商品列表
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // 服务器错误
        }
    }

    // 添加新商品
    @PostMapping("add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        try {
            int result = productService.addProduct(product);
            if (result > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add product");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while adding product");
        }
    }

    // 删除商品
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        try {
            boolean isDeleted = productService.deleteProduct(id);
            if (isDeleted) {
                return ResponseEntity.ok("Product successfully deleted");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while deleting product");
        }
    }

    // 转移商品到另一个仓库
    @PutMapping("/transfer/{id}")
    public ResponseEntity<String> transferProductToWarehouse(
            @PathVariable Integer id, @RequestParam Integer newWarehouseId) {
        try {
            boolean isTransferred = productService.transferProductToWarehouse(id, newWarehouseId);
            if (isTransferred) {
                return ResponseEntity.ok("Product successfully transferred to warehouse " + newWarehouseId);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to transfer product");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while transferring product");
        }
    }
}