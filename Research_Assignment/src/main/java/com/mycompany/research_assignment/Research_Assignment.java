/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.research_assignment;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument; 
import org.apache.pdfbox.text.PDFTextStripper;
/**
 *
 * @author VIGHNESH
 */
public class Research_Assignment {
        public void pdfreader()
        {
            try
            {
                    JFrame frame = new JFrame("TestDemo");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(700, 700);
                    JPanel panel = new JPanel();
                    JLabel showFilePath = new JLabel();
                    JButton btn = new JButton("Choose File");
                   
                    btn.addActionListener(new ActionListener() {
                         @Override
                        public void actionPerformed(ActionEvent e) {
                             JFileChooser jfc = new JFileChooser();
                                int result = jfc.showOpenDialog(frame);
                                File selectFile = jfc.getSelectedFile();
                                String filepath = selectFile.getAbsolutePath();

                                File file=new File(filepath);
                                FileInputStream fips = null;
                                PDDocument doc = null;
                                PDFTextStripper pdfs = null;
                                String pdfdata = null;
                             try {
                                       fips = new FileInputStream(file);
                                       doc = PDDocument.load(fips);
                                       pdfs = new PDFTextStripper();
                                       pdfdata = pdfs.getText(doc);
                             } catch (FileNotFoundException ex) {
                                 Logger.getLogger(Research_Assignment.class.getName()).log(Level.SEVERE, null, ex);
                             } catch (IOException ex) {
                                 Logger.getLogger(Research_Assignment.class.getName()).log(Level.SEVERE, null, ex);
                             }
                                
                                 if (result == JFileChooser.APPROVE_OPTION) {
                                        showFilePath.setText("File Uploaded Successfully");
                                        System.out.println("\nFile Path="+filepath);
                                        System.out.println("\nPages="+doc.getPages().getCount());                    
                                        System.out.println("\nContents:=\n"+pdfdata);
                                        System.out.println(pdfdata.contains("Experience")||pdfdata.contains("experinece"));

                             }          
                        }
                    });
                    panel.add(btn);
                    panel.add(showFilePath);
                    frame.setContentPane(panel);
                    frame.pack();
                    frame.setVisible(true);

                }   
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    public static void main(String[] args) {
        Research_Assignment obj=new Research_Assignment();
        obj.pdfreader();
    }
}
