
package com.mycompany.ulearnfinaljava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class Program extends javax.swing.JFrame {

    /**
     * Creates new form Program
     */
    public Program() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextDisplay = new javax.swing.JLabel();
        GraphButton = new javax.swing.JButton();
        EUButton = new javax.swing.JButton();
        JPButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FinalUlearnTask");

        GraphButton.setText("Build Graph");
        GraphButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GraphButtonMouseClicked(evt);
            }
        });

        EUButton.setText("Show game in EU");
        EUButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EUButtonMouseClicked(evt);
            }
        });

        JPButton.setText("Show game in JP");
        JPButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPButtonMouseClicked(evt);
            }
        });

        ExitButton.setText("Exit");
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonMouseClicked(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JPButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EUButton, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(GraphButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1420, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 1290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(TextDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(GraphButton)
                        .addGap(50, 50, 50)
                        .addComponent(EUButton)
                        .addGap(50, 50, 50)
                        .addComponent(JPButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                        .addComponent(ExitButton)))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitButtonMouseClicked

    private void JPButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPButtonMouseClicked
        // TODO add your handling code here:
        Request rq = new Request();
        TextDisplay.setText("Most sold game in a time period from 2000 to 2006 in genre \"Sports\" in Japan: "+rq.ShowName(3));
    }//GEN-LAST:event_JPButtonMouseClicked

    private void EUButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EUButtonMouseClicked
        // TODO add your handling code here:
        Request rq = new Request();
        TextDisplay.setText("Most sold game in Europe in 2000: "+rq.ShowName(2));
    }//GEN-LAST:event_EUButtonMouseClicked

    private void GraphButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GraphButtonMouseClicked
        // TODO add your handling code here:
        Request rq = new Request();
        TextDisplay.setText("Graph displaying data on global sales in different platforms: ");
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        List<Integer> Values =rq.Graph();
        List<String> Platf = null;
        Path path = Paths.get("NetBeansProjects/UlearnFinalJava/src/main/resources/Platfroms.txt");
        try
        {
            Platf= Files.readAllLines(path, StandardCharsets.UTF_8);
        }
        catch(FileNotFoundException ex)
        {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i < Platf.size(); i++)
        {
            ds.setValue(Values.get(i), "", Platf.get(i));
        }
       
        
        JFreeChart chart = ChartFactory.createBarChart("","","",ds,PlotOrientation.VERTICAL,false, false, false);
        CategoryPlot catPlot = chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.BLACK);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        jPanel1.removeAll();
        jPanel1.add(chartPanel,BorderLayout.CENTER);
        jPanel1.validate();
    }//GEN-LAST:event_GraphButtonMouseClicked

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
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Program().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EUButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton GraphButton;
    private javax.swing.JButton JPButton;
    private javax.swing.JLabel TextDisplay;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}