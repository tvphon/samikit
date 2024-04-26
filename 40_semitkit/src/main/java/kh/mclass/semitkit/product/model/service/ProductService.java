package kh.mclass.semitkit.product.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


import static kh.mclass.jdbc.common.MybatisTemplate.*;

import kh.mclass.semitkit.product.model.dao.ProductDao;
import kh.mclass.semitkit.product.model.dto.ProductListDto;

public class ProductService {
	private ProductDao dao = new ProductDao();
	
	public Map<String, Object> selectPageListMybaris(int pageSize, int pageBlockSize, int currentPageNum) {
		Map<String, Object> result = null;
		SqlSession session = getSqlSession();
		List<ProductListDto> productList = dao.selectPageListRowBounds(session, pageSize, currentPageNum);
		session.close();
		return result;
	}
	// select list - all
		public Map<String, Object> selectPageList(int pageSize, int pageBlockSize, int currentPageNum, String sorttype) {
			Map<String, Object> result = null;
			
			SqlSession session = getSqlSession();
			
			System.out.println("currentPageNum: " +currentPageNum);
			int start = pageSize*(currentPageNum-1)+1;
			int end = pageSize*currentPageNum;
			
//			--- 총글개수 103
//			select count(*) cnt from board;
			int totalCount = dao.selectTotalCount(session);
			System.out.println("totalCount:"+totalCount);
//			-- 전체페이지수  = ceil(총글개수/한페이지당글수) = (총글개수%한페이지당글수== 0)?(총글개수/한페이지당글수):(총글개수/한페이지당글수+1) 
//			int totalPageCount = (int)Math.ceil(totalCount/(double)pageSize);
			int totalPageCount = (totalCount % pageSize == 0)? totalCount/pageSize :  totalCount/pageSize+1;
			
//			-- 시작페이지 startPageNum = (현재페이지%페이지수 == 0) ? ((현재페이지/페이지수)-1)*페이지수 + 1  :((현재페이지/페이지수))*페이지수 + 1
//			-- 끝페이지 endPageNum =  (endPageNum > 전체페이지수) ? 전체페이지수 : startPageNum+페이지수 - 1;
			int startPageNum = (currentPageNum%pageBlockSize == 0) ? ((currentPageNum/pageBlockSize)-1)*pageBlockSize + 1  :((currentPageNum/pageBlockSize))*pageBlockSize + 1;
			int endPageNum = (startPageNum+pageBlockSize > totalPageCount) ? totalPageCount : startPageNum+pageBlockSize-1;
			
			List<ProductListDto> dtolist = dao.selectPageList(session, start, end, sorttype);
			session.close();
			
			result = new HashMap<String, Object>();
			result.put("dtolist", dtolist);
			result.put("totalPageCount", totalPageCount);
			result.put("startPageNum", startPageNum);
			result.put("endPageNum", endPageNum);
			result.put("currentPageNum", currentPageNum);
			System.out.println("selectPageList() : "+result);
			return result;
		}
	// select list - all
	public Map<String, Object> selectPageList(int pageSize, int pageBlockSize, int currentPageNum) {
		Map<String, Object> result = null;
		
		SqlSession session = getSqlSession();
		
		System.out.println("currentPageNum: " +currentPageNum);
		int start = pageSize*(currentPageNum-1)+1;
		int end = pageSize*currentPageNum;
		
//		--- 총글개수 103
//		select count(*) cnt from board;
		int totalCount = dao.selectTotalCount(session);
		System.out.println("totalCount:"+totalCount);
//		-- 전체페이지수  = ceil(총글개수/한페이지당글수) = (총글개수%한페이지당글수== 0)?(총글개수/한페이지당글수):(총글개수/한페이지당글수+1) 
//		int totalPageCount = (int)Math.ceil(totalCount/(double)pageSize);
		int totalPageCount = (totalCount % pageSize == 0)? totalCount/pageSize :  totalCount/pageSize+1;
		
//		-- 시작페이지 startPageNum = (현재페이지%페이지수 == 0) ? ((현재페이지/페이지수)-1)*페이지수 + 1  :((현재페이지/페이지수))*페이지수 + 1
//		-- 끝페이지 endPageNum =  (endPageNum > 전체페이지수) ? 전체페이지수 : startPageNum+페이지수 - 1;
		int startPageNum = (currentPageNum%pageBlockSize == 0) ? ((currentPageNum/pageBlockSize)-1)*pageBlockSize + 1  :((currentPageNum/pageBlockSize))*pageBlockSize + 1;
		int endPageNum = (startPageNum+pageBlockSize > totalPageCount) ? totalPageCount : startPageNum+pageBlockSize-1;
		
		List<ProductListDto> dtolist = dao.selectPageList(session, start, end);
		session.close();
		
		result = new HashMap<String, Object>();
		result.put("dtolist", dtolist);
		result.put("totalPageCount", totalPageCount);
		result.put("startPageNum", startPageNum);
		result.put("endPageNum", endPageNum);
		result.put("currentPageNum", currentPageNum);
		System.out.println("selectPageList() : "+result);
		return result;
	}
}
