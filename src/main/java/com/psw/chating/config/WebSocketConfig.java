package com.psw.chating.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.psw.chating.handler.SocketHandler;

//bean 이란 Spring Bean Container에 존재하는 객체를 말한다
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	//@Autowired annotation 은 new ~ 하고 같은 개념, 
	//스프링4.3부터는 생성자가 1개일경우 생략가능하다함
	@Autowired
	SocketHandler socketHandler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(socketHandler, "/chating");
	}
}