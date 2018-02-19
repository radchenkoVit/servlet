package com.education.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {

    public static String htmlPage = "<html>\n" +
            "\t<head>\n" +
            "\t\t<title>Servlet Page</title>\n" +
            "\t</head>\n" +
            "\t<body>\n" +
            "\t\t<p>Hi YayPay From Servlet</p>\n" +
            "\t</body>\n" +
            "</html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write(htmlPage);
        writer.flush();
    }
}
