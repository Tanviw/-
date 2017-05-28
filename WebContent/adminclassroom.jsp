<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教室信息</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div class="col-md-12 column">
    <div class="headpanel">
        <ul class="nav nav-pills">

            <li><a href="admin.jsp">学生信息</a></li>
            <li><a href="adminteacher.jsp">教师信息</a></li>
            <li class="active"><a href="#">教室信息</a></li>
            <li><a href="admincourse.jsp">课程管理</a></li>

        </ul>
    </div>
    <div class="main-content">
    <div style="float:right">
    <input type="text" name="classroom" placeholder="输入教室地点" id="addClassroom" style=" margin:10px 0 10px 0;height:30px;">
    <button class="btn btn-primary" onclick="addClassroom()">增加教室</button>
    <div class="clearfix"></div>
    </div>
    <div class="clearfix"></div>
    <h4 style="color:#337ab7">教室列表</h4>
    <div id="classroomUl">
        <ul id="classRoomList">
        <c:forEach var="classRoom" items="${sessionScope.classRoomList}" varStatus="status">
        
            <li><input type="checkbox" name="classroomlocation" value="${classRoom}">${classRoom}</li>
        </c:forEach>
        </ul>
     </div>   
   <div class="clearfix"></div>
    <div>
    <input type="checkbox" name="selectAll" id="selectAll" onclick="selectAll()">全选
    </div>
    <div style="float:right">
    	<button class="btn btn-primary" onclick="delClassroom()">删除教室</button>
    </div>
    <div class="clearfix"></div>
    </div>
</div>
<%@include file="footer.jsp" %>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
</body>
</html>