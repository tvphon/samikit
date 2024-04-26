package kh.mclass.semitkit.product.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kh.mclass.semitkit.product.model.dto.ProductListDto;

public class ProductDao {
	
	// select total Count
	public Integer selectTotalCount(SqlSession session) {
		return session.selectOne("productMapper.selectTotalCount");
	}
	
	public List<ProductListDto> selectPageListRowBounds(SqlSession session,int pageSize,  int currentPageNum) {
		int offset = (currentPageNum - 1) * pageSize;
		RowBounds rbounds = new RowBounds( offset , pageSize);
		return session.selectList("productMapper.selectPageList", null, rbounds);
	}
	// select list - all
	public List<ProductListDto> selectPageList(SqlSession session, int start, int end, String sorttype) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("startRownum", start);
		param.put("endRownum", end);
		param.put("sorttype", sorttype);
		return session.selectList("productMapper.selectPageListSort", param);
	}
	// select list - all
	public List<ProductListDto> selectPageList(SqlSession session, int start, int end) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("startRownum", start);
		param.put("endRownum", end);
		return session.selectList("productMapper.selectPageList", param);
	}
	
	// select list - all
	public List<ProductListDto> selectAllList(SqlSession session) {
		return session.selectList("productMapper.selectAllList");
	}
}
