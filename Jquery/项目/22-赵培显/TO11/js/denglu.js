$(document).ready(function(){
	//背景颜色的改变
		$(".login_content dd input").mouseover(function(){
		$(this).css("background-color","#F1FFDE");
		})
		$(".login_content dd input").mouseout(function(){
		$(this).css("background-color","whitesmoke");
		})

//邮箱和密码验证
$("#loginForm").submit(function(){
        var yy=$("#email").val();
        var qq=$("#pwd").val();
        if(yy==""){
            alert("请输入Email地址或昵称");
            return false;
        }
        if(qq==""){
            alert("请输入密码");
            return false;
        }
        return true;
    });
     $("#quick_register").mouseover(function(){
        $(this).removeClass().addClass("login_register_over");//移除当前元素，然后添加新的元素
    }).mouseout(function(){
        $(this).removeClass().addClass("login_register_out");
    }).click(function(){
        window.location.href="register.html";//获得当前页面的地址并把浏览器重定向到register页面
    });
})