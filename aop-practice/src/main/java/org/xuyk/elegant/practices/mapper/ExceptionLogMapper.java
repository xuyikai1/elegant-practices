package org.xuyk.elegant.practices.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.xuyk.elegant.practices.MyMapper;
import org.xuyk.elegant.practices.pojo.ExceptionLogInfo;

@Mapper
public interface ExceptionLogMapper extends MyMapper<ExceptionLogInfo> {
}