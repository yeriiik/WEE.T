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
	
} // 
