package com.example.spring_board_study.s1_author;

import com.example.spring_board_study.s1_author.service.s1AuthorService;
import com.example.spring_board_study.s1_post.s1Post;
import com.example.spring_board_study.s1_post.service.s1PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class s1AuthorController {

    @Autowired
    s1AuthorService s1sv;
    @Autowired s1PostService s1posv;


    //home
    @GetMapping("s1_home")
    public String s1_home(){
        return "s1/s1_home";
    }

    //save_Get
    @GetMapping("s1_save")
    public String s1_save_g(){
        return "s1/s1_author_register";
    }

    //save_Post
    @PostMapping("s1_save")
    public String s1_save_p(s1AuthorRequestDto author){
        s1sv.save(author);
        return "redirect:/s1_authors";
    }

    // find_all
    @GetMapping("s1_authors")
    public String s1_authors(Model model){
        model.addAttribute("authorList",s1sv.findAll());
        return "s1/s1_author_list";
    }

    // find_one
    @GetMapping("s1_author")
    public String s1_author(@RequestParam(value = "id")Long myid,Model model){
        s1Author author1 = s1sv.findByid(myid);
        model.addAttribute("author",author1);

        int count = 0;
        for(s1Post a : s1posv.s1_findAll()){
            if(a.getAuthor().getId() == author1.getId()){
                count++;
            }
        }
        System.out.println(count);

        return "s1/s1_author_detail";
    }

    // delete
    @GetMapping("s1_author_delete")
    public String s1_author_delete(@RequestParam(value = "id")Long myid){
        s1sv.delete(myid);
        return "redirect:/s1_authors";
    }

    // update
    @PostMapping("s1_author_update")
    public String s1_author_update(s1AuthorRequestDto author){
        s1sv.update(author);
        return "redirect:/s1_authors";
    }

/*

    @GetMapping("s1_author_login")
    public String authorlogin(){
        return "s1/login";
    }

*/




}
