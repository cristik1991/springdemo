package com.cristik.test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Created by zhenghua on 2016/3/22.
 */
public class EncryptTest {
    /**
     *
     */
    @Test
    public void testMD5(){
        String key ="我也不知道谁是sb";
        String result = DigestUtils.md5Hex(key.getBytes());
        System.out.println(result);
    }
}
