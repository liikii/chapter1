package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleCtrl {
    @Autowired
    private PeopleService peopleService;

    @GetMapping("/people")
    public People findOne(){
        return peopleService.findOne();
    }
}
