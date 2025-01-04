package com.karan.prctice.Controller;

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataRestController {
    @GetMapping("/getData")
    @ResponseBody
    public String get() {
        return "here";
    }

    @PostMapping("/postData")
    @ResponseBody
    public String post() {
        return "postData";
    }

    @PutMapping("/putData")
    @ResponseBody
    public String put() {
        return null;
    }

    @DeleteMapping("/deleteData")
    @ResponseBody
    public String delete() {
        return null;
    }
    
}
