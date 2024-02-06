package n1exercici1_2_3_4_5;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //n1exercici1
        System.out.println("Introduce la ruta que quieres consultar");
        String ruta = input.nextLine();
        File directorio = new File(ruta);
        ListadoDirectorio nuevoDirectorio = new ListadoDirectorio(directorio);

        try {
            System.out.println(nuevoDirectorio.ordenarAlfabeto(directorio));
        }catch(FileNotFoundException e1){
            System.out.println("No se ha encontrado la ruta");
        }catch(NullPointerException e) {
            System.out.println("La ruta está vacía");
        }

        //n1exercici2
        try {
            nuevoDirectorio.listarArbolDirectorioRecursivo(directorio);
        }catch (FileNotFoundException e2){
            System.out.println("No se ha encontrado la ruta");
        }catch(NullPointerException e) {
            System.out.println("La ruta está vacía");
        }

        //n1exercici3
        System.out.println("Indica la ruta donde quieres guardar el archivo");
        String rutaGuardarTxt = input.nextLine();
        try (FileWriter subdirectorio = new FileWriter(rutaGuardarTxt);)
        {
            nuevoDirectorio.guardarDirectorioRecursivoEnTxt(directorio, subdirectorio);
        }catch(IOException e){
            System.out.println("No se ha podido escribir correctamente");
        }
        //n1exercici4
        System.out.println("Indica la ruta del archivo que quieras leer");
        String rutaLeer = input.nextLine();
        nuevoDirectorio.leerArchivo(new File(rutaLeer));

        //n1exercici5
        /*Serializa nuevoSerializable = new Serializa();
        String objetoSerializable = "Me llamo Nuria y tengo 34 años";
        String ruta = "C:/Users/nfdez/IntelliJ/JavaUtils/src/n1exercici5/Archivo Serializado.ser";
        String ruta2 = "C:/Users/nfdez/IntelliJ/JavaUtils/src/n1exercici5/Archivo Serializado.ser";
        nuevoSerializable.serializar(objetoSerializable, ruta, ruta2);*/

        System.out.println("Indica la ruta del archivo que quieras serializar");
        String rutaGuardarSerializado = input.nextLine();
        nuevoDirectorio.serializar("Me llamo Nuria y tengo 34 años", new File(rutaGuardarSerializado),
                rutaGuardarSerializado);





    }

}