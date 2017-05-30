

function checkComment(){
	var teacherCourseId=$("#teacherCorsSele option:selected").val();

	$.ajax({
        type:"POST",
        url:"CheckCorsCommServlet",
        data:{
        	"teacherCourseId":teacherCourseId
            
        },
        success:function(data,status) {
            if(data!=null){
            	
            	var comment = $.parseJSON(data);
            	var avgGrade=0;
            	var commentContent="<ul>";
            	for(var i=0;i<comment.length;i++){
            		avgGrade+=Number(comment[i].teacherGrade);
            		commentContent+="<li><div style='font-size:14px;color:#9B9B9B'>"+(i+1)+"楼</div>"+comment[i].commentContent+"</li>";
            	}
            	commentContent+="</ul>";
            	avgGrade=(avgGrade/comment.length).toFixed(2);
            	
            	$("#avgGrade").html(avgGrade);
            	$("#commentContent").html(commentContent);
            }else{
            	$("#commentContent").html("该课程暂无评价！");
            }
        },
        error: function() {
            alert("获取评价失败");
        }
    });
	
	
	
}


function inputGrade(){
	var seleCorsId=$("#seleCors option:selected").val();
	

	$.ajax({
        type:"POST",
        url:"GetStuServlet",
        data:{
        	"teacherCourseId":seleCorsId
            
        },
        success:function(data,status) {
            if(data!=null){
            	var stumsg = $.parseJSON(data);
            	var stutable='<table class="data table table-bordered table-striped table-hover"  cellspacing="0" cellpadding="0">'
        +'<tbody id="corsStuList">'
        +'<tr><th>学号</th><th>姓名</th>'
            +'<th>年级</th>'
            +'<th>专业</th><th>成绩</th></tr>';
            	
            	for(var i=0;i<stumsg.length;i++){
            		stutable+='<tr><td>'+stumsg[i].stuAccount+'</td><td>'
            		+stumsg[i].stuName+'</td><td>'
            		+stumsg[i].grade+'</td><td>'
            		+stumsg[i].major+'</td><td><input type="number"  name="'+stumsg[i].stuAccount+'" style="width:65px" min="0" max="100"></td></tr>';
            	}
            	stutable+='</tbody></table><input type="button"  class="btn btn-success" style="float:right" value="提交" onclick="submitScore()">';
            	
            	$("#stuListTable").html(stutable);
            }else{
            	$("#stuListTable").html("该课程暂无学生！");
            }
        },
        error: function() {
            alert("获取学生名单失败");
        }
    });
	
	
}



function submitScore(){

	var seleCorsId=$("#seleCors option:selected").val();
	var data = $("#stuListTable").serializeArray(); //自动将form表单封装成json  

	 

	  $.ajax({
		  traditional: true,
	        type:"POST",
	        url:"PostScoreServlet",
	        data:{
	        	"ds":JSON.stringify(data),
	        	"teacherCourseId":seleCorsId
	        },
	        success:function(res,status) {
	            if(res=="ok"){
	            	alert("提交成功！");
	            	$("#seleCors option:selected").remove();
	            	$("#stuListTable").html("");
	            	
	            }else{
	            	alert("提交失败！");
	            }
	        },
	        error: function() {
	            alert("提交学生成绩失败");
	        }
	    });
		
}