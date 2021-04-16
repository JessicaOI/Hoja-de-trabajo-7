import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("diccionario.txt");
            Scanner linea = new Scanner(archivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero


           //while ((linea = br.readLine()) != null)
                //System.out.println(linea);

            while (linea.hasNextLine()) {
                String data = linea.nextLine();
                String[] palabra = data.split(",");

                Palabras pal = new Palabras(palabra);

                //realizamos la comparación desde la versión extendida creada que es la de comparableasso
                ComparableAsso ingles = new ComparableAsso(palabra[0], pal);
                ComparableAsso esp = new ComparableAsso(palabra[1], pal);
                ComparableAsso frances = new ComparableAsso(palabra[2], pal);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
