package org.bge.ccportal.configuration;

import java.util.Arrays;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/**
 * Spring Security Configuration.
 *
 * @author snilsen
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static Logger logger = Logger
            .getLogger(SecurityConfiguration.class.toString());

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder.authenticationProvider(activeDirectoryLdapAuthenticationProvider()).userDetailsService(userDetailsService());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Arrays.asList(activeDirectoryLdapAuthenticationProvider()));
        }

    @Bean
    public AuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
        ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider("bgeltd.com", "ldap://nilbgedc02.bgeltd.com:389");
        provider.setAuthoritiesMapper(new SimpleAuthorityMapper());
        provider.setConvertSubErrorCodesToExceptions(true);
        provider.setUseAuthenticationRequestCredentials(true);

        return provider;
    }

//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//
//        // The authentication provider below is the simplest provider you can use
//        // The users, their passwords and roles are all added as clear text
////        auth
////                .inMemoryAuthentication()
////                .withUser("admin").password("qwe123").roles("ADMIN")
////                .and()
////                .withUser("user").password("123456").roles("USER");
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select username, password, enabled from AppUser a where username=?")
//                .authoritiesByUsernameQuery(
//                        "select a.username, r.role from AppUser a " +
//                                "join AppUserRole b on a.AppUserId = b.AppUserId " +
//                                "join Role r on b.RoleId = r.RoleId " +
//                                "where a.username=?");
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        // This is here to ensure that the static content (JavaScript, CSS, etc)
        // is accessible from the login page without authentication
        web
                .ignoring()
                .antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                // access-denied-page: this is the page users will be
                // redirected to when they try to access protected areas.
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                // The intercept-url configuration is where we specify what roles are allowed access to what areas.
                // We specifically force the connection to https for all the pages, although it could be sufficient
                // just on the login page. The access parameter is where the expressions are used to control which
                // roles can access specific areas. One of the most important things is the order of the intercept-urls,
                // the most catch-all type patterns should at the bottom of the list as the matches are executed
                // in the order they are configured below. So /** (anyRequest()) should always be at the bottom of the list.
                .authorizeRequests()
                .antMatchers("/login**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                //This section forces all URLs to HTTPS; not necessary in our app
                //			.requiresChannel()
                //				.anyRequest().requiresSecure()
                //				.and()

                // This is where we configure our login form.
                // login-page: the page that contains the login screen
                // login-processing-url: this is the URL to which the login form should be submitted
                // default-target-url: the URL to which the user will be redirected if they login successfully
                // authentication-failure-url: the URL to which the user will be redirected if they fail login
                // username-parameter: the name of the request parameter which contains the username
                // password-parameter: the name of the request parameter which contains the password
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login.do")
                .defaultSuccessUrl("/")
                .failureUrl("/login?err=1")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                // This is where the logout page and process is configured. The logout-url is the URL to send
                // the user to in order to logout, the logout-success-url is where they are taken if the logout
                // is successful, and the delete-cookies and invalidate-session make sure that we clean up after logout
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?out=1")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                // The session management is used to ensure the user only has one session. This isn't
                // compulsory but can add some extra security to your application.
                .sessionManagement()
                .invalidSessionUrl("/login?time=1")
                .maximumSessions(1);
    }
}
