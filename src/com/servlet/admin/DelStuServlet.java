package com.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.StudentDao;
import com.javabeans.Student;

/**
 * Servlet implementation class DelStuServlet
 */
@WebServlet("/DelStuServlet")
public class DelStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelStuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out=response.getWriter();
    	Long stuAccount=Long.parseLong(request.getParameter("stuAccount"));
    	StudentDao dao=new StudentDao();
    	String result=dao.delStudent(stuAccount);
    	if(result!="error"){
            ArrayList<Student> stuList=dao.findAllStudent();
            request.getSession().setAttribute("stuList", stuList);
        }
    	out.print(result);
	}

}
