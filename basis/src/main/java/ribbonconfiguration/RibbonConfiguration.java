package ribbonconfiguration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author running4light
 * @description 自定义配置
 *
 * 该配置类所处包路径，
 * 不能被@SpringbootApplication注解或@ComponentScan注解所扫描的路径所包含
 *
 * @createTime 2021/7/13 14:20
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
