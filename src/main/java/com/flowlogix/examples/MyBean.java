package com.flowlogix.examples;

import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author lprimak
 */
@ApplicationScoped
public class MyBean {
    public String greeting() {
        return "hello";
    }
}
