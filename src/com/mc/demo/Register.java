package com.mc.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class Register extends HttpServlet {
	
	private String name;
	private String pass;
	private String confirm;

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		this.name = request.getParameter("username");
		this.pass = request.getParameter("password");
		//this.confirm = request.getParameter("confirm");
		
		Service serv = new Service();
		boolean register = serv.register(name, pass);
		if(register){
			System.out.print("Success");
			request.getSession().setAttribute("username", name);
			out.print("Success ");
		}
		else{
			System.out.print("Failed");
			out.print("Failed ");
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		out.print("用户名：" + name );
		out.print("密码：" + pass);
		out.flush();
		out.close();
		
		
		/*System.out.println(this.name + " __" + this.pass);
		String dirverName = "MySQL Connector/J";
		String userName = "root";
		String userPasswd ="root";
		String dbName = "mytestdb";
		String tableName = "users";
		
		
		String url="jdbc:mysql://localhost/"+dbName+"?user="+userName+"&password="+userPasswd;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url);

			Statement statement = connection.createStatement();

			String sql = "SELECT * FROM " + tableName;

			ResultSet rs = statement.executeQuery(sql);

			while(true){
				if(rs.next()){
					System.out.println(rs.getString(1));
					if(this.name.equals(rs.getString(1)))
					{
						out.print("<h1>" + "User Name is in Data base!");
						break;
					}
					
				}
				else
				{
					sql="INSERT INTO "+tableName+" VALUES('"+this.name+"','"+this.pass+"')";
					System.out.println(sql);
					statement.execute(sql);
					out.print("<h1>"+"Register Successful!");
					break;
				}
			}
			return;
		}
		catch(SQLException e){
			out.print(e.getMessage());
		}
		catch(ClassNotFoundException e){
			out.print(e.getMessage());
		}
		
		out.print("7");
		out.flush();
		out.close();*/
		

		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();*/
	}

}
