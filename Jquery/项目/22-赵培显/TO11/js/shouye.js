$(function(){
	//下拉菜单
    $("#menu").mouseenter(function(){
        $("#dd_menu_top_down").slideDown(500);//以0.5秒的速度着步显示
    }).mouseleave(function(){
        $("#dd_menu_top_down").slideUp(500);//以0.5秒的速度着步隐藏
    });
    //打开广告窗口
window.open('open.html','','width=400,height=300');//创建一个窗口，调用opan窗口再次页面显示
    //轮播图片
     function lunbo(){
        var index=0;
        var stop=false;
        var li=$("#content").find("#scroll_img").children("li");//拿到croll_img下所有li,然后敷给page
        var page = $("#content").find("#scroll_number").children("li");
       page.eq(index).addClass("scroll_number_over").stop(true,true).siblings().removeClass("scroll_number_over");//现在当前添加一类，然后删除同类元素
        page.mouseover(function(){
            stop=true;
            index=page.index($(this));//调用当前
            li.eq(index).stop(true,true).fadeIn().siblings().fadeOut();//现在当前页面淡入，然后淡出同类元素
            $(this).addClass("scroll_number_over").stop(true,true).siblings().removeClass("scroll_number_over");
        }).mouseout(function(){
            stop=false;
        });
        setInterval(function(){
            if(stop) return;
            index++;
            if(index>=li.length){
                index=0;
            }
            li.eq(index).stop(true,true).fadeIn().siblings().fadeOut();
            page.eq(index).addClass("scroll_number_over").stop(true,true).siblings().removeClass("scroll_number_over");
        },3000);
    }
    lunbo();
    
    $(".book ul img").mouseenter(function(){
        $(this).animate({width:"110%"},"slow");//鼠标指针进入以动画形式慢慢显示
    });
    $(".book ul img").mouseleave(function(){
        $(this).animate({width:"80%"},"slow");//鼠标指针离开以动画形式慢慢显示
    });
    //滚动窗口
     $(window).scroll(function(){
        var qq = $(this).scrollTop()+50;
        $("#right").css("top",qq);
    });
    $("#right").find("a").click(function(){
        $("#right").hide();//点击right下面的所有a下面子元素隐藏right
    });
//图书畅销榜切换
$(".tab ol li:first-of-type").bind("mouseover",function(){//绑定
	$(".tab ol li:last-of-type").css("background","yellowgreen");//添加背景颜色
    $(this).css("background","#ffffff");
	$(".tab ul:first-of-type").show();//显示
	$(".tab ul:last-of-type").hide();//隐藏
})
$(".tab ol li:last-of-type").bind("mouseover",function(){
	$(".tab ol li:first-of-type").css("background","yellowgreen");
    $(this).css("background","#ffffff");
	$(".tab ul:first-of-type").hide();
	$(".tab ul:last-of-type").show();
})
 $(".tab ul li p").bind("mouseenter",function(){
        $(this).next().show();//当前节点的下一个显示
        $(this).hide();
        $(this).parent().siblings().children("p").show().end().children("dl").hide();
        //返回当前元素的父元素，然后在显示同类元素下的所有p标签，然后结束当前筛选操作并还原之前状态，在隐藏同类元素下的所有dl标签
    })
//书讯快递循环垂直向上滚动
 function movedome(){
        var marginTop=0;
        var stop=false;
        var interval=setInterval(function(){//调用函数
            if(stop) return;
            $("#express").children("li").first().animate({"margin-top":marginTop--},0,function(){
            	//拿到express下面的第一个li标签然后动画事件
                var $first=$(this);//拿到当前
                if(!$first.is(":animated")){
                    if((-marginTop)>$first.height()){//如果-marginTop>$(this)的高度
                        $first.css({"margin-top":0}).appendTo($("#express"));//那么就把$(this)追加到express
                        marginTop=0;
                    }
                }
            });
        },50);//以0.05运行
        $("#express").mouseover(function(){
            stop=true;
        }).mouseout(function(){
            stop=false;
        });
    }
    movedome();//调用此函数
});