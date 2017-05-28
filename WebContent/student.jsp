<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>学生信息</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">


</head>
<body>

<div class="col-md-12 column">
    <div class="headpanel">
        <ul class="nav nav-pills">

            <li class="active"><a href="#">网上选课</a></li>
            <li><a href="#">课表查询</a></li>
            <li><a href="#">成绩查询</a></li>
            <li><a href="#">教师评价</a></li>
            <li><a href="#">教师答疑</a></li>

        </ul>
    </div>
<div class="main-content">
<h4>你尽管选，选上课算我输</h4>
<div class="col-md-12 column">

 <table class="data table table-bordered table-striped" cellspacing="0" cellpadding="0">
        <tbody>
        <tr>
            <th>选课</th>
            <th>课程代码</th>
            <th>课程名称</th>
            <th>教师姓名</th>
            <th>上课时间</th>
            <th>上课地点</th>
            <th>学分</th>
            <th>容量</th>
            <th>余量</th>
        </tr>
        
        <c:forEach var="course" items="${sessionScope.avacourseList}">
        <tr>
            <td><input type="checkbox" name="avacors" value="${course.teacherCourseId}"></td>
            <td>${course.courseNumber}</td>
            <td>${course.courseName}</td>
            <td>${course.teacherName}</td>
            <td>${course.courseTime}</td>
            <td>${course.classRoomLocation}</td>
            <td>${course.credit}</td>
            <td>${course.capacity}</td>
            <td>${course.surplus}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <button class="btn btn-success">提交</button>        	
</div>




</div>
</div>



<%@include file="footer.jsp" %>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</body>
</html>