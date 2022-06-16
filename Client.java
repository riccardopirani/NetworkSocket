//Riccardo Pirani www.riccardopirani.altervista.org

import java.io.*;
import java.net.*;

public class Client{

     public static void main(String args[]){
                     
          try{
           String host=""+args[0];
           int port=Integer.parseInt(args[1]);   

          //leggo valori da input

          BufferedReader input=new BufferedReader(new InputStreamReader(System.in));          
                            
            System.out.println("\n Inserisci un valore (CLIENT): ");
          String lettura=input.readLine();
              
          Socket s=new Socket(host,port);
          PrintWriter output=new PrintWriter(s.getOutputStream()); 
          BufferedReader insok = new BufferedReader(new InputStreamReader(s.getInputStream()));     
          while(!lettura.equals("fine")){
     
          System.out.println("\n Inserisci un valore (CLIENT): ");
           
          output.println(lettura);
          output.flush();
         
          //attendo dal server il risultato
        
          String lettsock=insok.readLine(); 
          System.out.println("\n Ho ricevuto dal server : "+lettsock);
                 
          lettura=input.readLine();       
         }
          //chiusura input
          input.close();  
       }

         catch(Exception ex){
            System.out.println("\n Errore: " + ex);
            System.exit(2);
         }  
    }


} 
