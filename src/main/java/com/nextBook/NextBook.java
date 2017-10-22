package com.nextBook;
import next_book_web_scrapper.database.BookDAO;
import next_book_web_scrapper.entity.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/info")
public class NextBook {

    @GET
    @Produces("text/html")
    public Response helloWorld() {
        String output = "Hello World";
        return Response.status(200).entity(output).build();
    }

    @Path("/title")
    @GET
    @Produces("text/html")
    public Response queryDatabase(
            @QueryParam("bookTitle") String bookTitle) {

        if (bookTitle == null || bookTitle.isEmpty()) {
            String badInput = "The request sent was not good, try again";
            return Response.status(200).entity(badInput).build();
        }

        BookDAO getBooks = new BookDAO();

        List<Book> results = getBooks.findBookByTitle(bookTitle);

        String output = "The following books matched the results <br/>";

        for (Book book: results) {
            output  += book.toString() + "<br/>";
        }


        return Response.status(200).entity(output).build();
    }
}
