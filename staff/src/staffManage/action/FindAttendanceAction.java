package staffManage.action;
import java.util.ArrayList;
import java.util.List;

import staffManage.dao.DAOFactory;
import staffManage.dao.sign.ISignDAO;
import staffManage.exception.DAOException;
import staffManage.pojo.Admin;
import staffManage.pojo.AttendanceCount;

public class FindAttendanceAction extends BaseAction {
	private Integer page = 1;
	private Integer pageSize = 10;
	private Integer totalPage;
	private Admin admin;
	private List<AttendanceCount> attendanceCounts = new ArrayList<AttendanceCount>();
	
	public Integer getPage() {return page;}
	public void setPage(Integer page) {this.page = page;}
	public Integer getPageSize() {return pageSize;}
	public void setPageSize(Integer pageSize) {this.pageSize = pageSize;}
	public Integer getTotalPage() {return totalPage;}
	public void setTotalPage(Integer totalPage) {this.totalPage = totalPage;}
	public Admin getAdmin() {return admin;}
	public void setAdmin(Admin admin) {this.admin = admin;}
	public List<AttendanceCount> getAttendanceCounts() {return attendanceCounts;}
	public void setAttendanceCounts(List<AttendanceCount> attendanceCounts) {this.attendanceCounts = attendanceCounts;}

	public String execute(){
		ISignDAO dao = DAOFactory.getSignDAO();
		try {
			attendanceCounts = dao.findAttendance(page, pageSize);
			totalPage = dao.findtotalPage(pageSize);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
