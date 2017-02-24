package com.gmu.databasedemo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gmu.databasedemo.dao.DataAccess;

/**
 * Servlet implementation class AllPost
 */
@WebServlet(name = "AllPost", urlPatterns = {"/AllPost"})
public class AllPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("AllPost", DataAccess.getAll());
        request.setAttribute("AllPostg", DataAccess.getAllGrades());
        RequestDispatcher rd = request.getRequestDispatcher("AllPost.jsp");
        rd.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 request.setAttribute("AllPostg", DataAccess.getAllGrades()); 
		request.setAttribute("AllPost", DataAccess.getAll());
	        RequestDispatcher rd = request.getRequestDispatcher("AllPost.jsp");
	        rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
