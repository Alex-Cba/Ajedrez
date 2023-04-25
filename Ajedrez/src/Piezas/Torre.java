package Piezas;

import javax.swing.*;

public class Torre extends Peon
{
    public Torre(String Color) {
        super(Color);
    }

    @Override
    public ImageIcon Check_Icon(){

        if(getSpr_pieza() == null) {
            if (getColor().equalsIgnoreCase("Blanco")) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Blanco_Torre()));
            } else if (getColor().equalsIgnoreCase("Negro")) {
                setSpr_pieza(Sprite(get_All_Sprite().getFile_Negro_Torre()));
            }
        }

        return getSpr_pieza();
    }
}
