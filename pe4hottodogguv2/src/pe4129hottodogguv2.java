
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jia Maris P. Samonte
 */
public class pe4129hottodogguv2 extends javax.swing.JFrame {


    /**
     * Creates new form pe4129hottodogguv2
     */
    
        File now;
        JFileChooser chooser;
        ArrayList <String> Prod = new ArrayList<>();
        String filenameflop;
        public int flagfile = 0;

    public pe4129hottodogguv2() {
        initComponents();
        setTitle("HATDOG");
    }
    File[] ff;   
    FileReader fff=null;
    JLabel labeller=new JLabel("");
    static int count =1;
    
       public void cleartable1() {
            // Clears table contents
        DefaultTableModel model1 = (DefaultTableModel) prodtable.getModel();
        model1.setRowCount(0);
                            loaderTA.setText("");
                            prodTA.setText("");
    } 
       
      public void cleartable2(){         
        DefaultTableModel model2 = (DefaultTableModel) parsetable.getModel();
        model2.setRowCount(0);
                            loaderTA.setText("");
                            parseTA.setText("");
      }
public void loader() throws FileNotFoundException{
        JFileChooser chooseFile = new JFileChooser();
        String namer = new String ();
//        chooseFile.getUI();
//        chooseFile.getSelectedFile();
        chooseFile.getCurrentDirectory();
//        chooseFile.
//        File mewmew = new File (chooseFile.getSelectedFile());



        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
//        chooser.showOpenDialog(this);
        int retval = chooser.showOpenDialog(this);
        switch (retval) {
            case JFileChooser.CANCEL_OPTION:
                break;
            case JFileChooser.APPROVE_OPTION:

             if (chooser.getSelectedFile().toString().endsWith(".prod"))
        {
            cleartable1();

            Scanner reader = new Scanner(chooser.getSelectedFile());
            DefaultTableModel prodmodel = (DefaultTableModel) prodtable.getModel();
            Object rowData[] = new Object [3];
            int x = 0;
            String temp[] = new String [3];
            
            while (reader.hasNextLine()){
                temp = reader.nextLine().split(",");
                rowData[0] = temp[0];
                rowData[1] = temp[1];
                rowData[2] = temp[2];
                prodmodel.addRow(rowData);
                temp = new String [3];
            }
            String filename = chooser.toString();
            String file = filename;
            if (filename.contains("\\")){
                file = filename.substring(filename.lastIndexOf("\\") + 1).replaceAll(",useFileHiding=false]", "");
                
            }
            else if (filename.contains("/")){
                file = filename.substring(filename.lastIndexOf("/") + 1).replaceAll(",useFileHiding=false]", "");;
            }
            prodTA.append(file);
            loaderTA.append(file);
        }
        
        else if (chooser.getSelectedFile().toString().endsWith(".ptbl")){
            cleartable2();
                    loaderTA.setText("");
            Scanner scan = new Scanner(chooser.getSelectedFile());
//            String[] count = scan.nextLine().split(",");

            DefaultTableModel parsemodel = (DefaultTableModel) parsetable.getModel();
            Object rowData[] = new Object [7];
            int x = 0;
            String temp[] = new String [7];
            String title;
            String label[] = new String [7];
            title = scan.nextLine().trim();
            label = title.split(",");
            
            parsemodel.setColumnIdentifiers(label);
            
            
            while (scan.hasNextLine()){
                rowData = scan.nextLine().split(",");
                parsemodel.addRow(rowData);
                temp = new String [7];
            }
            String filename = chooser.toString();
            String file = filename;
            if (filename.contains("\\")){
                file = filename.substring(filename.lastIndexOf("\\") + 1).replaceAll(",useFileHiding=false]", "");;
                
            }
            else if (filename.contains("/")){
                file = filename.substring(filename.lastIndexOf("/") + 1).replaceAll(",useFileHiding=false]", "");;
            }
            parseTA.append(file);
            loaderTA.append(file);   
        }
             
             
        
      
        
            
            
        }

        
        

//        try {
//                FileReader reader = new FileReader(chooser.getSelectedFile());
//                BufferedReader br = new BufferedReader(reader);
//                String str;
//                    while ((str = br.readLine()) != null) {
//                        loadTA.append(str + "\n");
//                        Stringz.add(str);
//                        }       
//                    processbtn.setEnabled(true);
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(calcuGUI.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(calcuGUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
}   
    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        prodpanel = new javax.swing.JPanel();
        prodlabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        prodtable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        prodTA = new javax.swing.JTextArea();
        parsepanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        parsetable = new javax.swing.JTable();
        parselabel = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        parseTA = new javax.swing.JTextArea();
        loadpanel = new javax.swing.JPanel();
        loadlabel = new javax.swing.JLabel();
        loadbtn = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        loaderTA = new javax.swing.JTextArea();
        inputpanel = new javax.swing.JPanel();
        inputlabel = new javax.swing.JLabel();
        inputTF = new java.awt.TextField();
        parsebtn = new javax.swing.JButton();
        parsingpanel = new javax.swing.JPanel();
        loadlabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        parsingtable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        parsingTA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainpanel.setBackground(new java.awt.Color(255, 204, 204));

        prodpanel.setBackground(new java.awt.Color(255, 153, 153));

        prodlabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        prodlabel.setText("Productions:");

        prodtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NT", "P"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(prodtable);

        prodTA.setEditable(false);
        prodTA.setColumns(20);
        prodTA.setRows(1);
        jScrollPane4.setViewportView(prodTA);

        javax.swing.GroupLayout prodpanelLayout = new javax.swing.GroupLayout(prodpanel);
        prodpanel.setLayout(prodpanelLayout);
        prodpanelLayout.setHorizontalGroup(
            prodpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prodpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(prodpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(prodpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(prodpanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(prodlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(226, Short.MAX_VALUE)))
        );
        prodpanelLayout.setVerticalGroup(
            prodpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, prodpanelLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(prodpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(prodpanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(prodlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(503, Short.MAX_VALUE)))
        );

        parsepanel.setBackground(new java.awt.Color(204, 204, 255));

        parsetable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane2.setViewportView(parsetable);

        parselabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        parselabel.setText("Parse Table:");

        parseTA.setEditable(false);
        parseTA.setColumns(20);
        parseTA.setRows(1);
        jScrollPane6.setViewportView(parseTA);

        javax.swing.GroupLayout parsepanelLayout = new javax.swing.GroupLayout(parsepanel);
        parsepanel.setLayout(parsepanelLayout);
        parsepanelLayout.setHorizontalGroup(
            parsepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parsepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(parsepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parsepanelLayout.createSequentialGroup()
                        .addComponent(parselabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
                .addContainerGap())
        );
        parsepanelLayout.setVerticalGroup(
            parsepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parsepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parselabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        loadpanel.setBackground(new java.awt.Color(204, 255, 204));

        loadlabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        loadlabel.setText("LOADED:");

        loadbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        loadbtn.setText("Load");
        loadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadbtnActionPerformed(evt);
            }
        });

        loaderTA.setEditable(false);
        loaderTA.setColumns(20);
        loaderTA.setRows(1);
        jScrollPane7.setViewportView(loaderTA);

        javax.swing.GroupLayout loadpanelLayout = new javax.swing.GroupLayout(loadpanel);
        loadpanel.setLayout(loadpanelLayout);
        loadpanelLayout.setHorizontalGroup(
            loadpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loadlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7)
                .addGap(39, 39, 39)
                .addComponent(loadbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        loadpanelLayout.setVerticalGroup(
            loadpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadpanelLayout.createSequentialGroup()
                .addGroup(loadpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadpanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(loadpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadlabel)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(loadpanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(loadbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        inputpanel.setBackground(new java.awt.Color(255, 255, 153));

        inputlabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        inputlabel.setText("INPUT: ");

        inputTF.setBackground(new java.awt.Color(255, 255, 153));
        inputTF.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        inputTF.setText(" ");
        inputTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTFActionPerformed(evt);
            }
        });

        parsebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        parsebtn.setText("Parse");
        parsebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parsebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputpanelLayout = new javax.swing.GroupLayout(inputpanel);
        inputpanel.setLayout(inputpanelLayout);
        inputpanelLayout.setHorizontalGroup(
            inputpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputTF, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(parsebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        inputpanelLayout.setVerticalGroup(
            inputpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parsebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputTF, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(inputlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        parsingpanel.setBackground(new java.awt.Color(204, 255, 255));

        loadlabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        loadlabel1.setText("PARSING:");

        parsingtable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        parsingtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stack", "Input Buffer", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(parsingtable);

        parsingTA.setEditable(false);
        parsingTA.setColumns(20);
        parsingTA.setRows(1);
        jScrollPane5.setViewportView(parsingTA);

        javax.swing.GroupLayout parsingpanelLayout = new javax.swing.GroupLayout(parsingpanel);
        parsingpanel.setLayout(parsingpanelLayout);
        parsingpanelLayout.setHorizontalGroup(
            parsingpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parsingpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(parsingpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parsingpanelLayout.createSequentialGroup()
                        .addComponent(loadlabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)))
        );
        parsingpanelLayout.setVerticalGroup(
            parsingpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parsingpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(parsingpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadlabel1)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addComponent(prodpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parsepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(inputpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(parsingpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prodpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(parsepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parsingpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTFActionPerformed

    private void parsebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parsebtnActionPerformed
        // TODO add your handling code here:
        parsingTA.append("parsing");
        
    }//GEN-LAST:event_parsebtnActionPerformed

    private void loadbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadbtnActionPerformed

        try {
                    // TODO add your handling code here:
                    loader();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(pe4129hottodogguv2.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_loadbtnActionPerformed

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
            java.util.logging.Logger.getLogger(pe4129hottodogguv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pe4129hottodogguv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pe4129hottodogguv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pe4129hottodogguv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pe4129hottodogguv2().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField inputTF;
    private javax.swing.JLabel inputlabel;
    private javax.swing.JPanel inputpanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JButton loadbtn;
    private javax.swing.JTextArea loaderTA;
    private javax.swing.JLabel loadlabel;
    private javax.swing.JLabel loadlabel1;
    private javax.swing.JPanel loadpanel;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextArea parseTA;
    private javax.swing.JButton parsebtn;
    private javax.swing.JLabel parselabel;
    private javax.swing.JPanel parsepanel;
    private javax.swing.JTable parsetable;
    private javax.swing.JTextArea parsingTA;
    private javax.swing.JPanel parsingpanel;
    private javax.swing.JTable parsingtable;
    private javax.swing.JTextArea prodTA;
    private javax.swing.JLabel prodlabel;
    private javax.swing.JPanel prodpanel;
    private javax.swing.JTable prodtable;
    // End of variables declaration//GEN-END:variables

    private void restrict(JFileChooser jf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
