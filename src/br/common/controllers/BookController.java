package br.common.controllers;

import br.common.models.Author;
import br.common.models.Book;
import br.common.services.BookDataProvider;
import br.common.utils.StreamUtil;
import br.common.utils.XmlReader;
import br.common.utils.XmlWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;


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
