package com.flow.eda.lean.service.serviceimpl;

import com.flow.eda.lean.mapper.WarehouseMapper;
import com.flow.eda.lean.pojo.Warehouse;
import com.flow.eda.lean.service.WarehouseService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Resource
    private WarehouseMapper warehouseMapper;

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseMapper.selectAll();
    }

    @Override
    public Warehouse getWarehouseById(Integer id) {
        return warehouseMapper.selectById(id);
    }
}