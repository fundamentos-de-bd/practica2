package fbd.practica2;

import java.io.*;
import java.util.Scanner;

/**
Ejecutable del sistema
 */
public class Practica2 {
    
    public static void main(String[] a) {
        Scanner f = new Scanner(System.in);
        System.out.println("---Bienvenido a nuestra tarea de FBD, antes de iniciar elige---");
        System.out.println("     1) Crear archivos de prueba. (Escribir 'hola' sin comillas)");
        System.out.println("     2) Iniciar programa (Cualquier otra cosa)\n>>");
        String q = f.nextLine();
        if(q.equals("hola")){
            Datos.testCSV();
            System.out.println("\n       NOTA: el programa se iniciará ahora\n----");
        }
        Menu.iniciaMenu();
    } 
    
    
}
