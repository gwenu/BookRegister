package br.common.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.common.models.Book;
import br.common.models.Books;
import br.common.services.BookRepository;
import br.common.utils.XmlResponse;

@WebServlet(
		description = "Book Servlet", 
		urlPatterns = { "/book" })
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String responseXml = getResponseString(request);
		sendResponse(response, responseXml);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	private String getResponseString(HttpServletRequest request) {
		String responseXml = "";
		String requestUri = request.getRequestURI();
		
		Map<String, String[]> paremeters = request.getParameterMap();
		BookRepository bookRepository = new BookRepository();
		
		if (requestUri.contains("book/all")) {
			XmlResponse<Books> xmlResponse = new XmlResponse<Books>();
			Books books = bookRepository.getAllBooks();
			responseXml = xmlResponse.xmlToString(books);
		} else if (paremeters.containsKey("id")) {
			Long id = Long.valueOf(request.getParameter("id"));
			XmlResponse<Book> xmlResponse = new XmlResponse<Book>();
			Book book = bookRepository.getBookById(id);
			responseXml = xmlResponse.xmlToString(book);
		} else if(paremeters.containsKey("title")) {
			String title = request.getParameter("title");
			XmlResponse<Book> xmlResponse = new XmlResponse<Book>();
			Book book = bookRepository.getBookByTitle(title);
			responseXml = xmlResponse.xmlToString(book);
		}

		return responseXml;
	}
	
	private void sendResponse(HttpServletResponse response, String responseBody)
			throws IOException {
		response.setStatus(200);
		PrintWriter out = response.getWriter();
		out.println(responseBody);
	}
}
