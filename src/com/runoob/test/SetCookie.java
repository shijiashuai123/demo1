package com.runoob.test;

import java.net.URLEncoder;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookie
 */
@WebServlet("/SetCookie")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 为名字和姓氏创建 Cookie
		// 设置响应内容类型
		try {
			
		} catch (Exception e){
        	System.out.println("出现异常："+ e);  //打印异常信息
        	e.printStackTrace();      //打印完整的异常信息'
        }
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if (request.getParameter("name") == null) {
			out.println("请设置name");
			System.out.println("进来了");
			return;
		}
		if (request.getParameter("url") == null) {
			out.println("请设置url");
			return;
		}
//        Cookie name = new Cookie("name", URLEncoder.encode(request.getParameter("name"), "UTF-8")); // 中文转码
        Cookie name = new Cookie("name", new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8"));
        Cookie url = new Cookie("url", request.getParameter("url"));
        
        System.out.println("这是name" + URLEncoder.encode(request.getParameter("name"), "UTF-8"));
        System.out.println(request.getParameter("name"));
        // 为两个 Cookie 设置过期日期为 24 小时后
        name.setMaxAge(60*60*24);
        url.setMaxAge(60*60*24); 
        
        // 在响应头中添加两个 Cookie
        response.addCookie( name );
        response.addCookie( url );
        
        String title = "设置 Cookie 实例";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>站点名：</b>："
                + request.getParameter("name") + "\n</li>" +
                "  <li><b>站点 URL：</b>："
                + request.getParameter("url") + "\n</li>" +
                "</ul>\n" +
                "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
