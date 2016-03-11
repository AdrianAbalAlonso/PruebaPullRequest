/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin22;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;



/**
 *
 * @author Adrián
 */
public class Fichero {
     ArrayList <Libro> lista= new ArrayList();
    
    public void crearArray(){
        Libro lib1= new Libro("L1","Jorge",5f,0);
        Libro lib2=new Libro("L2","Miki",25f,3);
        Libro lib3=new Libro("L3","Nbor",34f,1);
        Libro lib4=new Libro("L4","Pablo",432f,5);
        lista.add(lib1);
        lista.add(lib2);
        lista.add(lib3);
        lista.add(lib4);
    }
     public void crearFichero(String nomeFich) {
        File f= new File(nomeFich);
        PrintWriter escribir=null;
        
        try {
            escribir=new PrintWriter(f);
            for(int i=0;i<lista.size();i++){
            escribir.println(lista.get(i));
            }      
      } catch (FileNotFoundException ex) {
            System.out.println("erro escritura"+ex.getMessage());
        }
        finally{
            escribir.close();
        }
        
    }
      public void leerFicheiro(String nomeFich){
        Scanner sc=null;
        try {
          
            File f= new File(nomeFich);
            sc=new Scanner(f);
            while(sc.hasNextLine()){
                String res=sc.nextLine();
                System.out.println(res);}
        } catch (FileNotFoundException ex) {
            System.out.println("erro na lectura do ficheiro"+ex.getMessage());
            
            }finally{
            sc.close();
        }
        
    }
      public void engadir(String nomeFich, Libro dato){
        FileWriter fw = null;
        PrintWriter escribir=null;
        
        try {
            fw = new FileWriter(nomeFich,true);//añadir si es false lo sobre escribe
            escribir=new PrintWriter(fw);
            //escribir.append("\n");            
            escribir.append(dato.toString());
            
        } catch (IOException ex) {
            System.out.println("Erro añadir datos"+ex.getMessage());
        }finally{
            try {
                fw.close();
                escribir.close();
            } catch (IOException ex) {
                System.out.println("Erro de pechado"+ex.getMessage());
            }
            
        }
        
    }
    
   
    public void consultarTitulo(){
        String res=JOptionPane.showInputDialog("Introduaca el titulo del libro");
        for(int i =0;i<lista.size();i++){
            if(lista.get(i).getNomeLibro().equals(res))
                System.out.println("\n"+lista.get(i).toString()+"\n");
           }
    }
    public void eliminar(){
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getUnidades()==0)
               lista.remove(i);
        }
    }
    public void modificar(){
        String res=JOptionPane.showInputDialog("Introduzca el titulo del libro");
        Float prezo=Float.parseFloat(JOptionPane.showInputDialog("Introduzca el precio"));
                for(int i =0;i<lista.size();i++){
            if(lista.get(i).getNomeLibro().equals(res))
                lista.get(i).setPrecio(prezo);
            
        }
    }
    public void buscarAutor(){
        String acLibros="";
        String res=JOptionPane.showInputDialog("Introduzca el autor "); 
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getAutor().equals(res))
                acLibros+=lista.get(i).getNomeLibro()+"\n";
        }
        System.out.println(acLibros);
    }
public void ordenar(){
    //Collections.sort(lista);//no entiendo porque me da fallo si el Array se llama lista .
}

}

