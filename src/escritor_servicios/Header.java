/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritor_servicios;

/**
 *
 * @author DiegoCarrascal
 */
class Header {
    private String key,value;

    public Header(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
    public String getFormattedHeader(){
        return  '"'+this.key+"\":\""+this.value+'"';
    }
    
    /*
    El parametro format definira la manera en que se devolvera la cadena
    Un ejemplo de este format es el siguiente : "%":%
    */
    public String getFormattedHeader(String format){
        format = format.replaceFirst("%", this.key);
        format = format.replaceFirst("%", this.value);
        return format;
    }
}
