package com.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.StudentDao;
import com.javabeans.Student;

/**
 * Servlet implementation class EditStuServlet
 */
@WebServlet("/EditStuServlet")
public class EditStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStuServlet() {
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
    	StudentDao dao=new StudentDao();
    	Student student=new Student();
    	student.setStuAccount(Long.parseLong(request.getParameter("stuAccount")));
    	student.setStuName(request.getParameter("stuName"));
    	student.setPassword(request.getParameter("password"));
    	student.setSex(request.getParameter("sex"));
    	student.setGrade(request.getParameter("grade"));
    	student.setAcademy(request.getParameter("academy"));
    	student.setMajor(request.getParameter("major"));
        String result=dao.editStudent(student);
        if(result!="error"){
            ArrayList<Student> stuList=dao.findAllStudent();
            request.getSession().setAttribute("stuList", stuList);
        }
        out.print(result);
	}

}
