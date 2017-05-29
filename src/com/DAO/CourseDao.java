package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.javabeans.Course;
import com.javabeans.TeacherCourse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CourseDao  extends BaseDao{

	//查询所有课程
	public ArrayList<Course> findAllCourse(){
		String sql="SELECT * FROM course;";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rst=pstmt.executeQuery();
			ArrayList<Course> courseList=new ArrayList<Course>();
			Course course=null;
			while(rst.next()){   
				course=new Course();
				course.setCourseNumber(rst.getString(1));
		    	course.setCourseName(rst.getString(2));
		    	course.setCredit(rst.getInt(3));
		    	course.setClassHour(rst.getInt(4));
			
				courseList.add(course);
			}
			return courseList;
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
	
	//添加课程
	public String addCourse(Course course){
	
		String sql="INSERT INTO course VALUES(?,?,?,?);";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,course.getCourseNumber());
			pstmt.setString(2,course.getCourseName());
			pstmt.setInt(3,course.getCredit());
			pstmt.setInt(4,course.getClassHour());
			int col=pstmt.executeUpdate();
			if(col!=0){
				return "ok";
			}else{
				return "error";
			}
		} catch (Exception e) {
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
	

	//根据关键字搜索课程信息,返回json数组字符串
	public String searchCourse(String message){
		String sql="SELECT * FROM course WHERE 	courseNumber LIKE '%"
					+message+"%'OR courseName LIKE '%"+message+"%';";
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
	
	//删除课程
		public String delCourse(String courseNumber){
			String sql="DELETE FROM course WHERE courseNumber=?";
			Connection conn=null;
			PreparedStatement pstmt=null;
			
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,courseNumber);
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
		//根据教师账号和课程学时获取可用的上课时间
		public String getAvaCoursetime(Long teacherAccount,int classHour){
			
			//String sql="SELECT 	courseTimeId,courseTime FROM coursetime WHERE classHour=? AND courseTimeId NOT IN(SELECT courseTimeId FROM teachercourse WHERE teacherAccount=? UNION SELECT courseTimeId FROM classroomoccupied WHERE classRoomId=?)";
			String sql="SELECT courseTimeId ,courseTime FROM coursetime "
						+"WHERE courseTimeId IN"
		+"(SELECT DISTINCT courseTimeId FROM classhour"+classHour+" WHERE courseTimeId NOT IN "
			+"(SELECT courseTimeId FROM classhour"+classHour+" WHERE timepreiod IN "
				+"( SELECT weekday*10+timeQuantum FROM coursetimedescript WHERE courseTimeId IN "
					+"( SELECT courseTimeId FROM teachercourse WHERE teacherAccount=?))));";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setLong(1,teacherAccount);
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
		//为课程分配教师
		public String openCourse(TeacherCourse tc){
			String sql1="INSERT INTO teachercourse VALUES(null,?,?,?,?,?,?)";
			String sql2="INSERT INTO classroomoccupied VALUES(?,?)";
			Connection conn=null;
			PreparedStatement pstmt=null;
			int col1=0,col2=0;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql1);
				pstmt.setLong(1,tc.getTeacherAccount());
				pstmt.setString(2,tc.getCourseNumber());
				pstmt.setString(3,tc.getCourseTimeId());
				pstmt.setInt(4,tc.getClassRoomId());
				pstmt.setInt(5,tc.getCapacity());
				pstmt.setInt(6,tc.getSurplus());
				col1=pstmt.executeUpdate();
				if(col1!=0){
					pstmt=conn.prepareStatement(sql2);
					pstmt.setInt(1,tc.getClassRoomId());
					pstmt.setString(2,tc.getCourseTimeId());
					col2=pstmt.executeUpdate();
					if(col2!=0){
						return "ok";  
					}
			     }    
					return "error";
				
			} catch (SQLException e) {
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
		
		//根据课程代码查看课程开设的情况
		public String searchCorsopened(String courseNumber){
			
			String sql="SELECT teachercourse.courseNumber,course.courseName,"
					+ "teacher.teacherName,course.credit,coursetime.courseTime,"
					+ "classroom.classRoomLocation,teachercourse.capacity,"
					+ "teachercourse.surplus FROM teachercourse "
					+ "INNER JOIN teacher ON teachercourse.teacherAccount"
					+ "=teacher.teacherAccount INNER JOIN course ON"
					+ " teachercourse.courseNumber=course.courseNumber INNER JOIN coursetime "
					+ "ON teachercourse.courseTimeId=coursetime.courseTimeId "
					+ "INNER JOIN classroom ON teachercourse.classRoomId=classroom.classRoomId "
					+ "WHERE teachercourse.courseNumber=?;";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,courseNumber);
				
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
		
		//显示所有余量大于0的课程
		public ArrayList<TeacherCourse> findAllAvaCourse(){
			
			String sql="SELECT teachercourse.teacherCourseId,teachercourse.courseNumber,course.courseName,"
					+ "teacher.teacherName,coursetime.courseTime,"
					+ "classroom.classRoomLocation,course.credit,teachercourse.capacity,"
					+ "teachercourse.surplus FROM teachercourse "
					+ "INNER JOIN teacher ON teachercourse.teacherAccount"
					+ "=teacher.teacherAccount INNER JOIN course ON"
					+ " teachercourse.courseNumber=course.courseNumber INNER JOIN coursetime "
					+ "ON teachercourse.courseTimeId=coursetime.courseTimeId "
					+ "INNER JOIN classroom ON teachercourse.classRoomId=classroom.classRoomId "
					+ "WHERE teachercourse.surplus>0 ORDER BY teachercourse.courseNumber ASC;";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql);
				rst=pstmt.executeQuery();
				ArrayList<TeacherCourse> courseList=new ArrayList<TeacherCourse>();
				TeacherCourse course=null;
				while(rst.next()){   
					course=new TeacherCourse();
					
					course.setTeacherCourseId(rst.getInt(1));
					course.setCourseNumber(rst.getString(2));
					course.setCourseName(rst.getString(3));
					course.setTeacherName(rst.getString(4));
					course.setCourseTime(rst.getString(5));
			    	course.setClassRoomLocation(rst.getString(6));
			    	course.setCredit(rst.getInt(7));
			    	course.setCapacity(rst.getInt(8));
			    	course.setSurplus(rst.getInt(9));
				
					courseList.add(course);
				}
				return courseList;
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
		//根据学生账号查询学生已选课程
		public ArrayList<TeacherCourse> findSelectedCourse(long stuAccount){
			String sql1="SELECT teacherCourseId FROM stucourse WHERE stuAccount=?";
			
			String tcId="";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql1);
				pstmt.setLong(1,stuAccount);
				rst=pstmt.executeQuery();
				while(rst.next()){
					tcId+=rst.getInt(1)+",";
				}
			
			if(tcId!=""){
				
			
			String sql2="SELECT teachercourse.teacherCourseId,teachercourse.courseNumber,course.courseName,"
					+ "teacher.teacherName,coursetime.courseTime,"
					+ "classroom.classRoomLocation,course.credit"
					+ " FROM teachercourse "
					+ "INNER JOIN teacher ON teachercourse.teacherAccount"
					+ "=teacher.teacherAccount INNER JOIN course ON"
					+ " teachercourse.courseNumber=course.courseNumber INNER JOIN coursetime "
					+ "ON teachercourse.courseTimeId=coursetime.courseTimeId "
					+ "INNER JOIN classroom ON teachercourse.classRoomId=classroom.classRoomId "
					+ "WHERE teachercourse.teacherCourseId IN ("
					+tcId.substring(0,tcId.length()-1)+") ORDER BY coursetime.courseTimeId ASC;";
			
				pstmt=conn.prepareStatement(sql2);
				
				rst=pstmt.executeQuery();
				ArrayList<TeacherCourse> courseList=new ArrayList<TeacherCourse>();
				TeacherCourse course=null;
				while(rst.next()){   
					course=new TeacherCourse();
					
					course.setTeacherCourseId(rst.getInt(1));
					course.setCourseNumber(rst.getString(2));
					course.setCourseName(rst.getString(3));
					course.setTeacherName(rst.getString(4));
					course.setCourseTime(rst.getString(5));
			    	course.setClassRoomLocation(rst.getString(6));
			    	course.setCredit(rst.getInt(7));
			    	
				
					courseList.add(course);
				}
				return courseList;
			}
			return null;
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
		
		
		//学生选课
		public String stuSelectCors(long stuAccount,String teacCorsIdArr,String val){
			String sql1="SELECT surplus FROM teachercourse WHERE teacherCourseId IN ("+teacCorsIdArr+");";
			String sql5="SELECT  COUNT(courseTimeId) FROM teachercourse WHERE teacherCourseId IN ("+teacCorsIdArr
					+") GROUP BY courseTimeId HAVING COUNT(courseTimeId)>1";
			
			String sql="SELECT COUNT(cf) ,cf FROM( SELECT weekday*10+timeQuantum as cf "
					+ "FROM coursetimedescript WHERE courseTimeId IN "
					+ "(SELECT courseTimeId FROM teachercourse "
					+ "WHERE  teacherCourseId IN ("+teacCorsIdArr+"))) as a"
					+ " GROUP BY cf HAVING COUNT(cf)>1";
			String sql2="SELECT * FROM( SELECT weekday*10+timeQuantum as wt "
					+ "FROM coursetimedescript WHERE courseTimeId IN "
					+ "(SELECT courseTimeId FROM teachercourse"
					+ " WHERE teacherCourseId IN ("+teacCorsIdArr+"))) AS a WHERE wt IN "
					+ "(SELECT weekday*10+timeQuantum FROM coursetimedescript"
					+ " WHERE courseTimeId IN "
					+ "( SELECT courseTimeId FROM teachercourse"
					+ " WHERE teacherCourseId IN "
					+ "(SELECT teacherCourseId From stucourse "
					+ "WHERE stuAccount=?)));";
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql1);
				
				rst=pstmt.executeQuery();
				int surplus;
				while(rst.next()){
					surplus=rst.getInt(1);
					if(surplus<=0){
						return "余量不足";
					}
				}//余量充足再判断学生选择的课程之间有没有上课时间完全相同的
				pstmt=conn.prepareStatement(sql5);
				
				rst=pstmt.executeQuery();
				if(rst.next()){//学生选择多门课程时课程时间之间有一样的
					return "上课时间不能冲突！";
				}else{
					pstmt=conn.prepareStatement(sql);
					rst=pstmt.executeQuery();
					if(rst.next()){//学生选择多门课程时课程时间之间相互冲突
						return "上课时间不能冲突！";
					}else{
					pstmt=conn.prepareStatement(sql2);
					pstmt.setLong(1,stuAccount);
					rst=pstmt.executeQuery();
						if(rst.next()){//学生选择的多门课程中有与已选课程时间冲突的
							return "上课时间不能冲突！";
						}else{
							
							String sql3="INSERT INTO stucourse VALUES"+val+";";
							String sql4="UPDATE teachercourse SET surplus=surplus-1"
									+ " WHERE teacherCourseId IN ("+teacCorsIdArr+");";
							pstmt=conn.prepareStatement(sql3);
							int col=0;
							col=pstmt.executeUpdate();
							if(col!=0){
								pstmt=conn.prepareStatement(sql4);
								int col1=0;
								col1=pstmt.executeUpdate();
								if(col1!=0){
									return "ok";
								}
								return "error";
							}
							return "error";
						}
						
					}
				}
					
					
				
				
			} catch (Exception e) {
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
		
		//根据课程名称或教师姓名搜索教师课程信息,返回json数组字符串
		public String searchTeacherCourse(String message){
			String sql="SELECT teachercourse.teacherCourseId,teachercourse.courseNumber,course.courseName,"
					+ "teacher.teacherName,coursetime.courseTime,"
					+ "classroom.classRoomLocation,course.credit,teachercourse.capacity,"
					+ "teachercourse.surplus FROM teachercourse "
					+ "INNER JOIN teacher ON teachercourse.teacherAccount"
					+ "=teacher.teacherAccount INNER JOIN course ON"
					+ " teachercourse.courseNumber=course.courseNumber INNER JOIN coursetime "
					+ "ON teachercourse.courseTimeId=coursetime.courseTimeId "
					+ "INNER JOIN classroom ON teachercourse.classRoomId=classroom.classRoomId "
					+ "WHERE  teacher.teacherName LIKE '%"
						+message+"%' OR courseName LIKE '%"+message+"%' ORDER BY teachercourse.courseNumber ASC;";
					
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
		
		//学生退课
		public String quitSelectedCors(long stuAccount,int teacherCourseId){
			String sql1="DELETE FROM stucourse WHERE stuAccount=? AND teacherCourseId=?";
			String sql2="UPDATE teachercourse SET surplus=surplus+1 WHERE teacherCourseId=?";
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			try {
				conn = dataSource.getConnection();
				pstmt=conn.prepareStatement(sql1);
				pstmt.setLong(1,stuAccount);
				pstmt.setInt(2,teacherCourseId);
				int col=0;
				col=pstmt.executeUpdate();
				if(col!=0){
					pstmt=conn.prepareStatement(sql2);
					pstmt.setInt(1,teacherCourseId);
					int col2=0;
					col2=pstmt.executeUpdate();
					if(col2!=0){
						return "ok";
					}
					return "error";
					
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
}
