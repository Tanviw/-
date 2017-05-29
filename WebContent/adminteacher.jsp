<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师信息</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body onload="getResearchFields()">
<div class="col-md-12 column">
    <div class="headpanel">
        <ul class="nav nav-pills">

            <li><a href="admin.jsp">学生信息</a></li>
            <li class="active"><a href="#">教师信息</a></li>
            <li><a href="adminclassroom.jsp">教室信息</a></li>
            <li><a href="admincourse.jsp">课程管理</a></li>

        </ul>
    </div>
<div class="main-content">
<div  class="searchTeacher">
<input type="submit" id="searchTeacSubmit"  style="float:right" onclick="searchTeacher()" value="搜索教师">
<input type="search" id="searchTeacher"   style="float:right" oninput="searchTeacher()"  onpropertychange="searchTeacher()" placeholder="输入教师姓名或工号">
<div class="clearfix"></div>
</div>
   <div class="clearfix"></div>
   <h4 style="color:#337ab7">教师名单</h4>
    <table class="data table table-bordered table-striped table-hover" cellspacing="0" cellpadding="0">
        <tbody id="teacList">
        <tr>
            <th>工号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>职称</th>
            <th>学院</th>
            <th>研究方向</th>
        </tr>
        <c:forEach var="teac" items="${sessionScope.teacList}">
        <tr>
            <td>${teac.teacherAccount}</td>
            <td>${teac.teacherName}</td>
            <td>${teac.sex}</td>
            <td>${teac.technicalTitle}</td>
            <td>${teac.academy}</td>
            <td>${teac.researchFields}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="addTeacherrow">
     <a id="addBtn" href="javascript:;">添加教师</a>
    <form name="addform"   ng-app='addTeacApp' novalidate="novalidate"  ng-controller="validateCtrl">
    <table class="table table-bordered" id="addTeacMsg">
    <tbody>
    	<tr>
            <th>姓名</th>
            <th>身份证号</th>
            <th>性别</th>
            <th>职称</th>
            <th>学院</th>
            <th>研究方向</th>
            <th colspan="2">操作</th>
        </tr>
        <tr>
        	<td><input type="text" name="teacherName" ng-model="teacherName" ng-blur="change=true" ng-focus="change=false" placeholder="教师姓名" style="border:none" required>
        	<p ng-show="addform.teacherName.$error.required && change" style="color:red" >*请输入姓名</p>
        	</td>
        	<td><input type="text" name="idCard" ng-model="idCard" ng-blur="change=true" ng-focus="change=false" placeholder="身份证号" style="border:none" required  ng-pattern="/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/">
        	<p ng-show="addform.idCard.$invalid && change" style="color:red">*身份证号不合法</p>
        	</td>
        	<td style="width:5%">
        	<select name="sex">
        	<option value="男">男</option>
        	<option value="女">女</option>
        	</select>
        	</td>
        	<td style="width:5%">
        	<select name="technicalTitle">
        	<option value="讲师">讲师</option>
        	<option value="副教授">副教授</option>
        	<option value="教授">教授</option>
        	<option value="助教">助教</option>
        	
        	</select></td>
        	<td style="width:20%">
        	<select name="academy" id="academy" onchange="getResearchFields()">
        	<c:forEach var="academy" items="${sessionScope.academyList}">
        	<option value="${academy}">${academy}</option>
        	</c:forEach>
        	</select>
        	</td>
        	<td  style="width:20%">
        	<select name="researchFields" id="researchFields">
        	
        	</select>
        	</td>
        	<td><a href="javascipt:void(0);" id="addTeacher" onclick="addTeacher()">确认添加</a></td>
        	<td><a href="javascipt:void(0);" type="reset">重置</a></td>
        </tr>
    </tbody>
    
    </table>
    </form>
    </div>
</div>
</div>
<%@include file="footer.jsp" %>


<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
<script>
var app = angular.module('addTeacApp', []);
app.controller('validateCtrl', function($scope) {
	$scope.change = false;  
});
</script>
</body>
</html>