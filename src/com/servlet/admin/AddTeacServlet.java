package com.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.TeacherDao;

import com.javabeans.Teacher;

/**
 * Servlet implementation class AddTeacServlet
 */
@WebServlet("/AddTeacServlet")
public class AddTeacServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacServlet() {
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
    	TeacherDao dao=new TeacherDao();
    	Teacher teacher=new Teacher();
    	
    	teacher.setTeacherName(request.getParameter("teacherName"));
    	teacher.setIdCard(request.getParameter("idCard"));
    	teacher.setPassword(request.getParameter("idCard").substring(12));
    	teacher.setSex(request.getParameter("sex"));
    	teacher.setTechnicalTitle(request.getParameter("technicalTitle"));
    	teacher.setAcademy(request.getParameter("academy"));
    	teacher.setResearchFields(request.getParameter("researchFields"));
        String result=dao.addTeacher(teacher);
        if(result!="error"){
            ArrayList<Teacher> teacList=dao.findAllTeacher();
            request.getSession().setAttribute("teacList", teacList);
        }
        out.print(result);
	}
	

}
