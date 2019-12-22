import java.lang.String.*;
import java.lang.StringBuffer;
import java.util.Vector;
import java.util.StringTokenizer;
public class Appariement {
	
		  static Vector transformerEnVecteur(String phrase) {
		    StringTokenizer diviseur = new StringTokenizer(phrase, " ");
		    Vector vecteurDeMots = new Vector();
		    while ( diviseur.hasMoreTokens() ){
		      vecteurDeMots.addElement(diviseur.nextToken());
		    }
		    return vecteurDeMots;
		  }

		  public static boolean correspondre(String phrase, String filtre) {
		    Vector vecteurPhrase = transformerEnVecteur(phrase.toLowerCase().trim());
		    Vector vecteurFiltre = transformerEnVecteur(filtre.toLowerCase().trim());
		    int i = 0;
		    while (i < vecteurFiltre.size() & i < vecteurPhrase.size()){
		      if(vecteurFiltre.elementAt(i).equals("$")){
		        vecteurFiltre.setElementAt(vecteurPhrase.elementAt(i), i);
		      }
		      else if(vecteurFiltre.elementAt(i).equals("*")){
		         if ((i < vecteurFiltre.size()-1) && (vecteurFiltre.elementAt(i+1).equals(vecteurPhrase.elementAt(i)))){
		          vecteurFiltre.removeElementAt(i);
		         }
		         else if(i == vecteurPhrase.size()-1){
		          vecteurFiltre.setElementAt(vecteurPhrase.elementAt(i), i);
		         }
		         else {
		          vecteurFiltre.insertElementAt(vecteurPhrase.elementAt(i), i);
		         }
		      }
		      i++;
		    }
		    vecteurFiltre.removeElement("*");
		    i = 0;
		    StringBuffer strb = new StringBuffer();

		    while(i < vecteurFiltre.size()){
		      strb.append(vecteurFiltre.elementAt(i));
		      strb.append(" ");
		      i++;
		    }

		    filtre = strb.toString();
		    filtre = filtre.trim();
		    phrase = phrase.trim();

		    if ( filtre.equalsIgnoreCase(phrase) ) {
		      return true;
		    }
		    else {
		      return false;
		    }
		  }
		}


