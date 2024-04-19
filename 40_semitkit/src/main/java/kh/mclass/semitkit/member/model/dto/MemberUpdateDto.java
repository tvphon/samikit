package kh.mclass.semitkit.member.model.dto;


public class MemberUpdateDto {
// 회원 정보 업데이트 DTO
//	이름          널?       유형            
//	----------- -------- ------------- 
//	MEMBER_KEY  NOT NULL NUMBER        
//	USERID      NOT NULL VARCHAR2(50)  
//	USERPWD     NOT NULL VARCHAR2(150) 
//	USERNAME    NOT NULL VARCHAR2(15)  
//	PHONE       NOT NULL VARCHAR2(15)  
//	ADDRESS     NOT NULL NVARCHAR2(30) 
//	BANNED               VARCHAR2(1)   
//	MEMBEROUT            VARCHAR2(1)  

    private int memberKey;
    private String userId;
    private String userPwd;
    private String userName;
    private String phone;
    private String address;
    private String banned;
    private String memberOut;
	@Override
	public String toString() {
		return "MemberUpdateDto [memberKey=" + memberKey + ", userId=" + userId + ", userPwd=" + userPwd + ", userName="
				+ userName + ", phone=" + phone + ", address=" + address + ", banned=" + banned + ", memberOut="
				+ memberOut + "]";
	}
	public MemberUpdateDto(int memberKey, String userId, String userPwd, String userName, String phone, String address,
			String banned, String memberOut) {
		super();
		this.memberKey = memberKey;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.address = address;
		this.banned = banned;
		this.memberOut = memberOut;
	}
	public int getMemberKey() {
		return memberKey;
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
	public String getAddress() {
		return address;
	}
	public String getBanned() {
		return banned;
	}
	public String getMemberOut() {
		return memberOut;
	}
	
    
}
