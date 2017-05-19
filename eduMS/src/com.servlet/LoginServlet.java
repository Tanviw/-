package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.sql.*;

/**
 * Created by Tanvi on 2017/5/18.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out=response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String identity=request.getParameter("identity");
        System.out.println(username);
        System.out.println(password);
        System.out.println(identity);
        try{
           
            Class.forName("com.mysql.jdbc.Driver");
         

            String url="jdbc:mysql://localhost:3306/edums";    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url, "root","root");

            String sql = "SELECT * FROM account WHERE account=? AND password=? AND identity=?";   
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,identity);
            ResultSet rst=pstmt.executeQuery();
            if (rst.next()){
                out.println("0");
            }else{
                out.println("1");
            }
            rst.close();
            pstmt.close();
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
		
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
