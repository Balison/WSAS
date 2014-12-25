package webserver;

import http.responses.HttpResponse;
import java.io.IOException;

/**
 *
 * @author TeamServer
 */
public class WebServer {

    public static final int PUERTO = 8000;
    private ControladorPuerto control;
    private final FilterManager filterManager;
    
    public static final String SERVER_NAME = "apachito/0.1";

    public WebServer() {
        filterManager = new FilterManager();
        control = new ControladorPuerto(this);
    }

    public void listeningPort(){
        control.listeningPort();
    }

    public HttpResponse responseRequest(String peticion, String parametros) throws IOException {
        return filterManager.respond(peticion, parametros);
    }
}
