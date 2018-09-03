package pep.pesoftware.fwf.annotation;

import org.mybatis.spring.annotation.MapperScan;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MapperScan(basePackages = "pep.pesoftware.fwf.repository.mapper")
public @interface EnableDB {
}
