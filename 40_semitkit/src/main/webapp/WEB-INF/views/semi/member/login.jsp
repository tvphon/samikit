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
        <%@include file="/WEB-INF/views/semi/mainloginoutheader.jsp" %>
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
				location.href="${pageContext.request.contextPath}/home";
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

$(document).ready(function(){
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var key = getCookie("key");
    $("#id").val(key); 
     
    // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
    if($("#id").val() != ""){ 
        $("#remember").prop("checked", true); // 아이디 저장하기를 체크 상태로 두기.
    }
     
    $("#remember").change(function(){ // 체크박스에 변화가 있다면,
        if($("#remember").is(":checked")){ // 아이디 저장하기 체크했을 때,
            setCookie("key", $("#id").val(), 7); // 7일 동안 쿠키 보관
        }else{ // 아이디 저장하기 체크 해제 시,
            deleteCookie("key");
        }
    });
     
    // 아이디 저장하기를 체크한 상태에서 아이디를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("#id").keyup(function(){ // 아이디 입력 칸에 아이디를 입력할 때,
        if($("#remember").is(":checked")){ // 아이디 저장하기를 체크한 상태라면,
            setCookie("key", $("#id").val(), 7); // 7일 동안 쿠키 보관
        }
    });

    // 쿠키 저장하기 
    // setCookie => saveid함수에서 넘겨준 시간이 현재시간과 비교해서 쿠키를 생성하고 지워주는 역할
    function setCookie(cookieName, value, exdays) {
        var exdate = new Date();
        exdate.setDate(exdate.getDate() + exdays);
        var cookieValue = escape(value) + ((exdays == null) ? "" : "; expires=" + exdate.toGMTString());
        document.cookie = cookieName + "=" + cookieValue;
    }

    // 쿠키 삭제
    function deleteCookie(cookieName) {
        var expireDate = new Date();
        expireDate.setDate(expireDate.getDate() - 1);
        document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
    }
     
    // 쿠키 가져오기
    function getCookie(cookieName) {
        cookieName = cookieName + '=';
        var cookieData = document.cookie;
        var start = cookieData.indexOf(cookieName);
        var cookieValue = '';
        if (start != -1) { // 쿠키가 존재하면
            start += cookieName.length;
            var end = cookieData.indexOf(';', start);
            if (end == -1) // 쿠키 값의 마지막 위치 인덱스 번호 설정 
                end = cookieData.length;
            console.log("end위치  : " + end);
            cookieValue = cookieData.substring(start, end);
        }
        return unescape(cookieValue);
    }
});

</script>






























</body>
</html>