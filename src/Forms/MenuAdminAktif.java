/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuUtama.java
 *
 * Created on 03 Des 11, 13:03:37
 */
package Forms;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author NoName
 */
public class MenuAdminAktif extends javax.swing.JFrame {
    /** Creates new form MenuUtama */

    public MenuAdminAktif() {
        initComponents();

        //tampilan tengah
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frameSize = getSize();
	setLocation(
	(screenSize.width - frameSize.width) / 2,
	(screenSize.height - frameSize.height) / 2);
    }

     private Image oldIcon;

    protected static ImageIcon createImageIcon(String path) {

       // Ganti IconFrame dengan nama kelas jFrame Anda
        java.net.URL imgURL = MenuAdminAktif.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        MenuBeranda = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        MenuFile = new javax.swing.JMenu();
        MenuLaporan = new javax.swing.JMenu();
        MenuKeseluruhan = new javax.swing.JMenuItem();
        MenuPeriode = new javax.swing.JMenuItem();
        MenuInformasi = new javax.swing.JMenu();
        MenuPengunjung = new javax.swing.JMenu();
        MenuExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Beranda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));

        MenuBeranda.setBackground(new java.awt.Color(255, 255, 255));
        MenuBeranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tampilan/Home.png"))); // NOI18N
        MenuBeranda.setText("Beranda   ");
        MenuBeranda.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        MenuBeranda.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
                MenuBerandaMenuDeselected(evt);
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
            }
        });
        MenuBeranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBerandaActionPerformed(evt);
            }
        });

        jMenuItem1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jMenuItem1.setForeground(new java.awt.Color(204, 204, 204));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/merah.png"))); // NOI18N
        jMenuItem1.setText("Log In");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        MenuBeranda.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/hijau.png"))); // NOI18N
        jMenuItem2.setText("Log Out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MenuBeranda.add(jMenuItem2);

        menuBar.add(MenuBeranda);

        MenuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Add-32.png"))); // NOI18N
        MenuFile.setText("File    ");
        MenuFile.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        MenuFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuFileMouseClicked(evt);
            }
        });
        MenuFile.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                MenuFileComponentHidden(evt);
            }
        });
        MenuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFileActionPerformed(evt);
            }
        });
        menuBar.add(MenuFile);

        MenuLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Edit-32.png"))); // NOI18N
        MenuLaporan.setText(" Laporan   ");
        MenuLaporan.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        MenuLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuLaporanMouseClicked(evt);
            }
        });
        MenuLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLaporanActionPerformed(evt);
            }
        });

        MenuKeseluruhan.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        MenuKeseluruhan.setText("Keseluruhan");
        MenuKeseluruhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuKeseluruhanMouseClicked(evt);
            }
        });
        MenuKeseluruhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuKeseluruhanActionPerformed(evt);
            }
        });
        MenuLaporan.add(MenuKeseluruhan);

        MenuPeriode.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        MenuPeriode.setText("Periode Tertentu");
        MenuPeriode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPeriodeMouseClicked(evt);
            }
        });
        MenuPeriode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPeriodeActionPerformed(evt);
            }
        });
        MenuLaporan.add(MenuPeriode);

        menuBar.add(MenuLaporan);

        MenuInformasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/search.png"))); // NOI18N
        MenuInformasi.setText("Informasi   ");
        MenuInformasi.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        MenuInformasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuInformasiMouseClicked(evt);
            }
        });
        MenuInformasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuInformasiActionPerformed(evt);
            }
        });
        menuBar.add(MenuInformasi);

        MenuPengunjung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/3d bar chart.png"))); // NOI18N
        MenuPengunjung.setText("Riwayat Pengguna   ");
        MenuPengunjung.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        MenuPengunjung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPengunjungMouseClicked(evt);
            }
        });
        menuBar.add(MenuPengunjung);

        MenuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Exit.png"))); // NOI18N
        MenuExit.setText("Keluar   ");
        MenuExit.setFont(new java.awt.Font("Segoe UI Light", 0, 14));
        MenuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuExitMouseClicked(evt);
            }
        });
        MenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuExitActionPerformed(evt);
            }
        });
        menuBar.add(MenuExit);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1313, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1329)/2, (screenSize.height-700)/2, 1329, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void button11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button11ActionPerformed
       
    }//GEN-LAST:event_button11ActionPerformed

    private void button12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button12ActionPerformed

    private void button13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button13ActionPerformed

    private void button14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button14ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_button14ActionPerformed

    private void button15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button15ActionPerformed

    private void MenuBerandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBerandaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_MenuBerandaActionPerformed

    private void MenuFileComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_MenuFileComponentHidden
        // TODO add your handling code here:
}//GEN-LAST:event_MenuFileComponentHidden

    private void MenuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFileActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_MenuFileActionPerformed

    private void MenuInformasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuInformasiActionPerformed

}//GEN-LAST:event_MenuInformasiActionPerformed

    private void MenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuExitActionPerformed
        new MenuUtama().setVisible(true);
        this.dispose();
}//GEN-LAST:event_MenuExitActionPerformed

    private void MenuExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuExitMouseClicked
        System.exit(0);
}//GEN-LAST:event_MenuExitMouseClicked

    private void MenuBerandaMenuDeselected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_MenuBerandaMenuDeselected
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuBerandaMenuDeselected

    private void MenuFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuFileMouseClicked
        FrmFile s=new FrmFile();
        jDesktopPane1.add(s);
        s.setVisible(true);
    }//GEN-LAST:event_MenuFileMouseClicked

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new MenuUtama().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void MenuInformasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuInformasiMouseClicked
        FrmPencarian1 s=new FrmPencarian1 ();
        jDesktopPane1.add(s);
        s.setVisible(true);
    }//GEN-LAST:event_MenuInformasiMouseClicked

    private void MenuLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuLaporanMouseClicked

    }//GEN-LAST:event_MenuLaporanMouseClicked

    private void MenuLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLaporanActionPerformed

    }//GEN-LAST:event_MenuLaporanActionPerformed

    private void MenuPengunjungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPengunjungMouseClicked
        FrmPengunjung s=new FrmPengunjung();
        jDesktopPane1.add(s);
        s.setVisible(true);
    }//GEN-LAST:event_MenuPengunjungMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //mengganti icon
        oldIcon = getIconImage();
        ImageIcon newIcon = createImageIcon("icon_admin.png");
        setIconImage(newIcon.getImage());
    }//GEN-LAST:event_formWindowActivated

    private void MenuKeseluruhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuKeseluruhanMouseClicked
       FrmLaporan flg=new FrmLaporan ("");
        jDesktopPane1.add(flg);
    }//GEN-LAST:event_MenuKeseluruhanMouseClicked

    private void MenuPeriodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPeriodeMouseClicked
        String tahun = JOptionPane.showInputDialog("Tahun : ");
        FrmLaporan flg=new FrmLaporan(tahun);
        jDesktopPane1.add(flg);
    }//GEN-LAST:event_MenuPeriodeMouseClicked

    private void MenuKeseluruhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuKeseluruhanActionPerformed
        FrmLaporan flg=new FrmLaporan ("");
        jDesktopPane1.add(flg);
    }//GEN-LAST:event_MenuKeseluruhanActionPerformed

    private void MenuPeriodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPeriodeActionPerformed
        String tahun = JOptionPane.showInputDialog("Tahun : ");
        FrmLaporan flg=new FrmLaporan(tahun);
        jDesktopPane1.add(flg);
    }//GEN-LAST:event_MenuPeriodeActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdminAktif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdminAktif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdminAktif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdminAktif.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuAdminAktif().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuBeranda;
    private javax.swing.JMenu MenuExit;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenu MenuInformasi;
    private javax.swing.JMenuItem MenuKeseluruhan;
    private javax.swing.JMenu MenuLaporan;
    private javax.swing.JMenu MenuPengunjung;
    private javax.swing.JMenuItem MenuPeriode;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
}
