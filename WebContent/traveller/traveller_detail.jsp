<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>结伴游 | 驴友网</title>
    <meta charset="utf-8">
    <meta name="Keywords" content="" />
    <meta name="Description" content="" />
    <link rel="shortcut icon"  href="favicon.ico" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="mobile-agent" content="format=html5; url=http://m.roadqu.com">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/boxy,jquery.fancybox-1.3.4.css">
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/youhui.css" media="all">
    <script type="text/javascript">
		var userjson = '';
		var c_cityinfo = '';
	</script>
</head>

<body>
<!--top-->
<%@include file="/including/footer.jsp" %>
<!--top end-->

<!--main body-->
<div id="container">

    <div class="ui-box fn-clear ">
        <div class="city-guide">
            <div class="fn-left">
				<a href="#">${keep.tktitle }</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发帖时间：<fmt:formatDate value="${keep.tktime }"  pattern="yyyy年MM月dd日"/>
            </div>
		 </div>
		 
        <!-- 发帖人 -->
        <div class="tag-list menu_select cf">
        	<span class="tag-notes fn-left">发帖人：</span>
            <span class="tag-cnt fn-right" id="lyq"><a title="${keep.username }" href="#" data-lyq="0">${keep.username }</a></span>
        </div>
         <!--end 发帖人 -->
		 
		 <!-- 目的地 -->
        <div class="tag-list menu_select cf">
        	<span class="tag-notes fn-left">目的地：</span>
            <span class="tag-cnt fn-right" id="lyq"><a title="${keep.tkdestination }" href="#" class="tag-current" data-lyq="0">${keep.tkdestination }</a></span>
        </div>
         <!--end 目的地 -->
		 
		  <!-- 行程安排 -->
        <div class="tag-list menu_select cf">
        	<span class="tag-notes fn-left">行程安排：</span>
            <span class="tag-cnt fn-right" id="lyq"><a href="#" data-lyq="0"><fmt:formatDate value="${keep.tkbegintime }" pattern="yyyy年MM月dd日"/> </a> <a href="#">至</a> <a href="#" data-lyq="0"><fmt:formatDate value="${keep.tkaftertime }" pattern="yyyy年MM月dd日"/> </a></span>
        </div>
         <!--end 行程安排 -->
		 
		 <!-- 联系方式 -->
        <div class="tag-list menu_select cf">
        	<span class="tag-notes fn-left">联系方式：</span>
            <span class="tag-cnt fn-right" id="lyq"><a href="#" class="tag-current" data-lyq="0">${keep.tkphone }</a></span>
        </div>
         <!--end 联系方式 -->
		 
		 <!-- 帖子详情 -->
        <div class="tag-list menu_select cf">
        	<span class="tag-notes fn-left">详情：</span>
            <span class="tag-cnt fn-right" id="lyq">${keep.tkdetails }</span>
        </div>
         <!--end 帖子详情 -->
    </div>
  

</div>
</div>

<!--main body end-->
<%@include file="/including/footer.jsp" %>
<!-- footer end -->
</body>
</html>