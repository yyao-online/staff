package staffManage.action;
import staffManage.dao.DAOFactory;
import staffManage.dao.admin.IAdminDAO;
import staffManage.exception.DAOException;
import staffManage.pojo.Admin;

public class EditPasswordAction extends BaseAction {
	private String password1;
	private String password2;
	private String password3;
	private String msg;
	
	public String getMsg() {return msg;}
	public void setMsg(String msg) {this.msg = msg;}
	public String getPassword1() {return password1;}
	public void setPassword1(String password1) {this.password1 = password1;}
	public String getPassword2() {return password2;}
	public void setPassword2(String password2) {this.password2 = password2;}
	public String getPassword3() {return password3;}
	public void setPassword3(String password3) {this.password3 = password3;}
	
	public String execute(){
		Admin admin = (Admin) session.get("admin");
		if(admin.getPassword().equals(password1)){
			if(password2.equals(password3)){
				IAdminDAO dao = DAOFactory.getAdminDAO();
				try {
					dao.EditPassword(admin.getId(), password2);
					return "success";
				} catch (DAOException e) {
					e.printStackTrace();
					return "error";
				}
			}else{
				msg="两次输入的密码不一致";
				return "err";
			}
		}else{
			msg="初始密码不正确";
			return "err";
		}
	}
}
