package customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception;
		
	
}
