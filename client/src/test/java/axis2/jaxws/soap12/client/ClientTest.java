package axis2.jaxws.soap12.client;

import axis2.jaxws.soap12.client.soap11.ClientSoap11;
import axis2.jaxws.soap12.client.soap12.ClientSoap12;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClientTest {

    @Test
    public void testSoap11() throws Exception {
        ClientSoap11 sut = new ClientSoap11();
        assertThat(sut.invokeSayHello("foo"), is("[SOAP11] Hello, foo"));
    }

    @Test
    public void testSoap12() throws Exception {
        ClientSoap12 sut = new ClientSoap12();
        assertThat(sut.invokeSayHello("foo"), is("[SOAP12] Hello, foo"));
    }

}