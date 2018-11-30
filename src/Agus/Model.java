package Agus;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Toshiba
 */

public class Model {
    
    private HashMap<String, Float> items = new HashMap<>(); //hashMap
    

    public Model() {     //konstruktor
        this.items.put("Gula", new Float(20000));
        this.items.put("Kopi", new Float(5000));
        this.items.put("Susu", new Float(15000));
    }
    
    public ArrayList<String> getJenisNama(){     //ArrayList JenisNama Getter
        ArrayList<String> str = new ArrayList<>();
        for(String item : this.items.keySet()){
            str.add(item);
        }
        return str;
    }
    public ArrayList<Float> getHargaBarang(){    //ArrayList HargaBarang getter
        ArrayList<Float> flt = new ArrayList<>();
        for(float item : this.items.values()){
            flt.add(item);
        }
        return flt;
    }
    public void addItem(String nama, float harga){   //menambah item 
        this.items.put(nama, harga);
    }
    
}
