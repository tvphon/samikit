<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<link href="<%=request.getContextPath()%>/resources/css/member.css" rel="stylesheet">
<title>회원가입페이지</title>
</head>
<body>
	<div class="member-wrap">
	<h1>회원가입</h1>
	<form action="${pageContext.request.contextPath }/member" method="POST">
		<div >
			아이디:<input type="text" name="id" id="id" class="id-width" required>
			<button type="button" class="btn checkid">중복확인</button>
		</div>
		<div>
			<div id="msg-memberId"></div>
		</div>
		<div>
			비밀번호:<input type="password" name="pwd" id="pwd" class="pwd-width" required>
		</div>
		<div>
			<div id="msg-memberpassword"></div>
		</div>
		<div>
			비밀번호확인:<input type="password" id="pwdch" name="pwdch" class="pwdch-width" required>
		</div>
		<div>
			<div id="msg-memberpasswordCheck"></div>
		</div>
		<div>
			이름:<input type="text" id="name" name="name"  class="name-width"  required>
		</div>
		<div>
			휴대전화:<input type="text" id="phone" name="phone" class="phone-width" required>
		</div>
		<div>
			<div id="msg-memberphone"></div>
		</div>
		<div >
			이메일:<input type="text" id="email" name="email" class="email-width" required> 
			<select name="email2">
				<option selected="selected" value="">직접입력</option>
				<option value="@naver.com">naver.com</option>
				<option value="@daum.net">daum.net</option>
				<option value="@hanmail.net">hanmail.net</option>
				<option value="@gmail.com">gmail.com</option>
				<option value="@hotmail.com">hotmail.com</option>
				<option value="@yahoo.co.kr">yahoo.co.kr</option>
				<option value="@chollian.net">chollian.net</option>
				<option value="@empal.com">empal.com</option>
				<option value="@freechal.com">freechal.com</option>
				<option value="@hitel.net">hitel.net</option>
				<option value="@hanmir.com">hanmir.com</option>
				<option value="@hanafos.com">hanafos.com</option>
				<option value="@korea.com">korea.com</option>
				<option value="@lycos.co.kr">lycos.co.kr</option>
				<option value="@nate.com">nate.com</option>
				<option value="@netian.com">netian.com</option>
				<option value="@paran.com">paran.com</option>
				<option value="@unitel.co.kr">unitel.co.kr</option>

			</select>
			<button type="button" class="btn Emailch">이메일확인</button>
		</div>
		<div >
		<input type="text" name="address" id="sample6_postcode" class="narrow-input" placeholder="우편번호" required> <input
			type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" name="address2"   id="sample6_address" class="address2-width" placeholder="주소" required><br>
		<input type="text" name="address3" id="sample6_detailAddress" class="address3-width" placeholder="상세주소" required>
		<input type="text" name="address4" id="sample6_extraAddress" class="address4-width" placeholder="참고항목" required>
		</div>
		<div class="find-btn">
		<button type="submit" onclick="signUpHandler()" class="find-btn1" >회원가입</button>
		<button type="reset" class="find-btn2" >다시 입력</button>
		</div>
		
	</form>
	</div>
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	$(loadedHandler);
	function loadedHandler() {
		//event 등록
		$(".btn.checkid").on("click", btnCheckidClickHandler);
	}
	function btnCheckidClickHandler() {
		var idVal = $("[name=id]").val();
		$.ajax({
			async : false,
			url : "${pageContext.request.contextPath }/checkid.ajax",
			method : "post",
			data : {
				cid : $("[name=id]").val(),
				k1 : "v1",
				k2 : "v2"
			}
			///////////// contentType 은 data의 자료형

			///////////// dataType은 success의 result 의 자료형
			//		,dataType : "json"
			,
			success : function(result) {
				console.log(result);
				if (result > 0) {
					alert("사용불가!! 다른아이디를 사용해주세요.");
				} else {
					alert("사용가능");
				}

				/*
				console.log(typeof result);
				//[ {},{}]
				var htmlVal = '';
				$.each(result, function(){
					console.log(this.memEmail);
					// 백틱
					htmlVal += '<div>'+this.memEmail+'</div>';
				});
				$(".member-list").html(htmlVal);
				 */
			},
			error : function(request, status, error) {
				alert("code: " + request.status + "\n" + "message: "
						+ request.responseText + "\n" + "error: " + error);
			}
		});

	}

	//모든 공백 체크 정규식
	var empJ = /\s/g;
	//아이디 정규식
	var idJ = /^[a-z0-9_-]{4,12}$/;
	// 비밀번호 정규식
	var pwJ = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()])[A-Za-z0-9!@#$%^&*()]{8,12}$/;
	// 휴대폰 번호 정규식
	var phoneJ = /^[01]{1,3}-[0-9]{4}-[0-9]{4}$/;

	$("#id").blur(function() {
		if (idJ.test($(this).val())) {
			console.log(idJ.test($(this).val()));
			console.log($(this).val());
			$("#msg-memberId").text('');
		} else {
			$('#msg-memberId').text('4~12자 특수문자는 _- 만 허용해요.');
			
		}
	});
	$("#pwd").blur(function() {
		if (pwJ.test($(this).val())) {
			console.log(pwJ.test($(this).val()));
			$("#msg-memberpassword").text('');
		} else {
			$('#msg-memberpassword').text('특수문자 포함 8~12자로 써주세요');
		}
	});

	$("#phone").blur(function() {
		if (phoneJ.test($(this).val())) {
			console.log(phoneJ.test($(this).val()));
			$("#msg-memberphone").text('');
		} else {
			$('#msg-memberphone').text('-포함하고 휴대폰번호를 써주세요');
		}
	});
	// 패스워드 확인 스크립트
	$("#pwdch").blur(function() {
		var pw1 = $("#pwd").val();
		var pw2 = $("#pwdch").val();
		if (pw1 == pw2) {
			$('#msg-memberpasswordCheck').text("비밀번호가 일치합니다")
		} else {
			$('#msg-memberpasswordCheck').text("비밀번호가 일치하지않습니다.비밀번호를 재확인해주세요")
		}

	});
	
	
	

	function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
</html>