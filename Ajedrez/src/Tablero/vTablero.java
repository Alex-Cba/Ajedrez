package Tablero;

import Piezas.*;

public class vTablero
{
    private Object [] [] vTablero = new Object[8][8];

    //Setear posiciónes iniciales
    //Chequear repartición J1 y J2 - J1 abajo
    public vTablero(String J1)
    {

        if(J1.equalsIgnoreCase("Blanco")) //Blancas abajo
        {
            String Color = "Negro";

            Cargar_Arriba_Matriz(Color);

            Color = "Blanco";

            Cargar_Abajo_Matriz(Color);


        } else if (J1.equalsIgnoreCase("Negro"))  //Negras abajo
        {
            String Color = "Blanco";

            Cargar_Arriba_Matriz(Color);

            Color = "Negro";

            Cargar_Abajo_Matriz(Color);

        }
    }

    //Gets
    public Object[][] getVTablero() {
        return vTablero;
    }

    public void Cargar_Arriba_Matriz(String Color)
    {
        //Negro
        //Peones
        for (int j = 0; j <= 7; j++) {

            Peon Peon = new Peon(Color);

            vTablero[6][j] = Peon;
        }

        //Torre
        Torre _Torre1 = new Torre(Color);
        Torre _Torre2 = new Torre(Color);

        vTablero[7][0] = _Torre1;
        vTablero[7][7] = _Torre2;

        //Caballo
        Caballo _Caballo1 = new Caballo(Color);
        Caballo _Caballo2 = new Caballo(Color);

        vTablero[7][1] = _Caballo1;
        vTablero[7][6] = _Caballo2;

        //Alfil
        Alfil _Alfil1 = new Alfil(Color);
        Alfil _Alfil2 = new Alfil(Color);

        vTablero[7][2] = _Alfil1;
        vTablero[7][5] = _Alfil2;

        //Rey y reina
        Rey _Rey = new Rey(Color);
        Reina _Reina = new Reina(Color);

        vTablero[7][4] = _Rey;
        vTablero[7][3] = _Reina;

    }

    public void Cargar_Abajo_Matriz(String Color)
    {
        //Blanco
        //Peones
        for (int i = 0; i <= 7; i++) {

            Peon Peon = new Peon(Color);

            vTablero[1][i] = Peon;
        }

        //Torre
        Torre _Torre1 = new Torre(Color);
        Torre _Torre2 = new Torre(Color);

        vTablero[0][0] = _Torre1;
        vTablero[0][7] = _Torre2;

        //Caballo
        Caballo _Caballo1 = new Caballo(Color);
        Caballo _Caballo2 = new Caballo(Color);

        vTablero[0][1] = _Caballo1;
        vTablero[0][6] = _Caballo2;

        //Alfiles
        Alfil _Alfil1 = new Alfil(Color);
        Alfil _Alfil2 = new Alfil(Color);

        vTablero[0][2] = _Alfil1;
        vTablero[0][5] = _Alfil2;

        //Rey y reina
        Rey _Rey = new Rey(Color);
        Reina _Reina = new Reina(Color);

        vTablero[0][3] = _Rey;
        vTablero[0][4] = _Reina;
    }


}
