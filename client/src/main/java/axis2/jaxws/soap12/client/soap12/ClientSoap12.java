package axis2.jaxws.soap12.client.soap12;

public class ClientSoap12 {

    public String invokeSayHello(String text) {
        HelloWorldSoap12_Service service = new HelloWorldSoap12_Service();
        HelloWorldSoap12 stub = service.getHelloWorldSoap12Port();
        return stub.sayHello(text);
    }

}
