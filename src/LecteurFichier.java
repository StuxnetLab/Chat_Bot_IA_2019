import java.io.*;
public class LecteurFichier {
	
		  BufferedReader in;

		  public LecteurFichier(String fichier) {
		    try{
		      in = new BufferedReader(new InputStreamReader(new FileInputStream(fichier)));
		    }
		    catch(IOException ex){
		      System.out.println(ex.getMessage());
		    }
		  }

		  public String lireLigne(){
		    try {
		      return in.readLine();
		    }
		    catch(IOException ex){
		      System.out.println(ex.getMessage());
		      return null;
		    }
		  }

		  public void close(){
		    try{
		      in.close();
		    }
		    catch (IOException ex){
		    }
		  }

}
