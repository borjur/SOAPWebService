package com.webage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.ws.core.StubExt;
import org.jboss.ws.extensions.wsrm.api.RMProvider;

import com.webage.warehouse.Order;
import com.webage.warehouse.WarehouseSystem;
import com.webage.warehouse.WarehouseSystemService;

/**
 * Servlet implementation class for Servlet: OrderServlet
 *
 */
 public class OrderServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			WarehouseSystemService svc = new WarehouseSystemService();
			WarehouseSystem w = svc.getWarehouseSystemPort();
			
			((StubExt) w).setConfigName("Standard Anonymous WSRM Client", 
			"META-INF/wsrm-jaxws-client-config.xml");
			
			Order o = new Order();
			
			o.setOrderId(request.getParameter("orderId"));
			o.setProductId(request.getParameter("productId"));
			o.setQuantity(Integer.parseInt(
					request.getParameter("quantity")));
			
			w.createOrder(o);
			
			((RMProvider) w).closeSequence();
			
			out.println("<p>Your order has been submitted</p>");
		} catch (Exception e) {
			out.println("<p>Error: " + e.getMessage() + "</p>");
			e.printStackTrace();
		}
	}   	  	    
}