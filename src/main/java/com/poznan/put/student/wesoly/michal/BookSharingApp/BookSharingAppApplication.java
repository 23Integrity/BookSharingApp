package com.poznan.put.student.wesoly.michal.BookSharingApp;

import com.poznan.put.student.wesoly.michal.BookSharingApp.api.books.GoogleBooksAPIController;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.BooksDAO;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.BooksParser;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.UserDAO;
import com.poznan.put.student.wesoly.michal.BookSharingApp.dao.UserParser;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.Books.Books;
import com.poznan.put.student.wesoly.michal.BookSharingApp.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.sql.SQLException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BookSharingAppApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(BookSharingAppApplication.class, args);
//		GoogleBooksAPIController controller = new GoogleBooksAPIController(new RestTemplateBuilder());
//		Books book = controller.getBookISBNJSON("9788380326460");
//		BooksDAO dao = new BooksDAO();
////		dao.runQuery(BooksParser.createSaveQuery(book));
//		System.out.println(dao.runQuery(BooksParser.findBookWithISBN("9788380326460")));
		UserDAO dao = new UserDAO();
		User user = new User("test", "test");
		dao.runQuery(UserParser.createSaveQuery(user));
	}

}
