package pep.pesoftware.wew.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pep.pesoftware.fwf.repository.mapper.SysLogMapper;
import pep.pesoftware.fwf.repository.model.SysLog;
import pep.pesoftware.wew.service.ISysLogService;

@Service
@Slf4j
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public SysLog selectSysLogById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }
}
