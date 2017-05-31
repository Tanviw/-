<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>学生课表</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">


</head>
<body>

<div class="col-md-12 column">
    <div class="headpanel">
        <ul class="nav nav-pills">

            <li><a href="student.jsp">网上选课</a></li>
            <li><a href="#">课表查询</a></li>
            <li  class="active"><a href="#">成绩查询</a></li>
            <li><a href="stucomment.jsp">教师评价</a></li>
            <li><a href="stuquestion.jsp">学生提问</a>
            <c:if test="${sessionScope.uncheckedAnsNum>0}">
            <span id='teacdy'>${uncheckedAnsNum}</span>
            </c:if>
            </li>

        </ul>
    </div>
<div class="main-content">
<hr/>
<h3 style="text-align:center;color:#288690;">学生课表</h3>
<table  class="data table table-bordered table-striped table-hover" cellspacing="0" cellpadding="0">
        <tbody>
        <tr>
            
            <th>课程名称</th>
            <th>教师姓名</th>
            <th>上课时间</th>
            <th>上课地点</th>
            
            
        </tr>
        <c:forEach var="course" items="${sessionScope.selectedCorsList}">
        <tr>
           
            <td>${course.courseName}</td>
            <td>${course.teacherName}</td>
            <td>${course.courseTime}</td>
            <td>${course.classRoomLocation}</td>
        </tr>
        </c:forEach>
        </tbody>
</table>

</div>
</div>




<%@include file="/footer.jsp" %>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/student.js"></script>

</body>
</html>