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
// 判断用户是否有token登录
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
		System.out.println("token值" + token);
		response.setContentType("text/html;charset=UTF-8"); // 返回字符类型（解决乱码）//设置返回内容类型
		PrintWriter out = response.getWriter();
		// 获取请求头中的信息
		if (token == null) {
			String str = "请输入token进行验证";
			out.print(str);
			return;
		}
		if("123".equals(token)){ // 设置token为123
	        // 把请求传回过滤链
	        chain.doFilter(request, response);
	    }else{
	        //在页面输出响应信息
	        out.print("<b style='color: red;'>token不正确，请求被拦截，不能访问web资源</b>");
	        System.out.println("token值不正确，请求被拦截，不能访问web资源");
	    }
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		userName = fConfig.getInitParameter("user"); 
        // 输出初始化参数
	}

}
