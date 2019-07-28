/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritor_servicios;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 *
 * @author diegocv
 */
public class Service {
    
    private String identifier;
    private String name;
    private String url;
    private String type;
    private String contentType;
    private String miDataType;
    private Headers headers;
    private Data input;
    private DataInput output;
    
    public Service() {
       this.input = new Data();
       this.input.setName("data");
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public Data getInput() {
        return input;
    }
    
    public Data setInput(Data data, Object contend) {
        if (contend.getClass().isAssignableFrom(java.util.LinkedHashMap.class)) {
            LinkedHashMap my_contend = (LinkedHashMap) contend;            
            Set keys = my_contend.keySet();
            for (Object key : keys) {
                Data aux = new Data();
                aux.setName((String) key);
                aux = setInput(aux, my_contend.get((String) key));
                data.setSub_data(aux);
            }      
        } else if (contend.getClass().isAssignableFrom(java.util.ArrayList.class)) {
            ArrayList my_contend = (ArrayList) contend;
            for (Object object : my_contend) {
                data = setInput(data, object);                        
            }
        } else if (contend.getClass().isAssignableFrom(String.class)) {     
            Data aux = new Data();
            aux.setName((String) contend);
            data.setSub_data(aux);
        }
        return data;
    }
    
    public void setOutput(DataInput output) {
        this.output = output;
    }
    
    String getFormattedInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    String getFormattedBody() {
        String body = "url: this.get_url('" + this.identifier + "'),\n";
        body = body.concat("type: '" + this.type + "',");
        if (this.contentType == null) {
            body = body.concat("contentType: \"application/json; charset=utf-8\",\n");
        } else {
            body = body.concat("contentType: \"" + this.contentType + "\",\n");
        }
        if (this.input != null) {
//            body = body.concat("data: " + this.input.getFormattedDataInput() + ",\n");
        }
        if (this.headers != null) {
            body = body.concat("headers: {" + this.headers.getFormattedHeaders() + "},\n");
        }
        if (this.miDataType != null) {
            body = body.concat("dataType: '" + this.miDataType + "'\n");
        }
        return body;
    }

    //url: this.obtener_url('"+servicio.getIndice()+"'),\n\t\ttype: '"servicio.getType()"',
//        contentType: "application/json; charset=utf-8",
//        data: JSON.stringify({ "sesion":{ "titulo":titulo, "descripcion":descripcion, "color":color, "textcolor":textcolor, "inicio":inicio, "anfitrion":anfitrion } }),
//        headers: {
//          "x-access-token": this.local.obtener_token()
//        },
//        
    @Override
    public String toString() {
        return "Servicio{" + "indice=" + identifier + ", name=" + name + ", url=" + url + ", type=" + type + ", contentType=" + contentType + ", miDataType=" + miDataType + ", headers=" + headers + ", input=" + input + ", output=" + output + '}';
    }
    
    void setAtributo(String key, Object value) {
        switch (key) {
            case "name":
                this.setName((String) value);
                break;
            
            case "url":
                this.setUrl((String) value);
                break;
            
            case "type":
                this.setType((String) value);
                break;
            
            case "input":
                this.input = setInput(this.input, value);
                System.out.println(this.input);
                break;
        }
    }
}
