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
public class DictionarysService {
    @Autowired
    DictionaryMapper dictionaryMapper;

    @Autowired DictionaryService service;

    public void loadCaches(){
        List<Dictionary> list =  dictionaryMapper.selectAll();
        for(Dictionary dic : list){
            service.getValue(dic);
        }
    }
}
