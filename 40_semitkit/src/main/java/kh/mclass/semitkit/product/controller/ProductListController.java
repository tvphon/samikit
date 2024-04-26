package kh.mclass.semitkit.product.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.mclass.semitkit.product.model.service.ProductService;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product/list.ajax")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service = new ProductService();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		-- 한페이지당글수 3 씩
		int pageSize = 6;
//		-- 화면하단 나타날 페이지수 5 씩
		int pageBlockSize = 5;
//		-- 현재페이지
		int currentPageNum = 1;  // 기본1
		// 페이지지정하고 들어왔다면... 현재페이지를 그값으로 설정함
		String pageNum = request.getParameter("page");
		try {
			currentPageNum = Integer.parseInt(pageNum);
		} catch(NumberFormatException e) {
		}
		String sorttype = request.getParameter("sorttype");
//		request.setAttribute("map" , service.selectPageList(pageSize, pageBlockSize, currentPageNum));
//		request.getRequestDispatcher("/WEB-INF/views/semi/product/productlist.jsp").forward(request, response);
		Map<String, Object> result = service.selectPageList(pageSize, pageBlockSize, currentPageNum, sorttype);
		response.getWriter().append(new Gson().toJson(result));
	}

}
