package cn.running4light.basis2.auth;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author running4light
 * @description 定义用于登录校验的切面
 * @createTime 2021/7/22 18:55
 */
@Aspect
@Component
public class CheckLoginAspect {
    private Logger logger = LoggerFactory.getLogger(CheckLoginAspect.class);
    @Around("@annotation(cn.running4light.basis2.auth.CheckLogin)")
    public Object checkLogin(ProceedingJoinPoint point) throws Throwable {
        logger.info("登录校验中。。。。");
        // 从header获取token
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("token");

        // 校验token  这里简单测试一下
        if(!"test".equals(token)){
            logger.error("token不合法");
            throw new SecurityException("token不合法");
        }
        request.setAttribute("userInfo","zzx");
        // 放行
        return point.proceed();
    }
}
