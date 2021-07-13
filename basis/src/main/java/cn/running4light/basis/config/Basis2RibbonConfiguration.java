package cn.running4light.basis.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import ribbonconfiguration.RibbonConfiguration;

/**
 * @author running4light
 * @description 指定ribbonClient配置类
 * @createTime 2021/7/13 14:18
 */
@Configuration
@RibbonClient(name = "basis2", configuration = RibbonConfiguration.class)
public class Basis2RibbonConfiguration {


}
