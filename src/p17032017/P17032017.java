/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p17032017;

import java.util.Scanner;

/**
 *
 * @author Missy M
 */
public class P17032017 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        char answer = 0;
        do{
        new Agenda_contactos();        
        System.out.println("Deseja efectuar mais operações? (s\\n) ");
        answer=new Scanner(System.in).next().charAt(0);
        }while(answer!='n');
    }
    
}
