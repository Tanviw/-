package com.servlet.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IdentifySevlet
 */
@WebServlet("/IdentifyServlet")
public class IdentifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdentifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("account");
		String username=request.getParameter("username");
		String identity=request.getParameter("identity");
		request.getSession().setAttribute("account",account);
		request.getSession().setAttribute("username",username);

		if(identity.equals("admin")){
			request.getSession().setAttribute("identity","管理员");
			response.sendRedirect("ShowStuListServlet");
		}else if(identity.equals("student")){
			request.getSession().setAttribute("identity","同学");
			response.sendRedirect("student.jsp?username="+username);
		}else if(identity.equals("teacher")){
			request.getSession().setAttribute("identity","老师");
			response.sendRedirect("teacher.jsp?username="+username);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
