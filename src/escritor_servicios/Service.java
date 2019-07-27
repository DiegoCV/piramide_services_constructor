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
//        this.input = new DataInput();
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

    public Data setInput(Object contend) {
        System.out.println(contend);
        System.out.println(contend.getClass());
        System.out.println(contend.getClass().isAssignableFrom(java.util.LinkedHashMap.class));
        LinkedHashMap<String,Object> g = (LinkedHashMap<String,Object>) contend;
        System.out.println(g.get("vendedor").getClass());
        ArrayList f = (ArrayList)g.get("vendedor");
        for (Object object : f) {
            System.out.println(object.getClass());
        }
        Data data = new Data();
//        if (contend.getClass().isAssignableFrom(java.util.LinkedHashMap.class)) {
//            data.setIsEntity(true);
////            data.setName((String)key);
////                    data.setMy_data(setInput(contend));
//            LinkedHashMap my_contend = (LinkedHashMap) contend;
//            Set keys = my_contend.keySet();
//            keys.forEach((Object key) -> {
//                Object f = my_contend.get((String) key);
//                if (f.getClass().isAssignableFrom(java.util.LinkedHashMap.class)) {
//                    
//
//                } else {
////                    System.out.println("jjuju");
//                }
////                System.out.println((String)key);
////                s.setAtributo((String)key, obj.get((String)key));               
//            });
//            data.setIsEntity(true);
////            System.out.println("jajaj");
////            System.out.println((LinkedHashMap) contend);
////            LinkedHashMap cc = (LinkedHashMap)contend;
////            cc.get(contend)
////            data.setName(name);
//        } else if (contend.getClass().isAssignableFrom(java.util.ArrayList.class)) {
//            java.util.ArrayList my_contend = (java.util.ArrayList)contend;
//            my_contend.forEach((cont) -> {
//                System.out.println(cont.getClass());
//                this.input = this.setInput(cont);
//            });
//        } else {
//            data.setIsEntity(false);
//            data.setValue((String) contend);
//        }
        return data;
    }

//    public DataInput getOutput() {
//        return output;
//    }

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
                setInput(value);
//                this.input = this.setInput(value);
                break;
        }
    }
}
