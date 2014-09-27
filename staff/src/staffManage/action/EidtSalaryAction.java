package staffManage.action;

import staffManage.dao.DAOFactory;
import staffManage.dao.employ.IEmployDAO;
import staffManage.exception.DAOException;
import staffManage.pojo.Admin;

public class EidtSalaryAction extends BaseAction {
	private Integer id;
	private Double salary;
	private Admin admin;

	public Admin getAdmin() {return admin;}
	public void setAdmin(Admin admin) {this.admin = admin;}
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	public Double getSalary() {return salary;}
	public void setSalary(Double salary) {this.salary = salary;}

	public String execute(){
		admin = (Admin) session.get("admin");
		IEmployDAO dao = DAOFactory.getEmployDAO();
		try {
			dao.updateSalary(id, salary);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
