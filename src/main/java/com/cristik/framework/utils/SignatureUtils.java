package com.cristik.framework.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by zhenghua on 2016/3/23.
 */
public class SignatureUtils {
    /**
     * 签名生成算法
     * @param  params 请求参数集，所有参数必须已转换为字符串类型
     * @param  secret 签名密钥
     * @return 签名
     * @throws IOException
     */
    public static String getSignature(HashMap<String,String> params, String secret) throws IOException
    {
        // 先将参数以其参数名的字典序升序进行排序
        Map<String, String> sortedParams = new TreeMap<String, String>(params);
        Set<Map.Entry<String, String>> entrys = sortedParams.entrySet();

        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder basestring = new StringBuilder();
        for (Map.Entry<String, String> param : entrys) {
            basestring.append(param.getKey()).append("=").append(param.getValue());
        }
        basestring.append(secret);
        // 使用MD5对待签名串求签
        String sign =DigestUtils.md5Hex(basestring.toString());
        return sign;
    }

}
