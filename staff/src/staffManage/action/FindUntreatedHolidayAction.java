package staffManage.action;

import java.util.ArrayList;
import java.util.List;

import staffManage.dao.DAOFactory;
import staffManage.dao.holiday.IHolidayDAO;
import staffManage.exception.DAOException;
import staffManage.pojo.Admin;
import staffManage.pojo.Holiday;

public class FindUntreatedHolidayAction extends BaseAction{
	private Admin admin;
	private List<Holiday> holidays = new ArrayList<Holiday>();

	public Admin getAdmin() {return admin;}
	public void setAdmin(Admin admin) {this.admin = admin;}
	public List<Holiday> getHolidays() {return holidays;}
	public void setHolidays(List<Holiday> holidays) {this.holidays = holidays;}

	public String execute(){
		admin = (Admin) session.get("admin");
		IHolidayDAO dao = DAOFactory.getHolidayDAO();
		try {
			holidays = dao.findHolidayUntreated();
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
