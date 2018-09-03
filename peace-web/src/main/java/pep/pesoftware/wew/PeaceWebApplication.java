package pep.pesoftware.wew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import pep.pesoftware.fwf.annotation.EnableDB;
import pep.pesoftware.fwf.annotation.EnableRedis;

@EnableCircuitBreaker
@SpringBootApplication
@EnableDB
@EnableRedis(name = "redisUtil")
public class PeaceWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(PeaceWebApplication.class, args);
    }
}
