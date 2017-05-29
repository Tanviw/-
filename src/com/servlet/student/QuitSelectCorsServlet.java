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
import com.javabeans.TeacherCourse;

/**
 * Servlet implementation class QuitSelectCorsServlet
 */
@WebServlet("/QuitSelectCorsServlet")
public class QuitSelectCorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuitSelectCorsServlet() {
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
		long stuAccount=Long.parseLong(request.getParameter("stuAccount"));
		int teacherCourseId=Integer.parseInt(request.getParameter("teacherCourseId"));
		CourseDao dao=new CourseDao();
		String result=dao.quitSelectedCors(stuAccount, teacherCourseId);
		if(result!="error"){
			ArrayList<TeacherCourse> avacourseList=dao.findAllAvaCourse();
	        ArrayList<TeacherCourse> selectedCorsList=dao.findSelectedCourse(stuAccount);
	        request.getSession().setAttribute("avacourseList", avacourseList);//返回可选课程信息列表
	        request.getSession().setAttribute("selectedCorsList", selectedCorsList);//返回学生已选课程信息列表
		}
		out.print(result);
	
	}

}
