var editBtnClicked=false;

$(document).ready(function(){
	var academy=$("#academy option:selected").val();
	getMajor(academy);
	
	$("#addStudent").click(function(){
		var stuArr=$("#addStuMsg").find("input");
		var stuName=stuArr[0].value;
		var idCard=stuArr[1].value;
		var stuSelectItems=$("#addStuMsg option:selected");
		var sex=stuSelectItems[0].value;
		var grade=stuSelectItems[1].value;
		var academy=stuSelectItems[2].value;
		var major=stuSelectItems[3].value;
		$.ajax({
	        type:"POST",
	        url:"AddStuServlet",
	        data:{
	            "stuName":stuName,
	            "idCard":idCard,
	            "sex":sex,
	            "grade":grade,
	            "academy":academy,
	            "major":major
	        },
	        success:function(data,status) {
	            if(data!="error"){
	            	alert("添加学生成功");
	            	$("#stuList").append("<tr><td>"+data+"</td><td>"
	            			+stuName+"</td><td>"
	            			+sex+"</td><td>"
	            			+grade+"</td><td>"
	            			+academy+"</td><td>"
	            			+major+"</tr>");
	            	stuArr[0].value="";   
	            	stuArr[1].value="";
	                       	
	            }else{
	            	alert("添加学生返回数据失败");
	            }
	        },
	        error: function() {
	            alert("添加学生出了点问题");
	        }
	    });
	});
	

	
});
function hideHints(){
	$("#loginHints").html('');
}

function getMajor(value){
	var academy=value;
	$.ajax({
        type:"POST",
        url:"GetMajorServlet",
        data:{
            "academy":academy
        },
        success:function(data,status) {
            if(data!=0){
            	var option="";
            	
            	var array=data.substring(1,data.length-1).split(",");
            	for(var i=0;i<array.length;i++){
            		option=option+"<option value="+array[i]+">"+array[i]+"</option>";
            	}
            	$("#major").html(option);
                       	
            }
        },
        error: function() {
            alert("获取专业失败");
        }
    });
	
}
function searchStudent(){
	var message=$("#searchStudent").val();
	$.ajax({
        type:"POST",
        url:"SearchStudentServlet",
        data:{
            "message":message
        },
        success:function(data,status) {
            if(data!="error"){
            	var studentMsg = $.parseJSON(data);
            	var stu="<tr><th>学号</th><th>姓名</th> <th>性别</th><th>年级</th><th>学院</th><th>专业</th><th colspan='2'>操作</th></tr>";
                for( var i = 0;i<studentMsg.length; i++) {
                    stu=stu+"<tr><td>"+studentMsg[i].stuAccount+"</td><td>"
                    +studentMsg[i].stuName+"</td><td>"
                    +studentMsg[i].sex+"</td><td>"
                    +studentMsg[i].grade+"</td><td>"
                    +studentMsg[i].academy+"</td><td>"
                    +studentMsg[i].major+"</td>"
                    +"<td><a href='javascipt:void(0);' class='edit' onclick='editStudent(this)' >编辑</a></td><td><a href='javascipt:void(0);' class='delete' onclick='deleteStudent(this)' >删除</a></td></tr>";
                }
                $("#stuList").html(stu);
               
            }else{
            	
            }
        },
        error: function() {
            alert("获取学生信息失败");
        }
    });
}



