package io.rooftophero.mybatiscase.api;

import org.apache.tomcat.jni.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HomeApiController {

    @GetMapping("/hello")
    public ResponseEntity<?> home(Local local) {
        LocalDateTime now = LocalDateTime.now();
        String hello = "Hello, world! " + now;
        return ResponseEntity.ok().body(hello);
    }
}
