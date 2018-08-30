package pep.pesoftware.fnf.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pep.pesoftware.fnf.common.TestFeignHiHystric;

@FeignClient(value = "PEACE-EUREKA-CLIENT",fallback = TestFeignHiHystric.class)
public interface TestFeignService {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
