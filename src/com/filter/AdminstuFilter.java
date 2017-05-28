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
 * Servlet Filter implementation class AdminstuFilter
 */
@WebFilter(filterName="AdminstuFilter",urlPatterns="/admin.jsp")
public class AdminstuFilter implements Filter {

	private FilterConfig config;
    /**
     * Default constructor. 
     */
    public AdminstuFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		config=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		HttpServletRequest hrequest=(HttpServletRequest) request;
		HttpSession session=hrequest.getSession(true);

		if(session.getAttribute("stuList")!=null){
			chain.doFilter(request, response);
		}else{
			request.getRequestDispatcher("ShowStuListServlet").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		config=fConfig;
	}

}
