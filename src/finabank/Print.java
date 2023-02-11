/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finabank;

import java.text.*;
import javax.swing.*;

/**
 *
 * @author Yepy
 */
public class Print {
    public static void printJtable (JTable jt, String title) {
        MessageFormat header = new MessageFormat(title);
        MessageFormat footer = new MessageFormat("Page 0");
        
        try {
            jt.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur :\n"+e.getMessage(), "Impression", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }
}
