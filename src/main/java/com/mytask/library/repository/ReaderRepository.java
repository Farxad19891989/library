package com.mytask.library.repository;


import com.mytask.library.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader,Integer> {

    Reader findByName(String readername);

}
