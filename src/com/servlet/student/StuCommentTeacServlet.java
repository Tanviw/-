package com.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.TeacherDao;
import com.javabeans.TeacherCourse;

/**
 * Servlet implementation class StuCommentTeacServlet
 */
@WebServlet("/StuCommentTeacServlet")
public class StuCommentTeacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuCommentTeacServlet() {
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

		int teacherCourseId=Integer.parseInt(request.getParameter("teacherCourseId"));
		double teacherGrade=Double.parseDouble(request.getParameter("teacherGrade"));
		String  commentContent=request.getParameter("commentContent");
		TeacherDao dao=new TeacherDao();
		String result=dao.stuCommentTeac(teacherCourseId, teacherGrade, commentContent);
		if(result!="error"){
		}
		out.print(result);
	
	
	}

}
