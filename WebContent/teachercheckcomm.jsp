<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>教师查看评价</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">


</head>
<body onload="checkComment()" style="background:#eae7e0">

<div class="col-md-12 column " >
    <div class="headpanel">
        <ul class="nav nav-pills">

            <li class="active"><a href="#">查看课程评价</a></li>
            <li><a href="ShowGradeNotInputCorsServlet">录入课程成绩</a></li>
            <li><a href="#">学生答疑</a></li>
           
        </ul>
    </div>
 
<div class="main-content ">

<div class="teacComment">
<hr/>
<span>课程名称及上课时间：</span>
<select id="teacherCorsSele" onchange="checkComment()">

 <c:forEach var="teaccourse" items="${sessionScope.teacCors}">
        <option value="${teaccourse.teacherCourseId}">${teaccourse.courseName},${teaccourse.courseTime}</option>
        </c:forEach>
</select>

<span>平均分：</span><span id="avgGrade" style="color:green;font-size:20px;"></span>


<h4 style="text-align:center">学生评价与建议</h4>
<hr/>
</div>
<div id="commentContent" class="col-md-12">

</div>
</div>


</div>





<%@include file="footer.jsp" %>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/teacher.js"></script>

</body>
</html>