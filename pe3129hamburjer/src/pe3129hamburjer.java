
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import static java.awt.SystemColor.text;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jia Maris P. Samonte
 */
public class pe3129hamburjer extends javax.swing.JFrame {

    /**
     * Creates new form pe3129hamburjer
     */
    
        JFileChooser chooser;
        ArrayList Stringz = new ArrayList<>();    
        String filenameflop;
        public int flagfile = 0;

        
    public pe3129hamburjer() {
        initComponents();
        setResizable(false);
        JPanel panel1;
        panel1 = new JPanel();
        JTextArea text = new JTextArea();

    }
    
    File[] ff;
    FileReader fff=null;
    JLabel labeller=new JLabel("");
    static int count =1;
    
    //functions
    public void fileopener(){
        
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(true);
        jf.showOpenDialog(null);
            try {
                //        consoleTA.setText("");
//        consoleTA.append("FILE SUCCESSFULLY LOADED!");
            restrict(jf);
            } catch (IOException ex) {
                Logger.getLogger(pe3129hamburjer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(flagfile == 0){
                if(jf.getSelectedFiles() != null ){
            ff=jf.getSelectedFiles();
            for(File item : ff){
            String filename = item.toString();
            String file = filename;
            if(filename.contains("\\")){
                   file = filename.substring(filename.lastIndexOf("\\") + 1);
            }
            else if(filename.contains("/")){
                file = filename.substring(filename.lastIndexOf("/") + 1);
            }
            
            int count = edittab.getTabCount();
            JTextPane editTA =new JTextPane();
            JScrollPane jsp=new JScrollPane(editTA);
            edittab.addTab(file, jsp);
            edittab.setSelectedIndex(count);
            
            setTitle(""+file);
            labeller.setText(filename);
               
            BufferedReader br;
            StringBuilder brr = new StringBuilder();
            try {
                br = new BufferedReader(new FileReader(filename));
                String line;
                while((line = br.readLine())!=null){
                brr.append(line + "\n");
                editTA.setText(brr.toString());
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("File not Found");  
            } catch (IOException ex) {
                editTA.requestFocus();
            }
            }   
        }
                else{
                    consoleTA.append("FILE INVALID!");
                }
            }
            
           }
    public void newfile(){
        editTA.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        editTA.getDocument();
        edittab.addTab("File_" +count, null, new JTextPane());
        editTA.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        editTA.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        int index = edittab.getTabCount() - 1;
        edittab.setSelectedIndex(index); 
        setTitle(" File "+count+" ");
        labeller.setText("File "+count);

        count++;
    }
    public void saveas(){

        if (edittab.getTabCount() > 0)
        {
            FileDialog fd = new FileDialog(new JFrame(), "Save File", FileDialog.SAVE);
            if (fd.getFile()!= null)
            {
                String filename = fd.getDirectory()+ fd.getFile();
                int sel = edittab.getSelectedIndex();
                JTextPane currtextpane = (JTextPane)(((JScrollPane)edittab.getComponentAt(sel)).getViewport()).getComponent(0);
                try
                {
                    DataOutputStream d = new DataOutputStream(new FileOutputStream(filename));
                    String line = currtextpane.getText();
                    d.writeBytes(line);
                    d.close();
                    labeller.setText(filename);

                    String file = filename.substring(filename.lastIndexOf("\\") + 1);
                    edittab.setTitleAt(sel, file);
                    
                    setTitle("" + file);

                }
                catch (Exception ex)
                {
                    System.out.println("File not found");
                }
                currtextpane.requestFocus();

            }
        }
    }     
    public void save(){
        if (edittab.getTabCount()>0){
            String filename= labeller.getText();
            int currtab = edittab.getSelectedIndex();
            System.out.println(currtab);
            JTextPane currtextpane = (JTextPane)(((JScrollPane)edittab.getComponentAt(currtab)).getViewport()).getComponent(0);
            if(filename.contains("\\") || filename.contains("/")){
                File f = new File(filename);
                if (f.exists()){
                    try {
                        
                       DataOutputStream d = new DataOutputStream(new FileOutputStream(filename));
                       String line = currtextpane.getText();
                       d.writeBytes(line);
                       d.close();
                       
                        String tabtext = edittab.getTitleAt(currtab);
                        if(tabtext.contains("*")){
                            tabtext=tabtext.replace("*", "");
                            edittab.setTitleAt(currtab, tabtext);
                        }
                    } catch (FileNotFoundException ex) {
                       System.out.println("File not found!");
                    } catch (IOException ex) {
                        Logger.getLogger(pe3129hamburjer.class.getName()).log(Level.SEVERE, null, ex);
                    }currtextpane.requestFocus();
                }
            }
            else if(filename.contains("File")){
                saveas();
            }
        }
    }
    public void closetab(){
         if (edittab.getTabCount() > 0)
        {
            int selector = edittab.getSelectedIndex();
            String tabtext = edittab.getTitleAt(selector);

            if (tabtext.contains("*"))
            {
                int n = JOptionPane.showConfirmDialog(null, "Do you want to save " + tabtext + " before closing ?",
                        "Save or Not", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                tabtext.replace("*", "");

                if (n == 0)
                {
                    String filename = labeller.getText();
                    JTextPane textPane = (JTextPane) (((JScrollPane) edittab.getComponentAt(selector)).getViewport()).getComponent(0);

                    if (filename.contains("\\")||filename.contains("/"))
                    {
                        save();

                        edittab.remove(selector);
                        //adding all elements to list after removing the tab
                        for (int i = 0; i < edittab.getTabCount(); i++)
                        {
                            String item = edittab.getTitleAt(i);
                            if (item.contains("*"))
                            {
                                item = item.replace("*", "").trim();
                            }

                        }

                        if(edittab.getTabCount()==0)
                        {
                            setTitle("Lexical Analysis");
                            labeller.setText("");
                        }

                    }

                    else if (filename.contains("File "))
                    {
                        saveas();

                        edittab.remove(selector);

                        //adding all elements to list after removing the tab
                        for (int i = 0; i < edittab.getTabCount(); i++)
                        {
                            String item = edittab.getTitleAt(i);
                            if (item.contains("*"))
                            {
                                item = item.replace("*", "").trim();
                            }
                        }

                        if (edittab.getTabCount() == 0)
                        {
                            setTitle("Lexical Analysis");
                            labeller.setText("");
                        }
                    }

                }

                if (n == 1)
                {
                    edittab.remove(selector);

                    for (int i = 0; i < edittab.getTabCount(); i++)
                    {
                        String item = edittab.getTitleAt(i);
                        if (item.contains("*"))
                        {
                            item = item.replace("*", "").trim();
                        }
                    }
                    if (edittab.getTabCount() == 0)
                    {
                        setTitle("Lexical Analysis");
                        labeller.setText("");
                    }
                }
            }

            else
            {
                edittab.remove(selector);

                //adding all elements to list after removing the tab
                for (int i = 0; i < edittab.getTabCount(); i++)
                {
                    String item = edittab.getTitleAt(i);
                    if (item.contains("*"))
                    {
                        item = item.replace("*", "").trim();
                    }
                }
                if (edittab.getTabCount() == 0)
                {
                    setTitle("Lexical Analysis");
                    labeller.setText("");
                }

            }
        }

        else
        {
            setTitle("Lexical Analysis");
            labeller.setText("");
        }
    }
    public void restrict(JFileChooser chooser) throws FileNotFoundException, IOException{  
        String file = chooser.getSelectedFile().getName();
        
        System.out.println("File name: " +file);
        System.out.println("File ext: " +getFileExtension(file));
      
        if ("flop".equals(getFileExtension(file))) { 
            consoleTA.setText("");
            consoleTA.append("FILE SUCCESSFULLY OPENED!");
            flagfile = 0;
        }
        else{
            consoleTA.setText("");
            consoleTA.append("INVALID FILE!");
            flagfile = 1;
        }
    }
    public String getFileExtension(String file) {
        if (file.lastIndexOf(".") != -1 && file.lastIndexOf(".") != 0) {
            return file.substring(file.lastIndexOf(".")+1);
        }
        else {
            return "";
        }
    }
    public void tableadder() {
        cleartable();
        DefaultTableModel model1 = (DefaultTableModel) vartable.getModel();
        DefaultTableModel model2  = (DefaultTableModel) lextable.getModel();
        Object rowData[] = new Object [4];

        for (int x=0; x < tokenTYPE.size(); x++) {
            rowData[0] = tokenTYPE.get(x);
            rowData[1] = words.get(x);
            model2.addRow(rowData);
        }
        //SAVE FOR VARIABLE
//        for (){
//            
//            model1.addRow(rowData);
//        }
    }
    public void cleartable() {
            // Clears table contents
        DefaultTableModel model1 = (DefaultTableModel) vartable.getModel();
        model1.setRowCount(0);
        
        DefaultTableModel model2 = (DefaultTableModel) lextable.getModel();
        model2.setRowCount(0);
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
        consoleSP = new javax.swing.JScrollPane();
        consoleTA = new javax.swing.JTextArea();
        editpanel = new javax.swing.JPanel();
        edittab = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        editTA = new javax.swing.JTextArea();
        tablepanel = new javax.swing.JPanel();
        lextoktab = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        vartable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        lextable = new javax.swing.JTable();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        SaveAs = new javax.swing.JMenuItem();
        Closetab = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Compile = new javax.swing.JMenuItem();
        Execute = new javax.swing.JMenuItem();
        Token = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1123, 703));
        setMinimumSize(new java.awt.Dimension(1123, 703));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        consoleTA.setColumns(20);
        consoleTA.setRows(5);
        consoleSP.setViewportView(consoleTA);

        editpanel.setMaximumSize(new java.awt.Dimension(520, 498));
        editpanel.setMinimumSize(new java.awt.Dimension(520, 498));
        editpanel.setPreferredSize(new java.awt.Dimension(520, 498));

        edittab.setBackground(new java.awt.Color(255, 51, 51));
        edittab.setMaximumSize(new java.awt.Dimension(520, 498));
        edittab.setMinimumSize(new java.awt.Dimension(520, 498));
        edittab.setPreferredSize(new java.awt.Dimension(520, 498));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(520, 498));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(520, 498));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(520, 498));

