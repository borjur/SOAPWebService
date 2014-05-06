package com.movie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.BindingProvider;

import org.jboss.ws.core.StubExt;

import com.movie.MovieService;
import com.movie.MovieServiceImplService;
import com.movie.MovieType;

/**
 * Servlet implementation class for Servlet: AddMovieServlet
 * 
 */
public class AddMovieServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AddMovieServlet() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		MovieType movie = new MovieType();
		movie.setTitle(request.getParameter("title"));
		movie.setDescription(request.getParameter("description"));
		movie.setRating(request.getParameter("rating"));
		String[] actors = request.getParameter("actors").split(",");
		for (int x = 0; x != actors.length; x++) {
			movie.getActor().add(actors[x]);
		}

		MovieServiceImplService mss = new MovieServiceImplService();
		MovieService service = mss.getMovieServiceImplPort();
		
		defaultSetup(service);

		BindingProvider bp = (BindingProvider) service;
		Map<String, Object> context = bp.getRequestContext();
		context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://localhost:8081/WebServiceProject/MovieService");

		service.addMovie(movie);

		out.println("Successfully added a movie: " + movie.getTitle());

	}

	protected void defaultSetup(MovieService service) {
		((StubExt) service).setConfigName("Standard WSSecurity Client");
		System.setProperty("org.jboss.ws.wsse.keyStore",
				"C:/LabFiles/client.jks");
		System.setProperty("org.jboss.ws.wsse.trustStore",
				"C:/LabFiles/client.jks");
		System.setProperty("org.jboss.ws.wsse.keyStorePassword", "xyz123");
		System.setProperty("org.jboss.ws.wsse.trustStorePassword", "xyz123");
		System.setProperty("org.jboss.ws.wsse.keyStoreType", "jks");
		System.setProperty("org.jboss.ws.wsse.trustStoreType", "jks");

	}

}