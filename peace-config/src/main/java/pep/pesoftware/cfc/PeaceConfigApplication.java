package pep.pesoftware.cfc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PeaceConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeaceConfigApplication.class, args);
    }
}
