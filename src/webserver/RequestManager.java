
package webserver;

import http.HttpResponser;
import http.responses.HttpResponse;
import java.io.IOException;

/**
 *
 * @author TeamServer
 */
public class RequestManager {
    
    private final FileManager fileManager;
    private final ValidatorRequest validatorRequest;
    
    public RequestManager(FileManager manager){
        fileManager = manager;
        validatorRequest = new ValidatorRequest(fileManager);
    }
    
    public HttpResponse request(String method, String url, String protocol) throws IOException {
        int status = validatorRequest.validateFullRequest(method, url, protocol);
        if (status == 200) {
            return HttpResponser.respondTo(fileManager.findFile(url), method);
        }
        return HttpResponser.respondTo(fileManager.updateFile(status,method,url), status);
    }
    
    public HttpResponse request(String method, String url) throws IOException {
        int status = validatorRequest.validateSimpleRequest(method, url);
        if (status == 200) {
            return HttpResponser.respondTo(fileManager.findFile(url));
        } else {
            return HttpResponser.respondTo(fileManager.updateFile(status,method,url));
        }
    }
}
