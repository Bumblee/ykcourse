package com.youkke.course.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Constant {
	
	public final static String NORMAL = "normal";	//正常

	// 权限
	public final static String PERMISSION_OWNER = "owner"; // 拥有者权限
	public final static String PERMISSION_ADMIN = "admin"; // 管理者权限
	public final static String PERMISSION_NORMAL = "normal";// 普通权限
	public final static String PERMISSION_BLACKLIST = "blacklist"; // 黑名单
	public final static String PERMISSION_NOSPEAK = "nospeak"; // 禁言
	public final static String PERMISSION_EXCLUDE = "exclude"; // 排除
	public final static String PERMISSION_VERIFY = "verify"; // 等待验证
	public final static String PERMISSION_FINISHED = "finished"; // 等待验证
	public final static String PERMISSION_FAILED = "failed"; // 等待验证
	// 权限

	// 分享范围：公开，私有，所有好友，指定好友，指定社群
	public final static Set<String> SCOPE = new HashSet<String>(
			Arrays.asList(new String[] { "public", "private", "friend", "friends", "communities" }));
	public final static String PUBLIC = "public";
	public final static String PRIVATE = "private";
	public final static String FRIEND = "friend";
	public final static String FRIENDS = "friends";
	public final static String COMMUNITIES = "communities";

	// 安全设置
	public final static Set<String> SECURITY = new HashSet<String>(
			Arrays.asList(new String[] { "comment_deny", "join_verify", "public", "deny" }));
	public final static String JOIN_VERIFY = "join_verify";// 加入需要验证
	public final static String DENY = "deny";// 拒绝任何人加入
	public final static String COMMENT_DENY = "comment_deny";
	public final static String FOLLOW_VERIFY = "follow_verify";
	/* public final static String ACCESS_DENY = "access_deny"; */

	// 社群状态
	public final static Set<String> COMMUNITY_STATUS = new HashSet<String>(
			Arrays.asList(new String[] { "normal", "trash" }));
	public final static String COMMUNITY_NORMAL = "normal"; // 正常
	public final static String COMMUNITY_TRASH = "trash";

	public final static String USER_TYPE_PERSONAL = "p";
	public final static String USER_TYPE_SHOP = "s";
	public final static String USER_TYPE_COMPANY = "c";
	
	public final static String USER_SEX_MALE = "male";
	public final static String USER_SEX_FEMALE = "female";
	
	public final static String YES = "yes";			//是
	public final static String NO = "no";			//否
}
