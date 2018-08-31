package pep.pesoftware.fwf.util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * Bean操作类
 */
public class PeaceBeanUtils {

    /**
     * 把Map转换成Bean
     * 当返回的Bean为NULL时，说明转换失败。
     * @param bean
     *              接收的Bean
     * @param map
     *              Map的信息
     */
    public static void map2Bean(Object bean, Map<String, ? extends Object> map){
        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            bean = null;
        }
    }

}
