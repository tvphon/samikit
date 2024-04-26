<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<div class="shopping-wrap ">
    <div class="product-grid">
<%-- displayProductWrap()
        <div class="product">
            <a href="product1.html"><img src="${pageContext.request.contextPath }/resources/image/logo.png" alt="상품 1"></a>
            <div class="product-name">상품명 1</div>
            <div class="product-price">가격: 100원</div>
        </div>
       
 --%>
    </div>

 	<div class="product-page-wrap flex">
<!-- displayProducPagetWrap() -->
	</div>

<script>
	
	$(loadedHandler);
	function loadedHandler(){
		// loaded -바로 ajax - display
		ajaxGetShoppingData("new");
		
		// event등록
		$("select[name=sort]").on("change", sortChangeHandler);
	}
	function sortChangeHandler(){
		var sortnum = $("select[name=sort]").val();
		ajaxGetShoppingData(sortnum);
	}
	function pageClickHandler(pageNum){
		var sortnum = $("select[name=sort]").val();
		console.log("======00001");
		console.log(pageNum);
		console.log(sortnum);
		ajaxGetShoppingData(sortnum, pageNum);
	}
	function ajaxGetShoppingData(sorttype, pageNum){
		if(!pageNum){
			pageNum=1;
		}
		$.ajax({
			url: "${pageContext.request.contextPath }/product/list.ajax"
			,method:"post"
			,error : ajaxErrorHandler
			,data: { sorttype : sorttype , page : pageNum }
			,dataType:"json"
			,success: function(map){
				console.log(map);
				displayProductWrap(map.dtolist);
				displayProducPagetWrap(map);
			}
		});
	}
	
	function displayProductWrap(dtolist){
		var htmlVal = '';
		if(dtolist.length == 0){
			htmlVal += `<div class="product">
				<h1>상품 0개</h1>
			    </div>`;
		} else {
			for(var i in dtolist){
				var vo = dtolist[i];
				htmlVal += `
			 		<div class="product">
		            <a href="${pageContext.request.contextPath }/shopping/detail?productKey=\${vo.productKey}"><img src="${pageContext.request.contextPath }/\${vo.imgMain1 }" alt=""></a>
		            <div class="product-name">\${vo.productPrice }</div>
		            <div class="product-price">\${vo.productName }</div>
		        </div>
				`;
			}
		}
		$(".product-grid").html(htmlVal);
	}
	function displayProducPagetWrap(map){
		var htmlVal = '';
		//for
		htmlVal += `<ul>`;
		if(map.startPageNum > 1) {
			htmlVal += `<li><button type="button" onclick="pageClickHandler(\${map.startPageNum-1 });">  &lt;&lt; </button></li>`;
		}
		for(var page=map.startPageNum; page <= map.endPageNum ; page++) {
			if(map.currentPageNum == page){
				htmlVal += `<li><strong>\${page }</strong></li>`;
			} else {
				htmlVal += `<li><button type="button" onclick="pageClickHandler(\${page });">\${page }</button></li>`;
			}
		}
		if(map.endPageNum < map.totalPageCount) {
			htmlVal += `<li><button type="button" onclick="pageClickHandler(\${map.endPageNum+1 });">  &gt;&gt; </button></li>`;
		}

		htmlVal += `</ul>`;
		
		$(".product-page-wrap").html(htmlVal);
	}
</script>

