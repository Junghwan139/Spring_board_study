package com.example.spring_board_study.s1_post.service;

import com.example.spring_board_study.s1_author.s1AuthorRepository;
import com.example.spring_board_study.s1_post.s1Post;
import com.example.spring_board_study.s1_post.s1PostRepository;
import com.example.spring_board_study.s1_post.s1PostRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class s1PostService {

    @Autowired
    s1PostRepository s1PoRepo;
    @Autowired s1AuthorRepository s1auRepo;

    // save
    public void s1_save(s1PostRequestDto post){


        String my_appointment = null;
        LocalDateTime my_appointment_time=null;
        if(post.getAppointment() !=null && !post.getAppointment_time().isEmpty()){

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime localDateTime = LocalDateTime.parse(post.getAppointment_time(),formatter);

            if(LocalDateTime.now().isBefore(localDateTime) == true){
                my_appointment_time=localDateTime;
                my_appointment="Y";
            }

        }

        s1Post post1 = s1Post.builder()
                        .title(post.getTitle())
                        .contents(post.getContents())
                        .author(s1auRepo.findByEmail(post.getEmail()))
                        .createDate(LocalDateTime.now())
                        .appointment(my_appointment)
                        .appointment_time(my_appointment_time)
                        .build();
        s1PoRepo.save(post1);
    }

    // find_all
    public List<s1Post> s1_findAll(){
        return s1PoRepo.findByAppointment(null);
    }

    // find_one
    public s1Post s1_findOne(Long id){
        return s1PoRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    // delete
    public void s1_delete(Long id){
        s1PoRepo.delete(this.s1_findOne(id));
    }

    // update
    public void s1_update(s1Post newPost, Long id){
        s1Post beforeToChange = this.s1_findOne(id);
        beforeToChange.setId(newPost.getId());
        beforeToChange.setContents(newPost.getContents());
        beforeToChange.setTitle(newPost.getTitle());
        s1PoRepo.save(beforeToChange);
    }


}
