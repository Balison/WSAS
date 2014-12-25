
package http;

import org.junit.Test;
import http.responses.*;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;


/**
 *
 * @author TeamServer
 */
public class HttpResponserTest {

    @Test
    public void testRespondTo_SimpleOK() throws IOException {
        HttpResponse returnedResult = HttpResponser.respondTo(new File("index.html"));
        HttpResponse expectedResult = new HttpResponse(new File("index.html"));
        assertEquals(expectedResult, returnedResult);
    }
    
    @Test
    public void testRespondTo_SimpleError() throws IOException {
        HttpResponse returnedResult = HttpResponser.respondTo(new File("error404.html"));
        HttpResponse expectedResult = new HttpResponse(new File("error404.html"));
        assertEquals(expectedResult, returnedResult);
    }
    
    @Test
    public void testRespondTo_Full200() throws IOException {
        HttpResponse returnedResult = HttpResponser.respondTo(new File("index.html"), "GET");
        HttpResponse expectedResult = new HttpResponse(new File("index.html"), "GET");
        assertEquals(expectedResult, returnedResult);
    }
    
    @Test
    public void testRespondTo_FullError() throws IOException {
        HttpResponse returnedResult = HttpResponser.respondTo(new File("error404.html"), 404);
        HttpResponse expectedResult = new HttpResponse(new File("error404.html"), 404);
        assertEquals(expectedResult, returnedResult);
    }
    
    
}
