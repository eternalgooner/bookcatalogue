package com.bestbookz;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author x17135486
 */
public class BookService {
    
    public static List<Book> bookList;
    private static Logger LOGGER = Logger.getLogger(BookService.class.getSimpleName());
    
    public List<Book> getAllBooks(){
    	LOGGER.info("entering getAllBooks()...");
    	bookList = new ArrayList<Book>();
        bookList.add(new Book(1, "test title1", "test author1", "test publisher1"));
        bookList.add(new Book(2, "test title2", "test author2", "test publisher2"));
        bookList.add(new Book(3, "test title3", "test author3", "test publisher3"));
        bookList.add(new Book(4, "test title4", "test author4", "test publisher4"));
        bookList.add(new Book(5, "test title5", "test author5", "test publisher5"));
        
        LOGGER.info("returning: " + bookList);
        return bookList;
    }
    
    public Book getBook(int id){
    	LOGGER.info("entering getBook()...ith id: " + id);
    	try {
    		return bookList.get(id - 1);
		} catch (Exception e) {
			LOGGER.warning("** no book found **");
			return null;
		}        
    }    
}
