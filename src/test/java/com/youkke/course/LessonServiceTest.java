package com.youkke.course;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.youkke.course.service.LessonService;
import com.youkke.course.web.LessonForm;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = YkcourseApplication.class)
public class LessonServiceTest {
	@Autowired
	private LessonService lessonService;
	
	@Before
	public void init() {
		LessonForm lessonForm = new LessonForm();
		lessonForm.setName("章节名称");
		lessonForm.setTitle("章节标题");
		String markdown = "### 主要特性"
				+ "  - 支持“标准”Markdown / CommonMark和Github风格的语法，也可变身为代码编辑器；"
				+ "	 - 支持实时预览、图片（跨域）上传、预格式文本/代码/表格插入、代码折叠、搜索替换、只读模式、自定义样式主题和多语言语法高亮等功能；";
		lessonForm.setMarkdown(markdown);
		lessonForm.setContent("test");
		lessonForm.setTags(new HashSet<String>(Arrays.asList("tag1","tag2")));
		lessonService.save("0042dd84ff4d4246a0e3d06095392a86", "8f0a9001ba9646ff8f4614688d7cb307", lessonForm);
	}
	
	@Test
	public void find() {
		LessonForm lessonForm = new LessonForm();
		lessonForm.setName("章节名称");
		lessonForm.setTitle("章节标题");
		String markdown = "### 主要特性"
				+ "  - 支持“标准”Markdown / CommonMark和Github风格的语法，也可变身为代码编辑器；"
				+ "	 - 支持实时预览、图片（跨域）上传、预格式文本/代码/表格插入、代码折叠、搜索替换、只读模式、自定义样式主题和多语言语法高亮等功能；";
		lessonForm.setMarkdown(markdown);
		lessonForm.setContent("test");
		lessonForm.setTags(new HashSet<String>(Arrays.asList("tag1","tag2")));
		lessonService.save("0042dd84ff4d4246a0e3d06095392a86", "8f0a9001ba9646ff8f4614688d7cb307", lessonForm);
	}
}
