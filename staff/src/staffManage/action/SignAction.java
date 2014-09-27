package staffManage.action;

import staffManage.dao.DAOFactory;
import staffManage.dao.sign.ISignDAO;
import staffManage.exception.DAOException;

public class SignAction {
	private Integer empid;

	public Integer getEmpid() {return empid;}
	public void setEmpid(Integer empid) {this.empid = empid;}

	public String execute(){
		ISignDAO dao = DAOFactory.getSignDAO();
		try {
			dao.sign(empid);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
