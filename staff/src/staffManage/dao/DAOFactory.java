package staffManage.dao;

import staffManage.dao.admin.AdminDAOImpl;
import staffManage.dao.admin.IAdminDAO;
import staffManage.dao.employ.EmployDAOImpl;
import staffManage.dao.employ.IEmployDAO;
import staffManage.dao.holiday.HolidayDAOImpl;
import staffManage.dao.holiday.IHolidayDAO;
import staffManage.dao.sign.ISignDAO;
import staffManage.dao.sign.SignDAOImpl;

public class DAOFactory {
	
	public static IAdminDAO getAdminDAO(){
		return new AdminDAOImpl();
	}
	
	public static IEmployDAO getEmployDAO(){
		return new EmployDAOImpl();
	}
	
	public static ISignDAO getSignDAO(){
		return new SignDAOImpl();
	}
	
	public static IHolidayDAO getHolidayDAO(){
		return new HolidayDAOImpl();
	}
	
}
