package cn.running4light.basis.auth;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author running4light
 * @description 权限验证
 * @createTime 2021/7/23 12:18
 */
@Documented
@Target({METHOD})
@Retention(RUNTIME)
public @interface CheckAuth {
    String value() default "";
}
