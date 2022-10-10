package com.stackroute.chatservice.repository;

import com.stackroute.chatservice.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository extends MongoRepository<ChatMessage,String> {
}
