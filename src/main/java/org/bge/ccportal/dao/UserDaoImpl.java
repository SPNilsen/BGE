package org.bge.ccportal.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.bge.ccportal.jdbc.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.bge.ccportal.model.User;

public class UserDaoImpl implements UserDao {

    @Autowired
    DataSource dataSource;

    public void insertData(User user) {

        //Add the new User, Add the Role After
        String sql_user = "INSERT INTO users "
                + "(username, password, enabled) VALUES (?, ?, ?)";

        String sql_role = "INSERT INTO user_roles "
                + "(username, ROLE) VALUES (?, 'ROLE_USER')";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        int var3 = 0;

        if (user.isEnabled()) {
            var3 = 1;
        }

        //Add the User
        jdbcTemplate.update(
                sql_user,
                new Object[]{user.getUsername(), user.getPassword(), var3});

        //Add the Role
        jdbcTemplate.update(
                sql_role,
                new Object[]{user.getUsername()});
    }

    public List<User> getUserList() {
        List userList = new ArrayList();

        String sql = "select * from users";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql, new UserRowMapper());
        return userList;
    }

    @Override
    public void deleteData(String username) {
        String sql_roles = "delete from user_roles where username='" + username + "'";
        String sql_user = "delete from users where username='" + username + "'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
        jdbcTemplate.update(sql_roles);
        jdbcTemplate.update(sql_user);

    }

    @Override
    public void updateData(User user) {

        //Update the User
        String sql = "UPDATE users set password = ?, enabled = ? where username = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

//        Map<String,Object> params = new HashMap<String,Object>();
//        params.put("pass", user.getPassword());
        int var3 = 0;

        if (user.isEnabled()) {
            var3 = 1;
        }

        jdbcTemplate.update(
                sql,
                new Object[]{user.getPassword(), var3, user.getUsername()});

    }

    @Override
    public User getUser(String username) {
        List<User> userList = new ArrayList<User>();
        String sql = "select * from users where username='" + username + "'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql, new UserRowMapper());
        return userList.get(0);
    }

}
