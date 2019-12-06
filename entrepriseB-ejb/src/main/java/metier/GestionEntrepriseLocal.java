/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entities.CompteRendu;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author alban
 */
@Local
public interface GestionEntrepriseLocal {
    public ArrayList<CompteRendu> afficherCR();
    public void enregistrerCR(CompteRendu cr);
}
