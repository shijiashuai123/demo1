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
        // ��ȡ�������ص� Cookie ������
         cookies = request.getCookies();
         
         // ������Ӧ��������
         response.setContentType("text/html;charset=UTF-8");
    
         PrintWriter out = response.getWriter();
         String name = "name"; // ����Ҫɾ����cookie
         String title = "Delete Cookie Example";
         String docType = "<!DOCTYPE html>\n";
         out.println(docType +
                   "<html>\n" +
                   "<head><title>" + title + "</title></head>\n" +
                   "<body bgcolor=\"#f0f0f0\">\n" );
          if( cookies != null ){
            out.println("<h2>ɾ��cookie</h2>");
            for (int i = 0; i < cookies.length; i++){
               cookie = cookies[i];
               System.out.println(cookies[i].getName());
               if((cookie.getName()).compareTo(name) == 0 ){  // �ж�ָ����cookie��ȥɾ��
                    cookie.setMaxAge(0);  // ������������Ϊ0
                    response.addCookie(cookie); // Ȼ�����������֮ǰ��cookie
                    out.print("��ɾ���� cookie��" + cookie.getName( ) + "<br/>");
                    System.out.println("���������");
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
