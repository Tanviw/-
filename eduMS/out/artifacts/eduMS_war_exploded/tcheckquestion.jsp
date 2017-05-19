<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>教师查看学生提问</title>
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

            <li><a href="teacher.jsp">教师课表</a></li>
            <li><a href="tinputscore.jsp">录入成绩</a></li>
            <li><a href="teachergrade.jsp">查看评分</a></li>
            <li class="active"><a href="#">查看学生提问</a></li>

        </ul>
    </div>

        <table class="table table-bordered table-striped">


            <tbody><tr>
                <td>课程名称</td>

                <td>学生提问</td>
            </tr>
            <tr>

                <td>能源概论</td>

                <td><a href="#">查看学生提问</a></td>
            </tr>
            <tr>

                <td>能源概论</td>

                <td><a href="#">查看学生提问</a></td>
            </tr>
            </tbody>
        </table>
    </div>

</body>
</html>
