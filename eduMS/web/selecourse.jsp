
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>主页</title>
     <link rel="stylesheet" href="css/bootstrap.min.css">
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
  	<script type="text/javascript" src="js/bootstrap.min.js"></script>
  	<style>
  	*{
  	margin:0;
  	padding:0}
  	ul li{
  	list-style:none;}
  	.head .logo h2,.head .logo h3{
  	float:left}
  	.head .logo h2{
  	padding-left:15px;}
  	.head{
  	height:100px;
  	width:100%;
  	        background: linear-gradient(to bottom, rgba(0, 52, 255, 0.65) , rgba(146, 78, 255, 0.1));
  	}
  	.headpanel{
  	width:100%;
  	height:40px;
  	background:rgba(217, 232, 247, 0.76);
  	}
  	</style>
</head>
<body>

		
		<div class="head">
					<!--学校图标及皮肤说明图标-->
					<div class="logo">
						 <h2><img src="images/logo_school.png"></h2>
                         <h3><img src="images/logo_jw.png" ></h3>
					</div>
					<!--学校图标及皮肤说明图标-->
					<!--登录信息及工具-->
					<form name="Form1" method="post" action="xs_main.aspx?xh=1419660103" id="Form1">
<input type="hidden" name="__EVENTTARGET" value="">
<input type="hidden" name="__EVENTARGUMENT" value="">
<input type="hidden" name="__VIEWSTATE" value="dDwtMTM4MzI5NTE3MDs7Po8bpsvkhy9L9b/gtxAIb2pd6CEC">



						<div class="info"  style="float:right" >
							<ul style="height:90px;line-height:90px">
								<li style="float:left;padding-right:20px">
									<span id="Label3">欢迎您：</span>
									<em>
										<span id="xhxm">1419660103  檀文文同学</span></em>
									
								</li>
								<li style="float:left">
									<a id="likTc" href="index.jsp">安全退出</a>
								</li>
							</ul>
						</div>
			

</form>
					<!--登录信息及工具-->
				</div>
				<div class="clearfix"></div>
				<div class="col-md-12 column">
				<div class="headpanel">
		<ul class="nav nav-pills">

  <li class="active"><a href="#">学生选课</a></li>
  <li><a href="course.jsp">课表查询</a></li>
  <li><a href="stugrade.jsp">成绩及绩点查询</a></li>
  <li><a href="stuquestion.jsp">教师答疑</a></li>
  <li><a href="stucomment.jsp">教师评价</a></li>
