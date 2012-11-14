package com.esisa.j2ee.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.log.SystemLogHandler;

import esisa.java.db.DataSource;
import esisa.java.db.Database;
import esisa.java.db.MySqlDataSource;
import esisa.java.gs.Produit;
import esisa.java.gs.Stock;


public class StockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Stock stock;
	
	public void init() throws ServletException {
		DataSource ds = new MySqlDataSource("stock", "localhost", "root", "");
		Database db = new Database(ds);
		stock = new Stock(db);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long s1=System.currentTimeMillis();
		
		String produit = request.getParameter("ref");
		Produit p = stock.getProduit(produit);
		//PrintWriter out = response.getWriter();
		if(p != null) {
			//out.println("<html><body><h1>" + p.toString() + "</h1></body></html>");
			request.setAttribute("produit", p);
			getServletContext().getRequestDispatcher("/AfficherProduit.jsp").forward(request, response);
		}
		else {
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			//out.println("<html><body><h1> Produit inexistant </h1></body></html>");
	
		}
		long s2=System.currentTimeMillis();
		System.out.println("Temps  d'une requete :"+(s2-s1));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
