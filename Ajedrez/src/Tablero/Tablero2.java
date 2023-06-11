package Tablero;

import Jugador.Jugador;
import Piezas.*;
import Piezas.Enums.Tipo_Color;
import Piezas.Enums.Tipo_Pieza;
import Sprites.All_Sprites;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Tablero2 extends JFrame
{
    private JFrame ventana;
    private Color t_colorBlack = new Color(0, 0, 0,255);
    private Color t_colorWhite = new Color(248, 248, 248,255);
    private JPanel panel_8x8 = new JPanel(new GridLayout(8, 8));
    private All_Sprites _All_Sprites = All_Sprites.getInstance();
    private ArrayList<Integer> lst_Componente = new ArrayList<>();
    public static String orden_Piezas = "Abajo_Blancas"; //TODO Cambiar esta mal
    private vTablero Matriz_Tablero = vTablero.getInstance(orden_Piezas);

    private Jugador Jugador1;//TODO: Hacer Jugadores
    private Jugador Jugador2;

    public vTablero getMatriz_Tablero(){return Matriz_Tablero;}

    public Tablero2() {



        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        ventana = this;
        ventana.setTitle("Tablero de Ajedrez");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(512, 512);
        ventana.setLocationRelativeTo(null);
        for (int i = 0; i < 64; i++) {

            JButton button = new JButton();

            //Fila
            if ((i / 8) % 2 == 0) {
                //Columna
                button.setBackground(i % 2 == 0 ? t_colorWhite : t_colorBlack);
            } else {
                //Columna
                button.setBackground(i % 2 == 0 ? t_colorBlack : t_colorWhite);
            }

            panel_8x8.add(button);
        }

        //Agregado de piezas

        Tipo_Color Color = Tipo_Color.NEGRO;
        //Agregar_AllPeones(Color);
        Agregar_AllTorres(Color);
        //Agregar_AllCaballos(Color);
        //Agregar_Alfiles(Color);
        Agregar_ReyReina(Color);

        add(panel_8x8);
    }
    private void Agregar_AllPeones(Tipo_Color Color)
    {
        int _inicio = 8;
        int _final = 16;
        for (int c = 0; c < 2; c++) //Blanco y Negro 2 vueltas
        {
            //Agregar Peones
            for (int i = _inicio; i < _final; i++)
            {
                Agregar_Pieza(Tipo_Pieza.PEON, Color, i);
            }

            if(Color.equals(Tipo_Color.BLANCO))
            {
                Color = Tipo_Color.NEGRO;
            } else if (Color.equals(Tipo_Color.NEGRO)) {
                Color = Tipo_Color.BLANCO;
            }
            _inicio = 48;
            _final = 56;
        }
    }

    private void Agregar_AllTorres(Tipo_Color Color)
    {
        Agregar_Pieza(Tipo_Pieza.TORRE, Color, 0);
        Agregar_Pieza(Tipo_Pieza.TORRE, Color, 7);

        if(Color.equals(Tipo_Color.BLANCO))
        {
            Color = Tipo_Color.NEGRO;

        } else if (Color.equals(Tipo_Color.NEGRO)) {
            Color = Tipo_Color.BLANCO;
        }
        Agregar_Pieza(Tipo_Pieza.TORRE, Color, 56);
        Agregar_Pieza(Tipo_Pieza.TORRE, Color, 63);
    }

    private void Agregar_AllCaballos(Tipo_Color Color)
    {

        Agregar_Pieza(Tipo_Pieza.CABALLO, Color, 1);
        Agregar_Pieza(Tipo_Pieza.CABALLO, Color, 6);

        if(Color.equals(Tipo_Color.BLANCO))
        {
            Color = Tipo_Color.NEGRO;
        } else if (Color.equals(Tipo_Color.NEGRO)) {
            Color = Tipo_Color.BLANCO;
        }


        Agregar_Pieza(Tipo_Pieza.CABALLO, Color, 57);
        Agregar_Pieza(Tipo_Pieza.CABALLO, Color, 62);
    }

    private void Agregar_Alfiles(Tipo_Color Color)
    {
        Agregar_Pieza(Tipo_Pieza.ALFIL, Color, 2);
        Agregar_Pieza(Tipo_Pieza.ALFIL, Color, 5);

        if(Color.equals(Tipo_Color.NEGRO))
        {
            Color = Tipo_Color.BLANCO;
        } else if (Color.equals(Tipo_Color.BLANCO)) {
            Color = Tipo_Color.NEGRO;
        }
        Agregar_Pieza(Tipo_Pieza.ALFIL, Color, 58);
        Agregar_Pieza(Tipo_Pieza.ALFIL, Color, 61);
    }


    private void Agregar_ReyReina(Tipo_Color Color)
    {
        Agregar_Pieza(Tipo_Pieza.REY, Color, 4);
        Agregar_Pieza(Tipo_Pieza.REINA, Color, 3);


        if(Color.equals(Tipo_Color.BLANCO))
        {
            Color = Tipo_Color.NEGRO;
        } else if (Color.equals(Tipo_Color.NEGRO)) {
            Color = Tipo_Color.BLANCO;
        }

        Agregar_Pieza(Tipo_Pieza.REY, Color, 60);
        Agregar_Pieza(Tipo_Pieza.REINA, Color, 59);
    }

    private void Agregar_Pieza(Tipo_Pieza Pieza, Tipo_Color Color, int i)
    {
        //Añadir piezas
        if(Color.equals(Tipo_Color.BLANCO))
        {
            if (Pieza.equals(Tipo_Pieza.PEON))
            {
                Peon pieza = new Peon(Color);
                JButton posicion = (JButton) panel_8x8.getComponent(i);
                posicion.setIcon(pieza.Check_Icon());
            }
            else if (Pieza.equals(Tipo_Pieza.TORRE))
            {
                Torre pieza = new Torre(Color);
                JButton posicion = (JButton) panel_8x8.getComponent(i);
                posicion.setIcon(pieza.Check_Icon());
            }
            else if (Pieza.equals(Tipo_Pieza.CABALLO))
            {
                Caballo pieza = new Caballo(Color);
                JButton posicion = (JButton) panel_8x8.getComponent(i);
                posicion.setIcon(pieza.Check_Icon());
            }
            else if (Pieza.equals(Tipo_Pieza.ALFIL))
            {
                Alfil pieza = new Alfil(Color);
                JButton posicion = (JButton) panel_8x8.getComponent(i);
                posicion.setIcon(pieza.Check_Icon());
            }
            else if (Pieza.equals(Tipo_Pieza.REY))
            {
                Rey pieza = new Rey(Color);
                JButton posicion = (JButton) panel_8x8.getComponent(i);
                posicion.setIcon(pieza.Check_Icon());
            }
            else if(Pieza.equals(Tipo_Pieza.REINA))
            {
                Reina pieza = new Reina(Color);
                JButton posicion = (JButton) panel_8x8.getComponent(i);
                posicion.setIcon(pieza.Check_Icon());
            }
        }
        else if (Color.equals(Tipo_Color.NEGRO))
        {
            if (Pieza.equals(Tipo_Pieza.PEON))
            {
                Peon pieza = new Peon(Color);
                JButton posicion = (JButton) panel_8x8.getComponent(i);
                posicion.setIcon(pieza.Check_Icon());
            }
            else if (Pieza.equals(Tipo_Pieza.TORRE))
            {
                Torre pieza = new Torre(Color);
                JButton posicion = (JButton) panel_8x8.getComponent(i);
                posicion.setIcon(pieza.Check_Icon());
            }
            else if (Pieza.equals(Tipo_Pieza.CABALLO))
            {
                Caballo pieza = new Caballo(Color);
                JButton posicion = (JButton) panel_8x8.getComponent(i);
                posicion.setIcon(pieza.Check_Icon());
            }
            else if (Pieza.equals(Tipo_Pieza.ALFIL))
            {
                Alfil pieza = new Alfil(Color);
                JButton posicion = (JButton) panel_8x8.getComponent(i);
                posicion.setIcon(pieza.Check_Icon());
            }
            else if (Pieza.equals(Tipo_Pieza.REY))
            {
                Rey pieza = new Rey(Color);
                JButton posicion = (JButton) panel_8x8.getComponent(i);
                posicion.setIcon(pieza.Check_Icon());
            }
            else if(Pieza.equals(Tipo_Pieza.REINA))
            {
                Reina pieza = new Reina(Color);
                JButton posicion = (JButton) panel_8x8.getComponent(i);
                posicion.setIcon(pieza.Check_Icon());
            }
        }
    }

    public void ActualizarTablero()
    {
        for (int i = 0; i < 64; i++)
        {
            JButton btn = (JButton) panel_8x8.getComponent(i);
            btn.setIcon(null);
        }

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if(Matriz_Tablero.getAjedrezTablero()[i][j] != null)
                {
                    Pieza _pieza = Matriz_Tablero.getAjedrezTablero()[i][j];

                    int index = (i*8)+j;

                    Agregar_Pieza(_pieza.getTipoPieza(), _pieza.getColor(), index);
                }
            }
        }
    }
}
