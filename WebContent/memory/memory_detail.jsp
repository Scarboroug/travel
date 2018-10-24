<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html lang="zh"><!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <title>旅游记忆 | 驴友网</title>
        <meta name="keywords" content="旅游社交，在旅途中享受激情与欢乐" />
        <meta name="description" content="旅游社交，在旅途中享受激情与欢乐"/>
        <link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="mobile-agent" content="format=html5; url=http://m.roadqu.com">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global.css" media="all">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/boxy,jquery.fancybox-1.3.4.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/huidong.css">
        <script type="text/javascript">
			var userjson = '';
			var c_cityinfo = '';
		</script>
	</head>
    
<body>
<%@include file="/including/hearder.jsp" %>
<div id="container">
	<div class="ui-box fn-clear">
			<p><img src="${memory.tmimg }" style="height:200px; width:300px; float:left; padding-right:5px;" >
			&nbsp;&nbsp;&nbsp;&nbsp;标题：${memory.tmtitle }<br /><br />
			&nbsp;&nbsp;&nbsp;&nbsp;类别：<c:if test="${memory.memorytypeid==1001 }">面朝大海</c:if>
										<c:if test="${memory.memorytypeid==1002 }">古镇时光</c:if>
										<c:if test="${memory.memorytypeid==1003}">吃货血拼</c:if>
										<c:if test="${memory.memorytypeid==1004 }">户外撒野</c:if>
			&nbsp;&nbsp;&nbsp;&nbsp;发布者：${memory.username }&nbsp;&nbsp;&nbsp;&nbsp;发布时间：${memory.tmtime }<br /><br />
			&nbsp;&nbsp;&nbsp;&nbsp;内容：${memory.tmcontent }</p>
	</div>
	<!-- 发表评论 -->
	<form action="${pageContext.request.contextPath }/add_comment.do" method="post">
	<div class="ui-box fn-clear">
		<div id="comment" class="comment cnt-box fn-clear">
			<h2>发表评论</h2>
			<div class="comment_headPic fn-left">
				<a href="#"><img width="75" height="75"  src="../images/default.jpg">	</a>
			</div>
			<div class="comment_info fn-right">
			<input type="hidden"  value="${memory.tmid }" name="tmid"/>
			<div class="cont fn-clear">
				<textarea class="talkBox" id="comment_box" name="commentcontent" style="float:left"></textarea>
				<input type="submit" class="sendBtn" value="评论">
			</div>
			</div>
		</div>				
	</div>
	</form>
	
	
	<div class="mainWrap wide-wrap fn-clear">
		<div class="main">
			<!--comments-->
			<div id="comment" class="comment cnt-box fn-clear">
				<h2>所有评论</h2>
					<ul id="comment-list" class="comment-list">
						<c:forEach items="${comments }" var="comment">
							<li class="fn-clear">
							<div class="comment_headPic fn-left">
								<a href="#"><img width="75" height="75" alt="${comment.username }" src="../images/default.jpg"> </a>
							</div>
							<p>&nbsp;&nbsp; &nbsp;&nbsp;${comment.username }  &nbsp;&nbsp;&nbsp;&nbsp; <fmt:formatDate value="${comment.commentdate }"  pattern="MM月dd日"/>  </p>
							<div class="comment_info fn-right">
								<div class="comment_box">
									<div class="SA">
										<em>◆</em><span>◆</span>
                                    </div>
									<div class="comment_cnt">${comment.commentcontent } 
                                            
                                    </div>
                                </div>
                            </div>
                        </li>
						
						</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 底部footer 开始-->
  <%@include file="/including/footer.jsp" %>
	<!-- footer end -->
    </body>
</html>