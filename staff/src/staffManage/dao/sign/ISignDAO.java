package staffManage.dao.sign;

import java.util.List;

import staffManage.exception.DAOException;
import staffManage.pojo.AttendanceCount;

public interface ISignDAO {

	/**
	 * 签到检查
	 * @param empid
	 * @return
	 * @throws DAOException 
	 */
	boolean checkSign(Integer empid) throws DAOException;
	
	void sign(Integer empid) throws DAOException;
	
	List<AttendanceCount> findAttendance(Integer page, Integer pageSize) throws DAOException;
	
	int findtotalPage(Integer pageSize) throws DAOException;
	
}
