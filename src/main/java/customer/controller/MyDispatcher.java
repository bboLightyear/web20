package customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.controller.notice.NoticeDelProcController;
import customer.controller.notice.NoticeDetailController;
import customer.controller.notice.NoticeEditController;
import customer.controller.notice.NoticeEditprocController;
import customer.controller.notice.NoticeRecController;
import customer.controller.notice.NoticeRecController;
import customer.controller.notice.NoticeRecProcController;

public class MyDispatcher extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("signnnnnnnnn");
		
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		System.out.println("uri : " +uri);
		System.out.println("conPath : " +conPath);
		System.out.println("com : " +com);
		
//		NoticeDetailController controller1=new NoticeDetailController();
//		NoticeDetailController controller2=new NoticeDetailController();
		
		controller controller =null;
		
		try {
			//주소로 분기
			if (com.equals("/custom/noticeDetaile.do")) {
				controller=new NoticeDetailController();
//				controller1.execute(request, response);
			}else if (com.equals("/custom/noticeEdit.do")) {
				controller=new NoticeEditController();
//				controller2.execute(request, response);
			}else if (com.equals("/custom/noticeEditPro.do")) {
				controller=new NoticeEditprocController();
//				controller2.execute(request, response);
			}else if (com.equals("/custom/noticeReg.do")) {
				controller=new NoticeRecController();
//				controller2.execute(request, response);
			}else if (com.equals("/custom/noticeRegProc.do")) {
				controller=new NoticeRecProcController();
//				controller2.execute(request, response);
			}else if (com.equals("/custom/noticeDelPro.do")) {
				controller=new NoticeDelProcController();
//				controller2.execute(request, response);
			}
			controller.execute(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
