package com.teacher;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.TeacherDao;
import com.javabeans.TeacherCourse;

/**
 * Servlet implementation class ShowTeacCorsServlet
 */
@WebServlet("/ShowTeacCorsServlet")
public class ShowTeacCorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTeacCorsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(request.getSession().getAttribute("teacCors")==null){
			
		
		long teacherAccount= Long.parseLong((String) request.getSession().getAttribute("account"));
		TeacherDao dao=new TeacherDao();
        ArrayList<TeacherCourse> teacCors=dao.findCourseOffered(teacherAccount);
        request.getSession().setAttribute("teacCors", teacCors);//返回教师已开设课程信息列表
		}
		response.sendRedirect("teachercheckcomm.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
