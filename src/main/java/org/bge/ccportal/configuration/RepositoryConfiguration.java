package org.bge.ccportal.configuration;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 * Loads the relevant repository classes
 *
 * @author Alessandro Giannone
 * @version 1.0
 */
@Configuration
public class RepositoryConfiguration
{
	
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName( "com.mysql.jdbc.Driver" );
		driverManagerDataSource.setUrl( "jdbc:mysql://localhost:3306/ccportal" );
		driverManagerDataSource.setUsername( "ccportal" );
		driverManagerDataSource.setPassword( "!ccp0rtal!" );
		return driverManagerDataSource;
	}
}
