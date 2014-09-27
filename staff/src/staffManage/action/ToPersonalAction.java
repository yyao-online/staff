package staffManage.action;

import staffManage.dao.DAOFactory;
import staffManage.dao.employ.IEmployDAO;
import staffManage.dao.holiday.IHolidayDAO;
import staffManage.exception.DAOException;
import staffManage.pojo.Admin;
import staffManage.pojo.Employ;
import staffManage.pojo.Holiday;

public class ToPersonalAction extends BaseAction {
	
	private Admin admin;
	private Employ employ;
	private Holiday holiday;

	public Admin getAdmin() {return admin;}
	public void setAdmin(Admin admin) {this.admin = admin;}
	public Employ getEmploy() {return employ;}
	public void setEmploy(Employ employ) {this.employ = employ;}
	public Holiday getHoliday() {return holiday;}
	public void setHoliday(Holiday holiday) {this.holiday = holiday;}

	public String execute(){
		admin = (Admin) session.get("admin");
		IEmployDAO employDAO = DAOFactory.getEmployDAO();
		IHolidayDAO holidayDAO = DAOFactory.getHolidayDAO();
		try {
			employ = employDAO.findEmployById(admin.getEmpid());
			holiday = holidayDAO.findLastHoliday(admin.getEmpid());
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
