/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bestbookz.com;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author x17135486
 */
@Path("/api")
public class Tester {
    
    BookService bookService = new BookService();
    
    @GET
    @Path("/test/{param}")
    public Response sayHelloWorld(@PathParam("param") String message){
        String output = "Hello " + message + "!";
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/rest/books")
    @Produces(MediaType.APPLICATION_XML)
    public List getAllBooks(){        
        return bookService.getAllBooks();
    }
    
}
