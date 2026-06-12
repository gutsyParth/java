package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping("/welcome")
    public String welcome(
            @RequestParam(defaultValue = "Guest") String name) {

        return "Welcome " + name;
    }

    @GetMapping("/user1")
    public String user(
            @RequestParam String name,
            @RequestParam int age) {

        return "Name: " + name + ", Age: " + age;
    }

    @GetMapping("/service")
    public String serviceGreeting() {
        return greetingService.greet("Parth");
    }


    @GetMapping("/greeting")
    public Greeting greeting(
            @RequestParam(defaultValue = "World") String name) {

        return new Greeting(
                counter.incrementAndGet(),
                template.formatted(name));
    }

    @GetMapping("/about")
    public String about() {
        return "My first Spring Boot API";
    }

    @GetMapping("/age")
    public int age() {
        return 25;
    }

    @GetMapping("/user")
    public Greeting user() {
        return new Greeting(100, "Parth");
    }

    @GetMapping("/hello/{name}")
    public Greeting hello(@PathVariable String name) {

        return new Greeting(
                counter.incrementAndGet(),
                "Hello " + name);
    }

    @PostMapping("/create")
    public Greeting create() {

        return new Greeting(
                counter.incrementAndGet(),
                "Created Successfully");
    }
}