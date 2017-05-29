
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