package http.responses;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author TeamServer
 */
public class HttpHeaderResponseTest {

    @Test
    public void testSameHeader() throws IOException {
        HttpHeaderResponse header1 = new HttpHeaderResponse(new File("index.html"));
        HttpHeaderResponse header2 = new HttpHeaderResponse(new File("index.html"));
        
        assertEquals(header1, header2);
    }
    
    @Test
    public void testDistintHeader() throws IOException {
        HttpHeaderResponse header1 = new HttpHeaderResponse(new File("index.html"));
        HttpHeaderResponse header2 = new HttpHeaderResponse(new File("lala.html"));
        
        assertNotSame(header1, header2);
    }
}
