package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.TeacherDao;
import com.javabeans.Teacher;

/**
 * Servlet implementation class DelTeacServlet
 */
@WebServlet("/DelTeacServlet")
public class DelTeacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelTeacServlet() {
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
    	Long teacherAccount=Long.parseLong(request.getParameter("teacherAccount"));
    	TeacherDao dao=new TeacherDao();
    	String result=dao.delTeacher(teacherAccount);
    	if(result!="error"){
            ArrayList<Teacher> teacList=dao.findAllTeacher();
            request.getSession().setAttribute("teacList", teacList);
        }
    	out.print(result);
	}

}
