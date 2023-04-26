package Sprites;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class All_Sprites
{
    private static All_Sprites instance = null;

    //Files
    //Blanco
    private File file_Blanco_Peon = new File("src/Sprites/W_Pawn.png");
    private File file_Blanco_Torre = new File("src/Sprites/W_Rook.png");
    private File file_Blanco_Caballo = new File("src/Sprites/W_Knight.png");
    private File file_Blanco_Alfil = new File("src/Sprites/W_Bishop.png");
    private File file_Blanco_Rey = new File("src/Sprites/W_King.png");
    private File file_Blanco_Reina = new File("src/Sprites/W_Queen.png");
    //Negro
    private File file_Negro_Peon = new File("src/Sprites/B_Pawn.png");
    private File file_Negro_Torre = new File("src/Sprites/B_Rook.png");
    private File file_Negro_Caballo = new File("src/Sprites/B_Knight.png");
    private File file_Negro_Alfil = new File("src/Sprites/B_Bishop.png");
    private File file_Negro_Rey = new File("src/Sprites/B_King.png");
    private File file_Negro_Reina = new File("src/Sprites/B_Queen.png");

    //Listas
    private ArrayList<String> lst_Sprite_direccion = new ArrayList<>();
    private ArrayList<File> lst_Sprite_File = new ArrayList<>();
    private ArrayList<Icon> lst_Sprite_Icon = new ArrayList<>();

    private All_Sprites(){
        //32 Pieza EN TOTAL
        //Direcciones 16 + 16 piezas
        //Blanco
        lst_Sprite_direccion.add(file_Blanco_Peon.getAbsolutePath());
        lst_Sprite_direccion.add(file_Blanco_Torre.getAbsolutePath());
        lst_Sprite_direccion.add(file_Blanco_Caballo.getAbsolutePath());
        lst_Sprite_direccion.add(file_Blanco_Alfil.getAbsolutePath());
        lst_Sprite_direccion.add(file_Blanco_Rey.getAbsolutePath());
        lst_Sprite_direccion.add(file_Blanco_Reina.getAbsolutePath());
        //Negro
        lst_Sprite_direccion.add(file_Blanco_Peon.getAbsolutePath());
        lst_Sprite_direccion.add(file_Blanco_Torre.getAbsolutePath());
        lst_Sprite_direccion.add(file_Blanco_Caballo.getAbsolutePath());
        lst_Sprite_direccion.add(file_Blanco_Alfil.getAbsolutePath());
        lst_Sprite_direccion.add(file_Blanco_Rey.getAbsolutePath());
        lst_Sprite_direccion.add(file_Blanco_Reina.getAbsolutePath());


        for (int i = 0; i < lst_Sprite_direccion.size(); i++)
        {
            File newArchivo = new File(lst_Sprite_direccion.get(i));
            lst_Sprite_File.add(newArchivo);
        }

        //Convertir a Icon todos los Files
        for (int i = 0; i < lst_Sprite_direccion.size(); i++)
        {
            Icon img = new ImageIcon(lst_Sprite_File.get(i).getAbsolutePath());

            lst_Sprite_Icon.add(img);
        }
    }

    public static All_Sprites getInstance() {
        if (instance == null) {
            instance = new All_Sprites();
        }
        return instance;
    }

    //GETS
    public ArrayList<String> getLst_Sprite_direccion() {
        return lst_Sprite_direccion;
    }

    public ArrayList<File> getLst_Sprite_File() {return lst_Sprite_File;}

    public ArrayList<Icon> getLst_Sprite_Icon() {
        return lst_Sprite_Icon;
    }

    //Gets
    //Blanco
    public File getFile_Blanco_Peon() {return file_Blanco_Peon;}
    public File getFile_Blanco_Torre() {
        return file_Blanco_Torre;
    }

    public File getFile_Blanco_Caballo() {
        return file_Blanco_Caballo;
    }

    public File getFile_Blanco_Alfil() {
        return file_Blanco_Alfil;
    }

    public File getFile_Blanco_Rey() {
        return file_Blanco_Rey;
    }

    public File getFile_Blanco_Reina() {
        return file_Blanco_Reina;
    }

    //Negro
    public File getFile_Negro_Peon() {

        return file_Negro_Peon;
    }

    public File getFile_Negro_Torre() {
        return file_Negro_Torre;
    }

    public File getFile_Negro_Caballo() {
        return file_Negro_Caballo;
    }

    public File getFile_Negro_Alfil() {
        return file_Negro_Alfil;
    }

    public File getFile_Negro_Rey() {
        return file_Negro_Rey;
    }

    public File getFile_Negro_Reina() {
        return file_Negro_Reina;
    }
}
