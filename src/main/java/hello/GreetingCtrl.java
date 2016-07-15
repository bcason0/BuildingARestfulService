package hello;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingCtrl {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong(); //a long value that may be updated atomically doesn't replace
    //Long

    //ensures that the http requests to /greeting are mapped to the greeting method
    //RequestMapping maps all HTTP operations by default. you would use @RequestMapping(method=GET) to narrow mapping
    @RequestMapping("/greeting")
    //RequestParam binds the value of the query string parameter name into the name parameter of the greeting()
    //if value is false the the default value is used.
    //creates and returns a new Greeting object with id and content attributes based on the next value from the counter
    //then formats the given name by using the greeting template.
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
