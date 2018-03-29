package com.meng.service;

import com.meng.anno.Say;
import com.meng.commons.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mengqingcai on 2018/3/26.
 */
@Service
public class LoginService {

    @Autowired
    GetPersonService getPersonService;

    public void printPerson(){
        Person person = getPersonService.getPerson();
        System.out.println(person.toString());
    }

    /**
     * 在使用 Spring AOP 的时候，我们从IOC容器中获取的Service Bean对象其实都是代理对象，
     * 而不是那些 Service Bean 对象本身，也就是说获取的并不是被代理对象或代理目标。
     * 当我在自己的 Service 类中使用 this 关键字嵌套调用同类中的其他方法时，
     * 由于 this 关键字引用的并不是该 Service Bean 对象的代理对象，而是其本身，故 Spring AOP 是不能拦截到这些被嵌套调用的方法的。
     * @return
     */
    @Say
    public Person getPerson(){
        Person person = new Person();
        person.setAge(1);
        person.setName("麻大师");
        System.out.println("*******" + person.toString());
        return person;
    }
}
