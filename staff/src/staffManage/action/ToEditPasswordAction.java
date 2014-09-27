package staffManage.action;

import staffManage.pojo.Admin;

public class ToEditPasswordAction extends BaseAction {
	private Admin admin;

	public Admin getAdmin() {return admin;}
	public void setAdmin(Admin admin) {this.admin = admin;}
	
	public String execute(){
		admin = (Admin) session.get("admin");
		return "success";
	}
	
}
