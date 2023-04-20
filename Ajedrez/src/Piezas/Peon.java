package Piezas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Peon
{
    private String color;
    private ImageIcon Spr_Peon = new ImageIcon();

    public String getColor(){
        return color;
    }

    public Peon(String Color)
    {
        color = Color;
    }

    //Sprite
    public ImageIcon Sprite(File imgArchivo)
    {
        //Cargar Sprites
        if(color.equalsIgnoreCase("Blanco"))
        {
            //el metodo read de ImageIO, necesita ir dentro de un bloque try-catch por que no puede colocar una imagen null
            Image img = null;

            try {

                img = ImageIO.read(imgArchivo);

            } catch (IOException e) {

                throw new RuntimeException(e);
            }

            Spr_Peon.setImage(img);
        }
        else if (color.equalsIgnoreCase("Negro"))
        {

            //el metodo read de ImageIO, necesita ir dentro de un bloque try-catch por que no puede colocar una imagen null
            Image img = null;

            try {

                img = ImageIO.read(imgArchivo);

            } catch (IOException e) {

                throw new RuntimeException(e);
            }

            Spr_Peon.setImage(img);
        }

        Image _Spr_Peon = Spr_Peon.getImage().getScaledInstance(32, 42, Image.SCALE_SMOOTH);
        ImageIcon Spr_Peon_Convert = new ImageIcon(_Spr_Peon);


        return Spr_Peon_Convert;
    }
}
