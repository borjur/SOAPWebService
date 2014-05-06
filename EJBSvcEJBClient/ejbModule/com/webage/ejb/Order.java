package com.webage.ejb;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@Remote
public interface Order {

	@WebMethod
	public String orderSoup(String name) throws BadCustomerException;

}
