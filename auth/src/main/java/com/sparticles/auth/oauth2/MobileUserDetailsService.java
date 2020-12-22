package com.sparticles.auth.oauth2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

/**
 * 手机验证码登陆, 用户相关获取
 */
@Slf4j
@Service("mobileUserDetailsService")
public class MobileUserDetailsService implements UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new org.springframework.security.core.userdetails.User(
                "test",
                "test",
                true,
                true,
                true,
                true,
                this.getRoleByUser());
    }

    //todo 入参加入User，获取用户权限
    private Set<GrantedAuthority> getRoleByUser(){
        Set<GrantedAuthority> set = Collections.emptySet();
        set.add(new SimpleGrantedAuthority("ceshi"));
        return  set;
    }
}
