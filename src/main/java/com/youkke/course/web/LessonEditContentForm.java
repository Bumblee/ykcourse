package com.youkke.course.web;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.youkke.course.domain.Config;

public class LessonEditContentForm {
	
	private String title;
	private String image;
	private Set<String> tags;

	//@NotNull(message = "info.markdown.notnull")
	//@Size(min = 3, message = "info.markdown.too_little")
	private String markdown;

	//@NotNull(message = "info.content.notnull")
	//@Size(min = 3, message = "info.content.too_little")
	private String content;

	// TODO https://github.com/jirutka/validator-collection 增加集合较验
	private List<Config> configs;


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

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
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

	public List<Config> getConfigs() {
		return configs;
	}

	public void setConfigs(List<Config> configs) {
		this.configs = configs;
	}
}
