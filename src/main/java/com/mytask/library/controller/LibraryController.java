package com.mytask.library.controller;

import com.mytask.library.ClientInterface.PopularBooks;
import com.mytask.library.DTO.*;
import com.mytask.library.model.Book;
import com.mytask.library.model.Reader;
import com.mytask.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/books/")

public class LibraryController {

    @Autowired
    private PopularBooks popularBooks;

    private final BookService bookService;

    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/addreader")
    public void AddReader(@RequestBody ReaderRequest readerRequest){
        bookService.addReader(readerRequest);
    }

    @PostMapping ("/login")
    public ResponseEntity<String> loginLibrerian(@RequestBody LoginRequest loginRequest){
       return ResponseEntity.ok(bookService.loginLibrerian(loginRequest));

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerLibrerian(@RequestBody RegisterRequest registerRequest){
       return ResponseEntity.ok(bookService.registerLibrerian(registerRequest));

    }

    @PostMapping("/addcategory")
    public void addCategory(@RequestBody CategoryDTO categoryDTO){

        bookService.addCategory(categoryDTO);

    }

    @PostMapping("/addbook")
    public void addBook(@RequestBody BookRequestDTO bookRequestDTO){
        bookService.addBook(bookRequestDTO);
    }

    @GetMapping("/findbook")
    public ResponseEntity<Book> findByISBN(@RequestParam Integer id){
        return new ResponseEntity<>(bookService.findByISBN(id), HttpStatus.OK);
    }

    @GetMapping("/findcategory")
    public ResponseEntity<List<Object[]>> findByCategory(@RequestParam String category){
        return new ResponseEntity<>(bookService.findByCategory(category),HttpStatus.OK);
    }

    @PutMapping("/stockupdate")
    public void updateBookStock(@RequestBody BookStockRequest bookStockRequest){
         bookService.updateBookStock(bookStockRequest);
    }

    @PostMapping("/booktransaction")
    public ResponseEntity<String> BookTran(@RequestBody TakeBookRequest takeBookRequest){
      return   ResponseEntity.ok(bookService.BookTran(takeBookRequest));

    }

    @GetMapping("/{fin}")
    public ResponseEntity<Object[]> getBooksByReaderFin(@PathVariable int fin){
       return new ResponseEntity(bookService.getBooksByReaderFin(fin),HttpStatus.OK);
    }

    @GetMapping("/takenBooksByPeriod")
    public ResponseEntity<Object> findTakenBookCount(@RequestParam("date1") String date1,
                                                      @RequestParam("date2") String date2){
        return new ResponseEntity(bookService.findTakenBookCount(date1,date2),HttpStatus.OK);
    }

    @GetMapping("/returnedBooksByPeriod")
    public ResponseEntity<Object> findReturnedBookCount(@RequestParam("date1") String date1,
                                                     @RequestParam("date2") String date2){
        return new ResponseEntity(bookService.findReturnedBookCount(date1,date2),HttpStatus.OK);
    }

    @GetMapping("/mostreadbook")
    public ResponseEntity<List<MaxReadedBooks>> findMostReadBook(){
       return new  ResponseEntity(bookService.findMostReadBook(),HttpStatus.OK);

    }

    @GetMapping("/getpopular")
    public ResponseEntity<PopularBooksResponse> getPopularBooks(@RequestParam String q){
         return new  ResponseEntity(popularBooks.getPopularBooks(q),HttpStatus.OK);
    }


    @GetMapping("/getReaders")
    public ResponseEntity<List<Reader>> getAllReaders(){
        return new ResponseEntity<>(bookService.getAllReaders(),HttpStatus.OK);
    }
}



