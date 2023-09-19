package com.maddy_Registrtion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String UNAME = request.getParameter("name");
		String UPASSWORD = request.getParameter("pass");
		String UEMAIL = request.getParameter("email");
		String UMOBILE= request.getParameter("contact");
		
		PrintWriter out = response.getWriter();
		out.println("Name:"+UNAME);
		out.println("Password:"+UPASSWORD);
		out.println("Email:"+UEMAIL);
		out.println("Contact:" +UMOBILE);
		out.print("Successfully Registered!!!");
		
		Connection con = null;
		RequestDispatcher dispatcher= null;
	
		try 
		{   //loading driver class
			Class.forName("com.mysql.jdbc.Driver"); 
			//creating a connection
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/login_register","root"," "); 
			PreparedStatement pst= con.prepareStatement("INSERT INTO USERS(UNAME,UPASSWORD,UEMAIL,UMOBILE) VALUES(?,?,?,?)");
			pst.setString(1, UNAME);
			pst.setString(2, UPASSWORD);
			pst.setString(3, UEMAIL);
			pst.setString(4, UMOBILE);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if(rowCount > 0) 
			{
				request.setAttribute("Status", "Successfull!!!");
			}
			else
			{
				request.setAttribute("Status", "Failed");
			}
			
			dispatcher.forward(request, response);	
		}
		catch(Exception e ) 
		{
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
