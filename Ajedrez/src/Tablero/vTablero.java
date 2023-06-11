package Tablero;

import CarpMain.Main;
import Piezas.*;
import Piezas.Enums.Direction;
import Piezas.Enums.EstadosPartida;
import Piezas.Enums.Tipo_Color;
import Piezas.Enums.Tipo_Pieza;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.List;

public class vTablero
{
    // region Atributos
    private static vTablero instance = null;
    private Pieza [] [] AjedrezTablero = new Pieza[8][8];
    private String orden="";
    private Scanner sc = new Scanner(System.in);

    private EstadosPartida _EstadoDePartida;

    //Gets
    public Pieza[][] getAjedrezTablero(){return AjedrezTablero;}
    public String getOrden(){return orden;}
    // endregion

    // region Constructor
    private vTablero(String J1)
    {
        orden = J1;
        _EstadoDePartida = EstadosPartida.ENCURSO;

        if(J1.equalsIgnoreCase("Abajo_Blancas")) //Blancas abajo
        {
            Tipo_Color Color = Tipo_Color.NEGRO;

            Cargar_Arriba_Matriz(Color);

            Color = Tipo_Color.BLANCO;

            Cargar_Abajo_Matriz(Color);


        } else if (J1.equalsIgnoreCase("Arriba_Blancas"))  //Negras abajo
        {
            Tipo_Color Color = Tipo_Color.BLANCO;

            Cargar_Arriba_Matriz(Color);

            Color = Tipo_Color.NEGRO;

            Cargar_Abajo_Matriz(Color);

        }

        ActualizarPosiciones();
    }

    // endregion

    // region Singleton
    public static vTablero getInstance(String J1) {
        if (instance == null) {
            instance = new vTablero(J1);
        }
        return instance;
    }
    // endregion

    // region Carga de Matriz

    public void Cargar_Abajo_Matriz(Tipo_Color Color)
    {
        /*
        //Negro
        //Peones
        for (int j = 0; j <= 7; j++) {

            Peon Peon = new Peon(Color);

            AjedrezTablero[6][j] = Peon;
        }

         */

        //Torre
        Torre _Torre1 = new Torre(Color);
        Torre _Torre2 = new Torre(Color);

        AjedrezTablero[7][0] = _Torre1;
        AjedrezTablero[7][7] = _Torre2;

        /*
        //Caballo
        Caballo _Caballo1 = new Caballo(Color);
        Caballo _Caballo2 = new Caballo(Color);

        AjedrezTablero[7][1] = _Caballo1;
        AjedrezTablero[7][6] = _Caballo2;

        //Alfil
        Alfil _Alfil1 = new Alfil(Color);
        Alfil _Alfil2 = new Alfil(Color);

        AjedrezTablero[7][2] = _Alfil1;
        AjedrezTablero[7][5] = _Alfil2;

         */

        //Rey y reina
        Rey _Rey = new Rey(Color);
        Reina _Reina = new Reina(Color);

        AjedrezTablero[7][4] = _Rey;
        AjedrezTablero[7][3] = _Reina;

    }

    public void Cargar_Arriba_Matriz(Tipo_Color Color)
    {
        /*
        //Blanco
        //Peones
        for (int i = 0; i <= 7; i++) {

            Peon Peon = new Peon(Color);

            AjedrezTablero[1][i] = Peon;
        }

         */

        //Torre
        Torre _Torre1 = new Torre(Color);
        Torre _Torre2 = new Torre(Color);

        AjedrezTablero[0][0] = _Torre1;
        AjedrezTablero[0][7] = _Torre2;
        /*

        //Caballo
        Caballo _Caballo1 = new Caballo(Color);
        Caballo _Caballo2 = new Caballo(Color);

        AjedrezTablero[0][1] = _Caballo1;
        AjedrezTablero[0][6] = _Caballo2;

        //Alfiles
        Alfil _Alfil1 = new Alfil(Color);
        Alfil _Alfil2 = new Alfil(Color);

        AjedrezTablero[0][2] = _Alfil1;
        AjedrezTablero[0][5] = _Alfil2;

         */

        //Rey y reina
        Rey _Rey = new Rey(Color);
        Reina _Reina = new Reina(Color);

        AjedrezTablero[0][4] = _Rey;
        AjedrezTablero[0][3] = _Reina;
    }

