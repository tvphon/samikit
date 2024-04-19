package kh.mclass.semitkit.member.model.dto;

public class MemberLoginDto {
// 회원 로그인 DTO	
//	이름          널?       유형            
//	----------- -------- ------------- 
//	USERID      NOT NULL VARCHAR2(50)  
//	USERPWD     NOT NULL VARCHAR2(150)
//	EMAIL       NOT NULL VARCHAR2(50) 

	private String userId;
	private String userPwd;

	@Override
	public String toString() {
		return "MemberLoginDto [userId=" + userId + ", userPwd=" + userPwd + "]";
	}
	public MemberLoginDto(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	
	
	
}
