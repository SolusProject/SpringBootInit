package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bean.Message;
import com.app.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService service;
	
	@RequestMapping("/count")
	public Long countUniqueUserId() {
		return service.countUniqueUserId();
	}
	
	// Return the modified JSON object to the main Java class.
	@RequestMapping("/get4th")
	public Message get4thMessage() {
		return service.get4thMessage();
	} 
	
}
