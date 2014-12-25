
package webserver;

/**
 *
 * @author franko
 */
public class DataBaseResponseError {

    protected static String detailedResponse(int status,String method,String resource) {
        String response;
        switch(status){
            case 400:
                    response="Your browser sent a request that this server could not understand.";
                    break;
            case 404:
                    response="The requested URL "+resource+" was not found on this server.";
                    break;
            case 501:
                    response=method+" to "+resource+" not supported.";
                    break;
            default:
                    response="Error detail not implemented";
                    break;
        }
        return response;
    }

    protected static String response(int status) {
        String response;
        switch(status){
            case 400:
                    response="Bad Request";
                    break;
            case 404:
                    response="Not Found";
                    break;
            case 501:
                    response="Method Not Implemented";
                    break;
            default:
                    response="Error not implemented";
                    break;
        }
        return response;
    }
    
}
