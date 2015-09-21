package org.bge.ccportal.services;

import java.util.List;
import org.bge.ccportal.dao.AllocationDao;
import org.bge.ccportal.model.Allocation;
import org.springframework.beans.factory.annotation.Autowired;

public class AllocationServiceImpl implements AllocationService {

    @Autowired
    AllocationDao allocationDao;

    @Override
    public void insertData(Allocation allocation) {
        allocationDao.insert(allocation);
    }

    @Override
    public List<Allocation> getList() {
        return allocationDao.getAll();
    }

    @Override
    public Allocation getByProduct(String product) {
        return allocationDao.findByProduct(product);
    }

    @Override
    public void update(Allocation allocation) {
        allocationDao.update(allocation);
    }

    @Override
    public void delete(String product) {
        allocationDao.delete(product);
    }

}
