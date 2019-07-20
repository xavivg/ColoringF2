package Controller;

import model.Conf;
import model.Configuracion;
import model.Main;
import model.Marcaje;

import javax.swing.*;


public class AuxiliarFunctions {

    public static final int MAX_COLORS = 6;

    public static int[] preparaRecorridoNivel(int[] x, int k){
         x[k] = 0;
         return x;
    }
    public static boolean hayaSucesor(int[] x, int k){
        return x[k] < MAX_COLORS;
    }
    public static int[] siguienteHermano(int[] x, int k){
        x[k] = x[k]+1;
        return x;
    }
    public static boolean solucion(int k){
        return k == Main.configuration.getNumRegions()-1;
    }

    public static boolean buena(int[] x, int k) {
        int i = 0, used = 0;
        int[] aux = new int[MAX_COLORS];

        while (i < k) {
            if (Main.configuration.getAdjacencies()[k][i]) {
                if (x[i] == x[k]) return false;
            }
            i++;
        }

        i=0;
        while (i <= k) {
            aux[x[i]-1] ++;
            if (aux[x[i]-1] == 1) used ++;
            if (used > Main.numColors) return false;
            i++;
        }

        return true;
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

    public static void tratarSolucion(int[] x) {
        int[] aux = new int [MAX_COLORS];
        int used = 0;

        for (int i = 0; i < Main.configuration.getNumRegions(); i++) {
            aux[x[i]-1] ++;
            if (aux[x[i]-1] == 1) used ++;
        }

        if (used < Main.vMejor) {
            Main.vMejor = used;
            for (int i=0; i < x.length; i++) {
                Main.xMejor[i] = x[i];
            }
            Main.numSolutions++;
        }
    }

    public static Marcaje marcar(int[] x, int k, Marcaje m) {
        int[] colorsStatus = m.getColorsStatus();
        colorsStatus[x[k]-1]++;
        m.setColorsStatus(colorsStatus);

        int usedColors = m.getUsedColors();
        if (m.getColorsStatus()[x[k]-1] == 1)
            m.setUsedColors(usedColors+1);

        return m;
    }

    public static Marcaje desmarcar(int[] x, int k, Marcaje m) {
        int[] colorsStatus = m.getColorsStatus();
        colorsStatus[x[k]-1]--;
        m.setColorsStatus(colorsStatus);

        int usedColors = m.getUsedColors();
        if (m.getColorsStatus()[x[k]-1] == 0)
            m.setUsedColors(usedColors-1);

        return m;
    }

    public static boolean buenaMejoras(int[] x, int k, Marcaje m) {
        int i=0;

        while (i < k) {
            if (Main.configuration.getAdjacencies()[i][k]) {
                if (x[i] == x[k])
                    return false;
            }
            i++;
        }

        return m.getUsedColors() <= Main.numColors;
    }

    public static void tratarSolucionMejoras(int[] x, Marcaje m) {
        if (m.getUsedColors() < Main.vMejor) {
            Main.vMejor = m.getUsedColors();
            for (int i=0; i < x.length; i++) {
                Main.xMejor[i] = x[i];
            }
            Main.numSolutions++;
        }
    }
    public static Configuracion configuracionRaiz(Configuracion x){
        x.setK(-1);
        int regions[] = new int[Main.configuration.getNumRegions()];
        x.setRegions(regions);
        return x;
    }
    public static Configuracion[] expande(Configuracion x){
        Configuracion[] hijos = new Configuracion[MAX_COLORS];
        int[] aux = new int[Main.configuration.getNumRegions()];
        aux = x.getRegions();//si falla, fer bucle
        for (int i = 0; i < hijos.length; i++) {
            aux[x.getK()] = i;
            hijos[i].setRegions(aux);
        }
        return hijos;
    }
}
