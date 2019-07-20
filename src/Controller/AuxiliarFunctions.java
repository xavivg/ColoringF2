package Controller;

import model.Conf;
import model.Configuracion;
import model.Main;
//import model.Marcaje;

import javax.swing.*;


public class AuxiliarFunctions {

    public static final int MAX_COLORS = 6;

    public static boolean solucion(Configuracion x){
        return x.getK() == Main.configuration.getNumRegions()-1;
    }

    public static boolean buena(Configuracion x) {
        int i = 0, used = 0;
        int[] aux = new int[MAX_COLORS];

        while (i < x.getK()) {
            if (Main.configuration.getAdjacencies()[x.getK()][i]) {
                if (x.getRegions()[i] == x.getRegions()[x.getK()]) return false;
            }
            i++;
        }

        i=0;
        while (i <= x.getK()) {
            aux[x.getRegions()[i]-1] ++;
            if (aux[x.getRegions()[i]-1] == 1) used ++;
            if (used > Main.numColors) return false;
            i++;
        }

        return true;
    }

    public static int valor(Configuracion x){
        int[] aux = new int[MAX_COLORS];
        int used = 0;
        for (int i = 0; i < Main.configuration.getNumRegions(); i++) {
            aux[x.getRegions()[i]]++;
            if (aux[x.getRegions()[i]] == 1) used++;
        }
        return used;
    }

    public static void paint(int[] x) {
        for (int r = 0; r < Main.configuration.getNumRegions(); r++) {
            for (int i = 0; i < Main.configuration.getBoardDimension(); i++) {
                for (int j = 0; j < Main.configuration.getBoardDimension(); j++) {
                    if (Main.configuration.getRegions()[i][j] == r+1)
                        Main.vista.setCellColor(i, j, x[r]);
                }
            }
        }
        SwingUtilities.updateComponentTreeUI(Main.vista);
    }

//    public static Marcaje marcar(int[] x, int k, Marcaje m) {
//        int[] colorsStatus = m.getColorsStatus();
//        colorsStatus[x[k]-1]++;
//        m.setColorsStatus(colorsStatus);
//
//        int usedColors = m.getUsedColors();
//        if (m.getColorsStatus()[x[k]-1] == 1)
//            m.setUsedColors(usedColors+1);
//
//        return m;
//    }
//
//    public static Marcaje desmarcar(int[] x, int k, Marcaje m) {
//        int[] colorsStatus = m.getColorsStatus();
//        colorsStatus[x[k]-1]--;
//        m.setColorsStatus(colorsStatus);
//
//        int usedColors = m.getUsedColors();
//        if (m.getColorsStatus()[x[k]-1] == 0)
//            m.setUsedColors(usedColors-1);
//
//        return m;
//    }
//
//    public static boolean buenaMejoras(int[] x, int k, Marcaje m) {
//        int i=0;
//
//        while (i < k) {
//            if (Main.configuration.getAdjacencies()[i][k]) {
//                if (x[i] == x[k])
//                    return false;
//            }
//            i++;
//        }
//
//        return m.getUsedColors() <= Main.numColors;
//    }
//
//    public static void tratarSolucionMejoras(int[] x, Marcaje m) {
//        if (m.getUsedColors() < Main.vMejor) {
//            Main.vMejor = m.getUsedColors();
//            for (int i=0; i < x.length; i++) {
//                Main.xMejor[i] = x[i];
//            }
//            Main.numSolutions++;
//        }
//    }
    public static Configuracion configuracionRaiz(Configuracion x){
        x.setK(-1);
        int regions[] = new int[Main.configuration.getNumRegions()];
        x.setRegions(regions);
        return x;
    }
    public static Configuracion[] expande(Configuracion x){
        x.setK(x.getK()+1);
        Configuracion[] hijos = new Configuracion[MAX_COLORS];
        int[] aux = new int[Main.configuration.getNumRegions()];

        for (int i=0; i < aux.length; i++) {
            aux[i] = x.getRegions()[i];
        }

        for (int i = 0; i < hijos.length; i++) {
            aux[x.getK()] = i;
            hijos[i].setRegions(aux);
        }
        return hijos;
    }
}
