package spring.mvc.day0204;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/form1")
	public String form() {
		return "board/writeForm";
	}
	
	@PostMapping("/process")
	public ModelAndView process(@RequestParam String name, 
			@RequestParam String date, 
			@RequestParam String gender, 
			/*required는 기본이 true, 항목이 없는데 에러가 안나게 하려면 true, defaultValue를 주면된다*/
			@RequestParam(required = false) String msg,  /*required이거 안하면 400에러나*/
			@RequestParam(defaultValue = "1") int currentPage) {
		ModelAndView mview= new ModelAndView();
		
		mview.addObject("name", name);
		mview.addObject("date", date);
		mview.addObject("gender", gender);
		mview.addObject("msg", msg);
		mview.addObject("currentPage", currentPage);
		mview.setViewName("board/result");
		return mview;
	}
	
	@GetMapping("/result2")
	public String result2(Model model) {
		model.addAttribute("myimg1", "../image/Food/10.jpg");
		model.addAttribute("likeFood", "내가 좋아하는 음식");
		return "board/result2";
	}
}
