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
<body onload="checkGrade()">

<div class="col-md-12 column">
    <div class="headpanel">
        <ul class="nav nav-pills">

            <li><a href="student.jsp">网上选课</a></li>
            <li><a href="#">课表查询</a></li>
            <li  class="active"><a href="#">成绩查询</a></li>
            <li><a href="stucomment.jsp">教师评价</a></li>
            <li><a href="#">教师答疑</a></li>

        </ul>
    </div>
<div class="main-content">
<hr/>
<div id='gpa'>
</div>
<div id='gradeList'>

</div>




</div>
</div>




<%@include file="footer.jsp" %>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/student.js"></script>

</body>
</html>