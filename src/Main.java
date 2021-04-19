import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        String respuesta2 = null;
        String respuesta = null;

        boolean cont = true;
        boolean cont2 = true;
        boolean cont3 = true;

        Scanner scan = new Scanner(System.in);

        BinarySearchTree ing = new BinarySearchTree();
        BinarySearchTree esp = new BinarySearchTree();
        BinarySearchTree fra = new BinarySearchTree();

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
                ComparableAsso espa = new ComparableAsso(palabra[1], pal);
                ComparableAsso frances = new ComparableAsso(palabra[2], pal);

                ing.add(ingles);
                esp.add(espa);
                fra.add(frances);



            }
            linea.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        esp.iterator();


        while (true)
        {
            System.out.println("Bienvenido al traductor(ingles-español-frances)");

            System.out.println("¿En que idioma esta el texto que ingresará?");
            System.out.println("a. Ingles");
            System.out.println("b. Español");
            System.out.println("c. Frances");
            System.out.println("opción:");
            respuesta = scan.nextLine().toLowerCase();

            if(respuesta.equals("a"))
            {
                System.out.println("¿A que idioma desea traducirlo?");
                System.out.println("b. Español");
                System.out.println("c. Frances");
                System.out.println("opción:");
                respuesta2 = scan.nextLine().toLowerCase();
                while (cont)
                {
                    if(respuesta2.equals("b")||respuesta2.equals("c"))
                    {
                        cont = false;
                    }
                    else
                    {
                        System.out.println("porfavor ingrese una de las opciones dadas");
                        System.out.println("¿A que idioma desea traducirlo?");
                        System.out.println("b. Español");
                        System.out.println("c. Frances");
                        System.out.println("opción:");
                        respuesta2 = scan.nextLine().toLowerCase();
                    }
                }


            }
            else if(respuesta.equals("b"))
            {
                System.out.println("¿A que idioma desea traducirlo?");
                System.out.println("a. Ingles");
                System.out.println("c. Frances");
                System.out.println("opción:");
                respuesta2 = scan.nextLine().toLowerCase();
                while (cont2)
                {
                    if(respuesta2.equals("a")||respuesta2.equals("c"))
                    {
                        cont2 = false;
                    }
                    else
                    {
                        System.out.println("porfavor ingrese una de las opciones dadas");
                        System.out.println("¿A que idioma desea traducirlo?");
                        System.out.println("a. Ingles");
                        System.out.println("c. Frances");
                        System.out.println("opción:");
                        respuesta2 = scan.nextLine().toLowerCase();
                    }
                }
            }
            else if(respuesta.equals("c"))
            {
                System.out.println("¿A que idioma desea traducirlo?");
                System.out.println("a. Ingles");
                System.out.println("b. Español");
                System.out.println("opción:");
                respuesta2 = scan.nextLine().toLowerCase();
                while (cont3)
                {
                    if(respuesta2.equals("a")||respuesta2.equals("b"))
                    {
                        cont3 = false;
                    }
                    else
                    {
                        System.out.println("porfavor ingrese una de las opciones dadas");
                        System.out.println("¿A que idioma desea traducirlo?");
                        System.out.println("a. Ingles");
                        System.out.println("b. Español");
                        System.out.println("opción:");
                        respuesta2 = scan.nextLine().toLowerCase();
                    }
                }
            }

            try {
                // Apertura del fichero y creacion de BufferedReader para poder
                // hacer una lectura comoda (disponer del metodo readLine()).
                archivo = new File("texto.txt");
                Scanner linea = new Scanner(archivo);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);

                // Lectura del fichero

                while (linea.hasNextLine()) {
                    String data = linea.nextLine();
                    String[] palabra = data.split(" ");

                    //Palabras pal = new Palabras(palabra);

                    System.out.println(traducir.getTraducida(palabra,respuesta,ing,esp,fra,respuesta2));
                    System.out.println();

                }

                linea.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }





    }
}
