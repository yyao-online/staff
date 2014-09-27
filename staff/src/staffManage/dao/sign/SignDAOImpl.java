package staffManage.dao.sign;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import staffManage.exception.DAOException;
import staffManage.pojo.AttendanceCount;
import staffManage.util.DBUtil;

public class SignDAOImpl implements ISignDAO {

	@Override
	public boolean checkSign(Integer empid) throws DAOException {
		Date now = new Date(System.currentTimeMillis());
		String sql = "select date from sign where empid=? order by date desc limit 0,1";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			stat=conn.prepareStatement(sql);
			stat.setInt(1, empid);
			rs = stat.executeQuery();
			if(rs.next()){
				Date date=rs.getDate(1);
				Date date_temp = Date.valueOf(date.toString());
				Date now_temp = Date.valueOf(now.toString());
				if(date_temp.equals(now_temp)){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		} finally {
			DBUtil.close(conn, stat, rs);
		}
		return false;
	}

	@Override
	public void sign(Integer empid) throws DAOException {
		Date now = new Date(System.currentTimeMillis());
		String sql = "insert into sign values(?,?)";
		Connection conn = null;
		PreparedStatement stat = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			stat.setInt(1, empid);
			stat.setDate(2, now);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据插入异常", e);
		} finally {
			DBUtil.close(conn, stat);
		}
	}

	@Override
	public List<AttendanceCount> findAttendance(Integer page, Integer pageSize) throws DAOException {
		String sql = "select empid,count(*) count from sign group by empid limit ?,?";
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			stat = conn.prepareStatement(sql);
			Integer before = (page-1)*pageSize;
			stat.setInt(1, before);
			stat.setInt(2, pageSize);
			rs = stat.executeQuery();
			List<AttendanceCount> list = new ArrayList<AttendanceCount>();
			while(rs.next()){
				list.add(createAttendanceCount(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("数据库查询异常", e);
		} finally {
			DBUtil.close(conn, stat, rs);
		}
	}

	private AttendanceCount createAttendanceCount(ResultSet rs) throws SQLException {
		AttendanceCount attendanceCount = new AttendanceCount();
		attendanceCount.setId(rs.getInt("empid"));
		attendanceCount.setCount(rs.getInt("count"));
		return attendanceCount;
	}

	@Override
	public int findtotalPage(Integer pageSize) throws DAOException {
		String sql = "select count(*) from sign group by empid";
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

}
