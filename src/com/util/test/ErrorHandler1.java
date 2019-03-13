package com.util.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import java.util.*;

/**
 * Servlet implementation class ErrorHandler1
 */
//@WebServlet("/ErrorHandler1")
public class ErrorHandler1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorHandler1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		// ���� GET ��������ķ���
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	    {
	        Throwable throwable = (Throwable)
	        request.getAttribute("javax.servlet.error.exception");
	        Integer statusCode = (Integer)
	        request.getAttribute("javax.servlet.error.status_code");
	        String servletName = (String)
	        request.getAttribute("javax.servlet.error.servlet_name");
	        if (servletName == null){
	            servletName = "Unknown";
	        }
	        String requestUri = (String)
	        request.getAttribute("javax.servlet.error.request_uri");
	        if (requestUri == null){
	            requestUri = "Unknown";
	        }
	        // ������Ӧ��������
	        response.setContentType("text/html;charset=UTF-8");
	    
	        PrintWriter out = response.getWriter();
	        String title = "����̳� Error/Exception ��Ϣ";
	       
	        String docType = "<!DOCTYPE html>\n";
	        out.println(docType +
	            "<html>\n" +
	             "<head><title>" + title + "</title></head>\n" +
	             "<body bgcolor=\"#f0f0f0\">\n");
	           out.println("<h1>����</h1>");
	           if (throwable == null && statusCode == null){
	              out.println("<h2>������Ϣ��ʧ</h2>");
	              out.println("�뷵�� <a href=\"" + 
        		  response.encodeURL("http://localhost:8080/demo1/one.html") + 
	                "\">��ҳ</a>��");
	           }else if (statusCode != null) {
	              out.println("������� : " + statusCode);
	           }else{
        	      out.println("<h2>������Ϣ</h2>");
	              out.println("Servlet Name : " + servletName + 
	                              "</br></br>");
	              out.println("�쳣���� : " + 
	                              throwable.getClass( ).getName( ) + 
	                              "</br></br>");
	              out.println("���� URI: " + requestUri + 
	                              "<br><br>");
	              out.println("�쳣��Ϣ: " + 
	                                  throwable.getMessage( ));
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
