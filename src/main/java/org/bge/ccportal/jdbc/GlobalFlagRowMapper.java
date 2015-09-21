package org.bge.ccportal.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.bge.ccportal.model.GlobalFlag;

import org.springframework.jdbc.core.RowMapper;


public class GlobalFlagRowMapper implements RowMapper<GlobalFlag> {

	@Override
	public GlobalFlag mapRow(ResultSet resultSet, int line) throws SQLException {
		GlobalFlagExtractor globalFlagExtractor = new GlobalFlagExtractor();
		return globalFlagExtractor.extractData(resultSet);
	}

}
