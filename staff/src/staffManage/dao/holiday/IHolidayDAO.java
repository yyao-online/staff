package staffManage.dao.holiday;

import java.util.List;

import staffManage.exception.DAOException;
import staffManage.pojo.Holiday;

public interface IHolidayDAO {
	
	void applyHoliday(Holiday holiday) throws DAOException;
	
	List<Holiday> findHolidayUntreated() throws DAOException;
	
	void passHoliday(Integer id) throws DAOException;
	
	void denyHoliday(Integer id) throws DAOException;
	
	Holiday findLastHoliday(Integer empId) throws DAOException;
	
}
