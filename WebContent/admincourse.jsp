<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程管理</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>
<div class="col-md-12 column">
    <div class="headpanel">
        <ul class="nav nav-pills">

            <li><a href="admin.jsp">学生信息</a></li>
            <li><a href="adminteacher.jsp">教师信息</a></li>
            <li><a href="adminclassroom.jsp">教室信息</a></li>
            <li class="active"><a href="#">课程管理</a></li>

        </ul>
    </div>
<div class="main-content">
<div  class="searchCourse">
<input type="submit" id="searchCorsSubmit"  style="float:right" onclick="searchCourse()" value="搜索课程">
<input type="search" id="searchCourse"   style="float:right" oninput="searchCourse()"  onpropertychange="searchCourse()" placeholder="输入课程代码或名称">

</div>
<div class="clearfix"></div>
<h4 style="color:#337ab7">课程列表</h4>
    <table class="data table table-bordered table-striped" cellspacing="0" cellpadding="0">
        <tbody id="courseList">
        <tr>
            <th>课程代码</th>
            <th>课程名称</th>
            <th>学分</th>
            <th>总学时</th>
            
        </tr>
        <c:forEach var="course" items="${sessionScope.courseList}">
        <tr>
            <td>${course.courseNumber}</td>
            <td>${course.courseName}</td>
            <td>${course.credit}</td>
            <td>${course.classHour}</td>
            
        </tr>
        </c:forEach>
        </tbody>
    </table>
 <div id="addCourserow">
    <a id="addBtn" href="javascript:;">添加课程</a>
    <form name="addform">
    <table class="table table-bordered table-hover" id="addCourseMsg">
    <tbody>
    	<tr>
            <th>课程代码</th>
            <th>课程名称</th>
            <th>学分</th>
            <th>总学时</th>
            
            <th colspan="2">操作</th>
        </tr>
        <tr>
        	<td><input type="text" name="courseNumber" placeholder="课程代码" style="border:none" required>
        	</td>
        	<td><input type="text" name="courseName"  placeholder="课程名称" style="border:none" required >
        	</td>
        	<td style="width:5%">
        	<select name="credit" id="credit"  onchange="getClasshour(this.options.selectedIndex)">
        	<option value="2">2</option>
        	<option value="3">3</option>
        	<option value="4">4</option>
        	<option value="6">6</option>
        	</select>
        	</td>
        	<td style="width:5%">
        	<select name="classHour"  id="classHour" onchange="getCredit(this.options.selectedIndex)">
        	<option value="32">32</option>
        	<option value="48">48</option>
        	<option value="64">64</option>
        	<option value="96">96</option>
        	</select>
        	</td>
        	
        	<td><a href="javascipt:void(0);" id="addCourse" onclick="addCourse()">确认添加</a></td>
        	<td><a href="javascipt:void(0);" type="reset">重置</a></td>
        </tr>
    </tbody>
    
    </table>
    </form>
    </div>


	<div class="row clearfix" id="openCourseContainer" >
		<div class="col-md-4 col-md-offset-4 column" id="openCourserow">
		<h4 style="text-align:center;color:#288690">为课程分配教师</h4>
			<div class="form-horizontal">
				<div class="form-group">
					 <label  class="col-sm-4 control-label">课程代码:</label>
					<div class="col-sm-8">
						<label id="courseNumberval" class="col-sm-8 control-label"></label>
					</div>
				</div>
				<div class="form-group">
					 <label  class="col-sm-4 control-label">课程名称:</label>
					<div class="col-sm-8">
						<label id="courseNameval" class="col-sm-8 control-label"></label>
					</div>
				</div>
				<div class="form-group">
					 <label  class="col-sm-4 control-label">课程学时:</label>
					<div class="col-sm-8">
						<label id="classHourval" class="col-sm-8 control-label"></label>
					</div>
				</div>
				<div class="form-group">
					 <label class="col-sm-4 control-label">任课教师:</label>
					<div class="col-sm-8">
						<select name='teacherOpt' id='teacherOpt' onchange="searchCourseTime()">
						
						</select>
					</div>
				</div>
				<div class="form-group">
					 <label  class="col-sm-4 control-label">上课时间:</label>
					<div class="col-sm-8">
						<select name='courseTime' id='courseTime' onchange="searchClassroom()">
						
						</select>
					</div>
				</div>
				<div class="form-group">
					 <label  class="col-sm-4 control-label" >上课地点:</label>
					<div class="col-sm-8">
						<select name='classroomloc' id='classroomloc'>
						
						</select>
					</div>
				</div>
				<div class="form-group">
					 <label for="capacity" class="col-sm-4 control-label">容量</label>
					<div class="col-sm-8">
						<input type="number" class="form-control" id="capacity" oninput="checkCapaticy()"  style="width:80px;height:30px"/>
						<span id="capacityHint" style="color:red;display:none">*容量不能超过30</span>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-3 col-sm-offset-3 ">
						 <button class="btn btn-primary" id="confirmOpenCourse">确定</button>
					</div>
					<div class="col-sm-3 ">
						 <button class="btn btn-primary" id="cancelOpenCourse">取消</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="openCorsMess" class="col-md-6 col-md-offset-3 column">
		 <table class="table table-bordered" id="addCourseMsg">
    		<tbody id="openedCourse">
    		
        	
        	</tbody>
        	</table>
        	<button class="btn btn-danger" id="closeopencorsmsg" style="float:right">关闭</button>
	</div>

</div>
</div>
<div class="clearfix"></div>
<%@include file="footer.jsp" %>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/admin.js"></script>


</body>
</html>