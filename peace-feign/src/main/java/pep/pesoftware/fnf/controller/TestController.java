package pep.pesoftware.fnf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pep.pesoftware.fnf.service.TestFeignService;

@RestController
public class TestController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    private TestFeignService testFeignService;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return testFeignService.sayHiFromClientOne( name );
    }
}
