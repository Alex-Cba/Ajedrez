import CarpMenu.MenuVentana;

import javax.swing.*;

import Sprites.All_Sprites;
import Tablero.*;

public class Main {
    private static Tablero _tablero = new Tablero();
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        /*
        // Cargar la imagen desde la carpeta "recursos"
        ImageIcon imagenIcono = new ImageIcon(All_Sprites.class.getResource("/Sprites/W_Pawn.png"));

        // Crear un JLabel para mostrar la imagen
        JLabel imagenLabel = new JLabel(imagenIcono);

        // Mostrar el JLabel en un JFrame
        JFrame ventana = new JFrame();
        ventana.add(imagenLabel);
        ventana.pack();
        ventana.setVisible(true);

         */


        MenuVentana menu = new MenuVentana();
        menu.setVisible(true);

        //Tablero

        //Matriz Tablero

        //Movimiento pieza
    }
}