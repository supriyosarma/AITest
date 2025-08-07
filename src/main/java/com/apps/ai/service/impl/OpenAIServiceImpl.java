package com.apps.ai.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

import com.apps.ai.service.AIService;

import jakarta.servlet.http.HttpSession;

@Service
public class OpenAIServiceImpl implements AIService {
	

	private OpenAiChatModel openAiChatModel;	
	private ChatClient chatClient;
	
	public OpenAIServiceImpl(OpenAiChatModel openAiChatModel) {
		this.openAiChatModel = openAiChatModel;
		this.chatClient = ChatClient.create(openAiChatModel);
	}

	@Override
	public String getAskResponse(String chatPrompt) {
		return openAiChatModel.call(chatPrompt);
	}

	/*
	 * @Override public String getChatResponse(String chatPrompt) { return
	 * chatClient.prompt(chatPrompt).call().content(); }
	 */

	@Override
	@SuppressWarnings("unchecked")
	public String getChatResponse(String prompt, HttpSession session) {

		// Get or create history for this session

		List<String> history = (List<String>) session.getAttribute("chatHistory");
		if (history == null) {
			history = new ArrayList<>();
		}
		history.add(prompt);
		session.setAttribute("chatHistory", history);

		// Combine all history into a chat prompt for OpenAI
		StringBuilder sb = new StringBuilder();
		for (String msg : history) {
			sb.append(msg).append("\n");
		}

		// Pass the history (or history + new prompt) to the openAI client
		String response = chatClient.prompt(sb.toString()).call().content();

		history.add(response); // Optionally add response to history
		session.setAttribute("chatHistory", history);

		return response;
	}


}
