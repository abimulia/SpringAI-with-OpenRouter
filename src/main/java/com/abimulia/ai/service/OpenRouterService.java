/**
 * OpenRouterService.java
 * 19-Aug-2025
 */
package com.abimulia.ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * @author abimu
 *
 * @version 1.0 (19-Aug-2025)
 * @since 19-Aug-2025 8:11:54 PM
 * 
 * 
 * Copyright(c) 2025 Abi Mulia
 */

@Service
@Slf4j
public class OpenRouterService {
	


//	private final ChatClient chatClient;
	private final OpenAiChatModel chatModel;
	
	
	/**
	 * @param chatClient
	 */
	public OpenRouterService(OpenAiChatModel chatModel) {
		log.debug("chatModel: {}", chatModel);
		this.chatModel = chatModel;
		log.debug("OpenRouterService chatModel: {}", this.chatModel);

	}
	
	 /**
     * Synchronous, satu kali jawab.
     */
    public String ask(String userMessage) {
    	log.debug("ask userMessage: {}",userMessage);
    	ChatResponse response = chatModel.call(new Prompt(userMessage));
    	log.debug("ChatResponse : {}", response);
        return response.getResult().getOutput().getText();
    }

    /**
     * Streaming jawaban sebagai Flux teks (untuk SSE/WebFlux).
     */ 
    public Flux<String> askStream(String userMessage) {
    	log.debug("askStream userMessage: {}",userMessage);
    	return chatModel.stream(new Prompt(userMessage))
                .map(chatResponse -> {
                    // Get text from each chunk
                    return chatResponse.getResult().getOutput().getText();
                })
                // filter empty chunk
                .filter(text -> text != null && !text.isBlank());
    	
    }
	
	

}
