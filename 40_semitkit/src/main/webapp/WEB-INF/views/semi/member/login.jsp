<jsp:include page="/WEB-INF/views/common/link_files.jsp"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<%=request.getContextPath()%>/resources/css/login.css" rel="stylesheet">
<title>Login</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
	<div>
        <%@include file="/WEB-INF/views/semi/mainlogoutheader.jsp" %>
    </div>

<form id="frm-login">
  <div><label for="id">아이디</label><input type="text" id="id" name="id"></div>
  <div><label for="pwd">패스워드</label><input type="password" id="pwd" name="pwd"></div>
  <div>
    <input type="checkbox" id="remember" name="remember">
    <label for="remember">아이디 저장</label>
  </div>
  <div class="form-links">
    <a href="#" class="find-id">아이디 찾기</a> |
    <a href="#" class="find-password">비밀번호 찾기</a>
  </div>
  <div><input type="button" value="로그인" class="btn submit"></div>
</form>

<script>
$(loadedHandler);
function loadedHandler(){
	//event 등록
	$("#frm-login .btn.submit").on("click", frmClickHandler);
}

function frmClickHandler(){
	console.log("클릭");
	//console.log(document.getElementById("frm-login").serialize());
	console.log($("#frm-login").serialize()); // query string 형태로 만들어줌.// id=sss&pwd=vvv
	//{id : $("#frm-login [name=id]").val() , pwd : $("#frm-login [name=pwd]").val()  }	
	//$("#frm-login").serialize()
	$.ajax({
		url:"${pageContext.request.contextPath }/login"
		, method : "post"
		, data : $("#frm-login").serialize()
		, success : function(result){
			console.log(result);
			if(result == 1 ){
				alert("반갑습니다.");
				var prePage = "${prePage}";
				if(prePage == "write"){
					location.href="${pageContext.request.contextPath}/board/write";
				}
				location.href="${pageContext.request.contextPath}/main";
			}else {
				alert("아이디 또는 패스워드가 일치하지 않습니다.\n다시 확인하고 로그인해주세요.");
				$("[name=pwd]").val("");
			}
		}
		,error : function(request, status, error){
			alert("code: "+request.status + "\n" + "message: " 
					+ request.responseText + "\n"
					+ "error: "+error);
		}
	});
	
}

</script>






























</body>
</html>