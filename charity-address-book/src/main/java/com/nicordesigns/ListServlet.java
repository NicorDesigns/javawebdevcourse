package com.nicordesigns;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import java.io.IOException;
import java.time.Instant;
import java.time.Month;
import java.time.MonthDay;
import java.util.Collections;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;

@WebServlet(
        name = "listServlet",
        urlPatterns = "/list"
)
public class ListServlet extends HttpServlet
{
    private static final SortedSet<Address> addresses = new TreeSet<>();

    static {
        addresses.add(new Address("1", "Zisize Care Centre", "+27 1 83 3160369", "https://www.facebook.com/ZISIZE",
                MonthDay.of(Month.JUNE, 5),
                Instant.parse("2022-06-05T21:22:23Z")
        ));
        addresses.add(new Address( "2", "UMCA", "+27 21 887 0212", "http://vcsv.co.za/",
                null, Instant.parse("2022-06-05T15:31:17Z")
        ));
        addresses.add(new Address("3", "Diaconia", "+27 21 957 7113", "http://www.diaconia.co.za/",
                MonthDay.of(Month.JUNE, 5),
                Instant.parse("2022-06-05T01:45:01Z")
        ));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    	String language = request.getParameter("language");
        if("afrikaans".equalsIgnoreCase(language))
            Config.set(request, Config.FMT_LOCALE, Locale.forLanguageTag("af-ZA"));
        
        
        if(request.getParameter("empty") != null)
            request.setAttribute("addresses", Collections.<Address>emptySet());
        else
            request.setAttribute("addresses", addresses);
        request.getRequestDispatcher("/WEB-INF/jsp/view/list.jsp")
               .forward(request, response);
    }
}
