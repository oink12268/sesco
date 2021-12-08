package com.eggplant.sesco.presentation.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserDetailsVo userDetailsVo;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        System.out.println("Get authorization");

//        if(loginId == userDetailsVo.getUsername())
//            return new UserDetailsVo();
//        else
            throw new UsernameNotFoundException("해당 유저를 찾을 수 없습니다");
    }
}
