package staffManage.dao.employ;

import java.util.List;

import staffManage.exception.DAOException;
import staffManage.pojo.Employ;

public interface IEmployDAO {
	
	/**
	 * 分页查询基本信息
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws DAOException
	 */
	List<Employ> findEmploy(Integer page, Integer pageSize) throws DAOException;
	
	/**
	 * 查询总页数
	 * @param pageSize
	 * @return
	 * @throws DAOException 
	 */
	int findTotalPage(Integer pageSize) throws DAOException;
	
	/**
	 * 添加员工信息
	 * @param employ
	 * @throws DAOException 
	 */
	String addEmploy(Employ employ) throws DAOException;
	
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 * @throws DAOException 
	 */
	Employ findEmployById(Integer id) throws DAOException;
	
	/**
	 * 更新职工信息
	 * @param employ
	 * @throws DAOException 
	 */
	void updateEmploy(Employ employ) throws DAOException;
	
	/**
	 * 修改工资
	 * @param id
	 * @param salary
	 * @throws DAOException
	 */
	void updateSalary(Integer id, Double salary) throws DAOException;
	
	/**
	 * 通过id删除员工
	 * @param id
	 * @throws DAOException
	 */
	void deleteEmployById(Integer id) throws DAOException;
	
	/**
	 * 根据id查询姓名
	 * @param id
	 * @return
	 * @throws DAOException 
	 */
	String findNameById(Integer id) throws DAOException;
	
}
