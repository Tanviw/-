package com.teacher;

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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class PostScoreServlet
 */
@WebServlet("/PostScoreServlet")
public class PostScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostScoreServlet() {
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
		
		String ds = request.getParameter("ds");
		int  teacherCourseId = Integer.parseInt(request.getParameter("teacherCourseId"));
		TeacherDao dao=new TeacherDao();
		String courseNumber=dao.getCourseNumber(teacherCourseId);
		JSONArray json=JSONArray.fromObject(ds);
		JSONObject jsonOne;
		long stuAcocunt;
		int stuGrade;
		double gpa;
		String sqlValue="";
		//将json数组转换成SQL insert value的形式
		for(int i=0;i<json.size();i++){
	          jsonOne = json.getJSONObject(i); 
	          stuAcocunt=Long.parseLong((String) jsonOne.get("name"));
	          stuGrade=Integer.parseInt((String) jsonOne.get("value"));
	          if(stuGrade>=95){
	        	  gpa=4.5;
	          }else if(stuGrade>=90){
	        	  gpa=4.0;
	          }else if(stuGrade>=85){
	        	  gpa=3.5;
	          }else if(stuGrade>=80){
	        	  gpa=3.0;
	          }else if(stuGrade>=75){
	        	  gpa=2.5;
	          }else if(stuGrade>=70){
	        	  gpa=2.0;
	          }else if(stuGrade>=65){
	        	  gpa=1.5;
	          }else if(stuGrade>=60){
	        	  gpa=1.0;
	          }else{
	        	  gpa=0;
	          }
	          sqlValue+="('"+courseNumber+"',"+stuAcocunt+","+stuGrade+","+gpa+"),";
	 }
		sqlValue=sqlValue.substring(0,sqlValue.length()-1);
		String result=dao.inputGrade(sqlValue,teacherCourseId);
		if(result=="ok"){
			long teacherAccount= Long.parseLong((String) request.getSession().getAttribute("account"));
			
	        ArrayList<TeacherCourse> gradeNotInputCors=dao.gradeNotInputCors(teacherAccount);
	        request.getSession().setAttribute("gradeNotInputCors", gradeNotInputCors);//返回教师已开设课程信息列表
		}
		out.print(result);
		
		
	
	}

}
