<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>教师答疑</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">


</head>
<body>

<div class="col-md-12 column " >
    <div class="headpanel">
        <ul class="nav nav-pills">

            <li><a href="teachercheckcomm.jsp">查看课程评价</a></li>
            <li><a href="ShowGradeNotInputCorsServlet">录入课程成绩</a></li>
            <li class="active"><a href="#">教师答疑</a>
            <c:if test="${sessionScope.unsolvedQuesNum>0}">
            <span id='teacdy'>${unsolvedQuesNum}</span>
            </c:if>
            </li>
           
        </ul>
    </div>
 
<div class="main-content ">
<hr/>

		<div class="col-md-4 column corslist">
		<h3>授课列表</h3>
		<ul>
       	<c:forEach var="teaccourse" items="${sessionScope.teacCors}">
        <li data="${teaccourse.teacherCourseId}" onclick="showTeacQues(this)">${teaccourse.courseName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${teaccourse.courseTime}</li>
        </c:forEach>

</ul>
		
		</div>
		<div class="col-md-8 column">
		
		<div class="tabbable" id="tabsquestion">
				<ul class="nav nav-tabs">
					<li class="active">
						 <a href="#panel-ask" data-toggle="tab">新的提问</a>
					</li>
					
					<li>
						 <a href="#panel-solved" data-toggle="tab">已回答</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="panel-ask">
					<div>
					<ul id="teacquesList">
					
					</ul>
					<div id="subAns"></div>
					</div>
						
					</div>
					<div class="tab-pane" id="panel-solved">
						<ul id="teacansList">
					
						</ul>
					</div>
				</div>
			</div>
		
		</div>
	

</div>
</div>


<%@include file="/footer.jsp" %>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/teacher.js"></script>

</body>
</html>