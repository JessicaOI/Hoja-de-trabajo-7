import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Palabras {

     String ingles;
     String espa;
     String frances;

    public Palabras(String[] palabra) {
        //guardamos los datos en variablesseparadas para cuando se necesiten y asi al mismo tiempo validamos que no interrumpan las mayudculas a la hora de comparar.
        ingles = palabra[0].toLowerCase();
        espa = palabra[1].toLowerCase();
        frances = palabra[2].toLowerCase();

    }
    public String getPalabra(String l) {
        /*return switch (l) {
            case ("a") -> ingles;
            case ("b") -> espa;
            default -> frances;

        };*/

        if(l.equals("a"))
        {
            return ingles;
        }
        else if(l.equals("b"))
        {
            return espa;
        }
        else if(l.equals("c"))
        {
            return frances;
        }
        else
        {
            return "Error, ingrese una opción correcta";
        }

    }
    public String toString()
    {
        return "ingles:"+ingles+" /español:"+espa+" /frances:"+frances;
    }




}
