package com.psw.chating.handler;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
/*
 @Component의 종류 : Spring에서 관리되는 객체임을 표시하기 위해 사용하는 가장 기본적인 annotation
1. @Contoller - @RestController
 :Web MVC 코드에 사용되는 어노테이션이다. 
 @RequestMapping 어노테이션을 해당 어노테이션 밑에서만 사용할 수 있다. 
2. @Service
3. @Repository
 */
@Component
public class SocketHandler extends TextWebSocketHandler {
	
	HashMap<String, WebSocketSession> sessionMap = new HashMap<>(); //웹소켓 세션을 담아둘 맵
	
	//TextWebSocketHandler를 상속받은 SocketHandler
	//TextWebSocketHandler의 handleTextMessage 메소드를 재정의 
	// 오타방지를 위해 Override 어노테이션 지원
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		//메시지 수신 후 발송
		String msg = message.getPayload();
		//map keyset을 사용해서 hashmap 전체 반복
		for(String key : sessionMap.keySet()) {
			WebSocketSession wss = sessionMap.get(key);
			try {
				wss.sendMessage(new TextMessage(msg));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//static 키워드를 가지는 메소드를 클래스 메소드(static method)라고 합니다.
		//static 키워드를 가지지 않는 메소드는 인스턴스 메소드(instance method)라고 합니다.
		//super 키워드는 부모 클래스로부터 상속받은 필드나 메소드를 자식 클래스에서 참조하는 데 사용하는 참조 변수
		//부모 클래스의 멤버와 자식 클래스의 멤버 이름이 같을 경우 super 키워드를 사용하여 구별할 수 있습니다.
		//this는 인스턴스 자신을 의미
		
		//소켓 연결되면 동작하는 메서드
		super.afterConnectionEstablished(session);
		sessionMap.put(session.getId(), session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//소켓 종료 되면 동작하는 메서드
		sessionMap.remove(session.getId());
		super.afterConnectionClosed(session, status);
	}
}