package pep.pesoftware.wew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pep.pesoftware.fwf.repository.model.SysLog;
import pep.pesoftware.wew.service.ISysLogService;

import java.util.HashMap;
import java.util.Map;

import static pep.pesoftware.wew.common.constant.UserConstant.V1;

@RestController
@RequestMapping(V1 + "/test")
public class TestController {

    @Autowired
    private ISysLogService sysLogService;

    @GetMapping()
    public ResponseEntity list() {
        Map<String, Object> map=new HashMap<String, Object>();
        SysLog sysLog = sysLogService.selectSysLogById(Long.valueOf("35"));
        map.put("sysLog", sysLog);
        return ResponseEntity.ok(map);
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