    // endregion

    //Logica de Ajedrez en consola

    // region Actualizar Posiciones
    private void ActualizarPosiciones(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pieza pieza = AjedrezTablero[i][j];
                if(pieza != null){
                    pieza.setFila(i);
                    pieza.setColumna(j);
                }
            }
        }
    }
    // endregion

    public void MoverPieza(int fila, int columna) throws CloneNotSupportedException {
        Pieza _pieza = AjedrezTablero[fila][columna];
        ArrayList<String> PosiblesMovs = CalcularPosiblesMovs(_pieza, fila, columna, AjedrezTablero);

        MostrarMovimientos(PosiblesMovs);
        boolean bandera = true;

        //¿A Donde quiere mover la pieza?
        while(bandera) {
            System.out.println("Donde quiere mover la pieza?");
            System.out.println("Fila:");
            String MovFila = sc.nextLine();
            System.out.println("Columna:");
            String MovColumna = sc.nextLine();
            if (DondeMoverValido(MovFila, MovColumna)) {
                Integer movimientoFila = Integer.parseInt(MovFila);
                Integer movimientoColumna = Integer.parseInt(MovColumna);
                boolean movimientoValido = MovimientoValido(movimientoFila, movimientoColumna, PosiblesMovs);

                boolean checkVictoria = verificarVictoria();

                if (!checkVictoria) {
                    if (_EstadoDePartida.equals(EstadosPartida.ENCURSO) && movimientoValido) {
                        if(!CheckAutoJaque(_pieza, movimientoFila, movimientoColumna)) {
                            ConfirmarMovimiento(fila, columna, movimientoFila, movimientoColumna, _pieza);
                        }
                        else{
                            System.out.println("No puede realizar ese movimiento, seria un autojaque");
                        }

                    } else if (_EstadoDePartida.equals(EstadosPartida.JAQUE) && movimientoValido) {
                        boolean check = CheckSigueEnJaque(_pieza, movimientoFila, movimientoColumna);

                        if (!check) {
                            ConfirmarMovimiento(fila, columna, movimientoFila, movimientoColumna, _pieza);
                        } else {
                            System.out.println("El movimiento es invalido, el rey sigue en jaque");
                        }
                    } else {
                        System.out.println("El movimiento es invalido");
                    }

                    bandera = false;

                } else if (checkVictoria) {
                    ConfirmarMovimiento(fila, columna, movimientoFila, movimientoColumna, _pieza);
                    System.out.println("Jaque mate");

                    bandera = false;
                } else {
                    System.out.println("Fallo en condición de victoria");
                }
            }
            else {
                System.out.println("Ingrese un movimiento válido!\n");
            }
        }
    }

    // region Confirmar Movimiento
    private void ConfirmarMovimiento(int fila, int columna, Integer movimientoFila, Integer movimientoColumna, Pieza _pieza) {
        AjedrezTablero[fila][columna] = null;
        AjedrezTablero[movimientoFila][movimientoColumna] = _pieza;

        EstadoDeJaque(AjedrezTablero, EncontraReyContrario(AjedrezTablero));

        ActualizarPosiciones();
        Main.ctrl_turno.CambiarTurno();
    }
    //endregion

    // region Movimiento valido
    private boolean MovimientoValido(int fila, int columna, ArrayList<String> PosiblesMovs)
    {
        boolean retorno = false;

        if(PosiblesMovs.size() > 0) {

            List<String> AllMovs = new ArrayList<>();
            List<Integer> Fila = new ArrayList<>();
            List<Integer> Columna = new ArrayList<>();

            for (int i = 0; i < PosiblesMovs.size(); i++) {
                String[] movs = PosiblesMovs.get(i).split(" ");
                Collections.addAll(AllMovs, movs);
            }

            for (int i = 0; i < AllMovs.size(); i++) {
                if (i % 2 == 0) {
                    Integer NuevaFila = Integer.parseInt(AllMovs.get(i));
                    Fila.add(NuevaFila);
                } else {
                    Integer NuevaColumna = Integer.parseInt(AllMovs.get(i));
                    Columna.add(NuevaColumna);
                }
            }

            //Movimiento valido!
            for (int i = 0; i < Fila.size(); i++) {
                if (Fila.get(i) == fila) {
                    for (int j = 0; j < Columna.size(); j++) {
                        if (Columna.get(i) == columna) {
                            retorno = true;
                            break;
                        }
                    }
                }
            }
        }
        else{
            System.out.println("Posibles movimientos, esta vacia");
        }

        return retorno;
    }

    // endregion

    // region Calculo de movimientos

    private ArrayList<String> CalcularPosiblesMovs(Pieza _pieza, int fila, int columna, Pieza[][] tablero){
        ArrayList<String> lst_Retorno = new ArrayList<>();//Primero FILA y Segundo COLUMNA
        HashMap<Direction, Integer> Movimiento = _pieza.Mov_Pieza();
        int newfila = -1;
        int newcolumna = -1;

        if(_pieza instanceof Caballo)
        {
            if(Movimiento.containsKey(Direction.TOPLEFT))
            {
                newfila = fila - 2;
                newcolumna = columna - 1;
                if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1)
                {
                    if(tablero[newfila][newcolumna] == null
                        || !tablero[newfila][newcolumna].getColor().equals(_pieza.getColor()))
                    {
                        lst_Retorno.add(newfila + " " + newcolumna);
                    }
                }

            }
            if(Movimiento.containsKey(Direction.TOP))
            {
                newfila = fila - 2;
                newcolumna = columna + 1;
                if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1)
                {
                    if(tablero[newfila][newcolumna] == null
                            || !tablero[newfila][newcolumna].getColor().equals(_pieza.getColor())) {
                        lst_Retorno.add(newfila + " " + newcolumna);
                    }
                }

            }
            if(Movimiento.containsKey(Direction.TOPRIGHT))
            {
                newfila = fila - 1;
                newcolumna = columna + 2;
                if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1)
                {
                    if(tablero[newfila][newcolumna] == null
                            || !tablero[newfila][newcolumna].getColor().equals(_pieza.getColor())) {
                        lst_Retorno.add(newfila + " " + newcolumna);
                    }
                }

            }
            if(Movimiento.containsKey(Direction.RIGHT))
            {
                newfila = fila + 1;
                newcolumna = columna + 2;
                if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1)
                {
                    if(tablero[newfila][newcolumna] == null
                            || !tablero[newfila][newcolumna].getColor().equals(_pieza.getColor())) {
                        lst_Retorno.add(newfila + " " + newcolumna);
                    }
                }

            }
            if(Movimiento.containsKey(Direction.BOTTOMRIGHT))
            {
                newfila = fila + 2;
                newcolumna = columna + 1;
                if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1)
                {
                    if(tablero[newfila][newcolumna] == null
                            || !tablero[newfila][newcolumna].getColor().equals(_pieza.getColor())) {
                        lst_Retorno.add(newfila + " " + newcolumna);
                    }
                }

            }
            if(Movimiento.containsKey(Direction.BOTTOM))
            {
                newfila = fila + 2;
                newcolumna = columna - 1;
                if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1)
                {
                    if(tablero[newfila][newcolumna] == null
                            || !tablero[newfila][newcolumna].getColor().equals(_pieza.getColor())) {
                        lst_Retorno.add(newfila + " " + newcolumna);
                    }
                }

            }
            if(Movimiento.containsKey(Direction.BOTTOMLEFT))
            {
                newfila = fila + 1;
                newcolumna = columna - 2;
                if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1)
                {
                    if(tablero[newfila][newcolumna] == null
                            || !tablero[newfila][newcolumna].getColor().equals(_pieza.getColor())) {
                        lst_Retorno.add(newfila + " " + newcolumna);
                    }
                }

            }
            if(Movimiento.containsKey(Direction.LEFT))
            {
                newfila = fila - 1;
                newcolumna = columna + 2;
                if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1)
                {
                    if(tablero[newfila][newcolumna] == null
                            || !tablero[newfila][newcolumna].getColor().equals(_pieza.getColor())) {
                        lst_Retorno.add(newfila + " " + newcolumna);
                    }
                }
            }

        }
        /*****PEON*****/
        else if (_pieza instanceof Peon) {

            if (Movimiento.containsKey(Direction.TOP)) {
                //Restar la fila porque el movimiento es hacia arriba
                for (int i = 1; i <= Movimiento.get(Direction.TOP); i++) {
                    newfila = fila - i;
                    if (newfila < 8 && newfila > -1)
                    {
                        if(tablero[newfila][columna] == null) {
                            lst_Retorno.add(newfila + " " + columna);
                        }
                    }
                }
            }

            if (Movimiento.containsKey(Direction.BOTTOM)) {
                //Sumar la fila porque el movimiento es hacia abajo
                for (int i = 1; i <= Movimiento.get(Direction.BOTTOM); i++) {
                    newfila = fila + i;
                    if (newfila < 8 && newfila > -1)
                    {
                        if(tablero[newfila][columna] == null) {
                            lst_Retorno.add(newfila + " " + columna);
                        }
                    }
                }
            }

            //ATAQUE DE PEON
            //NEGRO
            if (_pieza.getColor().equals(Tipo_Color.NEGRO)) {
                //Abajo derecha
                for (int i = 1; i <= Movimiento.get(Direction.BOTTOM); i++) {
                    newfila = fila + i;
                    newcolumna = columna + i;
                    if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1) {
                        if (tablero[newfila][newcolumna] != null && tablero[newfila][newcolumna].getColor().equals(Tipo_Color.BLANCO)) {
                            lst_Retorno.add(newfila + " " + newcolumna);
                        }
                    }
                }

                //Abajo izquierda
                for (int i = 1; i <= Movimiento.get(Direction.BOTTOM); i++) {
                    newfila = fila + i;
                    newcolumna = columna - i;
                    if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1) {
                        if (tablero[newfila][newcolumna] != null && tablero[newfila][newcolumna].getColor().equals(Tipo_Color.BLANCO)) {
                            lst_Retorno.add(newfila + " " + newcolumna);
                        }
                    }
                }
            }

            //BLANCO
            if (_pieza.getColor().equals(Tipo_Color.BLANCO)) {
                //Arriba derecha
                for (int i = 1; i <= Movimiento.get(Direction.TOP); i++) {
                    newfila = fila - i;
                    newcolumna = columna + i;
                    if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1) {
                        if (tablero[newfila][newcolumna] != null &&  tablero[newfila][newcolumna].getColor().equals(Tipo_Color.NEGRO)) {
                            lst_Retorno.add(newfila + " " + newcolumna);
                        }
                    }
                }

                //Arriba izquierda
                for (int i = 1; i <= Movimiento.get(Direction.TOP); i++) {
                    newfila = fila - i;
                    newcolumna = columna - i;
                    if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1) {
                        if (tablero[newfila][newcolumna] != null && tablero[newfila][newcolumna].getColor().equals(Tipo_Color.NEGRO)) {
                            lst_Retorno.add(newfila + " " + newcolumna);
                        }
                    }
                }
            }
        }
        /******LAS DEMAS PIEZAS*******/
        else
        {
            if (Movimiento.containsKey(Direction.TOP)) {
                //Restar la fila porque el movimiento es hacia arriba
                for (int i = 1; i <= Movimiento.get(Direction.TOP); i++) {
                    newfila = fila - i;
                    if (newfila < 8 && newfila > -1)
                    {
                        if(tablero[newfila][columna] == null) {
                            lst_Retorno.add(newfila + " " + columna);

                        }
                        else if(!tablero[newfila][columna].getColor().equals(_pieza.getColor())){
                            lst_Retorno.add(newfila + " " + columna);
                            break;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            if (Movimiento.containsKey(Direction.BOTTOM)) {
                //Sumar la fila porque el movimiento es hacia abajo
                for (int i = 1; i <= Movimiento.get(Direction.BOTTOM); i++) {
                    newfila = fila + i;
                    if (newfila < 8 && newfila > -1)
                    {
                        if(tablero[newfila][columna] == null) {
                            lst_Retorno.add(newfila + " " + columna);
                        } else if (!tablero[newfila][columna].getColor().equals(_pieza.getColor())) {
                            lst_Retorno.add(newfila + " " + columna);
                            break;
                        } else{
                            break;
                        }
                    }
                }
            }
            if (Movimiento.containsKey(Direction.LEFT)) {
                //Restar la columna porque el movimiento es hacia la izquierda
                for (int i = 1; i <= Movimiento.get(Direction.LEFT); i++) {
                    newcolumna = columna - i;
                    if (newcolumna < 8 && newcolumna > -1)
                    {
                        if(tablero[fila][newcolumna] == null) {
                            lst_Retorno.add(fila + " " + newcolumna);
                        } else if (!tablero[fila][newcolumna].getColor().equals(_pieza.getColor())) {
                            lst_Retorno.add(fila + " " + newcolumna);
                            break;
                        } else{
                            break;
                        }
                    }
                }
            }
            if (Movimiento.containsKey(Direction.RIGHT)) {
                //Sumar la columna porque el movimiento es hacia la derecha
                for (int i = 1; i <= Movimiento.get(Direction.RIGHT); i++) {
                    newcolumna = columna + i;
                    if (newcolumna < 8 && newcolumna > -1)
                    {
                        if(tablero[fila][newcolumna] == null) {
                            lst_Retorno.add(fila + " " + newcolumna);
                        }
                        else if(!tablero[fila][newcolumna].getColor().equals(_pieza.getColor())){
                            lst_Retorno.add(fila + " " + newcolumna);
                            break;
                        }
                        else{
                            break;
                        }
                    }

                }
            }
            /** DIAGONALES **/
            if (Movimiento.containsKey(Direction.TOPLEFT)) {
                //RESTAR FILA movimiento arriba
                //RESTAR COLUMNA movimiento hacia izquierda
                for (int i = 1; i <= Movimiento.get(Direction.TOPLEFT); i++) {
                    newfila = fila - i;
                    newcolumna = columna - i;
                    if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1)
                    {
                        if(tablero[newfila][newcolumna] == null) {
                            lst_Retorno.add(newfila + " " + newcolumna);
                        }
                        else if(!tablero[newfila][newcolumna].getColor().equals(_pieza.getColor())){
                            lst_Retorno.add(newfila + " " + newcolumna);
                            break;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            if (Movimiento.containsKey(Direction.TOPRIGHT)) {
                //RESTAR FILA movimiento arriba
                //SUMAR COLUMNA movimiento hacia derecha
                for (int i = 1; i <= Movimiento.get(Direction.TOPLEFT); i++) {
                    newfila = fila - i;
                    newcolumna = columna + i;
                    if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1)
                    {
                        if(tablero[newfila][newcolumna] == null) {
                            lst_Retorno.add(newfila + " " + newcolumna);
                        } else if (!tablero[newfila][newcolumna].getColor().equals(_pieza.getColor())) {
                            lst_Retorno.add(newfila + " " + newcolumna);
                            break;
                        } else{
                            break;
                        }
                    }
                }
            }
            if (Movimiento.containsKey(Direction.BOTTOMLEFT)) {
                //SUMAR FILA movimiento abajo
                //RESTAR COLUMNA movimiento hacia izquierda
                for (int i = 1; i <= Movimiento.get(Direction.BOTTOMLEFT); i++) {
                    newfila = fila + i;
                    newcolumna = columna - i;
                    if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1)
                    {
                        if(tablero[newfila][newcolumna] == null) {
                            lst_Retorno.add(newfila + " " + newcolumna);
                        } else if (!tablero[newfila][newcolumna].getColor().equals(_pieza.getColor())) {
                            lst_Retorno.add(newfila + " " + newcolumna);
                            break;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            if (Movimiento.containsKey(Direction.BOTTOMRIGHT)) {
                //SUMAR FILA movimiento abajo
                //SUMAR COLUMNA movimiento hacia derecha
                for (int i = 1; i <= Movimiento.get(Direction.BOTTOMRIGHT); i++) {
                    newfila = fila + i;
                    newcolumna = columna + i;
                    if (newfila < 8 && newfila > -1 && newcolumna < 8 && newcolumna > -1)
                    {
                        if(tablero[newfila][newcolumna] == null) {
                            lst_Retorno.add(newfila + " " + newcolumna);
                        } else if (!tablero[newfila][newcolumna].getColor().equals(_pieza.getColor())) {
                            lst_Retorno.add(newfila + " " + newcolumna);
                            break;
                        } else{
                            break;
                        }
                    }
                }
            }
        }

        return lst_Retorno;
    }
    // endregion

    // region clonación de tablero
    private Pieza[][] ClonarTableroActual(){

        Pieza[][] tableroTemporal = Arrays.copyOf(AjedrezTablero, AjedrezTablero.length);

        for (int i = 0; i < AjedrezTablero.length; i++) {
            tableroTemporal[i] = Arrays.copyOf(AjedrezTablero[i], AjedrezTablero[i].length);
        }

        return tableroTemporal;
    }
    // endregion

    //Solo para usos de prueba en consola, borrar mas tarde
    private void MostrarMovimientos(ArrayList<String> lst_Retorno){
        for (int i = 0; i < lst_Retorno.size(); i++) {
            System.out.println("Movimiento: "+ i +":" +lst_Retorno.get(i) + "\n");
        }
    }

    // region Validación de Matriz
    private boolean DondeMoverValido(String fila, String columna) {
        try {
            Integer filaNum = Integer.parseInt(fila);
            Integer columnaNum = Integer.parseInt(columna);
            if (filaNum < 8 && filaNum > -1 && columnaNum < 8 && columnaNum > -1) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {

            return false;
        }

    }
    // endregion

    // region Comprobación de condiciones de victoria

    public boolean verificarVictoria() throws CloneNotSupportedException {
        // Verificar jaque mate
        if (esJaqueMate()) {
            return true;
        }

        /*
        // Verificar empate por ahogado
        if (esAhogado()) {
            return true;
        }

        // Verificar empate por insuficiencia de material
        if (esInsuficienciaMaterial()) {
            return true;
        }

        // Verificar empate por repetición de movimientos
        if (esRepeticionMovimientos()) {
            return true;
        }

        // Verificar empate por regla de los 50 movimientos
        if (esRegla50Movimientos()) {
            return true;
        }

        // No se cumplen las condiciones de victoria

         */
        return false;
    }

    // region Jaque

    private boolean EstadoDeJaque(Pieza[][] tablero , Pieza rey) {
        boolean retorno = false;

        if(estaEnJaque(rey, tablero)){
            System.out.println("El rey "+rey.getColor()+", esta en jaque");
            _EstadoDePartida = EstadosPartida.JAQUE;
            retorno = true;
        }else{
            _EstadoDePartida = EstadosPartida.ENCURSO;
        }
        return retorno;
    }

    private boolean estaEnJaque(Pieza _pieza, Pieza[][] tablero) {
        boolean retorno = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pieza pieza = tablero[i][j];
                if (pieza != null && pieza.getColor() != _pieza.getColor()) {
                    ArrayList<String> posiblesMovs = CalcularPosiblesMovs(pieza, i, j, tablero);
                    for (String mov : posiblesMovs) {
                        int movFila = Integer.parseInt(mov.split(" ")[0]);
                        int movColumna = Integer.parseInt(mov.split(" ")[1]);
                        if (movFila == _pieza.getFila() && movColumna == _pieza.getColumna()) {
                            retorno = true;
                        }
                    }
                }
            }
        }
        return retorno;
    }

    // region Autojaque y Sigue en Jaque

    private boolean CheckAutoJaque(Pieza _pieza, int filaMovimiento, int columnaMovimiento) throws CloneNotSupportedException {
        Pieza[][] tableroTemporal = ClonarTableroActual();

        tableroTemporal[filaMovimiento][columnaMovimiento] = _pieza;
        tableroTemporal[_pieza.getFila()][_pieza.getColumna()] = null;

        Pieza rey = EncontraReyActual(tableroTemporal);

        if(estaEnJaque(rey, tableroTemporal)){
            return true;
        }

        return false;
    }

    private boolean CheckSigueEnJaque(Pieza pieza, Integer movimientoFila, Integer movimientoColumna) throws CloneNotSupportedException {
        boolean retorno;

        Pieza[][] tableroTemporal = ClonarTableroActual();

        tableroTemporal[pieza.getFila()][pieza.getColumna()] = null;
        tableroTemporal[movimientoFila][movimientoColumna] = pieza;

        retorno = EstadoDeJaque(tableroTemporal, EncontraReyActual(tableroTemporal));

        return retorno;
    }

    // endregion

    // region Encontrar Rey actual o contrario

    private Pieza EncontraReyActual(Pieza[][] tablero) throws CloneNotSupportedException {
        Pieza _rey = null;
        Pieza ReyTemporal = null;
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                _rey = tablero[fila][columna];
                if (_rey != null && _rey instanceof Rey && _rey.getColor() == Main.ctrl_turno.getTurnoActual()) {

                    ReyTemporal = _rey.clone();

                    ReyTemporal.setFila(fila);
                    ReyTemporal.setColumna(columna);

                    break;
                }
            }
            if (ReyTemporal != null) {
                break;
            }
        }

        return ReyTemporal;
    }

    private Pieza EncontraReyContrario(Pieza[][] tablero){
        int reyFila = -1;
        int reyColumna = -1;
        Pieza _rey = null;
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                _rey = tablero[fila][columna];
                if (_rey != null && _rey instanceof Rey && _rey.getColor() != Main.ctrl_turno.getTurnoActual()) {
                    reyFila = fila;
                    reyColumna = columna;
                    break;
                }
            }
            if (reyFila != -1) {
                break;
            }
        }

        return _rey;
    }

    // endregion

    // endregion

    // region JaqueMate
    public boolean esJaqueMate() throws CloneNotSupportedException {

        // Encontrar el rey del jugador contrario al turno actual
        Pieza _rey = EncontraReyContrario(AjedrezTablero);
        if (_rey == null) {
            return false;
        }

        // Verificar si el rey esta en jaque
        if (!estaEnJaque(_rey, AjedrezTablero)) {
            return false;
        }

        // Verificar si el rey puede moverse a alguna casilla válida
        if (puedeMoverseJaque(CalcularPosiblesMovs(_rey, _rey.getFila(), _rey.getColumna(), AjedrezTablero), _rey)) {
            return false;
        }

        // Verificar si alguna pieza puede bloquear o capturar la pieza amenazante
        for (int fila = 0; fila < 8; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                Pieza pieza = AjedrezTablero[fila][columna];
                if (pieza != null && pieza.getColor() == Main.ctrl_turno.getTurnoActual()) {
                    if (puedeAtacar(CalcularPosiblesMovs(pieza, pieza.getFila(), pieza.getColumna(), AjedrezTablero), pieza)) {
                        return false;
                    }
                }
            }
        }

        // Si no se encontraron movimientos válidos, es jaque mate
        return true;
    }

    //Movimiento temporal, para verificación de jaquemate
    public boolean puedeMoverseJaque(ArrayList<String> lst_movs, Pieza pieza) throws CloneNotSupportedException {
        boolean flag_break = false;

        // Realizar el movimiento en una copia temporal del tablero
        Pieza[][] tableroTemporal = ClonarTableroActual();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(MovimientoValido(i, j, lst_movs)) {
                    tableroTemporal[i][j] = pieza;
                    tableroTemporal[pieza.getFila()][pieza.getColumna()] = null;

                    flag_break = true;
                    break;
                }
            }
            if(flag_break){
                break;
            }
        }

        //Encontrar rey actual en la matriz temporal.
        Pieza _rey = EncontraReyActual(tableroTemporal);

        // Verificar si el rey queda en jaque después del movimiento
        if (estaEnJaque(_rey, tableroTemporal)) {
            return false;
        }

        return true;
    }

    public boolean puedeAtacar(ArrayList<String> lst_movs, Pieza pieza) throws CloneNotSupportedException {
        if (pieza != null) {
            return puedeMoverseJaque(lst_movs, pieza);
        }
        return false;
    }
    // endregion

    // region Ahogado
    /*
    public boolean esAhogado() {
        // Obtener el rey del jugador actual
        Pieza _rey = EncontraReyActual();

        // Comprobar si el rey no puede moverse
        if (!puedeMoverseJaque(CalcularPosiblesMovs(_rey, _rey.getFila(), _rey.getColumna()), _rey)) {
            // Comprobar si no hay movimientos legales disponibles para las demás piezas del jugador
            // Todavía hay al menos una pieza que puede moverse, no es ahogado
            for (int i = 0; i < ; i++) {
                
            }

            return true; // No hay movimientos legales disponibles para ninguna pieza, es ahogado
        }

        return false; // El rey puede moverse, no es ahogado
    }

     */
    // endregion

    // endregion

}
