package com.youkke.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.youkke.course.domain.Course;
import com.youkke.course.service.CourseService;
import com.youkke.utils.MyPage;

@Controller
public class IndexController extends BaseController {
	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public String index(Model model,
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "pagesize", defaultValue = "6", required = false) int pagesize,
			@RequestParam(value = "keyword", defaultValue = "", required = false) String keyword
			) {
		MyPage<Course> pages = courseService.findAll(page,pagesize,keyword);
		model.addAttribute("pages", pages);
		return "wxine";
	}
	
	@GetMapping("/markdown")
	public String markdown(){
		return "markdown";
	}
	
	@GetMapping("/content")
	public String content(){
		return "content";
	}
	
	@GetMapping("/template/{name}.html")
	public String wxine(Model model, @PathVariable(value="name") String name){
		return name;
	}

}
