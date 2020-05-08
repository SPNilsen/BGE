/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bge.ccportal.configuration;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

/**
 *
 * @author seannils1
 */
public class SimpleAuthorityMapper implements GrantedAuthoritiesMapper {

    private static Logger logger = Logger
            .getLogger(GrantedAuthoritiesMapper.class.toString());

    @Override
    public Collection<? extends GrantedAuthority> mapAuthorities(
            Collection<? extends GrantedAuthority> authorities) {

        Set newAuths = new HashSet();
        newAuths.addAll(authorities);
        
        for (GrantedAuthority auth : authorities){
            if(auth.getAuthority().equals(new String("BGE-Skill_Percent")))
            newAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        
        return newAuths;

    }
    
}

