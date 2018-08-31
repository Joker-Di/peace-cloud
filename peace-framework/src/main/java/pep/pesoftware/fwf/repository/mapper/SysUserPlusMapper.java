package pep.pesoftware.fwf.repository.mapper;

import pep.pesoftware.fwf.repository.model.SysUserPlus;

public interface SysUserPlusMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserPlus record);

    int insertSelective(SysUserPlus record);

    SysUserPlus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserPlus record);

    int updateByPrimaryKey(SysUserPlus record);
}