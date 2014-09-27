package staffManage.action;

import java.util.ArrayList;
import java.util.List;

import staffManage.dao.DAOFactory;
import staffManage.dao.employ.IEmployDAO;
import staffManage.exception.DAOException;
import staffManage.pojo.Admin;
import staffManage.pojo.Employ;

public class FindSalaryAction extends BaseAction {
	private Integer page = 1;
	private Integer pageSize = 10;
	private List<Employ> list = new ArrayList<Employ>();
	private Integer totalPage;
	private Admin admin;

	public Admin getAdmin() {return admin;}
	public void setAdmin(Admin admin) {this.admin = admin;}
	public Integer getPage() {return page;}
	public void setPage(Integer page) {this.page = page;}
	public Integer getPageSize() {return pageSize;}
	public void setPageSize(Integer pageSize) {this.pageSize = pageSize;}
	public List<Employ> getList() {return list;}
	public void setList(List<Employ> list) {this.list = list;}
	public Integer getTotalPage() {return totalPage;}
	public void setTotalPage(Integer totalPage) {this.totalPage = totalPage;}

	public String execute(){
		admin = (Admin) session.get("admin");
		IEmployDAO dao = DAOFactory.getEmployDAO();
		try {
			list = dao.findEmploy(page, pageSize);
			totalPage = dao.findTotalPage(pageSize);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
