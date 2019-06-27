package resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Marcus
 * @Date: 2019/6/27 13:55
 * @Version 1.0
 */
@SpringBootApplication
public class ResourceApplication {
  public static void main(String[] args) {
      SpringApplication.run(ResourceApplication.class,args);
  }
}
