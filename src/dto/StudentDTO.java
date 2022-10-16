package dto;

public class StudentDTO {
	private int studentNo;
	private String id;
	private String pwd;
	private String name;
	private String birthday;
	private String phone;
	private String email;
	private String address;
	private int disposedate;

	public StudentDTO() {};
	public int getStudentNo() {return studentNo;}
	public String getId() {return id;}
	public String getPwd() {return pwd;}
	public String getName() {return name;}
	public String getBirthday() {return birthday;}
	public String getPhone() {return phone;}
	public String getEmail() {return email;}
	public String getAddress() {return address;}
	public int getDisposeDate() {return disposedate;}
	public void setStudentNo(int studentNo) {this.studentNo = studentNo;}
	public void setId(String id) {this.id = id;}
	public void setPwd(String pwd) {this.pwd = pwd;}
	public void setName(String name) {this.name = name;}
	public void setBirthday(String birthday) {this.birthday = birthday;}
	public void setPhone(String phone) {this.phone = phone;}
	public void setEmail(String email) {this.email = email;}
	public void setAddress(String address) {this.address = address;}
	public void setDisposeDate(int disposedate) {this.disposedate = disposedate;}
}
