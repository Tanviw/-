
function selectCourse(){
	var stuAccount=$("#xhxm").text();
	var teacCorsIdArr =[]; 
	$('#seleCorslist input[name="avacors"]:checked').each(function(){ 
		teacCorsIdArr.push($(this).val()); 
	});
	
	$.ajax({
		traditional: true,//向后台传数组格式
        type:"POST",
        url:"StuSelectCorsServlet",
        data:{
            "stuAccount":stuAccount,
            "teacCorsIdArr":teacCorsIdArr
        },
        success:function(data,status) {
            if(data=="上课时间不能冲突！"){
            	alert("上课时间不能冲突！");
            	$('#seleCorslist input[name="avacors"]:checked').prop('checked',false);
            }else if(data=="ok"){
            	alert("恭喜你成功选上课啦~");
            	var selectedDom='';
            	$('#seleCorslist input[name="avacors"]:checked').each(function(){
            		var current=$(this).parent().parent();
            	
            		selectedDom+='<tr><td>'+current.find("td:eq(1)").text()
            		+'</td><td>'+current.find("td:eq(2)").text()
            		+'</td><td>'+current.find("td:eq(3)").text()
            		+'</td><td>'+current.find("td:eq(4)").text()
            		+'</td><td>'+current.find("td:eq(5)").text()
            		+'</td><td>'+current.find("td:eq(6)").text()
            		+'</td><td><a href="javascipt:void(0);" onclick="quitSelect(this)" data="'+$(this).val()+'" >退选</a>'
            		+'</td></tr>';
            	});
            	$("#selectedCorslist").append(selectedDom);
            	$('#seleCorslist input[name="avacors"]:checked').prop('checked',false);
            	
            }else{
            	alert("后台出了点问题");
            }
        },
        error: function() {
            alert("选课失败");
        }
    });
	
	
}

function quitSelect(e){
	var stuAccount=$("#xhxm").text();
	var teacherCourseId=$(e).attr("data");

	$.ajax({
        type:"POST",
        url:"QuitSelectCorsServlet",
        data:{
        	"stuAccount":stuAccount,
            "teacherCourseId":teacherCourseId
        },
        success:function(data,status) {
            if(data!="error"){
            	alert("退选成功！");
            	$(e).parent().parent().remove();
               
            }else{
            	alert("后台出毛病啦！");
            }
        },
        error: function() {
            alert("退选失败");
        }
    });
}

function searchTeacherCourse(){
	var message=$("#searchTeacherCourse").val();
	$.ajax({
        type:"POST",
        url:"SearchTeacCorsServlet",
        data:{
            "message":message
        },
        success:function(data,status) {
            if(data!="error"){
            	var course = $.parseJSON(data);
            	var cors="<tr><th>选课</th><th>课程代码</th><th>课程名称</th><th>教师姓名</th>"
            +"<th>上课时间</th><th>上课地点</th><th>学分</th><th>容量</th><th>余量</th></tr>";
                for( var i = 0;i<course.length; i++) {
                	cors=cors+'<tr><td><input type="checkbox" name="avacors" value="'+course[i].teacherCourseId+'"></td>'
           +'<td>'+course[i].courseNumber+'</td>'
            +'<td>'+course[i].courseName+'</td>'
            +'<td>'+course[i].teacherName+'</td>'
            +'<td>'+course[i].courseTime+'</td>'
            +'<td>'+course[i].classRoomLocation+'</td>'
            +'<td>'+course[i].credit+'</td>'
            +'<td>'+course[i].capacity+'</td>'
            +'<td>'+course[i].surplus+'</td></tr>';
                }
                $("#seleCorslist").html(cors);
               
            }else{
            	alert("后台出毛病啦！");
            }
        },
        error: function() {
            alert("获取课程信息失败");
        }
    });
}

function getTeacherName(){
	var teacName=$("#commentcors option:selected").attr("data");
	$("#commentTeac").find("th:eq(2)").text(teacName);
}
function commitComment(){
	var seleArr=0;
	$("#commentTeac option:selected").each(function(){
		seleArr=seleArr+Number($(this).val());
		
	});
	var teacherGrade=seleArr/4.0;
	
	var commentContent=$("#comment").val();

	var teacherCourseId=$("#commentcors option:selected").val();

	$.ajax({
        type:"POST",
        url:"StuCommentTeacServlet",
        data:{
        	"teacherCourseId":teacherCourseId,
            "commentContent":commentContent,
            "teacherGrade":teacherGrade
        },
        success:function(data,status) {
            if(data!="error"){
            	alert("评价成功！");
            	$("#commentcors option:selected").remove();
            	getTeacherName();
            	$("#comment").val("");
            }else{
            	alert("后台出毛病啦！");
            }
        },
        error: function() {
            alert("评价失败");
        }
    });
}

function checkGrade(){
	var stuAccount=$("#xhxm").text();
	$.ajax({
        type:"GET",
        url:"CheckGradeServlet",
        data:{
        	"stuAccount":stuAccount
        },
        success:function(data,status) {
        	
            if(data=="暂未有成绩！"){
            	$("#gradeList").html("暂无您的成绩！");
            }else if(data=="error"){
            	alert("后台出毛病啦！");
            	
            }else{
            	var gradeMsg=$.parseJSON(data);
            	var gradeTable="<h4 style='text-align:center;color:#288690;'>成绩列表</h4><hr/><table class='data table table-bordered table-striped table-hover' cellspacing='0' cellpadding='0'><tbody><tr><th>课程代码</th><th>课程名称</th>"
            		+"<th>成绩</th><th>学分</th><th>绩点</th></tr>";
            	var i;
            	 for(i = 0;i<gradeMsg.length-1; i++) {
            		 gradeTable+="<tr><td>"+gradeMsg[i].courseNumber+"</td><td>"
            		 +gradeMsg[i].courseName+"</td><td>"
            		 +gradeMsg[i].stuGrade+"</td><td>"
            		 +gradeMsg[i].credit+"</td><td>"
            		 +gradeMsg[i].courseGPA+"</td></tr>";
            	 }
            	 gradeTable+="</tbody></table>";
            	var gpa=gradeMsg[i].gpa;
            	$("#gpa").html("平均学分绩点："+gpa);
            	$("#gradeList").html(gradeTable);
            	
            	
            }
        },
        error: function() {
            alert("获取成绩失败");
        }
    });
}