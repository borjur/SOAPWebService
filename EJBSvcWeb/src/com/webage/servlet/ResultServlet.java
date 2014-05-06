package com.webage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.w3c.dom.*;
import javax.xml.parsers.*;



/**
 * Servlet implementation class for Servlet: ResultServlet
 *
 */
 public class ResultServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ResultServlet() {
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
		 try {
		        DocumentBuilderFactory factory = 
		            DocumentBuilderFactory.newInstance();
		        factory.setNamespaceAware(true);

		        DocumentBuilder builder = factory.newDocumentBuilder();
		        Document doc = builder.parse(request.getInputStream());

		        String messageId = getElementValue(doc, 
		            "http://www.w3.org/2005/08/addressing", "RelatesTo");
		        log("Message ID in response: " + messageId);

		        String status = getElementValue(doc, "*", "return");
		        log("Server returned: " + status);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

	}   	
	
	private String getElementValue(Document doc, String namespace, String tag) throws Exception {
	    NodeList list = doc.getElementsByTagNameNS(namespace, tag);
	    if (list.getLength() == 0) {
	    	throw new Exception("Can not find element " + tag);
	    }
	    Node n = list.item(0);
	    return n.getTextContent();
	}

}