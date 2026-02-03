package spring.mvc.data;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import data.dto.SawonDto;

@Controller
public class QuizController {
	
	//입력폼으로 이동
	@GetMapping("/quiz/myform")
	public String form() {
		return "quiz/form";
	}
	
	@PostMapping("/quiz/read5")
	public ModelAndView quiz(@ModelAttribute SawonDto dto) {
		ModelAndView mview = new ModelAndView();
		mview.addObject("dto", dto);
		
		mview.setViewName("quiz/result5");
		return mview;
	}
}
