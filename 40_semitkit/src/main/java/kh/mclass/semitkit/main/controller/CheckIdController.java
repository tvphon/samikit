package kh.mclass.semitkit.main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kh.mclass.semitkit.member.model.service.MemberService;

/**
 * Servlet implementation class CheckIdController
 */
@WebServlet("/checkid.ajax")
public class CheckIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("###checkid  doPost 진입");
		String k1 = request.getParameter("k1");
		String k2 = request.getParameter("k2");
		System.out.println(k1+","+k2);
	
		String USERID = request.getParameter("cid");
		System.out.println(USERID);
		//TODO DB 갔다올 예정
		int result = new MemberService().selectCheckId(USERID);
		response.getWriter().append(String.valueOf(result));	
		
		// ajax로 왔다면 
		// dispacher, sendredirect 로 다른 페이지로 이동하면 안됨!!!!
		// 왔던 곳 success/error 의 callback 으로 돌아가야함. 
		
//		List<MemberDto> result = new MemberService().selectAllList();
//		System.out.println(result);
//		Gson gson = new Gson();
//		String jsonResult = gson.toJson(result);
//		System.out.println("=== json===");
//		System.out.println(jsonResult);
//		response.getWriter().append(jsonResult);
	}

}















