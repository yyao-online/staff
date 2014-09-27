package staffManage.pojo;

public class Admin {
	private Integer id;
	private String loginName;
	private String password;
	private Integer empid;
	private Integer perm;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public Integer getPerm() {
		return perm;
	}
	public void setPerm(Integer perm) {
		this.perm = perm;
	}
	
	
}
