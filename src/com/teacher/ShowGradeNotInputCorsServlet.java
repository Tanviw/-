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
 * Servlet implementation class ShowGradeNotInputCorsServlet
 */
@WebServlet("/ShowGradeNotInputCorsServlet")
public class ShowGradeNotInputCorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGradeNotInputCorsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("gradeNotInputCors")==null){
			
			long teacherAccount= Long.parseLong((String) request.getSession().getAttribute("account"));
			TeacherDao dao=new TeacherDao();
	        ArrayList<TeacherCourse> gradeNotInputCors=dao.gradeNotInputCors(teacherAccount);
	        request.getSession().setAttribute("gradeNotInputCors", gradeNotInputCors);//返回教师已开设课程信息列表
		}
		response.sendRedirect("teacgradeinput.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
