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

	
	
	//��ȡרҵѧԺ��Ϣ
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
			
			
		
		//����ѧԺ��ȡ�о�������Ϣ,����json�ַ���
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

		//��ѯ���н�ʦ��Ϣ�����ؽ�ʦ���󼯺�
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
		
		//����γ�ʱ��ѯ���пɿ��ν�ʦ
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
		
		//��ӽ�ʦ
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
		
		//���ݹؼ���������ʦ��Ϣ,����json�����ַ���
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
			         
			        // ����ÿһ��  
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
		
		//�޸Ľ�ʦ
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
		
		
		
		//ɾ����ʦ
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
		//ѧ�����۽�ʦ
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
		//���ݽ�ʦ�˺Ų�ѯ��ʦ����Ŀγ�
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
		//���ݽ�ʦ�γ�id�鿴�γ�����,����json����
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
		//���ݽ�ʦ�˺Ų�ѯ��ʦ�ѿ��貢�ҳɼ���δ¼��Ŀγ�
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
	//���ݽ�ʦ�γ�id����ѡ�˸ÿε�����ѧ������
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
			         
			        // ����ÿһ��  
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
		//���ݽ�ʦ�γ�ID���ؿγ̴���
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
		//¼��γ̳ɼ�
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
		//���ݽ�ʦ�γ�ID��ѯ����δ�ش������
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
			         
			        // ����ÿһ��  
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
		//���ݽ�ʦ�γ�ID��ѯ�����ѻش������
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
			         
			        // ����ÿһ��  
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
		
		//��ʦ�ش�����
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
		//��ʾ��ʦ���ش����������
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
