package com.barry.demo.demo;

import com.alibaba.fastjson.JSONObject;
import com.zhangmen.qa.common.HttpConfig;
import com.zhangmen.qa.common.HttpHeader;
import com.zhangmen.qa.common.HttpMethods;
import com.zhangmen.qa.common.HttpResult;
import com.zhangmen.qa.exception.HttpProcessException;
import com.zhangmen.qa.util.HttpClientUtils;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.TreeMap;


public class HttpclientUtilsTest {
    @Test
    public void test1() throws HttpProcessException {
        //请求url
        String url = "http://127.0.0.1:8088/passport/Login";

        //插件式配置Header（各种header信息、自定义header）
        HttpHeader header = HttpHeader.custom();


        JSONObject json = new JSONObject();
        json.put("confirmPassword", "123456");
        json.put("password", "123456");
        json.put("username","xiehengda");

        //插件式配置请求参数（网址、请求参数、编码、client）
        HttpConfig config = HttpConfig.custom()
                .timeout(10000)
                .url(url)
                .encoding("utf-8")
                .json(json)
                .method(HttpMethods.POST);


        //使用方式：
        HttpResult result1 = HttpClientUtils.sendResult(config);
        System.out.println(result1.getStatusCode());
        System.out.println(result1.getResult());
    }
    @Test
    public void test2() throws HttpProcessException {
        //请求url
        String url = "http://127.0.0.1:8088/index/carousel";

        //插件式配置Header（各种header信息、自定义header）
        HttpHeader header = HttpHeader.custom();


        Map json = new TreeMap();
        json.put("confirmPassword", "123456");
        json.put("password", "123456");
        json.put("username","xiehengda");

        //插件式配置请求参数（网址、请求参数、编码、client）
        HttpConfig config = HttpConfig.custom()
                .timeout(1000)
                .url(url)
                .encoding("utf-8").map(null);


        //使用方式：
        String result1 = HttpClientUtils.get(config);
        System.out.println(result1);
    }
    @Test
    public void test3() throws HttpProcessException {
        //请求url
        String url = "http://127.0.0.1:8088/passport/usernameIsExist?username=xiehengda";

        //插件式配置Header（各种header信息、自定义header）
        HttpHeader header = HttpHeader.custom();


//        Map map = new HashMap();
//        map.put("username", "xiehengda");
//        json.put("password", "123456");
//        json.put("username","xiehengda");

        //插件式配置请求参数（网址、请求参数、编码、client）
        HttpConfig config = HttpConfig.custom()
                .timeout(1000)
                .url(url);
//                .encoding("utf-8").map(map);

        //使用方式：
        HttpResult result1 = HttpClientUtils.sendResult(config);
        System.out.println(result1.getStatusCode());
    }
}
