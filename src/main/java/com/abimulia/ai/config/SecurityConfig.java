/**
 * SecurityConfig.java
 * 19-Aug-2025
 */
package com.abimulia.ai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author abimu
 *
 * @version 1.0 (19-Aug-2025)
 * @since 19-Aug-2025 8:07:42 PM
 * 
 * 
 * Copyright(c) 2025 Abi Mulia
 */
@Configuration
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable());
        return http.build();
    }

}
