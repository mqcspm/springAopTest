package com.meng.asp;


import com.meng.commons.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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
    public void point() {
    }

    /**
     * 切入点方法执行后,获取执行方法的返回值
     * @param result
     * @throws Throwable
     */
//    @AfterReturning(value = "point()", returning = "result")
//    public void doAfterReturning(Object result) throws Throwable {
//        System.out.println("*******@AfterReturning");
//        Person person = (Person) result;
//        person.setName("二狗子");
//        System.out.println("****** AfterReturning" + result.toString());
//    }

    /**
     * 带有自定义注解方法执行之前,执行切入方法
     */
    /*@Before("point()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("*******@Before");
    }*/

    /**
     * 带有自定义注解的方法执行后,执行切入方法
     */
    /*@After("point()")
    public void doAfter(){
        System.out.println("*******@After");
    }*/

    /**
     * 环绕通知类型,带有自定义注解方法,执行前、执行后,都会执行切入方法
     * 环绕通知类型,必须joinPoint.proceed()该方法,通知才能生效
     */
    @Around("point()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("*******@Around");
        Object[] args = joinPoint.getArgs();
        for (Object o : args){
            Person person = (Person) o;
            ((Person) o).setName("b");
        }
        Object vlue = joinPoint.proceed();
        Person person = (Person) vlue;
        person.setName("c");
        return vlue;
    }
}
