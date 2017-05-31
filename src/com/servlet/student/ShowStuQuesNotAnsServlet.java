package com.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CourseDao;
import com.DAO.StudentDao;
import com.javabeans.TeacherCourse;

/**
 * Servlet implementation class ShowStuQuesNotAnsServlet
 */
@WebServlet("/ShowStuQuesNotAnsServlet")
public class ShowStuQuesNotAnsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStuQuesNotAnsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		long stuAccount= Long.parseLong(request.getParameter("stuAccount"));
		int teacherCourseId= Integer.parseInt(request.getParameter("teacherCourseId"));
		StudentDao dao=new StudentDao();
		String result=dao.getQuesNotAns(stuAccount, teacherCourseId);
		
		out.print(result);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
