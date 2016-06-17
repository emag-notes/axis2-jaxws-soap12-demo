package axis2.jaxws.soap12.client.soap12;

import java.net.MalformedURLException;
import java.net.URL;

public class ClientSoap12 {

    public String invokeSayHello(String text) throws MalformedURLException {
        HelloWorldSoap12_Service service;

        String wsdlLocation = System.getProperty("soap12.wsdl.location");
        if (wsdlLocation != null) {
            service = new HelloWorldSoap12_Service(new URL("file://" + wsdlLocation));
        } else {
            service = new HelloWorldSoap12_Service();
        }
        HelloWorldSoap12 stub = service.getHelloWorldSoap12Port();
        return stub.sayHello(text);
    }

}
