package com.cristik.business.service;

import com.cristik.business.dao.DictionaryMapper;
import com.cristik.business.entity.svo.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenghua on 2016/4/1.
 */
@Service
public class DictionaryService {
    @Autowired
    DictionaryMapper dictionaryMapper;

    @Cacheable(value="statuscache",key="#dic.tableName+#dic.columnName+#dic.keyStr")
    public String getValue(Dictionary dic){
        System.out.println("loading data from database...");
        return dic.getValueStr();
    }
}
