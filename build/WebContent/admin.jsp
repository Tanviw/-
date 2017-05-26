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

            <li class="active"><a href="#">学生信息</a></li>
            <li><a href="adminteacher.jsp">教师信息</a></li>
            <li><a href="adminclassroom.jsp">教室信息</a></li>
            <li><a href="admincourse.jsp">管理课程</a></li>

        </ul>
    </div>
<div class="main-content">
<div  class="searchStudent">
<input type="submit" id="searchStuSubmit"  style="float:right" onclick="searchStudent()" value="搜索学生">
<input type="search" id="searchStudent"   style="float:right" oninput="searchStudent()"  onpropertychange="searchStudent()" placeholder="输入学生姓名或学号">
<div class="clearfix"></div>
</div>
<div class="clearfix"></div>
   <h4 style="color:#337ab7">学生名单</h4>
    <table class="data table table-bordered table-striped" cellspacing="0" cellpadding="0">
        <tbody id="stuList">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年级</th>
            <th>学院</th>
            <th>专业</th>
        </tr>
        <c:forEach var="stu" items="${sessionScope.stuList}">
        <tr>
            <td>${stu.stuAccount}</td>
            <td>${stu.stuName}</td>
            <td>${stu.sex}</td>
            <td>${stu.grade}</td>
            <td>${stu.academy}</td>
            <td>${stu.major}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="addStudentrow">
     <a id="addBtn" href="javascript:;">添加学生</a>
    <form name="addform"   ng-app='addStuApp' novalidate="novalidate"  ng-controller="validateCtrl">
    <table class="table table-bordered" id="addStuMsg">
    <tbody>
    	<tr>
            <th>姓名</th>
            <th>身份证号</th>
            <th>性别</th>
            <th>年级</th>
            <th>学院</th>
            <th>专业</th>
            <th colspan="2">操作</th>
        </tr>
        <tr>
        	<td><input type="text" name="stuName" ng-model="stuName" ng-blur="change=true" ng-focus="change=false" placeholder="学生姓名" style="border:none" required>
        	<p ng-show="addform.stuName.$error.required && change" style="color:red" >*请输入姓名</p>
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
        	<select name="grade">
        	<option value="大一">大一</option>
        	<option value="大二">大二</option>
        	<option value="大三">大三</option>
        	<option value="大四">大四</option>
        	</select></td>
        	<td style="width:20%">
        	<select name="academy" id="academy"  onchange="getMajor(this.options[this.options.selectedIndex].value)">
        	<c:forEach var="academy" items="${sessionScope.academyList}">
        	<option value="${academy}">${academy}</option>
        	</c:forEach>
        	</select>
        	</td>
        	<td  style="width:20%">
        	<select name="major" id="major" >
        	
        	</select>
        	</td>
        	<td><a href="javascipt:void(0);" id="addStudent">确认添加</a></td>
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
	var app = angular.module('addStuApp', []);
	app.controller('validateCtrl', function($scope) {
		$scope.change = false;  
	});
</script>

</body>
</html>

