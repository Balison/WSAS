
package webserver;

import http.responses.HttpResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author TeamServer
 */
public class FunctionManagerTest {

    @Test
    public void testSimple_BadFunction() throws IOException {
        ParametersManager parametersManager = new ParametersManager();
        FileManager fileManager = new FileManager();
        FunctionManager manager = new FunctionManager(fileManager, parametersManager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        parametros.add("4");
        HttpResponse respuestaCalculada = manager.request("POST", "lala", parametros);
        HttpResponse respuestaEsperada = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testSimple_BadMethod() throws IOException {
        ParametersManager parametersManager = new ParametersManager();
        FileManager fileManager = new FileManager();
        FunctionManager manager = new FunctionManager(fileManager, parametersManager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        parametros.add("4");
        HttpResponse respuestaCalculada = manager.request("GET", "procesar", parametros);
        HttpResponse respuestaEsperada = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testSimple_BadParameters() throws IOException {
        ParametersManager parametersManager = new ParametersManager();
        FileManager fileManager = new FileManager();
        FunctionManager manager = new FunctionManager(fileManager, parametersManager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        HttpResponse respuestaCalculada = manager.request("POST", "procesar", parametros);
        HttpResponse respuestaEsperada = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testSimple_EmptyURL() throws IOException {
        ParametersManager parametersManager = new ParametersManager();
        FileManager fileManager = new FileManager();
        FunctionManager manager = new FunctionManager(fileManager, parametersManager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        parametros.add("4");
        HttpResponse respuestaCalculada = manager.request("POST", "", parametros);
        HttpResponse respuestaEsperada = new HttpResponse(new File("src/temp/error.html"));
        assertEquals(respuestaEsperada, respuestaCalculada);
    }   
    
    @Test
    public void testFull_BadFunction() throws IOException {
        ParametersManager parametersManager = new ParametersManager();
        FileManager fileManager = new FileManager();
        FunctionManager manager = new FunctionManager(fileManager, parametersManager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        parametros.add("4");
        HttpResponse respuestaCalculada = manager.request("POST", "lala", "HTTP/1.1", parametros);
        HttpResponse respuestaEsperada = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testFull_BadMethod() throws IOException {
        ParametersManager parametersManager = new ParametersManager();
        FileManager fileManager = new FileManager();
        FunctionManager manager = new FunctionManager(fileManager, parametersManager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        parametros.add("4");
        HttpResponse respuestaCalculada = manager.request("GET", "procesar", "HTTP/1.1", parametros);
        HttpResponse respuestaEsperada = new HttpResponse(new File("src/temp/error.html"), 501);
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testFull_BadParameters() throws IOException {
        ParametersManager parametersManager = new ParametersManager();
        FileManager fileManager = new FileManager();
        FunctionManager manager = new FunctionManager(fileManager, parametersManager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        HttpResponse respuestaCalculada = manager.request("POST", "procesar", "HTTP/1.1", parametros);
        HttpResponse respuestaEsperada = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
        public void testFull_BadProtocol() throws IOException {
        ParametersManager parametersManager = new ParametersManager();
        FileManager fileManager = new FileManager();
        FunctionManager manager = new FunctionManager(fileManager, parametersManager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        parametros.add("4");
        HttpResponse respuestaCalculada = manager.request("POST", "procesar", "HTTP/1.2", parametros);
        HttpResponse respuestaEsperada = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
        
    @Test
    public void testFull_EmptyURL() throws IOException {
        ParametersManager parametersManager = new ParametersManager();
        FileManager fileManager = new FileManager();
        FunctionManager manager = new FunctionManager(fileManager, parametersManager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        parametros.add("4");
        HttpResponse respuestaCalculada = manager.request("POST", "", "HTTP/1.2", parametros);
        HttpResponse respuestaEsperada = new HttpResponse(new File("src/temp/error.html"), 400);
        assertEquals(respuestaEsperada, respuestaCalculada);
    }    
    
}
