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

            <li><a href="selecourse.jsp">学生选课</a></li>
            <li><a href="course.jsp">课表查询</a></li>
            <li class="active"><a href="#">成绩及绩点查询</a></li>
            <li><a href="stuquestion.jsp">教师答疑</a></li>
            <li><a href="stucomment.jsp">教师评价</a></li>
        </ul>
    </div>
<div class="col-md-12 column">
					<span class="formbox">
						<table width="100%" class="formlist">
							<tbody><tr>
								<td id="Td1">学号：1419660103   姓名：檀文文</td>

							</tr>
							<tr>
								<td id="Td2">平均学分绩点：   3.47</td>

							</tr>
							<tr>
								<td valign="top">
								</td>
							</tr>
						</tbody></table>
						<fieldset>
							<legend>成绩列表</legend>
							<table class="datelist table-striped table-hover" cellspacing="0" cellpadding="3" border="1px" id="DBGrid" width="100%">
	<tbody><tr class="datelisthead">
		<td>课程代码</td><td>课程名称</td><td>成绩</td><td>学分</td><td>绩点</td>
	</tr>
		<td>32000010</td><td>思想道德修养与法律基础</td><td>87</td><td>2.5</td><td>3.5</td>
    </tr><tr class="alt">
		<td>32000020</td><td>中国近现代史纲要</td><td>85</td><td>2.0</td><td>3.5</td>
	</tr><tr>
		<td>32000030</td><td>马克思主义基本原理概论</td><td>90</td><td>2.5</td><td>4</td>
	</tr><tr class="alt">
		<td>32000120</td><td>毛泽东思想和中国特色社会主义理论体系概论</td><td>73</td><td>3.0</td><td>2</td>
	</tr><tr class="alt">
		<td>32000080</td><td>法律基础与实务</td><td>87</td><td>1.0</td><td>3.5</td>
	</tr>
</tbody></table>
						</fieldset>
					</span></div>
</div>
</body>
</html>