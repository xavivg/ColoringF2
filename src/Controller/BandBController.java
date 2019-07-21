package Controller;

import model.Conf;
import model.Configuracion;
import model.Main;

import java.util.Comparator;
import java.util.PriorityQueue;
import static Controller.AuxiliarFunctions.*;


public class BandBController {

    public static Configuracion branchAndBound() {

            PriorityQueue<Configuracion> nodosVivos = new PriorityQueue(new Comparator<Configuracion>() {
                @Override
                public int compare(Configuracion o1, Configuracion o2) {
                    return o1.getNota() - o2.getNota();
                }
            });

            Configuracion x = new Configuracion(), xMejor = new Configuracion();
            xMejor.setRegions(new int[Main.configuration.getNumRegions()]);
            int vMejor = Integer.MAX_VALUE;
            x = configuracionRaiz(x);

            nodosVivos.add(x);

            Configuracion[] hijos = new Configuracion[MAX_COLORS];
            while (!nodosVivos.isEmpty()) {
                x = nodosVivos.poll();
                hijos = expande(x);
                for (int i = 0; i < hijos.length; i++) {
                    if (solucion(hijos[i])) {
                        if (buena(hijos[i])) {
                            if (valor(hijos[i]) < vMejor) {   //com mes petit millor
                                vMejor = valor(hijos[i]);
                                xMejor.setK(hijos[i].getK());
                                for (int j = 0; j < hijos[i].getRegions().length; j++) {
                                    xMejor.getRegions()[j] = hijos[i].getRegions()[j];
                                }
                            }
                        }
                    } else {
                        if (buena(hijos[i])) {
                            if (valork(hijos[i]) < vMejor) {
                                //PODA
                                nodosVivos.add(hijos[i]);
                            }
                        }
                    }
                }
            }
            nodosVivos.remove(x);

        return x;
    }
}
