package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeRecController implements  controller{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeNoticeRecController");
		
		request.getRequestDispatcher("noticeRec.jsp").forward(request, response);
		
	}
}
