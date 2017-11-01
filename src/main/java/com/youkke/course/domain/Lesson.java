package com.youkke.course.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.mapper.Mapper.Null;
import com.youkke.course.utils.Constant;
import com.youkke.utils.ID;
import com.youkke.utils.Time;

@Entity
@Table(name = "lesson")
public class Lesson implements Serializable {
	private static final long serialVersionUID = 5255664133410825880L;

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	private String id;

	private String userid;
	@Transient
	private User user;

	@JSONField(serialize = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course")
	@NotFound(action = NotFoundAction.IGNORE)
	private Course course;
	
	@JSONField(serialize = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lesson")
	@NotFound(action = NotFoundAction.IGNORE)
	private Lesson lesson;

	private String name;
	private String title;
	private String image;
	private String tag;
	private String markdown;
	private String content;
	private Integer csort;
	private String status;
	private Integer ilike;
	private Integer cmcount;
	private Integer sharecount;
	private Integer readcount;
	private String config;
	private Timestamp ctime;
	private String pid;

	public Lesson() {
	}
	
	public Lesson(String userid) {
		this.id = ID.uuid();
		this.csort = 1;
		this.status = Constant.NORMAL;
		this.ilike = 0;
		this.cmcount = 0;
		this.sharecount = 0;
		this.readcount = 0;
		this.ctime = Time.timestamp();
		this.userid = userid;
		
	}

	public Lesson(String userid, String name, String title, String image, String tag, String markdown, String content,String pid) {
		this.id = ID.uuid();
		this.csort = 1;
		this.status = Constant.NORMAL;
		this.ilike = 0;
		this.cmcount = 0;
		this.sharecount = 0;
		this.readcount = 0;
		this.ctime = Time.timestamp();
		this.userid = userid;
		this.name = name;
		this.title = title;
		this.image = image;
		this.tag = tag;
		this.markdown = markdown;
		this.content = content;
		this.pid = pid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getMarkdown() {
		return markdown;
	}

	public void setMarkdown(String markdown) {
		this.markdown = markdown;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCsort() {
		return csort;
	}

	public void setCsort(Integer csort) {
		this.csort = csort;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIlike() {
		return ilike;
	}

	public void setIlike(Integer ilike) {
		this.ilike = ilike;
	}

	public Timestamp getCtime() {
		return ctime;
	}

	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Integer getCmcount() {
		return cmcount;
	}

	public void setCmcount(Integer cmcount) {
		this.cmcount = cmcount;
	}

	public Integer getSharecount() {
		return sharecount;
	}

	public void setSharecount(Integer sharecount) {
		this.sharecount = sharecount;
	}

	public Integer getReadcount() {
		return readcount;
	}

	public void setReadcount(Integer readcount) {
		this.readcount = readcount;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}