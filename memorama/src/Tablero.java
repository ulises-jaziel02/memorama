import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;

/**
 *
 * @author pablo
 */
public class Tablero {
    private int filas;
    private int columnas;
    private int cartas = 18; //Variable para pruebas
    private int totalCartas;

    public Tablero() {

    }
    public static void main (String[] args) {
        Tablero t = new Tablero();
        t.crearTablero();
    }
    public void crearTablero() {
        JFrame frame = new JFrame("Memorama ICO G-02");
        JPanel panelPuntaje = new JPanel();
        panelPuntaje.setSize(700,100);
        calculaGrid(cartas);
        JPanel panel = new JPanel(new GridLayout(filas,columnas,2,2));
        System.out.println(filas + " " + columnas);
        for(int i=1 ; i <= totalCartas ; i++) {
            JButton btn = new JButton(String.valueOf(i));
            int fils = 700/filas;
            int cols = 700/columnas;
            btn.setPreferredSize(new Dimension(fils, cols));
            panel.add(btn);
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

}