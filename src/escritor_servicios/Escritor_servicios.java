/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritor_servicios;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author diegocv
 */
public class Escritor_servicios {

    public static Service construir_servicio(String identifier, Map<String, Object> obj){
        Service s = new Service();
        s.setIdentifier(identifier);
        Set keys = obj.keySet();
        keys.forEach((Object key) -> {
            s.setAtributo((String)key, obj.get((String)key));               
        }); 
       return s;
    }
    /**
     * @param args the command line arguments
     */ 
   public static void main(String[] args) {
        try {
            Yaml yaml = new Yaml();
            String FILE_PATH="C:\\Users\\DiegoCarrascal\\Desktop\\escritor_servicios\\src\\escritor_servicios\\configuracion.yaml";  
            InputStream fileInputStream = new FileInputStream(FILE_PATH);
            Map<String, Object> obj = yaml.load(fileInputStream);
            Service[] servicios = new Service[obj.size()];
            for (int i = 1; i <= obj.size(); i++) {
                servicios[i-1] = Escritor_servicios.construir_servicio("s_"+i,(Map<String, Object>) obj.get("s_"+i));
            }
//
//            for (Service s : servicios) {
//                System.out.println(s.toString());
//            }
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Escritor_servicios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
//{vendedor=[nombre, celular, {juju=[gff, kiki, {lol=[fr, ñlop]}]}]}
//#Segundo servicio
//s_2:
//  name: verificar_vendedor
//  url: /vendedor/verificar
//  type: post
//  input:
//    - codigo
//    - pass
//  output:
//    - status
//
//#Tercer servicio
//s_3:
//  name: agendar_sesiones
//  url: /sesion/agendar
//  type: post
//  headers: 
//    -x-access-token
//  input:
//    sesion:
//      - titulo
//      - descripcion
//      - color
//      - textcolor
//      - inicio
//      - anfitrion
//  output:
//    - status

