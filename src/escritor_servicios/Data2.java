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
public class Data2 {

    private boolean isEntity;
    private String name;
    private ArrayList<Data2> my_data;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isIsEntity() {
        return isEntity;
    }

    public void setIsEntity(boolean isEntity) {
        this.isEntity = isEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    public void setMy_data(Data2 my_data) {
        this.my_data.add(my_data);
    }

  
}
