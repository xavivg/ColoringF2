package view;

import javax.swing.*;
import java.awt.*;


/**
 * Clase que implementa una ventana que permite pintar las celdas de un tablero de una determinada dimensión.
 * Fase 1 de la Práctica de Algorítmica avanzada.
 *
 * @author Xavi Solé (xavier.sole@salle.url.edu) - La Salle, Universitat Ramon Llull
 * @version 10/04/2019
 */
public class BoardGUI extends JFrame {
    /** Título de la ventana */
    private static final String TITLE = "ALA - Coloring (Fase 1)";
    /** Esquema de color que se utiliza para el coloreado de las celdas */
    private static final int COLOR_SCHEME = ColorSchemes.COLOR_SCHEME_4;
    /** Color con el que se inicializan y se dejan en vacio las celdas */
    private static final Color EMPTY_CELL = Color.WHITE;
    /** Parilla de las celdas que se pueden pintar */
    private JPanel[][] jpCells;


    /**
     * Crea una ventana con una tablero de la dimensión indicada. La dimensión y el número de regiones también se
     * muestran en la parte superior del la ventana.
     *
     * @param dimension Dimensión del tablero.
     * @param regions Número de regiones.
     */
    public BoardGUI(int dimension, int regions) {
        // Creación del panel superior con los indicadores de dimensión y número de regiones
        JPanel jpIndicators = new JPanel();
        jpIndicators.setBorder(BorderFactory.createTitledBorder("Board characteristics"));
        jpIndicators.setLayout(new GridLayout(1,2));
        JLabel jlRegions = new JLabel("Regions: " + String.valueOf(regions));
        jlRegions.setFont(jlRegions.getFont().deriveFont(18f));
        jlRegions.setHorizontalAlignment(JLabel.CENTER);
        JLabel jlDimension = new JLabel("Dimension: " + String.valueOf(dimension));
        jlDimension.setFont(jlDimension.getFont().deriveFont(18f));
        jlDimension.setHorizontalAlignment(JLabel.CENTER);
        jpIndicators.add(jlRegions);
        jpIndicators.add(jlDimension);
        // Adición del panel de los marcadores de dimensión y regiones a la ventana
        getContentPane().add(jpIndicators, BorderLayout.NORTH);

        // Creación del panel que representa el tablero, parrilla de celdas
        JPanel jpGrid = new JPanel();
        jpGrid.setLayout(new GridLayout(dimension+1,dimension+1));
        jpGrid.setBorder(BorderFactory.createTitledBorder("Board"));
        jpCells = new JPanel[dimension+1][dimension+1];
        for (int j = 0; j < dimension+1; j++) {
            jpCells[0][j] = new JPanel();
            if (j!=0) {
                JLabel jlNumber = new JLabel(String.valueOf(j-1));
                jlNumber.setFont(jlNumber.getFont().deriveFont(18f));
                jpCells[0][j].add(jlNumber);
            }
            jpGrid.add(jpCells[0][j]);
        }
        for (int i=1; i<dimension+1; i++) {
            for (int j=0; j<dimension+1; j++) {
                jpCells[i][j] = new JPanel();
                if (j == 0) {
                    JLabel jlNumber = new JLabel(String.valueOf(i-1));
                    jlNumber.setFont(jlNumber.getFont().deriveFont(18f));
                    jpCells[i][j].add(jlNumber);
                } else {
                    jpCells[i][j].setBorder(BorderFactory.createLineBorder(EMPTY_CELL));
                    jpCells[i][j].setBackground(Color.white);
                }
                jpGrid.add(jpCells[i][j]);
            }
        }

        // Adición del panel de que representa el tablero a la ventana principal
        getContentPane().add(jpGrid, BorderLayout.CENTER);

        setTitle(TITLE);
        pack();
        setSize(this.getHeight(), this.getHeight());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

    /**
     * Permite pintar la celda del color indicado.
     *
     * @param row Fila de la celda.
     * @param column Columna de la celda.
     * @param idColor Identificador del color con el cual pintar la celda. Ver clase ColorSchemes.
     */
     public void setCellColor(int row, int column, int idColor) {
        jpCells[row+1][column+1].setBackground(ColorSchemes.getColor(COLOR_SCHEME, idColor));
     }

    /**
     * Elimina el color de la celda indicada.
     *
     * @param row Fila de la celda.
     * @param column Columna de la celda.
     */
    public void eraseCellColor(int row, int column) {
        jpCells[row+1][column+1].setBackground(EMPTY_CELL);
    }

}