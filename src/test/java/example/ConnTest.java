package example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { App.class })
public class ConnTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test2() throws Exception{
        System.out.println("--------\n");
        assertThat(dataSource).isNotNull();
        dataSource.getConnection();
        System.out.println("--------\n");
    }

}
