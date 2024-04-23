<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kh.mclass.semitkit.member.model.dto.MemberJoinDto" %>
<%@ page import="kh.mclass.semitkit.member.model.service.MemberService"%>
<%@ page import="kh.mclass.mybatis.mail.util.SHA256" %>
<%@ page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
	String userId = null;
	String userPwd = null;
	String userName = null;
	String phone = null;
	String email = null;
	String address = null;
	if(request.getParameter("userId") != null) {
		userId = request.getParameter("userId");
	}
	if(request.getParameter("userPwd") != null) {
		userPwd = request.getParameter("userPwd");
	}
	if(request.getParameter("userName") != null) {
		userPwd = request.getParameter("userName");
	}
	if(request.getParameter("phone") != null) {
		userPwd = request.getParameter("phone");
	}
	if(request.getParameter("email") != null) {
		email = request.getParameter("email");
	}
	if(request.getParameter("address") != null) {
		email = request.getParameter("address");
	}
	if(userId == null || userPwd == null || userName == null || phone == null || email == null || address == null ) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}
	MemberService service = new MemberService();
	int result = service.insert(new MemberJoinDto(userId, userPwd, userName, phone, SHA256.getSHA256(email), address));
%>

