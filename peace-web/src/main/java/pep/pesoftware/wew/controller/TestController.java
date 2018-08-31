package pep.pesoftware.wew.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static pep.pesoftware.wew.common.constant.UserConstant.V1;

@RestController
@RequestMapping(V1 + "/test")
public class TestController {

    @GetMapping()
    public ResponseEntity list() {
        return ResponseEntity.ok(false);
    }

    @PostMapping()
    public ResponseEntity insert() {
        return ResponseEntity.ok(false);
    }

    @PutMapping()
    public ResponseEntity update() {
        return ResponseEntity.ok(false);
    }

    @DeleteMapping()
    public ResponseEntity delete () {
        return ResponseEntity.ok(false);
    }

}
