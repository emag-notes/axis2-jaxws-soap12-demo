package axis2.jaxws.soap12.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(serviceName = "HelloWorldSoap12")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class HelloWorldSoap12 {

    @WebMethod
    public String sayHello(@WebParam(name = "text") String text) {
        return "[SOAP12] Hello, " + text;
    }

}
