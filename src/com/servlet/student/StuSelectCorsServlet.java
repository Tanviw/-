package com.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CourseDao;
import com.javabeans.TeacherCourse;

/**
 * Servlet implementation class StuSelectCorsServlet
 */
@WebServlet("/StuSelectCorsServlet")
public class StuSelectCorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuSelectCorsServlet() {
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
		long stuAccount=Long.parseLong(request.getParameter("stuAccount"));
		String []teacCorsIdArr=request.getParameterValues("teacCorsIdArr");//这里一开始总是出错是因为前台ajax传递的是数组形式应该加traditional: true
		
		String str="";
		int i;
		for(i=0;i<teacCorsIdArr.length-1;i++){
			str+=teacCorsIdArr[i]+",";
		}
		str+=teacCorsIdArr[i];//把教师课程ID组合成可以存放在SQL 的IN中的形式 ;
		String val="";
		for(i=0;i<teacCorsIdArr.length-1;i++){
			val+="("+stuAccount+","+teacCorsIdArr[i]+"),";
		}
		val+="("+stuAccount+","+teacCorsIdArr[i]+")";//把学生账号和教师课程ID组合成INSERT语句中value后面的形式
		CourseDao dao=new CourseDao();
		String result=dao.stuSelectCors(stuAccount, str, val);
		if(result=="ok"){
			ArrayList<TeacherCourse> avacourseList=dao.findAllAvaCourse();
	        ArrayList<TeacherCourse> selectedCorsList=dao.findSelectedCourse(stuAccount);
	        request.getSession().setAttribute("avacourseList", avacourseList);//返回可选课程信息列表
	        request.getSession().setAttribute("selectedCorsList", selectedCorsList);//返回学生已选课程信息列表
		}
		out.print(result);
	
	}

}
