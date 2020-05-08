package org.bge.ccportal.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.bge.ccportal.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class UserExtractor implements ResultSetExtractor<User> {

    public User extractData(ResultSet resultSet) throws SQLException,
            DataAccessException {

        System.out.println("UserExtractor: 14");
        boolean var3 = false;
        if (resultSet.getInt(3) == 1) {
            var3 = true;
        }

        System.out.println("UserExtractor: 20");
        User user = new User(resultSet.getString(1), resultSet.getString(2), var3);

        return user;
    }

}
