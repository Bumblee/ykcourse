package com.youkke.course.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.youkke.course.domain.Lesson;
import com.youkke.utils.MyPage;

@Component
@Transactional
public class LessonDao extends BaseDao<Lesson> {
	private static final Logger log = LoggerFactory.getLogger(LessonDao.class);

	/**
	 * 课程下的第一级章节
	 * 
	 * @param courseid
	 * @param pagesize
	 * @param page
	 * @return
	 */
	public MyPage<Lesson> findByCourse(String courseid, int pagesize, int page) {
		log.debug("findByCourse");
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Lesson.class);
			dc.add(Property.forName("course.id").eq(courseid));
			dc.add(Property.forName("lesson").isNull());
			dc.addOrder(Order.asc("csort"));
			return this.findPageByCriteria(dc, pagesize, page);
		} catch (RuntimeException re) {
			log.error("findByCourse failed", re);
			throw re;
		}
	}

	/**
	 * 章节的子章节
	 * 
	 * @param pid
	 * @param pagesize
	 * @param page
	 * @return
	 */
	public MyPage<Lesson> findByPid(String pid, int pagesize, int page) {
		log.debug("findByPid");
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Lesson.class);
			dc.add(Property.forName("lesson.id").eq(pid));
			dc.addOrder(Order.asc("csort"));
			return this.findPageByCriteria(dc, pagesize, page);
		} catch (RuntimeException re) {
			log.error("findByPid failed", re);
			throw re;
		}
	}
	
	/**
	 * 章节的子章节 不分页
	 * @param pid
	 * @return
	 */
	public List<Lesson> findByPid(String pid) {
		log.debug("findByPid");
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Lesson.class);
			dc.add(Property.forName("lesson.id").eq(pid));
			dc.addOrder(Order.asc("csort"));
			return findAllByCriteria(dc);
		} catch (RuntimeException re) {
			log.error("findByPid failed", re);
			throw re;
		}
	}

	public Set<String> findIdsByCourse(String courseid) {
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Lesson.class);
			dc.setProjection(Property.forName("id"));
			dc.add(Property.forName("course.id").eq(courseid));
			Criteria criteria = dc.getExecutableCriteria(getSession());
			List<String> ids = criteria.list();
			return new HashSet<String>(ids);
		} catch (RuntimeException re) {
			log.error("findAll failed", re);
			throw re;
		}
	}

	public void save(Lesson transientInstance) {
		log.debug("saving Lesson instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Lesson persistentInstance) {
		log.debug("deleting Lesson instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void delete(String id) {
		log.debug("deleting Lesson by id");
		try {
			String sql = "delete from lesson where id=:id";
			Query<?> query = getSession().createNativeQuery(sql).setParameter("id", id);
			query.executeUpdate();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void deleteByCourse(String courseid) {
		log.debug("deleting Lesson by courseid");
		try {
			String sql = "delete from lesson where course=:courseid";
			Query<?> query = getSession().createNativeQuery(sql).setParameter("courseid", courseid);
			query.executeUpdate();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Lesson findById(java.lang.String id) {
		log.debug("getting Lesson instance with id: " + id);
		try {
			Lesson instance = (Lesson) getSession().get("com.youkke.course.domain.Lesson", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Lesson merge(Lesson lesson) {
		log.debug("merging Lesson instance");
		try {
			Lesson result = (Lesson) getSession().merge(lesson);
			getSession().flush();// 立即提交，避免新建社群递归不到整个树
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

}