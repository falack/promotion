package com.falack.promotion.basicactions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

/**
 * Servlet implementation class PurposeServlet
 */
public class PurposeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurposeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  
    // TODO: fill this in
    // The instance connection name can be obtained from the instance overview page in Cloud Console
    // or by running "gcloud sql instances describe <instance> | grep connectionName".
    String instanceConnectionName = "falack-001:europe-west1:promotiondb";

    // TODO: fill this in
    // The database from which to list tables.
    String databaseName = "falack";

    String username = "";
    
    String password = "";
    
    String connect = this.getServletContext().getInitParameter("sql.urlRemote");
  
	  System.out.println(connect);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	  
	  String jdbcUrl = String.format(
	      "jdbc:mysql://google/%s?cloudSqlInstance=%s"
	          + "&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=true",
	          databaseName,
	          instanceConnectionName);
	  
	  try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
      
      System.out.println("sssssssssssss");
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
	  
		request.getRequestDispatcher("/purpose.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    System.out.println("ssscssss");
		doGet(request, response);
	}

}
