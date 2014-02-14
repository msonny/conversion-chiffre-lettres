package controllers;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.chiffres.*;
import models.*;

public class ConvEnLettres extends Controller {
    
    /**
     * Formulaire pour la classe Chiffres.
     */ 
    final static Form<Chiffres> formulaire = form(Chiffres.class);
  
    /**
     * Afficher un formulaire vide.
     */ 
    public static Result blank() {
        return ok(form_sans.render(formulaire));
    }
  
    /**
     * Traiter la soumission d'un formulaire.
     */
    public static Result submit() {
        Form<Chiffres> formulaire_plein =  formulaire.bindFromRequest();
        
        // vérifier les conditions d'acceptation
	if (! romain_valide(formulaire_plein.field("valeur").value())) {
	    formulaire_plein.reject("valeur", "seuls les chiffres sont acceptés");
        }
        
        if(formulaire_plein.hasErrors()) {
            return badRequest(form_sans.render(formulaire_plein));
        } else {
	    Chiffres n = formulaire_plein.get();
            return ok(form_avec.render(form(Chiffres.class), n.valeur, n.en_decimal()));
        }
    }

    static boolean romain_valide(String s) { return true; }
  
}
