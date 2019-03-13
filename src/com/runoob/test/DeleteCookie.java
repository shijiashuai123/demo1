package com.runoob.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCookie
 */
@WebServlet("/DeleteCookie")
public class DeleteCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Cookie cookie = null;
         Cookie[] cookies = null;
        // 获取与该域相关的 Cookie 的数组
         cookies = request.getCookies();
         
         // 设置响应内容类型
         response.setContentType("text/html;charset=UTF-8");
    
         PrintWriter out = response.getWriter();
         String name = "name"; // 声明要删除的cookie
         String title = "Delete Cookie Example";
         String docType = "<!DOCTYPE html>\n";
         out.println(docType +
                   "<html>\n" +
                   "<head><title>" + title + "</title></head>\n" +
                   "<body bgcolor=\"#f0f0f0\">\n" );
          if( cookies != null ){
            out.println("<h2>删除cookie</h2>");
            for (int i = 0; i < cookies.length; i++){
               cookie = cookies[i];
               System.out.println(cookies[i].getName());
               if((cookie.getName()).compareTo(name) == 0 ){  // 判断指定的cookie名去删除
                    cookie.setMaxAge(0);  // 过期日期设置为0
                    response.addCookie(cookie); // 然后添加清除清除之前的cookie
                    out.print("已删除的 cookie：" + cookie.getName( ) + "<br/>");
                    System.out.println("有这个名字");
               }
            }
         }else{
             out.println(
               "<h2 class=\"tutheader\">No Cookie founds</h2>");
         }
         out.println("</body>");
         out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
