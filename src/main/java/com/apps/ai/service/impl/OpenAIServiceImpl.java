package com.apps.ai.service.impl;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.ai.service.AIService;

@Service
public class OpenAIServiceImpl implements AIService {
	
	@Autowired
	private OpenAiChatModel openAiChatModel;

	@Override
	public String getChatResponse(String chatPrompt) {
		return openAiChatModel.call(chatPrompt);
	}

}
