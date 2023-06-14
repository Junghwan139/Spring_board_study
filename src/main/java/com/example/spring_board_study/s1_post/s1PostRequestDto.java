package com.example.spring_board_study.s1_post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class s1PostRequestDto {

    private String id;
    private String title;
    private String contents;
    private String email;
    private String appointment;
    private String appointment_time;

}
