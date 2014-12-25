package webserver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author TeamServer
 */
public class FileManager {

    private final String defaultFileName;

    public FileManager() {
        defaultFileName = "index.html";
    }

    public File findFile(String url) {
        File file;
        if (urlHasNoFile(url)) {
            url = url + defaultFileName;
        }

        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }

        file = new File(url);

        return file;
    }

    private boolean urlHasNoFile(String url) {
        return url.charAt(url.length() - 1) == '/';
    }

    public String getType(File file) throws IOException {
        String nombre = file.getName();
        if (nombre.contains(".html")) {
            return "text/html";
        }
        if (nombre.endsWith(".css")) {
            return "text/css";
        }
        if (nombre.endsWith(".txt")) {
            return "text/plain";
        }
        if (nombre.endsWith(".gif")) {
            return "image/gif";
        }
        if (nombre.endsWith(".png")) {
            return "image/png";
        }
        else{
            String contenido = getContenido(file);
            if(contenido.contains("html"))
                return "text/html";
        }
        return "text/plain";
    }

    public String getContenido(File file) throws IOException {
        String contenido = "";
        if (file.exists()) {
            try {
                contenido = new Scanner(file).useDelimiter("\\Z").next();
            } catch (FileNotFoundException ex) {
            }
        }
        return contenido;
    }

    public String lastModified(File file) {
        Date fecha = new Date(file.lastModified());
        return fecha.toString();
    }

    public File updateFile(int status, String method, String url) {
       String statusLine=DataBaseResponseError.response(status);
       String detailStatus=DataBaseResponseError.detailedResponse(status, method, url);
       
       String textHtml="<html><head>\n  <title>"+status+" "+statusLine+
               "</title>\n</head><body>\n   <h1>"+statusLine+"</h1>\n   <p>"+
               detailStatus+"<br/></p>\n</body></html>";
        
        try (FileWriter fw = new FileWriter("src/temp/error.html")) {
               fw.write(textHtml);
           }            
        catch (Exception e) {
            e.getMessage();
        }
        return new File("src/temp/error.html");
    }
}
