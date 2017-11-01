package com.youkke.course.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.youkke.course.domain.Course;
import com.youkke.course.domain.Lesson;
import com.youkke.course.service.CourseService;
import com.youkke.course.service.LessonService;
import com.youkke.utils.MyPage;

@Controller
public class CourseController extends BaseController {
	@Autowired
	private CourseService courseService;
	@Autowired
	private LessonService lessonService;
	
	/**
	 * 表单创建课程，
	 * @param courseForm
	 * @return
	 */
	@PostMapping("/course")
	@ResponseBody
	public Map<String, Object> create(@Valid CourseForm courseForm) {
		Map<String, Object> map = new HashMap<String, Object>();
		courseService.save(sessuserid, courseForm);
		map.put("result", "success");
		return map;
	}

	/**
	 * 表单删除 Post一个课程id和用户id，通过用户id验证权限后才能删除
	 * @param id
	 * @return
	 */
	@PostMapping("/course/{id}/delete")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		courseService.delete(sessuserid, id);
		map.put("result", "success");
		return map;
	}
	
	/**
	 * 传入一个课程id，进入课程章节内容
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/course/{id}")
	public String get(Model model, @PathVariable String id) {
		Course course = courseService.findById(sessuserid, id);
		model.addAttribute("course", course);
		MyPage<Lesson> pages = lessonService.findByCourse(id, pagesize, page);
		model.addAttribute("lessons", pages);
		return "course_view";
	}

	/**
	 * 传入一个课程id，对当前id下的表单进行修改后提交
	 * @param id
	 * @param courseForm
	 * @return
	 */
	@PostMapping("/course/{id}")
	@ResponseBody
	public Map<String, Object> update(@PathVariable String id, @Valid CourseForm courseForm) {
		Map<String, Object> map = new HashMap<String, Object>();
		courseService.update(sessuserid, id, courseForm);
		map.put("result", "success");
		return map;
	}
	/**
	 * 通过课程id找到数据，用model打包到页面显示
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/course/{id}/edit")
	public String update(@PathVariable String id, Model model){
		model.addAttribute("course", courseService.findById(sessuserid, id));
		return "course_edit";
	}

}
