package org.bge.ccportal.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.bge.ccportal.jdbc.AllocationRowMapper;
import org.bge.ccportal.model.Allocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AllocationDaoImpl implements AllocationDao {

    @Autowired
    DataSource dataSource;

    @Override
    public void insert(Allocation allocation) {
        String sql = "INSERT INTO BGE_PERCENTAGE_ROUTING "
                + "(product, product_name, force_open, force_close, meeting, overflow, overflow2) values (?,?,?,?,?,?,?)";

        Connection conn = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(
                sql,
                new Object[]{allocation.getProduct(), allocation.getProduct_name(), allocation.getForce_open(), allocation.getForce_close(), allocation.getMeeting(), allocation.getOverflow()});
    }

    @Override
    public Allocation findByProduct(String product) {

        String sql = "select * from BGE_PERCENTAGE_ROUTING where product = " + product;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Allocation> allocationList = jdbcTemplate.query(sql, new AllocationRowMapper());
        return allocationList.get(0);
    }

    @Override
    public List<Allocation> getAll() {
        List allocationList = new ArrayList();

        String sql = "select product, product_name, force_open, force_close, meeting, overflow, overflow2 from BGE_PERCENTAGE_ROUTING";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        allocationList = jdbcTemplate.query(sql, new AllocationRowMapper());
        return allocationList;
    }

    @Override
    public void update(Allocation allocation) {
        System.out.println("FindMe Inside DAO: "+ allocation.describe());
        String sql = "UPDATE BGE_PERCENTAGE_ROUTING set force_open = ?, force_close = ?, meeting = ?, overflow = ?, overflow2 = ? where product = ?";
        
        Connection conn = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(
                sql,
                new Object[]{allocation.getForce_open(), allocation.getForce_close(), allocation.getMeeting(), allocation.getOverflow(), allocation.getOverflow2(), allocation.getProduct()});
    }

    @Override
    public void delete(String product) {
        String sql = "DELETE from BGE_PERCENTAGE_ROUTING where product = " + product;

        Connection conn = null;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql);
    }

}
