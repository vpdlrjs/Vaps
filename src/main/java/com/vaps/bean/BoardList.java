package com.vaps.bean;

import java.sql.Date;
/*
 * 변수는 소문자로 하자.
 * db table 변수와 같이 대문자로 똑같이 하면 동작이 안됐다.
 * B_NUM 이라고 db에서 쓰면 Bean에서는 b_num이라고 써야한다.
 */
public class BoardList {
	private int b_num;
	private String b_id;
	private String b_sub;
	private String b_contents;
	private Date b_date;
	private int b_readcount;
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_sub() {
		return b_sub;
	}
	public void setB_sub(String b_sub) {
		this.b_sub = b_sub;
	}
	public String getB_contents() {
		return b_contents;
	}
	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	public int getB_readcount() {
		return b_readcount;
	}
	public void setB_readcount(int b_readcount) {
		this.b_readcount = b_readcount;
	}
	
	
}
