package com.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.model.dao.ProductDao;
import com.model.vo.Product;

import static common.JDBCTemplate.*;

public class ProductService {
	private ProductDao dao = new ProductDao();
	
	public List<Product> selectAll(){
		Connection con = getConnection();
		List<Product> res = dao.selectAll(con);
		close(con);
		return res;
	}
	public Product selectOne(String id) {
		Connection con = getConnection();
		Product res = dao.selectOne(con,id);
		close(con);
		return res;
	}
	public int insert(Product dto) {
		Connection con = getConnection();
		int res = dao.insert(con, dto);
		if(res > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return res;
	}
	public int update(Product dto) {
		Connection con = getConnection();
		int res = dao.update(con, dto);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return res;
	}
	public int delete(String id) {
		Connection con = getConnection();
		int res = dao.delete(con, id);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return res;
	}
	
	
	
}
