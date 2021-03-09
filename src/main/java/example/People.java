package example;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Setter
@Getter
public class People {
    private int id;
    private String name;
    private String sex;
    private Date date;
}
