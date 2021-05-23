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
        ObtenerCartas();
        RevolverCartas();
    }
    
    public void ObtenerCartas()
    {
        //Obteniendo cartas
        String[] imagen = img.getImagenes();
        cartas = new Cartas[img.getCantidadImagenes()*2];
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
