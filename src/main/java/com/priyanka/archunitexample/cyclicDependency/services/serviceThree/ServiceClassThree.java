package com.priyanka.archunitexample.cyclicDependency.services.serviceThree;

import com.priyanka.archunitexample.cyclicDependency.services.serviceOne.ServiceClassOne;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceClassThree {

    @Autowired
    ServiceClassOne serviceClassOne;

    public void callServiceClassOneMethod(){
        serviceClassOne.doNothingClassOne();
    }

    public void doNothingClassThree(){

    }
}
