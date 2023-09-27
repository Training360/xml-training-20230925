package hello;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping(produces = {"application/json", "application/xml"})
    public HelloResource getHello() {
        return new HelloResource("Hello %s".formatted(LocalDateTime.now().toString()));
    }

    @GetMapping("{id}")
    public HelloResource getHelloById(@PathVariable String id) {
        return new HelloResource("Hello %s".formatted(id));
    }
}
