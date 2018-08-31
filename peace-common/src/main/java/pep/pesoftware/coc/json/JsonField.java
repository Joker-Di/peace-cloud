package pep.pesoftware.coc.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonField {

    /**
     * 属性名称
     */
    String value();

    /**
     * 属性别名
     */
    String alias() default "";

    /**
     * 是否忽略
     */
    boolean ignore() default false;

    /**
     * 转换类的Bean名称
     */
    String convertBeanName() default "";

}
