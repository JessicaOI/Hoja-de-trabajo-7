public class traducir {

    public static void compPalabras(BinarySearchTree bst, String[] p, String opcion, StringBuilder r)
    {

        for (int i= 0; i < p.length; i++)
        {
            ComparableAsso ca = new ComparableAsso(p[i].toLowerCase());
            if(bst.contains(ca))
            {
                BinaryTree encontrar = bst.locate(bst.root,ca);
                ComparableAsso c = (ComparableAsso) encontrar.value();
                Palabras palabras = (Palabras) c.getValue();
                r.append(palabras.getPalabra(opcion)+" ");

            }
            else
            {
                r.append("*"+p[i]+"*"+" ");
            }

        }

    }

    public static StringBuilder getTraducida(String[] texto, String opcion, BinarySearchTree bsti, BinarySearchTree bste, BinarySearchTree bstf)
    {
        StringBuilder r = new StringBuilder();

        if(opcion.equals("a"))
        {
            compPalabras(bsti,texto,opcion,r);
        }
        else if(opcion.equals("b"))
        {
            compPalabras(bste,texto,opcion,r);
        }
        else if(opcion.equals("c"))
        {
            compPalabras(bstf,texto,opcion,r);
        }

        return r;

    }
}
