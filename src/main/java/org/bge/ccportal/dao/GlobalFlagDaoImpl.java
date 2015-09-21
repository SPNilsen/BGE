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
        String sql = "INSERT INTO GlobalFlag "
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

        String sql = "select * from Global_Flag where id = " + id;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<GlobalFlag> globalFlagList = jdbcTemplate.query(sql, new GlobalFlagRowMapper());
        return globalFlagList.get(0);
    }

    @Override
    public List<GlobalFlag> getAll() {
        List globalFlagList = new ArrayList();

        String sql = "select id, emergency, weather from Global_Flag";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        globalFlagList = jdbcTemplate.query(sql, new GlobalFlagRowMapper());
        return globalFlagList;
    }

    @Override
    public void update(GlobalFlag globalFlag) {
        String sql = "UPDATE Global_Flag set emergency = ?, weather = ? where id = ?";

        System.out.println(globalFlag.describe());
        
        Connection conn = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        convertBools(globalFlag);
        
        System.out.println("emergency: " + emergency + ", weather: " + weather);
        
        jdbcTemplate.update(
                sql,
                new Object[]{emergency, weather, globalFlag.getId()});
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE from Global_Flag where id = " + id;

        Connection conn = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql);
    }

    public void convertBools(GlobalFlag globalFlag) {
        //Convert Booleans to Int's for DB
        if (globalFlag.isEmergency()) {
            emergency = 1;
        }
        if (globalFlag.isWeather()) {
            weather = 1;
        }
    }

}
