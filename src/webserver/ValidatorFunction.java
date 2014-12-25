
package webserver;

import java.util.List;

/**
 *
 * @author TeamServer
 */
public class ValidatorFunction {
    
    private String[] funciones = {"procesar", "sumar"};
    private ParametersManager parametersManager;
    
    public ValidatorFunction(ParametersManager manager){
        parametersManager = manager;
    }
    
    public int validateSimpleRequest(String method, String url, 
            List<String> parametros) {
        url = quitarSlash(url);
        if (!method.equals("POST")) {
            return 501;
        }
        if (url.isEmpty()) {
             return 400;
        }
        if (funcionImplement(url) && parametersManager.goodElements(parametros)) {
            return 200;
        } else {
            return 400;
        }
    }

    public int validateFullRequest(String method, String url, String protocol, 
            List<String> parametros) {
        url = quitarSlash(url);
        if (!method.equals("POST")) {
            return 501;
        }
        if (url.isEmpty()) {
            return 400;
        }
        if (!(protocol.equals("HTTP/1.0") || protocol.equals("HTTP/1.1"))) {
            return 400;
        }
        if (funcionImplement(url) && parametersManager.goodElements(parametros)) {
            return 200;
        } else {
            return 400;
        }
    }
    
    private boolean funcionImplement(String funcion) {
        int funcionDefinida = 0;
        while (funcionDefinida < funciones.length) {
            if (funciones[funcionDefinida].equals(funcion)) {
                return true;
            }
            funcionDefinida++;
        }
        return false;
    }

    private String quitarSlash(String url) {
        if(url.contains("/"))
            return url.substring(1);
        else
            return url;
    }
}
