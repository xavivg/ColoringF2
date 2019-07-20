package model;

public class Configuracion {
    private int k; //not sure
    private int nota;
    private int[] regions;

    public Configuracion(int k, int nota, int[] regions) {
        this.k = k;
        this.nota = nota;
        this.regions = regions;
    }

    public Configuracion() {
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int[] getRegions() {
        return regions;
    }

    public void setRegions(int[] regions) {
        this.regions = regions;
    }
}
