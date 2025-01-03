package com.flow.eda.lean.service;



import com.flow.eda.lean.pojo.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface WarehouseService {
    List<Warehouse> getAllWarehouses();
    Warehouse getWarehouseById(Integer id);
}