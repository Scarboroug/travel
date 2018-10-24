<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html  lang="zh">
<head>
	<meta charset="utf-8">
	<title>个人中心 | 驴友网</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="mobile-agent" content="format=html5; url=http://m.roadqu.com">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/global.css" media="all">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/boxy,jquery.fancybox-1.3.4.css">
	<link  href="${pageContext.request.contextPath }/css/aboutus.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/reg.css"  />
	<script type="text/javascript">
		var userjson = '';
		var c_cityinfo = '';
	</script>
</head>
<body>
<%@include file="/including/hearder.jsp" %>
<!--top end-->

<%@include file="/including/left.jsp" %>
		
		<div class="bottom_c_r">
			<h2 style="width:680px; height:40px; line-height:41px; background:#83bb4a url(../images/reg-title-bg.png) repeat-x; 
						color:#fefefe; text-indent:25px; font-size:20px; font-family:\9ED1\4F53; font-weight:400;">发起旅游</h2>
			
			<form id="form100" action="${pageContext.request.contextPath }/add_keep.do" method="post" class="reg-form"  enctype="multipart/form-data">
				<p><label for="tktitle"><em>*</em>标题：</label>
                   <input name="tktitle" type="text"  class="input-txt" id="tktitle" autocomplete="off" size="43" />
                </p>
                <p><label for="tkdestination"><em>*</em>目的地：</label>
                   <input name="tkdestination" type="text"  class="input-txt" id="tkdestination" autocomplete="off" size="43" />
                </p>
				<p><label for="tkbegintime"><em>*</em>起始日期：</label>
                   <input type="date" class="input-txt" name="tkbegintime"autocomplete="off" size="43"/>
                </p>
				<p><label for="tkaftertime"><em>*</em>返回日期：</label>
                   <input type="date" name="tkaftertime"class="input-txt" autocomplete="off" size="43" />
                </p>
				<p><label for="tkphone"><em>*</em>联系方式：</label>
                   <input name="tkphone" type="text"  class="input-txt" id="tkphone" autocomplete="off" size="43" />
                </p>
                <p><label for="file"><em>*</em>景点图片：</label>
                	<input type="file" name="file"/>
                </p>
				<p><label for="tkdetails"><em>*</em>内容：</label>
					<textarea rows="5" cols="60" name="tkdetails" id="tkdetails"  size="43" ></textarea>
				</p><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
              <input type="submit"  value="发布" class="reg-login">
			</form>
			
			
		</div>
	</div>
	</div>	
</div>
<!-- 底部footer 开始-->
<%@include file="/including/footer.jsp" %>
<!-- footer end -->

</body>
</html>