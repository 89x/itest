package com.barry.demo.demo;


import com.zhangmen.qa.util.HttpClientUtil;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HttpclientUtilTest {

    @Test
    public void demo() throws IOException {
        //请求url
        String url = "http://127.0.0.1:8088/passport/logout";
        Map map = new HashMap();
        String userId = "1";
        map.put("userId",userId);
        HttpClientUtil.doPost(url,map);
    }

}
