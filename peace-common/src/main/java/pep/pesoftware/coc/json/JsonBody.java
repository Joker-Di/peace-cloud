package pep.pesoftware.coc.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonBody {

    /**
     * 返回值封装在data类的属性名称，比如控制层返回值为1，需要返回客户端为{ data: { id : 1 }}，这时value需要配置为"id"
     *
     */
    String value() default "";

    /**
     * 属性组配置
     *
     * <pre>
     *  <ul>
     *    属性筛选模式：根据有没有明确指定需要序列化的属性分成如下两种
     *   <li>1.否定模式：没有指定任意一个需要序列化的属性，就进入否定模式，也即只要没有忽略，就输出
     *   <li>2.肯定模式：只要有一个明确指定需要序列化的属性，就进入肯定模式，也即只有被明确指定需要序列化的属性才会输出
     *   <li>属性别名的配置不影响属性筛选模式，但会隐式表示需要输出该属性
     *  </ul>
     *  <ul>
     *    配置方式：同一属性多次配置以前面的为准
     *   <li>1.property或property#1或property#true 配置属性名称
     *   <li>2.property#false或property#0 表示忽略属性
     *   <li>3.property#alias 表示将属性property使用别名alias输出，隐式表示是需要输出，但不影响属性筛选模式
     *  </ul>
     * </pre>
     *
     */
    String[] fields() default {};

    /**
     * 使用@JsonField注解配置属性组，优先级整体比value要高，但同一属性多次配置以前面的为准
     *
     */
    JsonField[] jsonFields() default {};

    /**
     * 是否使用Spring的Jackson封装
     *
     */
    boolean springJackson() default true;

    /**
     * 返回码的属性名称，为空表示不添加
     *
     */
    String codePropertyName() default "code";

    /**
     * 返回描述的属性名称，为空表示不添加
     *
     */
    String messagePropertyName() default "message";

    /**
     * 返回值的属性名称，为空表示不添加
     *
     */
    String valuePropertyName() default "data";

    /**
     * 返回状态的属性名称，为空表示不添加
     *
     */
    String statusPropertyName() default "success";

}
