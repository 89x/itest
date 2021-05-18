package com.barry.demo.demo;

import com.alibaba.fastjson.JSONObject;
import com.zhangmen.base.util.JsonUtils;
import com.zhangmen.qa.common.HttpConfig;
import com.zhangmen.qa.common.HttpCookies;
import com.zhangmen.qa.common.HttpMethods;
import com.zhangmen.qa.exception.HttpProcessException;
import com.zhangmen.qa.util.DataProviderUtil;
import com.zhangmen.qa.util.HttpClientUtils;
import com.zhangmen.qa.util.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class dataProviderdemo {
    /***
     * dataProvider  demo
     * 需要以方法名 命名CSV文件 如demo.csv
     * @param name
     */
    @Test(dataProvider = "testCsvData",description = "登录接口",dataProviderClass= DataProviderUtil.class)
    public void demo(String name,String mobile,String caseid,String codemsg,String msgcontent) throws HttpProcessException {

        String ur1="https://123/bLogin";
        Map sa = new HashMap();
        sa.put("bizCode","123");

        JSONObject json1 = new JSONObject();

        json1.put("password","LzdtfL+3wx0FWUKrpwik1jCVjM1HyZWea7zrW1PT+KigYCxoZsWAqlxvnk9+AJT17Me8gPGHXDmy9FWryxDoIQ==");
        json1.put("mobile",mobile);
        json1.put("context",sa);


        HttpCookies cookies = HttpCookies.custom();

        HttpConfig config = HttpConfig.custom()
                .timeout(1000)
                .url(ur1)
                .encoding("utf-8")
                .json(json1)
                .method(HttpMethods.POST)
                .context(cookies.getContext());

        String names = HttpClientUtils.post(config);

        String msg = JsonUtils.getJsonValue(names,"msgContent");




        JSONObject json = JSONObject.parseObject(names);

        Object code =json.get("msgCode");
//        Object msg = json.get("msgContent");


        Assert.assertEquals(codemsg,code);
        Assert.assertEquals(msgcontent,msg);



        if (caseid.equals("1")){
            System.out.println(code);
            Assert.assertEquals("200",code);
            System.out.println(codemsg);

        }
        if (caseid.equals("2")){
            System.out.println(code);
            Assert.assertEquals("11003",code);
            System.out.println(codemsg);


        }
         if (caseid.equals("3")){
             System.out.println(code);
             Assert.assertEquals("11001",code);
             System.out.println(codemsg);


         }



    }
}
