
package webserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TeamWebServer
 */
public class ParametersManager {
    
    public Map<String, String> load(String parametros) {
        Map<String, String> tuplas = new HashMap<>();
        if(parametros.contains("=")){
            String[] atributoValor = parametros.split("&");
            String[] pareja;
            for(String tupla: atributoValor){
                pareja = tupla.split("=");
                tuplas.put(pareja[0], pareja[1].replace("+", " "));
            }
        }
        return tuplas;
   }

    public List<String> loadForFunction(String parametros) {
        List<String> datos = new ArrayList<>();
        if(parametros.contains("|")){
            String[] elementos = parametros.split("\\|");
            for(String elemento: elementos){
                datos.add(elemento);
            }
        }
        return datos;
    }

    public boolean goodElements(List<String> parametros) {
        boolean estaBien = numerosPrimeros(parametros);
        int indiceParametros = 0;
        while(estaBien && indiceParametros < parametros.size()){
            if(parametros.get(indiceParametros).length() == 0)
                estaBien = false;
            indiceParametros++;
        }
        return estaBien;
    }

    private boolean esNumero(String elemento) {
        boolean esNumero = true;
        int caracter = 0;
        while(esNumero && caracter < elemento.length()){
            if(!Character.isDigit(elemento.charAt(caracter)))
                esNumero = false;
            caracter++;
        }
        if(esNumero)
            esNumero = Integer.parseInt(elemento) > 0;
        return esNumero;
    }

    private boolean numerosPrimeros(List<String> parametros) {
        if(parametros.size() > 2 && esNumero(parametros.get(0)) && 
                esNumero(parametros.get(1))){
            int filas = Integer.parseInt(parametros.get(0));
            int columnas = Integer.parseInt(parametros.get(1));
            return parametros.size() - 2 - (filas * columnas) == 0;
        }
        return false;    
    }
}
