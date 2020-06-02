
package topictracking;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.*;
import edu.stanford.nlp.ling.CoreLabel;
import java.applet.AppletContext;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;



public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    String sen1[];
    ArrayList stpres1=new ArrayList();
    ArrayList txt1=new ArrayList();
    ArrayList feat1=new ArrayList();
    ArrayList noun1=new ArrayList();
    
    String sen2[];
    ArrayList stpres2=new ArrayList();
    ArrayList txt2=new ArrayList();
    ArrayList feat2=new ArrayList();
    ArrayList noun2=new ArrayList();
    
    
    public MainFrame() {
        initComponents();
    }

    /
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel1.setText("Topic Tracking");

        jLabel2.setFont(new java.awt.Font("Cambria Math", 0, 17)); // NOI18N
        jLabel2.setText("Source");

        jButton1.setFont(new java.awt.Font("Cambria Math", 0, 16)); // NOI18N
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setFont(new java.awt.Font("Californian FB", 0, 18)); // NOI18N
        jButton2.setText("Proprocess");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Californian FB", 0, 18)); // NOI18N
        jButton3.setText("POS Tagging");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Californian FB", 0, 18)); // NOI18N
        jButton4.setText("Features Extraction");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel3.setFont(new java.awt.Font("Cambria Math", 0, 17)); // NOI18N
        jLabel3.setText("Suspicious ");

        jButton5.setFont(new java.awt.Font("Cambria Math", 0, 16)); // NOI18N
        jButton5.setText("Browse");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jButton2)
                        .addGap(74, 74, 74)
                        .addComponent(jButton3)
                        .addGap(54, 54, 54)
                        .addComponent(jButton4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(jTextField2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(24, 24, 24))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try
        {
            JFileChooser ch1=new JFileChooser();
            int v=ch1.showOpenDialog(this);

            if (v == JFileChooser.APPROVE_OPTION)
            {
                String path = ch1.getSelectedFile().getPath();

                jTextField1.setText(path);

                File fe=new File(path);
                FileInputStream fis=new FileInputStream(fe);
                byte data[]=new byte[fis.available()];
                fis.read(data);
                fis.close();

                jTextArea1.setText(new String(data));
                jButton5.setEnabled(true);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        try
        {
            Preprocessing pg1=new Preprocessing(jTextArea1.getText().trim());
            String sg1[]=pg1.sentenceSegmentation();
            sen1=new String[sg1.length];
            sen1=sg1;

            txt1=pg1.normalization(sg1);
            stpres1=pg1.stpres;

            
             for(int i=0;i<txt1.size();i++)
            {
                String st=txt1.get(i).toString();
                if(!(feat1.contains(st)))
                {
                    feat1.add(st);

                }
            }
             
            Preprocessing pg2=new Preprocessing(jTextArea2.getText().trim());
            String sg2[]=pg2.sentenceSegmentation();
            sen2=new String[sg2.length];
            sen2=sg2;

            txt2=pg2.normalization(sg2);
            stpres2=pg2.stpres;
            
           
            
            for(int i=0;i<txt2.size();i++)
            {
                String st=txt2.get(i).toString();
                if(!(feat2.contains(st)))
                {
                    feat2.add(st);

                }
            }

            PreprocessFrame pf=new PreprocessFrame();
            
            Object lt1[]=stpres1.toArray();
            pf.jList1.setListData(lt1);
            
            
            Object lt3[]=feat1.toArray();
            pf.jList3.setListData(lt3);
            
            
            Object lt2[]=stpres2.toArray();
            pf.jList2.setListData(lt2);
            
            Object lt4[]=feat2.toArray();
            pf.jList4.setListData(lt4);
            

            pf.setVisible(true);
            pf.setTitle("Text Preprocessing ");
            pf.setResizable(false);

            jButton3.setEnabled(true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) 
    {

        try
        {
            //edu.stanford.nlp.tagger.maxent.MaxentTagger ob=new edu.stanford.nlp.tagger.maxent.MaxentTagger(".\\models\\left3words-wsj-0-18.tagger");
            edu.stanford.nlp.tagger.maxent.MaxentTagger ob=new edu.stanford.nlp.tagger.maxent.MaxentTagger(edu.stanford.nlp.tagger.maxent.MaxentTagger.DEFAULT_JAR_PATH);

            ArrayList pos1=new ArrayList();
            
            ArrayList verb1=new ArrayList();

            for(int i=0;i<feat1.size();i++)
            {
                String st=feat1.get(i).toString();
                
                String tag=ob.tagString(st).trim();
                //if(tag.endsWith("/NN") || tag.endsWith("/NNS") || tag.endsWith("/NP") ||tag.endsWith("/NPS"))
                if(tag.endsWith("_NN") || tag.endsWith("_NNS") || tag.endsWith("_NP") ||tag.endsWith("_NPS"))
                {
                    noun1.add(tag);
                }
                //if(tag.endsWith("/VB") ||tag.endsWith("/VBD") ||tag.endsWith("/VBG") ||tag.endsWith("/VBN")||tag.endsWith("/VBZ"))
                if(tag.endsWith("_VB") ||tag.endsWith("_VBD") ||tag.endsWith("_VBG") ||tag.endsWith("_VBN")||tag.endsWith("_VBZ"))
                {
                    verb1.add(tag);
                }

                pos1.add(tag);

            }
            
            
             ArrayList pos2=new ArrayList();
            
            ArrayList verb2=new ArrayList();

            for(int i=0;i<feat2.size();i++)
            {
                String st=feat2.get(i).toString();
                
                String tag=ob.tagString(st).trim();
                //if(tag.endsWith("/NN") || tag.endsWith("/NNS") || tag.endsWith("/NP") ||tag.endsWith("/NPS"))
                if(tag.endsWith("_NN") || tag.endsWith("_NNS") || tag.endsWith("_NP") ||tag.endsWith("_NPS"))
                {
                    noun2.add(tag);
                }
                //if(tag.endsWith("/VB") ||tag.endsWith("/VBD") ||tag.endsWith("/VBG") ||tag.endsWith("/VBN")||tag.endsWith("/VBZ"))
                if(tag.endsWith("_VB") ||tag.endsWith("_VBD") ||tag.endsWith("_VBG") ||tag.endsWith("/VBN")||tag.endsWith("_VBZ"))
                {
                    verb2.add(tag);
                }

                pos2.add(tag);

            }
            
            POSTagFrame pf=new POSTagFrame();
            Object lt1[]=pos1.toArray();
            pf.jList1.setListData(lt1);

            Object lt2[]=noun1.toArray();
            pf.jList2.setListData(lt2);

            Object lt3[]=verb1.toArray();
            pf.jList3.setListData(lt3);

            
            Object lt4[]=pos2.toArray();
            pf.jList4.setListData(lt4);

            Object lt5[]=noun2.toArray();
            pf.jList5.setListData(lt5);

            Object lt6[]=verb2.toArray();
            pf.jList6.setListData(lt6);
            
            pf.setVisible(true);
            pf.setTitle("POS Tagging");
            pf.setResizable(false);

            System.out.println(pos1);
            System.out.println(noun1);
            System.out.println(verb1);
            
            jButton4.setEnabled(true);
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        try
        {
            ArrayList at1=new ArrayList();
            for(int i=0;i<noun1.size();i++)
            {
                String g1=noun1.get(i).toString();
                //g1=g1.substring(0, g1.lastIndexOf("/"));
                g1=g1.substring(0, g1.lastIndexOf("_"));
                at1.add(g1);
            }    
            
            ArrayList at3=new ArrayList();
            for(int i=0;i<noun2.size();i++)
            {
                String g1=noun2.get(i).toString();
                //g1=g1.substring(0, g1.lastIndexOf("/"));
                g1=g1.substring(0, g1.lastIndexOf("_"));
                at3.add(g1);
            }    
            
           
            FeatureFrame ff=new FeatureFrame(this);
            ff.setVisible(true);
            ff.setResizable(false);
            ff.setTitle("Feature Frame");
            Object lt1[]=at1.toArray();
            ff.jList1.setListData(lt1);
            
            
            Object lt3[]=at3.toArray();
            ff.jList3.setListData(lt3);
            
            String cls = "english.all.3class.distsim.crf.ser.gz";
            String tt1=jTextArea1.getText();
            
            AbstractSequenceClassifier<CoreLabel> classifier = CRFClassifier.getClassifierNoExceptions(cls);
          
          
            String res1=classifier.classifyToString(tt1);
            String sp1[]=res1.split(" ");
            
            ArrayList person1=new ArrayList();
            ArrayList loc1=new ArrayList();
            ArrayList time1=new ArrayList();
            ArrayList org1=new ArrayList();
            ArrayList money1=new ArrayList();
            ArrayList percent1=new ArrayList();
            ArrayList date1=new ArrayList();
            
            ArrayList at2=new ArrayList();
            for(int i=0;i<sp1.length;i++)
            {
                String s1=sp1[i];
                if(s1.contains("/"))
                {
                    String s2=s1.substring(0, s1.lastIndexOf("/"));
                    if(s1.endsWith("PERSON"))
                    {
                        if(!at2.contains(s2))    
                        {
                            s2=s1.replace("/PERSON","");
                            person1.add(s2);
                            at2.add(s2);
                        }
                    }
                    if(s1.endsWith("LOCATION"))
                    {                    
                        if(!at2.contains(s2))    
                        {
                            s2=s1.replace("/LOCATION","");
                            loc1.add(s2);
                            at2.add(s2);
                        }
                    }
                    if(s1.endsWith("TIME"))
                    {
                        if(!at2.contains(s2))    
                        {
                            s2=s1.replace("/TIME","");
                            time1.add(s2);
                            at2.add(s2);
                        }
                    }
                    if(s1.endsWith("DATE"))
                    {
                        
                        if(!at2.contains(s2))    
                        {
                            s2=s1.replace("/DATE","");
                            date1.add(s2);
                            at2.add(s2);
                        }
                    }
                    if(s1.endsWith("ORGANIZATION"))
                    {
                        if(!at2.contains(s2))    
                        {
                            s2=s1.replace("/ORGANIZATION","");
                            org1.add(s2);
                            at2.add(s2);
                        }
                    }
                    if(s1.endsWith("PERCENT"))
                    {
                        if(!at2.contains(s2))    
                        {
                            s2=s1.replace("/PERCENT","");
                            percent1.add(s2);
                            at2.add(s2);
                        }
                    }
                    if(s1.endsWith("MONEY"))
                    {                    
                        if(!at2.contains(s2))    
                        {
                            s2=s1.replace("/MONEY","");
                            money1.add(s2);
                            at2.add(s2);
                        }
                    }
                  }
                }
                System.out.println("Person "+person1);
                System.out.println("Date "+date1);
                System.out.println("Org "+org1);
                System.out.println("Time "+time1);
                System.out.println("Money "+money1);
                System.out.println("Percent "+percent1);
                System.out.println("Location "+loc1);
                
                
            String tt2=jTextArea2.getText();
            String res2=classifier.classifyToString(tt2);
            String sp2[]=res2.split(" ");
            
            ArrayList person2=new ArrayList();
            ArrayList loc2=new ArrayList();
            ArrayList time2=new ArrayList();
            ArrayList org2=new ArrayList();
            ArrayList money2=new ArrayList();
            ArrayList percent2=new ArrayList();
            ArrayList date2=new ArrayList();
            
           ArrayList at4=new ArrayList();
            for(int i=0;i<sp2.length;i++)
            {
                String s1=sp2[i];
                if(s1.contains("/"))
                {
                    String s2=s1.substring(0, s1.lastIndexOf("/"));
                    if(s1.endsWith("PERSON"))
                    {
                        if(!at4.contains(s2))    
                        {
                            s2=s1.replace("/PERSON","");
                            person1.add(s2);
                            at4.add(s2);
                        }
                    }
                    if(s1.endsWith("LOCATION"))
                    {                    
                        if(!at4.contains(s2))    
                        {
                            s2=s1.replace("/LOCATION","");
                            loc1.add(s2);
                            at4.add(s2);
                        }
                    }   
                    if(s1.endsWith("TIME"))
                    {
                        if(!at4.contains(s2))    
                        {
                            s2=s1.replace("/TIME","");
                            time1.add(s2);
                            at4.add(s2);
                        }
                    }
                    if(s1.endsWith("DATE"))
                    {
                    
                        if(!at4.contains(s2))    
                        {
                            s2=s1.replace("/DATE","");
                            date1.add(s2);
                            at4.add(s2);
                        }
                    }
                    if(s1.endsWith("ORGANIZATION"))
                    {
                        if(!at4.contains(s2))    
                        {
                            s2=s1.replace("/ORGANIZATION","");
                            org1.add(s2);
                            at4.add(s2);
                        }
                    }
                    if(s1.endsWith("PERCENT"))
                    {
                        if(!at4.contains(s2))    
                        {
                            s2=s1.replace("/PERCENT","");
                            percent1.add(s2);
                            at4.add(s2);
                        }
                    }   
                    if(s1.endsWith("MONEY"))
                    {                    
                        if(!at4.contains(s2))    
                        {
                            s2=s1.replace("/MONEY","");
                            money1.add(s2);
                            at4.add(s2);
                        }
                    }
                }
            }
            System.out.println("Person2 "+person2);
            System.out.println("Date2 "+date2);
            System.out.println("Org2 "+org2);
            System.out.println("Time2 "+time2);
            System.out.println("Money2 "+money2);
            System.out.println("Percent2 "+percent2);
            System.out.println("Location2 "+loc2);
            
            Object lt2[]=at2.toArray();
            ff.jList2.setListData(lt2);
            
            Object lt4[]=at4.toArray();
            ff.jList4.setListData(lt4);
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        try
        {
            JFileChooser ch1=new JFileChooser();
            int v=ch1.showOpenDialog(this);

            if (v == JFileChooser.APPROVE_OPTION)
            {
                String path = ch1.getSelectedFile().getPath();

                jTextField2.setText(path);

                File fe=new File(path);
                FileInputStream fis=new FileInputStream(fe);
                byte data[]=new byte[fis.available()];
                fis.read(data);
                fis.close();

                jTextArea2.setText(new String(data));
                jButton2.setEnabled(true);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
   

    private AppletContext getAppletContext() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
