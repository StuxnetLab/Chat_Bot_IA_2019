
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

public class chatbot extends JFrame {
	Dictionnaire dictionnaire = new Dictionnaire(System.getProperty("user.dir")+System.getProperty("file.separator")+"Dictionnaire.txt");
	 Model model = FileManager.get().loadModel("cancer.ttl");
	//Typing Area:
	private JTextField txtEnter = new JTextField();
	
	//Chat Area:
	private JTextArea txtChat = new JTextArea();
	
	public chatbot() {
		//Frame Attributes:
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setVisible(true);
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("Chatbot médical");
		
		//txtEnter Attributes:
		txtEnter.setLocation(2, 540);
		txtEnter.setSize(590, 30);
		
		//txtEnter Action Event:
		txtEnter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) 
                        {
				String uText = txtEnter.getText();
				txtChat.append("Doct : " + uText + "\n");
				
				uText = dictionnaire.repondre(txtEnter.getText());
				
		
		
		 if(uText.contains("req2")){
           
                String queryString =        
                		"PREFIX ns: <http://xmlns.com/cancer/0.1/> " +
                				"SELECT ?y WHERE { " +
                				"    ?x ns:hasname \"Sonia\" . " +
                				"    ?x ns:symp ?y . " +
                				"}";
               
        
                   Query query = QueryFactory.create(queryString);
   
                    try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
                    ResultSet results = qexec.execSelect();
                      while ( results.hasNext() ) {
                      QuerySolution soln = results.nextSolution();
                      soln.getLiteral("y");
                         botSay(soln.getLiteral("y").toString());
                           
                     
                     }
                     }
	
				}
		else if(uText.contains("req1")){
           
                String queryString =        
                		"PREFIX ns: <http://xmlns.com/cancer/0.1/> " +
                				"SELECT ?y WHERE { " +
                				"    ?x ns:hasname \"Sonia\" . " +
                				"    ?x ns:hasage ?y . " +
                				"}";
               
        
                   Query query = QueryFactory.create(queryString);
   
                    try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
                    ResultSet results = qexec.execSelect();
                      while ( results.hasNext() ) {
                      QuerySolution soln = results.nextSolution();
                        soln.getLiteral("y");
                         botSay( soln.getLiteral("y").toString());
                           
                     
                     }
                     }
	
				}
		else if(uText.contains("req3")){
            
                String queryString =        
                		"PREFIX ns: <http://xmlns.com/cancer/0.1/> " +
                				"SELECT ?y WHERE { " +
                				"    ?x ns:hasname \"Sonia\" . " +
                				"    ?x ns:diag ?y . " +
                				"}";
               
        
                   Query query = QueryFactory.create(queryString);
   
                    try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
                    ResultSet results = qexec.execSelect();
                      while ( results.hasNext() ) {
                      QuerySolution soln = results.nextSolution();
                      soln.getLiteral("y");
                         botSay(soln.getLiteral("y").toString());
                           
                     
                     }
                     }
	
				}
				
		else if(uText.contains("req4")){
            
            String queryString =        
            		"PREFIX ns: <http://xmlns.com/cancer/0.1/> " +
            				"SELECT ?y WHERE { " +
            				//"    ?x ns:type \"Symptômes\" . " +
            				"    ?x ns:listsymp ?y . " +
            				"}";
           
    
               Query query = QueryFactory.create(queryString);

                try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
                ResultSet results = qexec.execSelect();
                  while ( results.hasNext() ) {
                  QuerySolution soln = results.nextSolution();
                  soln.getLiteral("y");
                     botSay(soln.getLiteral("y").toString());
                       
                 
                 }
                 }

			}
else if(uText.contains("req5")){
            
            String queryString =        
            		"PREFIX ns: <http://xmlns.com/cancer/0.1/> " +
            				"SELECT ?y WHERE { " +
            				//"    ?x ns:type \"Symptômes\" . " +
            				"    ?x ns:isa ?y . " +
            				"}";
           
    
               Query query = QueryFactory.create(queryString);

                try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
                ResultSet results = qexec.execSelect();
                  while ( results.hasNext() ) {
                  QuerySolution soln = results.nextSolution();
                  soln.getLiteral("y");
                     botSay(soln.getLiteral("y").toString());
                       
                 
                 }
                 }

			}
else if(uText.contains("req6")){
    
    String queryString =        
    		"PREFIX ns: <http://xmlns.com/cancer/0.1/> " +
    				
    				"SELECT ?y ?z ?p ?q WHERE { " +
    				  "?x ns:hasname \"Sonia\" . " +
    				  "?x ns:hasage ?p ."  +
    				 "?x ns:isa_tabac ?z ."  +	
    				  "?x ns:symp ?y ."  +	
    				  "?x ns:diag ?q ."  +	
    		    "}";
   

       Query query = QueryFactory.create(queryString);

        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
        ResultSet results = qexec.execSelect();
          while ( results.hasNext() ) {
          QuerySolution soln = results.nextSolution();
          String Newligne=System.getProperty("line.separator");
          String rslt = "Age : " + soln.getLiteral("p").toString() +" Tabac : "+ soln.getLiteral("z").toString()+ " Symptômes : " + soln.getLiteral("y").toString() + Newligne+ 
        		  " Diagnostics : " + soln.getLiteral("q").toString();
          botSay(rslt);
               
         
         }
         }

	}
		
		
                else {
                    botSay(uText) ;
                }
                
				txtEnter.setText("");
					
                        }
                                

		});
	
		
		
                
		//txtChat Attributes:
		txtChat.setLocation(15, 5);
		txtChat.setSize(560, 510);
		txtChat.setEditable(false);
		
		//Add Items To Frame:
		this.add(txtEnter);
		this.add(txtChat);
	}
	
	public void botSay(String s){
		txtChat.append("ChatBot___AI : " + s + "\n");
	}
	
	public static void main(String[] args){
		new chatbot();
	}

}