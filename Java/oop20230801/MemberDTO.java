package oop20230801;

public class MemberDTO {     //MemberVO

	//DTO(Date Transfer Object)
	//VO(Value Object)
	
	//1.field
	private String id;             //ID
	private String passwd;         //PW
	private String uname;           //name
	private String email;          //E-mail
	private String phone;          //PhoneNumber
	private String address;        //address
	private String wdate;          //enrollDate
	
	
	//2.constructor
	public MemberDTO() {}
	
	
	//3.getter/setter
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getuName() {
		return uname;
	}


	public void setuName(String name) {
		this.uname = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getWdate() {
		return wdate;
	}


	public void setWdate(String wdate) {
		this.wdate = wdate;
	}


	
	//4. method : toString()
	@Override
	public String toString() {
		return "MemberDTO [id="+id+",passwd="+passwd+",uname=" +uname+ 
				",email="+email+",phone="+phone+",address="+address+",wdate="+wdate+"]";
	}
	
}







