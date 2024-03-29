
package com.movie;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.0
 * 
 */
@WebServiceClient(name = "MovieServiceImplService", targetNamespace = "http://movie.com/", wsdlLocation = "http://127.0.0.1:8080/WebServiceProject/MovieService?wsdl")
public class MovieServiceImplService
    extends Service
{

    private final static URL MOVIESERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.movie.MovieServiceImplService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.movie.MovieServiceImplService.class.getResource(".");
            url = new URL(baseUrl, "http://127.0.0.1:8080/WebServiceProject/MovieService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://127.0.0.1:8080/WebServiceProject/MovieService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        MOVIESERVICEIMPLSERVICE_WSDL_LOCATION = url;
    }

    public MovieServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MovieServiceImplService() {
        super(MOVIESERVICEIMPLSERVICE_WSDL_LOCATION, new QName("http://movie.com/", "MovieServiceImplService"));
    }

    /**
     * 
     * @return
     *     returns MovieService
     */
    @WebEndpoint(name = "MovieServiceImplPort")
    public MovieService getMovieServiceImplPort() {
        return super.getPort(new QName("http://movie.com/", "MovieServiceImplPort"), MovieService.class);
    }

}
