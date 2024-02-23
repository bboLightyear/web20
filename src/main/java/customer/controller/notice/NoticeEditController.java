package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeEditController implements  controller{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeEditController");
		
		String seq= request.getParameter("c");

		NoticeDao dao=new NoticeDao();
		Notice n = dao.getDetail(seq);

		
		request.setAttribute("n", n);
		request.getRequestDispatcher("noticeEdit.jsp").forward(request, response);
	}
}
