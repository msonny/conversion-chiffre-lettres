package models;

import java.util.*;
import javax.validation.*;
import play.data.validation.Constraints.*;

public class Chiffres {
    @Required
    public int valeur;
    public Chiffres() {}
    public Chiffres(int i) {
	   this.valeur = i;
    }

    public String en_lettres() {
    	if (valeur == 1)return "1";
    	else return "different de 1";
    }
}
