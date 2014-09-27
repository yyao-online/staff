package staffManage.action;

import staffManage.dao.DAOFactory;
import staffManage.dao.employ.IEmployDAO;
import staffManage.exception.DAOException;

public class FindNameAction {
	private Integer empid;
	private String name;

	public Integer getEmpid() {return empid;}
	public void setEmpid(Integer empid) {this.empid = empid;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String execute(){
		IEmployDAO dao = DAOFactory.getEmployDAO();
		try {
			name = dao.findNameById(empid);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
