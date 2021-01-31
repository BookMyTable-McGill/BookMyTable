package bookmytable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
@EnableJpaRepositories
public class BookMyTableApplication {

   public static void main(String[] args) {
       SpringApplication.run(BookMyTableApplication.class, args);
   }
}
