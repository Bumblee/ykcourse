package com.youkke.course.service;

import java.io.Console;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youkke.course.client.UserClient;
import com.youkke.course.dao.CourseDao;
import com.youkke.course.dao.LessonDao;
import com.youkke.course.domain.Course;
import com.youkke.course.web.CourseForm;
import com.youkke.utils.MyPage;
import com.youkke.utils.ServiceException;

@Service
@Transactional
public class CourseService {
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private LessonDao lessonDao;
	@Autowired
	private UserClient userClient;

	public void save(String sessuserid, CourseForm courseForm) {
		try {
			if (!StringUtils.isNotBlank(sessuserid))
				throw new ServiceException("user.require.login", "course");
			Course course = new Course(sessuserid);
			BeanUtils.copyProperties(courseForm, course, Course.class);
			courseDao.save(course);
		} catch (Exception e) {
			throw e;
		}
	}

	public void delete(String sessuserid, String id) {
		try {
			Course course = courseDao.findById(id);
			if (!StringUtils.equals(course.getUserid(), sessuserid))
				throw new ServiceException("user.permission.deny", "course");
			courseDao.delete(id);
			lessonDao.deleteByCourse(id);
		} catch (Exception e) {
			throw e;
		}
	}

	public Course findById(String sessuserid, String id) {
		try {
			Course course = courseDao.findById(id);
			course.setUser(userClient.findById(course.getUserid()));
			return course;
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(String sessuserid, String id, CourseForm courseForm) {
		try {
			Course course = courseDao.findById(id);
			if (!StringUtils.equals(course.getUserid(), sessuserid))
				throw new ServiceException("user.permission.deny", "course");
			BeanUtils.copyProperties(courseForm, course, Course.class);
			courseDao.merge(course);
		} catch (Exception e) {
			throw e;
		}
	}

	private String userid;
	private Set<String> syscates;
	private Set<String> tags;
	private Set<String> statuses;
	private String orderfield;
	private String direction;

	public MyPage<Course> findAll(int page,int pagesize,String keyword) {
		try {
			return courseDao.findAll(userid, syscates, tags, statuses, keyword, orderfield, direction, pagesize, page);
		} catch (Exception e) {
			throw e;
		}
	}

	public MyPage<Course> findAll(String userid, String t, Set<String> syscates, Set<String> tags, Set<String> statuses,
			String keyword, String orderfield, String direction, int pagesize, int page) {
		try {
			return courseDao.findAll(userid, syscates, tags, statuses, keyword, orderfield, direction, pagesize, page);
		} catch (Exception e) {
			throw e;
		}
	}

}
