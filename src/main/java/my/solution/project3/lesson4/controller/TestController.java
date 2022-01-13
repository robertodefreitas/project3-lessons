package my.solution.project3.lesson4.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test(){
        return "[PROJECT-3] [LESSON-2] <br>Data Structures and Persistence are pretty good.";
    }
}
