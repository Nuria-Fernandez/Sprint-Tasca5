package n1exercici1_2_3_4_5;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListadoDirectorio implements Serializable{


    public ListadoDirectorio(File ruta){
        ruta = ruta;

    }
    //n1exercici1
    public File [] ordenarAlfabeto(File ruta) throws FileNotFoundException {

        File[] listaArchivos = ruta.listFiles();
        //uso listFiles porque hace un array de objetos File, mientras que .list solo hace un array String con los nombres de los archivos
        if (ruta.exists()) {
            Arrays.sort(listaArchivos);//método sort lo ordena alfabetica/ usando interna/ el compareTo
            for (File archivo : listaArchivos) {
                System.out.println(archivo);
            }//Hago el for para que me lo imprima en formato lista y no de corrido
        }
        return listaArchivos;
    }
    //n1exercici2
    public File [] listarArbolDirectorioRecursivo(File ruta) throws FileNotFoundException{
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        //con esto se le da formato de String a la fecha interna de java.
        //Da formato al objeto Date. En este caso .lastModified devuelve un valor long y hay que pasarlo a String
        File[] listaFiles = ruta.listFiles();//devuelve un array con los nombres
        Arrays.sort(listaFiles);//.sort lo ordena alfabeticamente
        for(File archivo : listaFiles){
            if(archivo.isDirectory()){
                System.out.println("D: " + archivo.getName() + " La última fecha de modificación es: "
                        + formatoFecha.format(archivo.lastModified()));
                listarArbolDirectorioRecursivo(archivo);
                //Esto lo hace recursivo, ya que va a hacer esta acción cada vez que encuentre un directorio.
            }else{
                System.out.println("F: " + archivo.getName() + " La última fecha de modificación es: "
                        + formatoFecha.format(archivo.lastModified()));
                //SimpleDataFormat tiene el método .format que le da forma a la fecha en long de .lastModified
                }
            }

        return listaFiles;//devuelve lista ordenada
    }
    //n1exercici3
    public void guardarDirectorioRecursivoEnTxt(File ruta, FileWriter escritura) throws IOException{

            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            File [] listaArchivo = listarArbolDirectorioRecursivo(ruta);
            for(File archivo : listaArchivo ) {
                if (archivo.isDirectory()) {
                    escritura.write("D: " + archivo.getName() + " La última fecha de modificación es: "
                            + formatoFecha.format(archivo.lastModified()));
                    escritura.write("\n");
                    guardarDirectorioRecursivoEnTxt(archivo, escritura);
                    //cuando encuentra un directorio, coje el archivo, lo lista, vuelve a hacer el if y lo añade
                    //a la ruta del archivo listado.txt. Si dentro hay más directorios, lo vuelve a hacer.
                } else {
                    escritura.write("F: " + archivo.getName() + " La última fecha de modificación es: "
                            + formatoFecha.format(archivo.lastModified()));
                    escritura.write("\n");
                }
            }
    }
    //n1exercici4
    public void leerArchivo(File ruta){
        try(FileReader archivoParaLeer = new FileReader(ruta.getAbsoluteFile());
            /* getAbsoluteFile() representa la ruta absoluta del archivo la que que comienza desde
             el directorio raíz del sistema de archivos hasta el archivo o directorio deseado*/
            BufferedReader bf = new BufferedReader(archivoParaLeer)){
            String linea;
            while((linea = bf.readLine()) != null){
                System.out.println(linea);
            }
        }catch(IOException e){
            System.out.println("No se ha encontrado el archivo");
        }
    }
    //n1exercici5
    public void serializar(String objetoSerializable, File rutaGuardar, String rutaRecuperar){//Necesito File porque ListadoDirectorio tiene como parametro un File

        try(FileOutputStream ruta = new FileOutputStream(rutaGuardar.getAbsoluteFile());//declaro la ruta donde va a ser guardado el archivo//Uso .getAbsoluteFile para que sea un String
            ObjectOutputStream escribirFichero = new ObjectOutputStream(ruta);//aquí declaro la clase ObjectOutPut que es la que tiene el metodo para escribir(pasar los objetos a bytes)
            FileInputStream ruta2 = new FileInputStream(rutaRecuperar); //Indico la ruta a la que hay que acceder para obtener el archivo serializado
            ObjectInputStream recuperarFichero = new ObjectInputStream(ruta2);){ //Declaro la clase que me va a permitir leer el archivo

            escribirFichero.writeObject(objetoSerializable);//para transformarlo en bytes y poder lanzarlo a otro pc por red o a un sistema de almacenamiento

            objetoSerializable = (String) recuperarFichero.readObject();//Leo el archivo. Lo paso a String porque el Objeto Serializado es un String

            System.out.println(objetoSerializable);//Imprimo para ver lo que .readObject ha leído.

        }catch (IOException | ClassNotFoundException e) {
            System.out.println("No se ha podido escribir el archivo");
        }
    }



}