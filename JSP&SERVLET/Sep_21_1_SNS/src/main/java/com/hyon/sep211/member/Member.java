package com.hyon.sep211.member;

import java.util.Date;

public class Member {
	private String m_id;
	private String m_password;
	private String m_name;
	private String m_phonenum;
	private Date m_birthday;
	private String m_photo;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(String m_id, String m_password, String m_name, String m_phonenum, Date m_birthday, String m_photo) {
		super();
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_phonenum = m_phonenum;
		this.m_birthday = m_birthday;
		this.m_photo = m_photo;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_phonenum() {
		return m_phonenum;
	}

	public void setM_phonenum(String m_phonenum) {
		this.m_phonenum = m_phonenum;
	}

	public Date getM_birthday() {
		return m_birthday;
	}

	public void setM_birthday(Date m_birthday) {
		this.m_birthday = m_birthday;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}
	
	

}