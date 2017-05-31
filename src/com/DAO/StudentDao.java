package com.DAO;

import com.javabeans.Student;
import com.mysql.jdbc.ResultSetMetaData;

import net.sf.json.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class StudentDao extends BaseDao {
	
	//用户登录验证，账号密码正确则返回用户名，否则返回"0"
	public String validate(long account,String password,String identity){
		String sql="";
		if(identity.equals("admin")){
			sql="SELECT * FROM admin WHERE adminId=? AND password=?;";
		}else if(identity.equals("student")){
			sql="SELECT * FROM student WHERE stuAccount=? AND password=?;";
		}else if(identity.equals("teacher")){
			sql="SELECT * FROM teacher WHERE teacherAccount=? AND password=?;";
		}
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1,account);
			pstmt.setString(2,password);
			rst=pstmt.executeQuery();
			if(rst.next()){
				return rst.getString(4);
			}else{
				return "0";
			}

		} catch (Exception e) {

			e.printStackTrace();
			return "0";
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
		
	}
	//获取专业学院信息
	public ArrayList<String> getAcademy(){
		
		String sql="SELECT academy FROM major GROUP BY academy;";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rst=pstmt.executeQuery();
			ArrayList<String> academyList=new ArrayList<String>();
			while(rst.next()){
				academyList.add(rst.getString(1));
			}
			return academyList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
	}
		
		
	
	//根据学院获取专业信息
	public ArrayList<String> getMajor(String academy){
		String sql="SELECT major FROM major WHERE academy=?;";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,academy);
			rst=pstmt.executeQuery();
			ArrayList<String> majorList=new ArrayList<String>();
			while(rst.next()){
				majorList.add(rst.getString(1));
			}
			return majorList;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
	}

	//查询所有学生信息，返回学生对象集合
	public ArrayList<Student> findAllStudent(){

		String sql="SELECT stuAccount,idCard,password,stuName,sex,grade,academy,major FROM student INNER JOIN major " +
				"on student.majorId=major.majorId;";
		ArrayList<Student> stuList=new ArrayList<Student>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rst=pstmt.executeQuery();
			Student stu=null;
			while(rst.next()){   
				stu=new Student();
				stu.setStuAccount(rst.getLong("stuAccount"));
				stu.setIdCard(rst.getString("idCard"));
				stu.setPassword(rst.getString("password"));
				stu.setStuName(rst.getString("stuName"));
				stu.setSex(rst.getString("sex"));
				stu.setGrade(rst.getString("grade"));
				stu.setAcademy(rst.getString("academy"));
				stu.setMajor(rst.getString("major"));
				stuList.add(stu);
			}
			return stuList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}

	
	}
	//添加学生
	public String addStudent(Student student){
		
		String sql1="SELECT majorId FROM major WHERE academy=? AND major=?";
		String sql2="INSERT INTO student VALUES(?,?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		int col=0;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql1);
			pstmt.setString(1,student.getAcademy());
			pstmt.setString(2,student.getMajor());
			rst=pstmt.executeQuery();
			if(rst.next()){
				pstmt=conn.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
				pstmt.setString(1,null);
				pstmt.setString(2,student.getIdCard());
				pstmt.setString(3,student.getPassword());
				pstmt.setString(4,student.getStuName());
				pstmt.setString(5,student.getSex());
				pstmt.setString(6,student.getGrade());
				pstmt.setInt(7,rst.getInt(1));
				col=pstmt.executeUpdate();
				long autoIncKeyFromApi = -1;    
		        rst = pstmt.getGeneratedKeys();    //返回插入的学生主键，学生账号
		        if (rst.next()) {    
		          autoIncKeyFromApi = rst.getLong(1);    
		          return ""+autoIncKeyFromApi;    
		        }    
		            
				
				return "error";
			}else{
				return "error";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
	}
	//根据关键字搜索学生信息,返回json数组字符串
	public String searchStudent(String message){
		String sql="SELECT stuAccount,stuName,sex,grade,academy,major  FROM student INNER JOIN major "
				 +"on student.majorId=major.majorId WHERE stuAccount LIKE '%"+message+"%' OR stuName LIKE '%"+message+"%';";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rst=pstmt.executeQuery();
			JSONArray array=new JSONArray();
			java.sql.ResultSetMetaData metaData=rst.getMetaData();
			int columnCount =metaData.getColumnCount();
			while (rst.next()) {  
		        JSONObject jsonObj = new JSONObject();  
		         
		        // 遍历每一列  
		        for (int i = 1; i <= columnCount; i++) {  
		            String columnName =metaData.getColumnLabel(i);  
		            String value = rst.getString(columnName);  
						jsonObj.put(columnName, value);
		        }   
		        array.add(jsonObj);   
		    }  
		    
			
			return array.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
	}
	//删除学生
	public String delStudent(Long stuAccount){
		String sql="DELETE FROM student WHERE stuAccount=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1,stuAccount);
			int col=pstmt.executeUpdate();
			if(col!=0){
				return "ok";
			}else{
				return "error";
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
	}
	
	//修改学生
	public String editStudent(Student student){
		String sql1="SELECT majorId FROM major WHERE academy=? AND major=?";
		String sql2="UPDATE student SET password=?,stuName=?,sex=?,grade=?,majorId=? WHERE stuAccount=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		int col=0;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql1);
			pstmt.setString(1,student.getAcademy());
			pstmt.setString(2,student.getMajor());
			rst=pstmt.executeQuery();
			if(rst.next()){
				pstmt=conn.prepareStatement(sql2);
				pstmt.setString(1,student.getPassword());
				pstmt.setString(2,student.getStuName());
				pstmt.setString(3,student.getSex());
				pstmt.setString(4,student.getGrade());
				pstmt.setInt(5,rst.getInt(1));
				pstmt.setLong(6,student.getStuAccount());
				col=pstmt.executeUpdate();
				  
		        if (col!=0) {    
		          return "ok";    
		        }    
				return "error";
			}else{
				return "error";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
		
		
	}
	//学生查询成绩和平均绩点
	public String checkGrade(long stuAccount){
		String sql="SELECT course.courseNumber,course.courseName ,"
				+ "stuGrade,credit,courseGPA FROM stugrade INNER JOIN course"
				+ " ON stugrade.courseNumber=course.courseNumber WHERE stuAccount=?;";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		double sum=0.0;
		int creditsum=0;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1,stuAccount);
			rst=pstmt.executeQuery();
			JSONArray array=new JSONArray();
			java.sql.ResultSetMetaData metaData=rst.getMetaData();
			int columnCount =metaData.getColumnCount();
			 JSONObject jsonObj ;
			while (rst.next()) {  
				creditsum+=rst.getInt("credit");//总学分
				sum+=rst.getInt("credit")*rst.getDouble("courseGPA");//学分*绩点之和
		        jsonObj = new JSONObject();  
		         
		        // 遍历每一列  
		        for (int i = 1; i <= columnCount; i++) {  
		            String columnName =metaData.getColumnLabel(i);  
		            String value = rst.getString(columnName);  
						jsonObj.put(columnName, value);
		        }   
		        array.add(jsonObj);   
		    }  
			if(creditsum==0){
				return "暂未有成绩！";
			}else{
				
				double gpa=sum/(creditsum*1.0);
				jsonObj = new JSONObject(); 
				jsonObj.put("gpa",gpa);
				array.add(jsonObj);
				return array.toString();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
		
	
	}
	//学生提问
	public String stuAskQuestion(int teacherCourseId ,long stuAccount,String question){
		String sql1="INSERT INTO coursequestion VALUES(null,?,?,?,null,now(),null,0,0);";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		int col1=0;
		
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1,teacherCourseId);
			pstmt.setLong(2,stuAccount);
			pstmt.setString(3,question);
			col1=pstmt.executeUpdate();
			if(col1!=0){
		        	  return "ok";
		        } 
		        return "error";
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
		
	}
	//获取学生提问未回答的问题
	public String getQuesNotAns(long stuAccount,int teacherCourseId){
		String sql="SELECT questionTime,questionContent FROM coursequestion "
				+ "WHERE teacherCourseId=? AND stuAccount=? AND isAnswered=0";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,teacherCourseId);
			pstmt.setLong(2,stuAccount);
			rst=pstmt.executeQuery();
			JSONArray array=new JSONArray();
			java.sql.ResultSetMetaData metaData=rst.getMetaData();
			int columnCount =metaData.getColumnCount();
			while (rst.next()) {  
		        JSONObject jsonObj = new JSONObject();  
		         
		        // 遍历每一列  
		        for (int i = 1; i <= columnCount; i++) {  
		            String columnName =metaData.getColumnLabel(i);  
		            String value = rst.getString(columnName);  
						jsonObj.put(columnName, value);
		        }   
		        array.add(jsonObj);   
		    }  
			return array.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}  
			
		
	}
	
	//根据教师课程获取学生提问已回答的问题
	public String getQuesAnswered(long stuAccount,int teacherCourseId){
		String sql="SELECT questionTime,questionContent ,questionAnswer ,"
				+ "answerTime FROM coursequestion "
				+ "WHERE teacherCourseId=? AND stuAccount=? AND isAnswered=1";
		String sql2="UPDATE coursequestion SET isChecked=1 WHERE teacherCourseId=? AND stuAccount=?;";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,teacherCourseId);
			pstmt.setLong(2,stuAccount);
			rst=pstmt.executeQuery();
			JSONArray array=new JSONArray();
			java.sql.ResultSetMetaData metaData=rst.getMetaData();
			int columnCount =metaData.getColumnCount();
			int col=0;
			while (rst.next()) {  
		        JSONObject jsonObj = new JSONObject();  
		         
		        // 遍历每一列  
		        for (int i = 1; i <= columnCount; i++) {  
		            String columnName =metaData.getColumnLabel(i);  
		            String value = rst.getString(columnName);  
						jsonObj.put(columnName, value);
		        }   
		        array.add(jsonObj);   
		    }  
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1,teacherCourseId);
			pstmt.setLong(2,stuAccount);
			col=pstmt.executeUpdate();
			
				JSONObject jsonObj1 = new JSONObject(); 
				jsonObj1.put("count", col);//将当前改变问题已被查看状态的记录数返回
				array.add(jsonObj1); 
			
			return array.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			return "error";
		}finally{
			if(rst!=null){
				try {
					rst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}  
			
		
	}
	//显示待查看回答数量
	public int getUncheckedAnsNum(long stuAccount){
		String sql="SELECT COUNT(*) FROM coursequestion WHERE stuAccount=? AND"
				+ " isAnswered=1 AND isChecked=0; ";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1,stuAccount);
			rst=pstmt.executeQuery();
			if(rst.next()){
				return rst.getInt(1);
			}
			return 0;
		}catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				
		}
		
		
	}
	
	
}
