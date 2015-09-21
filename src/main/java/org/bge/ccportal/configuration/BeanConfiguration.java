/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bge.ccportal.configuration;

import org.bge.ccportal.dao.AllocationDao;
import org.bge.ccportal.dao.AllocationDaoImpl;
import org.bge.ccportal.dao.GlobalFlagDao;
import org.bge.ccportal.dao.GlobalFlagDaoImpl;
import org.bge.ccportal.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.bge.ccportal.dao.UserDaoImpl;
import org.bge.ccportal.services.AllocationService;
import org.bge.ccportal.services.AllocationServiceImpl;
import org.bge.ccportal.services.GlobalFlagService;
import org.bge.ccportal.services.GlobalFlagServiceImpl;
import org.bge.ccportal.services.UserService;
import org.bge.ccportal.services.UserServiceImpl;

/**
 *
 * @author seannils1
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public AllocationDao allocationDao() {
        return new AllocationDaoImpl();
    }

    @Bean
    public AllocationService allocationService() {
        return new AllocationServiceImpl();
    }
    
    @Bean
    public GlobalFlagDao globalFlagDao(){
        return new GlobalFlagDaoImpl();
    }
    
    @Bean
    public GlobalFlagService globalFlagService(){
        return new GlobalFlagServiceImpl();
    }
}
