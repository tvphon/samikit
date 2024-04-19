package kh.mclass.semitkit.member.model.dto;

public class MemberJoinDto {
// 회원가입 DTO	
//	이름          널?       유형            
//	----------- -------- ------------- 
//	USERID      NOT NULL VARCHAR2(50)  
//	USERPWD     NOT NULL VARCHAR2(150) 
//	USERNAME    NOT NULL VARCHAR2(15)  
//	PHONE       NOT NULL VARCHAR2(15)
//	EMAIL       NOT NULL VARCHAR2(50)  
//	ADDRESS     NOT NULL NVARCHAR2(30) 

    private String userId;
    private String userPwd;
    private String userName;
    private String phone;
    private String email;
    private String address;
	@Override
	public String toString() {
		return "MemberJoinDto [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", phone="
				+ phone + ", email=" + email + ", address=" + address + "]";
	}
	public MemberJoinDto(String userId, String userPwd, String userName, String phone, String email, String address) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	
	
    
}
