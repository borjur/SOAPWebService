package com.webage.warehouse;

import java.util.logging.Logger;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.jboss.ws.annotation.EndpointConfig;
import org.jboss.ws.extensions.policy.PolicyScopeLevel;
import org.jboss.ws.extensions.policy.annotation.Policy;
import org.jboss.ws.extensions.policy.annotation.PolicyAttachment;

@WebService
@EndpointConfig(
		configFile = "META-INF/wsrm-jaxws-endpoint-config.xml", 
		configName = "Standard WSRM Endpoint"
	)
@PolicyAttachment(
	@Policy(
		policyFileLocation = "META-INF/wsrm-policy.xml", 
		scope = PolicyScopeLevel.WSDL_BINDING
	)
)
public class WarehouseSystem {
	Logger logger = Logger.getLogger("WarehouseSystem");
	
	@WebMethod
	public void createOrder(Order order) {
		logger.info("Order ID: " + order.getOrderId());
		logger.info("Product ID: " + order.getProductId());
		logger.info("Quantity: " + order.getQuantity());
	}
	
	@WebMethod
	public String getOrderStatus(String orderId) {
		//Hard code status to keep things simple
		return "ACCEPTED"; 
	}
}
