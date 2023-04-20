package Sprites;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class All_Sprites
{
    //Files
    //Blanco
    private File img_Blanco_Peon = new File("src/Sprites/W_Pawn.png");
    private File img_Blanco_Torre = new File("src/Sprites/W_Rook.png");
    private File img_Blanco_Caballo = new File("src/Sprites/W_Knight.png");
    private File img_Blanco_Alfil = new File("src/Sprites/W_Bishop.png");
    private File img_Blanco_Rey = new File("src/Sprites/W_King.png");
    private File img_Blanco_Reina = new File("src/Sprites/W_Queen.png");
    //Negro
    private File img_Negro_Peon = new File("src/Sprites/B_Pawn.png");
    private File img_Negro_Torre = new File("src/Sprites/B_Rook.png");
    private File img_Negro_Caballo = new File("src/Sprites/B_Knight.png");
    private File img_Negro_Alfil = new File("src/Sprites/B_Bishop.png");
    private File img_Negro_Rey = new File("src/Sprites/B_King.png");
    private File img_Negro_Reina = new File("src/Sprites/B_Queen.png");

    //Listas
    private ArrayList<String> lst_Sprite_direccion = new ArrayList<>();
    private ArrayList<File> lst_Sprite_File = new ArrayList<>();
    private ArrayList<Icon> lst_Sprite_Icon = new ArrayList<>();

    public All_Sprites(){
        //32 Pieza EN TOTAL
        //Direcciones 16 + 16 piezas
        //Blanco
        lst_Sprite_direccion.add("C:\\Users\\marti\\Desktop\\Alex TUP\\Materias\\Lab III\\Java Ej\\Ajedrez\\src\\Sprites\\W_Pawn.png");
        lst_Sprite_direccion.add("C:\\Users\\marti\\Desktop\\Alex TUP\\Materias\\Lab III\\Java Ej\\Ajedrez\\src\\Sprites\\W_Rook.png");
        lst_Sprite_direccion.add("C:\\Users\\marti\\Desktop\\Alex TUP\\Materias\\Lab III\\Java Ej\\Ajedrez\\src\\Sprites\\W_Knight.png");
        lst_Sprite_direccion.add("C:\\Users\\marti\\Desktop\\Alex TUP\\Materias\\Lab III\\Java Ej\\Ajedrez\\src\\Sprites\\W_Bishop.png");
        lst_Sprite_direccion.add("C:\\Users\\marti\\Desktop\\Alex TUP\\Materias\\Lab III\\Java Ej\\Ajedrez\\src\\Sprites\\W_King.png");
        lst_Sprite_direccion.add("C:\\Users\\marti\\Desktop\\Alex TUP\\Materias\\Lab III\\Java Ej\\Ajedrez\\src\\Sprites\\W_Queen.png");
        //Negro
        lst_Sprite_direccion.add("C:\\Users\\marti\\Desktop\\Alex TUP\\Materias\\Lab III\\Java Ej\\Ajedrez\\src\\Sprites\\B_Pawn.png");
        lst_Sprite_direccion.add("C:\\Users\\marti\\Desktop\\Alex TUP\\Materias\\Lab III\\Java Ej\\Ajedrez\\src\\Sprites\\B_Rook.png");
        lst_Sprite_direccion.add("C:\\Users\\marti\\Desktop\\Alex TUP\\Materias\\Lab III\\Java Ej\\Ajedrez\\src\\Sprites\\B_Knight.png");
        lst_Sprite_direccion.add("C:\\Users\\marti\\Desktop\\Alex TUP\\Materias\\Lab III\\Java Ej\\Ajedrez\\src\\Sprites\\B_Bishop.png");
        lst_Sprite_direccion.add("C:\\Users\\marti\\Desktop\\Alex TUP\\Materias\\Lab III\\Java Ej\\Ajedrez\\src\\Sprites\\B_King.png");
        lst_Sprite_direccion.add("C:\\Users\\marti\\Desktop\\Alex TUP\\Materias\\Lab III\\Java Ej\\Ajedrez\\src\\Sprites\\B_Queen.png");


        for (int i = 0; i < lst_Sprite_direccion.size(); i++)
        {
            File newArchivo = new File(lst_Sprite_direccion.get(i));
            lst_Sprite_File.add(newArchivo);
        }

        //Convertir a Icon todos los Files
        for (int i = 0; i < lst_Sprite_direccion.size(); i++)
        {
            for (int j = 0; j < lst_Sprite_File.size(); j++)
            {
                if (lst_Sprite_direccion.get(i).equals(lst_Sprite_File.get(j).getAbsolutePath()))
                {
                    Icon img = new ImageIcon(lst_Sprite_File.get(j).getAbsolutePath());

                    lst_Sprite_Icon.add(img);
                }
            }
        }
    }

    //GETS


    public ArrayList<String> getLst_Sprite_direccion() {
        return lst_Sprite_direccion;
    }

    public ArrayList<File> getLst_Sprite_File() {
        return lst_Sprite_File;
    }

    public ArrayList<Icon> getLst_Sprite_Icon() {
        return lst_Sprite_Icon;
    }

    //Gets
    //Blanco
    public File getImg_Blanco_Peon() {

        return img_Blanco_Peon;
    }
    public File getImg_Blanco_Torre() {
        return img_Blanco_Torre;
    }

    public File getImg_Blanco_Caballo() {
        return img_Blanco_Caballo;
    }

    public File getImg_Blanco_Alfil() {
        return img_Blanco_Alfil;
    }

    public File getImg_Blanco_Rey() {
        return img_Blanco_Rey;
    }

    public File getImg_Blanco_Reina() {
        return img_Blanco_Reina;
    }

    //Negro
    public File getImg_Negro_Peon() {

        return img_Negro_Peon;
    }

    public File getImg_Negro_Torre() {
        return img_Negro_Torre;
    }

    public File getImg_Negro_Caballo() {
        return img_Negro_Caballo;
    }

    public File getImg_Negro_Alfil() {
        return img_Negro_Alfil;
    }

    public File getImg_Negro_Rey() {
        return img_Negro_Rey;
    }

    public File getImg_Negro_Reina() {
        return img_Negro_Reina;
    }
}
