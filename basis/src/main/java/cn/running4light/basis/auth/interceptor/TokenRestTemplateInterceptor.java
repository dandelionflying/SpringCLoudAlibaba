package cn.running4light.basis.auth.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author running4light
 * @description 针对RestTemplate的token拦截器
 * @createTime 2021/7/23 11:44
 */
public class TokenRestTemplateInterceptor implements ClientHttpRequestInterceptor {
    private Logger logger = LoggerFactory.getLogger(TokenRestTemplateInterceptor.class);
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logger.info("token转发ing");
        // 获取token
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest httpRequest = attributes.getRequest();
        String token = httpRequest.getHeader("token");
        request.getHeaders().add("token", token);

        // 保证请求继续执行（保证其他拦截器正常执行）
        return execution.execute(request, body);
    }
}
