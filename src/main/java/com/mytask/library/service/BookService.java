package com.mytask.library.service;


import com.mytask.library.DTO.*;
import com.mytask.library.exception.*;
import com.mytask.library.model.*;
import com.mytask.library.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final ReaderBookRepository readerBookRepository;

    private final UserRepository userRepository;


    public BookService(CategoryRepository categoryRepository, BookRepository bookRepository,
                       ReaderRepository readerRepository,
                       ReaderBookRepository readerBookRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
        this.readerBookRepository = readerBookRepository;
        this.userRepository = userRepository;
    }

    public void addCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategory_name(categoryDTO.getCategory_name());
        categoryRepository.save(category);
    }

    public void addBook(BookRequestDTO bookRequestDTO) {
        Book book = new Book();
        book.setBookname(bookRequestDTO.getBookname());
        book.setAuthorName(bookRequestDTO.getAuthorName());
        book.setCount(bookRequestDTO.getCount());

        Category category = new Category();
        category = categoryRepository.findById(bookRequestDTO.getCategory_id()).get();
        book.setCategory(category);

        bookRepository.save(book);
        //    categoryRepository.save(category);
//        List<Book> bookList=new ArrayList<>();
//        bookList.add(book);
//       ;
//        category.setAllBooks(bookList);
//        //book.setCategory(category);


    }

    public Book findByISBN(Integer id) {

        Optional<Book> book = bookRepository.findById(id);
        if (book.isEmpty()) {
            throw new BookNotFoundException("Kitab tapilmaldi");
        } else {
            return book.get();
        }

    }

    public List<Object[]> findByCategory(String category) {
        return bookRepository.findAllByCategory_Category_name(category);
    }

    public void updateBookStock(BookStockRequest bookStockRequest) {

        int id = bookStockRequest.getId();
        Book book = bookRepository.findById(id).get();
        book.setCount(bookStockRequest.getCount());
        bookRepository.save(book);

    }

    public String BookTran(TakeBookRequest takeBookRequest) {
        Book book = bookRepository.findBookByBookname(takeBookRequest.getBookname());
        Optional<Reader> reader = readerRepository.findById(takeBookRequest.getReaderfin());
        int count = takeBookRequest.getCount();
        BookTaken bookTaken = takeBookRequest.getBookTaken();

        Book bookforUpdate = bookRepository.findById(book.getISBN()).get();

        if (count > bookforUpdate.getCount() && bookTaken != BookTaken.RETURNED) {
            throw new NotEnoughBookException("Stokda kifayyet qeder bu kitabdan yoxdu");
        } else if (reader.isEmpty()) {
            throw new ReaderNotFoundException("Bu finle istefadece tapilmadi");
        } else {
            if (bookTaken == BookTaken.TAKEN) {
                bookforUpdate.setCount(bookforUpdate.getCount() - count);
            } else {
                bookforUpdate.setCount(bookforUpdate.getCount() + count);
            }
        }


        bookRepository.save(bookforUpdate);

        ReaderBook readerBook = new ReaderBook();
        readerBook.setBook(book);
        readerBook.setReader(reader.get());
        readerBook.setCount(count);
        readerBook.setBookTaken(bookTaken);
        readerBook.setDate(LocalDate.now());

        readerBookRepository.save(readerBook);
        return "Emeliyet ugurla kecdi";


    }

    public Object[] getBooksByReaderFin(int fin) {
        return readerBookRepository.findReaderBooksByFin(fin);
    }

    public Object findTakenBookCount(String date1, String date2) {
        return readerBookRepository.findTakenBookCount(LocalDate.parse(date1), LocalDate.parse(date2));
    }

    public Object findReturnedBookCount(String date1, String date2) {
        return readerBookRepository.findReturnedBookCount(LocalDate.parse(date1), LocalDate.parse(date2));
    }

    public List<MaxReadedBooks> findMostReadBook() {
        List<BookSum> bookSums = readerBookRepository.findMostReadBook();
        List<MaxReadedBooks> maxReadedBooks=new ArrayList<>();
        long max = 0;
        String maxNameAuthor = "";
        for (BookSum bookSum : bookSums) {
            if (bookSum.getCount() >=max) {
                max = bookSum.getCount();
            }
        }

        for(BookSum bookSum: bookSums){
            if(bookSum.getCount()==max){
                maxReadedBooks.add(new MaxReadedBooks(bookSum.getAuthor_name()));
            }
        }

        return maxReadedBooks;

    }

    public String registerLibrerian(RegisterRequest registerRequest) {
        if (userRepository.findByFin(registerRequest.getFin()).isPresent()) {
            throw new LibreriianAlreadyExist("Bu finle kitabxanaci artiq movcuddur");
        } else {
            User user = new User();
            user.setFirstname(registerRequest.getFirstname());
            user.setLastname(registerRequest.getLastname());
            user.setFin(registerRequest.getFin());
            user.setPassword(registerRequest.getPassword());
            userRepository.save(user);
            return "Emeliiyet ugurla kecdi";
        }
    }

    public String loginLibrerian(LoginRequest loginRequest) {
        if (userRepository.findByFin(loginRequest.getFin()).isPresent()
             && (userRepository.findByFin(loginRequest.getFin()).get().getPassword()
                        .equals(loginRequest.getPassword()))) {
            return "Sistema ugurla daxil olduz";
        }else
            {
               throw  new WrongCredintialsException("Fin yada Shifre duzgun qeyd olunmuyub");
            }

    }

    public void addReader(ReaderRequest readerRequest) {

        Reader reader=new Reader();
        reader.setName(readerRequest.getReaderName());
        readerRepository.save(reader);
    }

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }
}

