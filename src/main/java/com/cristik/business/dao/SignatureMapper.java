package com.cristik.business.dao;

import com.cristik.business.entity.svo.Signature;
import tk.mybatis.mapper.common.Mapper;

public interface SignatureMapper extends Mapper<Signature> {

    int insertSignature(Signature signature);
}