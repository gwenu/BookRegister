package br.common.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.common.services.BookDataProvider;


@WebServlet(
        description = "Book Servlet",
        urlPatterns = {"/books"})
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 3341104474037671351L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String responseXml = new BookDataProvider().getAllBooks();

        response.setStatus(200);
        PrintWriter out= response.getWriter();
        out.println(responseXml);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
