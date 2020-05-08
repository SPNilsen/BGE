package org.bge.ccportal.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.bge.ccportal.model.Allocation;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class AllocationExtractor implements ResultSetExtractor<Allocation> {

	public Allocation extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
                        
                        boolean val3 = false;
                        boolean val4 = false;
                        boolean val5 = false;
                        
                        if(resultSet.getInt(3) == 1){
                            val3 = true;    
                        }
                        if(resultSet.getInt(4) == 1){
                            val4 = true;    
                        }
                        if(resultSet.getInt(5) == 1){
                            val5 = true;    
                        }
                        
		Allocation allocation = new Allocation(resultSet.getString(1),resultSet.getString(2),val3,val4,val5,resultSet.getInt(6),resultSet.getInt(7));
		return allocation;
	}

}
