package ai.miko.filedatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.miko.filedatabase.service.FileService;

@RestController
@RequestMapping("/filedatabase")
public class FileController {
    @Autowired
    FileService service;
    @PostMapping("/process")
    public String index(@RequestBody String code) {
        return service.process(code);
    }
    
}
