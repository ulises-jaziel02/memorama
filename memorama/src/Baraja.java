import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Uriel Jimenez Zempoalteca
 */

public class Baraja {
    private Cartas[] cartas;
    private Imagenes[] img; 
    
    public Baraja()
    {
        //Funciones de Baraja
        ObtenerCartas();
        RevolverCartas();
    }
    
    public void ObtenerCartas()
    {
        int i=0; 
        //Obteniendo cartas
        String[] imagen = img.getImagenes();
        cartas = new Cartas[img.getCantidadImagenes()*2];
        while(i==cartas.length)
        {
            cartas[i] = new Cartas(i);
            i++;
        }
    }
    
    public void RevolverCartas()
    {
        //Revolviendo Cartas
        
    }
    
    public Cartas[] getCartas()
    {
        return cartas; 
    }
    
}
