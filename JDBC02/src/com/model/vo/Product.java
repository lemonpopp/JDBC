package com.model.vo;

public class Product {
	private String pid;
	private String pname;
	private int price;
	private String des;
	
	public Product() {}
	public Product(String pid, String pname, int price, String des) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.des = des;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	@Override
	public String toString() {
		return "[pid=" + pid + ", pname=" + pname + ", price=" + price + ", des=" + des + "]";
	}
	
	
	
}
