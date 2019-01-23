package com.app.dao;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.stereotype.Repository;

import com.app.bean.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class MessageDao {
	
	ObjectMapper mapper = new ObjectMapper();
	final String url = "http://jsonplaceholder.typicode.com/posts";
	
	public List<Message> getAll() {
		try {
			return mapper.readValue(
					new URL(url), 
					mapper.getTypeFactory().constructCollectionType(ArrayList.class, Message.class)
			);
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	} 
		 
}
