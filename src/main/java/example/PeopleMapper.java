package example;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PeopleMapper {
    @Select("SELECT id, name, sex, `date` FROM people limit 1")
    People findOne();

    @Select("SELECT id, name, sex, `date` FROM people WHERE name = #{name} limit 1")
    People findByName(@Param("name") String state);
}
