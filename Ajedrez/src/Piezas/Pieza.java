package Piezas;

import Piezas.Enums.Direction;
import Piezas.Enums.Tipo_Color;
import Piezas.Enums.Tipo_Pieza;
import Sprites.All_Sprites;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Pieza implements Cloneable
{
    protected Tipo_Color color;
    private ImageIcon spr_pieza;
    private All_Sprites _All_Sprite = All_Sprites.getInstance();
    private Tipo_Pieza tipoPieza;
    private int fila;
    private int columna;

    //Gets y set
    public Tipo_Color getColor(){
        return color;
    }
    protected void setColor(Tipo_Color _color){color = _color;}
    protected ImageIcon getSpr_pieza() {return spr_pieza;}
    public void setSpr_pieza(ImageIcon spr){spr_pieza = spr;}
    public All_Sprites get_All_Sprite(){return _All_Sprite;}
    public Tipo_Pieza getTipoPieza(){return tipoPieza;}
    protected void setTipoPieza(Tipo_Pieza _tipopieza){tipoPieza = _tipopieza;}
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    //Constructor
    public Pieza(Tipo_Color Color)
    {
        color = Color;
    }
    public Pieza(){}

    //Check Si ya tiene o no el sprite la clase
    public ImageIcon Check_Icon(){
        return null;
    }

    //Sprite
    protected ImageIcon Sprite(File imgArchivo)
    {
        ImageIcon _sprite = new ImageIcon();

        if(color.equals(Tipo_Color.BLANCO))
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
        else if (color.equals(Tipo_Color.NEGRO))
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
    public HashMap<Direction, Integer> Mov_Pieza(){
        return null;
    }

    @Override
    public Pieza clone() throws CloneNotSupportedException {
        Pieza clonedPiece = (Pieza) super.clone();
        if (spr_pieza != null) {
            clonedPiece.spr_pieza = new ImageIcon(spr_pieza.getImage());
        }
        clonedPiece.tipoPieza = tipoPieza;
        clonedPiece.fila = fila;
        clonedPiece.columna = columna;
        return clonedPiece;
    }

}
