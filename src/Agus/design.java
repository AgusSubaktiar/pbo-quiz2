package Agus;

import Agus.Item;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Toshiba
 */
public class design extends javax.swing.JFrame {
    private int id = 0; //variable ID kode transaksi
    private String code;    //variable untuk kode transaksi
    private DefaultTableModel tbModel;  //table model
    private  DefaultComboBoxModel cbModel;  //combobox model
    private ArrayList<Item> belanja = new ArrayList<>();    //variable pembelanjaan transaksi item
    
 
    public design() {   //konstruktor
        Model comboModel = new Model();
        this.cbModel = new DefaultComboBoxModel<>(comboModel.getJenisNama().toArray());
        
        TabelBarang tabelModel = new TabelBarang();
        this.tbModel = new DefaultTableModel(tabelModel.getKolomNama(), 0); // tabel kolom nama
        initComponents();
    }

    
    private  void incId(){  //penambahan id
        this.id += 1;
    }
    private  void decId(){  //pengurangan id
        this.id -= 1;
    }
    private  Object[] addItem(String nama, int jumlah){ //addItem Object
        float harga = 0;
        Model items = new Model();
        for(int i = 0 ; i < items.getHargaBarang().size(); i++){
            if(nama.equalsIgnoreCase(items.getJenisNama().get(i))){
            harga = items.getHargaBarang().get(i);
            }
        }
        Object[] obj = {
            nama,
            harga,
            jumlah
        };
        return obj;
    }
    
    private String setCode(){    //set fungsi code
        this.incId();
        String sk = new SimpleDateFormat("yyMMdd").format(new Date());  //menampilkan tanggal
        this.code = String.format(sk + "%02d", this.id);
        return code;
    }
    
    private  void updateJumlah(String nama, int add){   // update fungsi jumlah
        ArrayList<String> item = new ArrayList<>();
        for(int i = 0; i < tbModel.getRowCount(); i++){
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for(int i = 0; i < item.size(); i++){
            if(item.get(i).equals(nama)){
                int jumlah = new Integer (tbModel.getValueAt(i, 2).toString());
                tbModel.setValueAt(jumlah + add, i, 2);
            }
        }
    }
    private  boolean Duplicate(String nama){    // ngecek item double yang terpilih pada item sebelumnya
        boolean result = false;
        ArrayList<String> item = new ArrayList<>();
        for(int i = 0; i < tbModel.getRowCount(); i++){
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        for(String i : item){
            if(i.equals(nama)){
                result = true;
            }
        }
        return result;
    }
 
    private void belanja(){ //disable tombol remove dan save jiak isi table kosong
        if(isEmpty()){
            this.saveButton.setEnabled(false);
            this.removeButton.setEnabled(false);
        }else{
            this.saveButton.setEnabled(true);
            this.removeButton.setEnabled(true);
        }
    }
    
    private boolean isEmpty(){  // ngecek jika isi tabel kosong
        return this.tblBarang.getModel().getRowCount() <= 0;
    }
    
    private  void newTransaksi(){   // melakukan transaksi baru jika sudah transaksi sebelumnya
        this.itemValue.setText("");
        this.codeValue.setText("");
        this.newButton.setEnabled(true);
        this.saveButton.setEnabled(false);
        this.cancelButton.setEnabled(false);
        this.addButton.setEnabled(false);
        this.removeButton.setEnabled(false);
        this.removeButton.setEnabled(false);
        this.itemValue.setEnabled(false);
        this.itemComboBox.setEnabled(false);
        this.tbModel.setRowCount(0);
        this.belanja.clear();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codeValue = new javax.swing.JTextField();
        itemComboBox = new javax.swing.JComboBox<>();
        itemValue = new javax.swing.JTextField();
        newButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Code");

        jLabel2.setText("Items");

        codeValue.setDragEnabled(true);
        codeValue.setEnabled(false);

        itemComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Susu", "Gula", "Kopi" }));
        itemComboBox.setSelectedIndex(-1);
        itemComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemComboBox.setEnabled(false);

        itemValue.setEnabled(false);
        itemValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemValueActionPerformed(evt);
            }
        });

        newButton.setText("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.setEnabled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        tblBarang.setModel(this.tbModel);
        jScrollPane1.setViewportView(tblBarang);

        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(itemValue, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(codeValue)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(newButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                                .addGap(36, 36, 36))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(removeButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeButton)
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try{
            for(int i = 0; i < tbModel.getRowCount(); i++){ // looping setiap tabel
                String nama = tbModel.getValueAt(i, 0).toString();  //menyimpan nama dan jumlah menjadi variable
                float harga = new Float(tbModel.getValueAt(i, 1).toString());
                int jumlah = new Integer(tbModel.getValueAt(i, 2).toString());
                this.belanja.add(new Item(nama, harga, jumlah));
            }
            ItemTransaksi transaksi = new ItemTransaksi(this.code, this.belanja);   //Transaksi dengan kode dan comitted belanja
            StringBuilder sbr = new StringBuilder();    //menangani output transaksi
            sbr.append(transaksi.Pembayaran()); //menambahkan hasil transaksi
            JOptionPane.showMessageDialog(this, sbr, "Transaksi" , JOptionPane.INFORMATION_MESSAGE);    // memanggil dialog
            newTransaksi(); // melakukan transaksi baru
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void itemValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemValueActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        this.itemValue.setText("1");
        this.newButton.setEnabled(false);
        this.cancelButton.setEnabled(true);
        this.addButton.setEnabled(true);
        this.itemValue.setEnabled(true);
        this.itemComboBox.setEnabled(true);
        this.codeValue.setText(this.setCode());
    }//GEN-LAST:event_newButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String nama = this.itemComboBox.getSelectedItem().toString();
        int jumlah = new Integer(this.itemValue.getText());
        if(Duplicate(nama)){
            updateJumlah(nama, jumlah);
        }else{
            tbModel.addRow(addItem(nama, jumlah));
        }
        this.belanja();
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        newTransaksi();
        this.decId();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        if(tblBarang.getSelectedRow() <0){  // ngecek apakah ada baris yang dipilih
            String sbr = "Pilih item mau dihapus";
            JOptionPane.showMessageDialog(this, sbr,"Information",JOptionPane.INFORMATION_MESSAGE);
        }else{
            int count = tblBarang.getSelectedRows().length;  // ada baris yang dipilih, baris itu akan dihapus
            for(int i = 0; i < count; i++){
                tbModel.removeRow(tblBarang.getSelectedRow());
            }
        }
            this.belanja();
        
    }//GEN-LAST:event_removeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
            try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
            java.awt.EventQueue.invokeLater(new Runnable(){
                public void run(){
                    new design().setVisible(true);
                }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField codeValue;
    private javax.swing.JComboBox<String> itemComboBox;
    private javax.swing.JTextField itemValue;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable tblBarang;
    // End of variables declaration//GEN-END:variables

  

   
}
