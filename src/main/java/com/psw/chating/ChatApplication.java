package com.psw.chating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*

@Target(value={TYPE})
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters={@Filter(type=CUSTOM, classes={TypeExcludeFilter.class}), @Filter(type=CUSTOM, classes={AutoConfigurationExcludeFilter.class})})
@Retention(value=RUNTIME)
@Documented
@Inherited 
>>@SpringBootApplication

ComponentScan : 
@Component @Configuration @Repository @Service @Controller @RestController
해당 어노테이션이 선언된 하위 패키지에서 위와 같은 Annotation을 찾아서 Bean으로 등록한다.
<<스프링 컨테이너가 생성한 객체들을 '빈'이라고 한다.

 * */
@SpringBootApplication 
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

}
