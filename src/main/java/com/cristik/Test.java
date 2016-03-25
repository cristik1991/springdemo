package com.cristik;

import com.cristik.framework.utils.PropertiesUtils;

import java.io.IOException;

/**
 * Created by zhenghua on 2016/3/25.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String value = PropertiesUtils.getProperty("file.properties","file.path");
        System.out.println(value);
    }
}
