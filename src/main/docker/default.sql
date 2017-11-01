-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.1.19-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 ykcourse 的数据库结构
CREATE DATABASE IF NOT EXISTS `ykcourse` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ykcourse`;


-- 导出  表 ykcourse.course 结构
CREATE TABLE IF NOT EXISTS `course` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `userid` varchar(32) DEFAULT NULL COMMENT '所属账户',
  `syscateid` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `image` text,
  `tag` text COMMENT 'JSON属性',
  `markdown` longtext COMMENT 'MD原文',
  `content` longtext COMMENT '详细内容',
  `csort` int(11) DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `ilike` int(11) NOT NULL,
  `cmcount` int(11) NOT NULL,
  `sharecount` int(11) NOT NULL,
  `readcount` int(11) NOT NULL,
  `config` varchar(255) DEFAULT NULL,
  `ctime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';

-- 正在导出表  ykcourse.course 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`id`, `userid`, `syscateid`, `type`, `name`, `title`, `image`, `tag`, `markdown`, `content`, `csort`, `status`, `ilike`, `cmcount`, `sharecount`, `readcount`, `config`, `ctime`) VALUES
	('018b50a5756e4c80895353c6d38da6b3', '0042dd84ff4d4246a0e3d06095392a86', NULL, NULL, 'gttr', NULL, NULL, NULL, '### 主要特性  - 支持“标准”Markdown / CommonMark和Github风格的语法，也可变身为代码编辑器； - 支持实时预览、图片（跨域）上传、预格式文本/代码/表格插入、代码折叠、搜索替换、只读模式、自定义样式主题和多语言语法高亮等功能；', NULL, 1, 'normal', 0, 0, 0, 0, NULL, '2017-03-08 12:44:00'),
	('94db7b6829594789b22693ff6f2915c8', '0042dd84ff4d4246a0e3d06095392a86', NULL, NULL, '课程名称', '课程标题', NULL, NULL, '### 主要特性  - 支持“标准”Markdown / CommonMark和Github风格的语法，也可变身为代码编辑器；	 - 支持实时预览、图片（跨域）上传、预格式文本/代码/表格插入、代码折叠、搜索替换、只读模式、自定义样式主题和多语言语法高亮等功能；', 'test', 1, 'normal', 0, 0, 0, 0, NULL, '2017-03-03 11:31:10'),
	('ab704c32a8a44fe99e92a2e821e82b03', '0042dd84ff4d4246a0e3d06095392a86', NULL, NULL, '支持“标准”Markdown / CommonMark和Gith', NULL, NULL, NULL, '### 主要特性\r\n\r\n- 支持“标准”Markdown / CommonMark和Github风格的语法，也可变身为代码编辑器；\r\n- 支持实时预览、图片（跨域）上传、预格式文本/代码/表格插入、代码折叠、搜索替换、只读模式、自定义样式主题和多语言语法高亮等功能；\r\n- 支持ToC（Table of Contents）、Emoji表情、Task lists、@链接等Markdown扩展语法；\r\n- 支持TeX科学公式（基于KaTeX）、流程图 Flowchart 和 时序图 Sequence Diagram;\r\n- 支持识别和解析HTML标签，并且支持自定义过滤标签解析，具有可靠的安全性和几乎无限的扩展性；\r\n- 支持 AMD / CMD 模块化加载（支持 Require.js & Sea.js），并且支持自定义扩展插件；\r\n- 兼容主流的浏览器（IE8+）和Zepto.js，且支持iPad等平板设备；\r\n- 支持自定义主题样式；\r\n\r\n# Editor.md', NULL, 1, 'normal', 0, 0, 0, 0, NULL, '2017-03-08 13:10:40'),
	('d609a82d41c54c35a754be85a21bbe3e', '0042dd84ff4d4246a0e3d06095392a86', NULL, NULL, '课程名称', '课程标题', NULL, NULL, '### 主要特性  - 支持“标准”Markdown / CommonMark和Github风格的语法，也可变身为代码编辑器；	 - 支持实时预览、图片（跨域）上传、预格式文本/代码/表格插入、代码折叠、搜索替换、只读模式、自定义样式主题和多语言语法高亮等功能；', 'test', 1, 'normal', 0, 0, 0, 0, NULL, '2017-03-03 11:31:10');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


