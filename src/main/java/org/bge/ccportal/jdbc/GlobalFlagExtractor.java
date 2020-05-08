package org.bge.ccportal.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.bge.ccportal.model.Allocation;
import org.bge.ccportal.model.GlobalFlag;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class GlobalFlagExtractor implements ResultSetExtractor<GlobalFlag> {

    public GlobalFlag extractData(ResultSet resultSet) throws SQLException,
            DataAccessException {

        boolean val2 = false;
        boolean val3 = false;

        if (resultSet.getInt(2) == 1) {
            val2 = true;
        }
        if (resultSet.getInt(3) == 1) {
            val3 = true;
        }

        GlobalFlag globalFlag = new GlobalFlag(resultSet.getInt(1), val2, val3);
        return globalFlag;
    }

}
