package com.sparticles.auth.oauth2;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Slf4j
@Service("userDetailsService")
public class AuthUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new org.springframework.security.core.userdetails.User(
                "test",
                new BCryptPasswordEncoder().encode("test"),
                true,
                true,
                true,
                true,
                this.getRoleByUser());
    }

    //todo 入参加入User，获取用户权限
    private Set<GrantedAuthority> getRoleByUser(){
        Set<GrantedAuthority> set = Sets.newHashSet();
        set.add(new SimpleGrantedAuthority("USER"));
        return  set;
    }

}
