package com.example.spring_board_study.s1_post.controller;

import com.example.spring_board_study.s1_author.s1Author;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
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


}
