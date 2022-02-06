package com.nicordesigns;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
name = "contextParameterServlet",
urlPatterns = {"/contextParameters"})
public class ContextParameterServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ServletContext c = this.getServletContext();
        PrintWriter writer = response.getWriter();

        writer.append("databaseOne: ").append(c.getInitParameter("databaseOne"))
              .append(", cloudOne: ").append(c.getInitParameter("cloudOne"));
    }
}
