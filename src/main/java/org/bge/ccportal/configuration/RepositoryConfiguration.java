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
		driverManagerDataSource.setDriverClassName( "net.sourceforge.jtds.jdbc.Driver" );
		driverManagerDataSource.setUrl( "jdbc:jtds:sqlserver://DB-PRD-CiscoICM.bgeltd.com:1433/CiscoICM" );
		driverManagerDataSource.setUsername( "icmGuiBGE" );
		driverManagerDataSource.setPassword( "cEAc_A_Kb_36" );
		return driverManagerDataSource;
	}
}
