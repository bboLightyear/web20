package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeDetailController implements controller{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeDetailController");
		
		String seq=request.getParameter("c");
		
		
		NoticeDao dao=new NoticeDao();
		Notice n=dao.getDetail(seq);
		
		System.out.println(seq);
		
//		foward
		request.setAttribute("n", n);
		request.getRequestDispatcher("noticeDetaile.jsp").forward(request, response);
	}
}
