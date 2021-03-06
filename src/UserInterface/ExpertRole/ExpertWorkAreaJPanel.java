/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ExpertRole;

import BusinessLogic.EcoSystem;
import BusinessLogic.Employee.Employee;
import BusinessLogic.Employee.Expert;
import BusinessLogic.Enterprise.Enterprise;
import BusinessLogic.Network.Network;
import BusinessLogic.Organization.Organization;
import BusinessLogic.Bean.Training;
import BusinessLogic.UserAccount.UserAccount;
import BusinessLogic.WorkQueue.Response;
import BusinessLogic.WorkQueue.WorkRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nehal
 */
public class ExpertWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ExpertWorkAreaJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private Network network; 
    private EcoSystem business;
    
    private Expert expert;
   

    public ExpertWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Network network, EcoSystem business) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    initComponents();
    
    this.userProcessContainer = userProcessContainer;
    this.account = account;
    this.organization = organization;
    this.network = network;
    this.business = business;
    Employee e = account.getEmployee();
    this.expert = ((Expert)e);
    
    expertNameJLabel.setText("Hello, "+e.getName());
    
    populateFarmerQueryTable();
    
    farmerQueryJTable.addMouseListener(new java.awt.event.MouseAdapter() {
        
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
  
        int row = farmerQueryJTable.rowAtPoint(evt.getPoint());
        int col = farmerQueryJTable.columnAtPoint(evt.getPoint());
        
        if (row >= 0 && col >= 0) {
          
            
            viewTheQueryDetails();

        }
    }
}); 
    
   
    }
    
    
    public void viewTheQueryDetails(){
        
         int selectedRow = farmerQueryJTable.getSelectedRow();

        if (selectedRow >= 0) {
            
           queryRequest = (WorkRequest)farmerQueryJTable.getValueAt(selectedRow, 1);
          
          queryDetailsJTextArea.setText(queryRequest.getMessage());
          replyJButton.setEnabled(true);
          
        }
    }

    public void populateFarmerQueryTable(){
        
        
      DefaultTableModel model = (DefaultTableModel) farmerQueryJTable.getModel();
        
        model.setRowCount(0);
               
        for(WorkRequest wr: business.getWorkQueue().getWorkRequestList())
         {
                 
             
            Object[] row = new Object[5];
            
            row[0] = wr.getSender().getEmployee().getName();
            row[1] = wr;
            row[2] = wr.getStatus();
            row[3] = wr.getRequestDate();
            row[4] = wr.getResolveDate() == null ? "-": wr.getResolveDate();
           
       
            model.addRow(row);
            //System.err.println("loaded table "+model.getRowCount());
        } 
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        attachJButton = new javax.swing.JButton();
        fileNameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        topicJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        errTopicJLabel = new javax.swing.JLabel();
        errAttachmentJLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        farmerQueryJTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        queryReplyJtextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        queryDetailsJTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        replyJButton = new javax.swing.JButton();
        expertNameJLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1164, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Home  ", new javax.swing.ImageIcon(getClass().getResource("/UserInterface/ExpertRole/images/home.png")), jPanel1); // NOI18N

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        attachJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/ExpertRole/images/attach.png"))); // NOI18N
        attachJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachJButtonActionPerformed(evt);
            }
        });
        jPanel2.add(attachJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 80, 60));

        fileNameJTextField.setEditable(false);
        fileNameJTextField.setEnabled(false);
        jPanel2.add(fileNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 250, 50));

        jLabel1.setText("Topic");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        topicJTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                topicJTextFieldFocusLost(evt);
            }
        });
        jPanel2.add(topicJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 100, 250, 50));

        jLabel2.setText("Reference Document");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/ExpertRole/images/upload.png"))); // NOI18N
        jButton1.setText("Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 250, -1));

        errTopicJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errTopicJLabel.setForeground(new java.awt.Color(255, 51, 102));
        jPanel2.add(errTopicJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 220, -1));

        errAttachmentJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        errAttachmentJLabel.setForeground(new java.awt.Color(255, 51, 102));
        jPanel2.add(errAttachmentJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 230, -1));

        jTabbedPane1.addTab("Create Training Material ", new javax.swing.ImageIcon(getClass().getResource("/UserInterface/ExpertRole/images/file.png")), jPanel2); // NOI18N

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        farmerQueryJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Subject", "Status", "Request Date", "Resolved Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(farmerQueryJTable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 16, 979, 182));

        jLabel3.setText("Query Details");

        queryReplyJtextArea.setColumns(20);
        queryReplyJtextArea.setRows(5);
        jScrollPane2.setViewportView(queryReplyJtextArea);

        queryDetailsJTextArea.setEditable(false);
        queryDetailsJTextArea.setColumns(20);
        queryDetailsJTextArea.setRows(5);
        queryDetailsJTextArea.setEnabled(false);
        jScrollPane3.setViewportView(queryDetailsJTextArea);

        jLabel4.setText("Reply");

        replyJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/ExpertRole/images/send.png"))); // NOI18N
        replyJButton.setEnabled(false);
        replyJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replyJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addGap(56, 56, 56))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(replyJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel4)
                        .addContainerGap(80, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(replyJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 198, -1, -1));

        jTabbedPane1.addTab("Farmer Queries", new javax.swing.ImageIcon(getClass().getResource("/UserInterface/ExpertRole/images/comments.png")), jPanel3); // NOI18N

        expertNameJLabel.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(expertNameJLabel)
                .addGap(242, 242, 242))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(expertNameJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
File dest = null;
File source = null;
    private void attachJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachJButtonActionPerformed
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyymmdd");

        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        source = jfc.getSelectedFile();
        
        
        if(source!=null){
            
        
        String fullFileName = source.getAbsolutePath();
        
       
         
        String[] fileNameArray = fullFileName.split("\\\\");
        int index  = fileNameArray.length-1;
        String fileName = fileNameArray[index];
        
        File newDir = new File(System.getProperty("user.dir")+"\\TrainingMaterial\\"+expert.getName());
        
        if(!newDir.exists()){
            newDir.mkdirs();
        }
       
        
        String destinationPath = newDir.getAbsolutePath()+"\\"+fileName;
        dest = new File(destinationPath);
         if(dest.exists()){
           int dialogButton = JOptionPane.YES_NO_OPTION;
           int dialogResult = JOptionPane.showConfirmDialog (this, "A file with the same name exists. Do you want to copy anyway?","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                
//            fileName = "Copy_of_"+fileName;
//            destinationPath = newDir.getAbsolutePath()+"\\"+fileName;
     try{  
         
         destinationPath = newDir.getAbsolutePath()+"\\"+dateFormat.format(Calendar.getInstance().getTime())+"_"+fileName;
        File file2 = new File(destinationPath);

       source.renameTo(file2);
        
//                  File origfile = dest; // Changes targetpath to file
//    String name = origfile.getName(); // Gets the name of the file to be updated
//    File file1 = new File(newDir.getAbsolutePath()+"\\Copy_of_"+fileName); //Create a new file instance with the name of the old file + date
//    origfile.renameTo(file1); //Rename the original file
//    origfile.createNewFile(); //Backup the original file
   // Files.delete(dest); 
                
     }catch(Exception e){
         
     }        
              fileNameJTextField.setText(destinationPath);
            }else{
               fileNameJTextField.setText(""); 
            }
        }
         else{
            fileNameJTextField.setText(destinationPath);   
         }
      
        
        // File dest = new File("/Users/pankaj/tmp/dest.avi");
        
        }
        
        
    }//GEN-LAST:event_attachJButtonActionPerformed

    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
    Files.copy(source.toPath(), dest.toPath());
}
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ///////////////////////////////////////////
        ///////////////////////////////////////////
        ////////     VALIDATIONS       ////////////
        ///////////////////////////////////////////
        //////////////////////////////////////////
       boolean flag = true;
        String topic =  topicJTextField.getText();
       String docPath = fileNameJTextField.getText();
       if(topic.isEmpty()){
           
           errTopicJLabel.setText("Please enter a topic name");
           flag = false;
       }
       
        if(docPath.isEmpty()){
           
           errAttachmentJLabel.setText("Please attach a file");
           flag = false;
       }
        
        if(flag){
            
  
       long start = System.nanoTime();
        
        try {
            copyFileUsingJava7Files(source, dest);
        } catch (IOException ex) {
            
            ///////////////////////////////////////////////
            ///////////////////////////////////////////////
            //////////    LOGGING         /////////////////
            ///////////////////////////////////////////////   
         //   Logger.getLogger(ExpertWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
       // System.out.println("Time taken by Java7 Files Copy = "+(System.nanoTime()-start));    
 
       
       Training t = expert.getExperTrainingCatalog().addTraining();
       t.setTopic(topic);
       t.setReferenceDocumentPath(docPath);
       
       t.setNumberOfDownloads(0);
       
        JOptionPane.showMessageDialog(this, "Traing for "+topic+ " created successfully");
       
       }
//       else{
//          JOptionPane.showMessageDialog(this, topic.isEmpty() ? "Please Enter topic" :docPath.isEmpty() ? " Please attach a file" : "Please pri..."); 
//       }
    }//GEN-LAST:event_jButton1ActionPerformed
 WorkRequest queryRequest = null;
    private void replyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replyJButtonActionPerformed
        // TODO add your handling code here:
        String reply = queryReplyJtextArea.getText();
        
        if(!reply.isEmpty()){
            Response newResponse = new Response();
            
            newResponse.setReply(reply);
            newResponse.setResponder(expert);
            newResponse.setReplyDate(new Date());
           queryRequest.getQueryResponseDirectory().getResponseList().add(newResponse);
           queryRequest.setStatus("Answered");
           
           WorkRequest queryReply = new WorkRequest();
           queryReply.setRequestTitle(reply);
           queryReply.setSender(account);
           queryReply.setMessage("Your query has been answered");
           
          queryRequest.getSender().getWorkQueue().getWorkRequestList().add(queryReply);
          
          JOptionPane.showMessageDialog(this, "Your reply has been submitted");
          queryReplyJtextArea.setText("");
        }
    }//GEN-LAST:event_replyJButtonActionPerformed
boolean flagTopicValid = true;
    private void topicJTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_topicJTextFieldFocusLost
    String title = topicJTextField.getText().trim();
    
    if(!title.isEmpty()){
        
        errTopicJLabel.setText("");
        flagTopicValid = true;
    }
    }//GEN-LAST:event_topicJTextFieldFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attachJButton;
    private javax.swing.JLabel errAttachmentJLabel;
    private javax.swing.JLabel errTopicJLabel;
    private javax.swing.JLabel expertNameJLabel;
    private javax.swing.JTable farmerQueryJTable;
    private javax.swing.JTextField fileNameJTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea queryDetailsJTextArea;
    private javax.swing.JTextArea queryReplyJtextArea;
    private javax.swing.JButton replyJButton;
    private javax.swing.JTextField topicJTextField;
    // End of variables declaration//GEN-END:variables
}
