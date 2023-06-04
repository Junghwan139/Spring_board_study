package com.example.spring_board_study.s1_author;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface s1AuthorRepository extends JpaRepository<s1Author, Long> {

    s1Author findByEmail(String email);





}