function editStudent(e){

	if(!editBtnClicked){
		editBtnClicked=true;
		var stuAccount=$(e).parent().parent().find("td:eq(0)").text();
		
		var previous=$("#addStudentrow");
		var prehtml=previous.html();
		
		var parent=$(e).parent().parent();//编辑所在行tr
		var stuName=parent.find('td:eq(1)').text();//姓名
		var sex=parent.find('td:eq(2)').text();//性别
		var grade=parent.find('td:eq(3)').text();//年级
		var academy=parent.find('td:eq(4)').text();//学院
		var major=parent.find('td:eq(5)').text();//专业
		 
		previous.find("a:eq(0)").text("编辑学生");
		previous.find("th:eq(1)").replaceWith('<th>密码</th>');
		previous.find("input:eq(0)").val(stuName);
		previous.find("p").remove();
		previous.find("input:eq(1)").replaceWith('<input type="password" name="password"  style="border:none" >');
		previous.find("option[value="+sex+"]").attr("selected",true);
		previous.find("option[value="+grade+"]").attr("selected",true);
		previous.find("option[value="+academy+"]").attr("selected",true);
		getMajor(academy);
		previous.find("td:eq(-2)").replaceWith('<td><a href="javascipt:void(0);" id="confirm">确认修改</a></td>');
		previous.find("td:eq(-1)").replaceWith('<td><a href="javascipt:void(0);" id="cancel">取消</a></td>');
		
		$("#major").find("option[value="+major+"]").attr("selected",true);
		$("#confirm").click(function(){
			var stuArr=$("#addStuMsg").find("input");
			var stuName=stuArr[0].value;
			var password=stuArr[1].value;
			var stuSelectItems=$("#addStuMsg option:selected");
			var sex=stuSelectItems[0].value;
			var grade=stuSelectItems[1].value;
			var academy=stuSelectItems[2].value;
			var major=stuSelectItems[3].value;
			$.ajax({
		        type:"POST",
		        url:"EditStuServlet",
		        data:{
		        	"stuAccount":stuAccount,
		            "stuName":stuName,
		            "password":password,
		            "sex":sex,
		            "grade":grade,
		            "academy":academy,
		            "major":major
		        },
		        success:function(data,status) {
		            if(data!="error"){
		            	alert("修改学生成功");
		        		parent.find('td:eq(1)').text(stuName);//姓名
		        		parent.find('td:eq(2)').text(sex);//性别
		        		parent.find('td:eq(3)').text(grade);//年级
		        		parent.find('td:eq(4)').text(academy);//学院
		        		parent.find('td:eq(5)').text(major);//专业
		        		stuArr[0].value="";   
		            	stuArr[1].value="";
		        		
		                       	
		            }else{
		            	alert("修改学生返回数据失败");
		            }
		        },
		        error: function() {
		            alert("修改学生出了点问题");
		        }
		    });
			editBtnClicked=false;
		});
		
		$("#cancel").click(function(){
			$("#addStudentrow").html(prehtml);
			editBtnClicked=false;
		});
	}
	
	
	
	
}


function deleteStudent(e){
	var msg = "您真的确定要删除吗？";
	if (confirm(msg)==true){
	var parent=$(e).parent().parent();
	var stuAccount=parent.find('td:eq(0)').text();
	$.ajax({
        type:"POST",
        url:"DelStuServlet",
        data:{
            "stuAccount":stuAccount
        },
        success:function(data,status) {
            if(data=="ok"){
            	parent.remove();
            }else{
            	alert("servlet出了点问题");
            }
        },
        error: function() {
            alert("删除学生失败");
        }
    });
	}
}

function getResearchFields(){

	var academy=$("#academy option:selected").val();

	$.ajax({
        type:"POST",
        url:"GetResearchServlet",
        data:{
            "academy":academy
        },
        success:function(data,status) {
            if(data!="error"){
            	var researchMsg = $.parseJSON(data);
            	var option="";
            	for(var i=0;i<researchMsg.length;i++){
            		option=option+"<option value="+researchMsg[i].researchFields+">"+researchMsg[i].researchFields+"</option>";
            	}
            	$("#researchFields").html(option);
                       	
            }else{
            	alert("服务器返回error");
            }
        },
        error: function() {
            alert("获取研究方向失败");
        }
    });

}

function addTeacher(){
	var teacArr=$("#addTeacMsg").find("input");
	var teacherName=teacArr[0].value;
	var idCard=teacArr[1].value;
	var teacSelectItems=$("#addTeacMsg option:selected");
	var sex=teacSelectItems[0].value;
	var technicalTitle=teacSelectItems[1].value;
	var academy=teacSelectItems[2].value;
	var researchFields=teacSelectItems[3].value;
	$.ajax({
        type:"POST",
        url:"AddTeacServlet",
        data:{
            "teacherName":teacherName,
            "idCard":idCard,
            "sex":sex,
            "technicalTitle":technicalTitle,
            "academy":academy,
            "researchFields":researchFields
        },
        success:function(data,status) {
            if(data!="error"){
            	alert("添加教师成功");
            	$("#teacList").append("<tr><td>"+data+"</td><td>"
            			+teacherName+"</td><td>"
            			+sex+"</td><td>"
            			+technicalTitle+"</td><td>"
            			+academy+"</td><td>"
            			+researchFields+"</tr>");
            	teacArr[0].value="";   
            	teacArr[1].value="";
            }else{
            	alert("添加教师返回数据失败");
            }
        },
        error: function() {
            alert("添加教师出了点问题");
        }
    });
}

