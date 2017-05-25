function validate(){
	var account=$("input[name='account']").val();
    var password=$("input[name='password']").val();
    var identity=$("input:radio[name='identity']:checked").val();
    if(account==""){
        alert("账号不能为空！");
        return false;
    }else if(password==""){
        alert("密码不能为空！");
        return false;
    }else{
        $.ajax({
            type:"POST",
            url:"LoginServlet",
            data:{
                "account":account,
                "password":password,
                "identity":identity
            },
            success:function(data,status) {
                if(data==0){
                	$('#loginHints').html("用户名或密码错误！");
                           	
                }else{
                	window.location.href="IdentifyServlet?account="+account+"&username="+data+"&identity="+identity;
                }
            },
            error: function() {
                alert("验证失败");
            }
        });
    }
}