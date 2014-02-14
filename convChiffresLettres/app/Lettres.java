package models;

import java.util.*;
import javax.validation.*;
import play.data.validation.Constraints.*;

public class Lettres {
    @Required
    public String valeur=new String();
    public Lettres() {}
    public Lettres(String s) {
	   this.valeur = s;
    }

    public String en_chiffres() {
    	if (valeur == "un")return "1";
    	else return "different de 1";
    }
}
