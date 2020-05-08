package org.bge.ccportal.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.bge.ccportal.jdbc.GlobalFlagRowMapper;
import org.bge.ccportal.model.GlobalFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class GlobalFlagDaoImpl implements GlobalFlagDao {

    @Autowired
    DataSource dataSource;

    //Locals
    int emergency = 0;
    int weather = 0;

    @Override
    public void insert(GlobalFlag globalFlag) {
        String sql = "INSERT INTO BGE_GlobalFlag "
                + "(id, emergency, weather) values (?,?,?)";

        Connection conn = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        convertBools(globalFlag);

        jdbcTemplate.update(
                sql,
                new Object[]{globalFlag.getId(), emergency, weather});
    }

    @Override
    public GlobalFlag findById(int id) {

        String sql = "select * from BGE_Global where id = " + id;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<GlobalFlag> globalFlagList = jdbcTemplate.query(sql, new GlobalFlagRowMapper());
        return globalFlagList.get(0);
    }

    @Override
    public List<GlobalFlag> getAll() {
        List globalFlagList = new ArrayList();

        String sql = "select id, emergency, weather from BGE_Global";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        globalFlagList = jdbcTemplate.query(sql, new GlobalFlagRowMapper());
        return globalFlagList;
    }

    @Override
    public void update(GlobalFlag globalFlag) {
        String sql = "UPDATE BGE_Global set emergency = ?, weather = ? where id = ?";

        System.out.println(globalFlag.describe());
        
        Connection conn = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        convertBools(globalFlag);
        
        System.out.println("UPDATE BGE_Global set emergency = ?, weather = ? where id = ? :: " + emergency + "," + weather + "," + globalFlag.getId());
        
        jdbcTemplate.update(
                sql,
                new Object[]{emergency, weather, globalFlag.getId()});
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE from BGE_Global where id = " + id;

        Connection conn = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql);
    }

    public void convertBools(GlobalFlag globalFlag) {
        //Convert Booleans to Int's for DB
        if (globalFlag.isEmergency()) {
            emergency = 1;
        } else {
            emergency = 0;
        }
        if (globalFlag.isWeather()) {
            weather = 1;
        } else {
            weather = 0;
        }
    }

}
