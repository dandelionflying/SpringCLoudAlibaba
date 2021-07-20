package cn.running4light.basis.web.feigns.fallbacks;

import cn.running4light.basis.web.feigns.Basis2Web;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author running4light
 * @description feign整合sentinel 用于获取异常信息
 * @createTime 2021/7/20 11:21
 */
@Component
public class Basis2FeignClientFallBackFactory implements FallbackFactory<Basis2Web> {
    private Logger logger = LoggerFactory.getLogger(Basis2FeignClientFallBackFactory.class);
    @Override
    public Basis2Web create(Throwable cause) {

        return new Basis2Web() {
            @Override
            public String findBasis2() {
                logger.warn("发生限流", cause);
                return "发生限流";
            }
        };
    }
}
