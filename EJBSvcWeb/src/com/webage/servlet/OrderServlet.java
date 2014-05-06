package com.webage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Response;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.addressing.AddressingBuilder;
import javax.xml.ws.addressing.AddressingProperties;
import javax.xml.ws.addressing.AttributedURI;
import javax.xml.ws.addressing.EndpointReference;
import javax.xml.ws.addressing.JAXWSAConstants;

import org.jboss.ws.core.StubExt;
import org.jboss.ws.extensions.addressing.AddressingClientUtil;

import com.webage.ejb.BadCustomerException_Exception;
import com.webage.ejb.Order;
import com.webage.ejb.OrderBeanService;

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
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    try {
	    	OrderBeanService obs = new OrderBeanService();
	    	Order o = obs.getOrderBeanPort();
	    	
	    	setupAddressing(
	    			(BindingProvider) o, 
	    			"http://localhost:8080/EJBSvcWeb/ResultServlet");
	    	((StubExt) o).setConfigName("Standard WSAddressing Client");



//	    	BindingProvider bp = (BindingProvider) o;
//	    	Map<String, Object> context = bp.getRequestContext();
//	    	context.put(
//	    	    BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
//	    	    "http://localhost:1234/invalid/URL");

	    	
	        String name = request.getParameter("name");

	        Response<?> r = o.orderSoupAsync(name);

	        out.println("<p>Your order has been submitted.</p>");
	        
	    } catch (BadCustomerException_Exception e) {
	    	out.println("<p>Your order is rejected. " + e.getFaultInfo().getMessage() + "</p>");
	    } catch (WebServiceException wse) {
	    	out.println("<p>Unexpected network or configuration error.</p>");
	    	wse.printStackTrace();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }



	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
	
	private void setupAddressing(BindingProvider bp, String replyTo) 
	throws Exception {
		AddressingProperties requestProps = 
			AddressingClientUtil.createDefaultProps(
			"http://ActionURL", "http://ToURL");

		AttributedURI messageId = AddressingClientUtil.createMessageID();
		log("Message ID: " + messageId.getURI());
		requestProps.setMessageID(messageId);

		EndpointReference er = AddressingBuilder.getAddressingBuilder()
		.newEndpointReference(new URI(replyTo));
	requestProps.setReplyTo(er);

	bp.getRequestContext().put(
			JAXWSAConstants.CLIENT_ADDRESSING_PROPERTIES_OUTBOUND,
			requestProps);

		
	}

}