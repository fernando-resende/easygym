package personal.project.easygym.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("${api-prefix}/status")
    public ResponseEntity<String> statu() {
        return ResponseEntity.ok("online");
    }

}

