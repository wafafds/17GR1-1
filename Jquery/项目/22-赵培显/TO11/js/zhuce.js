$(document).ready(function(){
	$("#myform").submit(function(){
		var qq=true;
		if(!email()) qq =false;
		if(!name()) qq =false;
		if(!mima()) qq =false;
		if(!cfmima()) qq =false;
		if(!diqu()) qq =false;
		return qq;
	})
	//邮箱验证
	
	$("#email").blur(function email(){
		var ee=$("#email").val();
		var XX=$("#DEmail");
		if(ee == ""){
			XX.html("email不能为空");
			return false;
		}
		if(ee.indexOf("@")== -1){
			XX.html("email必须包含@");
			return false;
		}
		if(ee.indexOf(".")== -1){
			XX.html("email必须包含.");
			return false;
		}
		return true;
	})
	//用户名验证
	
	$("#nickName").blur(function name(){
		var nn=$("#nickName").val();
		var RR=$("#NAckname")
		if(nn == ""){
			RR.html("昵称不能为空");
			return false;
		}
		for(var i =0;i<nn.length;i++){
		var j = nn.substring(i, i + 1);
   		 if (isNaN(j) == false) {
        RR.html("昵称中不能包含数字");
        return false;
		}
   		}
   		 return true;
   })
	//密码验证
	$("#pwd").blur(function mima(){
		var pp=$("#pwd").val();
		var ss=$("#PASS")
		if(pp == ""){
			ss.html("密码不能为空");
			return false;
		}
		if(pp.length< 6){
			ss.html("密码必须大于等于6");
			return false;
		}
   		 return true;
   })
	//再次输入密码验证
	$("#repwd").blur(function cfmima(){
		var cc=$("#repwd").val();
		var pp=$("#pwd").val();
		var vv=$("#qqq");
		if(cc== ""){
			vv.html("密码不能为空");
			return false;
		}
		if(pp!=cc ){
			vv.html("两次密码不一致");
			return false;
		}
   		 return true;
   })
	 //提交按钮样式变化
    $("#registerBtn").mouseover(function(){
        $(this).attr("src","images/register_btn_over.gif");
    }).mouseout(function(){
        $(this).attr("src","images/register_btn_out.gif");
    });
    //地址验证
    var cityList = new Array();
    cityList['北京市'] = ['朝阳区','东城区','西城区', '海淀区','宣武区','丰台区','怀柔','延庆','房山'];
    cityList['上海市'] = ['宝山区','长宁区','丰贤区', '虹口区','黄浦区','青浦区','南汇区','徐汇区','卢湾区'];
    cityList['广州省'] = ['广州市','惠州市','汕头市','珠海市','佛山市','中山市','东莞市'];
    cityList['深圳市'] = ['福田区', '罗湖区', '盐田区', '宝安区', '龙岗区', '南山区', '深圳周边'];
    cityList['重庆市'] = ['俞中区', '南岸区', '江北区', '沙坪坝区', '九龙坡区', '渝北区', '大渡口区', '北碚区'];
    cityList['天津市'] = ['和平区', '河西区', '南开区', '河北区', '河东区', '红桥区', '塘古区', '开发区'];
    cityList['江苏省'] = ['南京市','苏州市','无锡市'];
    cityList['浙江省'] = ['杭州市','宁波市','温州市'];
    cityList['四川省'] = ['四川省','成都市'];
    cityList['海南省'] = ['海口市'];
    cityList['福建省'] = ['福州市','厦门市','泉州市','漳州市'];
    cityList['山东省'] = ['济南市','青岛市','烟台市'];
    cityList['江西省'] = ['江西省','南昌市'];
    cityList['广西省'] = ['柳州市','南宁市'];
    cityList['安徽省'] = ['安徽省','合肥市'];
    cityList['河北省'] = ['邯郸市','石家庄市'];
    cityList['河南省'] = ['郑州市','洛阳市'];
    cityList['湖北省'] = ['武汉市','宜昌市'];
    cityList['湖南省'] = ['湖南省','长沙市'];
    cityList['陕西省'] = ['陕西省','西安市'];
    cityList['山西省'] = ['山西省','太原市'];
    cityList['黑龙江省'] = ['黑龙江省','哈尔滨市'];
    cityList['其他'] = ['其他'];
    $("#province").append(function(){
    	//把option追加到province
        var html="";
        for (var i in cityList){
            html+="<option value="+i+">"+i+"</option>";
        }
        return $(html);
    });
    $("#province").change(function(){
    	//当触发change事件option在页面显示
        var v= $(this).val();
        var html="";
        if(v=="请选择省/城市"){
            html="<option>请选择城市/地区</option>";
            $("#city").html(html);
            return;
        }
        var citys=cityList[v];
        $.each(citys,function(i,n){
            html+="<option value="+n+">"+n+"</option>";
        });
        $("#city").html(html);
    });
})