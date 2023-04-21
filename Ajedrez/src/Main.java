import CarpMenu.MenuVentana;

import javax.swing.*;
import Tablero.*;

public class Main {
    private static Tablero _tablero = new Tablero();
    //private static All_Sprites _All_Sprites = new All_Sprites();
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        MenuVentana menu = new MenuVentana();
        menu.setVisible(true);

        //Tablero

        //Matriz Tablero

        //Movimiento pieza
    }
}