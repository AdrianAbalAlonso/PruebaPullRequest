/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin22;

/**
 *
 * @author Adrián
 */
public class Boletin22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Fichero obx=new Fichero();   
        obx.crearArray();
        obx.crearFichero("Libreria.txt");
        obx.leerFicheiro("Libreria.txt");
        obx.engadir("Libreria.txt",new Libro("Libro5","Pepe",5f,5));
        obx.buscarAutor();
        obx.consultarTitulo();
        obx.modificar();
        obx.eliminar();
        obx.ordenar();
    }
    
}
