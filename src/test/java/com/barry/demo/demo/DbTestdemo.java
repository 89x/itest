package com.barry.demo.demo;

import com.zhangmen.qa.util.JDBCUtils;
import org.testng.annotations.Test;

import java.util.Map;

public class DbTestdemo {
    @Test
    public void demo(){
        Map<String,Object> ss1 =  JDBCUtils.query("barry","select id from name where mobile =?", "1");
//        int dd= JDBCUtils.executeUpdate("UPDATE  users SET nickname = ? where username =?","test","xiehengda");
        Map<String,Object> ss3 =  JDBCUtils.query("barry1","select id from  name where user_id =?", "1");
//        Assert.assertEquals(3,ss3.size());
//        Assert.assertEquals(dd,1);
    }
}
