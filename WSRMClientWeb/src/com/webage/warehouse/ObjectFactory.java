
package com.webage.warehouse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.webage.warehouse package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetOrderStatus_QNAME = new QName("http://warehouse.webage.com/", "getOrderStatus");
    private final static QName _GetOrderStatusResponse_QNAME = new QName("http://warehouse.webage.com/", "getOrderStatusResponse");
    private final static QName _CreateOrder_QNAME = new QName("http://warehouse.webage.com/", "createOrder");
    private final static QName _CreateOrderResponse_QNAME = new QName("http://warehouse.webage.com/", "createOrderResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.webage.warehouse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link GetOrderStatus }
     * 
     */
    public GetOrderStatus createGetOrderStatus() {
        return new GetOrderStatus();
    }

    /**
     * Create an instance of {@link CreateOrder }
     * 
     */
    public CreateOrder createCreateOrder() {
        return new CreateOrder();
    }

    /**
     * Create an instance of {@link CreateOrderResponse }
     * 
     */
    public CreateOrderResponse createCreateOrderResponse() {
        return new CreateOrderResponse();
    }

    /**
     * Create an instance of {@link GetOrderStatusResponse }
     * 
     */
    public GetOrderStatusResponse createGetOrderStatusResponse() {
        return new GetOrderStatusResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.webage.com/", name = "getOrderStatus")
    public JAXBElement<GetOrderStatus> createGetOrderStatus(GetOrderStatus value) {
        return new JAXBElement<GetOrderStatus>(_GetOrderStatus_QNAME, GetOrderStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.webage.com/", name = "getOrderStatusResponse")
    public JAXBElement<GetOrderStatusResponse> createGetOrderStatusResponse(GetOrderStatusResponse value) {
        return new JAXBElement<GetOrderStatusResponse>(_GetOrderStatusResponse_QNAME, GetOrderStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.webage.com/", name = "createOrder")
    public JAXBElement<CreateOrder> createCreateOrder(CreateOrder value) {
        return new JAXBElement<CreateOrder>(_CreateOrder_QNAME, CreateOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://warehouse.webage.com/", name = "createOrderResponse")
    public JAXBElement<CreateOrderResponse> createCreateOrderResponse(CreateOrderResponse value) {
        return new JAXBElement<CreateOrderResponse>(_CreateOrderResponse_QNAME, CreateOrderResponse.class, null, value);
    }

}
