package staffManage.action;

import staffManage.dao.DAOFactory;
import staffManage.dao.employ.IEmployDAO;
import staffManage.exception.DAOException;

public class DeleteEmployAction {
	private Integer id;

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String execute(){
		IEmployDAO dao = DAOFactory.getEmployDAO();
		try {
			dao.deleteEmployById(id);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
