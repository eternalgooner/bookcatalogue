
package com.bestbookz.com;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author x17135486
 */
@Path("/rest/")
public class BookResource {
	private static Logger LOGGER = Logger.getLogger(BookResource.class.getSimpleName());
    private BookService bookService = new BookService();
    
    @GET
    @Path("test/{param}")
    public Response sayHelloWorld(@PathParam("param") String message){
    	LOGGER.info("entering path api/test/" + "messageget");
        String output = "Hello " + message + "!";
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("books")
    @Produces(MediaType.APPLICATION_XML)
    public Response getAllBooks(){        
    	LOGGER.info("entering path api/rest/books");
    	List<Book> books = bookService.getAllBooks();
    	GenericEntity<List<Book>> entity = new GenericEntity<List<Book>>(books) {};
        return Response.ok().entity(entity).build();
    }
    
    @GET
    @Path("book/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getBook(@PathParam("id") int id) {
    	LOGGER.info("entering path api/rest/book/" + id);
    	Book book = bookService.getBook(id);
    	GenericEntity<Book> entity = new GenericEntity<Book>(book) {};
        return Response.ok().entity(entity).build();
    }
    
}
