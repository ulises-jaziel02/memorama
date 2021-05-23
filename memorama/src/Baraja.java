import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author Uriel Jimenez Zempoalteca
 */

public class Baraja {
    private Cartas[] cartas;
    private Imagenes img; 
    
    public Baraja()
    {
        //Funciones de Baraja
        img = new Imagenes(); 
        ObtenerCartas();
        RevolverCartas();
    }
    
    public void ObtenerCartas()
    {
        //Obteniendo cartas
        String[] imagen = img.getImagenes();
        cartas = new Cartas[img.getCantidadImagenes()*2];
        for(int i=0; i<cartas.length; i++)
        {
            cartas[i] = new Cartas(i); 
        }
    }
    
    public void RevolverCartas()
    {
        //Revolviendo Cartas
        int tmp=0,tmp2=0;
        String[] imagenes = img.getImagenes();        
        while(tmp<this.cartas.length) 
        {                                    
            cartas[tmp].setImagen(imagenes[tmp2]);
            cartas[tmp].setId(tmp2);
            cartas[tmp].setImagenTapada(img.getImagenReverso());
            if(tmp%2==1 && tmp!=0) {
                tmp2++;
            }            
            tmp++;                   
        }           
        List<Cartas> values = Arrays.asList((cartas));
        Collections.shuffle(values);
    }
    
    public Cartas[] getCartas()
    {
        return cartas; 
    }
    
}
