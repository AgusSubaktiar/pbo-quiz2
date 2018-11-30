/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agus;

/**
 *
 * @author Toshiba
 */
public class Item {
   
    private String nama;  //variable untuk menyimpan nama barang
   
    private float harga;  //variable untuk menyimpan harga barang
    
    private int jumlah;   //variable untuk menyimpan jumlah barang
    

    public Item() {   //Konstruktor
    }

    public Item(String nama, float harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public void setHarga(float harga) {  //setter dan getter untuk harga
        this.harga = harga;
    }

    public float getHarga() {
        return harga;
    }
   
    public void setNama(String nama) {   //setter dan getter untuk nama
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setJumlah(int jumlah) {  //setter dan getter untuk jumlah
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }
    public float getTotal(){       //hasil perkalian dari harga dan jumlah
        return this.harga * this.jumlah;
    }
    public String toString(){   //toString
        return this.nama;
    }
    
    
    
}
