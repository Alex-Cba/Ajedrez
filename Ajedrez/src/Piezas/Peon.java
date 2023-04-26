package Piezas;

import Sprites.All_Sprites;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static Tablero.Tablero.orden_Piezas;

public class Peon
{
    private String color;
    private ImageIcon spr_pieza = null;
    private All_Sprites _All_Sprite = All_Sprites.getInstance();

    //Gets y set
    public String getColor(){
        return color;
    }
    protected void setColor(String _color){color = _color;}
    protected ImageIcon getSpr_pieza() {return spr_pieza;}
    public void setSpr_pieza(ImageIcon spr){spr_pieza = spr;}

    public All_Sprites get_All_Sprite(){return _All_Sprite;}

    //Constructor
    public Peon(String Color)
    {
        color = Color;
    }

    //Check Si ya tiene o no el sprite la clase
    public ImageIcon Check_Icon(){

        if(spr_pieza == null) {
            if (color.equalsIgnoreCase("Blanco")) {
                spr_pieza = Sprite(_All_Sprite.getFile_Blanco_Peon());
            } else if (color.equalsIgnoreCase("Negro")) {
                spr_pieza = Sprite(_All_Sprite.getFile_Negro_Peon());
            }
        }

        return spr_pieza;
    }
    //Sprite
    protected ImageIcon Sprite(File imgArchivo)
    {
        ImageIcon _sprite = new ImageIcon();

        if(color.equalsIgnoreCase("Blanco"))
        {
            Image img = null;

            //el metodo read de ImageIO, necesita ir dentro de un bloque try-catch por que no puede colocar una imagen null
            try {

                img = ImageIO.read(imgArchivo);

            } catch (IOException e) {

                throw new RuntimeException(e);
            }

            _sprite.setImage(img);
        }
        else if (color.equalsIgnoreCase("Negro"))
        {
            Image img = null;

            //el metodo read de ImageIO, necesita ir dentro de un bloque try-catch por que no puede colocar una imagen null
            try {

                img = ImageIO.read(imgArchivo);

            } catch (IOException e) {

                throw new RuntimeException(e);
            }

            _sprite.setImage(img);
        }

        Image _Spr_Pieza = _sprite.getImage().getScaledInstance(32, 42, Image.SCALE_SMOOTH);

        ImageIcon img_return = new ImageIcon(_Spr_Pieza);

        return img_return;
    }

    //Movimiento -Pruebas Alex
    public int Mov_Pieza(){
        int num_mov = 0;

        if(orden_Piezas.equalsIgnoreCase("Abajo_Blancas")){
            if(color.equalsIgnoreCase("Blanco"))
            {
                //Aprender a usar MAP y hashMAP
            }
        }
        else if(orden_Piezas.equalsIgnoreCase("Arriba_Blancas"))
        {
            if(color.equalsIgnoreCase("Negro"))
            {
            }
        }

        return num_mov;
    }
}
