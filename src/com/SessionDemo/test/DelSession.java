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
		// �Ƿ��в���
		if (request.getParameter("SessionKey") == null) {
			 out.print("������Ҫɾ����Sessionkey");
			 return;
	    }
		
		 String str = new String(request.getParameter("SessionKey").getBytes("ISO8859-1"), "UTF-8");
		 // �ж��Ƿ�ɾ��ȫ��
		 if (str.equals("clearAll")) {
			 session.invalidate();
			 out.print("�����ȫ��session");
			 return;
		 }
		 // ɾ������session
		 Enumeration Sessions = session.getAttributeNames();  // ö������
		 if (session.getAttribute(str) == null) {
			 out.print("<h2 style='color: red;'>���ȫ��session����clearAll</h2>" + "<br/>");
			 out.print("û��" + str + "!��������ȷ��sessionKey" + "<br/>" + "��ǰsession���У�");
			 while(Sessions.hasMoreElements()){
				 String paramName = (String)Sessions.nextElement();
				 System.out.println(paramName);
				 out.print( paramName + "��");
			 }
			 return;
		 }
		 
		 session.removeAttribute(str);
		 out.print("ɾ��" + str + "�ɹ�");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
