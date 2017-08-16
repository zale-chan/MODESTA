/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Card.Card;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import org.rosuda.REngine.Rserve.RConnection;

/**
 *
 * @author Elise
 */
public class Without extends javax.swing.JFrame {
    String pieName, barname;
    /**
     * Creates new form Without
     */
    public Without() {
        initComponents();
        initTri(tDone);
        initDraw(cDrawn);
        this.setLocationRelativeTo(null);
        this.setTitle("Card Drawing Simulation");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bnom = new javax.swing.JButton();
        cDrawn = new javax.swing.JComboBox<>();
        tDone = new javax.swing.JComboBox<>();
        dTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        back1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        bnom1 = new javax.swing.JButton();
        ideal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Normal Deck has 52 cards and 4 suits. Each suit has 13 cards.");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("WITHOUT REPLACEMENT");

        jLabel2.setText("# of Cards to be Drawn");

        bnom.setText("OK");
        bnom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bnomMouseClicked(evt);
            }
        });

        jLabel3.setText("# of Trias to be Done");

        jLabel4.setText("Desired Total");

        back1.setText("Back");
        back1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back1MouseClicked(evt);
            }
        });

        area.setColumns(20);
        area.setRows(5);
        jScrollPane1.setViewportView(area);

        bnom1.setText("Graph");
        bnom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bnom1MouseClicked(evt);
            }
        });

        jLabel8.setText("Ideal Probability");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(back1)
                        .addGap(206, 206, 206)
                        .addComponent(bnom))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(167, 167, 167))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(bnom1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tDone, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dTotal))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cDrawn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(ideal, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cDrawn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ideal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnom)
                    .addComponent(back1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bnom1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bnomMouseClicked
        // TODO add your handling code here:
        String[] names = new String[] {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = new String[] {"H","C","S","D"};
        int Cchoice, Tchoice, Dchoice, suit, name, index, countW = 0, appearW = 0;
        float percent = 0;
        int[] tR, tW;
        float idealprob = 0;
        
        ArrayList<Card> handW = new ArrayList<Card>();
        ArrayList<Card> listR = new ArrayList<Card>();
        ArrayList<Card> listW = new ArrayList<Card>();
        Random gen = new Random();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy-hhmmss.SSS");
        String date = simpleDateFormat.format( new Date() );
        String fileName = "files/WithoutFile-" + date  + ".txt";
        String picName, barName;
        if (dTotal.getText().isEmpty() || ideal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please don't leave a field blank.", "Warning", JOptionPane.WARNING_MESSAGE, null);
        } else {
            if(cDrawn.getSelectedItem()!= null && tDone.getSelectedItem()!= null){
                
                Tchoice = Integer.parseInt(tDone.getSelectedItem().toString());
                Cchoice = Integer.parseInt(cDrawn.getSelectedItem().toString());
                Dchoice = Integer.parseInt(dTotal.getText());
                idealprob = Float.parseFloat(ideal.getText());
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    // NOTE: Rserve() must be entered in RStudio after library(Rserve) is used else no connection will happen.
                    RConnection c = new RConnection();
                    tW = tR = new int[Tchoice];
                    for (int i = 0; i <= 3; i++) {
                        for (int k = 0; k <= 12; k++) {
                            listW.add(new Card(k, i));
                        }
                    }
                    for (int j = 0; j < Tchoice; j++) {
                        //without rep
                        area.append("Trial " + j + "\n");
                        writer.write("Trial " + j);
                        writer.write(System.getProperty( "line.separator" ));
                        for (int i = 0; i < Cchoice; i++) {
                            index = gen.nextInt(listW.size());
                            suit = listW.get(index).getSuit();
                            name = listW.get(index).getName();

                            countW = countW + (name + 1);

                            handW.add(listW.remove(index));
                            area.append(suits[suit] + names[name] + "\n");
                            writer.write(suits[suit] + names[name]);
                            writer.write(System.getProperty( "line.separator" ));
                        }
                        tW[j] = countW;
                        area.append("Total Non-Rep: " + countW + "\n\n");
                        writer.write("Total Non-Rep: " + countW);
                        writer.write(System.getProperty( "line.separator" ));
                        countW = 0;
                        listW.clear();
                        for (int i = 0; i <= 3; i++) {
                            for (int k = 0; k <= 12; k++) {
                                listW.add(new Card(k, i));
                                listR.add(new Card(k, i));
                            }
                        }
                    }


                    for (int i = 0; i < Tchoice; i++) {
                        if (tR[i] == Dchoice)
                            appearW++;
                    }
                    area.append("Number of times the desired value appeared: " + appearW + "\n");
                    percent = (float) appearW / (float) Tchoice;
                    area.append("Probability the desired value appeared: " + percent + "\n");
                    int failure = Tchoice-appearW;
                    
                    picName = "C:/Users/Elise/Downloads/image/WithoutPie-" + date + ".png";
                    pieName = picName;
                    barName = "C:/Users/Elise/Downloads/image/WithoutBar-" + date + ".png";
                    barname = barName;
                    c.eval("slices = c("+ appearW + "," + failure + ")");
                    c.eval("lbls = c(\"Successes\", \"Failures\")");
                    c.eval("pct = round(slices/sum(slices)*100)");
                    c.eval("lbls = paste(lbls, pct)");
                    c.eval("lbls = paste(lbls, \"%\", sep=\"\")");
                    c.eval("png(filename='" + picName + "')");
                    c.eval("pie(slices, labels = lbls, main=\"Pie Chart of Success and Faillures\")");
                    c.eval("dev.off()");
                    c.eval("counts = c(" + percent + "," + idealprob +")");
                    c.eval("png(filename='" + barName + "')");
                    c.eval("barplot(counts, main = \"Actual vs. Ideal Probabilities\", names.arg = c(\"Actual\", \"Ideal\"), col = c(\"darkblue\",\"lightblue\"), las = 1)");
                    c.eval("dev.off()");
                    c.close();
                } catch (Exception e) {
                    System.out.println("ERROR: In Connection to R ");
                    System.out.println("The Exception is " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_bnomMouseClicked

    private void back1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back1MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new GUI().setVisible(true);
    }//GEN-LAST:event_back1MouseClicked

    private void bnom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bnom1MouseClicked
        // TODO add your handling code here:
        if (pieName != null || barname != null)
            new Graph(pieName, barname).setVisible(true);
        else
            JOptionPane.showMessageDialog(this, "No existing graphs!", "Warning", JOptionPane.WARNING_MESSAGE, null);
    }//GEN-LAST:event_bnom1MouseClicked

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
            java.util.logging.Logger.getLogger(Without.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Without.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Without.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Without.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Without().setVisible(true);
            }
        });
    }
    
    public void initTri(javax.swing.JComboBox m) {
        String [] num = new String[10000];
        int i=0, j=0;

        while (i < 10000) {

            j += 10;
            num[i] = Integer.toString((j));
            i++;
        }

        m.setModel(new javax.swing.DefaultComboBoxModel(num));
    }
    
    public void initDraw(javax.swing.JComboBox m) {
        String [] num = new String[5];
        int i=0, j=0;

        while (i < 5) {

            j++;
            num[i] = Integer.toString((j));
            i++;
        }

        m.setModel(new javax.swing.DefaultComboBoxModel(num));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JButton back1;
    private javax.swing.JButton bnom;
    private javax.swing.JButton bnom1;
    private javax.swing.JComboBox<String> cDrawn;
    private javax.swing.JTextField dTotal;
    private javax.swing.JTextField ideal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> tDone;
    // End of variables declaration//GEN-END:variables
}
