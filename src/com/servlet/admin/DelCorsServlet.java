package com.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CourseDao;
import com.javabeans.Course;

/**
 * Servlet implementation class DelCorsServlet
 */
@WebServlet("/DelCorsServlet")
public class DelCorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCorsServlet() {
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
    	String courseNumber=request.getParameter("courseNumber");
    	CourseDao dao=new CourseDao();
    	String result=dao.delCourse(courseNumber);
    	if(result!="error"){
            ArrayList<Course> courseList=dao.findAllCourse();
            request.getSession().setAttribute("courseList", courseList);
        }
    	out.print(result);
	}

}
