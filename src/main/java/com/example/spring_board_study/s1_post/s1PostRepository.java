package com.example.spring_board_study.s1_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface s1PostRepository extends JpaRepository<s1Post, Long> {


    List<s1Post> findByAppointment(String appointment);

}
