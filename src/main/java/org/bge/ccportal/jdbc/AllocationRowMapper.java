package org.bge.ccportal.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.bge.ccportal.model.Allocation;

import org.springframework.jdbc.core.RowMapper;


public class AllocationRowMapper implements RowMapper<Allocation> {

	@Override
	public Allocation mapRow(ResultSet resultSet, int line) throws SQLException {
		AllocationExtractor allocationExtractor = new AllocationExtractor();
		return allocationExtractor.extractData(resultSet);
	}

}
