package spring.hello.hi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
	@GetMapping("/happy")
	public String list(Model model) {
		return "mystudy01";
	}
	
	@GetMapping("/hello/my")
	public String list2(Model model) {
		model.addAttribute("title", "오므라이스??");
		return "mystudy02";
	}
	
	@GetMapping("/nice/hello")
	public String list3(Model model) {
		model.addAttribute("name", "김현능");
		model.addAttribute("age", "35");
		return "mystudy03";
	}
	
	
	
}
