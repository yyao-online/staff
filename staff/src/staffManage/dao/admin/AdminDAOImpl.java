package staffManage.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import staffManage.exception.DAOException;
import staffManage.pojo.Admin;
import staffManage.util.DBUtil;

public class AdminDAOImpl implements IAdminDAO {

	@Override
	public Admin findAdminByLoginNameAndPassword(String loginName,
			String password) throws DAOException {
		String sql="select * from admin where loginname=? and password=?";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, loginName);
			stat.setString(2, password);
			rs = stat.executeQuery();
			if(rs.next()){
				return createAdmin(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		} finally {
			DBUtil.close(conn, stat, rs);
		}
		return null;
	}
	
	private Admin createAdmin(ResultSet rs) throws SQLException {
		Admin admin = new Admin();
		admin.setId(rs.getInt("id"));
		admin.setLoginName(rs.getString("loginname"));
		admin.setPassword(rs.getString("password"));
		admin.setEmpid(rs.getInt("empid"));
		admin.setPerm(rs.getInt("perm"));
		return admin;
	}

	@Override
	public void EditPassword(Integer id, String password) throws DAOException {
		String sql = "update admin set password=? where id=?";
		Connection conn = null;
		PreparedStatement stat = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, password);
			stat.setInt(2, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库更新异常", e);
		}
	}

}
