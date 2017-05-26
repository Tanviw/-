package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassroomDao  extends BaseDao{

	public ArrayList<String> findAllClassroom(){
		String sql="SELECT 	classRoomLocation FROM classroom;";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			rst=pstmt.executeQuery();
			ArrayList<String> classRoomList=new ArrayList<String>();
			while(rst.next()){
				classRoomList.add(rst.getString(1));
			}
			return classRoomList;
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
	public String delClassroom(String classroomArr){
		String sql="DELETE FROM classroom WHERE classRoomLocation IN("+classroomArr+");";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
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
	
	public String addClassroom(String classRoomLocation){
		String sql="INSERT INTO classroom VALUES(null,?);";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		try {
			conn = dataSource.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,classRoomLocation);
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
}
