package com.cristik.business.service;

import com.cristik.business.dao.OperationLogMapper;
import com.cristik.business.entity.svo.OperationLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhenghua on 2016/3/29.
 */
@Service
public class OperationLogService {

    @Autowired
    OperationLogMapper operationLogMapper;

    public void log(OperationLog log){
        operationLogMapper.insert(log);
    }
}
