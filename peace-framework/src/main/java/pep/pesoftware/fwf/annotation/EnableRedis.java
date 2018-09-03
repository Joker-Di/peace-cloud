package pep.pesoftware.fwf.annotation;

import org.springframework.context.annotation.Import;
import pep.pesoftware.fwf.springextend.RedisBeanRegistry;

import java.lang.annotation.*;

/**
* 开启Redis
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(RedisBeanRegistry.class)
public @interface EnableRedis {
    String name();
}
