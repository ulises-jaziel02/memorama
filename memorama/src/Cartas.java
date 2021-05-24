import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Define los objetos que indican el estado de las cartas en el tablero
 * @author Aarón
 */
public class Cartas extends JButton implements ActionListener {
    private int id;
    private boolean encontrado;
    private boolean destapado;
    private String imagen;
    private String imagenTapada;
    private ImageIcon icono;
    private ImageIcon iconoTapado;    

/**
 * 
 * @param id El parametro id define el identificador de la carta
 */  
    public Cartas(int id) {        
        this.id = id;
        this.destapado=false;
        this.encontrado=false;
        this.setBackground(Color.darkGray);          
        addActionListener(this);
    }

/**
 * Metodo que valida las acciones que hagan los usuarios y compara las cartas seleccionadas
 * @param e parametro que recibe la accion del usauario
 */
    @Override
    public void actionPerformed(ActionEvent e) {  
        
     if(!Tablero.diferentes()) {         
        if(!destapado) {
            destapar();  
            if(Tablero.getCartaVolteada1() == null){                
                Tablero.setCartaVolteada1(this);
                if(Tablero.getCartaVolteada1().isEncontrado()){
                    Tablero.setCartaVolteada1(null);
                }
            }
            else if(Tablero.getCartaVolteada2() == null){
                Tablero.setCartaVolteada2(this);
                if(Tablero.getCartaVolteada2().isEncontrado()){
                    Tablero.setCartaVolteada1(null);
                }
            }
            if (Tablero.getCartaVolteada1() != null && Tablero.getCartaVolteada2() != null) {
                    if(!Tablero.comparaCasillas()){
                        Tablero.cambiaTurno();
                    }
                    Tablero.setCartaVolteada1(null);
                    Tablero.setCartaVolteada2(null);
            }
        }            
   
        }       
        
    }          
  
}