        editTA.setColumns(20);
        editTA.setRows(5);
        editTA.setMaximumSize(new java.awt.Dimension(520, 498));
        editTA.setMinimumSize(new java.awt.Dimension(520, 498));
        editTA.setPreferredSize(new java.awt.Dimension(520, 498));
        jScrollPane1.setViewportView(editTA);

        edittab.addTab("New File", jScrollPane1);

        javax.swing.GroupLayout editpanelLayout = new javax.swing.GroupLayout(editpanel);
        editpanel.setLayout(editpanelLayout);
        editpanelLayout.setHorizontalGroup(
            editpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(edittab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        editpanelLayout.setVerticalGroup(
            editpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(edittab, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        tablepanel.setMaximumSize(new java.awt.Dimension(528, 498));
        tablepanel.setMinimumSize(new java.awt.Dimension(528, 498));

        vartable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Variable", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(vartable);
        if (vartable.getColumnModel().getColumnCount() > 0) {
            vartable.getColumnModel().getColumn(0).setResizable(false);
            vartable.getColumnModel().getColumn(1).setResizable(false);
        }

        lextoktab.addTab("Variables", jScrollPane2);

        lextable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexeme", "Token"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(lextable);
        if (lextable.getColumnModel().getColumnCount() > 0) {
            lextable.getColumnModel().getColumn(0).setResizable(false);
            lextable.getColumnModel().getColumn(1).setResizable(false);
        }

        lextoktab.addTab("Lexeme Token", jScrollPane3);

        javax.swing.GroupLayout tablepanelLayout = new javax.swing.GroupLayout(tablepanel);
        tablepanel.setLayout(tablepanelLayout);
        tablepanelLayout.setHorizontalGroup(
            tablepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lextoktab, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        tablepanelLayout.setVerticalGroup(
            tablepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lextoktab)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consoleSP)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(editpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 516, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tablepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                    .addComponent(tablepanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consoleSP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar2.setBackground(new java.awt.Color(204, 255, 153));

        jMenu2.setBackground(new java.awt.Color(204, 255, 102));
        jMenu2.setText("File");

        New.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        jMenu2.add(New);

        Open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jMenu2.add(Open);

        Save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jMenu2.add(Save);

        SaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        SaveAs.setText("Save As");
        SaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAsActionPerformed(evt);
            }
        });
        jMenu2.add(SaveAs);

        Closetab.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Closetab.setText("Close Current Tab");
        Closetab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClosetabActionPerformed(evt);
            }
        });
        jMenu2.add(Closetab);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu2.add(Exit);

