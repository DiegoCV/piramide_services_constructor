/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritor_servicios;

import java.util.ArrayList;

/**
 *
 * @author DiegoCarrascal
 */
public class Data {

    private String name;
    private ArrayList<Data> sub_data;
    private ArrayList<String> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Data> getSub_data() {
        return sub_data;
    }

    public void setSub_data(ArrayList<Data> sub_data) {
        this.sub_data = sub_data;
    }

    public ArrayList<String> getValues() {
        return values;
    }

    public void setValues(ArrayList<String> values) {
        this.values = values;
    }
    
    
   
}