-- 导出  表 ykcourse.lesson 结构
CREATE TABLE IF NOT EXISTS `lesson` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `userid` varchar(32) DEFAULT NULL COMMENT '所属账户',
  `course` varchar(32) DEFAULT NULL COMMENT '群组',
  `lesson` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `image` text,
  `tag` text COMMENT 'JSON属性',
  `markdown` longtext COMMENT 'MD原文',
  `content` longtext COMMENT '详细内容',
  `csort` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `ilike` int(11) NOT NULL,
  `cmcount` int(11) NOT NULL,
  `sharecount` int(11) NOT NULL,
  `readcount` int(11) NOT NULL,
  `config` varchar(255) DEFAULT NULL,
  `ctime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业组织';

-- 正在导出表  ykcourse.lesson 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` (`id`, `userid`, `course`, `lesson`, `name`, `title`, `image`, `tag`, `markdown`, `content`, `csort`, `status`, `ilike`, `cmcount`, `sharecount`, `readcount`, `config`, `ctime`) VALUES
	('26a8b6ca98894ebd8edfa160d90bb2de', '0042dd84ff4d4246a0e3d06095392a86', 'ab704c32a8a44fe99e92a2e821e82b03', NULL, 'Android开发周报：Android Messages上线、App快速运维交付实践', NULL, NULL, NULL, '新闻\r\n\r\n《谷歌发福利：谷歌助手下放到Android 6.0》：北京时间2月26日消息，谷歌推出的Android旗舰手机Pixel集成了谷歌诸多新功能，而且还是独占的。不过这也让谷歌自己有点头疼，因为Pixel用户有限，并不能很好的推广谷歌一些新功能，如谷歌助手（Google Assistant）等服务。\r\n\r\n《折腾了十年安卓版的“iMessage”终于诞生》：近日，谷歌Play商店上线了 “Android Messages”，中文名“Android信息”。明眼人一瞧就知道这是干什么的。没错，它正是谷歌效仿苹果在iOS上推出iMessage的做法，开发的安卓平台御用短信软件。\r\n\r\n《Android成重灾区，恶意软件攻击一年增长50%》：如今的手机是我们每天都必备、必用的科技产品，而手机中也存储着大量的个人隐私信息，这也就让手机成为了网络犯罪分子攻击的目标。近日，安全公司ESET的报告显示针对Android操作系统的恶意攻击仅去年就增长了超过50%。\r\n\r\n教程\r\n\r\n《Android权限机制与适配经验》：Android M已经发布一段时间了，市面上很多应用都已经适配Android M。权限机制，作为Android M的一大特性，受到了很多开发者的关注。本文主要分享了以下几个知识点的内容，1、Android权限机制关键知识点；2、QQ音乐对于权限的适配经验；3、近段时间以来遇到的一些Android权限方面的问题。\r\n\r\n《蘑菇街Android客户端HotFix探索之路》：本文是一篇介绍Hotfix的文章，文章详细介绍了HotFix的发展历史，并且比对了不同时期各种方案的详情。文章后半部分详细介绍了蘑菇街自研方案Aceso的优缺点。Aceso有2个比较明显的好处，一个是下载即生效，另外一个是兼容性好，由于是使用ASM注入的方式，有希望1，2年内都不用再跟在Google后面做兼容性适配了。\r\n\r\n《手机淘宝：亿级用户APP的快速运维交付实践》：很少有公司会有App运维这个岗位，移动客户端运维这块，大部分公司应该都是研发工程师自己在做。不过像阿里这样几乎每天都有版本迭代的公司，App运维是很必要。本文作者比较关注移动化运维的事情，文章围绕手淘APP的运维交付实践进行了详细介绍。\r\n\r\n《安居客Android项目架构演进》：作者入职安居客后，在业务上刚完成了三网合并（新房、二手房、好租和商业地产多个平台多个网站合成现在的版本，这在公司历史上称之为三网合并），因此app端也将原先的新房、二手房、好租和商业地产多个app合并成为了现在的安居客app。本文详细介绍了几年来安居客的架构演进。\r\n\r\n《深度了解Android 7.0 ，你准备好了吗？》：2016年8月22日，谷歌正式推送Android 7.0 Nougat（牛轧糖）正式版，首发推送了多款Nexus设备。除了修复常规BUG，Android 7.0还新增了分屏、新的Notification、VR支持等新特性。本文对Android 7.0的新特性进行了详解说明。\r\n\r\n《Google VR for Android敲门》：虚拟现实（Virtual Reality）技术是一种可以创建和体验虚拟世界的计算机仿真系统，最近几年虚拟现实概念很火，技术上也有很多突破。Google、苹果等顶级互联网公司都进行了大手笔的投入。本文是一篇介绍如何在Android手机上运行、开发VR程序的基础教程。\r\n\r\n开源项目\r\n\r\nThinRPlugin：hinR插件在编译时将除R$styleable.class以外的所有R.class删除掉，并且在引用的地方替换成对应的常量，从而达到缩减包大小和减少dex个数的效果。该插件已经在蘑菇街app上使用，将包大小降低1mb（原包大小40mb）,dex数量减少3个。\r\n\r\nAceso：Aceso是基于Instant Run Hot Swap的Android热修复方案，使用它你能在不用重新发布版本的情况下对线上app的bug进行修复。\r\n\r\nAndroid-skin-support：Android-skin-support: 一款Android换肤框架，极低的学习成本， 极好的用户体验。只需要两行代码，就可以实现换肤。\r\n\r\nShuttle：这是一款开源的本地音乐播放器。\r\n\r\n感谢徐川对本文的审校。', NULL, 1, 'normal', 0, 0, 0, 0, NULL, '2017-03-08 13:26:03'),
	('2f6f3c721669453fa912986fe013c914', '0042dd84ff4d4246a0e3d06095392a86', 'ab704c32a8a44fe99e92a2e821e82b03', NULL, 'Deeplearning4j：如何建设深度学习开源社区', NULL, NULL, NULL, 'Deeplearning4j是第一个为 Java和 Scala编写的商业级、开源、分布式神经网络库，它是 Gitter上最活跃的社区之一。 Gitter采访了 Deeplearning4j的创始人Adam和 Chris，分享了他们在开源社区建设方面的想法、经验和教训。本访谈内容可以在 Gitter上的 deeplearning4j频道观看。\r\n\r\nGitter的数字战略和成长顾问 Ola Kohut日前写了这篇采访录，经Gitter授权， InfoQ翻译并分享。\r\n\r\n能否为我们介绍一下您自己和 Deeplearning4j社区？还有社区是怎么起步的？\r\n\r\n我们在2013年年底就开始构建 Deeplearning4j。那时 Adam已经参与机器学习大约有四年左右，当时，深度人工神经网络看上去前景一片光明。 Deeplearning4j的第一个网络是受限玻尔兹曼机，这是 Geoff Hinton在2006年提出的网络，这个领域的转折点。当时我正在另一家创业公司负责公关和招聘。以前我曾做过记者，因此我负责维护文档的工作（现在仍然也在做），因为我们相信，让开源代码具有价值的关键就是适当的沟通。\r\n\r\n他们在 Deeplearning4j频道中讨论的主要问题是什么？\r\n\r\n以前主要问题是关于安装方面。社区的工程师教会了我们很多东西，比如关于如何编写更清晰的指令以及如何使代码和体验变得更好，如果我们没有反馈环路的话， Deeplearning4j的情况就会变得更糟。作为质量控制，开源社区真的很了不起！你解决问题越早，那么这个问题从社区被提到的要求就越少。这极大地激励着我们迅速行动。\r\n\r\n现在主要问题是关于数据的加载和神经网络的优化。我们正在努力进行更好的沟通，并使框架做得更好，以便使 ETL和优化变得更加容易。最后，很多都是关于机器学习和深度学习的基本问题。许多软件工程师已经意识到，深度学习和机器学习是真正强大的工具，因此他们努力领会这些新想法。为此，我们编写了许多介绍性材料，并链接到解释这些想法的网页。', NULL, 1, 'normal', 0, 0, 0, 0, NULL, '2017-03-08 13:24:41'),
	('6eb731551590480a92a4aa8da108ab1f', '0042dd84ff4d4246a0e3d06095392a86', NULL, NULL, '章节名称', '章节标题', NULL, NULL, '### 主要特性  - 支持“标准”Markdown / CommonMark和Github风格的语法，也可变身为代码编辑器；	 - 支持实时预览、图片（跨域）上传、预格式文本/代码/表格插入、代码折叠、搜索替换、只读模式、自定义样式主题和多语言语法高亮等功能；', 'test', 1, 'normal', 0, 0, 0, 0, NULL, '2017-03-03 11:35:00'),
	('d5b0eb71e1914ee28297807c87139f91', '0042dd84ff4d4246a0e3d06095392a86', NULL, NULL, '章节名称', '章节标题', NULL, NULL, '### 主要特性  - 支持“标准”Markdown / CommonMark和Github风格的语法，也可变身为代码编辑器；	 - 支持实时预览、图片（跨域）上传、预格式文本/代码/表格插入、代码折叠、搜索替换、只读模式、自定义样式主题和多语言语法高亮等功能；', 'test', 1, 'normal', 0, 0, 0, 0, NULL, '2017-03-03 11:35:00');
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
