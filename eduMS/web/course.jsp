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
            <li class="active"><a href="#">课表查询</a></li>
            <li><a href="stugrade.jsp">成绩及绩点查询</a></li>
			<li><a href="stuquestion.jsp">教师答疑</a></li>
			<li><a href="stucomment.jsp">教师评价</a></li>
        </ul>
    </div>
<div class="col-md-12 column">
				<span class="formbox">
						<table class="formlist noprint" id="Table2" width="100%">
							<tbody><tr>
								<td align="center"><select name="xnd" onchange="__doPostBack('xnd','')" language="javascript" id="xnd">
	<option value="2017-2018">2017-2018</option>
	<option selected="selected" value="2016-2017">2016-2017</option>
	<option value="2015-2016">2015-2016</option>
	<option value="2014-2015">2014-2015</option>

</select><span id="Label2">学年第</span><select name="xqd" onchange="__doPostBack('xqd','')" language="javascript" id="xqd">
	<option value="1">1</option>
	<option selected="selected" value="2">2</option>
	<option value="3">3</option>

</select><span id="Label1">学期学生个人课程表</span></td>
							</tr>
							<tr class="trbg1">
								<td><span id="Label5">学号：1419660103</span>|
									<span id="Label6">姓名：檀文文</span>|
								</td>
							</tr>
						</tbody></table>
						<br>
						<table id="Table1" class="blacktab" border-collapse=collapse border="1px solid #000" width="100%" >
	<tbody><tr>
		<td colspan="2" rowspan="1" width="2%">时间</td><td align="Center" width="14%">星期一</td><td align="Center" width="14%">星期二</td><td align="Center" width="14%">星期三</td><td align="Center" width="14%">星期四</td><td align="Center" width="14%">星期五</td><td class="noprint" align="Center" width="14%">星期六</td><td class="noprint" align="Center" width="14%">星期日</td>
	</tr><tr>
		<td colspan="2">早晨</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td>
	</tr><tr>
		<td rowspan="5" width="1%">上午</td><td width="1%">第1节</td><td align="Center" rowspan="2" width="7%">软件协同设计课程设计<br>周一第1,2节{第19-20周}<br>赵逢禹<br>三教219<br></td><td align="Center" width="7%">&nbsp;</td><td align="Center" rowspan="2" width="7%">电路原理实验<br>周三第1,2节{第1-16周}<br>江霓<br>公共实验楼303室<br></td><td align="Center" width="7%">&nbsp;</td><td align="Center" rowspan="2" width="7%">软件过程管理<br>周五第1,2节{第1-16周}<br>欧广宇<br>三教203<br></td><td class="noprint" align="Center" width="7%">&nbsp;</td><td class="noprint" align="Center" width="7%">&nbsp;</td>
	</tr><tr>
		<td>第2节</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td>
	</tr><tr>
		<td>第3节</td><td align="Center" rowspan="2">软件协同设计课程设计<br>周一第3,4节{第19-20周}<br>赵逢禹<br>三教219<br></td><td align="Center">&nbsp;</td><td align="Center" rowspan="3">JavaWeb应用开发技术<br>周三第3,4,5节{第1-16周}<br>李锐<br>三教109<br></td><td align="Center" rowspan="3">移动软件开发技术<br>周四第3,4,5节{第1-16周}<br>马立新<br>三教305<br></td><td align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td>
	</tr><tr>
		<td>第4节</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td>
	</tr><tr>
		<td>第5节</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td>
	</tr><tr>
		<td rowspan="4">下午</td><td>第6节</td><td align="Center" rowspan="2">算法分析与设计<br>周一第6,7节{第1-16周}<br>高丽萍<br>三教107<br></td><td align="Center" rowspan="2">软件协同设计<br>周二第6,7节{第1-16周}<br>曹春萍<br>三教110<br></td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center" rowspan="2">软件协同设计课程设计<br>周五第6,7节{第19-20周}<br>赵逢禹<br>三教219<br></td><td class="noprint" align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td>
	</tr><tr>
		<td>第7节</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td>
	</tr><tr>
		<td>第8节</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center" rowspan="2">软件协同设计课程设计<br>周五第8,9节{第19-20周}<br>赵逢禹<br>三教219<br></td><td class="noprint" align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td>
	</tr><tr>
		<td>第9节</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td>
	</tr><tr>
		<td rowspan="3">晚上</td><td>第10节</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td>
	</tr><tr>
		<td>第11节</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td>
	</tr><tr>
		<td>第12节</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td><td class="noprint" align="Center">&nbsp;</td>
	</tr>
</tbody></table>





					</span>
</div>
</div>
</body>
</html>