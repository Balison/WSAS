
package webserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author TeamServer
 */
public class ParametersManagerTest {

    @Test
    public void testLoad1Parametro() {
        ParametersManager manager = new ParametersManager();
        Map<String, String> respuestaCalculada = manager.load("nombre=alison");
        Map<String, String> respuestaEsperada = new HashMap<>();
        respuestaEsperada.put("nombre", "alison");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testLoadParametros() {
        ParametersManager manager = new ParametersManager();
        Map<String, String> respuestaCalculada = manager.load("nombre=alison&pass=alison");
        Map<String, String> respuestaEsperada = new HashMap<>();
        respuestaEsperada.put("nombre", "alison");
        respuestaEsperada.put("pass", "alison");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testLoadParametrosEspacio() {
        ParametersManager manager = new ParametersManager();
        Map<String, String> respuestaCalculada = manager.load("nombre=alison+fernandez&pass=alison");
        Map<String, String> respuestaEsperada = new HashMap<>();
        respuestaEsperada.put("nombre", "alison fernandez");
        respuestaEsperada.put("pass", "alison");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testLoadFunctionParametro() {
        ParametersManager manager = new ParametersManager();
        List<String> respuestaCalculada = manager.loadForFunction("1");
        List<String> respuestaEsperada = new ArrayList<>();
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testLoadFunctionParametros() {
        ParametersManager manager = new ParametersManager();
        List<String> respuestaCalculada = manager.loadForFunction("1|2|3|4");
        List<String> respuestaEsperada = new ArrayList<>();
        respuestaEsperada.add("1");
        respuestaEsperada.add("2");
        respuestaEsperada.add("3");
        respuestaEsperada.add("4");
        assertEquals(respuestaEsperada, respuestaCalculada);
    }
    
    @Test
    public void testGoodElements() {
        ParametersManager manager = new ParametersManager();
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        parametros.add("4");
        assertTrue(manager.goodElements(parametros));
    }
    
    @Test
    public void testGoodElementsLetters() {
        ParametersManager manager = new ParametersManager();
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("b");
        parametros.add("a");
        assertTrue(manager.goodElements(parametros));
    }
    
    @Test
    public void testBadElementsLetters() {
        ParametersManager manager = new ParametersManager();
        List<String> parametros = new ArrayList<>();
        parametros.add("a");
        parametros.add("b");
        parametros.add("1");
        parametros.add("2");
        assertFalse(manager.goodElements(parametros));
    }
    
    @Test
    public void testBadElements() {
        ParametersManager manager = new ParametersManager();
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        assertFalse(manager.goodElements(parametros));
    }
    
    @Test
    public void testBadElementsNegativos() {
        ParametersManager manager = new ParametersManager();
        List<String> parametros = new ArrayList<>();
        parametros.add("0");
        parametros.add("2");
        parametros.add("3");
        assertFalse(manager.goodElements(parametros));
    }
    
    @Test
    public void testMasElements() {
        ParametersManager manager = new ParametersManager();
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("1");
        parametros.add("4");
        parametros.add("6");
        assertFalse(manager.goodElements(parametros));
    }
    
    @Test
    public void testLessElements() {
        ParametersManager manager = new ParametersManager();
        List<String> parametros = new ArrayList<>();
        parametros.add("1");
        parametros.add("2");
        parametros.add("3");
        assertFalse(manager.goodElements(parametros));
    }
}
