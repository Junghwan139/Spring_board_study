package com.example.spring_board_study.s1_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface s1PostRepository extends JpaRepository<s1Post, Long> {

}
