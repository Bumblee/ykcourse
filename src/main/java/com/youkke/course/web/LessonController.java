package com.youkke.course.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang.ObjectUtils.Null;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.youkke.course.domain.Course;
import com.youkke.course.domain.Lesson;
import com.youkke.course.service.CourseService;
import com.youkke.course.service.LessonService;
import com.youkke.utils.MyPage;

@Controller
public class LessonController extends BaseController {
	@Autowired
	private LessonService lessonService;
	@Autowired
	private CourseService courseService;
	
	/**
	 * 表单创建章节
	 * @param courseid
	 * @param lessonForm
	 * @return
	 */
	@PostMapping("/course/{courseid}/lesson")
	@ResponseBody
	public Map<String, Object> create(@PathVariable String courseid,  @Valid LessonForm lessonForm) {
		Map<String, Object> map = new HashMap<String, Object>();
		lessonService.save(sessuserid, courseid,  lessonForm);
		map.put("result", "success");
		return map;
	}
	/**
	 * 表单删除 Post一个课程id，章节id和用户id，通过用户id验证权限后才能删除
	 * @param id
	 * @return
	 */
	@PostMapping("/course/{courseid}/lesson/{id}/delete")
	@ResponseBody
	public Map<String, Object> delete(@PathVariable String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		lessonService.delete(sessuserid, id);
		map.put("result", "success");
		return map;
	}
	/**
	 * 传入一个课程id和章节的id，进入章节详细内容
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/course/{courseid}/lesson/{id}")
	public String get(Model model, @PathVariable String id) {
		Lesson lesson = lessonService.findById(sessuserid, id);
		model.addAttribute("lesson", lesson);
		return "lesson";
	}
	/**
	 * 传入一个课程的id，所有章节的list,对所有章节的名字进行修改和最后一个文本框如有内容就创建
	 * @param courseid
	 * @param lessons
	 * @param lessonForm
	 * @return
	 */
	@PostMapping("/course/{courseid}/lessons/edit")
	@ResponseBody
	public Map<String, Object> updatebyname(@PathVariable String courseid, LessonEditList lessons,LessonForm lessonForm) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(null != lessons.getLessons() && lessons.getLessons().size()!=0){
			for(LessonEditForm s : lessons.getLessons()){
				if(null!=s.getId()){
					lessonService.updatebyname(sessuserid,s.getId(),s);
				}
			}
		}
		if(null!=lessonForm.getName() && lessonForm.getName()!=""){
			lessonService.save(sessuserid, courseid, lessonForm);
		}
		map.put("result", "success");
		return map;
	}
	
	/**
	 * 传入一个课程id，获取章节的所有名字并显示在文本框里
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/lessons/{id}/edit")
	public String getupdate(Model model, @PathVariable String id) {
		Course course = courseService.findById(sessuserid, id);
		model.addAttribute("course", course);
		MyPage<Lesson> pages = lessonService.findByCourse(id, pagesize, page);
		model.addAttribute("lessons", pages);
		return "lessons_edit";
	}
	
	
	/**
	 * 传入一个课程id和章节id，显示当下id下的章节的详细内容
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/course/{courseid}/lesson/{id}/edit/content")
	public String update(@PathVariable String id, Model model){
		model.addAttribute("lesson", lessonService.findById(sessuserid, id));
		return "lesson_edit_content";
	}
	/**
	 * 传入一个课程id和章节id，对当前章节的详细内进行修改
	 * @param id
	 * @param lessoneditcontentForm
	 * @return
	 */
	@PostMapping("/course/{courseid}/lesson/{id}")
	@ResponseBody
	public Map<String, Object> update(@PathVariable String id, @Valid LessonEditContentForm lessoneditcontentForm) {
		Map<String, Object> map = new HashMap<String, Object>();
		lessonService.update(sessuserid, id, lessoneditcontentForm);
		map.put("result", "success");
		return map;
	}
	

}
