package com.sparticles.auth.oauth2;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

/**
 * 手机验证码登陆Token认证类
 */
public class MobileAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public MobileAuthenticationToken(Authentication authenticationToken) {
        super(authenticationToken.getPrincipal(), authenticationToken.getCredentials());
    }
}
