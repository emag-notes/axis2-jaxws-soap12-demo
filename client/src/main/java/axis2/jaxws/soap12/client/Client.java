package axis2.jaxws.soap12.client;

public class Client {

    public String invokeSayHello(String text) {
        HelloWorld_Service service = new HelloWorld_Service();
        HelloWorld stub = service.getHelloWorldPort();
        return stub.sayHello(text);
    }

}
