package staffManage.action;

import staffManage.dao.DAOFactory;
import staffManage.dao.admin.IAdminDAO;
import staffManage.exception.DAOException;
import staffManage.pojo.Admin;

public class LoginAction extends BaseAction {
	private String loginName;
	private String password;
	private Admin admin;

	public String getLoginName(){return loginName;}
	public void setLoginName(String loginName) {this.loginName = loginName;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public Admin getAdmin() {return admin;}
	public void setAdmin(Admin admin) {this.admin = admin;}
	
	public String execute(){
		IAdminDAO dao = DAOFactory.getAdminDAO();
		try {
			admin = dao.findAdminByLoginNameAndPassword(loginName, password);
			if(admin!=null){
				session.put("admin", admin);
				if(admin.getPerm()==2){
					return "admin";
				}else{
					return "common";
				}
			}else{
				return "fail";
			}
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
