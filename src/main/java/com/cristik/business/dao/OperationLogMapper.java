package com.cristik.business.dao;

import com.cristik.business.entity.svo.OperationLog;
import tk.mybatis.mapper.common.Mapper;

public interface OperationLogMapper extends Mapper<OperationLog> {
    int insertLog(OperationLog log);
}