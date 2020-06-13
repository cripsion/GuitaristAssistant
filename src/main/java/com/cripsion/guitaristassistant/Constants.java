package com.cripsion.guitaristassistant;

import com.cripsion.guitaristassistant.entities.Pitch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Constants {
    public static String MAJOR = "MAJOR";
    public static String MINOR = "MINOR";
    public static String DIMINISH = "DIMINISH";

    private static String MAJOR_SUFFIX = "";
    private static String MINOR_SUFFIX = "m";
    private static String DIMINISH_SUFFIX = "-";

    public static Pitch tone_A = new Pitch(0, "A");
    public static Pitch tone_sA = new Pitch(1, "#A");
    public static Pitch tone_B = new Pitch(2, "B");
    public static Pitch tone_C = new Pitch(3, "C");
    public static Pitch tone_sC = new Pitch(4, "#C");
    public static Pitch tone_D = new Pitch(5, "D");
    public static Pitch tone_sD = new Pitch(6, "#D");
    public static Pitch tone_E = new Pitch(7, "E");
    public static Pitch tone_F = new Pitch(8, "F");
    public static Pitch tone_sF = new Pitch(9, "#F");
    public static Pitch tone_G = new Pitch(10, "G");
    public static Pitch tone_sG = new Pitch(11, "#G");



    public static List<Pitch> KEY_C_CHORD_SEQUENCE = new ArrayList<>() {
        {
            add(tone_A);
            add(tone_sA);
            add(tone_B);
            add(tone_C);
            add(tone_sC);
            add(tone_D);
            add(tone_sD);
            add(tone_E);
            add(tone_F);
            add(tone_sF);
            add(tone_G);
            add(tone_sG);
        }
    };
    
    public static Map<Integer, String> FLAT_OR_SHARP_MAP = Map.of(0, "", 1, "#", 2, "b");
    public static Map<Integer, String> CHORD_TYPE_MAP_FULL = Map.of(1, MAJOR, 2, MINOR, 3, MINOR, 4, MAJOR, 5, MAJOR, 6, MINOR, 7, DIMINISH);
    public static Map<Integer, String> CHORD_TYPE_MAP = Map.of(1, MAJOR_SUFFIX, 2, MINOR_SUFFIX, 3, MINOR_SUFFIX, 4, MAJOR_SUFFIX, 5, MAJOR_SUFFIX, 6, MINOR_SUFFIX, 7, DIMINISH_SUFFIX);


}
