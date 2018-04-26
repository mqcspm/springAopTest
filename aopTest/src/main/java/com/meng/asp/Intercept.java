package com.meng.asp;


import com.meng.anno.Say;
import com.meng.commons.Person;
import com.sun.deploy.util.ArrayUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengqingcai on 2018/3/26.
 */
@Aspect
@Component
public class Intercept {

    /**
     * 设置切入点，在切入点方法中传入自定义的注解，在@Pointcut中的参数设置对应注解的变量名称
     */
    @Pointcut(value = "@annotation(say)",argNames = "say")
    public void point(Say say) {
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
    /*@Around(value = "point(say)",argNames = "say")
    public Object doAroundGetAnno(ProceedingJoinPoint joinPoint, Say say) throws Throwable {
        System.out.println("*******@Around");
        *//*Object[] args = joinPoint.getArgs();
        for (Object o : args){
            Person person = (Person) o;
            ((Person) o).setName("b");
        }*//*
        System.out.println(say.returnClassName());
        Object vlue = joinPoint.proceed();
        Person person = (Person) vlue;
        person.setName("c");
        return vlue;
    }*/

    @Around(value = "point(say)",argNames = "joinPoint,say")
    public Object doAroundGetParam(ProceedingJoinPoint joinPoint, Say say) throws Throwable {
        //用于启动目标方法执行
        joinPoint.proceed();
        System.out.println("*******@doAroundGetParam");
        say.paramClassName();
        Object[] args = joinPoint.getArgs();
        Object ob = new Object();
        String paramClassNeme = say.paramClassName().getName();
        for (Object o : args){
            System.out.println(o.getClass());
            ob = o;
            if (o.getClass().getName().equals(paramClassNeme)){
                //如果是该类型处理改参数不是则不处理
                Person person = (Person) ob;
                person.setName("b");
                person.setAge(3);
                ob = person;
                System.out.println("处理******");
            }
        }
     return ob;
    }
}
