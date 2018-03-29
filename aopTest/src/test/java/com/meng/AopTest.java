package com.meng;

import com.meng.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by mengqingcai on 2018/3/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AopTest {

    @Autowired
    LoginService loginService;

    @Test
    public void testAOP() {
        loginService.getPerson();
    }

}
