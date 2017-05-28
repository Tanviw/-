package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CourseDao;


/**
 * Servlet implementation class GetCoursetimeServlet
 */
@WebServlet("/GetCoursetimeServlet")
public class GetCoursetimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCoursetimeServlet() {
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
//    	int classRoomId=0;
    	int classHour=Integer.parseInt(request.getParameter("classHour"));
//    	if(request.getParameter("classRoomId")!=null){
//    		classRoomId=Integer.parseInt(request.getParameter("classRoomId"));
//    	}
    	
    	long teacherAccount=Long.parseLong(request.getParameter("teacherAccount"));
    	CourseDao dao=new CourseDao();
    	String result=dao.getAvaCoursetime(teacherAccount, classHour);
    	
    	out.print(result);
	}

}
