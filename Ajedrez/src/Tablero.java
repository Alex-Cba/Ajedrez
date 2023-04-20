import Piezas.*;
import Sprites.All_Sprites;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tablero extends JFrame
{
    private JFrame ventana;
    private Color t_colorBrown = new Color(0, 0, 0,255);
    private Color t_colorLightBrown = new Color(248, 248, 248,255);
    private JPanel panel_8x8 = new JPanel(new GridLayout(8, 8));
    private All_Sprites _All_Sprites = new All_Sprites();

    private vTablero Matriz_Tablero = new vTablero("Blanco");
        public Tablero()
        {
            ventana = this;
            ventana.setTitle("Tablero de Ajedrez");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(512, 512);
            ventana.setLocationRelativeTo(null);
            for (int i = 0; i < 64; i++)
            {

                JButton button = new JButton();

                //Fila
                if ((i / 8) % 2 == 0)
                {
                    //Columna
                    button.setBackground(i % 2 == 0 ? t_colorLightBrown : t_colorBrown);
                }
                else
                {
                    //Columna
                    button.setBackground(i % 2 == 0 ? t_colorBrown : t_colorLightBrown);
                }

                //Se le añade a cada boton, para que espere un click
                button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        //Funcionalidad al clickear

                        JButton btn_actual = (JButton) e.getSource();

                        if(btn_actual.getIcon() == null)
                        {

                        }
                        else if (btn_actual.getIcon() != null)
                        {
                            // Obtener la posición del botón dentro del panel
                            Component[] componentes = panel_8x8.getComponents();
                            int lugar = -1;
                            for (int i = 0; i < componentes.length; i++) {
                                if (componentes[i].equals(btn_actual)) {
                                    lugar = i;
                                    break;
                                }
                            }

                            //Obtener fila y columna

                            int fila=0, columna=0;
                            fila = (lugar / 8);
                            columna = (lugar % 8);
                            btn_actual.getIcon();


                            System.out.println("Botón clickeado en posición " + lugar + "||| intentado: " + fila + " " + columna);


                            if(((Peon) Matriz_Tablero.getVTablero()[fila][columna]).getColor().equalsIgnoreCase("Negro"))
                            {

                                if (Matriz_Tablero.getVTablero()[fila][columna] instanceof Peon)
                                {
                                }
                                else if (Matriz_Tablero.getVTablero()[fila][columna] instanceof Torre)
                                {
                                }
                                else if (Matriz_Tablero.getVTablero()[fila][columna] instanceof Caballo)
                                {
                                }
                                else if (Matriz_Tablero.getVTablero()[fila][columna] instanceof Alfil)
                                {
                                }
                                else if (Matriz_Tablero.getVTablero()[fila][columna] instanceof Rey)
                                {
                                }
                                else if (Matriz_Tablero.getVTablero()[fila][columna] instanceof Reina)
                                {
                                }
                            }
                            else if(((Peon) Matriz_Tablero.getVTablero()[fila][columna]).getColor().equalsIgnoreCase("Blanco"))
                            {

                                if (Matriz_Tablero.getVTablero()[fila][columna] instanceof Peon)
                                {
                                }
                                else if (Matriz_Tablero.getVTablero()[fila][columna] instanceof Torre)
                                {
                                }
                                else if (Matriz_Tablero.getVTablero()[fila][columna] instanceof Caballo)
                                {
                                }
                                else if (Matriz_Tablero.getVTablero()[fila][columna] instanceof Alfil)
                                {
                                }
                                else if (Matriz_Tablero.getVTablero()[fila][columna] instanceof Rey)
                                {
                                }
                                else if (Matriz_Tablero.getVTablero()[fila][columna] instanceof Reina)
                                {
                                }
                            }
                        }
                    }
                });

                panel_8x8.add(button);
            }

            //Agregado de piezas
            Agregar_AllPeones();
            Agregar_AllTorres();
            Agregar_AllCaballos();
            Agregar_Alfiles();
            Agregar_ReyReina();
        }

        private void Agregar_AllPeones()
        {
            String Color = "Blanco";
            int _inicio = 8;
            int _final = 16;
            for (int c = 0; c < 2; c++) //Blanco y Negro 2 vueltas
            {
                //Agregar Peones
                for (int i = _inicio; i < _final; i++)
                {
                    Agregar_Pieza("Peon", Color, i);
                }


                Color = "Negro";
                _inicio = 48;
                _final = 56;
            }

            add(panel_8x8);
        }

        private void Agregar_AllTorres()
        {
            String Color = "Blanco";

            Agregar_Pieza("Torre", Color, 0);
            Agregar_Pieza("Torre", Color, 7);

            Color = "Negro";
            Agregar_Pieza("Torre", Color, 56);
            Agregar_Pieza("Torre", Color, 63);

            add(panel_8x8);
        }

        private void Agregar_AllCaballos()
        {
            String Color = "Blanco";

            Agregar_Pieza("Caballo", Color, 1);
            Agregar_Pieza("Caballo", Color, 6);

            Color = "Negro";
            Agregar_Pieza("Caballo", Color, 57);
            Agregar_Pieza("Caballo", Color, 62);

            add(panel_8x8);
        }

        private void Agregar_Alfiles()
        {
            String Color = "Blanco";

            Agregar_Pieza("Alfil", Color, 2);
            Agregar_Pieza("Alfil", Color, 5);

            Color = "Negro";
            Agregar_Pieza("Alfil", Color, 58);
            Agregar_Pieza("Alfil", Color, 61);

            add(panel_8x8);
        }


        private void Agregar_ReyReina()
        {
            String Color = "Blanco";
            Agregar_Pieza("Rey", Color, 3);
            Agregar_Pieza("Reina", Color, 4);

            Color = "Negro";
            Agregar_Pieza("Rey", Color, 60);
            Agregar_Pieza("Reina", Color, 59);

            add(panel_8x8);
        }

        private void Agregar_Pieza(String Pieza, String Color, int i)
        {
            //Añadir piezas
            if(Color.equalsIgnoreCase("Blanco"))
            {
                if (Pieza.equalsIgnoreCase("Peon"))
                {
                    Peon pieza = new Peon(Color);
                    JButton posicion = (JButton) panel_8x8.getComponent(i);
                    posicion.setIcon(pieza.Sprite(_All_Sprites.getImg_Blanco_Peon()));
                }
                else if (Pieza.equalsIgnoreCase("Torre"))
                {
                    Torre pieza = new Torre(Color);
                    JButton posicion = (JButton) panel_8x8.getComponent(i);
                    posicion.setIcon(pieza.Sprite(_All_Sprites.getImg_Blanco_Torre()));
                }
                else if (Pieza.equalsIgnoreCase("Caballo"))
                {
                    Caballo pieza = new Caballo(Color);
                    JButton posicion = (JButton) panel_8x8.getComponent(i);
                    posicion.setIcon(pieza.Sprite(_All_Sprites.getImg_Blanco_Caballo()));
                }
                else if (Pieza.equalsIgnoreCase("Alfil"))
                {
                    Alfil pieza = new Alfil(Color);
                    JButton posicion = (JButton) panel_8x8.getComponent(i);
                    posicion.setIcon(pieza.Sprite(_All_Sprites.getImg_Blanco_Alfil()));
                }
                else if (Pieza.equalsIgnoreCase("Rey"))
                {
                    Rey pieza = new Rey(Color);
                    JButton posicion = (JButton) panel_8x8.getComponent(i);
                    posicion.setIcon(pieza.Sprite(_All_Sprites.getImg_Blanco_Rey()));
                }
                else if(Pieza.equalsIgnoreCase("Reina"))
                {
                    Reina pieza = new Reina(Color);
                    JButton posicion = (JButton) panel_8x8.getComponent(i);
                    posicion.setIcon(pieza.Sprite(_All_Sprites.getImg_Blanco_Reina()));
                }
            }
            else if (Color.equalsIgnoreCase("Negro"))
            {
                if (Pieza.equalsIgnoreCase("Peon"))
                {
                    Peon pieza = new Peon(Color);
                    JButton posicion = (JButton) panel_8x8.getComponent(i);
                    posicion.setIcon(pieza.Sprite(_All_Sprites.getImg_Negro_Peon()));
                }
                else if (Pieza.equalsIgnoreCase("Torre"))
                {
                    Torre pieza = new Torre(Color);
                    JButton posicion = (JButton) panel_8x8.getComponent(i);
                    posicion.setIcon(pieza.Sprite(_All_Sprites.getImg_Negro_Torre()));
                }
                else if (Pieza.equalsIgnoreCase("Caballo"))
                {
                    Caballo pieza = new Caballo(Color);
                    JButton posicion = (JButton) panel_8x8.getComponent(i);
                    posicion.setIcon(pieza.Sprite(_All_Sprites.getImg_Negro_Caballo()));
                }
                else if (Pieza.equalsIgnoreCase("Alfil"))
                {
                    Alfil pieza = new Alfil(Color);
                    JButton posicion = (JButton) panel_8x8.getComponent(i);
                    posicion.setIcon(pieza.Sprite(_All_Sprites.getImg_Negro_Alfil()));
                }
                else if (Pieza.equalsIgnoreCase("Rey"))
                {
                    Rey pieza = new Rey(Color);
                    JButton posicion = (JButton) panel_8x8.getComponent(i);
                    posicion.setIcon(pieza.Sprite(_All_Sprites.getImg_Negro_Rey()));
                }
                else if(Pieza.equalsIgnoreCase("Reina"))
                {
                    Reina pieza = new Reina(Color);
                    JButton posicion = (JButton) panel_8x8.getComponent(i);
                    posicion.setIcon(pieza.Sprite(_All_Sprites.getImg_Negro_Reina()));
                }
            }
        }

        //Agregar Sprite
        public void Agregar_Sprite(int fila, int columna, Peon _Peon)
        {
            JButton posicion = (JButton) panel_8x8.getComponent((fila * 8) + columna);
            posicion.setIcon(_Peon.Sprite(_All_Sprites.getImg_Blanco_Peon()));
        }

        //Quitar Sprite
        public void Quitar_Sprite(int fila, int columna)
        {
            JButton posicion = (JButton) panel_8x8.getComponent((fila * 8) + columna);
            posicion.setIcon(null);
        }

}
