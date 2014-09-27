package staffManage.action;

import staffManage.dao.DAOFactory;
import staffManage.dao.sign.ISignDAO;
import staffManage.exception.DAOException;

public class CheckSignAction {
	private Integer empid;
	private Boolean signed;

	public Integer getEmpid() {return empid;}
	public void setEmpid(Integer empid) {this.empid = empid;}
	public Boolean getSigned() {return signed;}
	public void setSigned(Boolean signed) {this.signed = signed;}

	public String execute(){
		ISignDAO dao = DAOFactory.getSignDAO();
		try {
			signed = dao.checkSign(empid);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
