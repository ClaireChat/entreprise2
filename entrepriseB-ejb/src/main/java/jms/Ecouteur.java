/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import com.google.gson.Gson;
import entities.CompteRendu;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import metier.GestionEntreprise;
import metier.GestionEntrepriseLocal;

/**
 *
 * @author Claire
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "commercialEntreprise")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class Ecouteur implements MessageListener {
    
    private Gson gson;
    @EJB
    private GestionEntrepriseLocal ge;
    
    
    public Ecouteur() {
        this.gson = new Gson();
        //this.ge = new GestionEntreprise();
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            String mes = message.getBody(String.class);
            CompteRendu cr = this.gson.fromJson(mes, CompteRendu.class);
            this.ge.enregistrerCR(cr);
            
            
        } catch (JMSException ex) {
            Logger.getLogger(Ecouteur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
