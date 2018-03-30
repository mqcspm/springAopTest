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

    /**
     * 设置切入点
     */
    @Pointcut(value = "@annotation(com.meng.anno.Say)")
    public void point(){
    }

    /**
     * 切入点方法执行后,获取执行方法的返回值
     * @param result
     * @throws Throwable
     */
    @AfterReturning(value = "point()", returning = "result")
    public void doAfterReturning(Object result) throws Throwable {
        Person person = (Person) result;
        person.setName("二狗子");
        System.out.println("****** AfterReturning" + result.toString());
    }

    /**
     * 带有自定义注解方法执行之前,执行切入方法
     */
    @Before("point()")
    public void doBefore(){

    }

    /**
     * 带有自定义注解的方法执行后,执行切入方法
     */
    @After("point()")
    public void doAfter(){

    }

    /**
     * 环绕通知类型,带有自定义注解方法,执行前、执行后,都会执行切入方法
     */
    @Around("point()")
    public void doAround(){

    }
}
