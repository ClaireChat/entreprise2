/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrepriseB;

import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.MediaType;
import services.ServiceEntrepriseLocal;

/**
 * REST Web Service
 *
 * @author alban
 */
@Path("entrepriseB")
@RequestScoped
public class EntrepriseBResource {

    ServiceEntrepriseLocal serviceEntreprise = lookupServiceEntrepriseLocal();


    @Context
    private UriInfo context;
    
    private Gson gson;

    /**
     * Creates a new instance of EntrepriseBResource
     */
    public EntrepriseBResource() {
        serviceEntreprise = lookupServiceEntrepriseLocal();
        this.gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of entrepriseB.EntrepriseBResource
     * @return an instance of java.lang.String
     */
    @Path("afficherCR")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String afficherCR() {
        return this.gson.toJson(this.serviceEntreprise.afficherCR());
    }

    private ServiceEntrepriseLocal lookupServiceEntrepriseLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (ServiceEntrepriseLocal) c.lookup("java:global/entrepriseB-ear/entrepriseB-ejb-1.0-SNAPSHOT/ServiceEntreprise!services.ServiceEntrepriseLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

   
    
    

}
