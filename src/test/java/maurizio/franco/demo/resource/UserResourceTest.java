package maurizio.franco.demo.resource;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import maurizio.franco.Demo;

/**
 * 
 * Provides a simple test for the 
 * @author maurizio.franco
 *
 */
public class UserResourceTest {

	private static Logger logger = LoggerFactory.getLogger(UserResourceTest.class);
	
    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Demo.startServer();
        // create the client
        Client c = ClientBuilder.newClient();
        target = c.target(Demo.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
    	logger.info("testGetIt - START");
    	List users = target.path("user").request().get(List.class);
        assertEquals(10, users.size());
        logger.info("testGetIt - END");
    }
}
