package oop20230801.crud;

public class DtoClass {        //"책"의 한면(page)
	
	private int pageNum;
	private int age;
	private String name;
	private String birth;
	private String address;
	
	public DtoClass() {}
	
	
	public DtoClass(int pageNum, int age, String name, String birth, String address) {
		super();
		this.pageNum = pageNum;
		this.age = age;
		this.name = name;
		this.birth = birth;
		this.address = address;
    }

	
	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "DtoClass [pageNum="+pageNum+", age="+age+", name=" +name+", birth=" +birth+", address="+address+"]";
	}
}
