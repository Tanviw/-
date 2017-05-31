package com.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.TeacherDao;

/**
 * Servlet implementation class PostAnswerServlet
 */
@WebServlet("/PostAnswerServlet")
public class PostAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostAnswerServlet() {
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
		
		String answerContent = request.getParameter("answerContent");
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		TeacherDao dao=new TeacherDao();
		String result=dao.postAnswer(answerContent, questionId);
		long teacherAccount= Long.parseLong((String) request.getSession().getAttribute("account"));
		int count=dao.getUnsolvedQuesNum(teacherAccount);
		request.getSession().setAttribute("unsolvedQuesNum", count);
		out.print(result);
		
	
	}

}
