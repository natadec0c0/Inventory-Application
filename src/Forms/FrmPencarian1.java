/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmBarang.java
 *
 * Created on 03 Des 11, 13:12:55
 */
package Forms;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.text.*;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

//import jie.koneksi.Koneksi;
/**
 *
 * @author Lidia Manik
 */
public final class FrmPencarian1 extends javax.swing.JInternalFrame {
    cls.ClassDB koneksi = new cls.ClassDB();
    private Object tblbarang;
    Map<String, Object> param = new HashMap<String, Object>();
    private DefaultTableModel model;
   Connection conn;
    Statement stat;
    ResultSet hasil;

    public FrmPencarian1() {
        initComponents();
        datatabel();
        TampilJenis();
        panelawal.setVisible(true);
        panel1kategori.setVisible(false);
        panel2kategori.setVisible(false);
        panel3kategori.setVisible(false);
        panel4kategori.setVisible(false);
        panel5kategori.setVisible(false);
        panel6kategori.setVisible(false);
        panel7kategori.setVisible(false);
        datatabel3.setVisible(true);    
    }

public void bersihkan(){
    cbojenis.setEnabled(false);
    txttahunawal.setEnabled(false);
    txttahunakhir.setEnabled(false);
    cbobagian.setEnabled(false);
    cboseksi.setEnabled(false);
    cboruang.setEnabled(false);
    cbokondisi.setEnabled(false);
    cboketerangan.setEnabled(false);
    cbojenis1.setEnabled(false);    
    txttahunawal1.setEnabled(false);
    txttahunakhir1.setEnabled(false);
    cbobagian1.setEnabled(false);
    cboseksi1.setEnabled(false);
    cboruang1.setEnabled(false);
    cbokondisi1.setEnabled(false);
    cboketerangan1.setEnabled(false);
    cbojenis2.setEnabled(false);
    txttahunawal2.setEnabled(false);
    txttahunakhir2.setEnabled(false);
    cbobagian2.setEnabled(false);
    cboseksi2.setEnabled(false);
    cboruang2.setEnabled(false);
    cbokondisi2.setEnabled(false);
    cboketerangan2.setEnabled(false);
    cbojenis3.setEnabled(false);
    txttahunawal3.setEnabled(false);
    txttahunakhir3.setEnabled(false);
    cbobagian3.setEnabled(false);
    cboseksi3.setEnabled(false);
    cboruang3.setEnabled(false);
    cbokondisi3.setEnabled(false);
    cboketerangan3.setEnabled(false);
    cbojenis4.setEnabled(false);
    txttahunawal4.setEnabled(false);
    txttahunakhir4.setEnabled(false);
    cbobagian4.setEnabled(false);
    cboseksi4.setEnabled(false);
    cboruang4.setEnabled(false);
    cbokondisi4.setEnabled(false);
    cboketerangan4.setEnabled(false);
    cbojenis5.setEnabled(false);
    txttahunawal5.setEnabled(false);
    txttahunakhir5.setEnabled(false);
    cbobagian5.setEnabled(false);
    cboseksi5.setEnabled(false);
    cboruang5.setEnabled(false);
    cbokondisi5.setEnabled(false);
    cboketerangan5.setEnabled(false);
    cbojenis6.setEnabled(false);
    txttahunawal6.setEnabled(false);
    txttahunakhir6.setEnabled(false);
    cbobagian6.setEnabled(false);
    cboseksi6.setEnabled(false);
    cboruang6.setEnabled(false);
    cbokondisi6.setEnabled(false);
    cboketerangan6.setEnabled(false);
}


