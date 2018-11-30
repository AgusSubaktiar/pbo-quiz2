package Agus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Toshiba
 */
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
public class ItemTransaksi {
    private final String kode;  //variable untuk menampilkan kode pembayaran 
    private  ArrayList<Item> items = new ArrayList();   //variabel item untuk menampilkan item apa saja yang dibeli
    private float total;    //variable menampilkan total pembelian

    public ItemTransaksi() {     //konstruktor
        this.kode = null;
    }
    

    public ItemTransaksi(String kode, ArrayList<Item> items) {
        this.kode = kode;
        this.items = items;
    }
    public void setTotal(){   //total setter
        float total = 0;
        for(Item item : this.items){
            total += item.getTotal();
        }
        this.total = total;
    }
    public String Pembayaran(){ //output dari transaksi
        setTotal();
        String obt = "";
        obt += "Kode\t\t : " + this.kode + "\n";
        obt += "Daftar Belanja : \n ";
        for (Item item : this.items){
            obt += "\t" + item.getNama()  + "(" + item.getJumlah() + ") : " +item.getTotal() + "\n" ;   
        }
        obt += "Total\t\t : " + this.total;
        return obt;
    }
    
}
