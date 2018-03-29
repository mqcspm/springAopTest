package com.meng.service;

import com.meng.anno.Say;
import com.meng.commons.Person;
import org.springframework.stereotype.Service;

/**
 * Created by mengqingcai on 2018/3/26.
 */
@Service
public class LoginService {

    @Say
    public Person getPerson(){
        Person person = new Person();
        person.setAge(1);
        person.setName("麻大师");
        System.out.println("*******" + person.toString());
        return person;
    }

    public void printPerson(){
        Person person = getPerson();
        person.toString();

    }
}
