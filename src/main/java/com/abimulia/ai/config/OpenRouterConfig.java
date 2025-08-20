/**
 * OpenRouterConfig.java
 * 20-Aug-2025
 */
package com.abimulia.ai.config;

import org.springframework.boot.web.client.RestClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author abimu
 *
 * @version 1.0 (20-Aug-2025)
 * @since 20-Aug-2025 11:50:41 AM
 * 
 * 
 * Copyright(c) 2025 Abi Mulia
 */

@Configuration
public class OpenRouterConfig {
	
	@Bean
    public RestClientCustomizer openRouterCustomizer() {
        return restClientBuilder -> restClientBuilder
                .defaultHeader("HTTP-Referer", "http://localhost:8080") 
                .defaultHeader("X-Title", "SpringAI OpenRouter");
    }

}
