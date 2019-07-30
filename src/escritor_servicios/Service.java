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
    private String dataType;
    private String miDataType;
    private Headers headers;
    private Data input;
    private Data output;

    public Service() {
        this.input = new Data();
        this.output = new Data();
        this.headers = new Headers();
        this.input.setName("data");
        this.output.setName("data");

    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
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

    public Data setData(Data data, Object contend) {
        if (contend.getClass().isAssignableFrom(java.util.LinkedHashMap.class)) {
            LinkedHashMap my_contend = (LinkedHashMap) contend;
            Set keys = my_contend.keySet();
            for (Object key : keys) {
                Data aux = new Data();
                aux.setName((String) key);
                aux = setData(aux, my_contend.get((String) key));
                data.setSub_data(aux);
            }
        } else if (contend.getClass().isAssignableFrom(java.util.ArrayList.class)) {
            ArrayList my_contend = (ArrayList) contend;
            for (Object object : my_contend) {
                data = setData(data, object);
            }
        } else if (contend.getClass().isAssignableFrom(String.class)) {
            Data aux = new Data();
            aux.setName((String) contend);
            data.setSub_data(aux);
        }
        return data;
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
            body = body.concat("data: " + getFormattedData(this.input) + ",\n");
        }
        if (this.headers != null) {
            body = body.concat("headers: {" + this.headers.getFormattedHeaders() + "},\n");
        }
        if (this.miDataType != null) {
            body = body.concat("dataType: '" + this.miDataType + "'\n");
        }
        return body;
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
            case "contentType":
                this.setContentType((String) value);
                break;
            case "datatype":
                this.setDataType((String) value);
                break;
            case "headers":
                this.setHeaders(value);
                break;
            case "input":
                this.input = setData(this.input, value);
                break;
            case "output":
                this.output = setData(this.output, value);
                break;
            default:
                System.err.println("Atributo no valido: " + key);
        }
    }

    private void setHeaders(Object contend) {
        if (contend.getClass().isAssignableFrom(java.util.ArrayList.class)) {
            ArrayList my_contend = (ArrayList) contend;
            my_contend.forEach((object) -> {
                this.headers.setHeader(new Header((String) object));
            });
        } else if (contend.getClass().isAssignableFrom(String.class)) {
            this.headers.setHeader(new Header((String) contend));
        }
    }

    private String getFormattedData(Data input) {
        if (this.input.getSub_data().isEmpty()) {
            return '"' + this.input.getName() + "\":\"\",";
        } else {
            String rta = "";
            for (Data data : input.getSub_data()) {
                rta += '"' + data.getName() + "\":{" + getFormattedData(data) + "},";
            }   
            return rta;
        }
    }
    
    
}
