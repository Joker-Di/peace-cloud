package pep.pesoftware.fwf.repository.mapper;

import pep.pesoftware.fwf.repository.model.SysUserToken;

public interface SysUserTokenMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUserToken record);

    int insertSelective(SysUserToken record);

    SysUserToken selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUserToken record);

    int updateByPrimaryKey(SysUserToken record);
}