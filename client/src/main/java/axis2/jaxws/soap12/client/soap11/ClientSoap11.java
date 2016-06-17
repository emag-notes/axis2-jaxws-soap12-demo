package axis2.jaxws.soap12.client.soap11;

public class ClientSoap11 {

    public String invokeSayHello(String text) {
        HelloWorldSoap11_Service service = new HelloWorldSoap11_Service();
        HelloWorldSoap11 stub = service.getHelloWorldSoap11Port();
        return stub.sayHello(text);
    }

}
