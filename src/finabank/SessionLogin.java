/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finabank;

/**
 *
 * @author Yepy
 */
public class SessionLogin {
    private String matricule;
    private String password;

    public SessionLogin(String matricule, String password) {
        this.matricule = matricule;
        this.password = password;
    }
    
    public String[] getCredentials() {
        String login = matricule;
        String mdp = password;
        String[] cred = {login, mdp};
        
        return cred;
    }
}
