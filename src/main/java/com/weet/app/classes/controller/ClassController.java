package com.weet.app.classes.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weet.app.classes.domain.ClassVO;
import com.weet.app.classes.domain.Criteria;
import com.weet.app.classes.domain.PageMakerDTO;
import com.weet.app.classes.service.ClassService;
import com.weet.app.exception.ControllerException;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor

@RequestMapping("/class/")
@Controller
public class ClassController {
	
	private ClassService classService;
	
//	클래스 목록 페이지 (페이징처리 / 검색처리) --------------------------------
	@GetMapping("/search")
	public String searchClass(Model model, Criteria cri) throws ControllerException {
		log.trace("searchClass() invoked.");
		
		try {
			model.addAttribute("_LIST_ALL_", classService.getClassPaging(cri));
			
			int total = classService.getTotal(cri);
			
			// 페이징 처리
			PageMakerDTO pageMake = new PageMakerDTO(cri, total);
			model.addAttribute("pageMaker", pageMake);
			
		} catch(Exception e) {
			throw new ControllerException(e);
		} //try-catch
		
		return "/class/classSearch";
	} // searchClass

	
// ================================================================================== //
	
//	메인페이지-> +더보기(추천 클래스) --------------------------------
	@GetMapping("/search/recommend")
	public String searchClassRecommend(Model model, Criteria cri) throws ControllerException {
		log.trace("searchClassRecommend() invoked.");
		
		try {
			List<ClassVO> listAll = this.classService.getListRecommendAll();
			model.addAttribute("_LIST_ALL_", listAll);
		} catch(Exception e) {
			throw new ControllerException(e);
		} //try-catch
		
		return "/class/classSearch";
	} // searchClass
	
//	메인페이지-> +더보기(마감임박 클래스) --------------------------------
	@GetMapping("/search/end")
	public String searchClassEnd(Model model, Criteria cri) throws ControllerException {
		log.trace("searchClassEnd() invoked.");
		
		try {
			List<ClassVO> listAll = this.classService.getListEndAll();
			model.addAttribute("_LIST_ALL_", listAll);
		} catch(Exception e) {
			throw new ControllerException(e);
		} //try-catch
		
		return "/class/classSearch";
	} // searchClass
	
//	메인페이지-> +더보기(신규 클래스) --------------------------------
	@GetMapping("/search/new")
	public String searchClassNew(Model model, Criteria cri) throws ControllerException {
		log.trace("searchClassNew() invoked.");
		
		try {
			List<ClassVO> listAll = this.classService.getListNewAll();
			model.addAttribute("_LIST_ALL_", listAll);
		} catch(Exception e) {
			throw new ControllerException(e);
		} //try-catch
		
		return "/class/classSearch";
	} // searchClass
	
	
// 클래스 등록 ================================================================================== //	
	
//	클래스 등록 시작 페이지 ---------------------------
	@GetMapping("/reg")
	public String classRegPage() {
		log.trace("classRegPage() invoked.");
		
		return "/class/reg";
	} // classRegPage
	

//	---------------------------------------------------
	@GetMapping("/reg/1")
	public String classReg1Page() {
		log.trace("classReg1Page() invoked.");
		
		return "/class/reg1";
	} // classReg1Page
	
	@PostMapping("/reg/1")
	public String classReg1(@RequestParam("classType") String classType, 
			@RequestParam("classTitle") String classTitle,
			@RequestParam("classIntro") String classIntro,
			@RequestParam("classVideoUrl") String classVideoUrl,
			HttpServletRequest request) {
		log.trace("classReg1() invoked.");
		
		HttpSession session = request.getSession();
		session.setAttribute("classType", classType);
		session.setAttribute("classTitle", classTitle);
		session.setAttribute("classIntro", classIntro);
		session.setAttribute("classVideoUrl", classVideoUrl);
		
		return "redirect:/class/reg/2";
	} // classReg1
	
	
//	---------------------------------------------------
	@GetMapping("/reg/2")
	public String classReg2Page() {
		log.trace("classReg2Page() invoked.");
		
		return "/class/reg2";
	} // classReg2Page
	
	@PostMapping("/reg/2")
	public String classReg2() {
		log.trace("classReg2() invoked.");
		
		return "/class/reg2";
	} // classReg2
	
	
//	---------------------------------------------------
	@GetMapping("/reg/3")
	public String classReg3Page() {
		log.trace("classReg3Page() invoked.");
		
		return "/class/reg3";
	} // classReg3Page
	
	@PostMapping("/reg/3")
	public String classReg3() {
		log.trace("classReg3() invoked.");
		
		return "/class/reg3";
	} // classReg3
	
	
//	---------------------------------------------------
	@GetMapping("/reg/4")
	public String classReg4Page() {
		log.trace("classReg4Page() invoked.");
		
		return "/class/reg4";
	} // classReg4Page
	
	@PostMapping("/reg/4")
	public String classReg4() {
		log.trace("classReg4() invoked.");
		
		return "/class/reg5";
	} // classReg4
	
	
//	클래스 등록 완료 페이지 ---------------------------
	@GetMapping("/reg/fin")
	public String classRegFin() {
		log.trace("classRegFin() invoked.");
		
		return "/class/regFin";
	}
}
