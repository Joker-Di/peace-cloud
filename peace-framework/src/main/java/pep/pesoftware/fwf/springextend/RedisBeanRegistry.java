package pep.pesoftware.fwf.springextend;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import pep.pesoftware.fwf.annotation.EnableRedis;
import pep.pesoftware.fwf.redis.RedisClient;

public class RedisBeanRegistry implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(
            AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annotation = AnnotationAttributes.fromMap(
                importingClassMetadata.getAnnotationAttributes(EnableRedis.class.getName()));

        String name = annotation.getString("name");
        BeanDefinition redisClient;
        redisClient = BeanDefinitionBuilder.genericBeanDefinition(RedisClient.class).getBeanDefinition();
        registry.registerBeanDefinition(name,redisClient);
    }

}
