package staffManage.dao.admin;

import staffManage.exception.DAOException;
import staffManage.pojo.Admin;

public interface IAdminDAO {
	
	/**
	 * 登录
	 * 通过用户名和密码查询出Admin对象
	 * @param loginName
	 * @param password
	 * @return
	 * @throws DAOException
	 */
	Admin findAdminByLoginNameAndPassword(String loginName, String password) throws DAOException;
	
	/**
	 * 修改密码
	 * @param id
	 * @param password
	 * @throws DAOException
	 */
	void EditPassword(Integer id, String password) throws DAOException;
	
}
