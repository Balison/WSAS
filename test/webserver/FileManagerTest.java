
package webserver;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TeamServer
 */
public class FileManagerTest {
    
    @Test
    public void testFindFileEmptyName() {
        FileManager fileManager = new FileManager();
        File fileExpected = new File("index.html");
        File fileReturned = fileManager.findFile("/");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFileEmpty_fileNotExists() {
        FileManager fileManager = new FileManager();
        File fileExpected = new File("arqui.html");
        File fileReturned = fileManager.findFile("/arqui.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFile_fileExists() {
        FileManager fileManager = new FileManager();
        File fileExpected = new File("index.html");
        File fileReturned = fileManager.findFile("/index.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFile_fileNotExists() {
        FileManager fileManager = new FileManager();
        File fileExpected = new File("arqui.html");
        File fileReturned = fileManager.findFile("/arqui.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFile_noSlash_fileExists() {
        FileManager fileManager = new FileManager();
        File fileExpected = new File("index.html");
        File fileReturned = fileManager.findFile("index.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    @Test
    public void testFindFile_noSlash_fileNotExists() {
        FileManager fileManager = new FileManager();
        File fileExpected = new File("arqui.html");
        File fileReturned = fileManager.findFile("arqui.html");
        
        assertEquals(fileExpected, fileReturned);
    }
    
    @Test
    public void testTypeFileHtml() throws IOException {
        FileManager fileManager = new FileManager();
        String typeFileReturned = fileManager.getType(new File("index.html"));
        
        assertEquals("text/html", typeFileReturned);
    }
    
    @Test
    public void testTypeFileDefault() throws IOException {
        FileManager fileManager = new FileManager();
        String typeFileReturned = fileManager.getType(new File("index"));
        
        assertEquals("text/html", typeFileReturned);
    }
    
    @Test
    public void testUpdateFile400() throws IOException {
        FileManager fileManager = new FileManager();
        File fileReturned = fileManager.updateFile(400,null,null);
        String expected="<html><head>\n" +
        "  <title>400 Bad Request</title>\n" +
        "</head><body>\n" +
        "   <h1>Bad Request</h1>\n" +
        "   <p>Your browser sent a request that this server could not understand.<br/></p>\n" +
        "</body></html>";
        String actual = fileManager.getContenido(fileReturned);
        assertEquals(expected,actual);
        
    }
   
    @Test
    public void testUpdateFile404() throws IOException {
        FileManager fileManager = new FileManager();
        File fileReturned = fileManager.updateFile(404,null,"/mundo.html");
        String expected = "<html><head>\n" +
        "  <title>404 Not Found</title>\n" +
        "</head><body>\n" +
        "   <h1>Not Found</h1>\n" +
        "   <p>The requested URL /mundo.html was not found on this server.<br/></p>\n" +
        "</body></html>";
        String actual = fileManager.getContenido(fileReturned);
        assertEquals(expected, actual);
        
    }
    
    
    @Test
    public void testUpdateFile501() throws IOException {
        FileManager fileManager = new FileManager();
        File fileReturned = fileManager.updateFile(501,"GO","/index.html");
        String expected ="<html><head>\n" +
        "  <title>501 Method Not Implemented</title>\n" +
        "</head><body>\n" +
        "   <h1>Method Not Implemented</h1>\n" +
        "   <p>GO to /index.html not supported.<br/></p>\n" +
        "</body></html>"; 
        String actual = fileManager.getContenido(fileReturned);
        assertEquals(expected,actual);
        
    }

    @Test
    public void testLastModified() {
        FileManager fileManager = new FileManager();
        String dateReturned = fileManager.lastModified(new File("index.html"));
        String dateExpected = "Sat Nov 22 14:00:04 BOT 2014";
        assertEquals(dateExpected, dateReturned);
    }
}
