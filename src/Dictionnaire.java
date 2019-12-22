import java.util.Vector;
import java.util.StringTokenizer;

public class Dictionnaire {
	  LecteurFichier lecteur;
	  Appariement appariement = new Appariement();
	  Vector filtres = new Vector();
	  Vector universDuDiscours = new Vector();

	  public Dictionnaire(String fichier) {
	    lecteur = new LecteurFichier(fichier);
	    String ligneLue = lecteur.lireLigne();
	    while (ligneLue != null){
	      StringTokenizer diviseur = new StringTokenizer(ligneLue, "|");
	      filtres.addElement(diviseur.nextToken());
	      universDuDiscours.addElement(diviseur.nextToken());
	      ligneLue = lecteur.lireLigne();
	    }
	  }

	  public String repondre(String phrase){
	    int i = 0;
	    int indexChoix;
	    while (i<filtres.size()){
	      if (appariement.correspondre(phrase,(String)filtres.elementAt(i))){
	        break;
	      }
	      i++;
	    }
	    Vector reponse = transformerEnVecteur((String)universDuDiscours.elementAt(i));
	    indexChoix = (int)(Math.random()*reponse.size());
	    return (String)reponse.elementAt(indexChoix);
	  }

	  static Vector transformerEnVecteur(String phrase) {
	    StringTokenizer diviseur = new StringTokenizer(phrase, "/");
	    Vector vecteurDeMots = new Vector();
	    while ( diviseur.hasMoreTokens() ){
	      vecteurDeMots.addElement(diviseur.nextToken());
	    }
	    return vecteurDeMots;
	  }
}
