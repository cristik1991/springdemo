package com.cristik.business.service;

import com.cristik.business.dao.SignatureMapper;
import com.cristik.business.entity.svo.Signature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhenghua on 2016/3/30.
 */
@Service
public class SignatureService {
    @Autowired
    SignatureMapper signatureMapper;

    public int insertSignature(Signature signature){
        int id = signatureMapper.insert(signature);
        //int id2 = signatureMapper.insert(signature);
        /*signatureMapper.insertSignature()*/
        return id;
    }
}
