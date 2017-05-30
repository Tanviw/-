<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>教师评价</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">


</head>
<body>

<div class="col-md-12 column">
    <div class="headpanel">
        <ul class="nav nav-pills">

            <li><a href="student.jsp">网上选课</a></li>
            <li><a href="#">课表查询</a></li>
            <li><a href="stugrade.jsp">成绩查询</a></li>
            <li class="active"><a href="#">教师评价</a></li>
            <li><a href="#">教师答疑</a></li>

        </ul>
    </div>
<div class="main-content">
<hr/>
评价课程名称:<select onchange="getTeacherName()" id="commentcors">
			<c:forEach var="course" items="${sessionScope.selectedCorsList}">
			<option value="${course.teacherCourseId}" data="${course.teacherName}">${course.courseName}</option>
        	</c:forEach>
		</select>


<h4 style="color:#288690 ;margin-top:30px;">评教师</h4>
<hr/>
<div class="col-md-8">
<table  id="commentTeac" class="data table table-bordered table-striped table-hover" cellspacing="0" cellpadding="0">
        <tbody>
        <tr>
        <th>评价号</th>
        <th>评价内容</th>
        <th style="color: #31708f; font-size: 16px; font-family: '宋体'">${sessionScope.selectedCorsList[0].teacherName}</th>
        </tr>
        <tr>
        <td>1</td>
        <td>教学工作认真负责，按时上课下课</td>
        <td>
        <select>
        <option value=90>优秀</option>
        <option value=80>良好</option>
        <option value=70>一般</option>
        <option value=60>较差</option>
        </select>
        </td>
        </tr>
        <tr>
        <td>2</td>
        <td>讲课条理清晰，语言生动、流畅、概念准确</td>
        <td>
        <select>
        <option value=90>优秀</option>
        <option value=80>良好</option>
        <option value=70>一般</option>
        <option value=60>较差</option>
        </select>
        </td>
        </tr>
        <tr>
        <td>3</td>
        <td>教学内容充实，重点突出，能理论联系实际</td>
        <td>
        <select>
        <option value=90>优秀</option>
        <option value=80>良好</option>
        <option value=70>一般</option>
        <option value=60>较差</option>
        </select>
        </td>
        </tr>
        <tr>
        <td>4</td>
        <td>作业批改认真，答疑辅导充分</td>
        <td>
        <select>
        <option value=90>优秀</option>
        <option value=80>良好</option>
        <option value=70>一般</option>
        <option value=60>较差</option>
        </select>
        </td>
        </tr>
        </tbody>
        </table>
        
</div>
<div class="col-md-4" style="text-indent:2em;color:#31708f">
<p>
不断提高教学质量，是您和我们的共同期盼。对任课教师的授课和课程进行客观、公正的评价，将有关信息反馈到相关部门，能有效提高教学质量。

</p>
<p>
请您给课堂教学质量按左列指标评价，谢谢。
</p>
</div>
<div class="col-md-12  ">其他评价与建议</div>
<div class="col-md-12  ">
<textarea  id="comment">
</textarea>

<button class="btn btn-success" id="commitComment" onclick="commitComment()" >提交</button>  
</div>
</div>


</div>




<%@include file="footer.jsp" %>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/student.js"></script>

</body>
</html>