</ul>
</div>
			<table class="table table-bordered table-striped table-hover">
				

	<tbody><tr class="datelisthead">
		<td>选课</td>
		<td><a href="javascript:__doPostBack('kcmcGrid$_ctl1$_ctl0','')">课程名称</a></td>
		<td><a href="javascript:__doPostBack('kcmcGrid$_ctl1$_ctl1','')">课程代码</a></td>
		<td><a href="javascript:__doPostBack('kcmcGrid$_ctl1$_ctl2','')">教师姓名</a></td>
		<td><a href="javascript:__doPostBack('kcmcGrid$_ctl1$_ctl3','')">上课时间</a></td>
		<td><a href="javascript:__doPostBack('kcmcGrid$_ctl1$_ctl4','')">上课地点</a></td>
		<td>学分</td>
		<td>容量</td>
		<td>余量</td>
	</tr>
	<tr>
		<td>
		<input id="kcmcGrid__ctl2_xk" type="checkbox" name="kcmcGrid:_ctl2:xk"></td>
		<td><a href="#" onclick="window.open('kcxx.aspx?xh=1419660103&amp;kcdm=11810010&amp;xkkh=(2017-2018-1)-11810010-04074-1','kcxx','toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width=540,height=450,left=120,top=60')">能源概论</a></td>
		<td>11810010</td>
		<td><a href="#" onclick="window.open('jsxx.aspx?xh=1419660103&amp;jszgh=04074&amp;xkkh=(2017-2018-1)-11810010-04074-1','jsxx','toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width=540,height=450,left=120,top=60')">王芳/余晓明/文振中</a></td>
		<td title="周二第10,11,12节{第3-13周}">周二第10,11,12节</td>
		<td>三教116</td>
		<td>2.0</td>
		<td>100</td>
		<td>20</td>
	</tr>
	<tr>
		<td>
		<input id="kcmcGrid__ctl3_xk" type="checkbox" name="kcmcGrid:_ctl2:xk"></td>
		<td><a href="#" onclick="window.open('kcxx.aspx?xh=1419660103&amp;kcdm=11810010&amp;xkkh=(2017-2018-1)-11810010-04074-1','kcxx','toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width=540,height=450,left=120,top=60')">能源概论</a></td>
		<td>11810010</td>
		<td><a href="#" onclick="window.open('jsxx.aspx?xh=1419660103&amp;jszgh=04074&amp;xkkh=(2017-2018-1)-11810010-04074-1','jsxx','toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width=540,height=450,left=120,top=60')">王芳/余晓明/文振中</a></td>
		<td title="周二第10,11,12节{第3-13周}">周二第10,11,12节</td>
		<td>三教116</td>
		<td>2.0</td>
		<td>100</td>
		<td>20</td>
	</tr>
	<tr>
		<td>
		<input id="kcmcGrid__ctl4_xk" type="checkbox" name="kcmcGrid:_ctl2:xk"></td>
		<td><a href="#" onclick="window.open('kcxx.aspx?xh=1419660103&amp;kcdm=11810010&amp;xkkh=(2017-2018-1)-11810010-04074-1','kcxx','toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width=540,height=450,left=120,top=60')">能源概论</a></td>
		<td>11810010</td>
		<td><a href="#" onclick="window.open('jsxx.aspx?xh=1419660103&amp;jszgh=04074&amp;xkkh=(2017-2018-1)-11810010-04074-1','jsxx','toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width=540,height=450,left=120,top=60')">王芳/余晓明/文振中</a></td>
		<td title="周二第10,11,12节{第3-13周}">周二第10,11,12节</td>
		<td>三教116</td>
		<td>2.0</td>
		<td>100</td>
		<td>20</td>
	</tr>
	<tr>
		<td>
		<input id="kcmcGrid__ctl5_xk" type="checkbox" name="kcmcGrid:_ctl2:xk"></td>
		<td><a href="#" onclick="window.open('kcxx.aspx?xh=1419660103&amp;kcdm=11810010&amp;xkkh=(2017-2018-1)-11810010-04074-1','kcxx','toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width=540,height=450,left=120,top=60')">能源概论</a></td>
		<td>11810010</td>
		<td><a href="#" onclick="window.open('jsxx.aspx?xh=1419660103&amp;jszgh=04074&amp;xkkh=(2017-2018-1)-11810010-04074-1','jsxx','toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=1,resizable=0,width=540,height=450,left=120,top=60')">王芳/余晓明/文振中</a></td>
		<td title="周二第10,11,12节{第3-13周}">周二第10,11,12节</td>
		<td>三教116</td>
		<td>2.0</td>
		<td>100</td>
		<td>20</td>
	</tr>
</tbody>
</table>

<div id="dpkcmcGrid_divDataPager" style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 3px; MARGIN: 0px auto; WIDTH: 98%; PADDING-TOP: 3px">
<div style="FLOAT: left">第<span id="dpkcmcGrid_lblCurrentPage">1</span>页/共<span id="dpkcmcGrid_lblTotalPages">52</span>页，跳转到<input name="dpkcmcGrid:txtChoosePage" type="text" value="1" onchange="__doPostBack('dpkcmcGrid$txtChoosePage','')" language="javascript" id="dpkcmcGrid_txtChoosePage" onkeydown="setjd(this);">页，总共<span id="dpkcmcGrid_lblTotalRecords">310</span>条记录，每页显示<input name="dpkcmcGrid:txtPageSize" type="text" value="6" onchange="__doPostBack('dpkcmcGrid$txtPageSize','')" language="javascript" id="dpkcmcGrid_txtPageSize">条</div>
<div style="FLOAT: right"><input type="submit" name="dpkcmcGrid:btnFirstPage" value="首 页" id="dpkcmcGrid_btnFirstPage" disabled="disabled" class="button">&nbsp;<input type="submit" name="dpkcmcGrid:btnPrePage" value="上一页" id="dpkcmcGrid_btnPrePage" disabled="disabled" class="button">&nbsp;<input type="submit" name="dpkcmcGrid:btnNextPage" value="下一页" id="dpkcmcGrid_btnNextPage" class="button">&nbsp;<input type="submit" name="dpkcmcGrid:btnLastPage" value="末 页" id="dpkcmcGrid_btnLastPage" class="button"></div>
	<input language="javascript" onclick="__doPostBack('dpkcmcGrid$btnpost','')" name="dpkcmcGrid:btnpost" id="dpkcmcGrid_btnpost" type="button" value="Button" style="DISPLAY:none"> 
</div>
<div style="text-align:left;padding:3px 0;clear:both"><input type="submit" name="Button1" value="  提交  " id="Button1" class="button">
	<font color="red">选课或退课后，请务必查看课表，操作是否成功以课表为准</font>
	</div>

				</div>
				
				
				


</body>
</html>
