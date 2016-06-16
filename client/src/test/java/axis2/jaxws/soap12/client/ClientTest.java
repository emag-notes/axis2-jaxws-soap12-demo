package axis2.jaxws.soap12.client;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClientTest {

    @Test
    public void test() throws Exception {
        Client sut = new Client();
        assertThat(sut.invokeSayHello("foo"), is("Hello, foo"));
    }

}