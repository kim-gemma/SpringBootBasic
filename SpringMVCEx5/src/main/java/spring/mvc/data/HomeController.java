package spring.mvc.data;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.dto.TestDto;

@Controller
public class HomeController {
	
	//home시작하기
	@GetMapping("/")
	public String home() {
		return "data/home";
	}
	
	//입력폼으로 이동
	@GetMapping("/data/myform")
	public String form() {
		return "data/form";
	}
	
	//1번쨰 폼전송
	@GetMapping("/data/read1")
	public ModelAndView reea1(@RequestParam("name") String name, @RequestParam int age) { //폼태그 name과 읽을 변수가 같다면 앞의 name은 생략가능
		ModelAndView mview = new ModelAndView();
		//request에 저장
		mview.addObject("name", name);
		mview.addObject("age", age);
		
		//포워드
		mview.setViewName("data/result1");
		return mview;
	}
	
	//2번재 폼전송
	@PostMapping("/data/read2")
	public ModelAndView read2(@ModelAttribute TestDto dto) {
		ModelAndView mview= new ModelAndView();
		mview.addObject("dto", dto);
		
		mview.setViewName("data/result2");
		return mview;
	}
	
	//3번재 폼전송
	@PostMapping("/data/read3")
	public ModelAndView read3(@RequestParam Map<String, String> map) {
		ModelAndView mview = new ModelAndView();
		
		String sang=map.get("sang");
		String price=map.get("sprice");
		
		String data=sang+" 제품의 가격은" +price+" 원 입니다.";
		mview.addObject("data", data);
		mview.setViewName("data/result3");
		
		return mview;
	}
	
}
	

