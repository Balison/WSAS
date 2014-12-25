

package http.responses;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author TeamServer
 */
public class HttpResponse {
    
    private HttpHeaderResponse header;
    private HttpBodyResponse body;
    
    private final int statusCode;
    
    public HttpResponse(File file, int status) throws IOException{
        statusCode = status;
        header = new HttpHeaderResponse(file);
        body = new HttpBodyResponse(file);
    }
    
    public HttpResponse(File file) throws IOException{
        statusCode = 0;
        header = null;
        body = new HttpBodyResponse(file);
    }

    public HttpResponse(File file, String method) throws IOException {
        statusCode = 200;
        header = new HttpHeaderResponse(file);
        if(method.equals("HEAD"))
            body = null;
        else
            body = new HttpBodyResponse(file);
    }
    
    public String render(){
        StringBuilder res = new StringBuilder();
        if(statusCode != 0)
            res.append("HTTP/1.0 ").append(statusCode).append(" \n");
        if(header == null){
            res.append(body.render());
        }
        else if(body == null)
            res.append(header.render());
        else{
            res.append(header.render());
            res.append("\n");
            res.append(body.render());
        }
        
        return res.toString();
    }
    
    @Override
    public boolean equals(Object other){
        if(other instanceof HttpResponse){
            HttpResponse otherResponse = (HttpResponse) other;
            if(header == null)
                return statusCode == otherResponse.statusCode && 
                        body.equals(otherResponse.body);
            if(body == null)
                return statusCode == otherResponse.statusCode &&
                        header.equals(otherResponse.header);
            else
                return statusCode == otherResponse.statusCode &&
                        header.equals(otherResponse.header) &&
                        body.equals(otherResponse.body);
        }
        return false;
    }    

    public int status() {
        return statusCode;
    }
}