function searchTeacher(){
	var message=$("#searchTeacher").val();
	$.ajax({
        type:"POST",
        url:"SearchTeacherServlet",
        data:{
            "message":message
        },
        success:function(data,status) {
            if(data!="error"){
            	var teacherMsg = $.parseJSON(data);
            	var teac="<tr><th>工号</th><th>姓名</th> <th>性别</th><th>职称</th><th>学院</th><th>研究方向</th><th colspan='2'>操作</th></tr>";
                for( var i = 0;i<teacherMsg.length; i++) {
                	teac=teac+"<tr><td>"+teacherMsg[i].teacherAccount+"</td><td>"
                    +teacherMsg[i].teacherName+"</td><td>"
                    +teacherMsg[i].sex+"</td><td>"
                    +teacherMsg[i].technicalTitle+"</td><td>"
                    +teacherMsg[i].academy+"</td><td>"
                    +teacherMsg[i].researchFields+"</td>"
                    +"<td><a href='javascipt:void(0);' class='edit' onclick='editTeacher(this)' >编辑</a></td><td><a href='javascipt:void(0);' class='delete' onclick='deleteTeacher(this)' >删除</a></td></tr>";
                }
                $("#teacList").html(teac);
               
            }else{
            	alert("服务器不知道返回了啥");
            }
        },
        error: function() {
            alert("获取学生信息失败");
        }
    });
}

function editTeacher(e){

	if(!editBtnClicked){
		editBtnClicked=true;
		var teacherAccount=$(e).parent().parent().find("td:eq(0)").text();
		
		var previous=$("#addTeacherrow");
		var prehtml=previous.html();
		
		var parent=$(e).parent().parent();//编辑所在行tr
		var teacherName=parent.find('td:eq(1)').text();//姓名
		var sex=parent.find('td:eq(2)').text();//性别
		var technicalTitle=parent.find('td:eq(3)').text();//职称
		var academy=parent.find('td:eq(4)').text();//学院
		var researchFields=parent.find('td:eq(5)').text();//研究方向
		 
		previous.find("a:eq(0)").text("编辑教师");
		previous.find("th:eq(1)").replaceWith('<th>密码</th>');
		previous.find("input:eq(0)").val(teacherName);
		previous.find("p").remove();
		previous.find("input:eq(1)").replaceWith('<input type="password" name="password"  style="border:none" >');
		previous.find("option[value="+sex+"]").attr("selected",true);
		previous.find("option[value="+technicalTitle+"]").attr("selected",true);
		previous.find("option[value="+academy+"]").attr("selected",true);
		getResearchFields(academy);
		previous.find("td:eq(-2)").replaceWith('<td><a href="javascipt:void(0);" id="confirm">确认修改</a></td>');
		previous.find("td:eq(-1)").replaceWith('<td><a href="javascipt:void(0);" id="cancel">取消</a></td>');
		
		$("#confirm").click(function(){
			var teacArr=$("#addTeacMsg").find("input");
			var teacherName=teacArr[0].value;
			var password=teacArr[1].value;
			var teacSelectItems=$("#addTeacMsg option:selected");
			var sex=teacSelectItems[0].value;
			var technicalTitle=teacSelectItems[1].value;
			var academy=teacSelectItems[2].value;
			var researchFields=teacSelectItems[3].value;
			$.ajax({
		        type:"POST",
		        url:"EditTeacServlet",
		        data:{
		        	"teacherAccount":teacherAccount,
		            "teacherName":teacherName,
		            "password":password,
		            "sex":sex,
		            "technicalTitle":technicalTitle,
		            "academy":academy,
		            "researchFields":researchFields
		        },
		        success:function(data,status) {
		            if(data!="error"){
		            	alert("修改教师成功");
		        		parent.find('td:eq(1)').text(teacherName);//姓名
		        		parent.find('td:eq(2)').text(sex);//性别
		        		parent.find('td:eq(3)').text(technicalTitle);//职称
		        		parent.find('td:eq(4)').text(academy);//学院
		        		parent.find('td:eq(5)').text(researchFields);//研究方向
		        		teacArr[0].value="";   
		            	teacArr[1].value="";
		        		
		                       	
		            }else{
		            	alert("修改教师返回数据失败");
		            }
		        },
		        error: function() {
		            alert("修改教师出了点问题");
		        }
		    });
			editBtnClicked=false;
		});
		
		$("#cancel").click(function(){
			$("#addTeacherrow").html(prehtml);
			editBtnClicked=false;
		});
	}
	
}

