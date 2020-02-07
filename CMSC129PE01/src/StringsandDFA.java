/*
CMSC 129 PROGRAMMING EXERCISE 02 STRINGS AND DFA

CABANALAN
IGBALIC
PAREDES
SAMONTE
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StringsandDFA extends javax.swing.JFrame {
    JFileChooser chooser;
    ArrayList Stringzinput = new ArrayList<>();
    ArrayList StringzTT = new ArrayList<>();
    ArrayList StringzTTmem = new ArrayList<>();
    ArrayList inter = new ArrayList<>();
    ArrayList inper = new ArrayList<>();
    ArrayList input_states = new ArrayList<>();
    ArrayList inpA = new ArrayList<>();
    ArrayList inpB = new ArrayList<>();
    ArrayList inpC = new ArrayList<>();
    ArrayList final_states = new ArrayList<>();
    ArrayList alphabet = new ArrayList<>();
    String filenamedfa;
    String filenameinp;

    public StringsandDFA() {
        initComponents();
        processbtn.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        processbtn = new javax.swing.JButton();
        loadbtn = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        inputLabel = new javax.swing.JLabel();
        outputLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTA = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        inputTA = new javax.swing.JTextArea();
        ttLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        statusTA = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        dfatable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        processbtn.setBackground(new java.awt.Color(255, 0, 0));
        processbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        processbtn.setText("Process");
        processbtn.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                processbtnStateChanged(evt);
            }
        });
        processbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processbtnActionPerformed(evt);
            }
        });

        loadbtn.setBackground(new java.awt.Color(255, 0, 0));
        loadbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        loadbtn.setText("Load File");
        loadbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadbtnActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(255, 0, 0));
        statusLabel.setText("Status:");

        inputLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        inputLabel.setForeground(new java.awt.Color(255, 0, 0));
        inputLabel.setText("Input");

        outputLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        outputLabel.setForeground(new java.awt.Color(255, 0, 0));
        outputLabel.setText("Output");

        outputTA.setColumns(20);
        outputTA.setRows(5);
        jScrollPane1.setViewportView(outputTA);

        inputTA.setColumns(20);
        inputTA.setRows(5);
        jScrollPane3.setViewportView(inputTA);

        ttLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ttLabel1.setForeground(new java.awt.Color(255, 0, 0));
        ttLabel1.setText("Transition Table");

        statusTA.setColumns(20);
        statusTA.setRows(5);
        jScrollPane4.setViewportView(statusTA);

        dfatable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "State", "", ""
            }
        ));
        dfatable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dfatable.setDragEnabled(true);
        jScrollPane5.setViewportView(dfatable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(statusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loadbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(369, 369, 369)
                                        .addComponent(inputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(processbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(outputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(ttLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(941, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(ttLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(413, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    // Loads and checks validity of file
    private void loadbtnActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser chooseFile1 = new JFileChooser();
        String namerz = new String ();
        chooseFile1.getCurrentDirectory();

        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.showOpenDialog(this);
        
        String file = chooser.getSelectedFile().getName();
        
        System.out.println("File name: " +file);
        System.out.println("File ext: " +getFileExtension(file));
      
        if ("dfa".equals(getFileExtension(file))) {
            filenamedfa = file;
            try {
                FileReader reader = new FileReader(chooser.getSelectedFile());
                BufferedReader br = new BufferedReader(reader);
                String str; 
                StringzTTmem.clear();
                    while ((str = br.readLine()) != null) {
                        StringzTTmem.add(str);
                    }

                    for (int i=1; i < StringzTTmem.size(); i++) {
                        truecheckerDFA((String)StringzTTmem.get(i));
                    }
                    
                    if (inter.contains(0)) {
                        statusTA.setText("INVALID DFA FILE");
                        statusTA.append("Unable to load content from " + filenamedfa + " due to invalid content.");
                        statusTA.append("The program will be using the content from the most recently successfully loaded file");
                        StringzTTmem.clear();
                        cleartable();
                    }
                    
                    else {
                        if(StringzTT.isEmpty()) {
                            System.out.println("Enter here when EMPTY\n");
                            StringzTT = (ArrayList) StringzTTmem.clone();
                            String r = StringzTT.get(0).toString();
                            r = r.replaceAll(",", "");
                            r = r.replaceAll("\t", "");
                            r = r.replaceAll(" ", "");
                            alphabet.clear();
                            alphabet.add(r.charAt(0) + "");
                            alphabet.add(r.charAt(1) + "");
                            System.out.println("Alphabet List: " + alphabet);
                            
                            for (int i=1; i< StringzTT.size(); i++) {
                                checkerDFA((String) StringzTT.get(i)); 
                                statusTA.setText("Sucessfully loaded " + filenamedfa + " file");
                            }
                        }
                        
                        else {
                            System.out.println("Enter here when NOT EMPTY\n");
                            StringzTT.clear();
                            input_states.clear();
                            inpA.clear();
                            inpB.clear();
                            inpC.clear();
                            final_states.clear();
                            StringzTT = (ArrayList) StringzTTmem.clone();
                            
                            String r = StringzTT.get(0).toString();
                            r = r.replaceAll(",", "");
                            r = r.replaceAll("\t", "");
                            r = r.replaceAll(" ", "");
                            alphabet.clear();
                            alphabet.add(r.charAt(0) + "");
                            alphabet.add(r.charAt(1) + "");
                            System.out.println("Alphabet List: " + alphabet);
                            
                            for (int i=1; i< StringzTT.size(); i++) {
                                checkerDFA((String) StringzTT.get(i)); 
                            }
                            
                            statusTA.setText("Sucessfully loaded " + filenamedfa + " file");
                        }
                    }
                    tableadder();
            }
            catch (FileNotFoundException ex) {
                Logger.getLogger(StringsandDFA.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex) {
                Logger.getLogger(StringsandDFA.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        
        else if ("inp".equals(getFileExtension(file))) {
            filenameinp = file;
            Stringzinput.clear();
            inputTA.setText("");
            try {
                FileReader reader = new FileReader(chooser.getSelectedFile());
                BufferedReader br = new BufferedReader(reader);
                String str;
                String exlimiter;
                
                while ((str = br.readLine()) != null) {
                    Stringzinput.add(str);
                }   

                String checker;
                
                for (int i=0; i < Stringzinput.size(); i++) {
                    checker = (String) Stringzinput.get(i);
                    inputTA.append(checker + "\n");
                }

                statusTA.setText("Successfully loaded " + filenameinp + " file");
            }
            catch (FileNotFoundException ex) {
                Logger.getLogger(StringsandDFA.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex) {
                Logger.getLogger(StringsandDFA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else statusTA.setText("Invalid File Extension!");
        
        if (inpA.isEmpty()|| inpB.isEmpty() || input_states.isEmpty() || alphabet.isEmpty() || final_states.isEmpty() || Stringzinput.isEmpty()) {
            processbtn.setEnabled(false);
        }
        else {
            processbtn.setEnabled(true);
        }
    }
    
    // Processes loaded .dfa and .inp files and outputs .out file
    private void processbtnActionPerformed(java.awt.event.ActionEvent evt) {
        outputTA.setText("");
        
        if (inpA.isEmpty()|| inpB.isEmpty() || input_states.isEmpty() || alphabet.isEmpty() || final_states.isEmpty() || Stringzinput.isEmpty()) {
            statusTA.setText("INCOMPLETE: MISSING INFORMATION\n");
        }
        else {
            for (int i = 0; i < Stringzinput.size(); i++) {
                outputTA.append("" + transition(Stringzinput.get(i).toString()));
            }
            System.out.println("Input states: " +input_states);
        }

        try {
            String output = outputTA.getText();
            File outputfile = new File ("strings.out");
            
            try (FileWriter powpow = new FileWriter (outputfile)) {
                powpow.write(output);
                powpow.flush();
                powpow.close();
                System.out.println("\nsaved!");
                statusTA.setText("Input from " + filenameinp + " successully processed using DFA table from " + filenamedfa + " Output saved to strings.out.");
            }
        }
        catch (IOException ex) {
            Logger.getLogger(StringsandDFA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                      

    private void processbtnStateChanged(javax.swing.event.ChangeEvent evt) {
    }                                       

    // Stores transition variables
    public void checkerDFA(String a) {
        a = a.replaceAll(",", "");
        a = a.replaceAll(" ", "");
        a = a.replaceAll("\t", "");
        String b = a;

        if (a.matches("[-][A-Z]*")) {
            input_states.add(b.charAt(1) + "");
            inpA.add(b.charAt(2) + "");
            inpB.add(b.charAt(3) + "");
            inpC.add(b.charAt(0) + "");   
        }
        
        else if (a.matches("[+][A-Z]*")) {
            final_states.add(b.charAt(1) + "");
            input_states.add(b.charAt(1) + "");
            inpA.add(b.charAt(2)+ "");
            inpB.add(b.charAt(3)+ "");
            inpC.add(b.charAt(0)+ "");
        }
        
        else if (a.matches("[A-Z]*")) { 
            b = b.replaceAll("", "");
            input_states.add(b.charAt(0)+ "");
            inpA.add(b.charAt(1)+ "");
            inpB.add(b.charAt(2)+ "");
            inpC.add(""); 
        }
    }
    
    // Checks validity of transition file
    public void truecheckerDFA(String a) {
        a = a.replaceAll(",", "");
        a = a.replaceAll(" ", "");
        a = a.replaceAll("\t", "");
        String b = a;

        if (a.matches("[-][A-Z]*")) {
            inter.add(1);
        }
        
        else if (a.matches("[+][A-Z]*")) {
            inter.add(1);
        }
        
        else if (a.matches("[A-Z]*")) {
            inter.add(1);
        }
        
        else {
            inter.add(0);
        }
    }
   
    // Gets the file extension
    public String getFileExtension(String file) {
        if (file.lastIndexOf(".") != -1 && file.lastIndexOf(".") != 0) {
            return file.substring(file.lastIndexOf(".")+1);
        }
        else {
            return "";
        }
    }
    
    // Traverses the transition table given the input
    public String move (String s, String ch) {
       int ind = input_states.indexOf(s);
       String first_alph = alphabet.get(0).toString();
       String second_alph = alphabet.get(1).toString();

       if(alphabet.contains(ch)) {
           if (first_alph.equals(ch)) {
               return inpA.get(ind).toString();
           }
           else if (second_alph.equals(ch)) {
               return inpB.get(ind).toString();
           }
           else {
               System.out.println("Not in alphabet!");
           }
       }
       return null;
    }
    
    // Checks validity of input string
    public String transition(String inp) {
        String ch = inp.charAt(0) + "";
        String s = input_states.get(0).toString();
        String t;
        
        for (int j = 0; j < inp.length(); j++) {
            ch = inp.charAt(j) + "";
            s = move(s, ch);
        }
        
        if (final_states.contains(s)) {
            t = "VALID\n";
            return t;
        }
        else {
            t = "INVALID\n";
            return t;
        }
    }
    
    // Displays DFA table to GUI
    public void tableadder() {
        cleartable();
        dfatable.getColumnModel().getColumn(2).setHeaderValue(alphabet.get(0).toString());
        dfatable.getColumnModel().getColumn(3).setHeaderValue(alphabet.get(1).toString());
        System.out.println("S: " + input_states);
        System.out.println(alphabet.get(0).toString() + ": " + inpA);
        System.out.println(alphabet.get(1).toString() + ": " + inpB);
        DefaultTableModel model  = (DefaultTableModel) dfatable.getModel();
        Object rowData[] = new Object [4];

        for (int x=0; x < input_states.size(); x++) {
            rowData[0] = inpC.get(x);
            rowData[1] = input_states.get(x);
            rowData[2] = inpA.get(x);
            rowData[3] = inpB.get(x);
            model.addRow(rowData);
        }
    }
    
    // Clears table contents
    public void cleartable() {
        DefaultTableModel model = (DefaultTableModel) dfatable.getModel();
        model.setRowCount(0);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StringsandDFA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StringsandDFA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StringsandDFA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StringsandDFA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StringsandDFA().setVisible(true);
            }
        });
    }
    
    // Variables declaration
    private javax.swing.JTable dfatable;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JTextArea inputTA;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton loadbtn;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JTextArea outputTA;
    private javax.swing.JButton processbtn;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextArea statusTA;
    private javax.swing.JLabel ttLabel1;                  
}