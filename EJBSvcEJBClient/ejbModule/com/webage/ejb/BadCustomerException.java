package com.webage.ejb;

public class BadCustomerException extends Exception {
    String name;

    public BadCustomerException(String name) {      
    	super("No soup for you!");
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
