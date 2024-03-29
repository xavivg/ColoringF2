package model;

import Controller.AuxiliarFunctions;
import Controller.BandBController;
import view.BoardGUI;

import java.util.Scanner;

import static Controller.FileController.loadFile;

public class Main {

    public static Conf configuration;
    public static BoardGUI vista;
    public static int numColors = 6;
    public static void main(String[] args) {
        // Crear la GUI en función de la dimensión y las regiones

        String file;
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        while (configuration == null) {
            System.out.println("Introduce el nombre del fichero con el tablero a resolver: ");
            file = reader.next();
            configuration = loadFile(file);
        }


        vista = new BoardGUI(configuration.getBoardDimension(), configuration.getNumRegions());
        vista.setVisible(true);
        // Mostrar la vista

       Configuracion a = BandBController.branchAndBound();

       AuxiliarFunctions.paint(a.getRegions());
    }
}
