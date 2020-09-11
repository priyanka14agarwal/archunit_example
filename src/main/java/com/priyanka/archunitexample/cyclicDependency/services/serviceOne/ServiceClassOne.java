package com.priyanka.archunitexample.cyclicDependency.services.serviceOne;

import com.priyanka.archunitexample.cyclicDependency.services.serviceTwo.ServiceClassTwo;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceClassOne {

    @Autowired
    ServiceClassTwo serviceClassTwo;

    public void callServiceClassTwoMethod(){
        serviceClassTwo.doNothingClassTwo();
    }

    public void doNothingClassOne(){

    }
}
