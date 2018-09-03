package pep.pesoftware.wew.service;

import pep.pesoftware.fwf.repository.model.SysLog;

public interface ISysLogService {
    SysLog selectSysLogById(Long id);
}
