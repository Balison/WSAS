package http.responses;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import webserver.FileManager;
import webserver.WebServer;

/**
 *
 * @author TeamServer
 */
public class HttpHeaderResponse {
     
    private final String serverInformation;
    private final String date;
    private final String contentType;
    private final String lastModified;
    private final long contentLength;
    
    public HttpHeaderResponse(File file) throws IOException {
        FileManager manager = new FileManager();
        serverInformation = WebServer.SERVER_NAME;
        contentType = manager.getType(file);
        date = Date.from(Instant.now()).toString();
        lastModified = manager.lastModified(file);
        contentLength = file.length();
    }
    
    public String render(){
        StringBuilder res = new StringBuilder("Date: ");
        res.append(date).append("\n");
        res.append("Server: ");
        res.append(serverInformation).append("\n");
        res.append("Content-Type: ");
        res.append(contentType).append("\n");
        res.append("Content-Length: ");
        res.append(contentLength).append("\n");
        res.append("Last-Modified: ");
        res.append(lastModified).append("\n");
        return res.toString();
    }
    
    @Override
    public boolean equals(Object other){
        if(other instanceof HttpHeaderResponse){
            HttpHeaderResponse otherHeader = (HttpHeaderResponse) other;
            return serverInformation.equals(otherHeader.serverInformation) &&
                    date.equals(otherHeader.date) && 
                    lastModified.equals(otherHeader.lastModified) &&
                    contentLength == otherHeader.contentLength &&
                    contentType.equals(otherHeader.contentType);
        }
        return false;
    }
    
}