function deleteTeacher(e){
	var msg = "您真的确定要删除吗？";
	if (confirm(msg)==true){
	var parent=$(e).parent().parent();
	var teacherAccount=parent.find('td:eq(0)').text();
	$.ajax({
        type:"POST",
        url:"DelTeacServlet",
        data:{
            "teacherAccount":teacherAccount
        },
        success:function(data,status) {
            if(data=="ok"){
            	parent.remove();
            }else{
            	alert("servlet出了点问题");
            }
        },
        error: function() {
            alert("删除教师失败");
        }
    });
	}
}
var selectedAll=false;
function selectAll(){
	if(!selectedAll){
		$('#classRoomList input[name="classroomlocation"]').attr("checked",'true');
		selectedAll=true;
	}else{
		$('#classRoomList input[name="classroomlocation"]').removeAttr("checked");
		selectedAll=false;
	}
	
}
function delClassroom(){
	var msg = "您真的确定要删除吗？";
	if (confirm(msg)==true){
	var classroomArr =[]; 
	$('#classRoomList input[name="classroomlocation"]:checked').each(function(){ 
		classroomArr.push($(this).val()); 
	});
	
	$.ajax({
		traditional: true,
        type:"POST",
        url:"DelClassroomServlet",
        data:{
            "classroomArr":classroomArr
        },
        success:function(data,status) {
            if(data=="ok"){
            	$('#classRoomList input[name="classroomlocation"]:checked').each(function(){ 
            		$(this).parent().remove(); 
            	});
            }else{
            	alert("servlet出了点问题");
            }
        },
        error: function() {
            alert("删除教室失败");
        }
    });
	}
	
	
}

function addClassroom(){
	var classRoomLocation=$("#addClassroom").val();

	$.ajax({
		
        type:"POST",
        url:"AddClassroomServlet",
        data:{
            "classRoomLocation":classRoomLocation
        },
        success:function(data,status) {
            if(data=="ok"){
            	var li='<li><input type="checkbox" name="classroomlocation" value="'+classRoomLocation+'">'+classRoomLocation+'</li>';
            	$("#classRoomList").append(li);
            	
            }else{
            	alert("servlet出了点问题");
            }
        },
        error: function() {
            alert("增加教室失败");
        }
    });
}

function getClasshour(e){
	 $("#classHour").get(0).selectedIndex=e;
}

function getCredit(e){
	 $("#credit").get(0).selectedIndex=e;
}

function addCourse(){
	var courseArr=$("#addCourseMsg").find("input");
	var courseNumber=courseArr[0].value;
	var courseName=courseArr[1].value;
	var courseSelectItems=$("#addCourseMsg option:selected");
	var credit=courseSelectItems[0].value;
	var classHour=courseSelectItems[1].value;
	$.ajax({
		
        type:"POST",
        url:"AddCourseServlet",
        data:{
            "courseNumber":courseNumber,
            "courseName":courseName,
            "credit":credit,
            "classHour":classHour
        },
        success:function(data,status) {
            if(data=="ok"){
            	$("#courseList").append("<tr><td>"+courseNumber+"</td><td>"
            			+courseName+"</td><td>"
            			+credit+"</td><td>"
            			+classHour+"</td></tr>");
            	courseArr[0].value="";   
            	courseArr[1].value="";
            }else{
            	alert("servlet出了点问题");
            }
        },
        error: function() {
            alert("添加课程失败");
        }
    });
}


