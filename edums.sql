-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2017-05-20 17:52:19
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
-- 表的结构 `account`
--

CREATE TABLE `account` (
  `account` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `identity` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `account`
--

INSERT INTO `account` (`account`, `password`, `identity`) VALUES
('05109', '05109', 'teacher'),
('1419660103', '1419660103', 'student'),
('admin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `answerunchecked`
--

CREATE TABLE `answerunchecked` (
  `stuAccount` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `questionId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `class`
--

CREATE TABLE `class` (
  `courseNumber` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `courseName` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `credit` int(11) NOT NULL,
  `classHour` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
(3, '一教102');

-- --------------------------------------------------------

--
-- 表的结构 `classroomoccupied`
--

CREATE TABLE `classroomoccupied` (
  `classRoomId` int(11) NOT NULL,
  `courseTimeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `coursecomment`
--

CREATE TABLE `coursecomment` (
  `commentId` int(11) NOT NULL,
  `teacherCourseId` int(11) NOT NULL,
  `commentContent` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `teacherGrade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `coursequestion`
--

CREATE TABLE `coursequestion` (
  `questionId` int(11) NOT NULL,
  `teacherCourseId` int(11) NOT NULL,
  `stuAccount` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `questionContent` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `questionAnswer` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `questionTime` datetime NOT NULL,
  `answerTime` datetime NOT NULL,
  `isAnswered` tinyint(1) NOT NULL,
  `isChecked` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `coursetime`
--

CREATE TABLE `coursetime` (
  `courseTimeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `classHour` int(11) NOT NULL,
  `courseTime` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `coursetimedescript`
--

CREATE TABLE `coursetimedescript` (
  `courseTimeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `weekday` int(11) NOT NULL,
  `timeQuantum` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `gpa`
--

CREATE TABLE `gpa` (
  `stuAccount` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
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
(1, '光电信息与计算机工程学院', '计算机科学与技术'),
(2, '光电信息与计算机工程学院', '网络工程'),
(3, '能源与动力工程学院', '能源与动力工程'),
(4, '能源与动力工程学院', '过程装备与控制工程');

-- --------------------------------------------------------

--
-- 表的结构 `questionunchecked`
--

CREATE TABLE `questionunchecked` (
  `teacherAccount` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `questionId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `researchfields`
--

CREATE TABLE `researchfields` (
  `researchFieldsId` int(11) NOT NULL,
  `academy` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `researchFields` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `stucourse`
--

CREATE TABLE `stucourse` (
  `stuAccount` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `teacherCourseId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE `student` (
  `stuAccount` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `stuName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `grade` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `majorId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `stugrade`
--

CREATE TABLE `stugrade` (
  `courseNumber` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `stuAccount` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `stuGrade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `teacher`
--

CREATE TABLE `teacher` (
  `teacherAccount` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `teacherName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `technicalTitle` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `researchFieldsId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `teachercourse`
--

CREATE TABLE `teachercourse` (
  `teacherCourseId` int(11) NOT NULL,
  `teacherAccount` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `courseNumber` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `courseTimeId` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `classRoomId` int(11) NOT NULL,
  `capacity` int(11) NOT NULL,
  `surplus` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`account`);

--
-- Indexes for table `answerunchecked`
--
ALTER TABLE `answerunchecked`
  ADD PRIMARY KEY (`questionId`),
  ADD KEY `stuAccount` (`stuAccount`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`courseNumber`);

--
-- Indexes for table `classroom`
--
ALTER TABLE `classroom`
  ADD PRIMARY KEY (`classRoomId`);

--
-- Indexes for table `classroomoccupied`
--
ALTER TABLE `classroomoccupied`
  ADD PRIMARY KEY (`classRoomId`),
  ADD KEY `courseTimeId` (`courseTimeId`);

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
  ADD KEY `coursequestion_ibfk_2` (`stuAccount`);

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
-- Indexes for table `questionunchecked`
--
ALTER TABLE `questionunchecked`
  ADD PRIMARY KEY (`questionId`),
  ADD KEY `teacherAccount` (`teacherAccount`);

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
  ADD KEY `stuAccount` (`stuAccount`),
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
  ADD KEY `teacherAccount` (`teacherAccount`),
  ADD KEY `researchFieldsId` (`researchFieldsId`);

--
-- Indexes for table `teachercourse`
--
ALTER TABLE `teachercourse`
  ADD PRIMARY KEY (`teacherCourseId`),
  ADD KEY `teacherAccount` (`teacherAccount`),
  ADD KEY `courseNumber` (`courseNumber`),
  ADD KEY `courseTimeId` (`courseTimeId`),
  ADD KEY `classRoomId` (`classRoomId`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `classroom`
--
ALTER TABLE `classroom`
  MODIFY `classRoomId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- 使用表AUTO_INCREMENT `coursecomment`
--
ALTER TABLE `coursecomment`
  MODIFY `commentId` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `coursequestion`
--
ALTER TABLE `coursequestion`
  MODIFY `questionId` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `major`
--
ALTER TABLE `major`
  MODIFY `majorId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- 使用表AUTO_INCREMENT `researchfields`
--
ALTER TABLE `researchfields`
  MODIFY `researchFieldsId` int(11) NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `teachercourse`
--
ALTER TABLE `teachercourse`
  MODIFY `teacherCourseId` int(11) NOT NULL AUTO_INCREMENT;
--
-- 限制导出的表
--

--
-- 限制表 `answerunchecked`
--
ALTER TABLE `answerunchecked`
  ADD CONSTRAINT `answerunchecked_ibfk_1` FOREIGN KEY (`stuAccount`) REFERENCES `account` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `answerunchecked_ibfk_2` FOREIGN KEY (`questionId`) REFERENCES `coursequestion` (`questionId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `classroomoccupied`
--
ALTER TABLE `classroomoccupied`
  ADD CONSTRAINT `classroomoccupied_ibfk_1` FOREIGN KEY (`classRoomId`) REFERENCES `classroom` (`classRoomId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `classroomoccupied_ibfk_2` FOREIGN KEY (`courseTimeId`) REFERENCES `coursetime` (`courseTimeId`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `coursequestion_ibfk_2` FOREIGN KEY (`stuAccount`) REFERENCES `stucourse` (`stuAccount`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `gpa`
--
ALTER TABLE `gpa`
  ADD CONSTRAINT `gpa_ibfk_1` FOREIGN KEY (`stuAccount`) REFERENCES `account` (`account`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `questionunchecked`
--
ALTER TABLE `questionunchecked`
  ADD CONSTRAINT `questionunchecked_ibfk_1` FOREIGN KEY (`teacherAccount`) REFERENCES `account` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `questionunchecked_ibfk_2` FOREIGN KEY (`questionId`) REFERENCES `coursequestion` (`questionId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `stucourse`
--
ALTER TABLE `stucourse`
  ADD CONSTRAINT `stucourse_ibfk_1` FOREIGN KEY (`stuAccount`) REFERENCES `account` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stucourse_ibfk_2` FOREIGN KEY (`teacherCourseId`) REFERENCES `teachercourse` (`teacherCourseId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`stuAccount`) REFERENCES `account` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`majorId`) REFERENCES `major` (`majorId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `stugrade`
--
ALTER TABLE `stugrade`
  ADD CONSTRAINT `stugrade_ibfk_2` FOREIGN KEY (`stuAccount`) REFERENCES `account` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stugrade_ibfk_3` FOREIGN KEY (`courseNumber`) REFERENCES `class` (`courseNumber`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`teacherAccount`) REFERENCES `account` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`researchFieldsId`) REFERENCES `researchfields` (`researchFieldsId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `teachercourse`
--
ALTER TABLE `teachercourse`
  ADD CONSTRAINT `teachercourse_ibfk_1` FOREIGN KEY (`teacherAccount`) REFERENCES `account` (`account`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `teachercourse_ibfk_2` FOREIGN KEY (`courseNumber`) REFERENCES `class` (`courseNumber`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `teachercourse_ibfk_3` FOREIGN KEY (`courseTimeId`) REFERENCES `coursetime` (`courseTimeId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `teachercourse_ibfk_4` FOREIGN KEY (`classRoomId`) REFERENCES `classroom` (`classRoomId`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
