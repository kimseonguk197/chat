package com.psw.chating.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	//@RequestMapping는 view의 요청경로 설정
	@RequestMapping("/chat")
	public ModelAndView chat() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat");
		//ModelAndView.addAttribute("변수이름", "데이터값")을 통해서 데이터를 뷰로 넘길수도 있다.
		return mv;
		/*여기서 반환 값은 application.properties와 매핍되어, 
		mvc.view.prefix, suffix가 붙여져 return 파일을 찾아낸다.
		*/
	}
}