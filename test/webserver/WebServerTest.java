package webserver;

import http.responses.HttpResponse;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author TeamServer
 */
public class WebServerTest {
    
    @Test
    public void testFullRequestGET_OK() throws IOException {
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("GET / HTTP/1.0", "");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"), "GET");
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHEAD_OK() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("HEAD / HTTP/1.0", "");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"), "HEAD");
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestPOST_OK() throws IOException {
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("POST / HTTP/1.0", "");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"), "POST");
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHEAD_NOT_FOUND() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("HEAD /as.html HTTP/1.0", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 404);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestGET_NOT_FOUND() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("GET /as.html HTTP/1.0", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 404);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestPOST_NOT_FOUND() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("POST /as.html HTTP/1.0", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 404);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHED_NOT_IMPLEMENT() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("HED /as.html HTTP/1.0", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 501);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestHEAD_BAD_PROTOCOL() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("HEAD /index.html HTTP/1.2", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestGET_BAD_PROTOCOL() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("GET /index.html HTTP/1.2", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testFullRequestPOST_BAD_PROTOCOL() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("POST /index.html HTTP/1.2", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestGET_OK() throws IOException {
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("GET /", "");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestPOST_OK() throws IOException {
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("POST /", "");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestHEAD() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("HEAD /", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestHEAD_NOT_FOUND() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("HEAD /as.html", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestGET_NOT_FOUND() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("GET /as.html", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestPOST_NOT_FOUND() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("POST /as.html", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestHED_NOT_IMPLEMENT() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("HED /as.html", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestHEAD_EMPTY_URL() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("HEAD", "");
        HttpResponse expectedResponse = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(expectedResponse, requestResponse);
    }
    
    @Test
    public void testSimpleRequestPOST_EMPTY_URL() throws IOException{
        WebServer server = new WebServer();
        HttpResponse requestResponse = server.responseRequest("POST", "");
        HttpResponse expectedResponse = new HttpResponse(new File("index.html"));
        assertEquals(expectedResponse, requestResponse);
    }
  }
