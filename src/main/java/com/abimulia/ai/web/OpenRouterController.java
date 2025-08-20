/**
 * OpenRouterController.java
 * 19-Aug-2025
 */
package com.abimulia.ai.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abimulia.ai.service.OpenRouterService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * @author abimu
 *
 * @version 1.0 (19-Aug-2025)
 * @since 19-Aug-2025 8:18:52 PM
 * 
 * 
 * Copyright(c) 2025 Abi Mulia
 */

@RestController
@RequestMapping("/api/ai")
@Slf4j
public class OpenRouterController {
	


	private final OpenRouterService orService;
	
	/**
	 * @param orService
	 */
	public OpenRouterController(OpenRouterService orService) {
		log.debug("OpenRouterController orService: {}", orService);
		this.orService = orService;
	}
	
	/**
     * Endpoint sync sederhana: /api/ai/ask?q=...
     */
    @GetMapping("/ask")
    public String ask(@RequestParam("question") String question) {
    	log.debug("ask question: {}", question);
        return orService.ask(question);
    }

    /**
     * Endpoint streaming SSE: /api/ai/stream?q=...
     */
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> stream(@RequestParam("question") String question) {
    	log.debug("stream question: {}", question);
        return orService.askStream(question);
    }
	
	

}
