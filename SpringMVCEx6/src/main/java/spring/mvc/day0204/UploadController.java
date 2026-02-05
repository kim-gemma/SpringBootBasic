package spring.mvc.day0204;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	@GetMapping("/upload/uploadForm1")
	public String form1() {
		return "upload/uploadForm1";
	}
	
	@GetMapping("/upload/uploadForm2")
	public String form2() {
		return "upload/uploadForm2";
	}
	
	@PostMapping("/upload/uploadproc1")
	public ModelAndView proc1(@RequestParam String title,
			@RequestParam MultipartFile photo,
			HttpServletRequest request) {
		ModelAndView mview= new ModelAndView();
		//업로드 실제경로 구하기
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(realPath);
		
		String fileName=photo.getOriginalFilename();
		
		if(!fileName.equals("")) {//실제업로드
			try {
				photo.transferTo(new File(realPath+"\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			fileName= "no"; //업로드 안했을 경우
		}
		
		mview.addObject("fileName", fileName);
		mview.addObject("title", title);
		mview.addObject("realPath", realPath);
		mview.setViewName("upload/uploadResult1");
		
		return mview;
	}
	
	@PostMapping("/upload/uploadproc2")
	public ModelAndView proc2(@RequestParam String title,
			@RequestParam ArrayList<MultipartFile> photo,
			HttpServletRequest request) {
		ModelAndView mview= new ModelAndView();
		//업로드 실제경로 구하기
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/image");
		System.out.println(realPath);
		
		ArrayList<String>files=new ArrayList<String>();
		//파일명담기
		for(MultipartFile f:photo) {
			String fileName= f.getOriginalFilename();
			files.add(fileName);
			
			//업로드
			try {
				f.transferTo(new File(realPath + "\\" + fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mview.addObject("files", files);
		mview.addObject("title", title);
		mview.addObject("realPath", realPath);
		mview.setViewName("upload/uploadResult2");
		
		return mview;
	}
}
