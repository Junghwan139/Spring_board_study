package com.example.spring_board_study.s1_author.service;

import com.example.spring_board_study.s1_author.s1Author;
import com.example.spring_board_study.s1_author.s1AuthorRepository;
import com.example.spring_board_study.s1_author.s1AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;

@Service
public class s1AuthorService implements UserDetailsService {

    @Autowired
    s1AuthorRepository s1auRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 저장
    public void save(s1AuthorRequestDto author){
        s1Author author1 = s1Author.builder()
                .name(author.getName())
                .email(author.getEmail())
                .role(author.getRole())
                .password(passwordEncoder.encode(author.getPassword()))
                .build();
        s1auRepo.save(author1);
    }

    // 전체 조회
    public List<s1Author> findAll(){
        return s1auRepo.findAll();
    }

    // 한건 조회
    public s1Author findByid(Long id){
        return s1auRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    // 업데이트
    public void update(s1AuthorRequestDto author){

        s1Author author1 = this.findByid(Long.parseLong(author.getId()));
        author1.setName(author.getName());
        author1.setPassword(author.getPassword());

        s1auRepo.save(author1);
    }

    // 삭제
    public void delete(Long id){
        s1auRepo.delete(this.findByid(id));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        s1Author author = s1auRepo.findByEmail(username);
        if(author==null){
        }
        return new User(author.getEmail(), author.getPassword(), Collections.emptyList());
    }


}
