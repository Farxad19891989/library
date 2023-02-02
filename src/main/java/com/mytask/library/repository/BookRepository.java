package com.mytask.library.repository;


import com.mytask.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
   @Query("select b.bookname,b.authorName,b.count from Book b join fetch Category c  on c.id=b.category.id where c.category_name=:category")
   List<Object[]> findAllByCategory_Category_name(@Param("category") String category);

  // @Query("select b.bookname,b.authorName,b.count from Book b join fetch Category c  where c.id=b.category.id and c.category_name=:category")
   Book findBookByBookname(String bookname);


}
