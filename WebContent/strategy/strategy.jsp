<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="zh">
    <head >
	<meta charset="utf-8" />
    <title>景点攻略 | 驴友网</title>
    <meta name="Keywords" content="" />
    <meta name="Description" content="" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="mobile-agent" content="format=html5; url=http://m.roadqu.com">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global.css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/boxy,jquery.fancybox-1.3.4.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/cityguide.css"  />
</head>
   
<body id="profile-homepage">
<%@include file="/including/hearder.jsp" %>

<div id="container">
	<div id="mainWrapper" class="cf"> 
		<!-- 主题游 begin -->  
		<div class="ui-box fn-clear">
			<div class="ui-title">
				<h2 class="ui-title-cnt fn-left"><em>主题游</em></h2>    
			</div>
			
			<ul class="hot-spots fn-clear">
				<c:forEach items="${theme }" var="strategy" >
					<li class="middle">
						<a href="${pageContext.request.contextPath }/strategy_detail.do?tsid=${strategy.tsid}"><img src="${strategy.tsimg}" width="190" height="190" alt="${strategy.tsname }" title="${strategy.tsname }"></a>
						<ul class="tag-info fn-clear">
							<li><a href="${pageContext.request.contextPath }/strategy_detail.do?tsid=${strategy.tsid}" target="_blank">${strategy.tsname }</a></li>
							<li><a href="${pageContext.request.contextPath }/strategy_detail.do?tsid=${strategy.tsid}" target="_blank">${strategy.tsapptime }</a></li>
							<li><a href="${pageContext.request.contextPath }/strategy_detail.do?tsid=${strategy.tsid}" target="_blank">${strategy.tspppeople}</a></li>
						</ul>
					</li>
			</c:forEach>
			</ul>
		</div>
		<!-- 主题游 end -->  
		
		<div class="ui-box fn-clear">
			<div class="ui-title">
				<h2 class="ui-title-cnt fn-left"><em>时令游</em></h2>    
			</div>
			
			<ul class="hot-spots fn-clear">
				<c:forEach items="${season }" var="strategy" >
					<li class="middle">
						<a href="${pageContext.request.contextPath }/strategy_detail.do?tsid=${strategy.tsid}"><img src="${strategy.tsimg}" width="190" height="190" alt="${strategy.tsname }" title="${strategy.tsname }"></a>
						<ul class="tag-info fn-clear">
							<li><a href="${pageContext.request.contextPath }/strategy_detail.do?tsid=${strategy.tsid}" target="_blank">${strategy.tsname }</a></li>
							<li><a href="${pageContext.request.contextPath }/strategy_detail.do?tsid=${strategy.tsid}" target="_blank">${strategy.tsapptime }</a></li>
							<li><a href="${pageContext.request.contextPath }/strategy_detail.do?tsid=${strategy.tsid}" target="_blank">${strategy.tspppeople}</a></li>
						</ul>
					</li>
			</c:forEach>
			</ul>
		</div>
	</div>
</div>

<%@include file="/including/footer.jsp" %>
<!-- footer end -->
</body>
</html>