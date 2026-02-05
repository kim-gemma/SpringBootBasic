package spring.mvc.day0204;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shop")
public class ShopController {

	@GetMapping("/list")
	public String list() {
		return "shop/list";
	}
	
	@GetMapping("form2")
	public String form2() {
		return "shop/shopForm";
	}
	
	//shopform으로 이동
	@PostMapping("/process2")
	public ModelAndView process2(@RequestParam String sang,
			@RequestParam int su,
			@RequestParam int price,
			@RequestParam String color) {
		ModelAndView mview =new ModelAndView();
		mview.addObject("sang", sang);
		mview.addObject("price", price);
		mview.addObject("su", su);
		mview.addObject("color", color);
	
		mview.setViewName("shop/shopResult");
		return mview;
	}
	
	
}
