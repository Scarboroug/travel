<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="container" class="fn-clear">
	<div class="bottom">
    	<div class="bottom_t"></div>
        <div class="bottom_c h650">
       	  <div class="bottom_c_l">
           	  <div class="title01"> 我的记忆 </div>
              <div class="list01 bk">
                <ul>
                    <li>
						<a href="${pageContext.request.contextPath }/user/memory_add.jsp"><div class="icon_bot"><img src="/images/help12.png"></div>发布新记忆</a>
					</li>
                    <li>
						<a href="${pageContext.request.contextPath }/memory_list.do"><div class="icon_bot"><img src="/images/help14.png"></div>全部记忆</a>
					</li>
                </ul>
			</div>	
           	  <div class="title01"> 相约驴友 </div>
              <div class="list01 bk">
                <ul>
                    <li>
						<a href="${pageContext.request.contextPath }/user/travel_add.jsp"><div class="icon_bot"><img src="/images/help12.png"></div>发起旅游</a>
					</li>
                    <li>
						<a href="${pageContext.request.contextPath }/travel_list.do"><div class="icon_bot"><img src="/images/help13.png"></div>我发起的旅游</a>
					</li>
                </ul>
			</div>
           	
           	  <div class="title01">账号管理</div>
              <div class="list01 bk">
                <ul>
                    <li class="un">
						<a href="${pageContext.request.contextPath }/user/account_detail.jsp"><div class="icon_bot"><img src="/images/help12.png"></div>基本信息</a>
					</li>
                    <li>                    
						<a href="${pageContext.request.contextPath }/user/password_change.jsp"> <div class="icon_bot"><img src="/images/help14.png"></div>修改密码</a>
					</li>
                </ul>
			</div>											
		</div>
</body>
</html>