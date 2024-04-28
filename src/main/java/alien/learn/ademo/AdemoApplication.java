package alien.learn.ademo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "alien.learn.ademo.mapper")
public class AdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdemoApplication.class, args);
	}

}
