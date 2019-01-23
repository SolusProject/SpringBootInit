package com.app.service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bean.Message;
import com.app.dao.MessageDao;

@Service
public class MessageService {
	
	@Autowired
	private MessageDao dao;
	
	public Long countUniqueUserId() {
		 return dao.getAll().stream().filter(distinctByKey(Message::getUserId)).count();
	}
	
	public Message get4thMessage() {
		return modify(dao.getAll().get(3));
	}
	
	private static Message modify(Message message) {
		final String mod_str = "1800Flowers";
		message.setTitle(mod_str);
		message.setBody(mod_str);
		return message;
	}
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Set<Object> seen = ConcurrentHashMap.newKeySet();
	    return t -> seen.add(keyExtractor.apply(t));
	}
}
