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

    @Say
    public Person getPerson(Person person){
        System.out.println("*******" + person.toString());
        return person;
    }

    @Say
    public Person getPerson(){
        Person person = new Person();
        person.setAge(1);
        person.setName("麻大师");
        System.out.println("*******" + person.toString());
        return person;
    }
}
