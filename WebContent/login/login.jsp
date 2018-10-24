<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta charset="utf-8">
<title>登录 | 驴友网</title>
<meta name="Keywords" content="驴友网" />
<meta name="Description" content="旅游社交，在旅途中享受激情与欢乐" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/global.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/reg.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/boxy,jquery.fancybox-1.3.4.css" />
<script type="text/javascript">
	var userjson = '';
	var c_cityinfo = '';
	//改变验证码
	function changeCode() {
		var img = document.getElementById("imgCode");
		var num = Math.random();
		img.src = "${pageContext.request.contextPath }/code.do?id=" + num;
	}
	
	//公共的非空验证
	function isNull(theId,msg){
		if(document.getElementById(theId).value==""){
			alert(msg);
			document.getElementById(theId).focus();
			return true;
		}
	}
	
	
	//检查是否为空
	function check(){
		if(isNull("username","请输入用户名！")){
			return false;
		}
		
		if(isNull("password","请输入密码！")){
			return false;
		}
		
		if(isNull("checkcode","请输入验证码！")){
			return false;
		}
		
		return true;
	}
</script>
</head>

<body id="reg">
	<!--top-->
	<%@include file="/including/hearder.jsp"%>
	<!--top end-->

	<div id="container" class="noXtips cf">
		<div class="main">

			<h2>欢迎登录驴友网</h2>
			<form id="form100"
				action="${pageContext.request.contextPath }/login.do" method="post"
				class="reg-form" onsubmit="return check();">
				<p>
					<label for="username"><em>*</em>用户名：</label> <input name="username"
						type="text" class="input-txt" id="username" value="${un}" autocomplete="off"
						size="43" />
				</p>
				<p>
					<label for="password"><em>*</em>密码：</label> <input name="password"
						type="password" class="input-txt"  value="${ password}" id="password" autocomplete="off"
						size="43" />
				</p>
				<p class="checkcode">
					<label for="checkcode"><em>*</em>验证码：</label> <input
						name="checkcode" type="text" class="input-txt" id="checkcode"
						autocomplete="off"><img id="imgCode" height="26"
						align="absmiddle" width="105" onclick="changeCode()"
						title="看不清？点击更换" src="${pageContext.request.contextPath }/code.do"
						id="checkcodeimg"><span onclick="changeCode();"
						class="refresh">换一换</span>
				</p>
				<input type="submit" value="登录" class="reg-login" />
			</form>


			<div class="reg-notes">
				<p>
					<font color="red" size="+1">${msg }</font>
				</p>
				<p>如果你还没有账户，请点击注册</p>
				<a href="${pageContext.request.contextPath }/login/register.jsp" class="reg-login">注册</a>
			</div>
		</div>
	</div>

	<%@include file="/including/footer.jsp"%>
	<!-- footer end -->
</body>
</html>