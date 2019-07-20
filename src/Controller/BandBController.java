package Controller;

import model.Conf;
import model.Configuracion;

import java.util.Comparator;
import java.util.PriorityQueue;
import static Controller.AuxiliarFunctions.*;
import static model.Main.xMejor;

public class BandBController {

    public static Configuracion branchAndBound() throws InterruptedException {
        PriorityQueue<Configuracion> nodosVivos = new PriorityQueue(new Comparator<Configuracion>() {
            @Override
            public int compare(Configuracion o1, Configuracion o2) {
                return o1.getNota() - o2.getNota();
            }
        });
        Configuracion x = new Configuracion();
        x = configuracionRaiz(x);
        nodosVivos.add(x);
        Configuracion[] hijos = new Configuracion[MAX_COLORS];
        while (nodosVivos.isEmpty()){
           x = nodosVivos.poll();
            hijos = expande(x);
            for (int i = 0; i < hijos.length; i++) {

            }
        }
        nodosVivos.remove(x);

        return x;
    }
}
