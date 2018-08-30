package pep.pesoftware.fnf.common;

import org.springframework.stereotype.Component;
import pep.pesoftware.fnf.service.TestFeignService;
@Component
public class TestFeignHiHystric  implements TestFeignService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
