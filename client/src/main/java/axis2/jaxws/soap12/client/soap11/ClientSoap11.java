package axis2.jaxws.soap12.client.soap11;

import java.net.MalformedURLException;
import java.net.URL;

public class ClientSoap11 {

    public String invokeSayHello(String text) throws MalformedURLException {
        HelloWorldSoap11_Service service;

        String wsdlLocation = System.getProperty("soap11.wsdl.location");
        if (wsdlLocation != null) {
            service = new HelloWorldSoap11_Service(new URL("file://" + wsdlLocation));
        } else {
            service = new HelloWorldSoap11_Service();
        }
        HelloWorldSoap11 stub = service.getHelloWorldSoap11Port();
        return stub.sayHello(text);
    }

}
