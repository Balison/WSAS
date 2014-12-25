package http;

import java.io.File;
import http.responses.*;
import java.io.IOException;

/**
 *
 * @author TeamServer
 */
public class HttpResponser {

    public static HttpResponse respondTo(File file, int status) throws IOException {
        HttpResponse response = new HttpResponse(file, status);
        return response;
    }
    
    public static HttpResponse respondTo(File file, String method) throws IOException {
        HttpResponse response = new HttpResponse(file, method);
        return response;
    }

    public static HttpResponse respondTo(File file) throws IOException {
        HttpResponse response = new HttpResponse(file);
        return response;
    }
}