function searchCourse(){
	var message=$("#searchCourse").val();
	$.ajax({
        type:"POST",
        url:"SearchCourseServlet",
        data:{
            "message":message
        },
        success:function(data,status) {
            if(data!="error"){
            	var courseMsg = $.parseJSON(data);
            	var cors="<tr><th>课程代码</th><th>课程名称</th> <th>学分</th><th>总学时</th><th colspan='3'>操作</th></tr>";
                for( var i = 0;i<courseMsg.length; i++) {
                	cors=cors+"<tr><td>"+courseMsg[i].courseNumber+"</td><td>"
                    +courseMsg[i].courseName+"</td><td>"
                    +courseMsg[i].credit+"</td><td>"
                    +courseMsg[i].classHour+"</td>"
                    +"<td><a href='javascipt:void(0);'  onclick='openCourse(this)' >开课</a></td><td><a href='javascipt:void(0);' onclick='CourseOpenedMsg(this)'>查看课程已开设信息</a></td><td><a href='javascipt:void(0);'  onclick='deleteCourse(this)' >删除课程</a></td></tr>";
                }
                $("#courseList").html(cors);
               
            }else{
            	
            }
        },
        error: function() {
            alert("获取课程信息失败");
        }
    });
}
function CourseOpenedMsg(e){
	
	var parent=$(e).parent().parent();
	var courseNumber=parent.find('td:eq(0)').text();
	$("#openCorsMess").css("display","block");
	$.ajax({
        type:"POST",
        url:"SearchCorsopenedServlet",
        data:{
            "courseNumber":courseNumber
        },
        success:function(data,status) {
            if(data!="error"){
            	var opencourseMsg = $.parseJSON(data);
            	var cors="<tr><th>课程代码</th><th>课程名称</th><th>开课教师</th>"
            +"<th>学分</th><th>上课时间</th><th>上课地点</th><th>容量</th><th>余量</th></tr>";
            	  for( var i = 0;i<opencourseMsg.length; i++) {
            		  cors+="<tr><td>"+opencourseMsg[i].courseNumber+"</td><td>"
            		  +opencourseMsg[i].courseName+"</td><td>"+opencourseMsg[i].teacherName+"</td><td>"
            		  +opencourseMsg[i].credit+"</td><td>"+opencourseMsg[i].courseTime+"</td><td>"
            		  +opencourseMsg[i].classRoomLocation+"</td><td>"+opencourseMsg[i].capacity+"</td><td>"
            		  +opencourseMsg[i].surplus+"</td></tr>";
            	  }
            	$("#openedCourse").html(cors);
            }else{
            	alert("servlet出了点问题");
            }
        },
        error: function() {
            alert("查看课程失败");
        }
    });
	
	$("#closeopencorsmsg").click(function(){
		$("#openedCourse").html("");
		$("#openCorsMess").css("display","none");
	});
	
}


function deleteCourse(e){
	var msg = "您真的确定要删除吗？";
	if (confirm(msg)==true){
	var parent=$(e).parent().parent();
	var courseNumber=parent.find('td:eq(0)').text();
	$.ajax({
        type:"POST",
        url:"DelCorsServlet",
        data:{
            "courseNumber":courseNumber
        },
        success:function(data,status) {
            if(data=="ok"){
            	parent.remove();
            }else{
            	alert("servlet出了点问题");
            }
        },
        error: function() {
            alert("删除课程失败");
        }
    });
	}
}

