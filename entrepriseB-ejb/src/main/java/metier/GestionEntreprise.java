/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entities.CompteRendu;
import entities.Entreprise;
import java.util.ArrayList;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

/**
 *
 * @author alban
 */
@Stateless
public class GestionEntreprise implements GestionEntrepriseLocal {

    private Entreprise ent;
    private ArrayList<CompteRendu> compteRendus;

    public GestionEntreprise() {
        this.ent = new Entreprise("123");
        this.compteRendus = new ArrayList<>();
        this.compteRendus.add(new CompteRendu("123", 50, "01/01/2020", "04/01/2020", "Rocher", 300));
    }
    
    @Override
    public void enregistrerCR(CompteRendu cr) {
        if(cr.getCodeClient().equals(ent.getCodeClient())) {
            this.compteRendus.add(cr);
            System.out.println("Nouveau compte-rendu pour le client 123 : "+ cr.toString());
        }
    }
    
    @Override
    public ArrayList<CompteRendu> afficherCR() {
       return this.compteRendus;
    }
    
    
}
