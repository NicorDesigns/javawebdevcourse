package com.nicordesigns;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "helloWorldServlet",
        urlPatterns = {"/greeting", "/salutation", "/wazzup"},
        loadOnStartup = 1
)
public class HelloWorldServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static final String DEFAULT_USER = "Guest";


	private static Logger LOGGER = LogManager.getLogger(HelloWorldServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
        
		if(user == null)
            user = HelloWorldServlet.DEFAULT_USER;
		
		 PrintWriter writer = response.getWriter();
	        writer.append("<!DOCTYPE html>\r\n")
	              .append("<html>\r\n")
	              .append("    <head>\r\n")
	              .append("        <title>Hello User Application</title>\r\n")
	              .append("    </head>\r\n")
	              .append("    <body>\r\n")
	              .append("        Hello, ").append(user).append("!<br/><br/>\r\n")
	              .append("        <form action=\"greeting\" method=\"POST\">\r\n")
	              .append("            Enter your name:<br/>\r\n")
	              .append("            <input type=\"text\" name=\"user\"/><br/>\r\n")
	              .append("            <input type=\"submit\" value=\"Submit\"/>\r\n")
	              .append("        </form>\r\n")
	              .append("    </body>\r\n")
	              .append("</html>\r\n");

	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
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
