package model;

public class Conf {

    private int boardDimension;
    private int numRegions;
    private int[][] regions;
    private boolean[][] adjacencies;

    public Conf() {
    }

    public int getBoardDimension() {
        return boardDimension;
    }

    public void setBoardDimension(int boardDimension) {
        this.boardDimension = boardDimension;
    }

    public int getNumRegions() {
        return numRegions;
    }

    public void setNumRegions(int numRegions) {
        this.numRegions = numRegions;
    }

    public int[][] getRegions() {
        return regions;
    }

    public void setRegions(int[][] regions) {
        this.regions = regions;
    }

    public boolean[][] getAdjacencies() {
        return adjacencies;
    }

    public void setAdjacencies(boolean[][] adjacencies) {
        this.adjacencies = adjacencies;
    }

}
