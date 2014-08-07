package br.common.controllers;

import br.common.services.BookDataProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(
        description = "Book Servlet",
        urlPatterns = {"/books"})
public class BookController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String responseXml = new BookDataProvider().getAllBooks();

        response.setStatus(200);
        PrintWriter out= response.getWriter();
        out.println(responseXml);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
