package kh.mclass.semitkit.member.model.dto;

import java.util.Date;

public class MemberInfoDto {
// 회원 정보 조회 DTO
//	이름          널?       유형            
//	----------- -------- ------------- 
//	USERID      NOT NULL VARCHAR2(50)  
//	USERNAME    NOT NULL VARCHAR2(15)  
//	PHONE       NOT NULL VARCHAR2(15)  
//	ADDRESS     NOT NULL NVARCHAR2(30) 
//	ENROLL_DATE NOT NULL DATE          
//	LAST_UPDATE NOT NULL DATE          
//	BANNED               VARCHAR2(1)   
//	MEMBEROUT            VARCHAR2(1)   

	    private String userId;
	    private String userName;
	    private String phone;
	    private String address;
	    private Date enrollDate;
	    private Date lastUpdate;
	    private String banned;
	    private String memberOut;
		@Override
		public String toString() {
			return "MemberInfoDto [userId=" + userId + ", userName=" + userName + ", phone=" + phone + ", address="
					+ address + ", enrollDate=" + enrollDate + ", lastUpdate=" + lastUpdate + ", banned=" + banned
					+ ", memberOut=" + memberOut + "]";
		}
		public MemberInfoDto(String userId, String userName, String phone, String address, Date enrollDate,
				Date lastUpdate, String banned, String memberOut) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.phone = phone;
			this.address = address;
			this.enrollDate = enrollDate;
			this.lastUpdate = lastUpdate;
			this.banned = banned;
			this.memberOut = memberOut;
		}
		public String getUserId() {
			return userId;
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
