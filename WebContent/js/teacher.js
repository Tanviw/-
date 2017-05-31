

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



function showTeacQues(e){
	var teacherCourseId=$(e).attr("data");
	$(e).parent().find('.curr').removeClass('curr');
	$(e).addClass('curr');
	$.ajax({
        type:"GET",
        url:"ShowTQuesNotAnsServlet",
        data:{
        	"teacherCourseId":teacherCourseId
        },
        success:function(data,status) {
            if(data!="error"){
            	var quesMsg=$.parseJSON(data);
            	var quesUnAnsDom="";
            	
            	 for(var i = 0;i<quesMsg.length; i++) {
            		 var time=quesMsg[i].questionTime.substring(0,quesMsg[i].questionTime.length-2);
            		 quesUnAnsDom+="<li data='"+quesMsg[i].questionId+"'><div class='quesstu'>"+quesMsg[i].stuAccount+"&nbsp;&nbsp;&nbsp;"
            		 				+quesMsg[i].stuName+"</div><div style='font-size:14px;color:#9B9B9B'>"
            		 				+time+"</div>"+quesMsg[i].questionContent+"<button class='btn btn-info' style='float:right' onclick='answerQues(this)' >回复</button><div class='ansContent'></div></li>";
            	 }
            	 $("#teacquesList").html(quesUnAnsDom);
            }else{
            	alert("后台出毛病啦！");
            }
        },
        error: function() {
            alert("获取新的提问失败");
        }
    });
	
	$.ajax({
        type:"GET",
        url:"ShowTQuesAnswerServlet",
        data:{
        	"teacherCourseId":teacherCourseId
            
        },
        success:function(data,status) {
            if(data!="error"){
            	var ansMsg=$.parseJSON(data);
            	var AnswerDom="";
            	
            	 for(var i = 0;i<ansMsg.length; i++) {
            		 var stuAcc=ansMsg[i].stuAccount;
            		 var stuName=ansMsg[i].stuName;
            		 var questime=ansMsg[i].questionTime.substring(0,ansMsg[i].questionTime.length-2);
            		 var answtime=ansMsg[i].answerTime.substring(0,ansMsg[i].answerTime.length-2);
            		 AnswerDom+="<li><div class='quesstu'>"+stuAcc+"&nbsp;&nbsp;&nbsp;"
            		 				+stuName+"</div><div style='font-size:14px;color:#9B9B9B'>"
                 		+questime+"</div>"+ansMsg[i].questionContent
                 		+"<div style='font-size:14px;color:rgb(165, 155, 170)'>"
                 		+answtime+"</div><div style='color:rgb(108, 115, 158)'>"+ansMsg[i].questionAnswer+"</div></li>";
            	 }
            	 $("#teacansList").html(AnswerDom);
            	
            }else{
            	alert("后台出毛病啦！");
            }
        },
        error: function() {
            alert("获取回答记录失败");
        }
    });
	
	
}



function answerQues(e){
	
	var textdom="<div><textarea style='width:60%;height:50px;'></textarea>" +
			"<br/><a href='javascript:;' onclick='submitAnswer(this)'>确定</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
			"<a href='javascript:;' onclick='cancelAnswer(this)'>取消</a></div>";
	
	$(e).parent().find(".ansContent").html(textdom);
	
}

function submitAnswer(e){
	var curli=$(e).parent().parent().parent();
	var questionId=curli.attr("data");

	var answerContent=$(e).parent().find('textarea:eq(0)').val();

	  $.ajax({
		  
	        type:"POST",
	        url:"PostAnswerServlet",
	        data:{
	        	"answerContent":answerContent,
	        	"questionId":questionId
	        },
	        success:function(res,status) {
	            if(res=="ok"){
	            	alert("回复成功！");
	            	curli.remove();
	            	var count=Number($('#teacdy').text());
	            	if(count>1){
	            		count=count-1;
	            		$('#teacdy').text(count);
	            	}else{
	            		$('#teacdy').remove();
	            	}
	            }else{
	            	alert("后台出问题啦！");
	            }
	        },
	        error: function() {
	            alert("回复失败");
	        }
	    });
}

function cancelAnswer(e){
	$(e).parent().remove();
}