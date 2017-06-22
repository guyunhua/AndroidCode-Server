package com.mc.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class LoginServlet extends HttpServlet {

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
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		//username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		String password = request.getParameter("password");
		System.out.println(username + "--" + password);
		
		Service serv = new Service();
		boolean loged = serv.login(username, password);
		if(loged){
			System.out.print("Success");
			out.print("Success ");
			request.getSession().setAttribute("username", username);
		}
		else{
			out.print("Failed ");
			System.out.print("Failed");
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		out.print("用户名：" + username );
		out.print("密码：" + password);
		out.flush();
		out.close();

		/*response.setContentType("text/html");
		String userName = request.getParameter("username");
		String userPwd = request.getParameter("pwd");
		PrintWriter out = response.getWriter();
		if(userName.equals("123") && userPwd.equals("123")){
			
			out.write("success!");
		}
		else{
			out.write("username or password error!");
		}
		out.flush();
		out.close();*/
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

		doGet(request, response);
	}

}
