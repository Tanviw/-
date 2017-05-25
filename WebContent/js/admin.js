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
		previous.find("input:eq(1)").parent().replaceWith('<td><input type="password" name="password" style="border:none"></td>');
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
	
	
	
//	var edithtml='<div id="editStudent"><a href="javascript:;">编辑学生</a><form><table class="table table-bordered">'
//   +'<tbody><tr><th>姓名</th><th>性别</th><th>年级</th><th>学院</th><th>专业</th><th colspan="2">操作</th></tr><tr>'
//   +'<td><input type="text" name="stuName" placeholder="学生姓名" style="border:none"></td>'
//   +'<td style="width:5%"><select name="sex"><option value="男">男</option><option value="女">女</option>'
//   +'</select></td><td style="width:5%"><select name="grade"><option value="大一">大一</option>'
//   +'<option value="大二">大二</option><option value="大三">大三</option><option value="大四">大四</option></select></td>'
//       	+'<td style="width:20%"><select name="academy" id="academy" onchange="getMajor(this.options[this.options.selectedIndex].value)">'
//       	+'<c:forEach var="academy" items="${sessionScope.academyList}">'
//       	+'<option value="${academy}">${academy}</option></c:forEach>'
//       	+'</select></td><td  style="width:20%"><select name="major" id="major">'
//       	+'</select></td><td><a href="javascipt:void(0);" id="confirm">确认</a></td>'
//       	+'<td><a href="javascipt:void(0);" id="cancel">取消</a></td></tr></tbody></table></form></div>';
	
	
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