function openCourse(e){
	if(!editBtnClicked){
		editBtnClicked=true;
		
	$.ajax({
        type:"GET",
        url:"findTeacServlet",
        data:{
            
        },
        success:function(data,status) {
            if(data!="error"){
            
            	var teacDom="";
            	var teacherMsg = $.parseJSON(data);//返回的是包含教师账号和教师姓名的json数组
            	
            	for( var i = 0;i<teacherMsg.length; i++) {
            		teacDom=teacDom+'<option value="'+teacherMsg[i].teacherAccount+'">'+teacherMsg[i].teacherName+'</option>';
                }
            	$("#teacherOpt").html(teacDom);
            	searchCourseTime();
            	searchClassroom();
            }else{
            	alert("servlet出了点问题");
            }
        },
        error: function() {
            alert("获取教师失败");
        }
    });
	
		var parent=$(e).parent().parent();//编辑所在行tr
		var courseNumber=parent.find('td:eq(0)').text();//课程代码
		var courseName=parent.find('td:eq(1)').text();//课程名称
		var credit=parent.find('td:eq(2)').text();//学分
		var classHour=parent.find('td:eq(3)').text();//总学时
		$("#openCourserow").css("display","block");
		$("#courseNumberval").text(courseNumber);
		$("#courseNameval").text(courseName);
		$("#classHourval").text(classHour);
		
		
		
		
	}
	
}

$("#cancelOpenCourse").click(function(){
	$("#openCourserow").css("display","none");
	editBtnClicked=false;
});

$("#confirmOpenCourse").click(function(){
	var courseNumber=$("#courseNumberval").text();
	var teacherAccount=$("#teacherOpt option:selected").val();
	
	var courseTimeId=$("#courseTime option:selected").val();
	var classRoomId=$("#classroomloc option:selected").val();
	var capacity=$("#capacity").val();
	$.ajax({
        type:"POST",
        url:"OpenCourseServlet",
        data:{
        	"teacherAccount":teacherAccount,
            "courseNumber":courseNumber,
            "courseTimeId":courseTimeId,
            "classRoomId":classRoomId,
            "capacity":capacity
        },
        success:function(data,status) {
            if(data!="error"){
            	    alert("开设课程成功");
            	    //$("#openCourserow").css("display","none");
            }else{
            	alert("开设课程失败");	
            	// $("#openCourserow").css("display","none");
            }
        },
        error:function(XMLHttpRequest, textStatus, errorThrown) {
           alert(XMLHttpRequest.readyState);
           alert(XMLHttpRequest.status);
            //$("#openCourserow").css("display","none");
        }
    });
	$("#openCourserow").css("display","none");
	editBtnClicked=false;
});

function searchCourseTime(){
	
	var classHour=$("#classHourval").text();
	var teacherAccount=$("#teacherOpt option:selected").val();
	//var classRoomId=$("#classroomloc option:selected").val();
	$.ajax({
        type:"POST",
        url:"GetCoursetimeServlet",
        data:{
            "classHour":classHour,
            "teacherAccount":teacherAccount
            //"classRoomId":classRoomId
        },
        success:function(data,status) {
            if(data!="error"){
            	var corsMsg = $.parseJSON(data);//返回的是包含上课时间id和上课时间描述的json数组
            	var corstime="";
            	for( var i = 0;i<corsMsg.length; i++) {
            		corstime=corstime+'<option value="'+corsMsg[i].courseTimeId+'">'+corsMsg[i].courseTime+'</option>"';
                }
            	
            	$("#courseTime").html(corstime);
            }else{
            	alert("servlet出了点问题");
            }
        },
        error: function() {
            alert("获取上课时间失败");
        }
    });
	
	
}
function searchClassroom(){
	var courseTimeselected=$("#courseTime option:selected").val();//上课时间ID
	$.ajax({
        type:"POST",
        url:"GetClassroomServlet",
        data:{
            "courseTimeselected":courseTimeselected
        },
        success:function(data,status) {
            if(data!="error"){
            	var clsrromMsg = $.parseJSON(data);//返回的是包含教室id和教室地点的json数组
            	var clsrrom="";
            	for( var i = 0;i<clsrromMsg.length; i++) {
            		clsrrom=clsrrom+'<option value="'+clsrromMsg[i].classRoomId+'">'+clsrromMsg[i].classRoomLocation+'</option>"';
                }
            	
            	$("#classroomloc").html(clsrrom);
            }else{
            	alert("servlet出了点问题");
            }
        },
        error: function() {
            alert("获取可用教室失败");
        }
    });
}

function checkCapaticy(){
	var capacity=$("#capacity").val();
	if(capacity>30){
		$("#capacityHint").css("display","inline");
	}else{
		$("#capacityHint").css("display","none");
	}
}


