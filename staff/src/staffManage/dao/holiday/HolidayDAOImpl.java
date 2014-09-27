package staffManage.dao.holiday;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import staffManage.exception.DAOException;
import staffManage.pojo.Holiday;
import staffManage.util.DBUtil;

public class HolidayDAOImpl implements IHolidayDAO {

	@Override
	public void applyHoliday(Holiday holiday) throws DAOException {
		String sql = "insert into holiday (empid,datefrom,dateto,reason) values (?,?,?,?)";
		Connection conn = null;
		PreparedStatement stat = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, holiday.getEmpId());
			stat.setDate(2, holiday.getDateFrom());
			stat.setDate(3, holiday.getDateTo());
			stat.setString(4, holiday.getReason());
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库插入异常", e);
		} finally {
			DBUtil.close(conn, stat);
		}
	}

	@Override
	public List<Holiday> findHolidayUntreated() throws DAOException {
		String sql = "select * from holiday where state=0";
		Connection conn = null;
		PreparedStatement stat= null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		List<Holiday> list = new ArrayList<Holiday>();
		try {
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while(rs.next()){
				list.add(createHoliday(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		} finally {
			DBUtil.close(conn, stat, rs);
		}
	}

	private Holiday createHoliday(ResultSet rs) throws SQLException {
		Holiday holiday = new Holiday();
		holiday.setId(rs.getInt("id"));
		holiday.setEmpId(rs.getInt("empid"));
		holiday.setDateFrom(rs.getDate("datefrom"));
		holiday.setDateTo(rs.getDate("dateto"));
		holiday.setReason(rs.getString("reason"));
		holiday.setState(rs.getInt("state"));
		return holiday;
	}

	@Override
	public void passHoliday(Integer id) throws DAOException {
		String sql = "update holiday set state=1 where id=?";
		Connection conn = null;
		PreparedStatement stat = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库更新异常", e);
		} finally {
			DBUtil.close(conn, stat);
		}
	}

	@Override
	public void denyHoliday(Integer id) throws DAOException {
		String sql = "update holiday set state=2 where id=?";
		Connection conn = null;
		PreparedStatement stat = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库更新异常", e);
		} finally {
			DBUtil.close(conn, stat);
		}
	}

	@Override
	public Holiday findLastHoliday(Integer empId) throws DAOException {
		String sql = "select * from holiday where empid=? order by id desc limit 0,1";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, empId);
			rs = stat.executeQuery();
			if(rs.next()){
				return createHoliday(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		}
		return null;
	}

}
