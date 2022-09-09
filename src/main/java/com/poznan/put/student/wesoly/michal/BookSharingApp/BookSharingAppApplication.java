package com.poznan.put.student.wesoly.michal.BookSharingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.sql.SQLException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BookSharingAppApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(BookSharingAppApplication.class, args);
	}

}
