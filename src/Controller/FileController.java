package Controller;

import model.Conf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileController {


    public static Conf loadFile(String file) {
        Conf configuration = new Conf();
        try (FileReader reader = new FileReader("src/file/" +file);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            line = br.readLine();
            configuration.setBoardDimension(Integer.parseInt(line));
            line = br.readLine();
            int num_regiones = Integer.parseInt(line);
            configuration.setNumRegions(num_regiones);
            int[][] numbers = new int[configuration.getBoardDimension()][configuration.getBoardDimension()];
            String[] arr;
            line = br.readLine();
            for (int i = 0; i < configuration.getBoardDimension(); i++) {
                line = br.readLine();
                arr = line.split(" ");

                for(int j=0; j < arr.length; j++){
                    numbers[i][j] = Integer.parseInt(arr[j]);
                }
            }
            line = br.readLine();
            configuration.setRegions(numbers);
            boolean[][] matriz = new boolean[configuration.getBoardDimension()][configuration.getBoardDimension()];
            for (int i = 0; i < num_regiones; i++) {
                line = br.readLine();
                arr = line.split(" ");

                for(int j=0; j < num_regiones; j++){
                    matriz[i][j] = Integer.parseInt(arr[j]) == 1;
                }
            }
            configuration.setAdjacencies(matriz);
            return configuration;
        } catch (IOException e) {
            System.out.println("No se puede encontrar el archivo especificado");
        }
        return null;
    }
}
