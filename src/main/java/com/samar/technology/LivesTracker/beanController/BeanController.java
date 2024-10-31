package com.samar.technology.LivesTracker.beanController;

import com.samar.technology.LivesTracker.beanService.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/xml-bean")
public class BeanController {

    @Autowired
    private MyService myService;

    @GetMapping("/display")
    public String returnInfoBean(){
        return myService.displayBeanInfo();
    }
}
