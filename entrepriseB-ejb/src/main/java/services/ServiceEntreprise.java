/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.CompteRendu;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import metier.GestionEntreprise;
import metier.GestionEntrepriseLocal;

/**
 *
 * @author Claire
 */
@Stateless
public class ServiceEntreprise implements ServiceEntrepriseLocal {

    @EJB
    private GestionEntrepriseLocal gestionEntreprise;

    public ServiceEntreprise() {
    }
    
    @Override
    public ArrayList<CompteRendu> afficherCR() {
        return this.gestionEntreprise.afficherCR();
    }

}
