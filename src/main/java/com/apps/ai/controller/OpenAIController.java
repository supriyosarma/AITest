
package com.apps.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apps.ai.service.AIService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("api/openai")
public class OpenAIController {
	
	@Autowired
	private AIService aiService;
	
	/**
	 * Handles chat requests, maintaining session history.
	 * 
	 * @param prompt  The user's chat prompt.
	 * @param session The HTTP session to maintain chat history.
	 * @return The AI's response to the chat prompt.
	 */
	@GetMapping("/chat")
	public ResponseEntity<String> getChatResponse(@RequestParam String prompt, HttpSession session) {

	    String response = aiService.getChatResponse(prompt, session);
	    return ResponseEntity.ok(response);
	}

	
	/**
	 * Handles ask requests.
	 * 
	 * @param prompt The user's prompt.
	 * @return The AI's response to the prompt.
	 */
	@GetMapping("/ask")
	public ResponseEntity<String> getAskResponse(@RequestParam String prompt) {
		String response = aiService.getAskResponse(prompt);
		return ResponseEntity.ok(response);
	}

	/*
	 * @GetMapping("/chat") public ResponseEntity<String>
	 * getChatResponse(@RequestParam String prompt) { String response =
	 * aiService.getChatResponse(prompt); return ResponseEntity.ok(response); }
	 */
	
}
