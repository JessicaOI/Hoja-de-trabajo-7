import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Palabras {

    public static String ingles;
    public static String espa;
    public static String frances;

    public Palabras(String[] palabra) {
        //guardamos los datos en variablesseparadas para cuando se necesiten y asi al mismo tiempo validamos que no interrumpan las mayudculas a la hora de comparar.
        ingles = palabra[0].toLowerCase();
        espa = palabra[1].toLowerCase();
        frances = palabra[2].toLowerCase();

    }


}
