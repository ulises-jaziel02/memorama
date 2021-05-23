import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Image;

/**
 *
 * @author pablo
 */
public class Tablero {
    private int filas;
    private int columnas;    
    private int totalCartas;
    private static Baraja baraja;  


    public Tablero() {

    }
    public static void main (String[] args) {                        
        Tablero t = new Tablero();        
        t.crearTablero();                
        
    }
    public void crearTablero() {    
        int cartas;
        baraja = new Baraja();          
        JFrame frame = new JFrame("Memorama ICO G-02");
        Imagenes img = new Imagenes();
        cartas = img.getCantidadImagenes();
        calculaGrid(cartas);
        JPanel panel = new JPanel(new GridLayout(filas,columnas));
                       
        for(int i=0;i<totalCartas;i++) {
            int fils = 700/filas;
            int cols = 700/columnas;        
            asignarIcono(baraja.consultaCarta(i), fils, cols);
            baraja.consultaCarta(i).setIcon(baraja.consultaCarta(i).getIconoTapado());                        
            baraja.consultaCarta(i).setPreferredSize(new Dimension(fils, cols)); 
            panel.add(baraja.consultaCarta(i));
        }        
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setVisible(true);

    }

    public void calculaGrid(int numeroCartas) {
        double raiz;
        totalCartas = numeroCartas * 2;
        raiz = Math.sqrt(totalCartas);
        columnas = (int)raiz;
        filas = columnas;
        if( raiz > columnas ) {
            filas = columnas+1;
        }
        if(columnas*filas < totalCartas) {
            columnas += 1;
        }
    }

    public void asignarIcono(Cartas carta,int width,int height) {                
        ImageIcon imageIcon = new ImageIcon(carta.getImagen());
        Image iconoActual = imageIcon.getImage(); 
        Image nuevoIcono = iconoActual.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);  
        imageIcon = new ImageIcon(nuevoIcono); 
        carta.setIcono(imageIcon);
        
        imageIcon = new ImageIcon(carta.getImagenTapada());
        iconoActual = imageIcon.getImage(); // transform it 
        nuevoIcono = iconoActual.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(nuevoIcono); 
        carta.setIconoTapado(imageIcon);                          
    }
          
}