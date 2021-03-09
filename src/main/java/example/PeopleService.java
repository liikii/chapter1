package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    @Autowired
    private PeopleMapper peopleMapper;

    public People findOne(){
        return peopleMapper.findOne();
    };

    public People findByName(){
        return peopleMapper.findOne();
    }
}
