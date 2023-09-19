package ServletPackage;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServletJdbcConnectivity extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletJdbcConnectivity() {
       
    }
    private Connection con;
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Setting up the jdbc connection....");
		
		//Database Connection 
		String dbURL="jdbc:mysql://localhost:3306";
		//Database name to access
		String dbName="World";
		String dbusername="root";
		String dbpassword="1234";
		
		StringBuffer sb=new StringBuffer(dbURL);
		try {
			String dbDriver = "com.mysql.cj.jdbc.Driver";
			Class.forName(dbDriver);
			con= DriverManager.getConnection(sb.append(dbName).toString(),dbusername,dbpassword );
			
			}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	public void destroy() {
		
	}
	public ServletConfig getServletConfig() {
		
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		try {
			
			Statement st=con.createStatement();
			ResultSet rs= st.executeQuery("SELECT * FROM USER");
			
			while(rs.next()) 
			{
				Integer id = rs.getInt(1);
				String userId = rs.getString(2);
				String password = rs.getString(3);
				String displayname = rs.getString(4);
				System.out.println("ID ::"+id + " USER_ID::"+userId + "PASSWORD::"+password + "DISPLAYNAME::"+displayname);
				
				response.getWriter().append("ID ::"+id).append(" USER_ID::"+userId).append("PASSWORD::"+password);
			}
				rs.close();
				st.close();
			
			
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}

	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userId= request.getParameter("userId");
		String passWord= request.getParameter("passWord");
		String displayName=request.getParameter("displayName");
		try {
			
			PreparedStatement ps= con.prepareStatement("INSERT INTO USER(userId, passWord, displayName) VALUES(?,?,?)");	
			ps.setString(1, userId);
			ps.setString(2, passWord);
			ps.setString(3, displayName);
			
			int numberOfRecord=  ps.executeUpdate();
			System.out.println("Number of Records Inserted is: " +numberOfRecord);
			ps.close();
			}
			catch(SQLException e )
			{
				e.printStackTrace();
			}
		
	}

	/*protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}*/

}
