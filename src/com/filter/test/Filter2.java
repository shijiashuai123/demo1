package com.filter.test;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.PrintWriter;
/**
 * Servlet Filter implementation class Filter2
 */
// �ж��û��Ƿ���token��¼
@WebFilter("/Filter2")
public class Filter2 implements Filter {

	static String userName = "";
    /**
     * Default constructor. 
     */
    public Filter2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		// TODO Auto-generated method stub
		// place your code here
		String token = request.getParameter("token");
		System.out.println("tokenֵ" + token);
		response.setContentType("text/html;charset=UTF-8"); // �����ַ����ͣ�������룩//���÷�����������
		PrintWriter out = response.getWriter();
		// ��ȡ����ͷ�е���Ϣ
		if (token == null) {
			String str = "������token������֤";
			out.print(str);
			return;
		}
		if("123".equals(token)){ // ����tokenΪ123
	        // �����󴫻ع�����
	        chain.doFilter(request, response);
	    }else{
	        //��ҳ�������Ӧ��Ϣ
	        out.print("<b style='color: red;'>token����ȷ���������أ����ܷ���web��Դ</b>");
	        System.out.println("tokenֵ����ȷ���������أ����ܷ���web��Դ");
	    }
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		userName = fConfig.getInitParameter("user"); 
        // �����ʼ������
	}

}
