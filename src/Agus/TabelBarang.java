/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agus;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Toshiba
 */
public class TabelBarang extends DefaultTableModel{
    private String[] kolom; //untuk menyimpan nama kolom

    public TabelBarang() {  //konstruktor
        this.kolom = new String[]{
          "Nama" , "Harga"  , "Jumlah"
        };
    }
    public String[] getKolomNama(){ //getter KolomNama
        return this.kolom;
    }
}
