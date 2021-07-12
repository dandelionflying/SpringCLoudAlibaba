package cn.running4light.basis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BasisApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasisApplication.class, args);
    }

    @Bean
    @LoadBalanced // 加上@LoadBanlanced注解，就可以直接用服务名称进行服务间通信，不需要再去获取hostport等信息
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
