<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>欢迎登录教务管理系统</title>
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
        <td><label for="account">账号:&nbsp;</label></td>
        <td>
          <input name="account" id="account" tabindex="1" title="请输入账号" type="text" value="" style="width:125px;">
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


  </form>
</div>

<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</body>
</html>