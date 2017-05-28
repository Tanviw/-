package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
@WebFilter(filterName="TeacherFilter",urlPatterns="/adminteacher.jsp")
public class TeacherFilter implements Filter {

	private FilterConfig config;
    /**
     * Default constructor. 
     */
    public TeacherFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		config=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			request.setCharacterEncoding("UTF-8");
			HttpServletRequest hrequest=(HttpServletRequest) request;
			HttpSession session=hrequest.getSession(true);
//			String requestPath=hrequest.getServletPath();
//			if(requestPath.contains(".css")||requestPath.contains(".js")||requestPath.contains("images")){
//				chain.doFilter(request, response);
//			}else if(session.getAttribute("username")==null
//					&&!requestPath.endsWith("index.jsp")
//					&&!requestPath.endsWith("LoginServlet")
//					&&!requestPath.contains("IdentifyServlet")){
//				request.getRequestDispatcher("index.jsp").forward(request, response);
//			}else{
//				chain.doFilter(request, response);
//			}
		if(session.getAttribute("teacList")!=null){
			
			chain.doFilter(request, response);
		}else{
			request.getRequestDispatcher("ShowTeacListServlet").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		config=fConfig;
	}

}
