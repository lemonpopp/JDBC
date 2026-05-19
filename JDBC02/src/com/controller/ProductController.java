package com.controller;

import java.util.List;

import com.model.service.ProductService;
import com.model.vo.Product;

public class ProductController {
	private ProductService service = new ProductService();
	
	//전체 출력
	public List<Product> selectAll(){
		return service.selectAll();
	}
	public Product selectOne(String id) {
		Product res = service.selectOne(id);
		return res;
	}
	public int insert(Product dto) {
		return service.insert(dto);
	}
	public int update(Product dto) {
		return service.update(dto);
	}
	public int delete(String id) {
		return service.delete(id);
	}
	
	
	
	
	
	
	
	
	
	
}
