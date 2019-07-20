package model;

import Controller.AuxiliarFunctions;
import view.BoardGUI;

import java.util.Scanner;

import static Controller.FileController.loadFile;

public class Main {

    public static Conf configuration;
    public static BoardGUI vista;
    public static int numColors = 0;
    public static int[] xMejor;
    public static int vMejor = AuxiliarFunctions.MAX_COLORS;
    public static int numSolutions = 0;
    public static void main(String[] args) {
        // Crear la GUI en función de la dimensión y las regiones

        String file;
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        while (configuration == null) {
            System.out.println("Introduce el nombre del fichero con el tablero a resolver: ");
            file = reader.next();
            configuration = loadFile(file);
        }

        int[] x = new int[configuration.getNumRegions()];



        BoardGUI vista = new BoardGUI(10, 6);
        // Mostrar la vista
        vista.setVisible(true);
        // Pintar celdas
        vista.setCellColor(0,0, 1);
        vista.setCellColor(1,1, 2);
        vista.setCellColor(2,2, 3);
        vista.setCellColor(3,3, 4);
        vista.setCellColor(4,4, 5);
        vista.setCellColor(5,5, 6);
        // ...




    }
}
