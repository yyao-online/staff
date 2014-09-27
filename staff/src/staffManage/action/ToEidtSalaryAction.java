package staffManage.action;

import staffManage.dao.DAOFactory;
import staffManage.dao.employ.IEmployDAO;
import staffManage.exception.DAOException;
import staffManage.pojo.Admin;
import staffManage.pojo.Employ;

public class ToEidtSalaryAction extends BaseAction {
	private Integer id;
	private Employ employ;
	private Admin admin;
	
	public Admin getAdmin() {return admin;}
	public void setAdmin(Admin admin) {this.admin = admin;}
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	public Employ getEmploy() {return employ;}
	public void setEmploy(Employ employ) {this.employ = employ;}
	
	public String execute(){
		admin = (Admin) session.get("admin");
		IEmployDAO dao = DAOFactory.getEmployDAO();
		try {
			employ = dao.findEmployById(id);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
