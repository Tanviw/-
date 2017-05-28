package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ClassroomDao;


/**
 * Servlet implementation class DelClassroomServlet
 */
@WebServlet("/DelClassroomServlet")
public class DelClassroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelClassroomServlet() {
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
    	String []classroomArr=request.getParameterValues("classroomArr");
    	String str="";
    	int i;
    	for(i=0;i<classroomArr.length-1;i++){
    		str+="'"+classroomArr[i]+"',";
    	}
    	str+="'"+classroomArr[i]+"'";
    	ClassroomDao dao=new ClassroomDao();
    	String result=dao.delClassroom(str);
    	if(result!="error"){
    		 ArrayList<String> classRoomList=dao.findAllClassroom();
    	     request.getSession().setAttribute("classRoomList", classRoomList);
        }
    	out.print(result);
	}

}
