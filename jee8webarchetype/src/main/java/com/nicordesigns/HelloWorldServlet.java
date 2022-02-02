package com.nicordesigns;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;

public class HelloWorldServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static Logger LOGGER = LogManager.getLogger(HelloWorldServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().println("Hello, World!");
	}

	@Override
	public void init() throws ServletException {
		LOGGER.info("Servlet " + this.getServletName() + " has started.");
	}

	@Override
	public void destroy() {
		LOGGER.info("Servlet " + this.getServletName() + " has stopped.");
	}
}
