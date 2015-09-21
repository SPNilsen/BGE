package org.bge.ccportal.services;

import java.util.List;
import org.bge.ccportal.dao.GlobalFlagDao;
import org.bge.ccportal.model.GlobalFlag;
import org.springframework.beans.factory.annotation.Autowired;

public class GlobalFlagServiceImpl implements GlobalFlagService {

    @Autowired
    GlobalFlagDao globalFlagDao;

    @Override
    public void insertData(GlobalFlag globalFlag) {
        globalFlagDao.insert(globalFlag);
    }

    @Override
    public List<GlobalFlag> getList() {
        return globalFlagDao.getAll();
    }

    @Override
    public GlobalFlag getById(int id) {
        return globalFlagDao.findById(id);
    }

    @Override
    public void update(GlobalFlag globalFlag) {
        globalFlagDao.update(globalFlag);
    }

    @Override
    public void delete(int id) {
        globalFlagDao.delete(id);
    }

}
