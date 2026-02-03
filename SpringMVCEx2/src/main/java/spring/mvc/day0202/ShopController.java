package spring.mvc.day0202;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {
	@GetMapping("/shop/detail")
	public String shopList() {
		
		return "imgResult";
	}
	
	@GetMapping("/admin/shop/mypage")
	public String shopList2() {
		
		return "imgResult2";
	}
	@GetMapping("/myshop")
	public String shopList3() {
		
		return "imgResult3";
	}
}
