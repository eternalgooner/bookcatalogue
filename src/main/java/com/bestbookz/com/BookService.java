/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bestbookz.com;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author x17135486
 */
public class BookService {
    
    public static List<Book> bookList = new ArrayList();
    
    public List<Book> getAllBooks(){
        bookList.add(new Book(1, "test title1", "test author1", "test publisher1"));
        bookList.add(new Book(2, "test title2", "test author2", "test publisher2"));
        bookList.add(new Book(3, "test title3", "test author3", "test publisher3"));
        bookList.add(new Book(4, "test title4", "test author4", "test publisher4"));
        bookList.add(new Book(5, "test title5", "test author5", "test publisher5"));
        
        return bookList;
    }
    
    public Book getBook(int id){
        return bookList.get(id - 1);
    }
    
}
