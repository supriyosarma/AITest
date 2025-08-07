package com.apps.ai.service;


import jakarta.servlet.http.HttpSession;

public interface AIService {
	
	public String getAskResponse(String chatPrompt);
	
//	public String getChatResponse(String chatPrompt);
		
	public String getChatResponse(String prompt, HttpSession session);


}
