package org.bge.ccportal.dao;

import java.util.List;
import org.bge.ccportal.model.Allocation;

public interface AllocationDao {

    //Create
    public void insert(Allocation allocation);

    //Retrieve
    public Allocation findByProduct(String product);

    public List<Allocation> getAll();

    //Update
    public void update(Allocation allocation);

    //Delete
    public void delete(String product);

}
