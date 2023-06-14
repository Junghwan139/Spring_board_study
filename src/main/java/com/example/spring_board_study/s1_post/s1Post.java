package com.example.spring_board_study.s1_post;

import com.example.spring_board_study.s1_author.s1Author;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class s1Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String title;

    @Column
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,name="author_id")
    private s1Author author;

    @Column
    private LocalDateTime createDate;

    private String appointment;

    private LocalDateTime appointment_time;


    @Builder
    s1Post(String title, String contents, s1Author author, LocalDateTime createDate,String appointment, LocalDateTime appointment_time){

        this.title=title;
        this.contents=contents;
        this.author=author;
        this.createDate=createDate;
        this.appointment=appointment;
        this.appointment_time=appointment_time;



    }






}
