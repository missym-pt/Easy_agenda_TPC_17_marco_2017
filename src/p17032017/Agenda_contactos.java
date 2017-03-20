/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p17032017;

import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Missy M
 */
public class Agenda_contactos {
    
    public ArrayList<Pessoa> agenda;

    public Agenda_contactos() {
        
        int op=0;
        agenda=new ArrayList<Pessoa>();
        
        carregarContactos();  
         
        System.out.println("<--------------EASY Agenda - MENU--------------> ");
        System.out.println("1 - Inserir novo contacto\n2 - Pesquisar contacto\n3 - Eliminar contacto\n4 - Listar todos os contactos\n0 - SAIR  ");
        op=new Scanner(System.in).nextInt();
        
        switch(op){
             case 1:  novoContacto(); 
                break;
             case 2: pesquisarContacto();
                break;
             case 3: eliminarContacto();
                break;
             case 4: listarTodosContactos();
                 break;
             case 0: System.out.println("Obrigado por utlizar a EASY Agenda.\n Até breve... ");
                break;
             default: System.out.println("Essa opção é inválida. ");
                break;}  
        
        gravarContactos();
        
    }
    
    public void novoContacto(){
        
        Pessoa contacto=new Pessoa(null, null, null, 0);
        
        System.out.println("Indique o nome do contacto: ");
        contacto.setNome(new Scanner(System.in).nextLine());
         
        String c="@";
        do{  
        System.out.println("Indique o email do contacto: "); 
        contacto.setEmail(new Scanner(System.in).nextLine());
        }while(contacto.getEmail().contains(c)==false);
        
        do{
        System.out.println("Indique a morada do contacto: "); 
        contacto.setMorada(new Scanner(System.in).nextLine());
        }while(contacto.getMorada().length()<1);
        
        do{
        System.out.println("Indique o numero de telemovel do contacto: "); 
        contacto.setTlm(new Scanner(System.in).nextInt());
        }while(contacto.getTlm()<910000000 || contacto.getTlm()>969999999);
        
        agenda.add(contacto);
        }
        
     public void listarTodosContactos(){
          System.out.println("<--------------Listagem de contactos--------------> ");
         for(int i=0; i<agenda.size(); i++){
            System.out.println("Nome: " + ((agenda.get(i)).getNome()) + "\nEmail: " + ((agenda.get(i)).getEmail())+ "\nMorada: " + ((agenda.get(i)).getMorada()) + "\nNumero de Telemovel: " + ((agenda.get(i)).getTlm()) );
          System.out.println("<-------------------------------------------------> ");
         }
               
    }     
     
     public void pesquisarContacto(){
         String x;
         System.out.println("Indique o nome do contacto que pretende pesquisar: "); 
         x=new Scanner(System.in).nextLine();
         
         for(int i=0; i<agenda.size(); i++){
             if((agenda.get(i).getNome().compareTo(x)==0)){
                 System.out.println("<--------------Detalhes de contacto--------------> ");
                 System.out.println("Nome: " + ((agenda.get(i)).getNome()) + "\nEmail: " + ((agenda.get(i)).getEmail())+ "\nMorada: " + ((agenda.get(i)).getMorada()) + "\nNumero de Telemovel: " + ((agenda.get(i)).getTlm()) ); 
             }}
     }
     
     public void eliminarContacto(){
         
         String x;
         System.out.println("<----------------Remoção de contactos----------------> ");
         System.out.println("Indique o nome do contacto que pretende eliminar: "); 
         x=new Scanner(System.in).nextLine();
         
         for(int i=0; i<agenda.size(); i++){
             if((agenda.get(i).getNome().compareTo(x)==0)){
                 agenda.remove(i);
                 System.out.println("Contacto eliminado... ");
             }}
     }
     
    public void add(String nome, String email, String morada, int tlm ){
        Pessoa contacto=new Pessoa(nome,email, morada, tlm);
        agenda.add(contacto);
    }
    
    public void carregarContactos(){
          
         String file = "contactos.txt"; 
         String line = null;
         
         try {
             FileReader fileReader =  new FileReader(file);
             
             try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                 int i=0, tlm=0; 
                 String nome = null, morada = null, email = null;
                 while((line = bufferedReader.readLine()) != null) {                     
                     switch (i){
                         case 0: nome=line;
                                 i++;
                             break;
                         case 1: email=line;
                                 i++;
                            break;
                         case 2: morada=line;
                                 i++;
                             break;
                         case 3: tlm=parseInt(line);  
                                 add(nome, email, morada, tlm);
                                 i=0;
                             break;}}
             } 
               
         }catch(FileNotFoundException ex) {
            System.out.println("Impossivel abrir '" + file + "'");
         
         }catch(IOException ex) {
            System.out.println("Erro ao ler o ficheiro '" + file + "'");}
      }  
    
    public void gravarContactos(){
        
         String file = "contactos.txt";

        try {
            
            FileWriter fileWriter = new FileWriter(file);

             try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                 for(int i=0; i<agenda.size(); i++){
                                    
                     bufferedWriter.write(agenda.get(i).getNome());
                     bufferedWriter.newLine();
        
                     bufferedWriter.write(agenda.get(i).getEmail());
                     bufferedWriter.newLine();
                  
                     bufferedWriter.write(agenda.get(i).getMorada());
                     bufferedWriter.newLine();
                     
                     bufferedWriter.write(String.valueOf(agenda.get(i).getTlm()));
                     bufferedWriter.newLine();}
             }
        }
        catch(IOException ex) {
            System.out.println(
                "Erro ao escrever para ficheiro '" + file + "'");
        }
    }
}

    
    

