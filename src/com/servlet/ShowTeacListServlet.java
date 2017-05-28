package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.TeacherDao;

import com.javabeans.Teacher;

/**
 * Servlet implementation class ShowTeacListServlet
 */
@WebServlet("/ShowTeacListServlet")
public class ShowTeacListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTeacListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherDao dao=new TeacherDao();
        ArrayList<Teacher> teacList=dao.findAllTeacher();
        ArrayList<String> academyList=dao.getAcademy();
        request.getSession().setAttribute("teacList", teacList);//返回教师信息列表
        request.getSession().setAttribute("academyList", academyList);//返回学院信息列表
        response.sendRedirect("adminteacher.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
