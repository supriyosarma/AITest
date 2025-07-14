
package com.apps.ai.controller;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/openai")
public class OpenAIController {
	
	@Autowired
	private OpenAiChatModel openAiChatModel;

	@GetMapping("/ask")
	public ResponseEntity<String> getResponse(@RequestParam String prompt) {
		String response = openAiChatModel.call(prompt);
		return ResponseEntity.ok(response);
	}

	public String getChatResponse(String chatPrompt) {
		// Placeholder for OpenAI Chat API call logic
		// This method should interact with the OpenAI Chat API to get a response
		// based on the chat prompt
		return "Chat response from OpenAI for prompt: " + chatPrompt;
	}
}
