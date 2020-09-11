package com.priyanka.archunitexample.cyclicDependency.services.serviceTwo;

import com.priyanka.archunitexample.cyclicDependency.services.serviceThree.ServiceClassThree;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceClassTwo {

    @Autowired
    ServiceClassThree serviceClassThree;

    public void callServiceClassThreeMethod(){
        serviceClassThree.doNothingClassThree();
    }

    public void doNothingClassTwo(){

    }
}
