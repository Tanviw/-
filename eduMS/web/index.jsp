<%--
  Created by IntelliJ IDEA.
  User: Tanvi
  Date: 2017/5/18
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>上海理工大学选课系统</title>
  <meta http-equiv="content-type" content="text/html;charset=utf-8">
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="content-style-type" content="text/css">
  <meta http-equiv="content-script-type" content="text/javascript">
  <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!--<link id="beangle_theme_link" rel="stylesheet" href="/xk/static/themes/default/beangle-ui.css" type="text/css">-->

  <link rel="stylesheet" href="css/login.css">

  <script>
  var curIndex=0;

  var timeInterval=2000;
  var arr=new Array();
  arr[0]="images/body1.jpg";
  arr[1]="images/body2.jpg";
  arr[2]="images/timg.jpg";

  setInterval(changeImg,timeInterval);
  function changeImg()
  {
  var obj=document.getElementById("s4");
  if (curIndex==arr.length-1)
  {
  curIndex=0;
  }
  else
  {
  curIndex+=1;
  }

  obj.src=arr[curIndex];
  }
  </script>


</head>
<body>


<div class="browser-hint">
  <h2>请使用IE8(或以上版本)、Firefox或Google Chrome浏览器访问本系统<br>否则可能影响功能使用</h2>
  <ul>
    <li>
      <a class="iexplorer" href="http://www.microsoft.com/windows/internet-explorer" target="_blank"></a>
    </li>
    <li>
      <a class="firefox" href="http://www.mozilla.com" target="_blank"></a>
    </li>
    <li>
      <a class="chrome" href="http://www.google.com/chrome" target="_blank"></a>
    </li>
  </ul>
</div>

<div class="logindiv">
  <div class="banner1"></div>
  <div class="banner2">选课系统</div>
  <form id="loginForm" name="loginForm" action="" method="post">

    <table class="bulletin">
      <tbody><tr>
        <td>
          <div style="position: relative; width: 430px; height: 230px;">
            <div style="position: absolute; top: 0px; left: 0px; display: block; z-index: 3; opacity: 1; width: 430px; height: 230px;"><img  id="s4" style="width:430px;height:230px;" src="images/timg.jpg"></div>
          </div>
        </td>
      </tr>
      </tbody></table>

    <table class="logintable">
      <tbody><tr>
        <td colspan="2" style="text-align:center;color:red;"></td>
      </tr>
      <tr>
        <td><label for="username">用户名:&nbsp;</label></td>
        <td>
          <input name="username" id="username" tabindex="1" title="请输入用户名" type="text" value="" style="width:125px;">
        </td>
      </tr>
      <tr>
        <td>
          <label for="password">密　码:&nbsp;</label>
        </td>
        <td>
          <input id="password" name="password" tabindex="2" type="password" style="width:125px;">
          <input name="encodedPassword" type="hidden" value="">
        </td>
      </tr>
      
      <tr>
        <td colspan="2" style="text-align:center">
        <p id="loginHints" style="color:red;height:10px"></p>
        </td>
        
      </tr>
      <tr>
        <td colspan="2">
          <input name="identity" id="stu" type="radio" tabindex="4" value="student" checked="checked"><label for="student">学生</label>
          <input name="identity" id="teacher" type="radio" tabindex="5" value="teacher"><label for="teacher">教师</label>
          <input name="identity" id="admin" type="radio" tabindex="6" value="admin"><label for="admin">管理员</label>
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="button" onclick="validate()" value="" name="submitBtn" tabindex="7" class="blue-button">
        </td>
      </tr>
      </tbody></table>

    <!--<table class="footage">-->
    <!--<tbody><tr>-->
    <!--<td style="text-align:right">-->
    <!--</td>-->
    <!--</tr>-->
    <!--</tbody></table>-->

  </form>
</div>

<!--<div class="foot"></div>-->

<!--<script type="text/javascript">-->
<!--var form  = document.loginForm;-->

<!--function casLogin(){-->
<!--var loginStr = window.location.href;-->
<!--loginStr = loginStr.substring(0,loginStr.lastIndexOf("/"));-->
<!--loginStr += "/home.action";-->
<!--loginStr = "https://uis1.fudan.edu.cn/amserver/UI/Login?gx_charset=UTF-8&goto=" + loginStr;-->
<!--window.location = loginStr;-->
<!--}-->

<!--function checkLogin(form){-->
<!--if(!form['username'].value){-->
<!--alert("用户名称不能为空");return false;-->
<!--}-->
<!--if(!form['password'].value){-->
<!--alert("密码不能为空");return false;-->
<!--}-->
<!--form['password'].value = CryptoJS.SHA1('d754ca91-9153-4fa1-9626-7bc1ea4bdaa9-' + form['password'].value);-->
<!--return true;-->
<!--}-->
<!--if("zh".indexOf("en")!=-1){document.getElementById('teacher').checked=true;}-->
<!--var username=beangle.cookie.get("username");-->
<!--if(null!=username){ form['username'].value=username;}-->
<!--(function(){-->
<!--// 侦测登陆页面是否被嵌套了-->
<!--if(jQuery("body > div:not(.logindiv,.foot,.browser-hint)").length) {-->
<!--window.location = "/xk/login.action?v=1";-->
<!--}-->
<!--})();-->
<!--</script>-->



<!--<audio controls="controls" style="display: none;"></audio>-->
<script type="text/javascript" src="js/login.js"></script>
</body>
</html>
