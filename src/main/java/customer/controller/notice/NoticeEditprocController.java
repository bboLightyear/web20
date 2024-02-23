package customer.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.controller;
import customer.dao.NoticeDao;
import customer.vo.Notice;

public class NoticeEditprocController implements  controller{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeEditProcController");
		
		
		request.setCharacterEncoding("UTF-8");
		String seq = request.getParameter("c");
		String title = request.getParameter("title");
		String content = request.getParameter("content");


			Notice n=new Notice();
			n.setSeq(seq);
			n.setTitle(title);
			n.setContent(content);
			
			NoticeDao dao=new NoticeDao();
			dao.update(n);

		request.setAttribute("n", n);
		/*
		 * request.getRequestDispatcher("noticeDetaile.jsp").forward(request, response);
		 */
		request.getRequestDispatcher("noticeDetaile.do?c="+seq).forward(request, response);
		
//		response.sendRedirect("notice.do?c="+seq);

		
		
		
		
		//		String seq= request.getParameter("c");
//
//		NoticeDao dao=new NoticeDao();
//		Notice n = dao.getDetail(seq);
//
//		
//		request.setAttribute("n", n);
//		request.getRequestDispatcher("noticeEdit.jsp").forward(request, response);
	}
}
