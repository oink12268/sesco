package com.eggplant.sesco.presentation.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserDetailsVo userDetailsVo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        if(!s.equals("test")) throw new UsernameNotFoundException("해당 유저가 존재하지 않습니다.");

        return new UserDetailsVo(s, Arrays.asList("ROLE_AUTH"));
    }
}
