package model;

public class Configuracion {
    private int k; //not sure
    private double nota;
    private int[] regions;

    public Configuracion(int k, double nota, int[] regions) {
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

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int[] getRegions() {
        return regions;
    }

    public void setRegions(int[] regions) {
        this.regions = regions;
    }
}
