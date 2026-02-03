package spring.mvc.day0202;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	
	//home으로 첫화면이 나오게
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	@GetMapping("/dragon/sist") 
	// @GetMapping("/dragon/sist")
	// ▶ URL 뒤에 확장자(.do, .nhn 등)를 붙이지 않고 매핑
	// ▶ 예: /dragon/sist
	// ▶ Spring MVC에서는 확장자 기반 요청(.do, .nhn)을 더 이상 사용하지 않음
	// ▶ 컨트롤러 메서드가 URL 자체로 직접 매핑됨 (REST 방식)

	// ❌ 옛날 방식 (Spring 이전 / 초창기 MVC)
	// @GetMapping("/dragon/sist.do")
	// ▶ .do, .nhn 같은 확장자는 과거 서블릿 매핑 방식
	// ▶ web.xml에서 *.do 식으로 매핑하던 시대의 흔적
	// ▶ 현재 Spring Boot / Spring MVC에서는 사용하지 않음
	//(Model model)은 “컨트롤러에서 화면(JSP)으로 데이터 보내는 통로
	public String hello1(Model model) {
		model.addAttribute("name", "손흥민");
		model.addAttribute("addr", "서울 강남구 ");
		return "result1";
	}
	@GetMapping("/naver/shop")
	public String hello2(Model model) {
		model.addAttribute("name", "요가매트");
		model.addAttribute("color", "그레이");
		model.addAttribute("price", "25,000");
		return "result2";
	}
}
