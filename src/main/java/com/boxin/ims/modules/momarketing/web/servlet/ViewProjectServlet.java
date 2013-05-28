package com.boxin.ims.modules.momarketing.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewProjectServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
		String path = "/WEB-INF/views/modules/ims/front/viewProject.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
		
	}
}
