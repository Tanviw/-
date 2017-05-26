package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.StudentDao;
import com.javabeans.Student;

/**
 * Servlet implementation class ShowStuListServlet
 */
@WebServlet("/ShowStuListServlet")
public class ShowStuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStuListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao dao=new StudentDao();
        ArrayList<Student> stuList=dao.findAllStudent();
        ArrayList<String> academyList=dao.getAcademy();
        request.getSession().setAttribute("stuList", stuList);//返回学生信息列表
        request.getSession().setAttribute("academyList", academyList);//返回学院信息列表
        response.sendRedirect("admin.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
