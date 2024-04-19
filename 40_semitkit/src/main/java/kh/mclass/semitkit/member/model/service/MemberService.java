package kh.mclass.semitkit.member.model.service;

import static kh.mclass.jdbc.common.JdbcTemplate.close;
import static kh.mclass.jdbc.common.JdbcTemplate.getSemiConnection;

import java.sql.Connection;
import java.util.List;

import kh.mclass.semitkit.member.model.dto.MemberInfoDto;
import kh.mclass.semitkit.member.model.dto.MemberJoinDto;
import kh.mclass.semitkit.member.model.dto.MemberLoginDto;
import kh.mclass.semitkit.member.model.dao.MemberDao;
import kh.mclass.semitkit.member.model.dto.MemberDto;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	// select Login get Info
	// 회원 로그인 후 회원 정보를 가져오는 메서드입니다. 회원 로그인 정보를 받아와 DAO를 통해 데이터베이스에서 해당 회원의 정보를 조회합니다.
	public String loginGetInfo(MemberLoginDto dto) {
		String result = null;
		Connection conn = getSemiConnection(true);
		result = dao.loginGetInfo(conn, dto);
		close(conn);
		return result;
	}
	
//	// select Login
//	// 회원 로그인을 처리하는 메서드입니다. 회원 로그인 정보를 받아와 DAO를 통해 데이터베이스에서 로그인 여부를 확인합니다.
//	public int login(MemberLoginDto dto) {
//		int result = 0;
//		Connection conn = getSemiConnection(true);
//		result = dao.login(conn, dto);
//		close(conn);
//		return result;
//	}
	
	// select checkId
	// 회원 아이디 중복을 체크하는 메서드입니다. 회원 아이디를 받아와 DAO를 통해 데이터베이스에서 아이디 중복 여부를 확인합니다.
	public int selectCheckId(String USERID) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		
		
		result = dao.selectCheckId(conn, USERID);
		System.out.println(conn);
		close(conn);
		return result;
	}
	
	
	
	
//	// select list - all
//	// 모든 회원의 정보를 조회하는 메서드입니다. DAO를 통해 데이터베이스에서 모든 회원 정보를 가져옵니다.
//	public List<MemberDto> selectAllList() {
//		List<MemberDto> result = null;
//		Connection conn = getSemiConnection(true);
//		result = dao.selectAllList(conn);
//		close(conn);
//		return result;
//	}
	
//	// select one
//	// 특정 회원의 정보를 조회하는 메서드입니다. 회원 아이디를 받아와 DAO를 통해 해당 회원의 정보를 가져옵니다.
//	public MemberDto selectOne(String memId) {
//		MemberDto result = null;
//		Connection conn = getSemiConnection(true);
//		result = dao.selectOne(conn, memId);
//		close(conn);
//		return result;
//	}
	
	// insert
	// 회원 정보를 삽입하는 메서드입니다. 회원 정보를 받아와 DAO를 통해 데이터베이스에 삽입합니다.
	public int insert(MemberJoinDto dto) {
		int result = 0;
		Connection conn = getSemiConnection(true);
		result = dao.insert(conn, dto);
		close(conn);
		return result;
	}
	
//	// update
//	// 회원 정보를 수정하는 메서드입니다. 수정된 회원 정보를 받아와 DAO를 통해 데이터베이스에서 해당 회원 정보를 수정합니다.
//	public int update(MemberDto dto) {
//		int result = 0;
//		Connection conn = getSemiConnection(true);
//		result = dao.update(conn, dto);
//		close(conn);
//		return result;
//	}
	
	// delete
//	// 회원 정보를 삭제하는 메서드입니다. 회원 아이디를 받아와 DAO를 통해 해당 회원 정보를 데이터베이스에서 삭제합니다.
//	public int delete(String memId) {
//		int result = 0;
//		Connection conn = null;
//		result = dao.delete(conn, memId);
//		close(conn);
//		return result;
//	}
}
