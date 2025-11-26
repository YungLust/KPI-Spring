package org.example.lab1webapplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MembersController {

    @GetMapping({"/isaac"})
    public String isaacMember(){
        return "isaac-member-page.html";
    }
    @GetMapping({"/magdalene"})
    public String magdaleneMember(){
        return "magdalene-member-page.html";
    }
    @GetMapping({"/cain"})
    public String cainMember(){
        return "cain-member-page.html";
    }
    @GetMapping({"/judas"})
    public String judasMember(){
        return "judas-member-page.html";
    }

}
