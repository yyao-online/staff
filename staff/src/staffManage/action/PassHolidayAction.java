package staffManage.action;

import staffManage.dao.DAOFactory;
import staffManage.dao.holiday.IHolidayDAO;
import staffManage.exception.DAOException;

public class PassHolidayAction {
	private Integer id;

	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public String execute(){
		IHolidayDAO dao = DAOFactory.getHolidayDAO();
		try {
			dao.passHoliday(id);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
