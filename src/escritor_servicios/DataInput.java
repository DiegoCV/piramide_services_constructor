/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritor_servicios;
import java.util.ArrayList;
/**
 *
 * @author diegocv
 */
public class DataInput{

    private ArrayList<Data> data;
    
    public void setData(Data data){
        this.data.add(data);
    }

    public ArrayList<Data> getData() {
        return data;
    }
    
    
    
    String getFormattedDataInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
