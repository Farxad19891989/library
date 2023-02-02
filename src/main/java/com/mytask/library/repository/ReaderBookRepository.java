package com.mytask.library.repository;


import com.mytask.library.model.BookSum;
import com.mytask.library.model.ReaderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReaderBookRepository extends JpaRepository<ReaderBook,Integer> {
    @Query("select b.bookname from Book b join fetch ReaderBook rb  on b.ISBN=rb.book.ISBN where rb.bookTaken='TAKEN' and rb.reader.fin=:fin")
    Object[] findReaderBooksByFin(@Param("fin") int fin);


    @Query("select sum(rb.count) from ReaderBook rb  where rb.bookTaken='TAKEN' and  rb.date>=:date1 and rb.date<=:date2")
    Object findTakenBookCount(@Param("date1") LocalDate date1,@Param("date2") LocalDate date2);

    @Query("select sum(rb.count) from ReaderBook rb  where rb.bookTaken='RETURNED' and  rb.date>=:date1 and rb.date<=:date2")
    Object findReturnedBookCount(@Param("date1") LocalDate date1,@Param("date2") LocalDate date2);

    @Query("select new com.mytask.library.model.BookSum(b.authorName,sum(rb.count)) from ReaderBook rb join fetch Book b on rb.book.ISBN = b.ISBN\n" +
            "where rb.bookTaken='TAKEN' group by b.authorName")
    List<BookSum> findMostReadBook();
}


