package com.example.spring_board_study.author.repository;

import com.example.spring_board_study.author.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

//    findByA라는 규칙으로 jpa에서는 자동으로 where 조건문으로 a를 사용하게 된다.
//    findByAandB : A와 B를 and조건으로 where문에서 조회할 때 사용
    Author findByEmail(String myEmail);

}
