-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2017-05-31 17:55:20
-- 服务器版本： 10.1.21-MariaDB
-- PHP Version: 7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `edums`
--

-- --------------------------------------------------------

--
-- 表的结构 `admin`
--

CREATE TABLE `admin` (
  `adminId` bigint(20) NOT NULL,
  `idCard` varchar(18) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `adminName` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `admin`
--

INSERT INTO `admin` (`adminId`, `idCard`, `password`, `adminName`) VALUES
(666666, '310101199101012244', 'admin', '管理员');

-- --------------------------------------------------------

--
-- 替换视图以便查看 `classhour32`
-- (See below for the actual view)
--
CREATE TABLE `classhour32` (
`courseTimeId` varchar(50)
,`timepreiod` bigint(14)
);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `classhour48`
-- (See below for the actual view)
--
CREATE TABLE `classhour48` (
`courseTimeId` varchar(50)
,`timepreiod` bigint(14)
);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `classhour64`
-- (See below for the actual view)
--
CREATE TABLE `classhour64` (
`courseTimeId` varchar(50)
,`timepreiod` bigint(14)
);

-- --------------------------------------------------------

--
-- 替换视图以便查看 `classhour96`
-- (See below for the actual view)
--
CREATE TABLE `classhour96` (
`courseTimeId` varchar(50)
,`timepreiod` bigint(14)
);

-- --------------------------------------------------------

--
-- 表的结构 `classroom`
--

CREATE TABLE `classroom` (
  `classRoomId` int(11) NOT NULL,
  `classRoomLocation` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `classroom`
--

INSERT INTO `classroom` (`classRoomId`, `classRoomLocation`) VALUES
(1, ' 一教100'),
(2, '一教101'),
(3, '一教102'),
(4, '一教103'),
(5, '一教104'),
(6, '一教105'),
(7, '一教106'),
(8, '一教107'),
(9, '一教108'),
(10, '一教109'),
(11, '一教110'),
(12, '一教111'),
(13, '一教112'),
(14, '一教113'),
(17, '一教114'),
(18, '一教115'),
(19, '一教116'),
(20, '一教117'),
(21, '一教118'),
(22, '一教119'),
(23, '一教120'),
(24, '一教200'),
(25, '一教201'),
(26, '一教202'),
(27, '一教203'),
(28, '一教204'),
(29, '一教205'),
(30, '一教206'),
(31, '一教207'),
(32, '一教208'),
(33, '一教209'),
(34, '一教210'),
(35, '一教211'),
(36, '一教212'),
(37, '一教213'),
(38, '一教214'),
(39, '一教215');

-- --------------------------------------------------------

--
-- 表的结构 `classroomoccupied`
--

CREATE TABLE `classroomoccupied` (
  `classRoomId` int(11) NOT NULL,
  `courseTimeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `classroomoccupied`
--

INSERT INTO `classroomoccupied` (`classRoomId`, `courseTimeId`) VALUES
(10, '48.3.345'),
(17, '32.2.67'),
(1, '32.1.12'),
(14, '96.1.12.3.34.5.12'),
(2, '32.1.12'),
(1, '32.5.67'),
(17, '32.5.89'),
(11, '32.5.12'),
(21, '64.1.67.3.34'),
(24, '48.3.345'),
(23, '32.5.89'),
(21, '48.4.345'),
(18, '64.2.34.4.67'),
(20, '32.5.67');

-- --------------------------------------------------------

--
-- 表的结构 `course`
--

CREATE TABLE `course` (
  `courseNumber` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `courseName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `credit` int(11) NOT NULL,
  `classHour` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `course`
--

INSERT INTO `course` (`courseNumber`, `courseName`, `credit`, `classHour`) VALUES
('12000520', '嵌入式系统', 2, 32),
('12000561', '数据结构A', 4, 64),
('12001200', 'JavaWeb应用开发技术', 3, 48),
('12001780', '计算机网络', 3, 48),
('12002080', '计算机组成与系统结构', 4, 64),
('12002230', '数据库原理', 3, 48),
('12002240', '软件工程', 3, 48),
('12002250', '软件协同设计', 2, 32),
('12002270', 'LINUX操作系统', 2, 32),
('12002280', '信息安全概论', 2, 32),
('12002290', '算法分析与设计', 2, 32),
('12002310', '软件项目管理', 2, 32),
('12002320', '软件过程管理', 2, 32),
('12002330', '移动软件开发技术', 3, 48),
('22000210', '高等数学A', 6, 96);

-- --------------------------------------------------------

--
-- 表的结构 `coursecomment`
--

CREATE TABLE `coursecomment` (
  `commentId` int(11) NOT NULL,
  `teacherCourseId` int(11) NOT NULL,
  `commentContent` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `teacherGrade` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `coursecomment`
--

INSERT INTO `coursecomment` (`commentId`, `teacherCourseId`, `commentContent`, `teacherGrade`) VALUES
(1, 14, '老师挺好的，希望答疑辅导更加充分。', 85),
(2, 13, '建议老师能更加理论联系实际', 85),
(3, 33, '好！', 90),
(4, 14, '老师上课风格非常棒，如果课后答疑辅导时间更多一点就好了，还有上课时希望讲些实践中用到的知识，这样就更完美啦', 82.5),
(5, 13, '这门课太烦啦！！其实老师讲的不错，就是这门课的要求课下要花很多时间讨论写报告，都没有时间去做自己感兴趣的事。', 90),
(6, 14, ' 一般般，对这门课提不起兴趣', 85),
(7, 13, '小组讨论太耗时间啦！！！', 82.5),
(8, 14, '老师挺好的，讲课很生动，也能理论联系实际，作业批改认真，教学内容充实，重点突出，答疑辅导充分，工作认真负责。讲课条理清晰。棒棒棒！！！', 85),
(9, 13, '怎么说呢，一周只有这门课最不想上，太耗时间了，小组讨论讨论，讨论得再仔细再完美，最后写代码也不可能和设计的时候一模一样，肯定会遇到各种问题啊，就是每周写报告写报告，太耗时间了', 80),
(10, 33, '好啊！！', 90),
(11, 12, '五星好评！！', 90),
(12, 14, '好', 90),
(13, 13, '让我们来集体吐槽它！！', 82.5),
(14, 13, '还好还好，能过就好', 85),
(15, 13, '很好！！', 90),
(16, 33, '太难啦', 85),
(17, 13, '这门课有点烦', 77.5),
(18, 33, '知道这门课重要  但是太难啦 还好是开卷', 77.5),
(19, 13, '挺不错的 没啥建议', 85),
(20, 12, '老师特别好！！', 90),
(21, 13, '没啥可说的', 72.5),
(22, 12, '这个老师我给全优！', 90),
(23, 12, '老师很优秀！！', 90);

-- --------------------------------------------------------

--
-- 表的结构 `coursequestion`
--

CREATE TABLE `coursequestion` (
  `questionId` int(11) NOT NULL,
  `teacherCourseId` int(11) NOT NULL,
  `stuAccount` bigint(20) NOT NULL,
  `questionContent` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `questionAnswer` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `questionTime` datetime NOT NULL,
  `answerTime` datetime DEFAULT NULL,
  `isAnswered` bit(1) NOT NULL,
  `isChecked` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `coursequestion`
--

INSERT INTO `coursequestion` (`questionId`, `teacherCourseId`, `stuAccount`, `questionContent`, `questionAnswer`, `questionTime`, `answerTime`, `isAnswered`, `isChecked`) VALUES
(1, 14, 1412480101, '老师，这门课最后的考试形式是什么啊？', '写论文', '2017-05-31 13:55:09', '2017-05-31 16:32:18', b'1', b'1'),
(2, 14, 1412480101, '我就是来试试能不能来问问题', '能', '2017-05-31 14:21:35', '2017-05-31 16:32:50', b'1', b'1'),
(3, 14, 1412480101, '这门课学不明白', '那也要学', '2017-05-31 14:29:19', '2017-05-31 16:32:45', b'1', b'1'),
(4, 13, 1412480101, '老师，本周报告写几份', '两份', '2017-05-31 14:30:51', '2017-05-31 16:31:14', b'1', b'1'),
(5, 13, 1412480101, '考试难不难', '还好还好', '2017-05-31 14:31:48', '2017-05-31 17:21:06', b'1', b'1'),
(6, 13, 1412480101, '老师，测试报告啥时候交', '明天', '2017-05-31 18:10:26', '2017-05-31 18:59:58', b'1', b'1'),
(7, 13, 1412480103, '试试', '哈', '2017-05-31 19:03:42', '2017-05-31 19:05:44', b'1', b'1'),
(8, 13, 1412480103, '。。。test', '。。', '2017-05-31 19:13:09', '2017-05-31 19:17:45', b'1', b'1'),
(9, 33, 1412480103, '算法好难啊  到底要咋学', '多做多练', '2017-05-31 20:04:24', '2017-05-31 20:05:05', b'1', b'1'),
(10, 33, 1412480103, '。。。', '。', '2017-05-31 20:06:22', '2017-05-31 20:07:16', b'1', b'1'),
(11, 35, 1412480103, '你说我能问什么', '我也不知道', '2017-05-31 20:11:22', '2017-05-31 20:12:13', b'1', b'1'),
(12, 33, 1412480105, '算法到底有什么好法子学', NULL, '2017-05-31 20:51:58', NULL, b'0', b'0'),
(13, 13, 1412480101, '最后考试形式是什么', NULL, '2017-05-31 21:46:59', NULL, b'0', b'1');

-- --------------------------------------------------------

--
-- 表的结构 `coursetime`
--

CREATE TABLE `coursetime` (
  `courseTimeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `classHour` int(11) NOT NULL,
  `courseTime` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `coursetime`
--

INSERT INTO `coursetime` (`courseTimeId`, `classHour`, `courseTime`) VALUES
('32.1.12', 32, '周一1,2节'),
('32.1.34', 32, '周一3,4节'),
('32.1.67', 32, '周一6,7节'),
('32.1.89', 32, '周一8,9节'),
('32.2.12', 32, '周二1,2节'),
('32.2.34', 32, '周二3,4节'),
('32.2.67', 32, '周二6,7节'),
('32.2.89', 32, '周二8,9节'),
('32.3.12', 32, '周三1,2节'),
('32.3.34', 32, '周三3,4节'),
('32.3.67', 32, '周三6,7节'),
('32.3.89', 32, '周三8,9节'),
('32.4.12', 32, '周四1,2节'),
('32.4.34', 32, '周四3,4节'),
('32.4.67', 32, '周四6,7节'),
('32.4.89', 32, '周四8,9节'),
('32.5.12', 32, '周五1,2节'),
('32.5.34', 32, '周五3,4节'),
('32.5.67', 32, '周五6,7节'),
('32.5.89', 32, '周五8,9节'),
('48.1.101112', 48, '周一10,11,12节'),
('48.1.345', 48, '周一3,4,5节'),
('48.2.101112', 48, '周二10,11,12节'),
('48.2.345', 48, '周二3,4,5节'),
('48.3.101112', 48, '周三10,11,12节'),
('48.3.345', 48, '周三3,4,5节'),
('48.4.101112', 48, '周四10,11,12节'),
('48.4.345', 48, '周四3,4,5节'),
('48.5.101112', 48, '周五10,11,12节'),
('48.5.345', 48, '周五3,4,5节'),
('64.1.12.3.89', 64, '周一1,2节,周三8,9节'),
('64.1.34.3.67', 64, '周一3,4节,周三6,7节'),
('64.1.67.3.34', 64, '周一6,7节,周三3,4节'),
('64.1.89.3.12', 64, '周一8,9节,周三1,2节'),
('64.2.12.4.89', 64, '周二1,2节,周四8,9节'),
('64.2.34.4.67', 64, '周二3,4节,周四6,7节'),
('64.2.67.4.34', 64, '周二6,7节,周四3,4节'),
('64.2.89.4.12', 64, '周二8,9节,周四1,2节'),
('96.1.12.3.34.5.12', 96, '周一1,2节课,周三3,4节课,周五1,2节课'),
('96.1.34.3.12.5.34', 96, '周一3,4节课,周三1,2节课,周五3,4节课');

-- --------------------------------------------------------

--
-- 表的结构 `coursetimedescript`
--

CREATE TABLE `coursetimedescript` (
  `courseTimeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `weekday` int(11) NOT NULL,
  `timeQuantum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `coursetimedescript`
--

INSERT INTO `coursetimedescript` (`courseTimeId`, `weekday`, `timeQuantum`) VALUES
('32.1.12', 1, 1),
('32.1.34', 1, 2),
('32.1.67', 1, 3),
('32.1.89', 1, 4),
('32.2.12', 2, 1),
('32.2.34', 2, 2),
('32.2.67', 2, 3),
('32.2.89', 2, 4),
('32.3.12', 3, 1),
('32.3.34', 3, 2),
('32.3.67', 3, 3),
('32.3.89', 3, 4),
('32.4.12', 4, 1),
('32.4.34', 4, 2),
('32.4.67', 4, 3),
('32.4.89', 4, 4),
('32.5.12', 5, 1),
('32.5.34', 5, 2),
('32.5.67', 5, 3),
('32.5.89', 5, 4),
('48.1.345', 1, 2),
('48.2.345', 2, 2),
('48.3.345', 3, 2),
('48.4.345', 4, 2),
('48.5.345', 5, 2),
('48.1.101112', 1, 5),
('48.2.101112', 2, 5),
('48.3.101112', 3, 5),
('48.4.101112', 4, 5),
('48.5.101112', 5, 5),
('64.1.12.3.89', 1, 1),
('64.1.12.3.89', 3, 4),
('64.1.34.3.67', 1, 2),
('64.1.34.3.67', 3, 3),
('64.1.67.3.34', 1, 3),
('64.1.67.3.34', 3, 2),
('64.1.89.3.12', 1, 4),
('64.1.89.3.12', 3, 1),
('64.2.12.4.89', 2, 1),
('64.2.12.4.89', 4, 4),
('64.2.34.4.67', 2, 2),
('64.2.34.4.67', 4, 3),
('64.2.67.4.34', 2, 3),
('64.2.67.4.34', 4, 2),
('64.2.89.4.12', 2, 4),
('64.2.89.4.12', 4, 1),
('96.1.12.3.34.5.12', 1, 1),
('96.1.12.3.34.5.12', 3, 2),
('96.1.12.3.34.5.12', 5, 1),
('96.1.34.3.12.5.34', 1, 2),
('96.1.34.3.12.5.34', 3, 1),
('96.1.34.3.12.5.34', 5, 2);

-- --------------------------------------------------------

--
-- 表的结构 `gpa`
--

CREATE TABLE `gpa` (
  `stuAccount` bigint(20) NOT NULL,
  `gpa` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `major`
--

CREATE TABLE `major` (
  `majorId` int(11) NOT NULL,
  `academy` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `major` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `major`
--

INSERT INTO `major` (`majorId`, `academy`, `major`) VALUES
(1, '能源与动力工程学院', '过程装备与控制工程'),
(2, '能源与动力工程学院', '新能源科学与工程'),
(3, '能源与动力工程学院', '能源与动力工程'),
(4, '光电信息与计算机工程学院', '计算机科学与技术'),
(5, '光电信息与计算机工程学院', '电子信息工程'),
(6, '光电信息与计算机工程学院', '通信工程'),
(7, '光电信息与计算机工程学院', '电子科学与技术'),
(8, '光电信息与计算机工程学院', '自动化'),
(9, '光电信息与计算机工程学院', '测控技术与仪器'),
(10, '光电信息与计算机工程学院', '网络工程'),
(11, '管理学院', '国际经济与贸易'),
(12, '管理学院', '金融学'),
(13, '管理学院', '管理科学'),
(14, '管理学院', '信息管理与信息系统'),
(15, '管理学院', '工业工程'),
(16, '管理学院', '工商管理'),
(17, '管理学院', '会计学'),
(18, '管理学院', '公共事业管理'),
(19, '机械工程学院', '机械设计制造及其自动化'),
(20, '机械工程学院', '车辆工程'),
(21, '外语学院', '英语'),
(22, '外语学院', '德语'),
(23, '外语学院', '日语'),
(24, '环境与建筑学院', '土木工程'),
(25, '环境与建筑学院', '环境工程'),
(26, '环境与建筑学院', '建筑环境与能源应用工程'),
(27, '医疗器械与食品学院', '生物医学工程'),
(28, '医疗器械与食品学院', '食品科学与工程'),
(29, '医疗器械与食品学院', '食品质量与安全'),
(30, '医疗器械与食品学院', '医学信息工程'),
(31, '医疗器械与食品学院', '制药工程'),
(32, '出版印刷与艺术设计学院', '广告学'),
(33, '出版印刷与艺术设计学院', '编辑出版学'),
(34, '出版印刷与艺术设计学院', '包装工程'),
(35, '出版印刷与艺术设计学院', '工业设计'),
(36, '出版印刷与艺术设计学院', '动画'),
(37, '出版印刷与艺术设计学院', '产品设计'),
(38, '出版印刷与艺术设计学院', '环境设计'),
(39, '出版印刷与艺术设计学院', '印刷工程'),
(40, '出版印刷与艺术设计学院', '视觉传达设计'),
(41, '理学院', '数学与应用数学'),
(42, '理学院', '应用物理学'),
(43, '理学院', '应用化学'),
(44, '材料科学与工程学院', '材料科学与工程'),
(45, '材料科学与工程学院', '材料成型及控制工程');

-- --------------------------------------------------------

--
-- 表的结构 `researchfields`
--

CREATE TABLE `researchfields` (
  `researchFieldsId` int(11) NOT NULL,
  `academy` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `researchFields` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `researchfields`
--

INSERT INTO `researchfields` (`researchFieldsId`, `academy`, `researchFields`) VALUES
(1, '光电信息与计算机工程学院', '计算机应用技术'),
(2, '光电信息与计算机工程学院', '图像处理'),
(3, '光电信息与计算机工程学院', '模式识别'),
(4, '光电信息与计算机工程学院', '数据挖掘'),
(5, '光电信息与计算机工程学院', '嵌入式系统'),
(6, '光电信息与计算机工程学院', '太赫兹技术'),
(7, '光电信息与计算机工程学院', '智能科学'),
(8, '能源与动力工程学院', '制冷与低温工程'),
(9, '能源与动力工程学院', '热工测控技术'),
(10, '能源与动力工程学院', '化工过程机械'),
(11, '能源与动力工程学院', '多相流动与传热'),
(12, '管理学院', '工业工程'),
(13, '管理学院', '电子商务'),
(14, '管理学院', '企业管理'),
(15, '管理学院', '运筹与决策'),
(16, '机械工程学院', '机械工程'),
(17, '机械工程学院', '机械制造'),
(18, '外语学院', '英美文学'),
(19, '外语学院', '经济德语'),
(20, '外语学院', '语言学'),
(21, '外语学院', '德语教学'),
(22, '外语学院', '口译'),
(23, '环境与建筑学院', '结构工程试验'),
(24, '环境与建筑学院', '大气污染控制'),
(25, '环境与建筑学院', '生态水力学'),
(26, '环境与建筑学院', '土壤污染修复'),
(27, '环境与建筑学院', '建筑设计'),
(28, '环境与建筑学院', '水处理'),
(29, '医疗器械与食品学院', '生物医学工程'),
(30, '医疗器械与食品学院', '食品科学与工程'),
(31, '医疗器械与食品学院', '假肢矫形工程'),
(32, '出版印刷与艺术设计学院', '数字媒体'),
(33, '出版印刷与艺术设计学院', '城市设计'),
(34, '出版印刷与艺术设计学院', '传媒管理'),
(35, '出版印刷与艺术设计学院', '视觉传达'),
(36, '出版印刷与艺术设计学院', '包装结构'),
(37, '理学院', '药物合成化学'),
(38, '理学院', '光电转化与储能研究'),
(39, '理学院', '数据分析'),
(40, '理学院', '光子学'),
(41, '理学院', '纳米无机材料'),
(42, '材料科学与工程学院', '半导体材料'),
(43, '材料科学与工程学院', '锂电池材料'),
(44, '材料科学与工程学院', '生物医用材料'),
(45, '材料科学与工程学院', '石墨烯材料'),
(46, '材料科学与工程学院', '光电半导体');

-- --------------------------------------------------------

--
-- 表的结构 `stucourse`
--

CREATE TABLE `stucourse` (
  `stuAccount` bigint(20) NOT NULL,
  `teacherCourseId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `stucourse`
--

INSERT INTO `stucourse` (`stuAccount`, `teacherCourseId`) VALUES
(1412480101, 12),
(1412480101, 13),
(1412480101, 14),
(1412480101, 33),
(1412480101, 34),
(1412480103, 12),
(1412480103, 13),
(1412480103, 14),
(1412480103, 33),
(1412480103, 35),
(1412480105, 12),
(1412480105, 13),
(1412480105, 14),
(1412480105, 33),
(1412480105, 34),
(1412480107, 13),
(1412480107, 15),
(1412480107, 33),
(1412480108, 13),
(1412480108, 33),
(1412480109, 13),
(1412480109, 14),
(1412480109, 33),
(1412480110, 12),
(1412480110, 13),
(1412480111, 12),
(1412480111, 13);

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE `student` (
  `stuAccount` bigint(20) NOT NULL,
  `idCard` varchar(18) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `stuName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `grade` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `majorId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`stuAccount`, `idCard`, `password`, `stuName`, `sex`, `grade`, `majorId`) VALUES
(1412480101, '310101199601014412', '111111', '徐逸', '男', '大三', 1),
(1412480103, '341912199309084456', '', '李平', '男', '大二', 44),
(1412480105, '310112199706102234', '111111', '王小五', '男', '大二', 4),
(1412480107, '310121199602054420', '111111', '杜晓福', '男', '大三', 4),
(1412480108, '342121199505034439', '034439', '李四', '男', '大一', 25),
(1412480109, '410022199701078839', '078839', '董志', '男', '大一', 17),
(1412480110, '342121199803073331', '111111', '张伟', '男', '大二', 33),
(1412480111, '319201199805073312', '073312', '张强', '男', '大二', 10);

-- --------------------------------------------------------

--
-- 表的结构 `stugrade`
--

CREATE TABLE `stugrade` (
  `courseNumber` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `stuAccount` bigint(20) NOT NULL,
  `stuGrade` int(11) NOT NULL,
  `courseGPA` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `stugrade`
--

INSERT INTO `stugrade` (`courseNumber`, `stuAccount`, `stuGrade`, `courseGPA`) VALUES
('12000520', 1412480101, 83, 3),
('12000520', 1412480103, 88, 3.5),
('12000520', 1412480105, 91, 4),
('12000520', 1412480109, 95, 4.5),
('12002250', 1412480101, 78, 2.5),
('12002250', 1412480103, 88, 3.5),
('12002250', 1412480105, 87, 3.5),
('12002250', 1412480107, 89, 3.5),
('12002250', 1412480108, 90, 4),
('12002250', 1412480109, 66, 1.5),
('12002250', 1412480110, 77, 2.5),
('12002250', 1412480111, 85, 3.5);

-- --------------------------------------------------------

--
-- 表的结构 `teacher`
--

CREATE TABLE `teacher` (
  `teacherAccount` bigint(20) NOT NULL,
  `idCard` varchar(18) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `teacherName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `technicalTitle` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `researchFieldsId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `teacher`
--

INSERT INTO `teacher` (`teacherAccount`, `idCard`, `password`, `teacherName`, `sex`, `technicalTitle`, `researchFieldsId`) VALUES
(5100, '310111199001012233', '111111', '周璐', '女', '讲师', 1),
(5102, '412991199009073398', '073398', '程鹏', '男', '讲师', 24),
(5103, '341119198801043339', '111111', '李志', '男', '讲师', 7),
(5104, '310210198807032210', '032210', '李锐', '男', '讲师', 1),
(5107, '329181198001294429', '294429', '张燕', '女', '讲师', 3),
(5108, '321023198803210093', '210093', '黄伟文', '男', '讲师', 5),
(5109, '341921197804095533', '111111', '赵峰宇', '男', '教授', 4),
(5110, '310231197902072221', '072221', '曹春平', '女', '教授', 4),
(5111, '310292198410129983', '129983', ' 杨莉莉', '女', '副教授', 1),
(5112, '321092198707120031', '120031', '周江宇', '男', '讲师', 39);

-- --------------------------------------------------------

--
-- 表的结构 `teachercourse`
--

CREATE TABLE `teachercourse` (
  `teacherCourseId` int(11) NOT NULL,
  `teacherAccount` bigint(20) NOT NULL,
  `courseNumber` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `courseTimeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `classRoomId` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `surplus` int(11) NOT NULL,
  `gradeinputed` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `teachercourse`
--

INSERT INTO `teachercourse` (`teacherCourseId`, `teacherAccount`, `courseNumber`, `courseTimeId`, `classRoomId`, `capacity`, `surplus`, `gradeinputed`) VALUES
(12, 5104, '12001200', '48.3.345', 10, 30, 25, b'0'),
(13, 5100, '12002250', '32.2.67', 17, 25, 17, b'1'),
(14, 5100, '12000520', '32.1.12', 1, 26, 22, b'1'),
(15, 5102, '22000210', '96.1.12.3.34.5.12', 14, 30, 29, b'0'),
(16, 5107, '12002250', '32.1.12', 2, 23, 23, b'0'),
(17, 5103, '12000520', '32.5.67', 1, 19, 19, b'0'),
(19, 5102, '12000520', '32.5.89', 17, 30, 30, b'0'),
(20, 5103, '12002250', '32.5.12', 11, 30, 30, b'0'),
(22, 5112, '12000561', '64.1.67.3.34', 21, 25, 25, b'0'),
(25, 5111, '12001200', '48.3.345', 24, 24, 24, b'0'),
(33, 5108, '12002290', '32.5.89', 23, 29, 23, b'0'),
(34, 5107, '12002240', '48.4.345', 21, 29, 27, b'0'),
(35, 5109, '12002080', '64.2.34.4.67', 18, 30, 29, b'0'),
(36, 5112, '12002270', '32.5.67', 20, 25, 25, b'0');

-- --------------------------------------------------------

--
-- 视图结构 `classhour32`
--
DROP TABLE IF EXISTS `classhour32`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `classhour32`  AS  select `coursetimedescript`.`courseTimeId` AS `courseTimeId`,((`coursetimedescript`.`weekday` * 10) + `coursetimedescript`.`timeQuantum`) AS `timepreiod` from `coursetimedescript` where `coursetimedescript`.`courseTimeId` in (select `coursetime`.`courseTimeId` from `coursetime` where (`coursetime`.`classHour` = 32)) ;

-- --------------------------------------------------------

--
-- 视图结构 `classhour48`
--
DROP TABLE IF EXISTS `classhour48`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `classhour48`  AS  select `coursetimedescript`.`courseTimeId` AS `courseTimeId`,((`coursetimedescript`.`weekday` * 10) + `coursetimedescript`.`timeQuantum`) AS `timepreiod` from `coursetimedescript` where `coursetimedescript`.`courseTimeId` in (select `coursetime`.`courseTimeId` from `coursetime` where (`coursetime`.`classHour` = 48)) ;

-- --------------------------------------------------------

--
-- 视图结构 `classhour64`
--
DROP TABLE IF EXISTS `classhour64`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `classhour64`  AS  select `coursetimedescript`.`courseTimeId` AS `courseTimeId`,((`coursetimedescript`.`weekday` * 10) + `coursetimedescript`.`timeQuantum`) AS `timepreiod` from `coursetimedescript` where `coursetimedescript`.`courseTimeId` in (select `coursetime`.`courseTimeId` from `coursetime` where (`coursetime`.`classHour` = 64)) ;

-- --------------------------------------------------------

--
-- 视图结构 `classhour96`
--
DROP TABLE IF EXISTS `classhour96`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `classhour96`  AS  select `coursetimedescript`.`courseTimeId` AS `courseTimeId`,((`coursetimedescript`.`weekday` * 10) + `coursetimedescript`.`timeQuantum`) AS `timepreiod` from `coursetimedescript` where `coursetimedescript`.`courseTimeId` in (select `coursetime`.`courseTimeId` from `coursetime` where (`coursetime`.`classHour` = 96)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminId`);

--
-- Indexes for table `classroom`
--
ALTER TABLE `classroom`
  ADD PRIMARY KEY (`classRoomId`);

--
-- Indexes for table `classroomoccupied`
--
ALTER TABLE `classroomoccupied`
  ADD KEY `courseTimeId` (`courseTimeId`),
  ADD KEY `classRoomId` (`classRoomId`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`courseNumber`);

--
-- Indexes for table `coursecomment`
--
ALTER TABLE `coursecomment`
  ADD PRIMARY KEY (`commentId`),
  ADD KEY `teacherCourseId` (`teacherCourseId`);

--
-- Indexes for table `coursequestion`
--
ALTER TABLE `coursequestion`
  ADD PRIMARY KEY (`questionId`),
  ADD KEY `teacherCourseId` (`teacherCourseId`),
  ADD KEY `stuAccount` (`stuAccount`);

--
-- Indexes for table `coursetime`
--
ALTER TABLE `coursetime`
  ADD PRIMARY KEY (`courseTimeId`);

--
-- Indexes for table `gpa`
--
ALTER TABLE `gpa`
  ADD PRIMARY KEY (`stuAccount`);

--
-- Indexes for table `major`
--
ALTER TABLE `major`
  ADD PRIMARY KEY (`majorId`);

--
-- Indexes for table `researchfields`
--
ALTER TABLE `researchfields`
  ADD PRIMARY KEY (`researchFieldsId`);

--
-- Indexes for table `stucourse`
--
ALTER TABLE `stucourse`
  ADD PRIMARY KEY (`stuAccount`,`teacherCourseId`),
  ADD KEY `teacherCourseId` (`teacherCourseId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`stuAccount`),
  ADD KEY `majorId` (`majorId`);

--
-- Indexes for table `stugrade`
--
ALTER TABLE `stugrade`
  ADD PRIMARY KEY (`courseNumber`,`stuAccount`),
  ADD KEY `stuAccount` (`stuAccount`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacherAccount`),
  ADD KEY `researchFieldsId` (`researchFieldsId`);

--
-- Indexes for table `teachercourse`
--
ALTER TABLE `teachercourse`
  ADD PRIMARY KEY (`teacherCourseId`),
  ADD KEY `courseTimeId` (`courseTimeId`),
  ADD KEY `classRoomId` (`classRoomId`),
  ADD KEY `teachercourse_ibfk_2` (`courseNumber`),
  ADD KEY `teacherAccount` (`teacherAccount`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `classroom`
--
ALTER TABLE `classroom`
  MODIFY `classRoomId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- 使用表AUTO_INCREMENT `coursecomment`
--
ALTER TABLE `coursecomment`
  MODIFY `commentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- 使用表AUTO_INCREMENT `coursequestion`
--
ALTER TABLE `coursequestion`
  MODIFY `questionId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- 使用表AUTO_INCREMENT `major`
--
ALTER TABLE `major`
  MODIFY `majorId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
--
-- 使用表AUTO_INCREMENT `researchfields`
--
ALTER TABLE `researchfields`
  MODIFY `researchFieldsId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;
--
-- 使用表AUTO_INCREMENT `student`
--
ALTER TABLE `student`
  MODIFY `stuAccount` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1412480112;
--
-- 使用表AUTO_INCREMENT `teacher`
--
ALTER TABLE `teacher`
  MODIFY `teacherAccount` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5113;
--
-- 使用表AUTO_INCREMENT `teachercourse`
--
ALTER TABLE `teachercourse`
  MODIFY `teacherCourseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- 限制导出的表
--

--
-- 限制表 `classroomoccupied`
--
ALTER TABLE `classroomoccupied`
  ADD CONSTRAINT `classroomoccupied_ibfk_2` FOREIGN KEY (`courseTimeId`) REFERENCES `coursetime` (`courseTimeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classroomoccupied_ibfk_3` FOREIGN KEY (`classRoomId`) REFERENCES `classroom` (`classRoomId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `coursecomment`
--
ALTER TABLE `coursecomment`
  ADD CONSTRAINT `coursecomment_ibfk_1` FOREIGN KEY (`teacherCourseId`) REFERENCES `teachercourse` (`teacherCourseId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `coursequestion`
--
ALTER TABLE `coursequestion`
  ADD CONSTRAINT `coursequestion_ibfk_1` FOREIGN KEY (`teacherCourseId`) REFERENCES `teachercourse` (`teacherCourseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `coursequestion_ibfk_2` FOREIGN KEY (`stuAccount`) REFERENCES `student` (`stuAccount`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `gpa`
--
ALTER TABLE `gpa`
  ADD CONSTRAINT `gpa_ibfk_1` FOREIGN KEY (`stuAccount`) REFERENCES `student` (`stuAccount`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `stucourse`
--
ALTER TABLE `stucourse`
  ADD CONSTRAINT `stucourse_ibfk_2` FOREIGN KEY (`teacherCourseId`) REFERENCES `teachercourse` (`teacherCourseId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stucourse_ibfk_3` FOREIGN KEY (`stuAccount`) REFERENCES `student` (`stuAccount`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`majorId`) REFERENCES `major` (`majorId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `stugrade`
--
ALTER TABLE `stugrade`
  ADD CONSTRAINT `stugrade_ibfk_3` FOREIGN KEY (`courseNumber`) REFERENCES `course` (`courseNumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stugrade_ibfk_4` FOREIGN KEY (`stuAccount`) REFERENCES `student` (`stuAccount`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`researchFieldsId`) REFERENCES `researchfields` (`researchFieldsId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `teachercourse`
--
ALTER TABLE `teachercourse`
  ADD CONSTRAINT `teachercourse_ibfk_2` FOREIGN KEY (`courseNumber`) REFERENCES `course` (`courseNumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `teachercourse_ibfk_3` FOREIGN KEY (`courseTimeId`) REFERENCES `coursetime` (`courseTimeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `teachercourse_ibfk_4` FOREIGN KEY (`classRoomId`) REFERENCES `classroom` (`classRoomId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `teachercourse_ibfk_5` FOREIGN KEY (`teacherAccount`) REFERENCES `teacher` (`teacherAccount`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
