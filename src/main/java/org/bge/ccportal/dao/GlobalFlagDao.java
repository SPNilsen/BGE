package org.bge.ccportal.dao;

import java.util.List;
import org.bge.ccportal.model.GlobalFlag;

public interface GlobalFlagDao {

    //Create
    public void insert(GlobalFlag globalFlag);

    //Retrieve
    public GlobalFlag findById(int id);

    public List<GlobalFlag> getAll();

    //Update
    public void update(GlobalFlag globalFlag);

    //Delete
    public void delete(int id);

}
