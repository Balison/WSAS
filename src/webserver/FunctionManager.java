
package webserver;

import http.HttpResponser;
import http.responses.HttpResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author TeamServer
 */
public class FunctionManager {
    
    private ValidatorFunction validatorFunction;
    private FileManager fileManager;
    
    public FunctionManager(FileManager filemanager, ParametersManager manager){
        validatorFunction = new ValidatorFunction(manager);
        fileManager = filemanager;
    }
    
    public HttpResponse request(String method, String url, String protocol, 
            List<String> parametros) throws IOException {
        int status = validatorFunction.validateFullRequest(method, url, protocol,
        parametros);
        if (status == 200) {
            return null;
        }
        return HttpResponser.respondTo(fileManager.updateFile(status, method, url),
                status);
    }
    
    public HttpResponse request(String method, String url, List<String> parametros) 
            throws IOException {
        int status = validatorFunction.validateSimpleRequest(method, url, parametros);
        if (status == 200) {
            return null;
        } else {
            return HttpResponser.respondTo(fileManager.updateFile(status, method, url));
        }
    }
}
