package com.eggplant.sesco.presentation.config;

import com.eggplant.sesco.presentation.config.security.CustomAccessDeniedHandler;
import com.eggplant.sesco.presentation.config.security.CustomAuthenticationEntryPoint;
import com.eggplant.sesco.presentation.config.security.SecurityAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Bean
    public SecurityAuthenticationFilter securityAuthenticationFilter() {

        return new SecurityAuthenticationFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/api/v1/test/permit-all").permitAll()
//                .antMatchers("/api/v1/test/auth").hasRole("AUTH")
                .antMatchers("/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().disable()
        ;

        http
                .addFilterBefore(securityAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

}
