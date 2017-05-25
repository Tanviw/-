<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>管理员页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/head.css">
    <link rel="stylesheet" href="css/main.css">


</head>
<body ng-app='routingAdminApp'>


<div class="head">
    <!--学校图标及皮肤说明图标-->
    <div class="logo">
        <h2><img src="images/logo_school.png"></h2>
        <h3><img src="images/logo_jw.png" ></h3>
    </div>

        <div class="info"  style="float:right" >
            <ul style="height:90px;line-height:90px">
                <li style="float:left;padding-right:20px">
                    <span id="Label3">欢迎您：</span>
                    <em>
                        <span id="xhxm">${sessionScope.account}&nbsp;${sessionScope.username}&nbsp;${sessionScope.identity}</span></em>

                </li>
                <li style="float:left">
                    <a id="likTc" href="index.jsp">安全退出</a>
                </li>
            </ul>
        </div>

</div>
<div class="clearfix"></div>
<div ng-view>
<div class="col-md-12 column">
    <div class="headpanel">
        <ul class="nav nav-pills">

            <li class="active"><a href="#/">学生信息</a></li>
            <li><a href="#/adminteacher">教师信息</a></li>
            <li><a href="#/adminclassroom">教室信息</a></li>
            <li><a href="#/admincourse">管理课程</a></li>

        </ul>
    </div>
<div  class="searchStudent">
<input type="submit" id="searchStuSubmit"  style="float:right" onclick="searchStudent()" value="搜索学生">
<input type="search" id="searchStudent"   style="float:right" oninput="searchStudent()"  onpropertychange="searchStudent()" placeholder="输入学生姓名或学号">
<div class="clearfix"></div>
</div>
   
   
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
    <form>
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
        	<td><input type="text" name="stuName" placeholder="学生姓名" style="border:none"></td>
        	<td><input type="text" name="idCard" placeholder="身份证号" style="border:none"></td>
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
        	<select name="academy" id="academy" onchange="getMajor(this.options[this.options.selectedIndex].value)">
        	<c:forEach var="academy" items="${sessionScope.academyList}">
        	<option value="${academy}">${academy}</option>
        	</c:forEach>
        	</select>
        	</td>
        	<td  style="width:20%">
        	<select name="major" id="major">
        	
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

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
<script src="http://apps.bdimg.com/libs/angular-route/1.3.13/angular-route.js"></script>
<script>
       angular.module('routingAdminApp',['ngRoute'])
       .config(['$routeProvider', function($routeProvider){
           $routeProvider
           .when('/',{templateUrl:'admin.jsp'})
           .when('/adminteacher',{templateUrl:'adminteacher.html'})
           .when('/adminclassroom',{templateUrl:'adminclassroom.html'})
           .when('/admincourse',{templateUrl:'admincourse.html'})
           .otherwise({redirectTo:'/'});
       }]);
</script>

</body>
</html>

