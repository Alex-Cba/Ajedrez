package Piezas;

import javax.swing.*;

public class Rey extends Peon{
    public Rey(String Color) {
        super(Color);
    }

    @Override
    public ImageIcon Check_Icon(){

        if(getSpr_pieza() == null) {
            if (getColor().equalsIgnoreCase("Blanco")) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Blanco_Rey()));
            } else if (getColor().equalsIgnoreCase("Negro")) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Negro_Rey()));
            }
        }

        return getSpr_pieza();
    }
}
