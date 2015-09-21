package org.bge.ccportal.services;

import java.util.List;
import org.bge.ccportal.model.GlobalFlag;

public interface GlobalFlagService {
	public void insertData(GlobalFlag globalFlag);

	public List<GlobalFlag> getList();

	public void delete(int id);

	public GlobalFlag getById(int id);

	public void update(GlobalFlag globalFlag);
}
