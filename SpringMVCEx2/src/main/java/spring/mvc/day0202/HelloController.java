package spring.mvc.day0202;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping("/apple/list") 
	//사원명(sawonName), 부서명( buseo), 급여(pay)를 result3에서 출력하도록 해보세요
	public String company(Model model) {
		model.addAttribute("sawonName", "김현능");
		model.addAttribute("buseo", "개발팀");
		model.addAttribute("pay", "5,000,000");
		return "result3";
	}
	
	
	@GetMapping("/kakao/list")
	public ModelAndView klist(HttpSession session) {
		ModelAndView mview= new ModelAndView();
		//ModelAndView는 request애 저장하기 위한 model과 포워드하기위한 view를 합친 클래스
		//request에 저장
		mview.addObject("java",88);
		mview.addObject("spring",99);
		//session에 저장
		session.setAttribute("myid", "admin");
		
		//포워드할 jsp파일을 지정
		mview.setViewName("result4");
		
		return mview;
	}

}
