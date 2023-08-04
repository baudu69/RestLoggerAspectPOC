package com.example.restloggeraspectpoc.pack1.pack2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api2")
@Slf4j
public class Hello2Controller {

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
