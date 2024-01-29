package n1exercici1_2_3_4_5;

import java.io.*;


public class Main {
    public static void main(String[] args) {

        //n1exercici1
        File directorio = new File("C:/Users/nfdez/OneDrive/Escritorio/Fonaments Java");
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
        try (FileWriter subdirectorio = new FileWriter("C:/Users/nfdez/IntelliJ/JavaUtils/src/n1exercici1_2_3_4_5/listado.txt");)
        {
            nuevoDirectorio.guardarDirectorioRecursivoEnTxt(directorio, subdirectorio);
        }catch(IOException e){
            System.out.println("No se ha podido escribir correctamente");
        }
        //n1exercici4
        nuevoDirectorio.leerArchivo(new File("C:/Users/nfdez/OneDrive/Documentos/PruebaJava.txt"));

        //n1exercici5
        /*Serializa nuevoSerializable = new Serializa();
        String objetoSerializable = "Me llamo Nuria y tengo 34 años";
        String ruta = "C:/Users/nfdez/IntelliJ/JavaUtils/src/n1exercici5/Archivo Serializado.ser";
        String ruta2 = "C:/Users/nfdez/IntelliJ/JavaUtils/src/n1exercici5/Archivo Serializado.ser";
        nuevoSerializable.serializar(objetoSerializable, ruta, ruta2);*/
        nuevoDirectorio.serializar("Me llamo Nuria y tengo 34 años", new File("C:/Users/nfdez/IntelliJ/JavaUtils/src/n1exercici5/Archivo Serializado.ser"),
                "C:/Users/nfdez/IntelliJ/JavaUtils/src/n1exercici5/Archivo Serializado.ser");





    }

}