package kh.mclass.semitkit.member.model.dto;

import java.util.Date;

public class MemberDto {
//	이름          널?       유형            
//			----------- -------- ------------- 
//			MEMBER_KEY  NOT NULL NUMBER        
//			USERID      NOT NULL VARCHAR2(50)  
//			USERPWD     NOT NULL VARCHAR2(150) 
//			USERNAME    NOT NULL VARCHAR2(15)  
//			PHONE       NOT NULL VARCHAR2(15)  
//			EMAIL       NOT NULL VARCHAR2(50)  
//			ADDRESS     NOT NULL NVARCHAR2(30) 
//			ENROLL_DATE NOT NULL DATE          
//			LAST_UPDATE NOT NULL DATE          
//			BANNED               VARCHAR2(1)   
//			MEMBEROUT            VARCHAR2(1)      
    private int memberKey;
    private String userId;
    private String userPwd;
    private String userName;
    private String phone;
    private String email;
    private String address;
    private Date enrollDate;
    private Date lastUpdate;
    private String banned;
    private String memberOut;
	@Override
	public String toString() {
		return "MemberDto [memberKey=" + memberKey + ", userId=" + userId + ", userPwd=" + userPwd + ", userName="
				+ userName + ", phone=" + phone + ", email=" + email + ", address=" + address + ", enrollDate="
				+ enrollDate + ", lastUpdate=" + lastUpdate + ", banned=" + banned + ", memberOut=" + memberOut + "]";
	}
	public MemberDto(int memberKey, String userId, String userPwd, String userName, String phone, String email,
			String address, Date enrollDate, Date lastUpdate, String banned, String memberOut) {
		super();
		this.memberKey = memberKey;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.enrollDate = enrollDate;
		this.lastUpdate = lastUpdate;
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
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public String getBanned() {
		return banned;
	}
	public String getMemberOut() {
		return memberOut;
	}
	
	
    
}
