/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finabank;

/**
 *
 * @author Yepy
 */
public class Employe extends Client {
    private String password;
    private int idPoste;

    public Employe(String id, String nom, String prenom, String password, String telephone, int idPoste) {
        super(id, nom, prenom, telephone);
        this.password = password;
        this.idPoste = idPoste;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(int idPoste) {
        this.idPoste = idPoste;
    }
    
}
