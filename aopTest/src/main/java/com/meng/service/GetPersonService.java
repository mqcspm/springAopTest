package com.meng.service;

import com.meng.anno.Say;
import com.meng.commons.Person;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author <a href="mailto:mengqingcai@zuozh.com">mengqingcai</a>
 * @Date Create on 2018/3/29
 * @since version1.0 Copyright 2015 ZZJR All Rights Reserved.
 */
@Service
public class GetPersonService {

    /**
     * 拦截方法参数
     * @param person
     * @return
     */
    @Say(paramClassName = Person.class,returnClassName = Person.class)
    public Person getPerson(Person person){
        System.out.println("拦截方法参数");
        System.out.println("*******" + person.toString());
        return person;
    }

    /**
     * 拦截方法返回值
     * @return
     */
    @Say(paramClassName = Void.class,returnClassName = Person.class)
    public Person getPerson(){
        Person person = new Person();
        System.out.println("拦截方法返回值");
        person.setAge(1);
        person.setName("麻大师");
        System.out.println("*******" + person.toString());
        return person;
    }

    public static void main(String[] args) {
        String str1 = new StringBuilder().append("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder().append("ph").append("p").toString();
        System.out.println(str2.intern() == str2);
    }
}
