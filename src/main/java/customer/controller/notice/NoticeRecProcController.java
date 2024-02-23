package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeRecProcController implements  controller{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeNoticeRecProcController");
		
		request.setCharacterEncoding("UTF-8");
		String title=request.getParameter("title");
		String content=request.getParameter("content");

		//Notice 객체 생성

		Notice n=new Notice();
		n.setTitle(title);//title 주입
		n.setContent(content);//content 주입

		//NoticeDao 객체 생성
		NoticeDao dao=new NoticeDao();
		dao.write(n);


		response.sendRedirect("notice.jsp");
		
	}
}
