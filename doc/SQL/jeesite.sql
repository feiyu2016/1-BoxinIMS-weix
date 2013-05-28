/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.8 : Database - jeesite
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jeesite` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jeesite`;

/*Table structure for table `cms_article` */

DROP TABLE IF EXISTS `cms_article`;

CREATE TABLE `cms_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `category_id` bigint(20) NOT NULL COMMENT '分类编号',
  `user_id` bigint(20) NOT NULL COMMENT '发布者',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `color` varchar(50) DEFAULT '' COMMENT '标题颜色（red：红色；green：绿色；blue：蓝色；yellow：黄色；orange：橙色）',
  `thumb` varchar(255) DEFAULT '' COMMENT '缩略图',
  `keywords` varchar(255) DEFAULT '' COMMENT '关键字',
  `desciption` varchar(255) DEFAULT '' COMMENT '描述、摘要',
  `status` char(1) DEFAULT '' COMMENT '状态（0：发布；1：作废；2：审核；）',
  `weight` int(11) DEFAULT '0' COMMENT '权重，越大越靠前',
  `hits` int(11) DEFAULT '0' COMMENT '点击数',
  `posid` varchar(10) DEFAULT NULL COMMENT '推荐位，多选（1：首页焦点图；2：栏目页文章推荐；）',
  `input_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `title` (`title`),
  KEY `keywords` (`keywords`),
  KEY `status` (`status`),
  KEY `weight` (`weight`),
  KEY `input_date` (`input_date`),
  KEY `update_date` (`update_date`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='内容管理文章模型表';

/*Data for the table `cms_article` */

insert  into `cms_article`(`id`,`category_id`,`user_id`,`title`,`color`,`thumb`,`keywords`,`desciption`,`status`,`weight`,`hits`,`posid`,`input_date`,`update_date`) values (1,3,1,'文章标题标题标题标题','green','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(2,3,1,'文章标题标题标题标题','red','','关键字1,关键字2','','0',0,3,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(3,3,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,2,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(4,3,1,'文章标题标题标题标题','green','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(5,3,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(6,3,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(7,4,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(8,4,1,'文章标题标题标题标题','blue','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(9,4,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,1,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(10,4,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(11,5,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,1,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(12,5,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(13,5,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(14,7,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(15,7,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,1,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(16,7,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(17,7,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(18,8,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,1,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(19,8,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(20,8,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(21,8,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(22,9,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(23,9,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(24,9,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(25,9,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(26,9,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(27,11,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(28,11,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(29,11,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(30,11,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(31,11,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(32,12,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(33,12,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(34,12,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(35,12,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(36,12,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(37,13,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(38,13,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(39,13,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(40,13,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(41,14,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(42,14,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(43,14,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(44,14,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(45,14,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(46,15,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(47,15,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(48,15,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(49,16,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(50,17,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(51,17,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(52,26,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00'),(53,26,1,'文章标题标题标题标题','','','关键字1,关键字2','','0',0,0,'','2013-05-15 13:20:11','2012-10-07 00:00:00');

/*Table structure for table `cms_article_data` */

DROP TABLE IF EXISTS `cms_article_data`;

CREATE TABLE `cms_article_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `content` mediumtext COMMENT '内容',
  `copyfrom` varchar(255) DEFAULT NULL COMMENT '来源',
  `relation` varchar(255) DEFAULT NULL COMMENT '相关文章',
  `allow_comment` char(1) DEFAULT NULL COMMENT '是否允许评论',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='内容管理文章模型表';

/*Data for the table `cms_article_data` */

insert  into `cms_article_data`(`id`,`content`,`copyfrom`,`relation`,`allow_comment`) values (1,'文章内容内容内容内容','来源','1,2,3','1'),(2,'文章内容内容内容内容','来源','1,2,3','1'),(3,'文章内容内容内容内容','来源','1,2,3','1'),(4,'文章内容内容内容内容','来源','1,2,3','1'),(5,'文章内容内容内容内容','来源','1,2,3','1'),(6,'文章内容内容内容内容','来源','1,2,3','1'),(7,'文章内容内容内容内容','来源','1,2,3','1'),(8,'文章内容内容内容内容','来源','1,2,3','1'),(9,'文章内容内容内容内容','来源','1,2,3','1'),(10,'文章内容内容内容内容','来源','1,2,3','1'),(11,'文章内容内容内容内容','来源','1,2,3','1'),(12,'文章内容内容内容内容','来源','1,2,3','1'),(13,'文章内容内容内容内容','来源','1,2,3','1'),(14,'文章内容内容内容内容','来源','1,2,3','1'),(15,'文章内容内容内容内容','来源','1,2,3','1'),(16,'文章内容内容内容内容','来源','1,2,3','1'),(17,'文章内容内容内容内容','来源','1,2,3','1'),(18,'文章内容内容内容内容','来源','1,2,3','1'),(19,'文章内容内容内容内容','来源','1,2,3','1'),(20,'文章内容内容内容内容','来源','1,2,3','1'),(21,'文章内容内容内容内容','来源','1,2,3','1'),(22,'文章内容内容内容内容','来源','1,2,3','1'),(23,'文章内容内容内容内容','来源','1,2,3','1'),(24,'文章内容内容内容内容','来源','1,2,3','1'),(25,'文章内容内容内容内容','来源','1,2,3','1'),(26,'文章内容内容内容内容','来源','1,2,3','1'),(27,'文章内容内容内容内容','来源','1,2,3','1'),(28,'文章内容内容内容内容','来源','1,2,3','1'),(29,'文章内容内容内容内容','来源','1,2,3','1'),(30,'文章内容内容内容内容','来源','1,2,3','1'),(31,'文章内容内容内容内容','来源','1,2,3','1'),(32,'文章内容内容内容内容','来源','1,2,3','1'),(33,'文章内容内容内容内容','来源','1,2,3','1'),(34,'文章内容内容内容内容','来源','1,2,3','1'),(35,'文章内容内容内容内容','来源','1,2,3','1'),(36,'文章内容内容内容内容','来源','1,2,3','1'),(37,'文章内容内容内容内容','来源','1,2,3','1'),(38,'文章内容内容内容内容','来源','1,2,3','1'),(39,'文章内容内容内容内容','来源','1,2,3','1'),(40,'文章内容内容内容内容','来源','1,2,3','1'),(41,'文章内容内容内容内容','来源','1,2,3','1'),(42,'文章内容内容内容内容','来源','1,2,3','1'),(43,'文章内容内容内容内容','来源','1,2,3','1'),(44,'文章内容内容内容内容','来源','1,2,3','1'),(45,'文章内容内容内容内容','来源','1,2,3','1'),(46,'文章内容内容内容内容','来源','1,2,3','1'),(47,'文章内容内容内容内容','来源','1,2,3','1'),(48,'文章内容内容内容内容','来源','1,2,3','1'),(49,'文章内容内容内容内容','来源','1,2,3','1'),(50,'文章内容内容内容内容','来源','1,2,3','1'),(51,'文章内容内容内容内容','来源','1,2,3','1'),(52,'文章内容内容内容内容','来源','1,2,3','1'),(53,'文章内容内容内容内容','来源','1,2,3','1');

/*Table structure for table `cms_category` */

DROP TABLE IF EXISTS `cms_category`;

CREATE TABLE `cms_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `site_id` bigint(20) DEFAULT '1' COMMENT '站点编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(255) NOT NULL COMMENT '所有父级编号',
  `module` varchar(20) NOT NULL COMMENT '栏目模块（article：文章；picture：图片；download：下载；link：链接；special：专题）',
  `name` varchar(100) NOT NULL COMMENT '栏目名称',
  `image` varchar(255) DEFAULT '' COMMENT '栏目图片',
  `href` varchar(255) NOT NULL COMMENT '链接',
  `target` varchar(20) NOT NULL COMMENT '目标（ _blank、_self、_parent、_top）',
  `desciption` varchar(255) DEFAULT '' COMMENT '描述，填写有助于搜索引擎优化',
  `keywords` varchar(255) DEFAULT '' COMMENT '关键字，填写有助于搜索引擎优化',
  `sort` int(11) DEFAULT '30' COMMENT '排序（升序）',
  `in_menu` char(1) DEFAULT '1' COMMENT '是否在导航中显示（1：显示；0：不显示）',
  `in_list` char(1) DEFAULT '1' COMMENT '是否在分类页中显示列表（1：显示；0：不显示）',
  `show_modes` char(1) DEFAULT '0' COMMENT '展现方式（0:有子栏目显示栏目列表，无子栏目显示内容列表;1：首栏目内容列表；2：栏目第一条内容）',
  `allow_comment` char(1) DEFAULT NULL COMMENT '是否允许评论',
  `user_id` bigint(20) NOT NULL COMMENT '创建者',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `parent_ids` (`parent_ids`),
  KEY `module` (`module`),
  KEY `name` (`name`),
  KEY `sort` (`sort`),
  KEY `user_id` (`user_id`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='内容管理栏目表';

/*Data for the table `cms_category` */

insert  into `cms_category`(`id`,`site_id`,`parent_id`,`parent_ids`,`module`,`name`,`image`,`href`,`target`,`desciption`,`keywords`,`sort`,`in_menu`,`in_list`,`show_modes`,`allow_comment`,`user_id`,`del_flag`) values (1,0,0,'0,','','顶级栏目','','','','','',0,'1','1','0','0',1,'0'),(2,1,1,'0,1,','article','组织机构','','','','','',10,'1','1','0','0',1,'0'),(3,1,2,'0,1,2,','article','网站简介','','','','','',30,'1','1','0','0',1,'0'),(4,1,2,'0,1,2,','article','内部机构','','','','','',40,'1','1','0','0',1,'0'),(5,1,2,'0,1,2,','article','地方机构','','','','','',50,'1','1','0','0',1,'0'),(6,1,1,'0,1,','article','质量检验','','','','','',20,'1','1','1','1',1,'0'),(7,1,6,'0,1,6,','article','产品质量','','','','','',30,'1','1','0','1',1,'0'),(8,1,6,'0,1,6,','article','技术质量','','','','','',40,'1','1','0','1',1,'0'),(9,1,6,'0,1,6,','article','工程质量','','','','','',50,'1','1','0','1',1,'0'),(10,1,1,'0,1,','article','软件介绍','','','','','',20,'1','1','0','1',1,'0'),(11,1,10,'0,1,10,','article','网络工具','','','','','',30,'1','1','0','1',1,'0'),(12,1,10,'0,1,10,','article','浏览工具','','','','','',40,'1','1','0','1',1,'0'),(13,1,10,'0,1,10,','article','浏览辅助','','','','','',50,'1','1','0','1',1,'0'),(14,1,10,'0,1,10,','article','网络优化','','','','','',50,'1','1','0','1',1,'0'),(15,1,10,'0,1,10,','article','邮件处理','','','','','',50,'1','1','0','1',1,'0'),(16,1,10,'0,1,10,','article','下载工具','','','','','',50,'1','1','0','1',1,'0'),(17,1,10,'0,1,10,','article','搜索工具','','','','','',50,'1','1','2','1',1,'0'),(18,1,1,'0,1,','link','友情链接','','','','','',90,'1','1','0','1',1,'0'),(19,1,18,'0,1,18,','link','常用网站','','','','','',50,'1','1','0','1',1,'0'),(20,1,18,'0,1,18,','link','门户网站','','','','','',50,'1','1','0','1',1,'0'),(21,1,18,'0,1,18,','link','购物网站','','','','','',50,'1','1','0','1',1,'0'),(22,1,18,'0,1,18,','link','交友社区','','','','','',50,'1','1','0','1',1,'0'),(23,1,18,'0,1,18,','link','音乐视频','','','','','',50,'1','1','0','1',1,'0'),(24,1,1,'0,1,','','百度一下','','http://www.baidu.com','_blank','','',90,'1','1','0','1',1,'0'),(25,1,1,'0,1,','','全文检索','','/search','','','',90,'0','1','0','1',1,'0'),(26,2,1,'0,1,','article','测试栏目','','','','','',90,'1','1','0','1',1,'0'),(27,1,1,'0,1,','','公共留言','','/guestbook','','','',90,'1','1','0','1',1,'0');

/*Table structure for table `cms_comment` */

DROP TABLE IF EXISTS `cms_comment`;

CREATE TABLE `cms_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `module` varchar(20) NOT NULL COMMENT '内容模型（article：文章；picture：图片；download：下载）',
  `content_id` bigint(20) NOT NULL COMMENT '归属分类内容的编号（Article.id、Photo.id、Download.id）',
  `title` varchar(255) DEFAULT NULL COMMENT '归属分类内容的标题（Article.title、Photo.title、Download.title）',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `name` varchar(100) DEFAULT NULL COMMENT '评论姓名',
  `ip` varchar(100) DEFAULT NULL COMMENT '评论IP',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `audit_user_id` bigint(20) DEFAULT NULL COMMENT '审核人',
  `audit_date` timestamp NULL DEFAULT NULL COMMENT '审核时间',
  `status` char(1) DEFAULT '0' COMMENT '删除标记（0：发布；1：作废；2：审核；）',
  PRIMARY KEY (`id`),
  KEY `module` (`module`),
  KEY `content_id` (`content_id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容管理内容评论表';

/*Data for the table `cms_comment` */

/*Table structure for table `cms_guestbook` */

DROP TABLE IF EXISTS `cms_guestbook`;

CREATE TABLE `cms_guestbook` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` varchar(100) NOT NULL COMMENT '留言分类（咨询、建议、投诉、其它）',
  `content` varchar(255) NOT NULL COMMENT '留言内容',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `phone` varchar(100) NOT NULL COMMENT '电话',
  `workunit` varchar(100) NOT NULL COMMENT '单位',
  `ip` varchar(100) NOT NULL COMMENT 'IP',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '留言时间',
  `re_user_id` bigint(20) DEFAULT NULL COMMENT '回复人',
  `re_date` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  `re_content` varchar(100) DEFAULT NULL COMMENT '回复内容',
  `status` char(1) DEFAULT '0' COMMENT '状态（0：发布；1：作废；2：审核；）',
  PRIMARY KEY (`id`),
  KEY `status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容管理留言本表';

/*Data for the table `cms_guestbook` */

/*Table structure for table `cms_link` */

DROP TABLE IF EXISTS `cms_link`;

CREATE TABLE `cms_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `category_id` bigint(20) NOT NULL COMMENT '分类编号',
  `user_id` bigint(20) NOT NULL COMMENT '发布者',
  `title` varchar(255) NOT NULL COMMENT '链接名称',
  `color` varchar(50) DEFAULT '' COMMENT '标题颜色（red：红色；green：绿色；blue：蓝色；yellow：黄色；orange：橙色）',
  `image` varchar(255) DEFAULT '' COMMENT '如果上传了图片，则显示为图片链接',
  `href` varchar(255) DEFAULT '' COMMENT '链接地址',
  `remarks` varchar(255) DEFAULT '' COMMENT '备注',
  `status` char(1) DEFAULT '' COMMENT '状态（0：发布；1：作废；2：审核；）',
  `weight` int(11) DEFAULT '0' COMMENT '权重，越大越靠前',
  `input_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '录入时间',
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `title` (`title`),
  KEY `status` (`status`),
  KEY `weight` (`weight`),
  KEY `input_date` (`input_date`),
  KEY `update_date` (`update_date`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='内容管理链接模型表';

/*Data for the table `cms_link` */

insert  into `cms_link`(`id`,`category_id`,`user_id`,`title`,`color`,`image`,`href`,`remarks`,`status`,`weight`,`input_date`,`update_date`) values (1,19,1,'JeeSite','','','http://thinkgem.github.com/jeesite','','0',0,'2013-05-15 13:20:11','2012-10-07 00:00:00'),(2,19,1,'ThinkGem','','','http://thinkgem.iteye.com/','','0',0,'2013-05-15 13:20:11','2012-10-07 00:00:00'),(3,19,1,'百度一下','','','http://www.baidu.com','','0',0,'2013-05-15 13:20:11','2012-10-07 00:00:00'),(4,19,1,'谷歌搜索','','','http://www.google.com','','0',0,'2013-05-15 13:20:11','2012-10-07 00:00:00'),(5,20,1,'新浪网','','','http://www.sina.com.cn','','0',0,'2013-05-15 13:20:11','2012-10-07 00:00:00'),(6,20,1,'腾讯网','','','http://www.qq.com/','','0',0,'2013-05-15 13:20:11','2012-10-07 00:00:00'),(7,21,1,'淘宝网','','','http://www.taobao.com/','','0',0,'2013-05-15 13:20:11','2012-10-07 00:00:00'),(8,21,1,'新华网','','','http://www.xinhuanet.com/','','0',0,'2013-05-15 13:20:11','2012-10-07 00:00:00'),(9,22,1,'赶集网','','','http://www.ganji.com/','','0',0,'2013-05-15 13:20:11','2012-10-07 00:00:00'),(10,22,1,'58同城','','','http://www.58.com/','','0',0,'2013-05-15 13:20:11','2012-10-07 00:00:00'),(11,23,1,'视频大全','','','http://v.360.cn/','','0',0,'2013-05-15 13:20:11','2012-10-07 00:00:00'),(12,23,1,'凤凰网','','','http://www.ifeng.com/','','0',0,'2013-05-15 13:20:11','2012-10-07 00:00:00');

/*Table structure for table `cms_site` */

DROP TABLE IF EXISTS `cms_site`;

CREATE TABLE `cms_site` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '站点名称',
  `title` varchar(100) NOT NULL COMMENT '站点标题',
  `desciption` varchar(255) DEFAULT '' COMMENT '描述，填写有助于搜索引擎优化',
  `keywords` varchar(255) DEFAULT '' COMMENT '关键字，填写有助于搜索引擎优化',
  `theme` varchar(255) DEFAULT 'default' COMMENT '主题',
  `copyright` mediumtext COMMENT '版权信息',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='内容管理站点配置表';

/*Data for the table `cms_site` */

insert  into `cms_site`(`id`,`name`,`title`,`desciption`,`keywords`,`theme`,`copyright`,`del_flag`) values (1,'默认站点','JeeSite Web','JeeSite','JeeSite','basic','Copyright &copy; 2012-2013 <a href=\'http://thinkgem.iteye.com\' target=\'_blank\'>ThinkGem</a> - Powered By <a href=\'https://github.com/thinkgem/jeesite\' target=\'_blank\'>JeeSite</a> V1.0','0'),(2,'子站点测试','JeeSite Subsite','JeeSite subsite','JeeSite subsite','basic','Copyright &copy; 2012-2013 <a href=\'http://thinkgem.iteye.com\' target=\'_blank\'>ThinkGem</a> - Powered By <a href=\'https://github.com/thinkgem/jeesite\' target=\'_blank\'>JeeSite</a> V1.0','0');

/*Table structure for table `ims_customer` */

DROP TABLE IF EXISTS `ims_customer`;

CREATE TABLE `ims_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `companyId` int(11) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `idno` varchar(25) DEFAULT NULL COMMENT '身份证号',
  `qq` varchar(20) DEFAULT NULL,
  `mail` varchar(100) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `ims_customer` */

insert  into `ims_customer`(`id`,`name`,`companyId`,`tel`,`mobile`,`address`,`description`,`idno`,`qq`,`mail`,`remark`) values (1,'周明源',2,'23423423','23423423','2222222','23423423','4423432','333333','aaaA@163.com',NULL),(2,'aaa',NULL,'aaa','adafd',NULL,NULL,NULL,NULL,'aaa@163.com','afad'),(3,'ffff',NULL,'2343241','342341','邯郸丛台',NULL,NULL,NULL,'aaaa@163.com','adsfasdfadfasd');

/*Table structure for table `ims_customer_survey` */

DROP TABLE IF EXISTS `ims_customer_survey`;

CREATE TABLE `ims_customer_survey` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '客户ID',
  `content` varchar(3000) DEFAULT NULL COMMENT '调查内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `sort` int(11) DEFAULT NULL COMMENT '第几次',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ims_customer_survey` */

/*Table structure for table `ims_industry` */

DROP TABLE IF EXISTS `ims_industry`;

CREATE TABLE `ims_industry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '行业名称',
  `descriptoin` varchar(500) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ims_industry` */

/*Table structure for table `ims_page_template` */

DROP TABLE IF EXISTS `ims_page_template`;

CREATE TABLE `ims_page_template` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `remarks` varchar(1000) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `del_flag` varchar(2) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `ims_page_template` */

insert  into `ims_page_template`(`id`,`name`,`remarks`,`create_date`,`del_flag`) values (1,'通普模板','通用模板','2013-05-27 14:28:16','0');

/*Table structure for table `ims_page_template_item` */

DROP TABLE IF EXISTS `ims_page_template_item`;

CREATE TABLE `ims_page_template_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '导航名称',
  `url` varchar(500) DEFAULT NULL COMMENT '连接地址',
  `template_id` int(11) DEFAULT NULL COMMENT '对应的模板',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ims_page_template_item` */

/*Table structure for table `ims_project` */

DROP TABLE IF EXISTS `ims_project`;

CREATE TABLE `ims_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` int(11) DEFAULT NULL COMMENT '所属账号',
  `name` varchar(200) NOT NULL COMMENT '项目名称',
  `company_name` varchar(200) DEFAULT NULL COMMENT '公司名称',
  `com_address` varchar(500) DEFAULT NULL COMMENT '公司地址',
  `mobile` varchar(20) DEFAULT NULL COMMENT '电话',
  `mail` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `pageTemplate_id` int(11) NOT NULL COMMENT '页面模板',
  `industry_type` int(11) NOT NULL COMMENT '所属行业',
  `qrcode_id` int(11) NOT NULL COMMENT '对应的二维码',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `remarks` varchar(1000) DEFAULT NULL COMMENT '描述 ',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `start_date` datetime DEFAULT NULL COMMENT '生效时间',
  `end_date` datetime DEFAULT NULL COMMENT '结束时间',
  `del_flag` varchar(2) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `ims_project` */

insert  into `ims_project`(`id`,`user_id`,`name`,`company_name`,`com_address`,`mobile`,`mail`,`pageTemplate_id`,`industry_type`,`qrcode_id`,`status`,`remarks`,`create_date`,`start_date`,`end_date`,`del_flag`) values (1,2,'电影院','人民路',NULL,NULL,NULL,1,2,0,NULL,'sssss','2013-05-27 14:28:16','2013-05-27 14:28:16','2013-05-27 14:28:16','0'),(2,2,'Chow jakema','ZZ China',NULL,'23423423','jakemnase@1',1,3,4,NULL,'adfa','2013-05-28 13:50:55',NULL,NULL,'0'),(3,2,'金点子传媒','莾sdf',NULL,'23423','22',1,9,5,NULL,'adfs','2013-05-28 14:02:41',NULL,NULL,'0'),(4,2,'祥云传媒','国贸',NULL,'23432','jakemanse@1',1,1,6,NULL,'萨顶顶f','2013-05-28 14:39:19',NULL,NULL,'0');

/*Table structure for table `ims_project_b` */

DROP TABLE IF EXISTS `ims_project_b`;

CREATE TABLE `ims_project_b` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(200) NOT NULL COMMENT '项目名称',
  `customerId` int(11) NOT NULL COMMENT '所属客户',
  `industryId` int(11) DEFAULT NULL COMMENT '所属行业',
  `timeoutType` int(11) DEFAULT '1' COMMENT '有效期类型 1:年 2:季 3:月 4:周',
  `createTime` datetime DEFAULT NULL,
  `startTime` datetime DEFAULT NULL COMMENT '开始生效时间',
  `endTime` datetime DEFAULT NULL COMMENT '有效期结速时间',
  `description` varchar(3000) DEFAULT NULL COMMENT '项目描述',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `ims_project_b` */

/*Table structure for table `ims_project_visit` */

DROP TABLE IF EXISTS `ims_project_visit`;

CREATE TABLE `ims_project_visit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `project_id` int(11) DEFAULT NULL COMMENT '所属项目',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `qq` varchar(20) DEFAULT NULL COMMENT 'QQ',
  `ip` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `browser` varchar(2000) DEFAULT NULL COMMENT '浏览器',
  `create_date` datetime DEFAULT NULL COMMENT '扫描时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `ims_project_visit` */

insert  into `ims_project_visit`(`id`,`project_id`,`mobile`,`qq`,`ip`,`browser`,`create_date`) values (1,4,NULL,NULL,'192.168.1.101','Mozilla/5.0 (Linux; U; Android 4.1.2; zh-CN; GT-I9100 Build/JZO54K) AppleWebKit/534.31 (KHTML, like Gecko) UCBrowser/9.0.1.275 U3/0.8.0 Mobile Safari/534.31','2013-05-28 21:54:56'),(2,4,NULL,NULL,'192.168.1.100','Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.94 Safari/537.36','2013-05-28 22:14:45');

/*Table structure for table `ims_qrcode` */

DROP TABLE IF EXISTS `ims_qrcode`;

CREATE TABLE `ims_qrcode` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `type` int(11) DEFAULT '1',
  `content` varchar(500) NOT NULL COMMENT '二维码内容',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `png_path` varchar(500) DEFAULT NULL COMMENT 'png图版路径',
  `jpeg_path` varchar(500) DEFAULT NULL COMMENT 'jpeg图片路径',
  `del_flag` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `ims_qrcode` */

insert  into `ims_qrcode`(`id`,`type`,`content`,`create_date`,`update_date`,`png_path`,`jpeg_path`,`del_flag`) values (1,NULL,'http://www.163.com','2013-05-27 22:12:01',NULL,NULL,'d:\\temp\\ims\\1369663923570.png','0'),(4,NULL,'http://www.163.com','2013-05-28 13:51:03',NULL,NULL,'D:\\temp\\ims\\1369720264090','0'),(5,NULL,'http://192.168.1.102:8080/jeesite//f/mobsite/mom/pro/3.html','2013-05-28 14:02:51',NULL,NULL,'D:\\temp\\ims\\1369720971823','0'),(6,NULL,'http://192.168.1.102:8080/jeesite/f/mobsite/mom/pro/4.html','2013-05-28 14:39:19',NULL,NULL,'D:\\temp\\ims\\1369723159489','0');

/*Table structure for table `sys_area` */

DROP TABLE IF EXISTS `sys_area`;

CREATE TABLE `sys_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(255) NOT NULL COMMENT '所有父级编号',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `name` varchar(100) DEFAULT NULL COMMENT '区域名称',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `parent_ids` (`parent_ids`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='系统区域表';

/*Data for the table `sys_area` */

insert  into `sys_area`(`id`,`parent_id`,`parent_ids`,`code`,`name`,`remarks`,`del_flag`) values (1,0,'0,','','顶级区域','','0'),(2,1,'0,1,','370000','邯郸博信科技','','0'),(3,1,'0,1,','0310000','邯郸市','邯郸市','0'),(4,2,'0,1,2,','370531','济南分公司','','0'),(5,2,'0,1,2,','370532','青岛分公司','','0'),(6,3,'0,1,3,','0310001','邯郸县','','0'),(7,3,'0,1,3,','0310002','峰峰矿区','','0'),(8,3,'0,1,3,','0310003','武安市','','0'),(9,3,'0,1,3,','0310004','临漳县','','0'),(10,3,'0,1,3,','0310005','成安县','','0'),(11,3,'0,1,3,','0310006','大名县','','0'),(12,3,'0,1,3,','0310007','涉 县','','0'),(13,3,'0,1,3,','0310008','磁 县','','0'),(14,3,'0,1,3,','0310009','肥乡县','','0'),(15,3,'0,1,3,','0310010','永年县','','0'),(16,3,'0,1,3,','0310011','邱 县','','0'),(17,3,'0,1,3,','0310012','鸡泽县','','0'),(18,3,'0,1,3,','0310013','广平县','','0'),(19,3,'0,1,3,','0310014','馆陶县','','0'),(20,3,'0,1,3,','0310016','魏 县','','0'),(21,3,'0,1,3,','0310017','曲周县','','0');

/*Table structure for table `sys_dict` */

DROP TABLE IF EXISTS `sys_dict`;

CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `label` varchar(100) NOT NULL COMMENT '标签',
  `value` varchar(100) NOT NULL COMMENT '键值',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `desciption` varchar(100) NOT NULL COMMENT '描述',
  `sort` int(11) NOT NULL COMMENT '排序（升序）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `value` (`value`),
  KEY `label` (`label`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COMMENT='系统字典表';

/*Data for the table `sys_dict` */

insert  into `sys_dict`(`id`,`label`,`value`,`type`,`desciption`,`sort`,`del_flag`) values (1,'正常','0','del_flag','删除标记',10,'0'),(2,'删除','1','del_flag','删除标记',20,'0'),(3,'显示','1','show_hide','显示/隐藏',10,'0'),(4,'隐藏','0','show_hide','显示/隐藏',20,'0'),(5,'是','1','yes_no','是/否',10,'0'),(6,'否','0','yes_no','是/否',20,'0'),(7,'红色','red','color','颜色值',10,'0'),(8,'绿色','green','color','颜色值',20,'0'),(9,'蓝色','blue','color','颜色值',30,'0'),(10,'黄色','yellow','color','颜色值',40,'0'),(11,'橙色','orange','color','颜色值',50,'0'),(12,'系统管理','1','sys_user_type','用户类型',10,'0'),(13,'部门经理','2','sys_user_type','用户类型',20,'0'),(14,'普通用户','3','sys_user_type','用户类型',30,'0'),(15,'基础主题','basic','cms_theme','站点主题',10,'0'),(16,'蓝色主题','blue','cms_theme','站点主题',20,'1'),(17,'红色主题','red','cms_theme','站点主题',30,'1'),(18,'文章模型','article','cms_module','栏目模型',10,'0'),(19,'图片模型','picture','cms_module','栏目模型',20,'1'),(20,'下载模型','download','cms_module','栏目模型',30,'1'),(21,'链接模型','link','cms_module','栏目模型',40,'0'),(22,'专题模型','special','cms_module','栏目模型',50,'1'),(23,'默认展现方式','0','cms_show_modes','展现方式',20,'0'),(24,'首栏目内容列表','1','cms_show_modes','展现方式',20,'0'),(25,'栏目第一条内容','2','cms_show_modes','展现方式',30,'0'),(26,'发布','0','cms_status','内容状态',10,'0'),(27,'删除','1','cms_status','内容状态',20,'0'),(28,'审核','2','cms_status','内容状态',15,'0'),(29,'首页焦点图','1','cms_posid','推荐位',30,'0'),(30,'栏目页文章推荐','2','cms_posid','推荐位',30,'0'),(31,'咨询','1','cms_guestbook','留言板分类',30,'0'),(32,'建议','2','cms_guestbook','留言板分类',30,'0'),(33,'投诉','3','cms_guestbook','留言板分类',30,'0'),(34,'其它','4','cms_guestbook','留言板分类',30,'0'),(35,'默认主题','default','theme','主题方案',10,'0'),(36,'天蓝主题','cerulean','theme','主题方案',20,'0'),(37,'橙色主题','readable','theme','主题方案',30,'0'),(38,'红色主题','united','theme','主题方案',40,'0'),(39,'Win8主题','cosmo','theme','主题方案',50,'0'),(40,'平台客户','4','sys_user_type','平台客户，暂不能登录',40,'0'),(41,'休闲娱乐','1','ims_industry_type','休闲娱乐',1,'0'),(42,'餐饮美食','2','ims_industry_type','餐饮美食',2,'0'),(43,'城市生活','3','ims_industry_type','城市生活',3,'0'),(44,'烘焙行业','4','ims_industry_type','烘焙行业',4,'0'),(45,'美容美发','5','ims_industry_type','美容美发',5,'0'),(46,'演艺娱乐','6','ims_industry_type','演艺娱乐',6,'0'),(47,'服装行业','7','ims_industry_type','服装行业',7,'0'),(48,'旅游休闲','8','ims_industry_type','旅游休闲',8,'0'),(49,'家政服务','9','ims_industry_type','家政服务',9,'0'),(50,'医疗保健','10','ims_industry_type','医疗保健',10,'0'),(51,'广告媒体','11','ims_industry_type','广告媒体',11,'0'),(52,'产品制造','12','ims_industry_type','产品制造',12,'0'),(53,'公司会议','13','ims_industry_type','公司会议',13,'0'),(54,'新人婚礼','14','ims_industry_type','新人婚礼',14,'0'),(55,'社交活动','15','ims_industry_type','社交活动',15,'0'),(56,'产品发布','16','ims_industry_type','产品发布',16,'0'),(57,'文本二维码','1','ims_qrcode_type','文本二维码',1,'0'),(58,'短信二维码','2','ims_qrcode_type','短信二维码',2,'0'),(59,'邮件二维码','3','ims_qrcode_type','邮件内容二维码',3,'0'),(60,'WIFI 二维码','4','ims_qrcode_type','WIFI 二维码',4,'0'),(61,'网址二维码','5','ims_qrcode_type','网址二维码',5,'0'),(62,'公司基本信息及LOGO','1','ims_template_nav','公司基本信息及LOGO',1,'0'),(63,'LBS地图导航功能','2','ims_template_nav','LBS地图导航功能',2,'0'),(64,'介绍性导航页','3','ims_template_nav','介绍性导航页',3,'0'),(65,'公司动态','4','ims_template_nav','公司动态',4,'0');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(255) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '菜单名称',
  `href` varchar(255) NOT NULL COMMENT '链接',
  `target` varchar(20) NOT NULL COMMENT '目标（mainFrame、 _blank、_self、_parent、_top）',
  `icon` varchar(100) NOT NULL COMMENT '图标',
  `sort` int(11) NOT NULL COMMENT '排序（升序）',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示（1：显示；0：不显示）',
  `permission` varchar(200) NOT NULL COMMENT '权限标识',
  `user_id` bigint(20) NOT NULL COMMENT '创建者',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `parent_ids` (`parent_ids`),
  KEY `user_id` (`user_id`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`parent_id`,`parent_ids`,`name`,`href`,`target`,`icon`,`sort`,`is_show`,`permission`,`user_id`,`del_flag`) values (1,0,'0,','顶级菜单','','','',0,'1','',1,'0'),(2,1,'0,1,','系统设置','','','',900,'1','',1,'0'),(3,2,'0,1,2,','系统设置','','','',980,'1','',1,'0'),(4,3,'0,1,2,3,','菜单管理','/sys/menu/','','list-alt',30,'1','',1,'0'),(5,4,'0,1,2,3,4,','查看','','','',30,'0','sys:menu:view',1,'0'),(6,4,'0,1,2,3,4,','修改','','','',30,'0','sys:menu:edit',1,'0'),(7,3,'0,1,2,3,','角色管理','/sys/role/','','lock',50,'1','',1,'0'),(8,7,'0,1,2,3,7,','查看','','','',30,'0','sys:role:view',1,'0'),(9,7,'0,1,2,3,7,','修改','','','',30,'0','sys:role:edit',1,'0'),(10,3,'0,1,2,3,','字典管理','/sys/dict/','','th-list',60,'1','',1,'0'),(11,10,'0,1,2,3,10,','查看','','','',30,'0','sys:dict:view',1,'0'),(12,10,'0,1,2,3,10,','修改','','','',30,'0','sys:dict:edit',1,'0'),(13,2,'0,1,2,','机构用户','','','',970,'1','',1,'0'),(14,13,'0,1,2,13,','区域管理','/sys/area/','','th',50,'1','',1,'0'),(15,14,'0,1,2,13,14,','查看','','','',30,'0','sys:area:view',1,'0'),(16,14,'0,1,2,13,14,','修改','','','',30,'0','sys:area:edit',1,'0'),(17,13,'0,1,2,13,','机构管理','/sys/office/','','th-large',40,'1','',1,'0'),(18,17,'0,1,2,13,17,','查看','','','',30,'0','sys:office:view',1,'0'),(19,17,'0,1,2,13,17,','修改','','','',30,'0','sys:office:edit',1,'0'),(20,13,'0,1,2,13,','用户管理','/sys/user/','','user',30,'1','',1,'0'),(21,20,'0,1,2,13,20,','查看','','','',30,'0','sys:user:view',1,'0'),(22,20,'0,1,2,13,20,','修改','','','',30,'0','sys:user:edit',1,'0'),(23,2,'0,1,2,','关于帮助','','','',990,'1','',1,'0'),(24,23,'0,1,2,23','项目首页','http://jeesite.com','_blank','',30,'1','',1,'0'),(25,23,'0,1,2,23','项目维基','https://github.com/thinkgem/jeesite/wiki','_blank','',50,'1','',1,'0'),(26,23,'0,1,2,23','问题反馈','https://github.com/thinkgem/jeesite/issues/new','_blank','',80,'1','',1,'0'),(27,1,'0,1,','我的面板','','','',100,'1','',1,'0'),(28,27,'0,1,27,','个人信息','','','',990,'1','',1,'0'),(29,28,'0,1,27,28,','个人信息','/sys/user/info','','home',30,'1','',1,'0'),(30,28,'0,1,27,28,','修改密码','/sys/user/modifyPwd','','lock',40,'1','',1,'0'),(31,1,'0,1,','内容管理','','','',500,'1','',1,'0'),(32,31,'0,1,31,','栏目设置','','','',990,'1','',1,'0'),(33,32,'0,1,31,32','栏目管理','/cms/category/','','align-justify',30,'1','',1,'0'),(34,33,'0,1,31,32,33,','查看','','','',30,'0','cms:category:view',1,'0'),(35,33,'0,1,31,32,33,','修改','','','',30,'0','cms:category:edit',1,'0'),(36,32,'0,1,31,32','站点设置','/cms/site/','','certificate',40,'1','',1,'0'),(37,36,'0,1,31,32,36,','查看','','','',30,'0','cms:site:view',1,'0'),(38,36,'0,1,31,32,36,','修改','','','',30,'0','cms:site:edit',1,'0'),(39,32,'0,1,31,32','切换站点','/cms/site/select','','retweet',50,'1','cms:site:select',1,'0'),(40,31,'0,1,31,','内容管理','','','',500,'1','cms:view',1,'0'),(41,40,'0,1,31,40,','内容发布','/cms/','','briefcase',30,'1','',1,'0'),(42,41,'0,1,31,40,41,','文章模型','/cms/article/','','file',40,'0','',1,'0'),(43,42,'0,1,31,40,41,42,','查看','','','',30,'0','cms:article:view',1,'0'),(44,42,'0,1,31,40,41,42,','修改','','','',30,'0','cms:article:edit',1,'0'),(45,42,'0,1,31,40,41,42,','审核','','','',30,'0','cms:article:audit',1,'0'),(46,41,'0,1,31,40,41,','链接模型','/cms/link/','','random',60,'0','',1,'0'),(47,46,'0,1,31,40,41,46,','查看','','','',30,'0','cms:link:view',1,'0'),(48,46,'0,1,31,40,41,46,','修改','','','',30,'0','cms:link:edit',1,'0'),(49,46,'0,1,31,40,41,46,','审核','','','',30,'0','cms:link:audit',1,'0'),(50,40,'0,1,31,40,','评论管理','/cms/comment/?status=2','','comment',40,'1','',1,'0'),(51,50,'0,1,31,40,50,','查看','','','',30,'0','cms:comment:view',1,'0'),(52,50,'0,1,31,40,50,','审核','','','',30,'0','cms:comment:edit',1,'0'),(53,40,'0,1,31,40,','公共留言','/cms/guestbook/?status=2','','glass',80,'1','',1,'0'),(54,53,'0,1,31,40,53,','查看','','','',30,'0','cms:guestbook:view',1,'0'),(55,53,'0,1,31,40,53,','审核','','','',30,'0','cms:guestbook:edit',1,'0'),(56,40,'0,1,31,40,','文件管理','/../static/ckfinder/ckfinder.html','','folder-open',90,'1','',1,'0'),(57,56,'0,1,31,40,56,','查看','','','',30,'0','cms:ckfinder:view',1,'0'),(58,56,'0,1,31,40,56,','上传','','','',30,'0','cms:ckfinder:upload',1,'0'),(59,56,'0,1,31,40,56,','修改','','','',30,'0','cms:ckfinder:edit',1,'0'),(60,1,'0,1,','客户管理','','','user',30,'1','',2,'0'),(61,60,'0,1,60,','客户管理','','','pencil',30,'1','',2,'0'),(62,61,'0,1,60,61,','添加客户','/customer','','',30,'1','ims:customer:view',2,'0'),(63,62,'0,1,60,61,62,','客户查询','','','',30,'1','',2,'1'),(64,61,'0,1,60,61,','客户查询','','','',30,'1','',2,'0'),(65,62,'0,1,60,61,62,','修改','','','',30,'0','ims:customer:edit',2,'0'),(66,1,'0,1,','移动营销平台','','','',30,'1','',2,'0'),(67,66,'0,1,66,','项目管理','','','',30,'1','',2,'0'),(68,67,'0,1,66,67,','新建项目','/mom/project/form','','',30,'1','momarketing:project:edit',2,'0'),(69,67,'0,1,66,67,','全部项目','/mom/project','','folder-close',31,'1','momarketing:project:view',2,'0'),(70,66,'0,1,66,','产品管理','','','',32,'1','',2,'0'),(71,70,'0,1,66,70,','添加产品','','','',35,'1','',2,'0'),(72,70,'0,1,66,70,','我的产品','','','',30,'1','',2,'0'),(73,66,'0,1,66,','终端管理','','','',37,'1','',2,'0'),(74,73,'0,1,66,73,','我的终端','','','',38,'1','',2,'0'),(75,73,'0,1,66,73,','添加终端','','','',39,'1','',2,'0'),(76,66,'0,1,66,','常用工具','','','',50,'1','',2,'0'),(77,76,'0,1,66,76,','文本二维码','','','',51,'1','',2,'0'),(78,76,'0,1,66,76,','电话二维码','','','',52,'1','',2,'0'),(79,76,'0,1,66,76,','WIFI 二维码','','','',54,'1','',2,'0'),(80,76,'0,1,66,76,','网址二维码','','','',55,'1','',2,'0'),(81,76,'0,1,66,76,','邮箱二维码','','','',56,'1','',2,'0'),(82,76,'0,1,66,76,','短信二维码','','','',57,'1','',2,'0'),(83,76,'0,1,66,76,','个性二维码','','','',58,'1','',2,'0'),(84,66,'0,1,66,','微 营 销','','','',40,'1','',2,'0'),(85,84,'0,1,66,84,','微信公众平台','','','',41,'1','',2,'0'),(86,84,'0,1,66,84,','微博一键关注','','','',42,'1','',2,'0'),(87,66,'0,1,66,','优惠券管理','','','',30,'1','',2,'0'),(88,87,'0,1,66,87,','我的优惠券','','','',30,'1','',2,'0'),(89,87,'0,1,66,87,','核销优惠券','','','',30,'1','',2,'0'),(90,66,'0,1,66,','账单管理','','','',60,'1','',2,'0'),(91,90,'0,1,66,90,','我的账单','','','',61,'1','',2,'0'),(92,66,'0,1,66,','互动管理','','','',31,'1','',2,'0'),(93,92,'0,1,66,92,','在线抽奖','','','',31,'1','',2,'0'),(94,92,'0,1,66,92,','问卷调查','','','',32,'1','',2,'0'),(95,92,'0,1,66,92,','留言板','','','',34,'1','',2,'0'),(96,92,'0,1,66,92,','在线报名表','','','',35,'1','',2,'0');

/*Table structure for table `sys_office` */

DROP TABLE IF EXISTS `sys_office`;

CREATE TABLE `sys_office` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` bigint(20) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(255) NOT NULL COMMENT '所有父级编号',
  `area_id` bigint(20) NOT NULL COMMENT '归属区域',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `name` varchar(100) NOT NULL COMMENT '部门名称',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`),
  KEY `parent_ids` (`parent_ids`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='系统部门表';

/*Data for the table `sys_office` */

insert  into `sys_office`(`id`,`parent_id`,`parent_ids`,`area_id`,`code`,`name`,`remarks`,`del_flag`) values (1,0,'0,',1,'','顶级部门','','0'),(2,1,'0,1,',1,'0001','系统管理','','0'),(3,1,'0,1,',1,'0002','系统维护','','0'),(4,2,'0,1,2,',1,'000101','系统管理1','','0'),(5,2,'0,1,2,',1,'000102','系统管理2','','0'),(6,3,'0,1,3,',1,'000201','系统维护1','','0'),(7,3,'0,1,3,',1,'000202','系统维护2','','0');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `user_id` bigint(20) NOT NULL COMMENT '创建者',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`user_id`,`del_flag`) values (1,'系统管理员',1,'0'),(2,'普通用户',1,'0'),(3,'业务员',2,'0'),(4,'移动营销客户',2,'0');

/*Table structure for table `sys_role_category` */

DROP TABLE IF EXISTS `sys_role_category`;

CREATE TABLE `sys_role_category` (
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `category_id` bigint(20) NOT NULL COMMENT '内容分类编号',
  PRIMARY KEY (`role_id`,`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色与内容分类关联表';

/*Data for the table `sys_role_category` */

insert  into `sys_role_category`(`role_id`,`category_id`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(2,1),(2,2),(2,3),(2,4),(2,5),(2,6),(2,7),(2,8),(2,9),(2,10),(2,11),(2,12),(2,13),(2,14),(2,15),(2,16),(2,17),(2,18),(2,19),(2,20),(2,21),(2,22),(2,23),(2,24),(2,25),(2,26),(2,27);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色与菜单关联表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`role_id`,`menu_id`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),(1,36),(1,37),(1,38),(1,39),(1,40),(1,41),(1,42),(1,43),(1,44),(1,45),(1,46),(1,47),(1,48),(1,49),(1,50),(1,51),(1,52),(1,53),(1,54),(1,55),(1,56),(1,57),(1,58),(1,59),(2,1),(2,3),(2,23),(2,24),(2,25),(2,26),(2,27),(2,28),(2,29),(2,30),(2,31),(2,32),(2,33),(2,34),(2,35),(2,36),(2,37),(2,38),(2,39),(2,40),(2,41),(2,42),(2,43),(2,44),(2,45),(2,46),(2,47),(2,48),(2,49),(2,50),(2,51),(2,52),(2,53),(2,54),(2,55),(2,56),(2,57),(2,58),(2,59),(3,1),(3,27),(3,28),(3,29),(3,30),(3,60),(3,61),(3,64),(4,1),(4,27),(4,28),(4,29),(4,30),(4,66),(4,67),(4,68),(4,69),(4,70),(4,71),(4,72),(4,73),(4,74),(4,75),(4,76),(4,77),(4,78),(4,79),(4,80),(4,81),(4,82),(4,83),(4,84),(4,85),(4,86);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `area_id` bigint(20) NOT NULL COMMENT '区域编号',
  `office_id` bigint(20) NOT NULL COMMENT '部门编号',
  `login_name` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `qq` varchar(50) DEFAULT NULL COMMENT 'QQ',
  `remarks` varchar(255) DEFAULT '' COMMENT '备注',
  `user_type` varchar(100) DEFAULT '' COMMENT '用户类型',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  PRIMARY KEY (`id`),
  KEY `area_id` (`area_id`),
  KEY `office_id` (`office_id`),
  KEY `login_name` (`login_name`),
  KEY `del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`area_id`,`office_id`,`login_name`,`password`,`name`,`email`,`phone`,`mobile`,`qq`,`remarks`,`user_type`,`create_date`,`del_flag`,`login_ip`,`login_date`) values (1,1,1,'thinkgem','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','Thinkgem','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0',NULL,NULL),(2,1,1,'admin','02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032','管理员','jakemanse@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0','127.0.0.1','2013-05-28 22:11:11'),(3,2,2,'user','c365ed90538e9145a4939335a80be5169685fed00c5bfd573ad1927e','用户','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0','127.0.0.1','2013-05-15 13:31:21'),(4,3,3,'user2','c483879feb6704d4780ad0d259cca93ffc173b02c48084f8b186a53c','用户2','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0',NULL,NULL),(5,3,3,'user3','c483879feb6704d4780ad0d259cca93ffc173b02c48084f8b186a53c','用户3','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0',NULL,NULL),(6,3,3,'user4','c483879feb6704d4780ad0d259cca93ffc173b02c48084f8b186a53c','用户4','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0',NULL,NULL),(7,3,3,'user5','c483879feb6704d4780ad0d259cca93ffc173b02c48084f8b186a53c','用户5','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0',NULL,NULL),(8,3,3,'user6','c483879feb6704d4780ad0d259cca93ffc173b02c48084f8b186a53c','用户6','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0',NULL,NULL),(9,3,3,'user7','c483879feb6704d4780ad0d259cca93ffc173b02c48084f8b186a53c','用户7','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0',NULL,NULL),(10,3,3,'user8','c483879feb6704d4780ad0d259cca93ffc173b02c48084f8b186a53c','用户8','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0',NULL,NULL),(11,3,3,'user9','c483879feb6704d4780ad0d259cca93ffc173b02c48084f8b186a53c','用户9','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0',NULL,NULL),(12,3,3,'user10','c483879feb6704d4780ad0d259cca93ffc173b02c48084f8b186a53c','用户10','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0',NULL,NULL),(13,3,3,'user11','c483879feb6704d4780ad0d259cca93ffc173b02c48084f8b186a53c','用户11','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0',NULL,NULL),(14,3,3,'user12','c483879feb6704d4780ad0d259cca93ffc173b02c48084f8b186a53c','用户12','thinkgem@163.com','8675','8675',NULL,'','','2013-05-15 13:20:12','0',NULL,NULL),(15,1,1,'jakemanse','be4ee9f43c1bb41cc47a65908a49bd4c0e59fdd9eece95b1068779f1','张三','admin@163.com','','','35376089','','3','2013-05-15 14:53:18','0','127.0.0.1','2013-05-15 14:54:19'),(16,1,1,'qiangzi','a06116ab4b2b33b1110285d8255f75fe83af72af02b8c443f044abb4','贾志强','','','',NULL,'','2','2013-05-25 08:51:37','0','127.0.0.1','2013-05-25 08:51:47');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户编号',
  `role_id` bigint(20) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户与角色关联表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`user_id`,`role_id`) values (1,1),(1,2),(2,1),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(15,3),(16,4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
