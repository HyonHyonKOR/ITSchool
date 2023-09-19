package com.hyon.sep193.member;

public class Member {
	private String m_id;
	private String m_pw;
	private String m_name;
	private int m_phonenum;
	private int m_birthYear;
	private int m_birthMonth;
	private int m_birthDay;
	private String m_photo;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(String m_id, String m_pw) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
	}

	public Member(String m_id, String m_pw, String m_name, int m_phonenum, int m_birthYear, int m_birthMonth,
			int m_birthDay, String m_photo) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_phonenum = m_phonenum;
		this.m_birthYear = m_birthYear;
		this.m_birthMonth = m_birthMonth;
		this.m_birthDay = m_birthDay;
		this.m_photo = m_photo;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getM_phonenum() {
		return m_phonenum;
	}

	public void setM_phonenum(int m_phonenum) {
		this.m_phonenum = m_phonenum;
	}

	public int getM_birthYear() {
		return m_birthYear;
	}

	public void setM_birthYear(int m_birthYear) {
		this.m_birthYear = m_birthYear;
	}

	public int getM_birthMonth() {
		return m_birthMonth;
	}

	public void setM_birthMonth(int m_birthMonth) {
		this.m_birthMonth = m_birthMonth;
	}

	public int getM_birthDay() {
		return m_birthDay;
	}

	public void setM_birthDay(int m_birthDay) {
		this.m_birthDay = m_birthDay;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	

}