package cn.running4light.basis.auth;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
    @Around("@annotation(cn.running4light.basis.auth.CheckLogin)")
    public Object checkLogin(ProceedingJoinPoint point) throws Throwable {
        System.err.println("进来了。。。。。");
        // 从header获取token
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("token");

        // 校验token  这里简单测试一下
        if(!"test".equals(token)){
            throw new SecurityException("token不合法");
        }
        request.setAttribute("userInfo","zzx");
        // 放行
        return point.proceed();
    }
}
