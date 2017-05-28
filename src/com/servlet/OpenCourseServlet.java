package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CourseDao;
import com.javabeans.TeacherCourse;

/**
 * Servlet implementation class OpenCourseServlet
 */
@WebServlet("/OpenCourseServlet")
public class OpenCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenCourseServlet() {
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
		TeacherCourse tc=new TeacherCourse();
		tc.setTeacherAccount(Long.parseLong(request.getParameter("teacherAccount")));
		tc.setCourseNumber(request.getParameter("courseNumber"));
		tc.setCourseTimeId(request.getParameter("courseTimeId"));
		tc.setClassRoomId(Integer.parseInt(request.getParameter("classRoomId")));
		tc.setCapacity(Integer.parseInt(request.getParameter("capacity")));
		tc.setSurplus(Integer.parseInt(request.getParameter("capacity")));
		
		CourseDao dao=new CourseDao();
		String result=dao.openCourse(tc);
		out.print(result);
	
	}

}
