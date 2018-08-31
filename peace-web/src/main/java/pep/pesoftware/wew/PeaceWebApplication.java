package pep.pesoftware.wew;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringCloudApplication
@EnableCircuitBreaker
public class PeaceWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(PeaceWebApplication.class, args);
    }
}
