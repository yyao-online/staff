package staffManage.action;

import staffManage.dao.DAOFactory;
import staffManage.dao.employ.IEmployDAO;
import staffManage.exception.DAOException;
import staffManage.pojo.Employ;

public class EditPersonalAction {
	private Employ employ;

	public Employ getEmploy() {return employ;}
	public void setEmploy(Employ employ) {this.employ = employ;}
	
	public String execute(){
		IEmployDAO dao = DAOFactory.getEmployDAO();
		try {
			dao.updateEmploy(employ);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
