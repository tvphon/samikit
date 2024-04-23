package kh.mclass.semitkit.member.model.dao;

import static kh.mclass.jdbc.common.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.semitkit.member.model.dto.MemberDto;
import kh.mclass.semitkit.member.model.dto.MemberInfoDto;
import kh.mclass.semitkit.member.model.dto.MemberJoinDto;
import kh.mclass.semitkit.member.model.dto.MemberLoginDto;

public class MemberDao {

	// select one login
	//	회원 로그인에 사용되는 아이디와 비밀번호를 받아 해당 회원의 아이디와 이메일을 조회하는 메서드
	public String loginGetInfo(Connection conn, MemberLoginDto dto) {
		String result = null;
		String sql = "SELECT MEMBER_KEY FROM MEMBER WHERE USERID=? AND USERPWD=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPwd());
			rs = pstmt.executeQuery();
			// ResetSet처리
			if(rs.next()) {
				result = rs.getString("MEMBER_KEY");
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}

	
//	// select one login
//	// 회원 로그인에 사용되는 아이디와 비밀번호를 받아 해당 회원의 존재 여부를 조회하는 메서드
//	public int login(Connection conn, MemberLoginDto dto) {
//		int result = 0;
//		String sql = "SELECT COUNT(*) c  FROM MEMBER WHERE MEM_ID=? AND MEM_PWD=?";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			// ? 처리
//			pstmt.setString(1, dto.getMemId());
//			pstmt.setString(2, dto.getMemPwd());
//			rs = pstmt.executeQuery();
//			// ResetSet처리
//			if(rs.next()) {
//				result = rs.getInt("c");
//			}			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		close(rs);
//		close(pstmt);
//		return result;
//	}
	
	
	
	// select one check id
	// 회원 가입 시 입력한 아이디가 이미 존재하는지를 확인하는 메서드
	public int selectCheckId(Connection conn, String USERID) {
		int result = 0;
		String sql = "SELECT COUNT(*) c FROM MEMBER WHERE USERID=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setString(1, USERID);
			rs = pstmt.executeQuery();
			// ResetSet처리
			if(rs.next()) {
				result = rs.getInt("c");
				System.out.println(result);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs);
		close(pstmt);
		return result;
	}
	
	
	
	
	
//	// select list - all
//	// 모든 회원의 아이디, 비밀번호, 이메일을 조회하는 메서드
//	public List<MemberDto> selectAllList(Connection conn) {
//		System.out.println("MemberDao selectAllList");
//		List<MemberDto> result = null;
//		String sql = "SELECT MEM_ID,MEM_PWD,MEM_EMAIL    FROM MEMBER";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			// ? 처리
//			rs = pstmt.executeQuery();
//			// ResetSet처리
//			if(rs.next()) {
//				result = new ArrayList<MemberDto>();
//				do {
//					MemberDto dto = new MemberDto(	rs.getString("MEM_ID"),rs.getString("MEM_PWD"),rs.getString("MEM_EMAIL"));
//					result.add(dto);
//				}while (rs.next());
//			}	
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		close(rs);
//		close(pstmt);
//		System.out.println("MemberDao selectAllList : "+ result);
//		return result;
//	}
	
//	// select one
//	// 특정 회원의 아이디, 비밀번호, 이메일을 조회하는 메서드
//	public MemberDto selectOne(Connection conn, String memId) {
//		MemberDto result = null;
//		String sql = "SELECT MEM_ID,MEM_PWD,MEM_EMAIL  FROM MEMBER WHERE MEM_ID=?";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			// ? 처리
//			pstmt.setString(1, memId);
//			rs = pstmt.executeQuery();
//			// ResetSet처리
//			if(rs.next()) {
//				result = new MemberDto(	rs.getString("MEM_ID"),rs.getString("MEM_PWD"),rs.getString("MEM_EMAIL"));
//			}			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		close(rs);
//		close(pstmt);
//		return result;
//	}

	
	// insert
	// 새로운 회원 정보를 데이터베이스에 추가하는 메서드
	public int insert(Connection conn, MemberJoinDto dto) {
		System.out.println("memberdao insert() p: "+ dto);
		int result = 0;
//		INSERT INTO MEMBER VALUES ('kh1', 'pwd1', '아무개', '01012345678','이메일', '주소');
		String sql = "INSERT INTO MEMBER (MEMBER_KEY,USERID,USERPWD,USERNAME,PHONE,EMAIL,ADDRESS,ENROLL_DATE,LAST_UPDATE) "
				+ " VALUES (MEMBER_KEY.nextval,?, ?, ?, ?, ?, ?,SYSDATE,SYSDATE)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ? 처리
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserPwd());
			pstmt.setString(3, dto.getUserName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getAddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt);
		System.out.println("memberdao insert() r: "+ result);
		return result;
	}
	
//	// update
//	// 회원 정보를 업데이트하는 메서드
//	public int update(Connection conn, MemberDto dto) {
//		int result = 0;
//		String sql = "";  //TODO
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			// ? 처리
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		close(pstmt);
//		return result;
//	}
	
//	// delete
//	// 회원 정보를 삭제하는 메서드
//	public int delete(Connection conn, String memId) {
//		int result = 0;
//		String sql = "DELETE FROM MEMBER WHERE MEM_ID=?";
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			// ? 처리
//			pstmt.setString(1, memId);
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		close(pstmt);
//		return result;
//	}

}
