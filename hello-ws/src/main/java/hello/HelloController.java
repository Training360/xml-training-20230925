package hello;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    public HelloResource getHello() {
        return new HelloResource("Hello %s".formatted(LocalDateTime.now().toString()));
    }

}
