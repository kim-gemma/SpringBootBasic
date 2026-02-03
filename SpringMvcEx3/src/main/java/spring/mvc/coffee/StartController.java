package spring.mvc.coffee;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StartController {
	@GetMapping("/")
	public String Start() {
		return "myPage/home";
	}
	
	@GetMapping("/coffee/star")
	public String Start2(Model model) {
		model.addAttribute("name", "김현능");
		model.addAttribute("hp", "010-3907-4180");
		model.addAttribute("job", "개발자");
		return "myPage/study1";
	}
	
	@GetMapping("/coffee/bean")
	public ModelAndView Start3(HttpSession session) {
		ModelAndView mview= new ModelAndView();
		//request
		//👉 “이번 화면에서만 필요한 데이터”
		//session
		//👉 “사용자 자체를 대표하는 최소 정보”
		//id만 세션에 넣는 이유
		//👉 로그인 상태를 판별하는 열쇠라서
		
		//request
		mview.addObject("pass", "1234");
		mview.addObject("email", "ayuhyun@naver.com");
		//session
		session.setAttribute("id", "kkk");
		//foward
		mview.setViewName("myPage/study2");
		return mview;
	}
	
	
	@GetMapping("/pink/add/list")
	public String Start4() {
		return "myPage/study3";
	}
	
	
}
