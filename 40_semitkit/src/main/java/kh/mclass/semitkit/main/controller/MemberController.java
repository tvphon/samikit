package kh.mclass.semitkit.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kh.mclass.semitkit.member.model.service.MemberService;
import kh.mclass.semitkit.member.model.dto.MemberJoinDto;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/semi/member/member.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기여기");
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pwd");
		String userName = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email")+request.getParameter("email2");
		
		String address = request.getParameter("address")+request.getParameter("address2")+request.getParameter("address3")+request.getParameter("address4");
		System.out.println(userPwd+userPwd+userName+phone+email+address);
		
		MemberJoinDto dto = new MemberJoinDto(userId, userPwd, userName,phone,email,address);
		System.out.println(dto);
		int result = new MemberService().insert(dto);
		if(result < 0 ) {
			// 회원가입실패시
			// TODO
			response.sendRedirect(request.getContextPath()+"/main");
			return;
		}
		// 회원가입정상
		response.sendRedirect(request.getContextPath()+"/login");
		
		
	}

}
