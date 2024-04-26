<jsp:include page="/WEB-INF/views/common/link_files.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/resources/css/mainheader.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<header>
    <div class="logo">
        <a href="<%=request.getContextPath()%>/home"><img src="<%=request.getContextPath()%>/resources/image/logo.png" alt="로고"></a>
    </div>
    <nav class="tnb">
<c:choose>
    	<c:when test="${empty sssLogin }">
        <ul>
            <li><a href="<%=request.getContextPath()%>/login">로그인 </a></li>
            <li><a href="<%=request.getContextPath()%>/member">회원가입</a></li>
            <li><a href="#">주문조회</a></li>
            <li><a href="#">고객센터</a></li>
        </ul>
	    </c:when>
   		<c:otherwise>
        <ul>
        	<li>
            <form id="frm-logout">
            <div><button class="btn logout" id="btn logout" >로그아웃</button></div>
            </form>
        	</li>
            <li><a href="#">마이페이지</a></li>
            <li><a href="#">주문조회</a></li>
            <li><a href="#">고객센터</a></li>
        </ul>
    </c:otherwise>
</c:choose>
    </nav>
    <div class="search-bar">
        <form action="search.jsp" method="GET">
            <input type="text" name="keyword" placeholder="상품을 검색하세요">
            <button type="submit">검색</button>
        </form>
    </div>
	<nav class="bnb">
        <ul>
            <li><a href="#">쇼핑하기</a></li>
            <li><a href="#">리뷰</a></li>
            <li><a href="#">상품 Q&A</a></li>
            <li><a href="#">공지사항</a></li>
        </ul>
    </nav>
</header>
<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록
	$(".btn.logout").on("click", btnLogoutClickHandler);
}
function btnLogoutClickHandler(){
	// get방식으로 사용하지 않음
	// location.href="${pageContext.request.contextPath}/logout";
	//
	
	alert("로그아웃되었습니다.");
	
	var frmlogout = document.getElementById("frm-logout");
	frmlogout.action = "${pageContext.request.contextPath}/logout";
	frmlogout.method = "post";
	frmlogout.submit();
	
	
}

</script>

</body>

</html>