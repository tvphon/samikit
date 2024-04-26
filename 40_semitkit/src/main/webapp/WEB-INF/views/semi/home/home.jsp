<jsp:include page="/WEB-INF/views/common/link_files.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link href="<%=request.getContextPath()%>/resources/css/home.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div>
        <%@include file="/WEB-INF/views/semi/mainloginoutheader.jsp" %>
    </div>
    <div class="black"></div>
    
    <div class="sidebar">
        <a href="best-products.jsp"><img src="<%=request.getContextPath()%>/resources/image/logo.png" alt="Left Image"></a>
    </div>
    <div class="main-content">
        <div class="best-products">
            <h2>BEST 상품</h2>
            <div class="product">
            	<a href="#"><img src="<%=request.getContextPath()%>/resources/image/logo.png" alt="Best Product 1"></a>
                <p>상품 설명 1</p>
            </div>
            <div class="product">
                <a href="#"><img src="<%=request.getContextPath()%>/resources/image/logo.png" alt="Best Product 2"></a>
                <p>상품 설명 2</p>
            </div>
        </div>
        <div class="new-products">
            <h2>NEW 상품</h2>
            <div class="product">
                <a href="#"><img src="<%=request.getContextPath()%>/resources/image/logo.png" alt="New Product 1"></a>
                <p>상품 설명 1</p>
            </div>
            <div class="product">
                <a href="#"><img src="<%=request.getContextPath()%>/resources/image/logo.png" alt="New Product 1"></a>
                <p>상품 설명 2</p>
            </div>
        </div>
    </div>  
</body>
<script>
$(document).ready(function() {
    // 라디오 버튼 변경 시 상품 정렬
    $('input[type=radio][name=sort]').change(function() {
        var sortType = $(this).val();
        filterProducts(sortType);
    });

    // 초기화: 신상품 기준으로 정렬
    filterProducts('new');

    function filterProducts(sortType) {
        // 모든 상품 숨기기
        $('.product').hide();

        // 선택한 정렬 방식에 따라 상품 보여주기
        switch (sortType) {
            case 'new':
                // 신상품 기준으로 정렬
                $('.product').slice(0, 6).show();
                break;
            case 'name':
                // 상품명 기준으로 정렬
                // 여기에 구현
                break;
            case 'low':
                // 낮은 가격 기준으로 정렬
                // 여기에 구현
                break;
            case 'high':
                // 높은 가격 기준으로 정렬
                // 여기에 구현
                break;
            default:
                break;
        }
    }
});
</script>
</html>