
package http.responses;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TeamServer
 */
public class HttpResponseTest {

    @Test
    public void testEqualsFullResponseStatus200() throws IOException {
        HttpResponse response1= new HttpResponse(new File("index.html"), "GET");
        HttpResponse response2= new HttpResponse(new File("index.html"), "GET");
        assertEquals(response1, response2);
    }
    
    @Test
    public void testDistintFullResponseStatus200() throws IOException {
        HttpResponse response1= new HttpResponse(new File("index.html"), "GET");
        HttpResponse response2= new HttpResponse(new File("lala.html"), "HEAD");
        assertNotSame(response1, response2);
    }
    
    @Test
    public void testEqualsFullResponseStatusError() throws IOException {
        HttpResponse response1= new HttpResponse(new File("error404.html"), 404);
        HttpResponse response2= new HttpResponse(new File("error404.html"), 404);
        assertEquals(response1, response2);
    }
    
    @Test
    public void testDistintFullResponseStatusError() throws IOException {
        HttpResponse response1= new HttpResponse(new File("error400.html"), 400);
        HttpResponse response2= new HttpResponse(new File("error404.html"), 404);
        assertNotSame(response1, response2);
    }
    
    @Test
    public void testEqualsSimpleResponseStatus200() throws IOException {
        HttpResponse response1= new HttpResponse(new File("index.html"));
        HttpResponse response2= new HttpResponse(new File("index.html"));
        assertEquals(response1, response2);
    }
    
    @Test
    public void testDistintSimpleResponseStatus200() throws IOException {
        HttpResponse response1= new HttpResponse(new File("index.html"));
        HttpResponse response2= new HttpResponse(new File("lala.html"));
        assertNotSame(response1, response2);
    }
    
    @Test
    public void testEqualsSimpleResponseStatusError() throws IOException {
        HttpResponse response1= new HttpResponse(new File("error404.html"));
        HttpResponse response2= new HttpResponse(new File("error404.html"));
        assertEquals(response1, response2);
    }
    
    @Test
    public void testDistintSimpleResponseStatusError() throws IOException {
        HttpResponse response1= new HttpResponse(new File("error400.html"));
        HttpResponse response2= new HttpResponse(new File("error404.html"));
        assertNotSame(response1, response2);
    }
}
