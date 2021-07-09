package cn.running4light.learning;

import cn.running4light.learning.tests.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public User user1(){
        return new User("user1");
    }
//    @Primary
    @Bean
    public User user2(){
        return new User("user2");
    }

}