        jMenuBar2.add(jMenu2);

        jMenu3.setText("Run");

        Compile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        Compile.setText("Compile");
        jMenu3.add(Compile);

        Execute.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        Execute.setText("Execute");
        jMenu3.add(Execute);

        Token.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        Token.setText("Token");
        jMenu3.add(Token);

        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        // TODO add your handling code here:
        newfile();
    }//GEN-LAST:event_NewActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed

                // TODO add your handling code here:
        fileopener();
    }//GEN-LAST:event_OpenActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_SaveActionPerformed

    private void SaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveAsActionPerformed
        // TODO add your handling code here:
        saveas();
    }//GEN-LAST:event_SaveAsActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void ClosetabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClosetabActionPerformed
        // TODO add your handling code here:
        closetab();
    }//GEN-LAST:event_ClosetabActionPerformed

    
    /**
     * @param editorscrollpane
     * @return 
     */
    
//    protected JTabbedPane createTab(JScrollPane editorscrollpane) {
//        editortab = new JTabbedPane(JTabbedPane.TOP);
//        editortab.addTab(newTabName, editorscrollpane);
//
//        return editortab;
//    }
//    
//        private JScrollPane createTextArea() {
//        // Set text area and default font
//        editorTA = new JTextArea("", 0, 0);
//        editorTA.setEditable(true);
//        editorTA.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));
//        editorTA.setFont(new Font("Verdana", Font.PLAIN, 14));
//        editorscrollpane = new JScrollPane(editorTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//
//        return editorscrollpane;
//    }

    
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
            java.util.logging.Logger.getLogger(pe3129hamburjer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pe3129hamburjer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pe3129hamburjer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pe3129hamburjer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pe3129hamburjer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Closetab;
    private javax.swing.JMenuItem Compile;
    private javax.swing.JMenuItem Execute;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem SaveAs;
    private javax.swing.JMenuItem Token;
    private javax.swing.JScrollPane consoleSP;
    private javax.swing.JTextArea consoleTA;
    private javax.swing.JTextArea editTA;
    private javax.swing.JPanel editpanel;
    private javax.swing.JTabbedPane edittab;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable lextable;
    private javax.swing.JTabbedPane lextoktab;
    private javax.swing.JPanel tablepanel;
    private javax.swing.JTable vartable;
    // End of variables declaration//GEN-END:variables
}
