package com.webage.ejb;

import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.ws.annotation.EndpointConfig;

@EndpointConfig(configName = "Standard WSAddressing Endpoint")
@WebService(endpointInterface="com.webage.ejb.Order")
@Stateless(name="OrderBean")
public class OrderBean implements Order {

	public String orderSoup(String name) throws BadCustomerException {
		if (name.equals("Elaine")) {
			throw new BadCustomerException(name);
		}
		try {
			Thread.sleep(15000);
		} catch (Exception e) {
		}

		return "Soup Served";
	}

}
