package org.bge.ccportal.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Overall App Configuration
 *
 * @author Sean Nilsen
 * @version 1.0
 */
@Configuration
@ComponentScan({ "org.bge.ccportal.*" })
@Import({ MvcConfiguration.class, RepositoryConfiguration.class, SecurityConfiguration.class, BeanConfiguration.class })
public class AppConfiguration
{
}
