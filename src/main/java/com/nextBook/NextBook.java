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

    @Path("/search")
    @POST
    @Produces("text/plain")
    // Note I did not do all validation for these parameters, just the minimum
    public Response searchDatabase (
            @FormParam("bookTitle") String bookTitle,
            @FormParam("bookId") String bookId
    ) {
        //String test = "Hello";
        if (bookTitle != null && !bookTitle.isEmpty()) {
            String output = queryBookByTitle(bookTitle, "\n");
            return Response.status(200).entity(output).build();
        } else if (bookId != null && !bookId.isEmpty()) {
            // Convert to int
            int id = Integer.parseInt(bookId);
            String output = queryBookById(id);
            return Response.status(200).entity(output).build();
        }

        return Response.status(200).entity("The search failed, please try again").build();
    }

    private String queryBookByTitle(String title, String lineBreak) {

        BookDAO getBooks = new BookDAO();

        List<Book> results = getBooks.findBookByTitle(title);

        if (results == null) {
            return "No books matching the search results were found";
        }
        String output = "The following books matched your request" + lineBreak;

        for (Book book: results) {
            output += book.toString() + lineBreak;
        }

        return output;
    }


    private String queryBookById(int id) {
        BookDAO getBooks = new BookDAO();
        Book book = getBooks.getBook(id);
        if (book == null) {
            return "No Search results for that ID";
        }
        return "The following results matched your query + \n" + book.toString();
    }
}
