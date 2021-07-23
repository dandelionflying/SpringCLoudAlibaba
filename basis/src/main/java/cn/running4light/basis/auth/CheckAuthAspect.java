package cn.running4light.basis.auth;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author running4light
 * @description 定义用于登录校验的切面
 * @createTime 2021/7/22 18:55
 */
@Aspect
@Component
public class CheckAuthAspect {
    private Logger logger = LoggerFactory.getLogger(CheckAuthAspect.class);
    /**
     * @Description 登录校验
     * @Author running4light朱泽雄
     * @CreateTime 12:24 2021/7/23
     * @Return
     */
    @Around("@annotation(cn.running4light.basis.auth.CheckLogin)")
    public Object checkLogin(ProceedingJoinPoint point) throws Throwable {
        checkToken();
        // 放行
        return point.proceed();
    }
    /**
     * @Description token校验
     * @Author running4light朱泽雄
     * @CreateTime 12:24 2021/7/23
     * @Return
     */
    private void checkToken() {
        logger.info("登录校验中。。。。");
        // 从header获取token
        HttpServletRequest request = getHttpServletRequest();
        String token = request.getHeader("token");
        String role = request.getHeader("role");// 模拟权限测试用

        // 校验token  这里简单测试一下
        if(!"test".equals(token)){
            logger.error("token不合法");
            throw new SecurityException("token不合法");
        }
        request.setAttribute("userInfo","zzx");
        request.setAttribute("role", role);
    }
    /**
     * @Description 获取request
     * @Author running4light朱泽雄
     * @CreateTime 15:17 2021/7/23
     * @Return
     */
    private HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        return attributes.getRequest();
    }
    /**
     * @Description 权限校验
     * @Author running4light朱泽雄
     * @CreateTime 15:16 2021/7/23
     * @Return
     */
    @Around("@annotation(cn.running4light.basis.auth.CheckAuth)")
    public Object checkAuth(ProceedingJoinPoint point) throws Throwable {
        try {
            checkToken();
            HttpServletRequest request = getHttpServletRequest();
            String role = (String) request.getAttribute("role");
            // 实际需要通过jwt获取claim  拿到权限信息
            MethodSignature signature = (MethodSignature)point.getSignature();
            Method method = signature.getMethod();
            CheckAuth annotation = method.getAnnotation(CheckAuth.class);
            String value = annotation.value();
            if (!StringUtils.equals(value,role))
                throw new SecurityException("Access fail");
        } catch (Throwable throwable) {
            throw new SecurityException("Access fail", throwable);
        }
        logger.info("Access Success");
        return point.proceed();
    }
}
