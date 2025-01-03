package com.flow.eda.lean.mapper;

import com.flow.eda.lean.pojo.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface WarehouseMapper {

    @Select("SELECT * FROM warehouses")
    List<Warehouse> selectAll();

    @Select("SELECT * FROM warehouses WHERE id = #{id}")
    Warehouse selectById(@Param("id") Integer id);
}
