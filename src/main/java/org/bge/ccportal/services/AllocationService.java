package org.bge.ccportal.services;

import java.util.List;
import org.bge.ccportal.model.Allocation;

public interface AllocationService {
	public void insertData(Allocation allocation);

	public List<Allocation> getList();

	public void delete(String product);

	public Allocation getByProduct(String product);

	public void update(Allocation allocation);
}
