
package webserver;

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TeamServer
 */
public class ValidatorRequestTest {

    @Test
    public void testFullRequestGET_OK(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("GET", "/", "HTTP/1.0");
        assertEquals(200, statusResponse);
    }
    
    @Test
    public void testFullRequestHEAD_OK(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("HEAD", "/", "HTTP/1.0");
        assertEquals(200, statusResponse);
    }
    
    @Test
    public void testFullRequestPOST_OK(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("POST", "/", "HTTP/1.0");
        assertEquals(200, statusResponse);
    }
    
    @Test
    public void testFullRequestHEAD_NOT_FOUND(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("HEAD", "/as.html", "HTTP/1.0");
        assertEquals(404, statusResponse);
    }
    
    @Test
    public void testFullRequestGET_NOT_FOUND(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("GET", "/as.html", "HTTP/1.0");
        assertEquals(404, statusResponse);
    }
    
    @Test
    public void testFullRequestPOST_NOT_FOUND(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("POST", "/as.html", "HTTP/1.0");
        assertEquals(404, statusResponse);
    }
    
    @Test
    public void testFullRequestHED_NOT_IMPLEMENT(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("HED", "/as.html", "HTTP/1.0");
        assertEquals(501, statusResponse);
    }
    
    @Test
    public void testFullRequestHEAD_EMPTY_URL(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("HEAD", "", "HTTP/1.0");
        assertEquals(400, statusResponse);
    }
    
    @Test
    public void testFullRequestGET_EMPTY_URL(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("GET", "", "HTTP/1.0");
        assertEquals(400, statusResponse);
    }
    
    @Test
    public void testFullRequestPOST_EMPTY_URL(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("POST", "", "HTTP/1.0");
        assertEquals(400, statusResponse);
    }
    
    @Test
    public void testFullRequestHEAD_BAD_PROTOCOL(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("HEAD", "/index.html", "HTTP/1.2");
        assertEquals(400, statusResponse);
    }
    
    @Test
    public void testFullRequestGET_BAD_PROTOCOL(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("GET", "/index.html", "HTTP/1.2");
        assertEquals(400, statusResponse);
    }
    
    @Test
    public void testFullRequestPOST_BAD_PROTOCOL(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateFullRequest("POST", "/index.html", "HTTP/1.2");
        assertEquals(400, statusResponse);
    }
    
    @Test
    public void testSimpleRequestGET_OK(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateSimpleRequest("GET", "/");
        assertEquals(200, statusResponse);
    }
    
    @Test
    public void testSimpleRequestPOST_OK(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateSimpleRequest("POST", "/");
        assertEquals(200, statusResponse);
    }
    
    @Test
    public void testSimpleRequestHEAD_OK(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateSimpleRequest("HEAD", "/");
        assertEquals(400, statusResponse);
    }
    
    @Test
    public void testSimpleRequestHEAD_NOT_FOUND(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateSimpleRequest("HEAD", "/as.html");
        assertEquals(400, statusResponse);
    }
    
    @Test
    public void testSimpleRequestGET_NOT_FOUND(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateSimpleRequest("GET", "/as.html");
        assertEquals(404, statusResponse);
    }
    
    @Test
    public void testSimpleRequestPOST_NOT_FOUND(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateSimpleRequest("POST", "/as.html");
        assertEquals(404, statusResponse);
    }
    
    @Test
    public void testSimpleRequestHED_NOT_IMPLEMENT(){
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateSimpleRequest("HED", "/as.html");
        assertEquals(501, statusResponse);
    }
    
    @Test
    public void testSimpleRequestHEAD_EMPTY_URL() throws IOException{
        FileManager manager = new FileManager();
        ValidatorRequest validator = new ValidatorRequest(manager);
        int statusResponse = validator.validateSimpleRequest("HEAD", "");
        assertEquals(400, statusResponse);
    }
    
}
