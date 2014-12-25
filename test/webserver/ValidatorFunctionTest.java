
package webserver;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Usuario
 */
public class ValidatorFunctionTest {
    
    @Test
    public void testFULLRequest_OK() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        parametros.add("4");
        int respuestaCalculada = validator.validateFullRequest("POST", 
                    "procesar", "HTTP/1.1", parametros);
        assertEquals(200, respuestaCalculada);
    }
    
    @Test
    public void testFULLRequest_OKSlash() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        parametros.add("4");
        int respuestaCalculada = validator.validateFullRequest("POST", 
                    "procesar", "HTTP/1.1", parametros);
        assertEquals(200, respuestaCalculada);
    }

    @Test
    public void testFULLRequest_MethodNotImplement() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        int respuestaCalculada = validator.validateFullRequest("GET", 
                "/procesar", "HTTP/1.1", parametros);
        assertEquals(501, respuestaCalculada);
    }
    
    @Test
    public void testFULLRequest_EmptyURL() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        int respuestaCalculada = validator.validateFullRequest("POST", 
                "", "HTTP/1.1", parametros);
        assertEquals(400, respuestaCalculada);
    }
    
    @Test
    public void testFULLRequest_BadURL() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        int respuestaCalculada = validator.validateFullRequest("POST", 
                "lala", "HTTP/1.1", parametros);
        assertEquals(400, respuestaCalculada);
    }
    
    @Test
    public void testFULLRequest_BadProtocol() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        int respuestaCalculada = validator.validateFullRequest("POST", 
                "procesar", "HTTP/1.2", parametros);
        assertEquals(400, respuestaCalculada);
    }
    
    @Test
    public void testFULLRequest_BadParameters() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        int respuestaCalculada = validator.validateFullRequest("POST", 
                    "procesar", "HTTP/1.1", parametros);
        assertEquals(400, respuestaCalculada);
    }
    
    @Test
    public void testSimpleRequest_OK() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        parametros.add("4");
        int respuestaCalculada = validator.validateSimpleRequest("POST", 
                    "procesar", parametros);
        assertEquals(200, respuestaCalculada);
    }
    
    @Test
    public void testSimpleRequest_OKSlash() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        parametros.add("4");
        int respuestaCalculada = validator.validateSimpleRequest("POST", 
                    "procesar", parametros);
        assertEquals(200, respuestaCalculada);
    }

    @Test
    public void testSimpleRequest_MethodNotImplement() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        int respuestaCalculada = validator.validateSimpleRequest("GET", 
                "/procesar", parametros);
        assertEquals(501, respuestaCalculada);
    }
    
    @Test
    public void testSimpleRequest_EmptyURL() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        int respuestaCalculada = validator.validateSimpleRequest("POST", 
                "", parametros);
        assertEquals(400, respuestaCalculada);
    }
    
    @Test
    public void testSimpleRequest_BadURL() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        int respuestaCalculada = validator.validateSimpleRequest("POST", 
                "lala", parametros);
        assertEquals(400, respuestaCalculada);
    }
    
    @Test
    public void testSimpleRequest_BadParameters() {
        ParametersManager manager = new ParametersManager();
        ValidatorFunction validator = new ValidatorFunction(manager);
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        int respuestaCalculada = validator.validateSimpleRequest("POST", 
                    "procesar", parametros);
        assertEquals(400, respuestaCalculada);
    }
}
