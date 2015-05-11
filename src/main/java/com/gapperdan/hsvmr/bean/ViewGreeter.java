package com.gapperdan.hsvmr.bean;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

@SpringComponent
@ViewScope
public class ViewGreeter {
    public String sayHello() {
        return "Hello from a view scoped bean " + toString();
    }
}