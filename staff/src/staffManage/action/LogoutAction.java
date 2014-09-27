package staffManage.action;

public class LogoutAction extends BaseAction {
	public String execute(){
		session.remove("admin");
		return "success";
	}
}
