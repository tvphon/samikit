<jsp:include page="/WEB-INF/views/common/link_files.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/resources/css/productheader.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<header>
    <div class="logo">
        <a href="#"><img src="<%=request.getContextPath()%>/resources/image/logo.png" alt="로고"></a>
    </div>
    <nav class="tnb">
        <ul>
            <li><a href="#">마이페이지</a></li>
            <li><a href="#">로그아웃</a></li>
            <li><a href="#">주문조회</a></li>
            <li><a href="#">고객센터</a></li>
        </ul>
    </nav>
    <div class="search-bar">
        <form action="search.jsp" method="GET">
            <input type="text" name="keyword" placeholder="상품을 검색하세요">
            <button type="submit">검색</button>
        </form>
    </div>
	<nav class="bnb">
        <ul>
            <li><a href="#">카테고리</a></li>
            <li><a href="#">best 상품</a></li>
            <li><a href="#">NEW 상품</a></li>
        </ul>
    </nav>
</header>
</body>
</html>