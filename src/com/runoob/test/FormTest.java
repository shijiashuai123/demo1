package com.runoob.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormTest
 */
@WebServlet("/FormTest")
public class FormTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String str ="";
//        String title = "使用 POST 方法读取表单数据";
        // 处理中文
        try {
        	String username = new String(request.getParameter("username").getBytes("ISO8859-1"),"UTF-8");
        	String password = new String(request.getParameter("password").getBytes("ISO8859-1"),"UTF-8");
        	System.out.println("Mima" + password);
//        String docType = "<!DOCTYPE html> \n";
	        if (username.length() == 0) {
	        	response.getWriter().write("请输入用户名");
	        	out.println("请输入用户名");
	        	response.sendRedirect("/demo1/hello.html");
	        	return;
	        }
	        if ("".equals(password)) {
	        	str ="{\"ret\":\"-1\",\"msg\":\"请输入密码\"}";
	        	response.getWriter().write(str);
	        	return;
	        }
	        if ( password.equals("123456")) {
	        	str ="{\"ret\":\"0\",\"msg\":\"登录成功\"}";
	        	response.getWriter().write(str);
	        } else {
	        	str ="{\"ret\":\"-1\",\"msg\":\"密码错误\"}";
	        	response.getWriter().write(str);
	        }
        } catch (Exception e){
        	System.out.println("出现异常："+ e);  //打印异常信息
        	e.printStackTrace();            //打印完整的异常信息'
        	str ="{\"ret\":\"-1\",\"msg\":\"参数不能为空\"}";
        	response.getWriter().write(str);
        }
//        out.println(docType +
//            "<html>\n" +
//            "<head><title>" + title + "</title></head>\n" +
//            "<body bgcolor=\"#f0f0f0\">\n" +
//            "<h1 align=\"center\">" + title + "</h1>\n" +
//            "<ul>\n" +
//            "  <li><b>站点名</b>："
//            + name + "\n" +
//            "  <li><b>网址</b>："
//            + request.getParameter("url") + "\n" +
//            "</ul>\n" +
//            "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
