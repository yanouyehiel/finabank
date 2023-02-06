/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finabank;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author Yepy
 */
public class Client {
    public String id;
    public String nom;
    public String prenom;
    private String occupation;
    public String telephone;

    public Client(String id, String nom, String prenom, String telephone, String occupation) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.occupation = occupation;
        this.telephone = telephone;
    }
    
    public Client(String id, String nom, String prenom, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    public Client() {
    }
    

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
