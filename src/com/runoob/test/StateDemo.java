package com.runoob.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StateDemo
 */
@WebServlet("/StateDemo")
public class StateDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static final String url = "www.baidu.com";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateDemo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void sendRedirect(Object response, String url) {
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		{
			// 设置错误代码和原因
//			response.sendError(401, "没有这个路径");
//			response.sendRedirect(301, url);
//			response.setStatus(202);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
