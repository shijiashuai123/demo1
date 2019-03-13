package com.SessionDemo.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Enumeration;
/**
 * Servlet implementation class DelSession
 */
@WebServlet("/DelSession")
public class DelSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		// 是否有参数
		if (request.getParameter("SessionKey") == null) {
			 out.print("请输入要删除的Sessionkey");
			 return;
	    }
		
		 String str = new String(request.getParameter("SessionKey").getBytes("ISO8859-1"), "UTF-8");
		 // 判断是否删除全部
		 if (str.equals("clearAll")) {
			 session.invalidate();
			 out.print("已清除全部session");
			 return;
		 }
		 // 删除单个session
		 Enumeration Sessions = session.getAttributeNames();  // 枚举类型
		 if (session.getAttribute(str) == null) {
			 out.print("<h2 style='color: red;'>清除全部session输入clearAll</h2>" + "<br/>");
			 out.print("没有" + str + "!请输入正确的sessionKey" + "<br/>" + "当前session中有：");
			 while(Sessions.hasMoreElements()){
				 String paramName = (String)Sessions.nextElement();
				 System.out.println(paramName);
				 out.print( paramName + "；");
			 }
			 return;
		 }
		 
		 session.removeAttribute(str);
		 out.print("删除" + str + "成功");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
