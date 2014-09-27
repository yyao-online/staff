package staffManage.dao.employ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import staffManage.exception.DAOException;
import staffManage.pojo.Employ;
import staffManage.util.DBUtil;

public class EmployDAOImpl implements IEmployDAO {

	@Override
	public List<Employ> findEmploy(Integer page, Integer pageSize) throws DAOException {
		String sql = "select * from employ limit ?,?";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Employ> list = new ArrayList<Employ>();
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			Integer before = (page-1)*pageSize;
			stat.setInt(1, before);
			stat.setInt(2, pageSize);
			rs = stat.executeQuery();
			while(rs.next()){
				Employ employ = createEmploy(rs);
				list.add(employ);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("分页查询失败", e);
		} finally {
			DBUtil.close(conn, stat, rs);
		}
	}

	private Employ createEmploy(ResultSet rs) throws SQLException {
		Employ employ = new Employ();
		employ.setId(rs.getInt("id"));
		employ.setName(rs.getString("name"));
		employ.setPhone(rs.getString("phone"));
		employ.setSex(rs.getString("sex"));
		employ.setAge(rs.getInt("age"));
		employ.setSalary(rs.getDouble("salary"));
		return employ;
	}

	@Override
	public int findTotalPage(Integer pageSize) throws DAOException {
		String sql = "select count(*) from employ";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			if(rs.next()){
				int rows = rs.getInt(1);
				int totalPage = 0;
				if(rows%pageSize==0){
					totalPage = rows/pageSize;
				}else {
					totalPage = rows/pageSize+1;
				}
				return totalPage;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询失败", e);
		} finally {
			DBUtil.close(conn, stat, rs);
		}
		return 0;
	}

	@Override
	public String addEmploy(Employ employ) throws DAOException {
		String sql1 = "insert into employ (name,phone,sex,age,salary) values(?,?,?,?,?)";
		String sql2 = "insert into admin (loginname,password,empid)values(?,?,?)";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			stat = conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
			stat.setObject(1, employ.getName());
			stat.setObject(2, employ.getPhone());
			stat.setObject(3, employ.getSex());
			stat.setObject(4, employ.getAge());
			stat.setObject(5, employ.getSalary());
			stat.execute();
			rs = stat.getGeneratedKeys();
			if(rs.next()){
				int id = rs.getInt(1);
				String loginName = "aaa"+id;
				stat = conn.prepareStatement(sql2);
				stat.setString(1, loginName);
				stat.setString(2, "welcome123");
				stat.setInt(3, id);
				stat.executeUpdate();
				conn.commit();
				return loginName;
			}else {
				conn.rollback();
				return "";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DAOException("插入失败", e);
		}finally{
			DBUtil.close(conn, stat, rs);
		}
	}
	
	@Override
	public Employ findEmployById(Integer id) throws DAOException {
		String sql = "select * from employ where id=?";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if(rs.next()){
				Employ employ = createEmploy(rs);
				return employ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("查询异常", e);
		} finally {
			DBUtil.close(conn, stat, rs);
		}
		return null;
	}

	@Override
	public void updateEmploy(Employ employ) throws DAOException {
		String sql = "update employ set name=?,phone=?,sex=?,age=? where id=?";
		Connection conn = null;
		PreparedStatement stat = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setString(1, employ.getName());
			stat.setString(2, employ.getPhone());
			stat.setString(3, employ.getSex());
			stat.setInt(4, employ.getAge());
			stat.setInt(5, employ.getId());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("更新异常", e);
		} finally {
			DBUtil.close(conn, stat);
		}
	}

	@Override
	public void updateSalary(Integer id, Double salary) throws DAOException {
		String sql = "update employ set salary=? where id=?";
		Connection conn = null;
		PreparedStatement stat = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setDouble(1, salary);
			stat.setInt(2, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("更新异常", e);
		} finally {
			DBUtil.close(conn, stat);
		}
	}

	@Override
	public void deleteEmployById(Integer id) throws DAOException {
		String sql = "delete from employ where id=?";
		Connection conn = null;
		PreparedStatement stat = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("删除异常", e);
		}finally {
			DBUtil.close(conn, stat);
		}
	}

	@Override
	public String findNameById(Integer id) throws DAOException {
		String sql = "select name from employ where id=?";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if(rs.next()){
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("查询异常", e);
		} finally {
			DBUtil.close(conn, stat, rs);
		}
		return null;
	}

}
