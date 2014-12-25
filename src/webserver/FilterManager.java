
package webserver;

import http.responses.HttpResponse;
import java.io.IOException;

/**
 *
 * @author TeamServer
 */
public class FilterManager {
    
    private final FileManager fileManager;
    private final RequestManager requestManager;
    private final FunctionManager functionManager;
    private final ParametersManager parameterManager;
    
    public FilterManager(){
        parameterManager = new ParametersManager();
        fileManager = new FileManager();
        requestManager = new RequestManager(fileManager);
        functionManager = new FunctionManager(fileManager, parameterManager);
    }

    private boolean isFile(String resource) {
        return resource.contains(".") || resource.equals("/") || 
                fileManager.findFile(resource).exists();
    }

    private HttpResponse request(String method, String resource, String parametros) 
            throws IOException {
        if(isFile(resource)){
            parameterManager.load(parametros);
            return requestManager.request(method, resource);
        }
        else{
            return functionManager.request(method, resource, 
                    parameterManager.loadForFunction(parametros));
        }
    }

    private HttpResponse request(String method, String resource, String version,
            String parametros) throws IOException {
        if(isFile(resource)){
            parameterManager.load(parametros);
            return requestManager.request(method, resource, version);
        }
        else{
            return functionManager.request(method, resource, 
                    parameterManager.loadForFunction(parametros));
        }
    }

    public HttpResponse respond(String request, String parametros) throws IOException {
        request = request.split("\n")[0];
        String[] requestLine = request.split(" ");
        String method, resource, version;
        if(requestLine.length >= 3){
            method = requestLine[0];
            resource = requestLine[1];
            version = requestLine[2];
            return request(method, resource, version, parametros);
        }      
        else if(requestLine.length == 2){
            method = requestLine[0];
            resource = requestLine[1];
            return request(method, resource, parametros);
        }else{
            method = requestLine[0];
            return request(method, "index.html", parametros);
        }
    }
}