    public void datatabel(){
        Object[] Baris={"No. Inventaris","Jenis Inventaris","Nama Inventaris","Tahun","Bagian","Seksi","Ruang","Kondisi","Keterangan"};
        DefaultTableModel tabmode = new DefaultTableModel(null, Baris);
        datatabel.setModel(tabmode);
        String sql="";
        if (cekjenis.isSelected()){
        panel1kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis.getSelectedItem()+"%'";
        }
        else if(cektahun.isSelected())
        {
        panel1kategori.setVisible(true);
            sql = "select * from tblbarang where tahun between "+txttahunawal.getText()+" and "+txttahunakhir.getText();
        }
        else if (cekbagian.isSelected()){
        panel1kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian.getSelectedItem()+"%'";
        }
        else if (cekseksi.isSelected()){
        panel1kategori.setVisible(true);
            sql = "select * from tblbarang where seksi like '%"+cboseksi.getSelectedItem()+"%'";
        }
        else if (cekruang.isSelected()){
        panel1kategori.setVisible(true);
            sql = "select * from tblbarang where ruang like '%"+cboruang.getSelectedItem()+"%'";
        }
        else if (cekkondisi.isSelected()){
        panel1kategori.setVisible(true);
            sql = "select * from tblbarang where kondisi like '%"+cbokondisi.getSelectedItem()+"%'";
        }
        else if (cekketerangan.isSelected()){
        panel1kategori.setVisible(true);
            sql = "select * from tblbarang where keterangan like '%"+cboketerangan.getSelectedItem()+"%'";
        }


        //2 kondisi --> permutasi
        else if(cekjenis1.isSelected() && cekbagian1.isSelected())
            {
            panel2kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis1.getSelectedItem()+"%' and bagian like '%"+cbobagian1.getSelectedItem()+"%'";
        }
        else if(cekjenis1.isSelected() && cektahun1.isSelected())
            {
            panel2kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis1.getSelectedItem()+"%' and tahun between "+txttahunawal1.getText()+" and "+txttahunakhir1.getText();
        }
        else if (cekjenis1.isSelected() && cekseksi1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis1.getSelectedItem()+"%' and seksi like '%"+cboseksi1.getSelectedItem()+"%'";
        }
        else if (cekjenis1.isSelected() && cekruang1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis1.getSelectedItem()+"%' and ruang like '%"+cboruang1.getSelectedItem()+"%'";
        }
        else if (cekjenis1.isSelected() && cekkondisi1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis1.getSelectedItem()+"%' and kondisi like '%"+cbokondisi1.getSelectedItem()+"%'";
        }
        else if (cekjenis1.isSelected() && cekketerangan1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis1.getSelectedItem()+"%' and keterangan like '%"+cboketerangan1.getSelectedItem()+"%'";
        }

        else if(cektahun1.isSelected() && cekbagian1.isSelected())
            {
            panel2kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian1.getSelectedItem()+"%' and tahun between "+txttahunawal1.getText()+" and "+txttahunakhir1.getText();
        }
        else if(cektahun1.isSelected() && cekseksi1.isSelected())
            {
            panel2kategori.setVisible(true);
            sql = "select * from tblbarang where seksi like '%"+cboseksi1.getSelectedItem()+"%' and tahun between "+txttahunawal1.getText()+" and "+txttahunakhir1.getText();
        }
        else if(cektahun1.isSelected() && cekruang1.isSelected())
            {
            panel2kategori.setVisible(true);
            sql = "select * from tblbarang where ruang like '%"+cboruang1.getSelectedItem()+"%' and tahun between "+txttahunawal1.getText()+" and "+txttahunakhir1.getText();
        }
        else if(cektahun1.isSelected() && cekkondisi1.isSelected())
            {
            panel2kategori.setVisible(true);
            sql = "select * from tblbarang where kondisi like '%"+cbokondisi1.getSelectedItem()+"%' and tahun between "+txttahunawal1.getText()+" and "+txttahunakhir1.getText();
        }
        else if(cektahun1.isSelected() && cekketerangan1.isSelected())
            {
            panel2kategori.setVisible(true);
            sql = "select * from tblbarang where keterangan like '%"+cboketerangan1.getSelectedItem()+"%' and tahun between "+txttahunawal1.getText()+" and "+txttahunakhir1.getText();
        }
        else if (cekbagian1.isSelected() && cekseksi1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian1.getSelectedItem()+"%' and seksi like '%"+cboseksi1.getSelectedItem()+"%'";
        }
        else if (cekbagian1.isSelected() && cekruang1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian1.getSelectedItem()+"%' and ruang like '%"+cboruang1.getSelectedItem()+"%'";
        }
        else if (cekbagian1.isSelected() && cekkondisi1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian1.getSelectedItem()+"%' and kondisi like '%"+cbokondisi1.getSelectedItem()+"%'";
        }
        else if (cekbagian1.isSelected() && cekketerangan1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian1.getSelectedItem()+"%' and keterangan like '%"+cboketerangan1.getSelectedItem()+"%'";
        }
        else if (cekseksi1.isSelected() && cekruang1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where seksi like '%"+cboseksi1.getSelectedItem()+"%' and ruang like '%"+cboruang1.getSelectedItem()+"%'";
        }
        else if (cekseksi1.isSelected() && cekkondisi1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where seksi like '%"+cboseksi1.getSelectedItem()+"%' and kondisi like '%"+cbokondisi1.getSelectedItem()+"%'";
        }  
        else if (cekseksi1.isSelected() && cekketerangan1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where seksi like '%"+cboseksi1.getSelectedItem()+"%' and keterangan like '%"+cboketerangan1.getSelectedItem()+"%'";
        }
        else if (cekruang1.isSelected() && cekkondisi1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where ruang like '%"+cboruang1.getSelectedItem()+"%' and kondisi like '%"+cbokondisi1.getSelectedItem()+"%'";
        }
        else if (cekruang1.isSelected() && cekketerangan1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where ruang like '%"+cboruang1.getSelectedItem()+"%' and keterangan like '%"+cboketerangan1.getSelectedItem()+"%'";
        }
        else if (cekkondisi1.isSelected() && cekketerangan1.isSelected())
            {panel2kategori.setVisible(true);
            sql = "select * from tblbarang where kondisi like '%"+cbokondisi1.getSelectedItem()+"%' and keterangan like '%"+cboketerangan1.getSelectedItem()+"%'";
        }


        //3 kondisi -->permutasi : 20 kemungkinan
        else if(cekjenis2.isSelected() && cektahun2.isSelected() && cekbagian2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and bagian like '%"+cbobagian2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if(cekjenis2.isSelected() && cektahun2.isSelected() && cekseksi2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and seksi like '%"+cboseksi2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if(cekjenis2.isSelected() && cektahun2.isSelected() && cekruang2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and ruang like '%"+cboruang2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if(cekjenis2.isSelected() && cektahun2.isSelected() && cekkondisi2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and kondisi like '%"+cbokondisi2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if(cekjenis2.isSelected() && cektahun2.isSelected() && cekketerangan2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and keterangan like '%"+cboketerangan2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if(cekjenis2.isSelected() && cekbagian2.isSelected() && cekseksi2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and bagian like '%"+cbobagian2.getSelectedItem()+"%'and seksi like '%"+cboseksi2.getSelectedItem()+"%'";
        }
        else if (cekjenis2.isSelected() && cekbagian2.isSelected()&& cekruang2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and bagian like '%"+cbobagian2.getSelectedItem()+"%'and ruang like '%"+cboruang2.getSelectedItem()+"%'";
        }
        else if (cekjenis2.isSelected() && cekbagian2.isSelected()&& cekkondisi2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and bagian like '%"+cbobagian2.getSelectedItem()+"%'and kondisi like '%"+cbokondisi2.getSelectedItem()+"%'";
        }
        else if (cekjenis2.isSelected() && cekbagian2.isSelected()&& cekketerangan2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and bagian like '%"+cbobagian2.getSelectedItem()+"%'and keterangan like '%"+cboketerangan2.getSelectedItem()+"%'";
        }
        else if (cekjenis2.isSelected() && cekseksi2.isSelected()&& cekruang2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and seksi like '%"+cboseksi2.getSelectedItem()+"%'and ruang like '%"+cboruang2.getSelectedItem()+"%'";
        }
        else if (cekjenis2.isSelected() && cekseksi2.isSelected()&& cekkondisi2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and seksi like '%"+cboseksi2.getSelectedItem()+"%'and kondisi like '%"+cbokondisi2.getSelectedItem()+"%'";
        }
        else if (cekjenis2.isSelected() && cekseksi2.isSelected()&& cekketerangan2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and seksi like '%"+cboseksi2.getSelectedItem()+"%'and keterangan like '%"+cboketerangan2.getSelectedItem()+"%'";
        }
        else if (cekjenis2.isSelected() && cekruang2.isSelected()&& cekkondisi2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and ruang like '%"+cboruang2.getSelectedItem()+"%'and kondisi like '%"+cbokondisi2.getSelectedItem()+"%'";
        }
        else if (cekjenis2.isSelected() && cekruang2.isSelected()&& cekketerangan2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and ruang like '%"+cboruang2.getSelectedItem()+"%'and keterangan like '%"+cboketerangan2.getSelectedItem()+"%'";
        }
        else if (cekjenis2.isSelected() && cekkondisi2.isSelected()&& cekketerangan2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis2.getSelectedItem()+"%'and kondisi like '%"+cbokondisi2.getSelectedItem()+"%'and keterangan like '%"+cboketerangan2.getSelectedItem()+"%'";
        }

        else if (cektahun2.isSelected()&& cekbagian2.isSelected() && cekseksi2.isSelected()){
            sql = "select * from tblbarang where seksi like '%"+cboseksi2.getSelectedItem()+"%'and bagian like '%"+cbobagian2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if (cektahun2.isSelected()&& cekbagian2.isSelected() && cekruang2.isSelected()){
            sql = "select * from tblbarang where ruang like '%"+cboruang2.getSelectedItem()+"%'and bagian like '%"+cbobagian2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if (cektahun2.isSelected()&& cekbagian2.isSelected() && cekkondisi2.isSelected()){
            sql = "select * from tblbarang where kondisi like '%"+cbokondisi2.getSelectedItem()+"%'and bagian like '%"+cbobagian2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if (cektahun2.isSelected()&& cekbagian2.isSelected() && cekketerangan2.isSelected()){
            sql = "select * from tblbarang where keterangan like '%"+cboketerangan2.getSelectedItem()+"%'and bagian like '%"+cbobagian2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if (cektahun2.isSelected()&& cekseksi2.isSelected() && cekruang2.isSelected()){
            sql = "select * from tblbarang where ruang like '%"+cboruang2.getSelectedItem()+"%'and seksi like '%"+cboseksi2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if (cektahun2.isSelected()&& cekseksi2.isSelected() && cekkondisi2.isSelected()){
            sql = "select * from tblbarang where kondisi like '%"+cbokondisi2.getSelectedItem()+"%'and seksi like '%"+cboseksi2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if (cektahun2.isSelected()&& cekseksi2.isSelected() && cekketerangan2.isSelected()){
            sql = "select * from tblbarang where keterangan like '%"+cboketerangan2.getSelectedItem()+"%'and seksi like '%"+cboseksi2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if (cektahun2.isSelected()&& cekruang2.isSelected() && cekkondisi2.isSelected()){
            sql = "select * from tblbarang where kondisi like '%"+cbokondisi2.getSelectedItem()+"%'and ruang like '%"+cboruang2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if (cektahun2.isSelected()&& cekruang2.isSelected() && cekketerangan2.isSelected()){
            sql = "select * from tblbarang where keterangan like '%"+cboketerangan2.getSelectedItem()+"%'and ruang like '%"+cboruang2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }
        else if (cektahun2.isSelected()&& cekkondisi2.isSelected() && cekketerangan2.isSelected()){
            sql = "select * from tblbarang where keterangan like '%"+cboketerangan2.getSelectedItem()+"%'and kondisi like '%"+cbokondisi2.getSelectedItem()+"%'and tahun between "+txttahunawal2.getText()+" and "+txttahunakhir2.getText();
        }

        else if (cekbagian2.isSelected() && cekseksi2.isSelected()&& cekruang2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian2.getSelectedItem()+"%'and seksi like '%"+cboseksi2.getSelectedItem()+"%'and ruang like '%"+cboruang2.getSelectedItem()+"%'";
        }       
        else if (cekbagian2.isSelected() && cekseksi2.isSelected()&& cekkondisi2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian2.getSelectedItem()+"%'and seksi like '%"+cboseksi2.getSelectedItem()+"%'and kondisi like '%"+cbokondisi2.getSelectedItem()+"%'";
        }
        else if (cekbagian2.isSelected() && cekseksi2.isSelected()&& cekketerangan2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian2.getSelectedItem()+"%'and seksi like '%"+cboseksi2.getSelectedItem()+"%'and keterangan like '%"+cboketerangan2.getSelectedItem()+"%'";
        }
        else if (cekbagian2.isSelected() && cekruang2.isSelected()&& cekkondisi2.isSelected())
            {  panel3kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian2.getSelectedItem()+"%'and ruang like '%"+cboruang2.getSelectedItem()+"%'and kondisi like '%"+cbokondisi2.getSelectedItem()+"%'";
        }
        else if (cekbagian2.isSelected() && cekruang2.isSelected()&& cekketerangan2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian2.getSelectedItem()+"%'and ruang like '%"+cboruang2.getSelectedItem()+"%'and keterangan like '%"+cboketerangan2.getSelectedItem()+"%'";
        }
        else if (cekbagian2.isSelected() && cekkondisi2.isSelected()&& cekketerangan2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian2.getSelectedItem()+"%'and kondisi like '%"+cbokondisi2.getSelectedItem()+"%'and keterangan like '%"+cboketerangan2.getSelectedItem()+"%'";
        }
        else if (cekseksi2.isSelected() && cekruang2.isSelected()&& cekkondisi2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where seksi like '%"+cboseksi2.getSelectedItem()+"%'and ruang like '%"+cboruang2.getSelectedItem()+"%'and kondisi like '%"+cbokondisi2.getSelectedItem()+"%'";
        }
        else if (cekseksi2.isSelected() && cekruang2.isSelected()&& cekketerangan2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where seksi like '%"+cboseksi.getSelectedItem()+"%'and ruang like '%"+cboruang2.getSelectedItem()+"%'and keterangan like '%"+cboketerangan2.getSelectedItem()+"%'";
        }
        else if (cekseksi2.isSelected() && cekkondisi2.isSelected()&& cekketerangan2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where seksi like '%"+cboseksi.getSelectedItem()+"%'and kondisi like '%"+cbokondisi2.getSelectedItem()+"%'and keterangan like '%"+cboketerangan2.getSelectedItem()+"%'";
        }
        else if (cekruang2.isSelected() && cekkondisi2.isSelected()&& cekketerangan2.isSelected())
            {panel3kategori.setVisible(true);
            sql = "select * from tblbarang where ruang like '%"+cboruang2.getSelectedItem()+"%'and kondisi like '%"+cboruang2.getSelectedItem()+"%'and keterangan like '%"+cboketerangan2.getSelectedItem()+"%'";
        }


        //4 kondisi  -> permutasi 15
        else if (cekjenis3.isSelected()  && cektahun3.isSelected() && cekbagian3.isSelected()&& cekseksi3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and bagian like '%"+cbobagian3.getSelectedItem()+"%'and seksi like '%"+cboseksi3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cekjenis3.isSelected()  && cektahun3.isSelected() && cekbagian3.isSelected()&& cekruang3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and bagian like '%"+cbobagian3.getSelectedItem()+"%'and ruang like '%"+cboruang3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cekjenis3.isSelected()  && cektahun3.isSelected() && cekbagian3.isSelected()&& cekkondisi3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and bagian like '%"+cbobagian3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cekjenis3.isSelected()  && cektahun3.isSelected() && cekbagian3.isSelected()&& cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and bagian like '%"+cbobagian3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cekjenis3.isSelected()  && cektahun3.isSelected() && cekseksi3.isSelected()&& cekruang3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and ruang like '%"+cboruang3.getSelectedItem()+"%'and seksi like '%"+cboseksi3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cekjenis3.isSelected()  && cektahun3.isSelected() && cekseksi3.isSelected()&& cekkondisi3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and seksi like '%"+cboseksi3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cekjenis3.isSelected()  && cektahun3.isSelected() && cekseksi3.isSelected()&& cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'and seksi like '%"+cboseksi3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cekjenis3.isSelected()  && cektahun3.isSelected()&& cekruang3.isSelected()  && cekkondisi3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and ruang like '%"+cboruang3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cekjenis3.isSelected()  && cektahun3.isSelected()&& cekruang3.isSelected()  && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and ruang like '%"+cboruang3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cekjenis3.isSelected()  && cektahun3.isSelected() && cekkondisi3.isSelected()&& cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and keterangan like '%"+cboketerangan3.getSelectedItem()+ "%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }

        else if (cekjenis3.isSelected() && cekbagian3.isSelected()&& cekseksi3.isSelected() && cekruang3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and bagian like '%"+cbobagian3.getSelectedItem()+"%'and seksi like '%"+cboseksi3.getSelectedItem()+"%'and ruang like '%"+cboruang3.getSelectedItem()+"%'";
        }
        else if (cekjenis3.isSelected() && cekbagian3.isSelected()&& cekseksi3.isSelected() && cekkondisi3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and bagian like '%"+cbobagian3.getSelectedItem()+"%'and seksi like '%"+cboseksi3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'";
        }
        else if (cekjenis3.isSelected() && cekbagian3.isSelected()&& cekseksi3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and bagian like '%"+cbobagian3.getSelectedItem()+"%'and seksi like '%"+cboseksi3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'";
        }
       else if (cekjenis3.isSelected() && cekbagian3.isSelected()&& cekruang3.isSelected() && cekkondisi3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and bagian like '%"+cbobagian3.getSelectedItem()+"%'and ruang like '%"+cboruang3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'";
        }
       else if (cekjenis3.isSelected() && cekbagian3.isSelected()&& cekruang3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and bagian like '%"+cbobagian3.getSelectedItem()+"%'and ruang like '%"+cboruang3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'";
        }

        else if (cekjenis3.isSelected() && cekbagian3.isSelected()&& cekkondisi3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and bagian like '%"+cbobagian3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'";
        }
        else if (cekjenis3.isSelected() && cekseksi3.isSelected()&& cekruang3.isSelected() && cekkondisi3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and seksi like '%"+cboseksi3.getSelectedItem()+"%'and ruang like '%"+cboruang3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'";
        }
        else if (cekjenis3.isSelected() && cekseksi3.isSelected()&& cekruang3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and seksi like '%"+cboseksi3.getSelectedItem()+"%'and ruang like '%"+cboruang3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'";
        }
        else if (cekjenis3.isSelected() && cekseksi3.isSelected()&& cekkondisi3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and seksi like '%"+cboseksi3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'";
        }
        else if (cekjenis3.isSelected() && cekruang3.isSelected() && cekkondisi3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis3.getSelectedItem()+"%' and ruang like '%"+cboruang3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'";
        }



        else if (cektahun3.isSelected() && cekbagian3.isSelected() && cekseksi3.isSelected()&& cekruang3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian3.getSelectedItem()+"%' and seksi like '%"+cboseksi3.getSelectedItem()+"%'and ruang like '%"+cboruang3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cektahun3.isSelected() && cekbagian3.isSelected() && cekseksi3.isSelected()&& cekkondisi3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian3.getSelectedItem()+"%' and seksi like '%"+cboseksi3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cektahun3.isSelected() && cekbagian3.isSelected() && cekseksi3.isSelected()&& cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian3.getSelectedItem()+"%' and seksi like '%"+cboseksi3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cektahun3.isSelected() && cekbagian3.isSelected() && cekruang3.isSelected() && cekkondisi3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian3.getSelectedItem()+"%' and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and ruang like '%"+cboruang3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cektahun3.isSelected() && cekbagian3.isSelected() && cekruang3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian3.getSelectedItem()+"%' and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'and ruang like '%"+cboruang3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cektahun3.isSelected() && cekbagian3.isSelected() && cekkondisi3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian3.getSelectedItem()+"%' and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cektahun3.isSelected() && cekseksi3.isSelected()&& cekruang3.isSelected() && cekkondisi3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where ruang like '%"+cboruang3.getSelectedItem()+"%' and seksi like '%"+cboseksi3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cektahun3.isSelected() && cekseksi3.isSelected()&& cekruang3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where ruang like '%"+cboruang3.getSelectedItem()+"%' and seksi like '%"+cboseksi3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cektahun3.isSelected() && cekseksi3.isSelected()&& cekkondisi3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where kondisi like '%"+cbokondisi3.getSelectedItem()+"%' and seksi like '%"+cboseksi3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        else if (cektahun3.isSelected() && cekruang3.isSelected() && cekkondisi3.isSelected()&& cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where ruang like '%"+cboruang3.getSelectedItem()+"%' and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'and tahun between "+txttahunawal3.getText()+" and "+txttahunakhir3.getText();
        }
        

        else if (cekbagian3.isSelected() && cekseksi3.isSelected()&& cekruang3.isSelected() && cekkondisi3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian3.getSelectedItem()+"%' and seksi like '%"+cboseksi3.getSelectedItem()+"%'and ruang like '%"+cboruang3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'";
        }
        else if (cekbagian3.isSelected() && cekseksi3.isSelected()&& cekruang3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian3.getSelectedItem()+"%' and seksi like '%"+cboseksi3.getSelectedItem()+"%'and ruang like '%"+cboruang3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'";
        }
        else if (cekbagian3.isSelected() && cekseksi3.isSelected()&& cekkondisi3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian3.getSelectedItem()+"%' and seksi like '%"+cboseksi3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%'and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'";
        }
       else if (cekbagian3.isSelected() && cekruang3.isSelected() && cekkondisi3.isSelected()&& cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian3.getSelectedItem()+"%' and ruang like '%"+cboruang3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%' and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'";
        }
        else if (cekseksi3.isSelected()&& cekruang3.isSelected() && cekkondisi3.isSelected() && cekketerangan3.isSelected())
            {panel4kategori.setVisible(true);
            sql = "select * from tblbarang where seksi like '%"+cboseksi3.getSelectedItem()+"%'and ruang like '%"+cboruang3.getSelectedItem()+"%'and kondisi like '%"+cbokondisi3.getSelectedItem()+"%' and keterangan like '%"+cboketerangan3.getSelectedItem()+"%'";
        }



        //5 kondisi --> permutasi : 6
        else if (cekjenis4.isSelected() && cektahun4.isSelected() && cekbagian4.isSelected()&& cekseksi4.isSelected() && cekruang4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and bagian like '%"+cbobagian4.getSelectedItem()+"%'and seksi like '%"+cboseksi4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cekjenis4.isSelected() && cektahun4.isSelected() && cekbagian4.isSelected()&& cekseksi4.isSelected() && cekkondisi4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and bagian like '%"+cbobagian4.getSelectedItem()+"%'and seksi like '%"+cboseksi4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cekjenis4.isSelected() && cektahun4.isSelected() && cekbagian4.isSelected()&& cekseksi4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and bagian like '%"+cbobagian4.getSelectedItem()+"%'and seksi like '%"+cboseksi4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%'and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cekjenis4.isSelected() && cektahun4.isSelected() && cekbagian4.isSelected()&& cekruang4.isSelected() && cekkondisi4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and bagian like '%"+cbobagian4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cekjenis4.isSelected() && cektahun4.isSelected() && cekbagian4.isSelected()&& cekruang4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and bagian like '%"+cbobagian4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%'and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cekjenis4.isSelected() && cektahun4.isSelected() && cekbagian4.isSelected()&& cekkondisi4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and bagian like '%"+cbobagian4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%'and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cekjenis4.isSelected() && cektahun4.isSelected() && cekseksi4.isSelected()&& cekruang4.isSelected() && cekkondisi4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and seksi like '%"+cboseksi4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cekjenis4.isSelected() && cektahun4.isSelected() && cekseksi4.isSelected()&& cekruang4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and seksi like '%"+cboseksi4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%'and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cekjenis4.isSelected() && cektahun4.isSelected() && cekseksi4.isSelected()&& cekkondisi4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and seksi like '%"+cboseksi4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%'and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cekjenis4.isSelected() && cektahun4.isSelected() && cekruang4.isSelected()&& cekkondisi4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and ruang like '%"+cboruang4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%'and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }


        else if (cekjenis4.isSelected() && cekbagian4.isSelected()&& cekseksi4.isSelected() && cekruang4.isSelected() && cekkondisi4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and bagian like '%"+cbobagian4.getSelectedItem()+"%'and seksi like '%"+cboseksi4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'";
        }
       else if (cekjenis4.isSelected() && cekbagian4.isSelected()&& cekseksi4.isSelected() && cekruang4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and bagian like '%"+cbobagian4.getSelectedItem()+"%'and seksi like '%"+cboseksi4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%'";
        }
       else if (cekjenis4.isSelected() && cekbagian4.isSelected()&& cekseksi4.isSelected() && cekkondisi4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and bagian like '%"+cbobagian4.getSelectedItem()+"%'and seksi like '%"+cboseksi4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%'";
        }
       else if (cekjenis4.isSelected() && cekbagian4.isSelected()&& cekruang4.isSelected() && cekkondisi4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and bagian like '%"+cbobagian4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%'";
        }
        else if (cekjenis4.isSelected() && cekseksi4.isSelected() && cekruang4.isSelected() && cekkondisi4.isSelected() && cekketerangan4.isSelected() )
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis4.getSelectedItem()+"%' and seksi like '%"+cboseksi4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%' and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%'";
        }



        else if (cektahun4.isSelected()&& cekbagian4.isSelected()&& cekseksi4.isSelected() && cekruang4.isSelected() && cekkondisi4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian4.getSelectedItem()+"%'and seksi like '%"+cboseksi4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%' and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cektahun4.isSelected()&& cekbagian4.isSelected()&& cekseksi4.isSelected() && cekruang4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian4.getSelectedItem()+"%'and seksi like '%"+cboseksi4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%' and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cektahun4.isSelected()&& cekbagian4.isSelected()&& cekseksi4.isSelected() && cekkondisi4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian4.getSelectedItem()+"%'and seksi like '%"+cboseksi4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%' and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cektahun4.isSelected()&& cekbagian4.isSelected() && cekruang4.isSelected()&& cekkondisi4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%' and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }
        else if (cektahun4.isSelected()&& cekseksi4.isSelected() && cekruang4.isSelected()&& cekkondisi4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where seksi like '%"+cboseksi4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%'and keterangan like '%"+cboketerangan4.getSelectedItem()+"%' and tahun between "+txttahunawal4.getText()+" and "+txttahunakhir4.getText();
        }


        else if (cekbagian4.isSelected()&& cekseksi4.isSelected() && cekruang4.isSelected() && cekkondisi4.isSelected() && cekketerangan4.isSelected())
            {panel5kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian4.getSelectedItem()+"%'and seksi like '%"+cboseksi4.getSelectedItem()+"%'and ruang like '%"+cboruang4.getSelectedItem()+"%'and kondisi like '%"+cbokondisi4.getSelectedItem()+"%' and keterangan like '%"+cboketerangan4.getSelectedItem()+"%'";
        }


        //6 kondisi
        else if (cekjenis5.isSelected()  && cektahun5.isSelected() && cekbagian5.isSelected()&& cekseksi5.isSelected() && cekruang5.isSelected() && cekkondisi5.isSelected())
            {
            panel6kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis5.getSelectedItem()+"%' and bagian like '%"+cbobagian5.getSelectedItem()+"%'and seksi like '%"+cboseksi5.getSelectedItem()+"%'and ruang like '%"+cboruang5.getSelectedItem()+"%'and kondisi like '%"+cbokondisi5.getSelectedItem()+"%' and tahun between "+txttahunawal5.getText()+" and "+txttahunakhir5.getText();
        }
        else if (cekjenis5.isSelected()  && cektahun5.isSelected() && cekbagian5.isSelected()&& cekseksi5.isSelected() && cekruang5.isSelected() && cekketerangan5.isSelected())
            {
            panel6kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis5.getSelectedItem()+"%' and bagian like '%"+cbobagian5.getSelectedItem()+"%'and seksi like '%"+cboseksi5.getSelectedItem()+"%'and ruang like '%"+cboruang5.getSelectedItem()+"%'and keterangan like '%"+cboketerangan5.getSelectedItem()+"%' and tahun between "+txttahunawal5.getText()+" and "+txttahunakhir5.getText();
        }
        else if (cekjenis5.isSelected()  && cektahun5.isSelected() && cekbagian5.isSelected() && cekruang5.isSelected()&& cekkondisi5.isSelected() && cekketerangan5.isSelected())
            {
            panel6kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis5.getSelectedItem()+"%' and bagian like '%"+cbobagian5.getSelectedItem()+"%'and kondisi like '%"+cbokondisi5.getSelectedItem()+"%'and ruang like '%"+cboruang5.getSelectedItem()+"%'and keterangan like '%"+cboketerangan5.getSelectedItem()+"%' and tahun between "+txttahunawal5.getText()+" and "+txttahunakhir5.getText();
        }
        else if (cekjenis5.isSelected()  && cektahun5.isSelected() && cekseksi5.isSelected() && cekruang5.isSelected()&& cekkondisi5.isSelected() && cekketerangan5.isSelected())
            {
            panel6kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis5.getSelectedItem()+"%' and seksi like '%"+cboseksi5.getSelectedItem()+"%'and kondisi like '%"+cbokondisi5.getSelectedItem()+"%'and ruang like '%"+cboruang5.getSelectedItem()+"%'and keterangan like '%"+cboketerangan5.getSelectedItem()+"%' and tahun between "+txttahunawal5.getText()+" and "+txttahunakhir5.getText();
        }
        

        else if (cekjenis5.isSelected() && cekbagian5.isSelected()&& cekseksi5.isSelected() && cekruang5.isSelected() && cekkondisi5.isSelected() && cekketerangan5.isSelected())
            {
            panel6kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis5.getSelectedItem()+"%' and bagian like '%"+cbobagian5.getSelectedItem()+"%'and seksi like '%"+cboseksi5.getSelectedItem()+"%'and ruang like '%"+cboruang5.getSelectedItem()+"%'and kondisi like '%"+cbokondisi5.getSelectedItem()+"%' and keterangan like '%"+cboketerangan5.getSelectedItem()+"%'";
        }
        else if (cektahun5.isSelected() && cekbagian5.isSelected()&& cekseksi5.isSelected() && cekruang5.isSelected() && cekkondisi5.isSelected() && cekketerangan5.isSelected())
            {
            panel6kategori.setVisible(true);
            sql = "select * from tblbarang where bagian like '%"+cbobagian5.getSelectedItem()+"%'and seksi like '%"+cboseksi5.getSelectedItem()+"%'and ruang like '%"+cboruang5.getSelectedItem()+"%'and kondisi like '%"+cbokondisi5.getSelectedItem()+"%' and keterangan like '%"+cboketerangan5.getSelectedItem()+"%' and tahun between "+txttahunawal5.getText()+" and "+txttahunakhir5.getText();
        }


        //7 kategori
        else if (cekjenis6.isSelected() && cektahun6.isSelected() && cekbagian6.isSelected()&& cekseksi6.isSelected() && cekruang6.isSelected() && cekkondisi6.isSelected() && cekketerangan6.isSelected())
            {
            panel7kategori.setVisible(true);
            sql = "select * from tblbarang where jenis like '%"+cbojenis6.getSelectedItem()+"%'and bagian like '%"+cbobagian6.getSelectedItem()+"%'and seksi like '%"+cboseksi6.getSelectedItem()+"%'and ruang like '%"+cboruang6.getSelectedItem()+"%'and kondisi like '%"+cbokondisi6.getSelectedItem()+"%' and keterangan like '%"+cboketerangan6.getSelectedItem()+"%' and tahun between "+txttahunawal6.getText()+" and "+txttahunakhir6.getText();
        }
         

        try {
        hasil=stat.executeQuery(sql);
        while(hasil.next()){
                String a = hasil.getString("nomor");
                String b = hasil.getString("jenis");
                String c = hasil.getString("nama");
                String d = hasil.getString("tahun");
                String e = hasil.getString("bagian");
                String f = hasil.getString("seksi");
                String g = hasil.getString("ruang");
                String h = hasil.getString("kondisi");
                String i = hasil.getString("keterangan");
                String[] data = {a,b,c,d,e,f,g,h,i};
                tabmode.addRow(data);
            }

        } catch (Exception e) {
        
    }
        }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnKeluar = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        datatabel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datatabel = new javax.swing.JTable();
        panelinduk = new javax.swing.JPanel();
        panel1kategori = new javax.swing.JPanel();
        cbojenis = new javax.swing.JComboBox();
        cekjenis = new javax.swing.JCheckBox();
        cbobagian = new javax.swing.JComboBox();
        cekbagian = new javax.swing.JCheckBox();
        cboseksi = new javax.swing.JComboBox();
        cekseksi = new javax.swing.JCheckBox();
        cboruang = new javax.swing.JComboBox();
        cekruang = new javax.swing.JCheckBox();
        cbokondisi = new javax.swing.JComboBox();
        cekkondisi = new javax.swing.JCheckBox();
        cboketerangan = new javax.swing.JComboBox();
        cekketerangan = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        cektahun = new javax.swing.JCheckBox();
        txttahunawal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txttahunakhir = new javax.swing.JTextField();
        panel2kategori = new javax.swing.JPanel();
        cbojenis1 = new javax.swing.JComboBox();
        cekjenis1 = new javax.swing.JCheckBox();
        cbobagian1 = new javax.swing.JComboBox();
        cekbagian1 = new javax.swing.JCheckBox();
        cboseksi1 = new javax.swing.JComboBox();
        cekseksi1 = new javax.swing.JCheckBox();
        cboruang1 = new javax.swing.JComboBox();
        cekruang1 = new javax.swing.JCheckBox();
        cbokondisi1 = new javax.swing.JComboBox();
        cekkondisi1 = new javax.swing.JCheckBox();
        cboketerangan1 = new javax.swing.JComboBox();
        cekketerangan1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        txttahunakhir1 = new javax.swing.JTextField();
        cektahun1 = new javax.swing.JCheckBox();
        txttahunawal1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        panel3kategori = new javax.swing.JPanel();
        cbojenis2 = new javax.swing.JComboBox();
        cekjenis2 = new javax.swing.JCheckBox();
        cbobagian2 = new javax.swing.JComboBox();
        cekbagian2 = new javax.swing.JCheckBox();
        cboseksi2 = new javax.swing.JComboBox();
        cekseksi2 = new javax.swing.JCheckBox();
        cboruang2 = new javax.swing.JComboBox();
        cekruang2 = new javax.swing.JCheckBox();
        cbokondisi2 = new javax.swing.JComboBox();
        cekkondisi2 = new javax.swing.JCheckBox();
        cboketerangan2 = new javax.swing.JComboBox();
        cekketerangan2 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cektahun2 = new javax.swing.JCheckBox();
        txttahunakhir2 = new javax.swing.JTextField();
        txttahunawal2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        panel4kategori = new javax.swing.JPanel();
        cbojenis3 = new javax.swing.JComboBox();
        cekjenis3 = new javax.swing.JCheckBox();
        cbobagian3 = new javax.swing.JComboBox();
        cekbagian3 = new javax.swing.JCheckBox();
        cboseksi3 = new javax.swing.JComboBox();
        cekseksi3 = new javax.swing.JCheckBox();
        cboruang3 = new javax.swing.JComboBox();
        cekruang3 = new javax.swing.JCheckBox();
        cbokondisi3 = new javax.swing.JComboBox();
        cekkondisi3 = new javax.swing.JCheckBox();
        cboketerangan3 = new javax.swing.JComboBox();
        cekketerangan3 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        txttahunawal3 = new javax.swing.JTextField();
        txttahunakhir3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cektahun3 = new javax.swing.JCheckBox();
        panel5kategori = new javax.swing.JPanel();
        cbojenis4 = new javax.swing.JComboBox();
        cekjenis4 = new javax.swing.JCheckBox();
        cbobagian4 = new javax.swing.JComboBox();
        cekbagian4 = new javax.swing.JCheckBox();
        cboseksi4 = new javax.swing.JComboBox();
        cekseksi4 = new javax.swing.JCheckBox();
        cboruang4 = new javax.swing.JComboBox();
        cekruang4 = new javax.swing.JCheckBox();
        cbokondisi4 = new javax.swing.JComboBox();
        cekkondisi4 = new javax.swing.JCheckBox();
        cboketerangan4 = new javax.swing.JComboBox();
        cekketerangan4 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cektahun4 = new javax.swing.JCheckBox();
        txttahunawal4 = new javax.swing.JTextField();
        txttahunakhir4 = new javax.swing.JTextField();
        panel6kategori = new javax.swing.JPanel();
        cbojenis5 = new javax.swing.JComboBox();
        cekjenis5 = new javax.swing.JCheckBox();
        cbobagian5 = new javax.swing.JComboBox();
        cekbagian5 = new javax.swing.JCheckBox();
        cboseksi5 = new javax.swing.JComboBox();
        cekseksi5 = new javax.swing.JCheckBox();
        cboruang5 = new javax.swing.JComboBox();
        cekruang5 = new javax.swing.JCheckBox();
        cbokondisi5 = new javax.swing.JComboBox();
        cekkondisi5 = new javax.swing.JCheckBox();
        cboketerangan5 = new javax.swing.JComboBox();
        cekketerangan5 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        txttahunakhir5 = new javax.swing.JTextField();
        txttahunawal5 = new javax.swing.JTextField();
        cektahun5 = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        panel7kategori = new javax.swing.JPanel();
        cbojenis6 = new javax.swing.JComboBox();
        cekjenis6 = new javax.swing.JCheckBox();
        cbobagian6 = new javax.swing.JComboBox();
        cekbagian6 = new javax.swing.JCheckBox();
        cboseksi6 = new javax.swing.JComboBox();
        cekseksi6 = new javax.swing.JCheckBox();
        cboruang6 = new javax.swing.JComboBox();
        cekruang6 = new javax.swing.JCheckBox();
        cbokondisi6 = new javax.swing.JComboBox();
        cekkondisi6 = new javax.swing.JCheckBox();
        cboketerangan6 = new javax.swing.JComboBox();
        cekketerangan6 = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        txttahunakhir6 = new javax.swing.JTextField();
        txttahunawal6 = new javax.swing.JTextField();
        cektahun6 = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        panelawal = new javax.swing.JPanel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        rb4 = new javax.swing.JRadioButton();
        rb5 = new javax.swing.JRadioButton();
        rb6 = new javax.swing.JRadioButton();
        rb7 = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setTitle("Informasi Inventaris");
        setFont(new java.awt.Font("Tahoma", 0, 10));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Tandai dan Pilih Kategori Pencarian");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel19.setBackground(new java.awt.Color(255, 204, 51));
        jLabel19.setFont(new java.awt.Font("Eurostile", 0, 30)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Informasi Data Inventaris");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/informasi1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel11)
                .addGap(387, 387, 387)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11))
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        btnKeluar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Exit.png"))); // NOI18N
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnCetak.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
        btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/printer.png"))); // NOI18N
        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCetak)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1016, Short.MAX_VALUE)
                .addComponent(btnKeluar)
                .addGap(55, 55, 55))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap())
        );

        datatabel.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        datatabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        datatabel.setRowSelectionAllowed(false);
        datatabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(datatabel);

        javax.swing.GroupLayout datatabel3Layout = new javax.swing.GroupLayout(datatabel3);
        datatabel3.setLayout(datatabel3Layout);
        datatabel3Layout.setHorizontalGroup(
            datatabel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 864, Short.MAX_VALUE)
            .addGroup(datatabel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(datatabel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        datatabel3Layout.setVerticalGroup(
            datatabel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
            .addGroup(datatabel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(datatabel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panelinduk.setLayout(new java.awt.CardLayout());

        cbojenis.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        cbojenis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbojenisItemStateChanged(evt);
            }
        });
        cbojenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbojenisActionPerformed(evt);
            }
        });

        cekjenis.setBackground(new java.awt.Color(204, 204, 204));
        cekjenis.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        cekjenis.setText("    Jenis Inventaris");
        cekjenis.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekjenisStateChanged(evt);
            }
        });
        cekjenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekjenisActionPerformed(evt);
            }
        });

        cbobagian.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        cbobagian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jaringan", "Transaksi Energi Listrik", "Pelayanan & Adm", "Kosong" }));
        cbobagian.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbobagianItemStateChanged(evt);
            }
        });
        cbobagian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbobagianActionPerformed(evt);
            }
        });

        cekbagian.setBackground(new java.awt.Color(204, 204, 204));
        cekbagian.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekbagian.setText("    Bagian");
        cekbagian.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekbagianStateChanged(evt);
            }
        });
        cekbagian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekbagianActionPerformed(evt);
            }
        });

        cboseksi.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboseksi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adm Umum", "Kosong", "Operasi", "Pemeliharaan", "Pemeliharaan Meter", "Pengendalian Susut", "PPL", "Transaksi Energi Listrik" }));
        cboseksi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboseksiItemStateChanged(evt);
            }
        });
        cboseksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboseksiActionPerformed(evt);
            }
        });

        cekseksi.setBackground(new java.awt.Color(204, 204, 204));
        cekseksi.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekseksi.setText("    Seksi");
        cekseksi.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekseksiStateChanged(evt);
            }
        });
        cekseksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekseksiActionPerformed(evt);
            }
        });

        cboruang.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboruang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ahli Kinerja", "Akuntansi", "Asman PAD", "DPC-SP", "Gudang LT.I", "Humas", "Kasir", "Keuangan", "Komersil", "Manajer", "Operator Telepon", "P2TL", "Panitia Ruang & Jasa", "Penagihan", "Ruang Rapat", "SDM", "Sekretaris Asman TEL", "Sekretaris Manajer", "Sekretariat Umum", "Seksi HAR Meter", "Seksi Operasi Distribusi", "Seksi Logistik", "Seksi Pemeliharaan Distribusi", "Seksi PPL", "Seksi Proteksi", "Seksi TEL", "SP", "SP2J", "TERA", "Transaksi Energi Listrik" }));
        cboruang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboruangItemStateChanged(evt);
            }
        });
        cboruang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboruangActionPerformed(evt);
            }
        });

        cekruang.setBackground(new java.awt.Color(204, 204, 204));
        cekruang.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekruang.setText("    Ruang");
        cekruang.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekruangStateChanged(evt);
            }
        });
        cekruang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekruangActionPerformed(evt);
            }
        });

        cbokondisi.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbokondisi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baik", "Rusak" }));
        cbokondisi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbokondisiItemStateChanged(evt);
            }
        });
        cbokondisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbokondisiActionPerformed(evt);
            }
        });

        cekkondisi.setBackground(new java.awt.Color(204, 204, 204));
        cekkondisi.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekkondisi.setText("    Kondisi");
        cekkondisi.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekkondisiStateChanged(evt);
            }
        });
        cekkondisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekkondisiActionPerformed(evt);
            }
        });

        cboketerangan.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboketerangan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        cboketerangan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboketeranganItemStateChanged(evt);
            }
        });
        cboketerangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboketeranganActionPerformed(evt);
            }
        });

        cekketerangan.setBackground(new java.awt.Color(204, 204, 204));
        cekketerangan.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekketerangan.setText("    Keterangan");
        cekketerangan.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekketeranganStateChanged(evt);
            }
        });
        cekketerangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekketeranganActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("* Pilih 1 Kategori");

        cektahun.setBackground(new java.awt.Color(204, 204, 204));
        cektahun.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cektahun.setText("  Tahun Perolehan");
        cektahun.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cektahunStateChanged(evt);
            }
        });
        cektahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cektahunActionPerformed(evt);
            }
        });

        txttahunawal.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txttahunawal.setText("* yyyy");
        txttahunawal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunawal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunawalKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel10.setText("s/d");

        txttahunakhir.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        txttahunakhir.setText("* yyyy");
        txttahunakhir.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunakhir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunakhirKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel1kategoriLayout = new javax.swing.GroupLayout(panel1kategori);
        panel1kategori.setLayout(panel1kategoriLayout);
        panel1kategoriLayout.setHorizontalGroup(
            panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1kategoriLayout.createSequentialGroup()
                .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1kategoriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1kategoriLayout.createSequentialGroup()
                                .addComponent(cektahun, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttahunawal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttahunakhir, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                            .addGroup(panel1kategoriLayout.createSequentialGroup()
                                .addComponent(cekjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbojenis, 0, 190, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(panel1kategoriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1kategoriLayout.createSequentialGroup()
                        .addComponent(cekketerangan, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboketerangan, 0, 190, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1kategoriLayout.createSequentialGroup()
                        .addComponent(cekkondisi, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbokondisi, 0, 190, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1kategoriLayout.createSequentialGroup()
                        .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cekbagian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cekseksi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1kategoriLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cekruang, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbobagian, javax.swing.GroupLayout.Alignment.TRAILING, 0, 190, Short.MAX_VALUE)
                            .addComponent(cboseksi, javax.swing.GroupLayout.Alignment.TRAILING, 0, 190, Short.MAX_VALUE)
                            .addComponent(cboruang, javax.swing.GroupLayout.Alignment.TRAILING, 0, 190, Short.MAX_VALUE))))
                .addGap(9, 9, 9))
        );
        panel1kategoriLayout.setVerticalGroup(
            panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1kategoriLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbojenis, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(cekjenis))
                .addGap(18, 18, 18)
                .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttahunawal, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(txttahunakhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(cektahun))
                .addGap(18, 18, 18)
                .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbobagian, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekbagian))
                .addGap(21, 21, 21)
                .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboseksi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekseksi))
                .addGap(17, 17, 17)
                .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboruang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekruang))
                .addGap(18, 18, 18)
                .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbokondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekkondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboketerangan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekketerangan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelinduk.add(panel1kategori, "card2");

        cbojenis1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbojenis1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbojenis1ItemStateChanged(evt);
            }
        });
        cbojenis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbojenis1ActionPerformed(evt);
            }
        });

        cekjenis1.setBackground(new java.awt.Color(204, 204, 204));
        cekjenis1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekjenis1.setText("    Jenis Inventaris");
        cekjenis1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekjenis1StateChanged(evt);
            }
        });
        cekjenis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekjenis1ActionPerformed(evt);
            }
        });

        cbobagian1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbobagian1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jaringan", "Transaksi Energi Listrik", "Pelayanan & Adm", "Kosong" }));
        cbobagian1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbobagian1ItemStateChanged(evt);
            }
        });
        cbobagian1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbobagian1ActionPerformed(evt);
            }
        });

        cekbagian1.setBackground(new java.awt.Color(204, 204, 204));
        cekbagian1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekbagian1.setText("    Bagian");
        cekbagian1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekbagian1StateChanged(evt);
            }
        });
        cekbagian1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekbagian1ActionPerformed(evt);
            }
        });

        cboseksi1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboseksi1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adm Umum", "Kosong", "Operasi", "Pemeliharaan", "Pemeliharaan Meter", "Pengendalian Susut", "PPL", "Transaksi Energi Listrik" }));
        cboseksi1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboseksi1ItemStateChanged(evt);
            }
        });
        cboseksi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboseksi1ActionPerformed(evt);
            }
        });

        cekseksi1.setBackground(new java.awt.Color(204, 204, 204));
        cekseksi1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekseksi1.setText("    Seksi");
        cekseksi1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekseksi1StateChanged(evt);
            }
        });
        cekseksi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekseksi1ActionPerformed(evt);
            }
        });

        cboruang1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboruang1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ahli Kinerja", "Akuntansi", "Asman PAD", "DPC-SP", "Gudang LT.I", "Humas", "Kasir", "Keuangan", "Komersil", "Manajer", "Operator Telepon", "P2TL", "Panitia Ruang & Jasa", "Penagihan", "Ruang Rapat", "SDM", "Sekretaris Asman TEL", "Sekretaris Manajer", "Sekretariat Umum", "Seksi HAR Meter", "Seksi Operasi Distribusi", "Seksi Logistik", "Seksi Pemeliharaan Distribusi", "Seksi PPL", "Seksi Proteksi", "Seksi TEL", "SP", "SP2J", "TERA", "Transaksi Energi Listrik" }));
        cboruang1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboruang1ItemStateChanged(evt);
            }
        });
        cboruang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboruang1ActionPerformed(evt);
            }
        });

        cekruang1.setBackground(new java.awt.Color(204, 204, 204));
        cekruang1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekruang1.setText("    Ruang");
        cekruang1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekruang1StateChanged(evt);
            }
        });
        cekruang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekruang1ActionPerformed(evt);
            }
        });

        cbokondisi1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbokondisi1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baik", "Rusak" }));
        cbokondisi1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbokondisi1ItemStateChanged(evt);
            }
        });
        cbokondisi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbokondisi1ActionPerformed(evt);
            }
        });

        cekkondisi1.setBackground(new java.awt.Color(204, 204, 204));
        cekkondisi1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekkondisi1.setText("    Kondisi");
        cekkondisi1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekkondisi1StateChanged(evt);
            }
        });
        cekkondisi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekkondisi1ActionPerformed(evt);
            }
        });

        cboketerangan1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboketerangan1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        cboketerangan1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboketerangan1ItemStateChanged(evt);
            }
        });
        cboketerangan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboketerangan1ActionPerformed(evt);
            }
        });

        cekketerangan1.setBackground(new java.awt.Color(204, 204, 204));
        cekketerangan1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekketerangan1.setText("    Keterangan");
        cekketerangan1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekketerangan1StateChanged(evt);
            }
        });
        cekketerangan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekketerangan1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("* Pilih 2 Kategori");

        txttahunakhir1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        txttahunakhir1.setText("* yyyy");
        txttahunakhir1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunakhir1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunakhir1KeyReleased(evt);
            }
        });

        cektahun1.setBackground(new java.awt.Color(204, 204, 204));
        cektahun1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cektahun1.setText("  Tahun Perolehan");
        cektahun1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cektahun1StateChanged(evt);
            }
        });
        cektahun1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cektahun1ActionPerformed(evt);
            }
        });

        txttahunawal1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        txttahunawal1.setText("* yyyy");
        txttahunawal1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunawal1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunawal1KeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel12.setText("s/d");

        javax.swing.GroupLayout panel2kategoriLayout = new javax.swing.GroupLayout(panel2kategori);
        panel2kategori.setLayout(panel2kategoriLayout);
        panel2kategoriLayout.setHorizontalGroup(
            panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2kategoriLayout.createSequentialGroup()
                .addGroup(panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(panel2kategoriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cekjenis1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbojenis1, 0, 189, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panel2kategoriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel2kategoriLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cekketerangan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel2kategoriLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cekkondisi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel2kategoriLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cekruang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cekseksi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cekbagian1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboseksi1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 189, Short.MAX_VALUE)
                    .addComponent(cbobagian1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 189, Short.MAX_VALUE)
                    .addComponent(cboruang1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 189, Short.MAX_VALUE)
                    .addComponent(cbokondisi1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 189, Short.MAX_VALUE)
                    .addComponent(cboketerangan1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 189, Short.MAX_VALUE))
                .addGap(9, 9, 9))
            .addGroup(panel2kategoriLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cektahun1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttahunawal1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttahunakhir1, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel2kategoriLayout.setVerticalGroup(
            panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2kategoriLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbojenis1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(cekjenis1))
                .addGap(18, 18, 18)
                .addGroup(panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2kategoriLayout.createSequentialGroup()
                        .addGroup(panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttahunakhir1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(jLabel12))
                        .addGap(20, 20, 20))
                    .addGroup(panel2kategoriLayout.createSequentialGroup()
                        .addGroup(panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cektahun1)
                            .addComponent(txttahunawal1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbobagian1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekbagian1))
                .addGap(21, 21, 21)
                .addGroup(panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboseksi1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekseksi1))
                .addGap(17, 17, 17)
                .addGroup(panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboruang1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekruang1))
                .addGap(18, 18, 18)
                .addGroup(panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbokondisi1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekkondisi1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel2kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboketerangan1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekketerangan1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelinduk.add(panel2kategori, "card3");

        cbojenis2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbojenis2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbojenis2ItemStateChanged(evt);
            }
        });
        cbojenis2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbojenis2ActionPerformed(evt);
            }
        });

        cekjenis2.setBackground(new java.awt.Color(204, 204, 204));
        cekjenis2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekjenis2.setText("    Jenis Inventaris");
        cekjenis2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekjenis2StateChanged(evt);
            }
        });
        cekjenis2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekjenis2ActionPerformed(evt);
            }
        });

        cbobagian2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbobagian2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jaringan", "Transaksi Energi Listrik", "Pelayanan & Adm", "Kosong" }));
        cbobagian2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbobagian2ItemStateChanged(evt);
            }
        });
        cbobagian2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbobagian2ActionPerformed(evt);
            }
        });

        cekbagian2.setBackground(new java.awt.Color(204, 204, 204));
        cekbagian2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekbagian2.setText("    Bagian");
        cekbagian2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekbagian2StateChanged(evt);
            }
        });
        cekbagian2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekbagian2ActionPerformed(evt);
            }
        });

        cboseksi2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboseksi2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adm Umum", "Kosong", "Operasi", "Pemeliharaan", "Pemeliharaan Meter", "Pengendalian Susut", "PPL", "Transaksi Energi Listrik" }));
        cboseksi2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboseksi2ItemStateChanged(evt);
            }
        });
        cboseksi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboseksi2ActionPerformed(evt);
            }
        });

        cekseksi2.setBackground(new java.awt.Color(204, 204, 204));
        cekseksi2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekseksi2.setText("    Seksi");
        cekseksi2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekseksi2StateChanged(evt);
            }
        });
        cekseksi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekseksi2ActionPerformed(evt);
            }
        });

        cboruang2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboruang2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ahli Kinerja", "Akuntansi", "Asman PAD", "Humas", "Kasir", "Keuangan", "Manajer", "Operator Telepon", "P2TL", "Penagihan", "Ruang Rapat", "SDM", "Sekretaris Asman TEL", "Sekretaris Manajer", "Sekretariat Umum", "Seksi HAR Meter", "Seksi Operasi Distribusi", "Seksi Logistik", "Seksi Pemeliharaan Distribusi", "Seksi PPL", "Seksi Proteksi", "Seksi TEL", "SP", "SP2J", "TERA", "Transaksi Energi Listrik" }));
        cboruang2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboruang2ItemStateChanged(evt);
            }
        });
        cboruang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboruang2ActionPerformed(evt);
            }
        });

        cekruang2.setBackground(new java.awt.Color(204, 204, 204));
        cekruang2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekruang2.setText("    Ruang");
        cekruang2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekruang2StateChanged(evt);
            }
        });
        cekruang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekruang2ActionPerformed(evt);
            }
        });

        cbokondisi2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbokondisi2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baik", "Rusak" }));
        cbokondisi2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbokondisi2ItemStateChanged(evt);
            }
        });
        cbokondisi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbokondisi2ActionPerformed(evt);
            }
        });

        cekkondisi2.setBackground(new java.awt.Color(204, 204, 204));
        cekkondisi2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekkondisi2.setText("    Kondisi");
        cekkondisi2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekkondisi2StateChanged(evt);
            }
        });
        cekkondisi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekkondisi2ActionPerformed(evt);
            }
        });

        cboketerangan2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboketerangan2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        cboketerangan2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboketerangan2ItemStateChanged(evt);
            }
        });
        cboketerangan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboketerangan2ActionPerformed(evt);
            }
        });

        cekketerangan2.setBackground(new java.awt.Color(204, 204, 204));
        cekketerangan2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekketerangan2.setText("    Keterangan");
        cekketerangan2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekketerangan2StateChanged(evt);
            }
        });
        cekketerangan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekketerangan2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("* Pilih 3 Kategori");

        cektahun2.setBackground(new java.awt.Color(204, 204, 204));
        cektahun2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cektahun2.setText("  Tahun Perolehan");
        cektahun2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cektahun2StateChanged(evt);
            }
        });
        cektahun2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cektahun2ActionPerformed(evt);
            }
        });

        txttahunakhir2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        txttahunakhir2.setText("* yyyy");
        txttahunakhir2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunakhir2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunakhir2KeyReleased(evt);
            }
        });

        txttahunawal2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        txttahunawal2.setText("* yyyy");
        txttahunawal2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunawal2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunawal2KeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel13.setText("s/d");

        javax.swing.GroupLayout panel3kategoriLayout = new javax.swing.GroupLayout(panel3kategori);
        panel3kategori.setLayout(panel3kategoriLayout);
        panel3kategoriLayout.setHorizontalGroup(
            panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3kategoriLayout.createSequentialGroup()
                .addGroup(panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3kategoriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cekketerangan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cekkondisi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cekruang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cekseksi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cekbagian2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbobagian2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboseksi2, 0, 192, Short.MAX_VALUE)
                            .addComponent(cboketerangan2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbokondisi2, 0, 189, Short.MAX_VALUE)
                            .addComponent(cboruang2, 0, 0, Short.MAX_VALUE)))
                    .addGroup(panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel3kategoriLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(cektahun2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txttahunawal2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txttahunakhir2))
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel3kategoriLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(cekjenis2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbojenis2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel3kategoriLayout.setVerticalGroup(
            panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3kategoriLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbojenis2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(cekjenis2))
                .addGap(18, 18, 18)
                .addGroup(panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttahunawal2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(txttahunakhir2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cektahun2))
                .addGap(24, 24, 24)
                .addGroup(panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekbagian2)
                    .addComponent(cbobagian2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekseksi2)
                    .addComponent(cboseksi2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekruang2)
                    .addComponent(cboruang2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekkondisi2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbokondisi2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel3kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekketerangan2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboketerangan2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelinduk.add(panel3kategori, "card4");

        cbojenis3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbojenis3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbojenis3ItemStateChanged(evt);
            }
        });
        cbojenis3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbojenis3ActionPerformed(evt);
            }
        });

        cekjenis3.setBackground(new java.awt.Color(204, 204, 204));
        cekjenis3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekjenis3.setText("    Jenis Inventaris");
        cekjenis3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekjenis3StateChanged(evt);
            }
        });
        cekjenis3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekjenis3ActionPerformed(evt);
            }
        });

        cbobagian3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbobagian3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jaringan", "Transaksi Energi Listrik", "Pelayanan & Adm", "Kosong" }));
        cbobagian3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbobagian3ItemStateChanged(evt);
            }
        });
        cbobagian3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbobagian3ActionPerformed(evt);
            }
        });

        cekbagian3.setBackground(new java.awt.Color(204, 204, 204));
        cekbagian3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekbagian3.setText("    Bagian");
        cekbagian3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekbagian3StateChanged(evt);
            }
        });
        cekbagian3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekbagian3ActionPerformed(evt);
            }
        });

        cboseksi3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboseksi3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adm Umum", "Kosong", "Operasi", "Pemeliharaan", "Pemeliharaan Meter", "Pengendalian Susut", "PPL", "Transaksi Energi Listrik" }));
        cboseksi3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboseksi3ItemStateChanged(evt);
            }
        });
        cboseksi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboseksi3ActionPerformed(evt);
            }
        });

        cekseksi3.setBackground(new java.awt.Color(204, 204, 204));
        cekseksi3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekseksi3.setText("    Seksi");
        cekseksi3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekseksi3StateChanged(evt);
            }
        });
        cekseksi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekseksi3ActionPerformed(evt);
            }
        });

        cboruang3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboruang3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ahli Kinerja", "Akuntansi", "Asman PAD", "DPC-SP", "Gudang LT.I", "Humas", "Kasir", "Keuangan", "Komersil", "Manajer", "Operator Telepon", "P2TL", "Panitia Ruang & Jasa", "Penagihan", "Ruang Rapat", "SDM", "Sekretaris Asman TEL", "Sekretaris Manajer", "Sekretariat Umum", "Seksi HAR Meter", "Seksi Operasi Distribusi", "Seksi Logistik", "Seksi Pemeliharaan Distribusi", "Seksi PPL", "Seksi Proteksi", "Seksi TEL", "SP", "SP2J", "TERA", "Transaksi Energi Listrik" }));
        cboruang3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboruang3ItemStateChanged(evt);
            }
        });
        cboruang3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboruang3ActionPerformed(evt);
            }
        });

        cekruang3.setBackground(new java.awt.Color(204, 204, 204));
        cekruang3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekruang3.setText("    Ruang");
        cekruang3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekruang3StateChanged(evt);
            }
        });
        cekruang3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekruang3ActionPerformed(evt);
            }
        });

        cbokondisi3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbokondisi3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baik", "Rusak" }));
        cbokondisi3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbokondisi3ItemStateChanged(evt);
            }
        });
        cbokondisi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbokondisi3ActionPerformed(evt);
            }
        });

        cekkondisi3.setBackground(new java.awt.Color(204, 204, 204));
        cekkondisi3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekkondisi3.setText("    Kondisi");
        cekkondisi3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekkondisi3StateChanged(evt);
            }
        });
        cekkondisi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekkondisi3ActionPerformed(evt);
            }
        });

        cboketerangan3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboketerangan3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        cboketerangan3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboketerangan3ItemStateChanged(evt);
            }
        });
        cboketerangan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboketerangan3ActionPerformed(evt);
            }
        });

        cekketerangan3.setBackground(new java.awt.Color(204, 204, 204));
        cekketerangan3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekketerangan3.setText("    Keterangan");
        cekketerangan3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekketerangan3StateChanged(evt);
            }
        });
        cekketerangan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekketerangan3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("* Pilih 4 Kategori");

        txttahunawal3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        txttahunawal3.setText("* yyyy");
        txttahunawal3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunawal3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunawal3KeyReleased(evt);
            }
        });

        txttahunakhir3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        txttahunakhir3.setText("* yyyy");
        txttahunakhir3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunakhir3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunakhir3KeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel14.setText("s/d");

        cektahun3.setBackground(new java.awt.Color(204, 204, 204));
        cektahun3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cektahun3.setText("  Tahun Perolehan");
        cektahun3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cektahun3StateChanged(evt);
            }
        });
        cektahun3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cektahun3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel4kategoriLayout = new javax.swing.GroupLayout(panel4kategori);
        panel4kategori.setLayout(panel4kategoriLayout);
        panel4kategoriLayout.setHorizontalGroup(
            panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4kategoriLayout.createSequentialGroup()
                .addGroup(panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(panel4kategoriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cekjenis3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel4kategoriLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(cekseksi3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(cekbagian3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel4kategoriLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cekruang3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cekkondisi3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                        .addComponent(cekketerangan3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(cektahun3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboseksi3, 0, 183, Short.MAX_VALUE)
                            .addComponent(cboruang3, 0, 0, Short.MAX_VALUE)
                            .addComponent(cbokondisi3, 0, 183, Short.MAX_VALUE)
                            .addGroup(panel4kategoriLayout.createSequentialGroup()
                                .addComponent(txttahunawal3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttahunakhir3, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                            .addComponent(cbojenis3, 0, 183, Short.MAX_VALUE)
                            .addComponent(cbobagian3, javax.swing.GroupLayout.Alignment.TRAILING, 0, 183, Short.MAX_VALUE)
                            .addComponent(cboketerangan3, javax.swing.GroupLayout.Alignment.TRAILING, 0, 183, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panel4kategoriLayout.setVerticalGroup(
            panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4kategoriLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbojenis3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(cekjenis3))
                .addGap(18, 18, 18)
                .addGroup(panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttahunakhir3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cektahun3)
                    .addComponent(txttahunawal3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekbagian3)
                    .addComponent(cbobagian3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekseksi3)
                    .addComponent(cboseksi3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekruang3)
                    .addComponent(cboruang3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekkondisi3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbokondisi3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel4kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekketerangan3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboketerangan3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(278, 278, 278))
        );

        panelinduk.add(panel4kategori, "card5");

        cbojenis4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbojenis4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbojenis4ItemStateChanged(evt);
            }
        });
        cbojenis4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbojenis4ActionPerformed(evt);
            }
        });

        cekjenis4.setBackground(new java.awt.Color(204, 204, 204));
        cekjenis4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekjenis4.setText("    Jenis Inventaris");
        cekjenis4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekjenis4StateChanged(evt);
            }
        });
        cekjenis4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekjenis4ActionPerformed(evt);
            }
        });

        cbobagian4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbobagian4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jaringan", "Transaksi Energi Listrik", "Pelayanan & Adm", "Kosong" }));
        cbobagian4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbobagian4ItemStateChanged(evt);
            }
        });
        cbobagian4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbobagian4ActionPerformed(evt);
            }
        });

        cekbagian4.setBackground(new java.awt.Color(204, 204, 204));
        cekbagian4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekbagian4.setText("    Bagian");
        cekbagian4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekbagian4StateChanged(evt);
            }
        });
        cekbagian4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekbagian4ActionPerformed(evt);
            }
        });

        cboseksi4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboseksi4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adm Umum", "Kosong", "Operasi", "Pemeliharaan", "Pemeliharaan Meter", "Pengendalian Susut", "PPL", "Transaksi Energi Listrik" }));
        cboseksi4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboseksi4ItemStateChanged(evt);
            }
        });
        cboseksi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboseksi4ActionPerformed(evt);
            }
        });

        cekseksi4.setBackground(new java.awt.Color(204, 204, 204));
        cekseksi4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekseksi4.setText("    Seksi");
        cekseksi4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekseksi4StateChanged(evt);
            }
        });
        cekseksi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekseksi4ActionPerformed(evt);
            }
        });

        cboruang4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboruang4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ahli Kinerja", "Akuntansi", "Asman PAD", "DPC-SP", "Gudang LT.I", "Humas", "Kasir", "Keuangan", "Komersil", "Manajer", "Operator Telepon", "P2TL", "Panitia Ruang & Jasa", "Penagihan", "Ruang Rapat", "SDM", "Sekretaris Asman TEL", "Sekretaris Manajer", "Sekretariat Umum", "Seksi HAR Meter", "Seksi Operasi Distribusi", "Seksi Logistik", "Seksi Pemeliharaan Distribusi", "Seksi PPL", "Seksi Proteksi", "Seksi TEL", "SP", "SP2J", "TERA", "Transaksi Energi Listrik" }));
        cboruang4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboruang4ItemStateChanged(evt);
            }
        });
        cboruang4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboruang4ActionPerformed(evt);
            }
        });

        cekruang4.setBackground(new java.awt.Color(204, 204, 204));
        cekruang4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekruang4.setText("    Ruang");
        cekruang4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekruang4StateChanged(evt);
            }
        });
        cekruang4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekruang4ActionPerformed(evt);
            }
        });

        cbokondisi4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbokondisi4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baik", "Rusak" }));
        cbokondisi4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbokondisi4ItemStateChanged(evt);
            }
        });
        cbokondisi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbokondisi4ActionPerformed(evt);
            }
        });

        cekkondisi4.setBackground(new java.awt.Color(204, 204, 204));
        cekkondisi4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekkondisi4.setText("    Kondisi");
        cekkondisi4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekkondisi4StateChanged(evt);
            }
        });
        cekkondisi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekkondisi4ActionPerformed(evt);
            }
        });

        cboketerangan4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboketerangan4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        cboketerangan4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboketerangan4ItemStateChanged(evt);
            }
        });
        cboketerangan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboketerangan4ActionPerformed(evt);
            }
        });

        cekketerangan4.setBackground(new java.awt.Color(204, 204, 204));
        cekketerangan4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekketerangan4.setText("    Keterangan");
        cekketerangan4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekketerangan4StateChanged(evt);
            }
        });
        cekketerangan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekketerangan4ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("* Pilih 5 Kategori");

        jLabel15.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel15.setText("s/d");

        cektahun4.setBackground(new java.awt.Color(204, 204, 204));
        cektahun4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cektahun4.setText("  Tahun Perolehan");
        cektahun4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cektahun4StateChanged(evt);
            }
        });
        cektahun4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cektahun4ActionPerformed(evt);
            }
        });

        txttahunawal4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        txttahunawal4.setText("* yyyy");
        txttahunawal4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunawal4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunawal4KeyReleased(evt);
            }
        });

        txttahunakhir4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        txttahunakhir4.setText("* yyyy");
        txttahunakhir4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunakhir4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunakhir4KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel5kategoriLayout = new javax.swing.GroupLayout(panel5kategori);
        panel5kategori.setLayout(panel5kategoriLayout);
        panel5kategoriLayout.setHorizontalGroup(
            panel5kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5kategoriLayout.createSequentialGroup()
                .addGroup(panel5kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(panel5kategoriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cekjenis4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbojenis4, 0, 186, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5kategoriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel5kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cekketerangan4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cekkondisi4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cekruang4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cekseksi4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cekbagian4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel5kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbokondisi4, javax.swing.GroupLayout.Alignment.TRAILING, 0, 185, Short.MAX_VALUE)
                            .addComponent(cboruang4, javax.swing.GroupLayout.Alignment.TRAILING, 0, 185, Short.MAX_VALUE)
                            .addComponent(cboseksi4, javax.swing.GroupLayout.Alignment.TRAILING, 0, 185, Short.MAX_VALUE)
                            .addComponent(cbobagian4, javax.swing.GroupLayout.Alignment.TRAILING, 0, 185, Short.MAX_VALUE)
                            .addComponent(cboketerangan4, javax.swing.GroupLayout.Alignment.TRAILING, 0, 185, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5kategoriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cektahun4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttahunawal4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttahunakhir4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel5kategoriLayout.setVerticalGroup(
            panel5kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5kategoriLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel5kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbojenis4, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(cekjenis4))
                .addGap(24, 24, 24)
                .addGroup(panel5kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttahunakhir4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cektahun4)
                    .addComponent(txttahunawal4, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panel5kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbobagian4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekbagian4))
                .addGap(21, 21, 21)
                .addGroup(panel5kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboseksi4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekseksi4))
                .addGap(17, 17, 17)
                .addGroup(panel5kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboruang4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekruang4))
                .addGap(18, 18, 18)
                .addGroup(panel5kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbokondisi4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekkondisi4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel5kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboketerangan4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekketerangan4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        panelinduk.add(panel5kategori, "card6");

        cbojenis5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbojenis5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbojenis5ItemStateChanged(evt);
            }
        });
        cbojenis5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbojenis5ActionPerformed(evt);
            }
        });

        cekjenis5.setBackground(new java.awt.Color(204, 204, 204));
        cekjenis5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekjenis5.setText("    Jenis Inventaris");
        cekjenis5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekjenis5StateChanged(evt);
            }
        });
        cekjenis5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekjenis5ActionPerformed(evt);
            }
        });

        cbobagian5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbobagian5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jaringan", "Transaksi Energi Listrik", "Pelayanan & Adm", "Kosong" }));
        cbobagian5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbobagian5ItemStateChanged(evt);
            }
        });
        cbobagian5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbobagian5ActionPerformed(evt);
            }
        });

        cekbagian5.setBackground(new java.awt.Color(204, 204, 204));
        cekbagian5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekbagian5.setText("    Bagian");
        cekbagian5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekbagian5StateChanged(evt);
            }
        });
        cekbagian5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekbagian5ActionPerformed(evt);
            }
        });

        cboseksi5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboseksi5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adm Umum", "Kosong", "Operasi", "Pemeliharaan", "Pemeliharaan Meter", "Pengendalian Susut", "PPL", "Transaksi Energi Listrik" }));
        cboseksi5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboseksi5ItemStateChanged(evt);
            }
        });
        cboseksi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboseksi5ActionPerformed(evt);
            }
        });

        cekseksi5.setBackground(new java.awt.Color(204, 204, 204));
        cekseksi5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekseksi5.setText("    Seksi");
        cekseksi5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekseksi5StateChanged(evt);
            }
        });
        cekseksi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekseksi5ActionPerformed(evt);
            }
        });

        cboruang5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboruang5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ahli Kinerja", "Akuntansi", "Asman PAD", "DPC-SP", "Gudang LT.I", "Humas", "Kasir", "Keuangan", "Komersil", "Manajer", "Operator Telepon", "P2TL", "Panitia Ruang & Jasa", "Penagihan", "Ruang Rapat", "SDM", "Sekretaris Asman TEL", "Sekretaris Manajer", "Sekretariat Umum", "Seksi HAR Meter", "Seksi Operasi Distribusi", "Seksi Logistik", "Seksi Pemeliharaan Distribusi", "Seksi PPL", "Seksi Proteksi", "Seksi TEL", "SP", "SP2J", "TERA", "Transaksi Energi Listrik" }));
        cboruang5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboruang5ItemStateChanged(evt);
            }
        });
        cboruang5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboruang5ActionPerformed(evt);
            }
        });

        cekruang5.setBackground(new java.awt.Color(204, 204, 204));
        cekruang5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekruang5.setText("    Ruang");
        cekruang5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekruang5StateChanged(evt);
            }
        });
        cekruang5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekruang5ActionPerformed(evt);
            }
        });

        cbokondisi5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbokondisi5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baik", "Rusak" }));
        cbokondisi5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbokondisi5ItemStateChanged(evt);
            }
        });
        cbokondisi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbokondisi5ActionPerformed(evt);
            }
        });

        cekkondisi5.setBackground(new java.awt.Color(204, 204, 204));
        cekkondisi5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekkondisi5.setText("    Kondisi");
        cekkondisi5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekkondisi5StateChanged(evt);
            }
        });
        cekkondisi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekkondisi5ActionPerformed(evt);
            }
        });

        cboketerangan5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboketerangan5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        cboketerangan5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboketerangan5ItemStateChanged(evt);
            }
        });
        cboketerangan5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboketerangan5ActionPerformed(evt);
            }
        });

        cekketerangan5.setBackground(new java.awt.Color(204, 204, 204));
        cekketerangan5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekketerangan5.setText("    Keterangan");
        cekketerangan5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekketerangan5StateChanged(evt);
            }
        });
        cekketerangan5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekketerangan5ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("* Pilih 6 Kategori");

        txttahunakhir5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        txttahunakhir5.setText("* yyyy");
        txttahunakhir5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunakhir5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunakhir5KeyReleased(evt);
            }
        });

        txttahunawal5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        txttahunawal5.setText("* yyyy");
        txttahunawal5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunawal5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunawal5KeyReleased(evt);
            }
        });

        cektahun5.setBackground(new java.awt.Color(204, 204, 204));
        cektahun5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cektahun5.setText("  Tahun Perolehan");
        cektahun5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cektahun5StateChanged(evt);
            }
        });
        cektahun5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cektahun5ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel16.setText("s/d");

        javax.swing.GroupLayout panel6kategoriLayout = new javax.swing.GroupLayout(panel6kategori);
        panel6kategori.setLayout(panel6kategoriLayout);
        panel6kategoriLayout.setHorizontalGroup(
            panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6kategoriLayout.createSequentialGroup()
                .addGroup(panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6kategoriLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cekjenis5, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbojenis5, 0, 184, Short.MAX_VALUE))
                    .addGroup(panel6kategoriLayout.createSequentialGroup()
                        .addGroup(panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel6kategoriLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cektahun5, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel6kategoriLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cekseksi5, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6kategoriLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cekruang5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(cekkondisi5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(cekketerangan5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                                    .addComponent(cekbagian5, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboketerangan5, javax.swing.GroupLayout.Alignment.TRAILING, 0, 183, Short.MAX_VALUE)
                            .addComponent(cbokondisi5, javax.swing.GroupLayout.Alignment.TRAILING, 0, 183, Short.MAX_VALUE)
                            .addComponent(cboruang5, javax.swing.GroupLayout.Alignment.TRAILING, 0, 183, Short.MAX_VALUE)
                            .addComponent(cboseksi5, javax.swing.GroupLayout.Alignment.TRAILING, 0, 183, Short.MAX_VALUE)
                            .addComponent(cbobagian5, javax.swing.GroupLayout.Alignment.TRAILING, 0, 183, Short.MAX_VALUE)
                            .addGroup(panel6kategoriLayout.createSequentialGroup()
                                .addComponent(txttahunawal5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttahunakhir5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panel6kategoriLayout.setVerticalGroup(
            panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6kategoriLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbojenis5, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(cekjenis5))
                .addGap(18, 18, 18)
                .addGroup(panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttahunakhir5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(cektahun5)
                    .addComponent(txttahunawal5, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbobagian5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekbagian5))
                .addGap(21, 21, 21)
                .addGroup(panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboseksi5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekseksi5))
                .addGap(17, 17, 17)
                .addGroup(panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboruang5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekruang5))
                .addGap(18, 18, 18)
                .addGroup(panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbokondisi5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekkondisi5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel6kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboketerangan5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekketerangan5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(300, 300, 300))
        );

        panelinduk.add(panel6kategori, "card7");

        cbojenis6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbojenis6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbojenis6ItemStateChanged(evt);
            }
        });
        cbojenis6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbojenis6ActionPerformed(evt);
            }
        });

        cekjenis6.setBackground(new java.awt.Color(204, 204, 204));
        cekjenis6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekjenis6.setText("    Jenis Inventaris");
        cekjenis6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekjenis6StateChanged(evt);
            }
        });
        cekjenis6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekjenis6ActionPerformed(evt);
            }
        });

        cbobagian6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbobagian6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jaringan", "Transaksi Energi Listrik", "Pelayanan & Adm", "Kosong" }));
        cbobagian6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbobagian6ItemStateChanged(evt);
            }
        });
        cbobagian6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbobagian6ActionPerformed(evt);
            }
        });

        cekbagian6.setBackground(new java.awt.Color(204, 204, 204));
        cekbagian6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekbagian6.setText("    Bagian");
        cekbagian6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekbagian6StateChanged(evt);
            }
        });
        cekbagian6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekbagian6ActionPerformed(evt);
            }
        });

        cboseksi6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboseksi6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Adm Umum", "Kosong", "Operasi", "Pemeliharaan", "Pemeliharaan Meter", "Pengendalian Susut", "PPL", "Transaksi Energi Listrik" }));
        cboseksi6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboseksi6ItemStateChanged(evt);
            }
        });
        cboseksi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboseksi6ActionPerformed(evt);
            }
        });

        cekseksi6.setBackground(new java.awt.Color(204, 204, 204));
        cekseksi6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekseksi6.setText("    Seksi");
        cekseksi6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekseksi6StateChanged(evt);
            }
        });
        cekseksi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekseksi6ActionPerformed(evt);
            }
        });

        cboruang6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboruang6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ahli Kinerja", "Akuntansi", "Asman PAD", "DPC-SP", "Gudang LT.I", "Humas", "Kasir", "Keuangan", "Komersil", "Manajer", "Operator Telepon", "P2TL", "Panitia Ruang & Jasa", "Penagihan", "Ruang Rapat", "SDM", "Sekretaris Asman TEL", "Sekretaris Manajer", "Sekretariat Umum", "Seksi HAR Meter", "Seksi Operasi Distribusi", "Seksi Logistik", "Seksi Pemeliharaan Distribusi", "Seksi PPL", "Seksi Proteksi", "Seksi TEL", "SP", "SP2J", "TERA", "Transaksi Energi Listrik" }));
        cboruang6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboruang6ItemStateChanged(evt);
            }
        });
        cboruang6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboruang6ActionPerformed(evt);
            }
        });

        cekruang6.setBackground(new java.awt.Color(204, 204, 204));
        cekruang6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekruang6.setText("    Ruang");
        cekruang6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekruang6StateChanged(evt);
            }
        });
        cekruang6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekruang6ActionPerformed(evt);
            }
        });

        cbokondisi6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cbokondisi6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baik", "Rusak" }));
        cbokondisi6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbokondisi6ItemStateChanged(evt);
            }
        });
        cbokondisi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbokondisi6ActionPerformed(evt);
            }
        });

        cekkondisi6.setBackground(new java.awt.Color(204, 204, 204));
        cekkondisi6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekkondisi6.setText("    Kondisi");
        cekkondisi6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekkondisi6StateChanged(evt);
            }
        });
        cekkondisi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekkondisi6ActionPerformed(evt);
            }
        });

        cboketerangan6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cboketerangan6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        cboketerangan6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboketerangan6ItemStateChanged(evt);
            }
        });
        cboketerangan6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboketerangan6ActionPerformed(evt);
            }
        });

        cekketerangan6.setBackground(new java.awt.Color(204, 204, 204));
        cekketerangan6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cekketerangan6.setText("    Keterangan");
        cekketerangan6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cekketerangan6StateChanged(evt);
            }
        });
        cekketerangan6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekketerangan6ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel17.setForeground(new java.awt.Color(0, 0, 255));
        jLabel17.setText("* Pilih 7 Kategori");

        txttahunakhir6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        txttahunakhir6.setText("* yyyy");
        txttahunakhir6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunakhir6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunakhir6KeyReleased(evt);
            }
        });

        txttahunawal6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        txttahunawal6.setText("* yyyy");
        txttahunawal6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txttahunawal6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttahunawal6KeyReleased(evt);
            }
        });

        cektahun6.setBackground(new java.awt.Color(204, 204, 204));
        cektahun6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        cektahun6.setText("  Tahun Perolehan");
        cektahun6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cektahun6StateChanged(evt);
            }
        });
        cektahun6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cektahun6ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jLabel20.setText("s/d");

        javax.swing.GroupLayout panel7kategoriLayout = new javax.swing.GroupLayout(panel7kategori);
        panel7kategori.setLayout(panel7kategoriLayout);
        panel7kategoriLayout.setHorizontalGroup(
            panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7kategoriLayout.createSequentialGroup()
                .addGroup(panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(panel7kategoriLayout.createSequentialGroup()
                        .addGroup(panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel7kategoriLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cekjenis6, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                            .addGroup(panel7kategoriLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cekseksi6, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel7kategoriLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cekruang6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(cekkondisi6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(cekketerangan6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                                    .addComponent(cekbagian6, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                            .addGroup(panel7kategoriLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cektahun6, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboketerangan6, 0, 183, Short.MAX_VALUE)
                            .addComponent(cbokondisi6, 0, 183, Short.MAX_VALUE)
                            .addComponent(cboruang6, 0, 183, Short.MAX_VALUE)
                            .addComponent(cboseksi6, 0, 183, Short.MAX_VALUE)
                            .addComponent(cbobagian6, 0, 183, Short.MAX_VALUE)
                            .addGroup(panel7kategoriLayout.createSequentialGroup()
                                .addComponent(txttahunawal6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttahunakhir6, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                            .addComponent(cbojenis6, 0, 183, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panel7kategoriLayout.setVerticalGroup(
            panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel7kategoriLayout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbojenis6, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(cekjenis6))
                .addGap(18, 18, 18)
                .addGroup(panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttahunakhir6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cektahun6)
                    .addComponent(txttahunawal6, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel20))
                .addGap(25, 25, 25)
                .addGroup(panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekbagian6)
                    .addComponent(cbobagian6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekseksi6)
                    .addComponent(cboseksi6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekruang6)
                    .addComponent(cboruang6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekkondisi6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbokondisi6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel7kategoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cekketerangan6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboketerangan6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        panelinduk.add(panel7kategori, "card8");

        javax.swing.GroupLayout panelawalLayout = new javax.swing.GroupLayout(panelawal);
        panelawal.setLayout(panelawalLayout);
        panelawalLayout.setHorizontalGroup(
            panelawalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );
        panelawalLayout.setVerticalGroup(
            panelawalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        panelinduk.add(panelawal, "card2");

        buttonGroup1.add(rb1);
        rb1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        rb1.setText("1 Kategori");
        rb1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb1StateChanged(evt);
            }
        });
        rb1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rb1ItemStateChanged(evt);
            }
        });
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb2);
        rb2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        rb2.setText("2 Kategori");
        rb2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb2StateChanged(evt);
            }
        });
        rb2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rb2ItemStateChanged(evt);
            }
        });
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb3);
        rb3.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        rb3.setText("3 Kategori");
        rb3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb3StateChanged(evt);
            }
        });
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb4);
        rb4.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        rb4.setText("4 Kategori");
        rb4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb4StateChanged(evt);
            }
        });
        rb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb5);
        rb5.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        rb5.setText("5 Kategori");
        rb5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb5StateChanged(evt);
            }
        });
        rb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb6);
        rb6.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        rb6.setText("6 Kategori");
        rb6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb6StateChanged(evt);
            }
        });
        rb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb6ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb7);
        rb7.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        rb7.setText("Seluruh Kategori");
        rb7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rb7StateChanged(evt);
            }
        });
        rb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rb1)
                        .addGap(8, 8, 8)
                        .addComponent(rb2)
                        .addGap(10, 10, 10)
                        .addComponent(rb3)
                        .addGap(10, 10, 10)
                        .addComponent(rb4)
                        .addGap(10, 10, 10)
                        .addComponent(rb5)
                        .addGap(10, 10, 10)
                        .addComponent(rb6)
                        .addGap(10, 10, 10)
                        .addComponent(rb7))
                    .addComponent(jLabel18))
                .addContainerGap(598, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelinduk, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(datatabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rb1)
                    .addComponent(rb2)
                    .addComponent(rb3)
                    .addComponent(rb4)
                    .addComponent(rb5)
                    .addComponent(rb6)
                    .addComponent(rb7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelinduk, 0, 0, Short.MAX_VALUE)
                    .addComponent(datatabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
       
    }//GEN-LAST:event_formMouseMoved


    private void cbokondisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbokondisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbokondisiActionPerformed

    private void cbobagianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbobagianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbobagianActionPerformed

    private void cboruangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboruangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboruangActionPerformed

    private void cboketeranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboketeranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboketeranganActionPerformed

    private void cboketeranganItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboketeranganItemStateChanged
        datatabel();
    }//GEN-LAST:event_cboketeranganItemStateChanged

    private void cbokondisiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbokondisiItemStateChanged
        datatabel();
    }//GEN-LAST:event_cbokondisiItemStateChanged

    private void cboruangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboruangItemStateChanged
        datatabel();
    }//GEN-LAST:event_cboruangItemStateChanged

    private void cboseksiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboseksiItemStateChanged
    datatabel();
}//GEN-LAST:event_cboseksiItemStateChanged

    private void cboseksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboseksiActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_cboseksiActionPerformed

    private void cbobagianItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbobagianItemStateChanged
        datatabel();
    }//GEN-LAST:event_cbobagianItemStateChanged

    private void tblBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBarangMouseClicked

}//GEN-LAST:event_tblBarangMouseClicked

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnKeluarActionPerformed

    private void cekjenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekjenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekjenisActionPerformed

    private void cekbagianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekbagianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekbagianActionPerformed

    private void cekseksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekseksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekseksiActionPerformed

    private void cekruangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekruangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekruangActionPerformed

    private void cekkondisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekkondisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekkondisiActionPerformed

    private void cekketeranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekketeranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekketeranganActionPerformed

    private void cbojenisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbojenisItemStateChanged
        datatabel();
    }//GEN-LAST:event_cbojenisItemStateChanged

    private void cbojenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbojenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbojenisActionPerformed

    private void cekjenisStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekjenisStateChanged

        if (cekjenis.isSelected()== false){
            cbojenis.setEnabled(false);
        } else{
            cbojenis.setEnabled(true);
            datatabel();
        }
}//GEN-LAST:event_cekjenisStateChanged

    private void cekbagianStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekbagianStateChanged

        if (cekbagian.isSelected()== false){
            cbobagian.setEnabled(false);
        } else{
            cbobagian.setEnabled(true);
            datatabel();
        }
}//GEN-LAST:event_cekbagianStateChanged

    private void cekseksiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekseksiStateChanged

        if (cekseksi.isSelected()== false){
            cboseksi.setEnabled(false);
        } else{
            cboseksi.setEnabled(true);
            datatabel();
        }
}//GEN-LAST:event_cekseksiStateChanged

    private void cekruangStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekruangStateChanged

        if (cekruang.isSelected()== false){
            cboruang.setEnabled(false);
        } else{
            cboruang.setEnabled(true);
            datatabel();
        }
}//GEN-LAST:event_cekruangStateChanged

    private void cekkondisiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekkondisiStateChanged

        if (cekkondisi.isSelected()== false){
            cbokondisi.setEnabled(false);
        } else{
            cbokondisi.setEnabled(true);
            datatabel();
        }
}//GEN-LAST:event_cekkondisiStateChanged

    private void cekketeranganStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekketeranganStateChanged

        if (cekketerangan.isSelected()== false){
            cboketerangan.setEnabled(false);
        } else{
            cboketerangan.setEnabled(true);
            datatabel();
        }
}//GEN-LAST:event_cekketeranganStateChanged

    private void rb1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rb1ItemStateChanged

    }//GEN-LAST:event_rb1ItemStateChanged

    private void rb2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rb2ItemStateChanged

    }//GEN-LAST:event_rb2ItemStateChanged

    private void cbojenis1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbojenis1ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbojenis1ItemStateChanged

    private void cbojenis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbojenis1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbojenis1ActionPerformed

    private void cekjenis1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekjenis1StateChanged
        if (cekjenis1.isSelected()== false){
            cbojenis1.setEnabled(false);
        } else{
            cbojenis1.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekjenis1StateChanged

    private void cekjenis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekjenis1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekjenis1ActionPerformed

    private void cbobagian1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbobagian1ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbobagian1ItemStateChanged

    private void cbobagian1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbobagian1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbobagian1ActionPerformed

    private void cekbagian1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekbagian1StateChanged
        if (cekbagian1.isSelected()== false){
            cbobagian1.setEnabled(false);
        } else{
            cbobagian1.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekbagian1StateChanged

    private void cekbagian1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekbagian1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekbagian1ActionPerformed

    private void cboseksi1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboseksi1ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboseksi1ItemStateChanged

    private void cboseksi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboseksi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboseksi1ActionPerformed

    private void cekseksi1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekseksi1StateChanged
        if (cekseksi1.isSelected()== false){
            cboseksi1.setEnabled(false);
        } else{
            cboseksi1.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekseksi1StateChanged

    private void cekseksi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekseksi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekseksi1ActionPerformed

    private void cboruang1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboruang1ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboruang1ItemStateChanged

    private void cboruang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboruang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboruang1ActionPerformed

    private void cekruang1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekruang1StateChanged
        if (cekruang1.isSelected()== false){
            cboruang1.setEnabled(false);
        } else{
            cboruang1.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekruang1StateChanged

    private void cekruang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekruang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekruang1ActionPerformed

    private void cbokondisi1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbokondisi1ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbokondisi1ItemStateChanged

    private void cbokondisi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbokondisi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbokondisi1ActionPerformed

    private void cekkondisi1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekkondisi1StateChanged
        if (cekkondisi1.isSelected()== false){
            cbokondisi1.setEnabled(false);
        } else{
            cbokondisi1.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekkondisi1StateChanged

    private void cekkondisi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekkondisi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekkondisi1ActionPerformed

    private void cboketerangan1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboketerangan1ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboketerangan1ItemStateChanged

    private void cboketerangan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboketerangan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboketerangan1ActionPerformed

    private void cekketerangan1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekketerangan1StateChanged
        if (cekketerangan1.isSelected()== false){
            cboketerangan1.setEnabled(false);
        } else{
            cboketerangan1.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekketerangan1StateChanged

    private void cekketerangan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekketerangan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekketerangan1ActionPerformed

    private void cbojenis2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbojenis2ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbojenis2ItemStateChanged

    private void cbojenis2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbojenis2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbojenis2ActionPerformed

    private void cekjenis2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekjenis2StateChanged
        if (cekjenis2.isSelected()== false){
            cbojenis2.setEnabled(false);
        } else{
            cbojenis2.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekjenis2StateChanged

    private void cekjenis2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekjenis2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekjenis2ActionPerformed

    private void cbobagian2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbobagian2ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbobagian2ItemStateChanged

    private void cbobagian2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbobagian2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbobagian2ActionPerformed

    private void cekbagian2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekbagian2StateChanged
        if (cekbagian2.isSelected()== false){
            cbobagian2.setEnabled(false);
        } else{
            cbobagian2.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekbagian2StateChanged

    private void cekbagian2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekbagian2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekbagian2ActionPerformed

    private void cboseksi2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboseksi2ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboseksi2ItemStateChanged

    private void cboseksi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboseksi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboseksi2ActionPerformed

    private void cekseksi2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekseksi2StateChanged
        if (cekseksi2.isSelected()== false){
            cboseksi2.setEnabled(false);
        } else{
            cboseksi2.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekseksi2StateChanged

    private void cekseksi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekseksi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekseksi2ActionPerformed

    private void cboruang2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboruang2ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboruang2ItemStateChanged

    private void cboruang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboruang2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboruang2ActionPerformed

    private void cekruang2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekruang2StateChanged
        if (cekruang2.isSelected()== false){
            cboruang2.setEnabled(false);
        } else{
            cboruang2.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekruang2StateChanged

    private void cekruang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekruang2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekruang2ActionPerformed

    private void cbokondisi2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbokondisi2ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbokondisi2ItemStateChanged

    private void cbokondisi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbokondisi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbokondisi2ActionPerformed

    private void cekkondisi2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekkondisi2StateChanged
        if (cekkondisi2.isSelected()== false){
            cbokondisi2.setEnabled(false);
        } else{
            cbokondisi2.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekkondisi2StateChanged

    private void cekkondisi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekkondisi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekkondisi2ActionPerformed

    private void cboketerangan2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboketerangan2ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboketerangan2ItemStateChanged

    private void cboketerangan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboketerangan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboketerangan2ActionPerformed

    private void cekketerangan2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekketerangan2StateChanged
        if (cekketerangan2.isSelected()== false){
            cboketerangan2.setEnabled(false);
        } else{
            cboketerangan2.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekketerangan2StateChanged

    private void cekketerangan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekketerangan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekketerangan2ActionPerformed

    private void rb3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb3StateChanged

    }//GEN-LAST:event_rb3StateChanged

    private void rb1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb1StateChanged

    }//GEN-LAST:event_rb1StateChanged

    private void rb2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb2StateChanged

    }//GEN-LAST:event_rb2StateChanged

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
panel1kategori.setVisible(true);
panel2kategori.setVisible(false);
panel3kategori.setVisible(false);
panel4kategori.setVisible(false);
panel5kategori.setVisible(false);
panel6kategori.setVisible(false);
panel7kategori.setVisible(false);
bersihkan();
    }//GEN-LAST:event_rb1ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
bersihkan();
panel2kategori.setVisible(true);
panel1kategori.setVisible(false);
panel3kategori.setVisible(false);
panel4kategori.setVisible(false);
panel5kategori.setVisible(false);
panel6kategori.setVisible(false);
panel7kategori.setVisible(false);

    }//GEN-LAST:event_rb2ActionPerformed

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
bersihkan();
panel3kategori.setVisible(true);
panel1kategori.setVisible(false);
panel2kategori.setVisible(false);
panel4kategori.setVisible(false);
panel5kategori.setVisible(false);
panel6kategori.setVisible(false);
panel7kategori.setVisible(false);

    }//GEN-LAST:event_rb3ActionPerformed

    private void rb4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb4StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rb4StateChanged

    private void rb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb4ActionPerformed
bersihkan();
panel1kategori.setVisible(false);
panel2kategori.setVisible(false);
panel3kategori.setVisible(false);
panel4kategori.setVisible(true);
panel5kategori.setVisible(false);
panel6kategori.setVisible(false);
panel7kategori.setVisible(false);
    }//GEN-LAST:event_rb4ActionPerformed

    private void rb5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb5StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rb5StateChanged

    private void rb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb5ActionPerformed
bersihkan();
panel1kategori.setVisible(false);
panel2kategori.setVisible(false);
panel3kategori.setVisible(false);
panel4kategori.setVisible(false);
panel5kategori.setVisible(true);
panel6kategori.setVisible(false);
panel7kategori.setVisible(false);
    }//GEN-LAST:event_rb5ActionPerformed

    private void rb6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb6StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rb6StateChanged

    private void rb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb6ActionPerformed
bersihkan();
panel1kategori.setVisible(false);
panel2kategori.setVisible(false);
panel3kategori.setVisible(false);
panel4kategori.setVisible(false);
panel5kategori.setVisible(false);
panel6kategori.setVisible(true);
panel7kategori.setVisible(false);
    }//GEN-LAST:event_rb6ActionPerformed

    private void cbojenis3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbojenis3ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbojenis3ItemStateChanged

    private void cbojenis3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbojenis3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbojenis3ActionPerformed

    private void cekjenis3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekjenis3StateChanged
        if (cekjenis3.isSelected()== false){
            cbojenis3.setEnabled(false);
        } else{
            cbojenis3.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekjenis3StateChanged

    private void cekjenis3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekjenis3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekjenis3ActionPerformed

    private void cbobagian3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbobagian3ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbobagian3ItemStateChanged

    private void cbobagian3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbobagian3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbobagian3ActionPerformed

    private void cekbagian3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekbagian3StateChanged
        if (cekbagian3.isSelected()== false){
            cbobagian3.setEnabled(false);
        } else{
            cbobagian3.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekbagian3StateChanged

    private void cekbagian3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekbagian3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekbagian3ActionPerformed

    private void cboseksi3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboseksi3ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboseksi3ItemStateChanged

    private void cboseksi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboseksi3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboseksi3ActionPerformed

    private void cekseksi3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekseksi3StateChanged
        if (cekseksi3.isSelected()== false){
            cboseksi3.setEnabled(false);
        } else{
            cboseksi3.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekseksi3StateChanged

    private void cekseksi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekseksi3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekseksi3ActionPerformed

    private void cboruang3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboruang3ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboruang3ItemStateChanged

    private void cboruang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboruang3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboruang3ActionPerformed

    private void cekruang3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekruang3StateChanged
        if (cekruang3.isSelected()== false){
            cboruang3.setEnabled(false);
        } else{
            cboruang3.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekruang3StateChanged

    private void cekruang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekruang3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekruang3ActionPerformed

    private void cbokondisi3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbokondisi3ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbokondisi3ItemStateChanged

    private void cbokondisi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbokondisi3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbokondisi3ActionPerformed

    private void cekkondisi3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekkondisi3StateChanged
        if (cekkondisi3.isSelected()== false){
            cbokondisi3.setEnabled(false);
        } else{
            cbokondisi3.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekkondisi3StateChanged

    private void cekkondisi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekkondisi3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekkondisi3ActionPerformed

    private void cboketerangan3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboketerangan3ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboketerangan3ItemStateChanged

    private void cboketerangan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboketerangan3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboketerangan3ActionPerformed

    private void cekketerangan3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekketerangan3StateChanged
        if (cekketerangan3.isSelected()== false){
            cboketerangan3.setEnabled(false);
        } else{
            cboketerangan3.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekketerangan3StateChanged

    private void cekketerangan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekketerangan3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekketerangan3ActionPerformed

    private void cbojenis4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbojenis4ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbojenis4ItemStateChanged

    private void cbojenis4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbojenis4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbojenis4ActionPerformed

    private void cekjenis4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekjenis4StateChanged
        if (cekjenis4.isSelected()== false){
            cbojenis4.setEnabled(false);
        } else{
            cbojenis4.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekjenis4StateChanged

    private void cekjenis4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekjenis4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekjenis4ActionPerformed

    private void cbobagian4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbobagian4ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbobagian4ItemStateChanged

    private void cbobagian4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbobagian4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbobagian4ActionPerformed

    private void cekbagian4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekbagian4StateChanged
        if (cekbagian4.isSelected()== false){
            cbobagian4.setEnabled(false);
        } else{
            cbobagian4.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekbagian4StateChanged

    private void cekbagian4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekbagian4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekbagian4ActionPerformed

    private void cboseksi4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboseksi4ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboseksi4ItemStateChanged

    private void cboseksi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboseksi4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboseksi4ActionPerformed

    private void cekseksi4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekseksi4StateChanged
        if (cekseksi4.isSelected()== false){
            cboseksi4.setEnabled(false);
        } else{
            cboseksi4.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekseksi4StateChanged

    private void cekseksi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekseksi4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekseksi4ActionPerformed

    private void cboruang4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboruang4ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboruang4ItemStateChanged

    private void cboruang4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboruang4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboruang4ActionPerformed

    private void cekruang4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekruang4StateChanged
        if (cekruang4.isSelected()== false){
            cboruang4.setEnabled(false);
        } else{
            cboruang4.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekruang4StateChanged

    private void cekruang4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekruang4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekruang4ActionPerformed

    private void cbokondisi4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbokondisi4ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbokondisi4ItemStateChanged

    private void cbokondisi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbokondisi4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbokondisi4ActionPerformed

    private void cekkondisi4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekkondisi4StateChanged
        if (cekkondisi4.isSelected()== false){
            cbokondisi4.setEnabled(false);
        } else{
            cbokondisi4.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekkondisi4StateChanged

    private void cekkondisi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekkondisi4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekkondisi4ActionPerformed

    private void cboketerangan4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboketerangan4ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboketerangan4ItemStateChanged

    private void cboketerangan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboketerangan4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboketerangan4ActionPerformed

    private void cekketerangan4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekketerangan4StateChanged
        if (cekketerangan4.isSelected()== false){
            cboketerangan4.setEnabled(false);
        } else{
            cboketerangan4.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekketerangan4StateChanged

    private void cekketerangan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekketerangan4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekketerangan4ActionPerformed

    private void cbojenis5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbojenis5ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbojenis5ItemStateChanged

    private void cbojenis5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbojenis5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbojenis5ActionPerformed

    private void cekjenis5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekjenis5StateChanged
        if (cekjenis5.isSelected()== false){
            cbojenis5.setEnabled(false);
        } else{
            cbojenis5.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekjenis5StateChanged

    private void cekjenis5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekjenis5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekjenis5ActionPerformed

    private void cbobagian5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbobagian5ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbobagian5ItemStateChanged

    private void cbobagian5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbobagian5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbobagian5ActionPerformed

    private void cekbagian5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekbagian5StateChanged
        if (cekbagian5.isSelected()== false){
            cbobagian5.setEnabled(false);
        } else{
            cbobagian5.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekbagian5StateChanged

    private void cekbagian5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekbagian5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekbagian5ActionPerformed

    private void cboseksi5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboseksi5ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboseksi5ItemStateChanged

    private void cboseksi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboseksi5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboseksi5ActionPerformed

    private void cekseksi5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekseksi5StateChanged
        if (cekseksi5.isSelected()== false){
            cboseksi5.setEnabled(false);
        } else{
            cboseksi5.setEnabled(true);
            datatabel();
    }
    }//GEN-LAST:event_cekseksi5StateChanged

    private void cekseksi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekseksi5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekseksi5ActionPerformed

    private void cboruang5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboruang5ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboruang5ItemStateChanged

    private void cboruang5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboruang5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboruang5ActionPerformed

    private void cekruang5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekruang5StateChanged
        if (cekruang5.isSelected()== false){
            cboruang5.setEnabled(false);
        } else{
            cboruang5.setEnabled(true);
            datatabel();
    }
    }//GEN-LAST:event_cekruang5StateChanged

    private void cekruang5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekruang5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekruang5ActionPerformed

    private void cbokondisi5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbokondisi5ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cbokondisi5ItemStateChanged

    private void cbokondisi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbokondisi5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbokondisi5ActionPerformed

    private void cekkondisi5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekkondisi5StateChanged
        if (cekkondisi5.isSelected()== false){
            cbokondisi5.setEnabled(false);
        } else{
            cbokondisi5.setEnabled(true);
            datatabel();
    }
    }//GEN-LAST:event_cekkondisi5StateChanged

    private void cekkondisi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekkondisi5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekkondisi5ActionPerformed

    private void cboketerangan5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboketerangan5ItemStateChanged
            datatabel();
    }//GEN-LAST:event_cboketerangan5ItemStateChanged

    private void cboketerangan5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboketerangan5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboketerangan5ActionPerformed

    private void cekketerangan5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekketerangan5StateChanged
        if (cekketerangan5.isSelected()== false){
            cboketerangan5.setEnabled(false);
        } else{
            cboketerangan5.setEnabled(true);
            datatabel();
    }
    }//GEN-LAST:event_cekketerangan5StateChanged

    private void cekketerangan5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekketerangan5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekketerangan5ActionPerformed

    private void cektahunStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cektahunStateChanged
        if (cektahun.isSelected()== false){
            txttahunawal.setEnabled(false);
            txttahunakhir.setEnabled(false);
        } else{
            txttahunawal.setEnabled(true);
            txttahunakhir.setEnabled(true);
            datatabel();
    }
    }//GEN-LAST:event_cektahunStateChanged

    private void cektahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cektahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cektahunActionPerformed

    private void txttahunawalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunawalKeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunawalKeyReleased

    private void txttahunakhirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunakhirKeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunakhirKeyReleased

    private void txttahunakhir1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunakhir1KeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunakhir1KeyReleased

    private void cektahun1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cektahun1StateChanged
        if (cektahun1.isSelected()== false){
            txttahunawal1.setEnabled(false);
            txttahunakhir1.setEnabled(false);
        } else{
            txttahunawal1.setEnabled(true);
            txttahunakhir1.setEnabled(true);
            datatabel();
    }
    }//GEN-LAST:event_cektahun1StateChanged

    private void cektahun1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cektahun1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cektahun1ActionPerformed

    private void txttahunawal1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunawal1KeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunawal1KeyReleased

    private void cektahun2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cektahun2StateChanged
        if (cektahun2.isSelected()== false){
            txttahunawal2.setEnabled(false);
            txttahunakhir2.setEnabled(false);
        } else{
            txttahunawal2.setEnabled(true);
            txttahunakhir2.setEnabled(true);
            datatabel();
    }
    }//GEN-LAST:event_cektahun2StateChanged

    private void cektahun2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cektahun2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cektahun2ActionPerformed

    private void txttahunakhir2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunakhir2KeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunakhir2KeyReleased

    private void txttahunawal2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunawal2KeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunawal2KeyReleased

    private void txttahunawal3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunawal3KeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunawal3KeyReleased

    private void txttahunakhir3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunakhir3KeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunakhir3KeyReleased

    private void cektahun3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cektahun3StateChanged
        if (cektahun3.isSelected()== false){
            txttahunawal3.setEnabled(false);
            txttahunakhir3.setEnabled(false);
        } else{
            txttahunawal3.setEnabled(true);
            txttahunakhir3.setEnabled(true);
            datatabel();
    }
    }//GEN-LAST:event_cektahun3StateChanged

    private void cektahun3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cektahun3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cektahun3ActionPerformed

    private void cektahun4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cektahun4StateChanged
        if (cektahun4.isSelected()== false){
            txttahunawal4.setEnabled(false);
            txttahunakhir4.setEnabled(false);
        } else{
            txttahunawal4.setEnabled(true);
            txttahunakhir4.setEnabled(true);
            datatabel();
    }
    }//GEN-LAST:event_cektahun4StateChanged

    private void cektahun4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cektahun4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cektahun4ActionPerformed

    private void txttahunawal4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunawal4KeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunawal4KeyReleased

    private void txttahunakhir4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunakhir4KeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunakhir4KeyReleased

    private void txttahunakhir5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunakhir5KeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunakhir5KeyReleased

    private void txttahunawal5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunawal5KeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunawal5KeyReleased

    private void cektahun5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cektahun5StateChanged
        if (cektahun5.isSelected()== false){
            txttahunawal5.setEnabled(false);
            txttahunakhir5.setEnabled(false);
        } else{
            txttahunawal5.setEnabled(true);
            txttahunakhir5.setEnabled(true);
            datatabel();
    }
    }//GEN-LAST:event_cektahun5StateChanged

    private void cektahun5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cektahun5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cektahun5ActionPerformed

    private void cbojenis6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbojenis6ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbojenis6ItemStateChanged

    private void cbojenis6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbojenis6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbojenis6ActionPerformed

    private void cekjenis6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekjenis6StateChanged
        if (cekjenis6.isSelected()== false){
            cbojenis6.setEnabled(false);
        } else{
            cbojenis6.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekjenis6StateChanged

    private void cekjenis6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekjenis6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekjenis6ActionPerformed

    private void cbobagian6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbobagian6ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbobagian6ItemStateChanged

    private void cbobagian6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbobagian6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbobagian6ActionPerformed

    private void cekbagian6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekbagian6StateChanged
        if (cekbagian6.isSelected()== false){
            cbobagian6.setEnabled(false);
        } else{
            cbobagian6.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekbagian6StateChanged

    private void cekbagian6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekbagian6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekbagian6ActionPerformed

    private void cboseksi6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboseksi6ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboseksi6ItemStateChanged

    private void cboseksi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboseksi6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboseksi6ActionPerformed

    private void cekseksi6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekseksi6StateChanged
        if (cekseksi6.isSelected()== false){
            cboseksi6.setEnabled(false);
        } else{
            cboseksi6.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekseksi6StateChanged

    private void cekseksi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekseksi6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekseksi6ActionPerformed

    private void cboruang6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboruang6ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboruang6ItemStateChanged

    private void cboruang6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboruang6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboruang6ActionPerformed

    private void cekruang6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekruang6StateChanged
        if (cekruang6.isSelected()== false){
            cboruang6.setEnabled(false);
        } else{
            cboruang6.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekruang6StateChanged

    private void cekruang6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekruang6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekruang6ActionPerformed

    private void cbokondisi6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbokondisi6ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbokondisi6ItemStateChanged

    private void cbokondisi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbokondisi6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbokondisi6ActionPerformed

    private void cekkondisi6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekkondisi6StateChanged
        if (cekkondisi6.isSelected()== false){
            cbokondisi6.setEnabled(false);
        } else{
            cbokondisi6.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekkondisi6StateChanged

    private void cekkondisi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekkondisi6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekkondisi6ActionPerformed

    private void cboketerangan6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboketerangan6ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cboketerangan6ItemStateChanged

    private void cboketerangan6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboketerangan6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboketerangan6ActionPerformed

    private void cekketerangan6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cekketerangan6StateChanged
        if (cekketerangan6.isSelected()== false){
            cboketerangan6.setEnabled(false);
        } else{
            cboketerangan6.setEnabled(true);
            datatabel();
        }
    }//GEN-LAST:event_cekketerangan6StateChanged

    private void cekketerangan6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekketerangan6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cekketerangan6ActionPerformed

    private void txttahunakhir6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunakhir6KeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunakhir6KeyReleased

    private void txttahunawal6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttahunawal6KeyReleased
        datatabel();
    }//GEN-LAST:event_txttahunawal6KeyReleased

    private void cektahun6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cektahun6StateChanged
        if (cektahun6.isSelected()== false){
            txttahunawal6.setEnabled(false);
            txttahunakhir6.setEnabled(false);
        } else{
            txttahunawal6.setEnabled(true);
            txttahunakhir6.setEnabled(true);
            datatabel();
    }
    }//GEN-LAST:event_cektahun6StateChanged

    private void cektahun6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cektahun6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cektahun6ActionPerformed

    private void rb7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rb7StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_rb7StateChanged

    private void rb7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb7ActionPerformed
bersihkan();
panel1kategori.setVisible(false);
panel2kategori.setVisible(false);
panel3kategori.setVisible(false);
panel4kategori.setVisible(false);
panel5kategori.setVisible(false);
panel6kategori.setVisible(false);
panel7kategori.setVisible(true);
    }//GEN-LAST:event_rb7ActionPerformed

    private void sizeColumns(JTable table) {
        TableColumnModel columns = table.getColumnModel();
        TableModel data = table.getModel();
        int margin = columns.getColumnMargin() * 2;
        int columnCount = columns.getColumnCount();
        int rowCount = data.getRowCount();
        for (int col = 0; col < columnCount; col++) {
            TableColumn column = columns.getColumn(col);
            int modelCol = column.getModelIndex();
            int width = 0;
            for (int row = 0; row < rowCount; row++) {
                TableCellRenderer r = table.getCellRenderer(row, col);
                int w = r.getTableCellRendererComponent(
                  table, data.getValueAt(row, modelCol), false, false, row, col)
                  .getPreferredSize().width;
                if (w > width) {
                    width = w;
                }
            }
            column.setPreferredWidth(width + margin);
        }
    }

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        MessageFormat header = new MessageFormat("Laporan Inventaris PT. PLN (Persero)" );
        MessageFormat footer = new MessageFormat("Page {0,number,integer}" );
        try{
            datatabel.print(JTable.PrintMode.FIT_WIDTH,header,footer);
        }
        catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s%n",e.getMessage());
        }
}//GEN-LAST:event_btnCetakActionPerformed

    public void TampilJenis(){
    try {
        Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pln","root","root");
        Statement  st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        String     SQL = "SELECT * FROM tbljenis";
        ResultSet  rs = st.executeQuery(SQL);

        while(rs.next()){
            cbojenis.addItem(rs.getString("jenis"));
            cbojenis1.addItem(rs.getString("jenis"));
            cbojenis2.addItem(rs.getString("jenis"));
            cbojenis3.addItem(rs.getString("jenis"));
            cbojenis4.addItem(rs.getString("jenis"));
            cbojenis5.addItem(rs.getString("jenis"));
            cbojenis6.addItem(rs.getString("jenis"));
        }
    }
    catch (SQLException ex) {
    }
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnKeluar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbobagian;
    private javax.swing.JComboBox cbobagian1;
    private javax.swing.JComboBox cbobagian2;
    private javax.swing.JComboBox cbobagian3;
    private javax.swing.JComboBox cbobagian4;
    private javax.swing.JComboBox cbobagian5;
    private javax.swing.JComboBox cbobagian6;
    private javax.swing.JComboBox cbojenis;
    private javax.swing.JComboBox cbojenis1;
    private javax.swing.JComboBox cbojenis2;
    private javax.swing.JComboBox cbojenis3;
    private javax.swing.JComboBox cbojenis4;
    private javax.swing.JComboBox cbojenis5;
    private javax.swing.JComboBox cbojenis6;
    private javax.swing.JComboBox cboketerangan;
    private javax.swing.JComboBox cboketerangan1;
    private javax.swing.JComboBox cboketerangan2;
    private javax.swing.JComboBox cboketerangan3;
    private javax.swing.JComboBox cboketerangan4;
    private javax.swing.JComboBox cboketerangan5;
    private javax.swing.JComboBox cboketerangan6;
    private javax.swing.JComboBox cbokondisi;
    private javax.swing.JComboBox cbokondisi1;
    private javax.swing.JComboBox cbokondisi2;
    private javax.swing.JComboBox cbokondisi3;
    private javax.swing.JComboBox cbokondisi4;
    private javax.swing.JComboBox cbokondisi5;
    private javax.swing.JComboBox cbokondisi6;
    private javax.swing.JComboBox cboruang;
    private javax.swing.JComboBox cboruang1;
    private javax.swing.JComboBox cboruang2;
    private javax.swing.JComboBox cboruang3;
    private javax.swing.JComboBox cboruang4;
    private javax.swing.JComboBox cboruang5;
    private javax.swing.JComboBox cboruang6;
    private javax.swing.JComboBox cboseksi;
    private javax.swing.JComboBox cboseksi1;
    private javax.swing.JComboBox cboseksi2;
    private javax.swing.JComboBox cboseksi3;
    private javax.swing.JComboBox cboseksi4;
    private javax.swing.JComboBox cboseksi5;
    private javax.swing.JComboBox cboseksi6;
    private javax.swing.JCheckBox cekbagian;
    private javax.swing.JCheckBox cekbagian1;
    private javax.swing.JCheckBox cekbagian2;
    private javax.swing.JCheckBox cekbagian3;
    private javax.swing.JCheckBox cekbagian4;
    private javax.swing.JCheckBox cekbagian5;
    private javax.swing.JCheckBox cekbagian6;
    private javax.swing.JCheckBox cekjenis;
    private javax.swing.JCheckBox cekjenis1;
    private javax.swing.JCheckBox cekjenis2;
    private javax.swing.JCheckBox cekjenis3;
    private javax.swing.JCheckBox cekjenis4;
    private javax.swing.JCheckBox cekjenis5;
    private javax.swing.JCheckBox cekjenis6;
    private javax.swing.JCheckBox cekketerangan;
    private javax.swing.JCheckBox cekketerangan1;
    private javax.swing.JCheckBox cekketerangan2;
    private javax.swing.JCheckBox cekketerangan3;
    private javax.swing.JCheckBox cekketerangan4;
    private javax.swing.JCheckBox cekketerangan5;
    private javax.swing.JCheckBox cekketerangan6;
    private javax.swing.JCheckBox cekkondisi;
    private javax.swing.JCheckBox cekkondisi1;
    private javax.swing.JCheckBox cekkondisi2;
    private javax.swing.JCheckBox cekkondisi3;
    private javax.swing.JCheckBox cekkondisi4;
    private javax.swing.JCheckBox cekkondisi5;
    private javax.swing.JCheckBox cekkondisi6;
    private javax.swing.JCheckBox cekruang;
    private javax.swing.JCheckBox cekruang1;
    private javax.swing.JCheckBox cekruang2;
    private javax.swing.JCheckBox cekruang3;
    private javax.swing.JCheckBox cekruang4;
    private javax.swing.JCheckBox cekruang5;
    private javax.swing.JCheckBox cekruang6;
    private javax.swing.JCheckBox cekseksi;
    private javax.swing.JCheckBox cekseksi1;
    private javax.swing.JCheckBox cekseksi2;
    private javax.swing.JCheckBox cekseksi3;
    private javax.swing.JCheckBox cekseksi4;
    private javax.swing.JCheckBox cekseksi5;
    private javax.swing.JCheckBox cekseksi6;
    private javax.swing.JCheckBox cektahun;
    private javax.swing.JCheckBox cektahun1;
    private javax.swing.JCheckBox cektahun2;
    private javax.swing.JCheckBox cektahun3;
    private javax.swing.JCheckBox cektahun4;
    private javax.swing.JCheckBox cektahun5;
    private javax.swing.JCheckBox cektahun6;
    private javax.swing.JTable datatabel;
    private javax.swing.JPanel datatabel3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel1kategori;
    private javax.swing.JPanel panel2kategori;
    private javax.swing.JPanel panel3kategori;
    private javax.swing.JPanel panel4kategori;
    private javax.swing.JPanel panel5kategori;
    private javax.swing.JPanel panel6kategori;
    private javax.swing.JPanel panel7kategori;
    private javax.swing.JPanel panelawal;
    private javax.swing.JPanel panelinduk;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb4;
    private javax.swing.JRadioButton rb5;
    private javax.swing.JRadioButton rb6;
    private javax.swing.JRadioButton rb7;
    private javax.swing.JTextField txttahunakhir;
    private javax.swing.JTextField txttahunakhir1;
    private javax.swing.JTextField txttahunakhir2;
    private javax.swing.JTextField txttahunakhir3;
    private javax.swing.JTextField txttahunakhir4;
    private javax.swing.JTextField txttahunakhir5;
    private javax.swing.JTextField txttahunakhir6;
    private javax.swing.JTextField txttahunawal;
    private javax.swing.JTextField txttahunawal1;
    private javax.swing.JTextField txttahunawal2;
    private javax.swing.JTextField txttahunawal3;
    private javax.swing.JTextField txttahunawal4;
    private javax.swing.JTextField txttahunawal5;
    private javax.swing.JTextField txttahunawal6;
    // End of variables declaration//GEN-END:variables
}
