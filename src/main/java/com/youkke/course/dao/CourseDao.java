package com.youkke.course.dao;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.youkke.course.domain.Course;
import com.youkke.utils.MyPage;

@Component
@Transactional
public class CourseDao extends BaseDao<Course> {
	private static final Logger log = LoggerFactory.getLogger(CourseDao.class);

	public Course findByPhrase(String phrase) {
		log.debug("getting Course instance with phrase: " + phrase);
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Course.class);
			dc.add(Property.forName("phrase").eq(phrase));
			List<Course> categorys = findAllByCriteria(dc);
			try {
				return categorys.get(0);
			} catch (Exception e) {
				return null;
			}
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public MyPage<Course> findAll(String userid, Set<String> syscates, Set<String> tags, Set<String> statuses,
			String keyword, String orderfield, String direction, int pagesize, int page) {
		log.debug("findAll");
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(Course.class);

			if (StringUtils.isNotBlank(userid)) {
				dc.add(Property.forName("userid").eq(userid));
			}

			if (null != syscates && syscates.size() > 0) {
				Disjunction dis = Restrictions.disjunction();
				for (String category : syscates) {
					dis.add(Property.forName("syscate").like(category, MatchMode.ANYWHERE));
				}
				dc.add(dis);
			}

			if (null != tags && tags.size() > 0) {
				Disjunction dis = Restrictions.disjunction();
				for (String tag : tags) {
					dis.add(Property.forName("tag").like(tag, MatchMode.ANYWHERE));
				}
				dc.add(dis);
			}

			if (null != statuses && statuses.size() > 0) {
				Disjunction dis = Restrictions.disjunction();
				for (String status : statuses) {
					dis.add(Property.forName("status").like(status, MatchMode.ANYWHERE));
				}
				dc.add(dis);
			}

			if (StringUtils.isNotBlank(keyword)) {
				Disjunction dis = Restrictions.disjunction();
				dis.add(Property.forName("title").like(keyword, MatchMode.ANYWHERE));
				dis.add(Property.forName("name").like(keyword, MatchMode.ANYWHERE));
				dis.add(Property.forName("content").like(keyword, MatchMode.ANYWHERE));
				dc.add(dis);
			}

			if (StringUtils.equals(orderfield, "csort")) {
				if (StringUtils.equals(direction, "desc")) {
					dc.addOrder(Order.desc("csort"));
				} else {
					dc.addOrder(Order.asc("csort"));
				}
			} else if (StringUtils.equals(orderfield, "hot")) {
				if (StringUtils.equals(direction, "desc")) {
					dc.addOrder(Order.desc("readcount"));
					dc.addOrder(Order.desc("cmcount"));
					dc.addOrder(Order.desc("sharecount"));
					dc.addOrder(Order.desc("ilike"));
				} else {
					dc.addOrder(Order.asc("readcount"));
					dc.addOrder(Order.asc("cmcount"));
					dc.addOrder(Order.asc("sharecount"));
					dc.addOrder(Order.asc("ilike"));
				}
			} else {
				if (StringUtils.equals(direction, "asc")) {
					dc.addOrder(Order.asc("ctime"));
				} else {
					dc.addOrder(Order.desc("ctime"));
				}
			}
			dc.addOrder(Order.desc("ctime"));

			try {
				if (pagesize <= 0) {
					pagesize = 20;
				}
			} catch (Exception e) {
			}

			return findPageByCriteria(dc, pagesize, page);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public void save(Course transientInstance) {
		log.debug("saving Course instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Course persistentInstance) {
		log.debug("deleting Course instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void delete(String id) {
		log.debug("deleting Course by id");
		try {
			String sql = "delete from course where id=:id";
			Query<?> query = getSession().createNativeQuery(sql).setParameter("id", id);
			query.executeUpdate();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Course findById(java.lang.String id) {
		log.debug("getting Course instance with id: " + id);
		try {
			Course instance = (Course) getSession().get("com.youkke.course.domain.Course", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Course merge(Course course) {
		log.debug("merging Course instance");
		try {
			Course result = (Course) getSession().merge(course);
			getSession().flush();// 立即提交，避免新建社群递归不到整个树
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

}