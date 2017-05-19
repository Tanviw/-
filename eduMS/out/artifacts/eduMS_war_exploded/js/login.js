


    function validate() {
        var username=$("input[name='username']").val();
        var password=$("input[name='password']").val();
        var identity=$("input:radio[name='identity']:checked").val();
        if(username==""){
            alert("用户名不能为空！");
            return false;
        }else if(password==""){
            alert("密码不能为空！");
            return false;
        }else{
            $.ajax({
                type:"POST",
                url:"LoginServlet",
                data:{
                    "username":username,
                    "password":password,
                    "identity":identity
                },
                success:function(data,status) {
                    if(data==0){
                         window.location.href="identifyServlet?username="+username+"&identity="+identity;
                               	
                    }else if(data==1){
                    	$('#loginHints').html("用户名或密码错误！");
                    }
                },
                error: function() {
                    alert("验证失败");
                }
            });
        }
    }
