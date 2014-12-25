
package webserver;

/**
 *
 * @author TeamServer
 */
public class ValidatorRequest {
    
    private final String metodos[] = {"HEAD", "GET","POST"};
    private FileManager fileManager;
    
    public ValidatorRequest(FileManager manager){
        fileManager = manager;
    }

    public int validateSimpleRequest(String method, String url) {
        if (method.equals("GET") || method.equals("POST")) {
            if (fileManager.findFile(url).exists()) {
                return 200;
            } else {
                return 404;
            }
        }
        if (method.equals("HEAD")) {
            return 400;
        } else {
            return 501;
        }
    }

    public int validateFullRequest(String method, String url, String protocol) {
        if (!metodoImplement(method)) {
            return 501;
        }
        if (url.isEmpty()) {
            return 400;
        }
        if (!(protocol.equals("HTTP/1.0") || protocol.equals("HTTP/1.1"))) {
            return 400;
        }
        if (fileManager.findFile(url).exists()) {
            return 200;
        } else {
            return 404;
        }
    }
    
    private boolean metodoImplement(String metodo) {
        int metodoDefinido = 0;
        while (metodoDefinido < metodos.length) {
            if (metodos[metodoDefinido].equals(metodo)) {
                return true;
            }
            metodoDefinido++;
        }
        return false;
    }
    
}
