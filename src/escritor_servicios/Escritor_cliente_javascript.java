/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritor_servicios;

/**
 *
 * @author diegocv
 */
public class Escritor_cliente_javascript {
    public String construir_servicio(Service servicio){
        return servicio.getName()+"("+servicio.getFormattedInput()+") {\n"+
                "\t$.ajax({\n\t\t";
//        success: function (data) {
//          console.log(data);
//          validar_insertar_sesion(data);
//        }
//      });
  
    }
}
