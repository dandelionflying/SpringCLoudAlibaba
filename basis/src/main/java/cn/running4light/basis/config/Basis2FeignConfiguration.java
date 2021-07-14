package cn.running4light.basis.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author running4light
 * @description Feign自定义配置
 * @createTime 2021/7/14 15:51
 */
//@Configuration 加上这个会有父子上下文问题
public class Basis2FeignConfiguration {
    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
