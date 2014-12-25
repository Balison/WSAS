package http.responses;

import java.io.File;
import java.io.IOException;
import webserver.FileManager;

/**
 *
 * @author TeamServer
 */
public class HttpBodyResponse {
    
    private String contenido;
    
    public HttpBodyResponse(File file) throws IOException{
        FileManager manager = new FileManager();
        contenido = manager.getContenido(file);
    }
    
    @Override
    public boolean equals(Object other){
        if(other instanceof HttpBodyResponse){
            HttpBodyResponse otherBody = (HttpBodyResponse) other;
            return contenido.equals(otherBody.contenido);
        }
        return false;
    }

    public String render() {
        return contenido;
    }
}
