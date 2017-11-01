package com.youkke.course.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youkke.course.client.UserClient;
import com.youkke.course.dao.CourseDao;
import com.youkke.course.dao.LessonDao;
import com.youkke.course.domain.Course;
import com.youkke.course.domain.Lesson;
import com.youkke.course.web.LessonForm;
import com.youkke.course.web.LessonEditContentForm;
import com.youkke.course.web.LessonEditForm;
import com.youkke.utils.MyPage;
import com.youkke.utils.ServiceException;

@Service
@Transactional
public class LessonService {
	@Autowired
	private LessonDao lessonDao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private UserClient userClient;

	public void save(String sessuserid, String courseid, LessonForm lessonForm) {
		try {
			if (!StringUtils.isNotBlank(sessuserid))
				throw new ServiceException("user.require.login", "lesson");
			Course course = courseDao.findById(courseid);
			if (null != course && StringUtils.isNotBlank(course.getId())) {
				Lesson lesson = new Lesson(sessuserid);
				lesson.setCourse(course);
				BeanUtils.copyProperties(lessonForm, lesson, Lesson.class);
				lessonDao.save(lesson);
			} else {
				throw new ServiceException("course.not.exist", "lesson");
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void delete(String sessuserid, String id) {
		try {
			Lesson lesson = lessonDao.findById(id);
			if (!StringUtils.equals(lesson.getUserid(), sessuserid))
				throw new ServiceException("user.permission.deny", "lesson");
			lessonDao.delete(id);
			lessonDao.deleteByCourse(id);
		} catch (Exception e) {
			throw e;
		}
	}

	public Lesson findById(String sessuserid, String id) {
		try {
			Lesson lesson = lessonDao.findById(id);
			lesson.setUser(userClient.findById(lesson.getUserid()));
			return lesson;
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(String sessuserid, String id, LessonEditContentForm lessoneditcontentForm) {
		try {
			Lesson lesson = lessonDao.findById(id);
			if (!StringUtils.equals(lesson.getUserid(), sessuserid))
				throw new ServiceException("user.permission.deny", "lesson");
			BeanUtils.copyProperties(lessoneditcontentForm, lesson, Lesson.class);
			lessonDao.merge(lesson);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void updatebyname(String sessuserid, String id, LessonEditForm lessonUpdateForm) {
		try {
			Lesson lesson = lessonDao.findById(id);
			if (!StringUtils.equals(lesson.getUserid(), sessuserid))
				throw new ServiceException("user.permission.deny", "lesson");
			BeanUtils.copyProperties(lessonUpdateForm, lesson, Lesson.class);
			lessonDao.merge(lesson);
		} catch (Exception e) {
			throw e;
		}
	}

	public MyPage<Lesson> findByCourse(String courseid, int pagesize, int page) {
		try {
			return lessonDao.findByCourse(courseid, pagesize, page);
		} catch (Exception e) {
			throw e;
		}
	}

	public MyPage<Lesson> findByPid(String pid, int pagesize, int page) {
		try {
			return lessonDao.findByPid(pid, pagesize, page);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Lesson> findByPid(String pid) {
		try {
			return lessonDao.findByPid(pid);
		} catch (Exception e) {
			throw e;
		}
	}

}
