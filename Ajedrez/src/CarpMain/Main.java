package CarpMain;

import javax.swing.*;

import Tablero.*;

import java.util.Scanner;

public class Main {
    private static Tablero2 _tablero = new Tablero2();
    private static Scanner sc = new Scanner(System.in);
    private static boolean valorValido = true;
    public static ControladorTurno ctrl_turno = new ControladorTurno();
    public static void main(String[] args) throws CloneNotSupportedException {

        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run() {
                _tablero.setVisible(true);
            };
        });

            while(valorValido) {



                System.out.println("Ingrese la coordenada de la pieza que desea mover");
                System.out.println("Fila: ");
                String Fila = sc.nextLine();
                System.out.println("Columna: ");
                String Columna = sc.nextLine();
                valorValido = piezaAMover(Fila, Columna);
                if(valorValido) {

                    vTablero TableroVirtual = _tablero.getMatriz_Tablero();

                    Integer FilaInt = Integer.parseInt(Fila);
                    Integer ColumnaInt = Integer.parseInt(Columna);

                    if(_tablero.getMatriz_Tablero().getAjedrezTablero()[FilaInt][ColumnaInt] != null) {
                        if(TableroVirtual.getAjedrezTablero()[FilaInt][ColumnaInt].getColor().equals(ctrl_turno.getTurnoActual())) {
                            TableroVirtual.MoverPieza(FilaInt, ColumnaInt);

                            _tablero.ActualizarTablero();
                        }
                        else{
                            System.out.println("No es el turno de esta ficha. Turno Actual: " + ctrl_turno.getTurnoActual());
                        }
                    }
                    else{
                        System.out.println("La casilla que selecciono esta vacia!");
                    }
                }else
                {
                    System.out.println("Ingrese valores válidos por favor!");
                    valorValido = true;
                }
            }
    }
    private static boolean piezaAMover(String fila, String columna)
    {
        try {
            Integer filaNum = Integer.parseInt(fila);
            Integer columnaNum = Integer.parseInt(columna);
            if(filaNum < 8 && filaNum > -1 && columnaNum < 8 && columnaNum > -1)
            {
                return true;
            }
            return false;
        }catch(NumberFormatException e){

            return false;
    }

    }
}