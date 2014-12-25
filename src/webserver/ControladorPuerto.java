package webserver;

import http.responses.HttpResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TeamServr
 */
public class ControladorPuerto {
    
    private WebServer servidor;
    
    public ControladorPuerto(WebServer servidor){
        this.servidor = servidor;
    }
    
    public void listeningPort(){
        BufferedReader entradaCliente;
        DataOutputStream salidaServer;
        String peticion = "";
        int tamano = 0;
        try (ServerSocket puertoServidor = new ServerSocket(WebServer.PUERTO)) {
            Socket puerto = puertoServidor.accept();
            entradaCliente = new BufferedReader(new InputStreamReader(
                    puerto.getInputStream()));
            salidaServer = new DataOutputStream(puerto.getOutputStream());
            String linea = "";
            int indiceLinea = 0;

            while((linea = entradaCliente.readLine()) != null){
                if(linea.length() == 0){
                    break;
                }
                if(indiceLinea != 0){
                    peticion = peticion + "\n";
                }
                if(linea.startsWith("Content-Length: ")){
                    tamano = Integer.parseInt(linea.substring(16));
                }
                indiceLinea++;
                peticion = peticion + linea; 
            }
            
            atenderPeticion(tamano, entradaCliente, peticion, salidaServer);
            
        } catch (IOException ex) {
            Logger.getLogger(WebServer.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex.getMessage());
        }
        
    }
    
    private void atenderPeticion(int tamano, BufferedReader entradaCliente, 
            String peticion, DataOutputStream salidaServer) throws IOException {
        
        String parametros = leerParametros(tamano, entradaCliente);
        HttpResponse response;
        System.out.println(peticion);
        System.out.println(parametros);   
            
        response = servidor.responseRequest(peticion, parametros);
 
        salidaServer.writeUTF(response.render());
        System.out.println(response.render());
        salidaServer.close();
    }

    private String leerParametros(int tamano, BufferedReader entrada) 
            throws IOException {
        String parametros = "";
        for(int indiceCaracter = 0; indiceCaracter < tamano; indiceCaracter++){
            parametros = parametros + (char)entrada.read();
        }
        return parametros;
    }
}
