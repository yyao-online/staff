package staffManage.action;

import staffManage.dao.DAOFactory;
import staffManage.dao.holiday.IHolidayDAO;
import staffManage.exception.DAOException;
import staffManage.pojo.Admin;
import staffManage.pojo.Holiday;

public class ApplyHolidayAction extends BaseAction {
	private Admin admin;
	private Holiday holiday;

	public Admin getAdmin() {return admin;}
	public void setAdmin(Admin admin) {this.admin = admin;}
	public Holiday getHoliday() {return holiday;}
	public void setHoliday(Holiday holiday) {this.holiday = holiday;}

	public String execute(){
		admin = (Admin) session.get("admin");
		holiday.setEmpId(admin.getEmpid());
		IHolidayDAO dao = DAOFactory.getHolidayDAO();
		try {
			dao.applyHoliday(holiday);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
