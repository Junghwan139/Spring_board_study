package com.example.spring_board_study.s1_post.service;

import com.example.spring_board_study.s1_post.s1Post;
import com.example.spring_board_study.s1_post.s1PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class s1PostSchduler {

    @Autowired s1PostRepository s1PostRepository;

    @Scheduled(cron="0/30 * * * * *")
    public void postSchedule(){

        System.out.println("스케쥴러 입니다.");

       List<s1Post> posts = s1PostRepository.findByAppointment("Y");

       for(s1Post a : posts){

           if(LocalDateTime.now().isAfter(a.getAppointment_time()) == true){
               a.setAppointment(null);
               s1PostRepository.save(a);
           }
       }


    }



}
