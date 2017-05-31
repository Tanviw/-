package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.coyote.http11.filters.VoidInputFilter;

import com.javabeans.Student;
import com.javabeans.Teacher;
import com.javabeans.TeacherCourse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TeacherDao  extends BaseDao{

	
	
	//获取专业学院信息
		public ArrayList<String> getAcademy(){
			
			String sql="SELECT academy FROM researchFields GROUP BY academy;";
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
			
			
		
		//根据学院获取研究方向信息,返回json字符串
		public String getResearch(String academy){
			String sql="SELECT researchFields FROM researchFields WHERE academy=?;";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,academy);
				rst=pstmt.executeQuery();
				JSONArray array=new JSONArray();
				java.sql.ResultSetMetaData metaData=rst.getMetaData();
			
				while (rst.next()) {  
			        JSONObject jsonObj = new JSONObject();  
		         
		            String columnName =metaData.getColumnLabel(1);  
		            String value = rst.getString(columnName);  
						jsonObj.put(columnName, value);
			         
			        array.add(jsonObj);   
			    }  
				return array.toString();
				
			}catch (Exception e) {
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

		//查询所有教师信息，返回教师对象集合
		public ArrayList<Teacher> findAllTeacher(){

			String sql="SELECT teacherAccount,idCard,password,teacherName,sex,technicalTitle,academy,researchFields FROM teacher INNER JOIN researchfields " +
					"on teacher.researchFieldsId=researchfields.researchFieldsId;";
			ArrayList<Teacher> teacList=new ArrayList<Teacher>();
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				rst=pstmt.executeQuery();
				Teacher teac=null;
				while(rst.next()){   
					teac=new Teacher();
					teac.setTeacherAccount(rst.getLong("teacherAccount"));
					teac.setIdCard(rst.getString("idCard"));
					teac.setPassword(rst.getString("password"));
					teac.setTeacherName(rst.getString("teacherName"));
					teac.setSex(rst.getString("sex"));
					teac.setTechnicalTitle(rst.getString("technicalTitle"));
					teac.setAcademy(rst.getString("academy"));
					teac.setResearchFields(rst.getString("researchFields"));
					teacList.add(teac);
				}
				return teacList;
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
		
		//开设课程时查询所有可开课教师
		public String findTeacher(){
			
			String sql="SELECT teacherAccount,teacherName FROM teacher;";
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
		         
			        for (int i = 1; i <= columnCount; i++) {  
			            String columnName =metaData.getColumnLabel(i);  
			            String value = rst.getString(columnName);  
							jsonObj.put(columnName, value);
			        }   
		            
			         
			        array.add(jsonObj);   
			    }  
				return array.toString();
				
			}catch (Exception e) {
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
		
		//添加教师
		public String addTeacher(Teacher teacher){
			
			String sql1="SELECT researchFieldsId FROM researchfields WHERE academy=? AND researchFields=?";
			String sql2="INSERT INTO teacher VALUES(?,?,?,?,?,?,?)";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			int col=0;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql1);
				pstmt.setString(1,teacher.getAcademy());
				pstmt.setString(2,teacher.getResearchFields());
				rst=pstmt.executeQuery();
				if(rst.next()){
					pstmt=conn.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
					pstmt.setString(1,null);
					pstmt.setString(2,teacher.getIdCard());
					pstmt.setString(3,teacher.getPassword());
					pstmt.setString(4,teacher.getTeacherName());
					pstmt.setString(5,teacher.getSex());
					pstmt.setString(6,teacher.getTechnicalTitle());
					pstmt.setInt(7,rst.getInt(1));
					col=pstmt.executeUpdate();
					long autoIncKeyFromApi = -1;    
			        rst = pstmt.getGeneratedKeys();    
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
		
		//根据关键字搜索教师信息,返回json数组字符串
		public String searchTeacher(String message){
			String sql="SELECT 	teacherAccount,teacherName,sex,technicalTitle,academy,researchFields  FROM teacher INNER JOIN researchfields "
					 +"on teacher.researchFieldsId=researchfields.researchFieldsId WHERE teacherAccount LIKE '%"+message+"%' OR teacherName LIKE '%"+message+"%';";
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
		
		//修改教师
		public String editTeacher(Teacher teacher){
			String sql1="SELECT researchFieldsId FROM researchfields WHERE academy=? AND researchFields=?";
			String sql2="UPDATE teacher SET password=?,teacherName=?,sex=?,	technicalTitle=?,researchFieldsId=? WHERE teacherAccount=?";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			int col=0;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql1);
				pstmt.setString(1,teacher.getAcademy());
				pstmt.setString(2,teacher.getResearchFields());
				rst=pstmt.executeQuery();
				if(rst.next()){
					pstmt=conn.prepareStatement(sql2);
					pstmt.setString(1,teacher.getPassword());
					pstmt.setString(2,teacher.getTeacherName());
					pstmt.setString(3,teacher.getSex());
					pstmt.setString(4,teacher.getTechnicalTitle());
					pstmt.setInt(5,rst.getInt(1));
					pstmt.setLong(6,teacher.getTeacherAccount());
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
		
		
		
		//删除教师
		public String delTeacher(Long teacherAccount){
			String sql="DELETE FROM teacher WHERE teacherAccount=?";
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1,teacherAccount);
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
		//学生评价教师
		public String stuCommentTeac(int teacherCourseId,double teacherGrade,String  commentContent){
			String sql="INSERT INTO coursecomment VALUES(null,?,?,?)";
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			int col=0;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,teacherCourseId);
				pstmt.setString(2,commentContent);
				pstmt.setDouble(3,teacherGrade);
				col=pstmt.executeUpdate();
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
		//根据教师账号查询教师开设的课程
		public ArrayList<TeacherCourse> findCourseOffered(long teacherAccount){
			String sql="SELECT teachercourse.teacherCourseId,course.courseName,coursetime.courseTime FROM teachercourse INNER JOIN course "
					+"ON teachercourse.courseNumber=course.courseNumber "
					+"INNER JOIN coursetime ON teachercourse.courseTimeId=coursetime.courseTimeId "
										+"WHERE teacherAccount=? ;";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1,teacherAccount);
				rst=pstmt.executeQuery();
				ArrayList<TeacherCourse> teacCourseList=new ArrayList<TeacherCourse>();
				TeacherCourse course=null;
				while(rst.next()){   
					course=new TeacherCourse();
					
					course.setTeacherCourseId(rst.getInt(1));
					course.setCourseName(rst.getString(2));
					course.setCourseTime(rst.getString(3));
				
			    	teacCourseList.add(course);
				}
				return teacCourseList;
			}catch (SQLException e) {
					e.printStackTrace();
					return null;
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
		//根据教师课程id查看课程评价,返回json数组
		public String checkComment(int teacherCourseId){
			String sql="SELECT  teacherGrade,commentContent FROM coursecomment WHERE teacherCourseId=?";
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			
			try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,teacherCourseId);
			rst=pstmt.executeQuery();
			JSONArray array=new JSONArray();
			java.sql.ResultSetMetaData metaData=rst.getMetaData();
		
			while (rst.next()) {  
				JSONObject jsonObj = new JSONObject();  
				jsonObj.put("teacherGrade",rst.getDouble(1));
				jsonObj.put("commentContent",rst.getString(2));
				array.add(jsonObj); 
		       
		            
		    }  
			return array.toString();
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
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
		//根据教师账号查询教师已开设并且成绩尚未录入的课程
				public ArrayList<TeacherCourse> gradeNotInputCors(long teacherAccount){
					String sql="SELECT teachercourse.teacherCourseId,course.courseName,coursetime.courseTime FROM teachercourse INNER JOIN course "
							+"ON teachercourse.courseNumber=course.courseNumber "
							+"INNER JOIN coursetime ON teachercourse.courseTimeId=coursetime.courseTimeId "
												+"WHERE teacherAccount=?  AND gradeinputed=0;";
					Connection conn=null;
					PreparedStatement pstmt=null;
					ResultSet rst=null;
					
					try {
						conn = dataSource.getConnection();
						pstmt=conn.prepareStatement(sql);
						pstmt.setLong(1,teacherAccount);
						rst=pstmt.executeQuery();
						ArrayList<TeacherCourse> teacCourseList=new ArrayList<TeacherCourse>();
						TeacherCourse course=null;
						while(rst.next()){   
							course=new TeacherCourse();
							
							course.setTeacherCourseId(rst.getInt(1));
							course.setCourseName(rst.getString(2));
							course.setCourseTime(rst.getString(3));
						
					    	teacCourseList.add(course);
						}
						return teacCourseList;
					}catch (SQLException e) {
							e.printStackTrace();
							return null;
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
	//根据教师课程id返回选了该课的所有学生名单
		public String getStuList(int teacherCourseId ){
			String sql="SELECT stuAccount,stuName,grade,major FROM student INNER JOIN major "
						+ " ON  student.majorId=major.majorId WHERE stuAccount IN "
						+"(SELECT stuAccount FROM stucourse WHERE teacherCourseId =?);";
		
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,teacherCourseId);
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
				
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
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
		//根据教师课程ID返回课程代码
		public String  getCourseNumber(int teacherCourseId){
			String sql="SELECT courseNumber FROM teachercourse WHERE teacherCourseId =?";
		

			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,teacherCourseId);
				rst=pstmt.executeQuery();
				if(rst.next()){
					return rst.getString(1);
				}else{
					return null;
				}
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
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
		//录入课程成绩
		public String inputGrade(String sqlValue,int teacherCourseId){
			String sql1="INSERT INTO stuGrade VALUES "+sqlValue+";";
			String sql2="UPDATE teachercourse SET gradeinputed=1 WHERE teacherCourseId=?;";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			int col1=0;
			int col2=0;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql1);
				
				col1=pstmt.executeUpdate();
				if(col1!=0){
					pstmt=conn.prepareStatement(sql2);
					pstmt.setInt(1,teacherCourseId);
					col2=pstmt.executeUpdate();
					if(col2!=0){
						
						return "ok";
					}
					return "error";
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
		//根据教师课程ID查询所有未回答的问题
		public String  getTQuesNotAns(int teacherCourseId){
			String sql="SELECT questionId,student.stuAccount,stuName,questionTime,questionContent "
					+ "FROM coursequestion INNER JOIN student ON "
					+ " coursequestion.stuAccount=student.stuAccount WHERE teacherCourseId=? AND isAnswered=0;";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,teacherCourseId);
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
		//根据教师课程ID查询所有已回答的问题
		public String  getTQuesAnswer(int teacherCourseId){
			String sql="SELECT student.stuAccount,stuName,questionTime,questionContent "
					+ ",questionAnswer ,answerTime FROM coursequestion INNER JOIN student ON "
					+ " coursequestion.stuAccount=student.stuAccount "
					+ "WHERE teacherCourseId=? AND isAnswered=1";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,teacherCourseId);
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
		
		//教师回答问题
		public String postAnswer(String answerContent,int questionId){
			String sql="UPDATE coursequestion SET questionAnswer=? ,answerTime=now(),"
					+ "  isAnswered=1 WHERE  questionId=?;";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			int col=0;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,answerContent);
				pstmt.setInt(2,questionId);
				col=pstmt.executeUpdate();
				if(col!=0){
					return "ok";
				}
				return "error";
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
		//显示教师待回答的问题数量
		public int getUnsolvedQuesNum(long teacherAccount){
			String sql="SELECT COUNT(*) FROM coursequestion WHERE isAnswered=0 AND "
					+ "teacherCourseId IN (SELECT teacherCourseId FROM"
					+ " teachercourse WHERE teacherAccount=?);";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1,teacherAccount);
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
