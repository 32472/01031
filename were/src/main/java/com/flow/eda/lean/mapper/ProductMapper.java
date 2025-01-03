package com.flow.eda.lean.mapper;

import com.flow.eda.lean.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM products WHERE warehouse_id = #{warehouseId} AND is_deleted = false")
    List<Product> selectByWarehouseId(@Param("warehouseId") Integer warehouseId);

    @Insert("INSERT INTO products (name, supplier, warehouse_id, is_deleted) VALUES (#{name}, #{supplier}, #{warehouseId}, false)")
    int insertProduct(Product product);

    @Update("UPDATE products SET is_deleted = true WHERE id = #{productId}")
    int deleteProduct(@Param("productId") Long productId);

    @Update("UPDATE products SET warehouse_id = #{newWarehouseId} WHERE id = #{productId}")
    int transferProductToWarehouse(@Param("productId") Integer productId, @Param("newWarehouseId") Integer newWarehouseId);

    // 新增查询所有商品的方法
    @Select("SELECT * FROM products WHERE is_deleted = false")
    List<Product> selectAllProducts(); // 查询所有商品，不包含已删除的商品
}