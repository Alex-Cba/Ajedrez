package Piezas;

import javax.swing.*;

public class Reina extends Peon{
    public Reina(String Color) {
        super(Color);
    }

    @Override
    public ImageIcon Check_Icon(){

        if(getSpr_pieza() == null) {
            if (getColor().equalsIgnoreCase("Blanco")) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Blanco_Reina()));
            } else if (getColor().equalsIgnoreCase("Negro")) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Negro_Reina()));
            }
        }

        return getSpr_pieza();
    }
}
