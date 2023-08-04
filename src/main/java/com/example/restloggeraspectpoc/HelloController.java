package com.example.restloggeraspectpoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class HelloController {

    @GetMapping("{is}")
    public void getMethod(@PathVariable String is) {
        return;
    }

    @PostMapping
    public void postMethod(@RequestBody Object body) {
        return;
    }

    @PutMapping
    public void putMethod() {
        return;
    }

    @DeleteMapping
    public void deleteMethod() {
        return;
    }
}
