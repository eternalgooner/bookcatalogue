
package com.bestbookz;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.research.ws.wadl.Request;

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
    	if (book != null) {
    		LOGGER.info("book found, returning book");
    		GenericEntity<Book> entity = new GenericEntity<Book>(book) {};
            return Response.ok().entity(entity).build();
		}else {
			LOGGER.info("no book found, return error message");
			ErrorResponse errorResponse = new ErrorResponse("there is no book with id " + id + " available");
			GenericEntity<ErrorResponse> entity = new GenericEntity<ErrorResponse>(errorResponse) {};
			return Response.ok().entity(entity).build();
		}    	
    }
    
    @POST
    @Path("book/create")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response createBook(String request) {
    	LOGGER.info("request received: " + request);
    	Book book = ConvertXmlToBook.convertToBook(request.toString());
    	GenericEntity<Book> entity = new GenericEntity<Book>(book) {};
        return Response.ok().entity(entity).build();
    }
    
}
