package example;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class App {

    //
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    // curl -vkX GET -F 's=QUERY' http://127.0.0.1:8080/test_query
    @GetMapping("/test_query")
    HashMap<String, String>  test_query(@RequestParam(value = "s", defaultValue = "") String s){
        HashMap<String, String> map = new HashMap<>();
        map.put("get query parameter s:", s);
        return map;
    }

    // curl -vkX POST -F 's=cn' http://127.0.0.1:8080/test_post_form
    @PostMapping("/test_post_form")
    HashMap<String, String>  test_post_form(@RequestParam(value = "s", defaultValue = "") String s){
        HashMap<String, String> map = new HashMap<>();
        map.put("post query parameter s:", s);
        return map;
    }

    // curl -vkX POST --header "Content-Type: application/json" http://127.0.0.1:8080/test_post_json -d '{"user_id": 888, "token": "xxx"}'
    @PostMapping("/test_post_json")
    HashMap<String, String>  test_post_json(@RequestBody(required = false) String bd){
        if (bd == null){
            HashMap<String, String> map = new HashMap<>();
            map.put("post query parameter s:", " empty body");
            return map;
        }
        System.out.println("----------> " + bd.toString() + " <---\n");
        HashMap<String, String> map = new HashMap<>();
        map.put("post query parameter s:", " just test");
        return map;
    }

    // curl -vkX GET http://127.0.0.1:8080/test_json
    @GetMapping("/test_json")
    ResObject test_json() {
        return new ResObject(3, "return json");
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
