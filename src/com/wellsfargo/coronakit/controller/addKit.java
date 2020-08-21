package com.wellsfargo.coronakit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.coronakit.entity.CoronaKit;
import com.wellsfargo.coronakit.service.CoronaKitService;
import com.wellsfargo.coronakit.service.CoronaKitServiceImpl;

@WebServlet("/addKit")
public class addKit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public addKit() { 
        super(); 
        // TODO Auto-generated constructor stub 
    } 
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.getWriter().append("Served at: ").append(request.getContextPath()); 
		
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
	
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter(); 
	String item = request.getParameter("itemNumber"); 
	int itemNumber = Integer.parseInt(item); 
	try { 
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rathishdb", "root", "root"); 
		PreparedStatement ps = con.prepareStatement("select * from coronakit where id=?"); 
		ps.setInt(1, itemNumber); 
		ResultSet rs = ps.executeQuery(); 
		while (rs.next()) { 
			out.println( 
					"cost: " + rs.getDouble(3)); 
			
		}
	}
	catch (Exception e) { 
		e.printStackTrace(); 
	} finally { 
		out.close(); 
	} 
}
}
