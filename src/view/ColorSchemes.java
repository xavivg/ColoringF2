package view;

import java.awt.*;

/**
 * Clase que define un conjunto de esquemas de colores. Estos son utilizados por la clase "BoardGUI".
 *
 * @author Xavi Solé (xavier.sole@salle.url.edu) - La Salle, Universitat Ramon Llull
 * @version 10/04/2019
 */
public class ColorSchemes {

    /** Identificadores de los esquemas de colores */
    public static  final int COLOR_SCHEME_1 = 1;
    public static  final int COLOR_SCHEME_2 = 2;
    public static  final int COLOR_SCHEME_3 = 3;
    // Para la Fase 2 (MinDark)
    public static  final int COLOR_SCHEME_4 = 4;


    /** Definición de los esquemas de colores. Todos ellos tienen 6 colores. */
    /** Esquema de colores 1*/
    private static final Color[] COLOR_GROUP_1 = {
                                            new Color(207,216,220),
                                            new Color(144,164,174),
                                            new Color(96,125,139),
                                            new Color(69, 90,100),
                                            new Color(38, 50,56),
                                            new Color(3, 166,174)
    };
    /** Esquema de colores 2*/
    private static final Color[] COLOR_GROUP_2 = {
                                            new Color(242,184,48),
                                            new Color(223,128,39),
                                            new Color(0,120,158),
                                            new Color(3, 166,174),
                                            new Color(102, 218,228),
                                            new Color(65, 0,147)
    };
    /** Esquema de colores 3*/
    private static final Color[] COLOR_GROUP_3 = {
                                            new Color(66,133,244),
                                            new Color(52,168,83),
                                            new Color(251,188,5),
                                            new Color(234, 67,53),
                                            new Color(65, 0,147),
                                            new Color(207,216,220)
    };
    /** Esquema de colores 4*/
    // Para la Fase 2 (MinDark)
    private static final Color[] COLOR_GROUP_4 = {
                                            new Color(255,255,255),
                                            new Color(230,230,230),
                                            new Color(150,150,150),
                                            new Color(100, 100,100),
                                            new Color(70, 70,70),
                                            new Color(0, 0,0)
    };

    /**
     * Permite otenener el color "i-esimo" del esquema de color inidicado.
     *
     * @param id Identificador (1..6) del color que se quiere obtener.
     */
    public static Color getColor(int schema, int id) {
        switch(schema) {
            case COLOR_SCHEME_1: return COLOR_GROUP_1[id-1];
            case COLOR_SCHEME_2: return COLOR_GROUP_2[id-1];
            case COLOR_SCHEME_3: return COLOR_GROUP_3[id-1];
            case COLOR_SCHEME_4: return COLOR_GROUP_4[id-1];

            default: return COLOR_GROUP_1[id-1];
        }
    }

}
