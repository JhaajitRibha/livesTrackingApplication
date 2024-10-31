package com.samar.technology.LivesTracker.beanService;


import com.samar.technology.LivesTracker.utility.MyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final MyBean myBean;

    @Autowired
    public MyService(MyBean myBean) {
        this.myBean = myBean;
    }

    public String displayBeanInfo() {
      return myBean.getName()+" : "+myBean.getAge();
    }
}
