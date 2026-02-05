package db.sts.sist;

import java.lang.ProcessBuilder.Redirect;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyshopController {
	
	@Autowired
	MyshopDao dao;
	@GetMapping("/")
	public String home() {
		return "redirect:/myshop/list";
	}
	
	@GetMapping("/myshop/list")
	public String home(Model model) {
		
		List<MyshopDto> list= dao.getAllSangpums();
		
		model.addAttribute("list", list);
		model.addAttribute("count", list.size());
		
		return "myshop/list";
	}
	
	//입력폼으로 이동
	@GetMapping("/myshop/addform")
	public String form(Model model) {
		return "myshop/addform";
	}
	
	//입력폼 처리
	@PostMapping("/myshop/add")
	public String insert(@ModelAttribute("dto") MyshopDto dto,
			@RequestParam ArrayList<MultipartFile> upload,
			HttpSession session)
	{
		//업로드 실제경로
		String path= session.getServletContext().getRealPath("/WEB-INF/photo");
		
		//파일명에 현재날짜 사용
		SimpleDateFormat sdf= new SimpleDateFormat("yyyymmddhhss");
		System.out.println(path);
		String photo="";
		
		if(upload.get(0).getOriginalFilename().equals(""))//사진선택 안했으면  required="required"
		photo="no";
		else {
			for(MultipartFile f:upload) {
				String fName = sdf.format(new Date())+f.getOriginalFilename();
				photo+=fName+",";
				
				//업로드
				try {
					f.transferTo(new File(path+"\\"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//마지막 컴마 제거
				photo=photo.substring(0, photo.length()-1);
				
				dto.setPhoto(photo);
				dao.insertMyshop(dto);
				return "redirect:list";
			}
		}
		
		dao.insertMyshop(dto);
		return "redirect:list";
	}
	
	// 디테일이동 (이거 하나만 고치면 됨)
	@GetMapping("/myshop/detail")
	public ModelAndView detail(@RequestParam int num) {
		ModelAndView model =new ModelAndView();
		MyshopDto dto= dao.getData(num);
		model.addObject("dto", dto);
		model.setViewName("myshop/detailview");
		return model;
	}
}
