//Riccardo Pirani www.riccardopirani.altervista.org

import java.io.*;
import java.net.*;


public class Server{

   static final int PORT = 1024;

    public static void main(String args[]){

     try{

         ServerSocket ss=new ServerSocket(PORT);
             
          while(true) {
               Socket ns = ss.accept();
                BufferedReader networkIn = new BufferedReader(new InputStreamReader(ns.getInputStream()));
                PrintWriter networkOut=new PrintWriter(ns.getOutputStream()); 
                String line;
                System.out.println("\n Attendo valori \n ");
                while ((line = networkIn.readLine()) != null) {
                  
                  System.out.println("Ricevuto: " + line);
                  try{
                     int number=Integer.parseInt(line);
                     number=number*number;
                     networkOut.println(number);
                     networkOut.flush();
                   }
                  catch(Exception ex){
                     System.out.println("\n Non mi hai inviato un numero \n");
                  } 
                }

              ns.close();
            }
          
              
     }
    catch(Exception ex){

        System.out.println("\n Errore Server: "+ex);
        System.exit(2);
     }


   }
   
}
