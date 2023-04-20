import Piezas.Peon;

public class vTablero
{
    private Object [] [] vTablero = new Object[8][8];

    //Setear posiciónes iniciales
    //Chequear repartición J1 y J2 - J1 abajo
    public vTablero(String J1)
    {
        Peon Peon1 = new Peon("Blanco");
        Peon Peon2 = new Peon("Negro");

        if(J1.equalsIgnoreCase("Blanco")) //Blancas abajo
        {
            vTablero[3][1] = Peon1;
            vTablero[6][1] = Peon2;

        } else if (J1.equalsIgnoreCase("Negro"))  //Negras abajo
        {

        }
    }

    //Gets
    public Object[][] getVTablero() {
        return vTablero;
    }


}
