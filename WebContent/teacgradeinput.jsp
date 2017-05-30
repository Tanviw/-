<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>录入课程成绩</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">


</head>
<body>

<div class="col-md-12 column " >
    <div class="headpanel">
        <ul class="nav nav-pills">

            <li><a href="ShowTeacCorsServlet">查看课程评价</a></li>
            <li class="active"><a href="#">录入课程成绩</a></li>
            <li><a href="#">学生答疑</a></li>
           
        </ul>
    </div>
 
<div class="main-content ">
<div class="teacComment">
<hr/>
<span>课程名称及上课时间：</span>
<select id="seleCors">

 <c:forEach var="gradeInputCors" items="${sessionScope.gradeNotInputCors}">
        <option value="${gradeInputCors.teacherCourseId}">${gradeInputCors.courseName},${gradeInputCors.courseTime}</option>
        </c:forEach>
</select>
<button class="btn btn-primary" onclick="inputGrade()">录入成绩</button>

<h3>录入成绩</h3>
<hr/>
<form id="stuListTable">


</form>
</div>
</div>


</div>





<%@include file="footer.jsp" %>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/teacher.js"></script>

</body>
</html>