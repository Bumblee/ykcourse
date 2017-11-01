package com.youkke.course.web;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.youkke.course.domain.Config;

public class LessonEditForm {
	
	@NotNull(message = "info.name.notnull")
	@Size(min = 3, message = "info.name.too_little")
	private String name;
	private String id;

	// TODO https://github.com/jirutka/validator-collection 增加集合较验
	private List<Config> configs;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Config> getConfigs() {
		return configs;
	}

	public void setConfigs(List<Config> configs) {
		this.configs = configs;
	}
}
