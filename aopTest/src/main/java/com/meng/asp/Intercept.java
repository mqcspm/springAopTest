package com.meng.asp;


import com.meng.commons.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by mengqingcai on 2018/3/26.
 */
@Aspect
@Component
public class Intercept {
    @Pointcut(value = "@annotation(com.meng.anno.Say)")
    public void point(){
    }

    @AfterReturning(value = "point()", returning = "result")
    public void doAfter(Object result) throws Throwable {
        System.out.println("****** AfterReturning" + result.toString());
    }
}
