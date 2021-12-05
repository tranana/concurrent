package pres.tran.underlying;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pres.tran.underlying.*.dao")
public class ConcurrentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcurrentApplication.class);
    }

}
