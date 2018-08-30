package pep.pesoftware.rnr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pep.pesoftware.rnr.service.TestService;

@RestController
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return testService.hiService(name);
    }
}
