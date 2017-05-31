package com.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.StudentDao;

/**
 * Servlet implementation class StuAskQuesServlet
 */
@WebServlet("/StuAskQuesServlet")
public class StuAskQuesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuAskQuesServlet() {
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
		long stuAccount=Long.parseLong(request.getParameter("stuAccount"));
		String  question=request.getParameter("question");
		
		StudentDao dao=new StudentDao();
		String result=dao.stuAskQuestion(teacherCourseId, stuAccount, question);
		if(result!="error"){
			
		}
		out.print(result);
	
	}

}
